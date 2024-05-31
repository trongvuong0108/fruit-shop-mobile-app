package com.code.Helper;

import com.cloudinary.Cloudinary;
import com.cloudinary.utils.ObjectUtils;
import org.springframework.stereotype.Component;

@Component
public class CloudinaryHelper {
    private static Cloudinary cloudinary;

    public CloudinaryHelper() {
        cloudinary = new Cloudinary(ObjectUtils.asMap(
                "cloud_name", "dzjmvy2ty",
                "api_key", "682162512936223",
                "api_secret", "O9El85LO2lGt5Af1rlZxb8xxRwo"
        ));
    }

    public static Cloudinary getInstance(){
        return cloudinary;
    }

}
