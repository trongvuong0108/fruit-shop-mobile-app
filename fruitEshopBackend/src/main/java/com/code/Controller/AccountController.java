package com.code.Controller;

import com.code.Helper.CloudinaryHelper;
import com.code.Data.Account.IAccountService;
import com.code.Data.Account.Account;
import com.code.Data.Token.ITokenService;
import com.code.Data.Token.Token;
import com.code.Enum.Role;
import com.code.Enum.TokenType;
import com.code.Model.*;
import com.code.Services.MailService;
import com.google.gson.Gson;
import org.apache.tomcat.util.codec.binary.Base64;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.io.UnsupportedEncodingException;
import java.time.LocalDateTime;
import java.util.Properties;

@RestController
@RequestMapping(value = "/account")
public class AccountController {
    private final IAccountService accountService;

    private final ITokenService tokenService;


    private final MailService mailService;

    public AccountController(IAccountService accountService, ITokenService tokenService, MailService mailService) {
        this.accountService = accountService;
        this.tokenService = tokenService;
        this.mailService = mailService;
    }
    @GetMapping(value = "/getAccountSimple")
    public Account get(){
        return new Account();
    }


    @PostMapping(value = "/create")
    public HttpStatus save(

    ){
        CloudinaryHelper uploader = new CloudinaryHelper();
        Account account = new Account();
//        account.setUsername(username);
//        account.setPassword(password);
//        account.setFullName(fullName);
//        account.setEmail(email.trim());
//        account.setAddress(address);
//        account.setPhone(phone);
        account.setEnable(false);
        account.setUserRole(Role.CLIENT);
        accountService.save(account);
        Token signupToken = new Token();
        signupToken.genNewToken();
        signupToken.setAccount(account);
        signupToken.setTokenType(TokenType.SIGNUP);
        tokenService.save(signupToken);
        mailService.sendEmail(account.getEmail(),"Token",signupToken.getToken());
        return HttpStatus.OK;
    }

    @GetMapping(value = "/genNewSignupToken")
    public Token genNewSignupToken(@RequestParam("username") String username){
        Account account = accountService.getByUserName(username);
        Token signupToken = new Token();
        signupToken.genNewToken();
        signupToken.setAccount(account);
        signupToken.setTokenType(TokenType.SIGNUP);
        tokenService.save(signupToken);
        mailService.sendEmail(account.getEmail(),"Token",signupToken.getToken());
        return signupToken;
    }

    @GetMapping(value = "/confirmSignUpToken")
    public String confirmToken(
            @RequestParam("token") String token,
            @RequestParam("username") String username){
        Token signinToken = tokenService.findByToken(token);
        if(
                signinToken.getAccount().getUsername().equals(username)&&
                signinToken != null &&
                signinToken.getTokenType() == TokenType.SIGNUP &&
                signinToken.getExpiryAt().isAfter(LocalDateTime.now())
        ){
            Account account =signinToken.getAccount() ;
            account.setEnable(true);
            accountService.save(account);
            return "Successful";
        }
        return "Failure";
    }

    @GetMapping(value = "/genNewChangePassToken")
    public Token genNewChangePassToken(@RequestParam("username") String username){
        Token changePassToken = new Token();
        Account account = accountService.getByUserName(username);
        changePassToken.genNewToken();
        changePassToken.setAccount(account);
        changePassToken.setTokenType(TokenType.REPASSWORD);
        tokenService.save(changePassToken);
        mailService.sendEmail(account.getEmail(),"Token",changePassToken.getToken());
        return changePassToken;
    }

    @GetMapping(value = "/confirmChangePassToken")
    public boolean confirmChangePassToken(@RequestParam("token") String token,
                                        @RequestParam("username") String username){
        Token changePassToken = tokenService.findByToken(token);
        if(
                changePassToken.getAccount().getUsername().equals(username)&&
                        changePassToken != null &&
                        changePassToken.getTokenType() == TokenType.REPASSWORD &&
                        changePassToken.getExpiryAt().isAfter(LocalDateTime.now())
        ){
            return true;
        }
        return false;
    }

    @PostMapping(value = "/changePass")
    public void confirmChangePassToken(@RequestBody ChangePasswordRequest rePassword) throws Exception {
        Account account = accountService.getByUserName(rePassword.getUsername());
        if(account == null)
            throw new Exception("username not found");
        if(!rePassword.getPassword().equals(account.getPassword()))
            throw new Exception("password not match");
        account.setPassword(rePassword.getNewPassword());
        accountService.save(account);
    }

    @GetMapping(value = "/getUser")
    public Properties getUser(@RequestParam("jwt") String token) throws UnsupportedEncodingException {
        Properties prop = new Properties();
        String[] pieces = token.split("\\.");
        String b64payload = pieces[1];
        String jsonString = new String(Base64.decodeBase64(b64payload), "UTF-8");
        JwtDecodeModel jwtDecodeModel = new Gson().fromJson(jsonString, JwtDecodeModel.class);
        Account accountResult = accountService.getByUserName(jwtDecodeModel.sub);
        prop.put("username" , accountResult.getUsername());
        prop.put("fullname" , accountResult.getFullName());
        prop.put("phone" , accountResult.getPhone());
        prop.put("address" , accountResult.getAddress());
        prop.put("email" , accountResult.getEmail());
        return prop ;
    }
}
