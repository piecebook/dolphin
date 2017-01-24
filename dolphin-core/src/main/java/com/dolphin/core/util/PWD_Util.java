package com.dolphin.core.util;

import java.security.SecureRandom;

/**
 * 密码工具。
 * 生成随机盐，盐的长度可以定义，一般32位字符。
 * Created on 2017/1/13.
 *
 * @author PieceBook
 * @version 1.0
 */
public class PWD_Util {
    public static String getHash(String pwd) {
        return StringEncrypt.SHA256Code(pwd);
    }

    public static String getSalt(int length) {
        String base = "abcdefghijklmnopqrstuvwxyz0123456789-_";
        SecureRandom secureRandom = new SecureRandom();
        StringBuffer salt = new StringBuffer();
        for (int i = 0; i < length; i++) {
            int random = secureRandom.nextInt(base.length());
            salt.append(base.charAt(random));
        }
        return salt.toString();
    }
}
