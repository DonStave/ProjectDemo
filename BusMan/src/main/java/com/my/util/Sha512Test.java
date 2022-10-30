package com.my.util;


import org.apache.shiro.crypto.hash.Sha512Hash;


/**
 * Author: Don
 * 加密
 */
public class Sha512Test {
    public static void main(String[] args) {
        String salt = "efdd1d36-2430-4";
        System.out.println("随机盐：" + salt);
        String password = "123456";
        Sha512Hash sha512Hash = new Sha512Hash(password, salt, 1024);
        System.out.println("密码：" + sha512Hash.toString());

    }
}
