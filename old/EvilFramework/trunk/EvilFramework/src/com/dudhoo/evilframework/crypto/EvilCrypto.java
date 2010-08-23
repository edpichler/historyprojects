package com.dudhoo.evilframework.crypto;

import java.io.IOException;

import java.security.AlgorithmParameters;

import java.security.InvalidAlgorithmParameterException;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;

import javax.crypto.BadPaddingException;
import javax.crypto.Cipher;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.KeyGenerator;
import javax.crypto.NoSuchPaddingException;
import javax.crypto.SecretKey;
import javax.crypto.spec.SecretKeySpec;

public class EvilCrypto {
    private javax.crypto.spec.SecretKeySpec keySpec;
    private byte[] key;
    private String algorithm = "DES";

    /** Creates a new instance of Crypt */
    public EvilCrypto(byte[] key) {
        this.key = key;        
        this.keySpec = new SecretKeySpec(this.key, 
            this.algorithm);
    }

    public byte[] encrypt(byte[] value) throws NoSuchAlgorithmException, 
                                             NoSuchPaddingException, 
                                             IllegalBlockSizeException, 
                                             BadPaddingException, IOException, 
                                             InvalidKeyException {
        javax.crypto.Cipher cipher =
        javax.crypto.Cipher.getInstance(this.algorithm);
        cipher.init(javax.crypto.Cipher.ENCRYPT_MODE, this.keySpec);
        return cipher.doFinal(value);
    }
    
    public byte[] decrypt(byte[] value) throws NoSuchAlgorithmException, 
                                             NoSuchPaddingException, 
                                             IllegalBlockSizeException, 
                                             BadPaddingException, IOException, 
                                             InvalidKeyException, 
                                             InvalidAlgorithmParameterException {
        javax.crypto.Cipher cipher =
        javax.crypto.Cipher.getInstance(this.algorithm);
        cipher.init(javax.crypto.Cipher.DECRYPT_MODE, this.keySpec);
        return cipher.doFinal(value);
    }
}
