package com.example.demo.utils;

import java.security.KeyPair;
import java.security.interfaces.RSAPrivateKey;
import java.security.interfaces.RSAPublicKey;
import org.springframework.stereotype.Component;

import lombok.Getter;
import lombok.Setter;

@Component
@Setter
@Getter
public class RSAKeyProperties {
    private RSAPublicKey rsaPublicKey;
    private RSAPrivateKey rsaPrivateKey;
    public RSAKeyProperties()
    {
        KeyPair pair =KeyGeneratedUtility.generateRSAKey();
        this.rsaPublicKey=(RSAPublicKey)pair.getPublic();
        this.rsaPrivateKey=(RSAPrivateKey)pair.getPrivate();

    }
}
