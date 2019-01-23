package com.cursosdedesarrollo.cifrado;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.security.SecureRandom;
import java.util.Base64;

import javax.crypto.Cipher;
import javax.crypto.KeyGenerator;
import javax.crypto.SecretKey;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.SecretKeySpec;
import static org.apache.commons.codec.binary.Hex.*;
import static org.apache.commons.io.FileUtils.*;
import org.apache.commons.codec.DecoderException;

public class Ejemplo10Cifrado {

    static String plainText = "This is a plain text which need to be encrypted by AES Algorithm with CBC Mode";

    public static void main(String[] args) throws Exception
    {
        KeyGenerator keyGenerator = KeyGenerator.getInstance("AES");
        keyGenerator.init(128);

        // Generate Key
        SecretKey key = keyGenerator.generateKey();


        // Generating IV.
        byte[] IV = new byte[16];
        SecureRandom random = new SecureRandom();
        random.nextBytes(IV);

        System.out.println("Original Text  : "+plainText);

        byte[] cipherText = encrypt(plainText.getBytes(),key, IV);
        System.out.println("Encrypted Text : "+Base64.getEncoder().encodeToString(cipherText) );

        File file =
                new File("./archivo.key");
        saveKey(key,file,IV);
        key=loadKey(file);

        String decryptedText = decrypt(cipherText,key, IV);
        System.out.println("DeCrypted Text : "+decryptedText);

    }

    public static byte[] encrypt (byte[] plaintext,SecretKey key,byte[] IV ) throws Exception
    {
        //Get Cipher Instance
        Cipher cipher = Cipher.getInstance("AES/CBC/PKCS5Padding");

        //Create SecretKeySpec
        SecretKeySpec keySpec = new SecretKeySpec(key.getEncoded(), "AES");

        //Create IvParameterSpec
        IvParameterSpec ivSpec = new IvParameterSpec(IV);

        //Initialize Cipher for ENCRYPT_MODE
        cipher.init(Cipher.ENCRYPT_MODE, keySpec, ivSpec);

        //Perform Encryption
        byte[] cipherText = cipher.doFinal(plaintext);

        return cipherText;
    }

    public static String decrypt (byte[] cipherText, SecretKey key,byte[] IV) throws Exception
    {
        //Get Cipher Instance
        Cipher cipher = Cipher.getInstance("AES/CBC/PKCS5Padding");

        //Create SecretKeySpec
        SecretKeySpec keySpec = new SecretKeySpec(key.getEncoded(), "AES");

        //Create IvParameterSpec
        IvParameterSpec ivSpec = new IvParameterSpec(IV);

        //Initialize Cipher for DECRYPT_MODE
        cipher.init(Cipher.DECRYPT_MODE, keySpec, ivSpec);

        //Perform Decryption
        byte[] decryptedText = cipher.doFinal(cipherText);

        return new String(decryptedText);
    }

    public static void saveKey(SecretKey key, File file,byte[] IV) throws IOException
    {
        try (FileOutputStream fos = new FileOutputStream("./IV.key")) {
            fos.write(IV);
            fos.close(); //There is no more need for this line since you had created the instance of "fos" inside the try. And this will automatically close the OutputStream
        }
        System.out.println("IV: "+String.valueOf(encodeHex(IV)));

        char[] hex = encodeHex(key.getEncoded());
        writeStringToFile(file, String.valueOf(hex));
        System.out.println("key: "+String.valueOf(hex));


    }

    public static SecretKey loadKey(File file) throws IOException
    {
        String data = new String(readFileToByteArray(file));
        byte[] encoded;
        try {
            encoded = decodeHex(data.toCharArray());
        } catch (DecoderException e) {
            e.printStackTrace();
            return null;
        }
        try (FileInputStream fos = new FileInputStream("./IV.key")) {
            fos.read();
            //fos.close(); There is no more need for this line since you had created the instance of "fos" inside the try. And this will automatically close the OutputStream
        }
        return new SecretKeySpec(encoded, "AES");
    }
}
