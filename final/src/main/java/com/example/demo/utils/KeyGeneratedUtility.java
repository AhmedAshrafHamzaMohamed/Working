package com.example.demo.utils;

import java.security.KeyPair;
import java.security.KeyPairGenerator;

public class KeyGeneratedUtility  {
    public static KeyPair generateRSAKey(){
        KeyPair keyPair;
        try {
            KeyPairGenerator keyPairGenerator=KeyPairGenerator.getInstance("RSA");
            keyPairGenerator.initialize(2048);
            keyPair=keyPairGenerator.genKeyPair();
        } catch (Exception e) {
            throw new IllegalStateException();
        }
        return keyPair;
        
    }
}
