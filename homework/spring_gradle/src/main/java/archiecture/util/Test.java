package com.easy.archiecture.util;



import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Base64;



public class Test {

    public static void main(String[] args) {
        System.out.println(login("admin123456"));
    }

    //pmq7VoTEWWLYh1ZPCDRujQ== 就是 admin123456

    private static String savePassWord = "pmq7VoTEWWLYh1ZPCDRujQ==";

    public static boolean login(String password) {
        if(savePassWord.equals(md5(password))) {
            return true;
        }else {
            return false;
        }
    }


    private static String md5(String password) {
        try {
            MessageDigest md = MessageDigest.getInstance("md5");

            byte[] bytes = md.digest(password.getBytes());

            String str = Base64.getEncoder().encodeToString(bytes);

            return str;
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        }
        return null;
    }
}