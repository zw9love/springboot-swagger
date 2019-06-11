package com.roncoo.swagger.util;
/**
 * Created by admin on 2018/2/11.
 */
import java.security.MessageDigest;

public class MD5Util {

    public static void main(String[] args) {
        // 6350238.ll     前台加密后是：69bdb4557a463410be2927ea92786357
        System.out.println(MD5Util.encrypt("69bdb4557a463410be2927ea92786357")); //E7L2CDGGLL5M25ACB7D216FLL2B76D25
    }


    // 生成MD5
    public static String encrypt(String message) {
        String md5 = "";
        try {
            MessageDigest md = MessageDigest.getInstance("MD5"); // 创建一个md5算法对象
            byte[] messageByte = message.getBytes("UTF-8");
            byte[] md5Byte = md.digest(messageByte); // 获得MD5字节数组,16*8=128位
            md5 = bytesToHex(md5Byte); // 转换为16进制字符串
        } catch (Exception e) {
            e.printStackTrace();
        }
        return decrypt(md5); // 默认admin.123加密密码 G2LB1ELM7D5FC71D1M6E2EBMACE0L2F5
    }

    // 加密后解密
    public static String decrypt(String inStr) {
        char[] a = inStr.toCharArray();
        for (int i = 0; i < a.length; i++) {
            a[i] = (char) (a[i] ^ 't');
        }
        String k = new String(a);
        return k;
    }

    // 二进制转十六进制
    public static String bytesToHex(byte[] bytes) {
        StringBuffer hexStr = new StringBuffer();
        int num;
        for (int i = 0; i < bytes.length; i++) {
            num = bytes[i];
            if (num < 0) {
                num += 256;
            }
            if (num < 16) {
                hexStr.append("0");
            }
            hexStr.append(Integer.toHexString(num));
        }
        return hexStr.toString().toUpperCase();
    }
}