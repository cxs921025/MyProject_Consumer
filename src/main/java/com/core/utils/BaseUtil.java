package com.core.utils;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.UUID;

/**
 * @author ChenXS
 * Basic tool class.
 */
@SuppressWarnings("all")
public class BaseUtil {

    /**
     * 不允许实例化
     */
    private BaseUtil() {
    }

    /**
     * 生成随机id
     *
     * @return 生成的随机ID
     */
    public static synchronized String getUUID() {
        UUID uuid = UUID.randomUUID();
        String str = uuid.toString();
        return str.replace("-", "");
    }

    public static synchronized String encryptionWithMd5(String str) {
        try {
            MessageDigest md5 = MessageDigest.getInstance("md5");
            //把密码转换为byte类型
            byte[] b = str.getBytes();
            //加密
            byte[] digest = md5.digest(b);
            //16进制的字符
            char[] c = {'0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'A', 'B', 'C', 'D', 'E', 'F'};
            //用于储存加密后的字符串
            StringBuilder sb = new StringBuilder();
            //处理为16进制的字符串
            for (byte bb : digest) {
                //15的8进制是0000,1111
                sb.append(c[(bb >> 4) & 15]);
                sb.append(c[bb & 15]);
            }
            return sb.toString();
        } catch (NoSuchAlgorithmException e) {
            LogUtil.error(e);
        }
        return null;
    }
}
