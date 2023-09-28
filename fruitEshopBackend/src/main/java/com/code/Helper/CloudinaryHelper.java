package com.code.Config;

import com.cloudinary.Cloudinary;
import com.cloudinary.utils.ObjectUtils;
import org.springframework.beans.factory.config.ConfigurableBeanFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Scope;
@Configuration
public class CloudinaryConfiguration {
    private static Cloudinary cloudinary;

    public CloudinaryConfiguration() {
        cloudinary = new Cloudinary(ObjectUtils.asMap(
                "cloud_name", "dzjmvy2ty",
                "api_key", "682162512936223",
                "api_secret", "O9El85LO2lGt5Af1rlZxb8xxRwo"
        ));
    }

    @Bean
    @Scope(value = ConfigurableBeanFactory.SCOPE_SINGLETON)
    public static Cloudinary getInstance(){
        return cloudinary;
    }

}
