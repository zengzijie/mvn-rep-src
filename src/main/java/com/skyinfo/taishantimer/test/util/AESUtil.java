package com.skyinfo.taishantimer.test.util;

import org.apache.commons.codec.binary.Base64;

import javax.crypto.Cipher;
import javax.crypto.KeyGenerator;
import javax.crypto.SecretKey;
import javax.crypto.spec.SecretKeySpec;
import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;
import java.util.logging.Level;
import java.util.logging.Logger;

public class AESUtil {
    private static final String KEY_ALGORITHM = "AES";
    private static final String DEFAULT_CIPHER_ALGORITHM = "AES/ECB/PKCS5Padding";//默认的加密算法

    /**
     * AES 加密操作
     *
     * @param content 待加密内容
     * @param key 加密密钥
     * @return 返回Base64转码后的加密数据
     */
    public static String encrypt(String content, String key) {
        try {
            Cipher cipher = Cipher.getInstance(DEFAULT_CIPHER_ALGORITHM);// 创建密码器

            byte[] byteContent = content.getBytes("utf-8");

            cipher.init(Cipher.ENCRYPT_MODE, getSecretKey(key));// 初始化为加密模式的密码器

            byte[] result = cipher.doFinal(byteContent);// 加密

            return Base64.encodeBase64String(result);//通过Base64转码返回
        } catch (Exception ex) {
            Logger.getLogger(AESUtil.class.getName()).log(Level.SEVERE, null, ex);
        }

        return null;
    }

    /**
     * AES 解密操作
     *
     * @param content
     * @param key
     * @return
     */
    public static String decrypt(String content, String key) {

        try {
            //实例化
            Cipher cipher = Cipher.getInstance(DEFAULT_CIPHER_ALGORITHM);

            //使用密钥初始化，设置为解密模式
            cipher.init(Cipher.DECRYPT_MODE, getSecretKey(key));

            //执行操作
            byte[] result = cipher.doFinal(Base64.decodeBase64(content));

            return new String(result, "utf-8");
        } catch (Exception ex) {
            Logger.getLogger(AESUtil.class.getName()).log(Level.SEVERE, null, ex);
        }

        return null;
    }

    /**
     * 生成加密秘钥
     *
     * @return
     */
    private static SecretKeySpec getSecretKey(final String key) {
        //返回生成指定算法密钥生成器的 KeyGenerator 对象
        KeyGenerator kg = null;

        try {
            kg = KeyGenerator.getInstance(KEY_ALGORITHM);

            //AES 要求密钥长度为 128
            kg.init(128, new SecureRandom(key.getBytes()));

            //生成一个密钥
            SecretKey secretKey = kg.generateKey();

            return new SecretKeySpec(secretKey.getEncoded(), KEY_ALGORITHM);// 转换为AES专用密钥
        } catch (NoSuchAlgorithmException ex) {
            Logger.getLogger(AESUtil.class.getName()).log(Level.SEVERE, null, ex);
        }

        return null;
    }

    public static void main(String[] args) {
        String content = "hello,您好";
        String key = "sde@5f98H*^hsff%dfs$r344&df8543*er";
        System.out.println("content:" + content);
        String s1 = AESUtil.encrypt(content, key);
        System.out.println("s1:" + s1);
        System.out.println("s2:"+AESUtil.decrypt(s1, key));



        String unit = "kbMLG0u17lm2ow/dI9ahCQ==";
        String id_number = "oiQbYHNEfmCEooJtGjR6P5w6mZHTuGOddqPcC0XJR3U=";
        String img = "GEFECCstWyN2Mrf7v5IgCbKZFUjoYdiF1A/6lmy+MB3mXKfvzxoqTNck6OtbFT2HZhOZ87QZtOh2o60ftdxhedVXvlksHw/z22OUCBnyF3qDw8jS0tzEyCeedimPnXJo";
        String ownership = "fzfiNx5cuJacKSOrzmsIhQ==";
        String create_time = "Lc1PykXz4qSbrPHajiN9Jtr2pmjHCjIKWLghL9/yflI=";
        String phone = "PAMnNHWJAEHUJ/s+z1yn+A==";
        String community_name = "WzxXr0PzG7SZ0+I4NmSnbA==";
        String name = "o8dLQPW2kuEG1hNZc+Z5Tw==";
        String real_name = "s3+mG2H+jH3mgfSSudr4Gg==";
        String street_name = "fMp3eTzfIDf7g4yTPIjGuw==";
        String building =  "hp/62zlCg8XiWlhzpC+3GA==";
        String room =  "Kvd3GOsRGawpL5rcR9quYA==";


        String unit2 = "kbMLG0u17lm2ow/dI9ahCQ==";
        String id_number2 = "rFHnXf5oh5pgyPX4X8daIUqcFeUG6C7Z8jRsqGQ+zeY=";
        String img2 = "GEFECCstWyN2Mrf7v5IgCbKZFUjoYdiF1A/6lmy+MB3mXKfvzxoqTNck6OtbFT2HYK3+g/dTIQI0I2XsewtkPaJIZwSDhRaIkO1z7nQpCgdC05fapYcMUSwhObBDMx2r";
        String ownership2 = "FhCJA/Ow9wK9eFyGU1RYOA==";
        String create_time2 = "vcq0kei6iyNJ49E9quhsF3CIM5RI/fXOkatcKgGOA1U=";
        String phone2 = "zCPzJflUFyPLJyLwlRDrog==";
        String community_name2 = "WzxXr0PzG7SZ0+I4NmSnbA==";
        String name2 = "o8dLQPW2kuEG1hNZc+Z5Tw==";
        String real_name2 = "3F92gLZjy/qxgjCfuImXuQ==";
        String street_name2 = "fMp3eTzfIDf7g4yTPIjGuw==";
        String building2 =  "Qvc+dC4Afi/P4qcUr1wzcQ==";
        String room2 =  "5cArMF7xfuqtuE9K5Smnhw==";


        String key2 = "jnh2021";


        System.out.println("姓名:"+AESUtil.decrypt("uNF6k48atp9FrlxbfYhCKA==", key2));

        System.out.println("*************************************************");
        System.out.println("街道:"+AESUtil.decrypt(street_name, key2));
        System.out.println("社区:"+AESUtil.decrypt(community_name, key2));
        System.out.println("小区:"+AESUtil.decrypt(name, key2));
        System.out.println("楼栋:"+AESUtil.decrypt(building, key2));
        System.out.println("单元:"+AESUtil.decrypt(unit, key2));
        System.out.println("房号:"+AESUtil.decrypt(room, key2));
        System.out.println("姓名:"+AESUtil.decrypt(real_name, key2));
        System.out.println("身份证:"+AESUtil.decrypt(id_number, key2));
        System.out.println("照片URL:"+AESUtil.decrypt(img, key2));
        System.out.println("手机号:"+AESUtil.decrypt(phone, key2));
        System.out.println("类型:"+AESUtil.decrypt(ownership, key2));
        System.out.println("创建时间:"+AESUtil.decrypt(create_time, key2));
        System.out.println("*************************************************");

        System.out.println("*************************************************");
        System.out.println("街道:"+AESUtil.decrypt(street_name2, key2));
        System.out.println("社区:"+AESUtil.decrypt(community_name2, key2));
        System.out.println("小区:"+AESUtil.decrypt(name2, key2));
        System.out.println("楼栋:"+AESUtil.decrypt(building2, key2));
        System.out.println("单元:"+AESUtil.decrypt(unit2, key2));
        System.out.println("房号:"+AESUtil.decrypt(room2, key2));
        System.out.println("姓名:"+AESUtil.decrypt(real_name2, key2));
        System.out.println("身份证:"+AESUtil.decrypt(id_number2, key2));
        System.out.println("照片URL:"+AESUtil.decrypt(img2, key2));
        System.out.println("手机号:"+AESUtil.decrypt(phone2, key2));
        System.out.println("类型:"+AESUtil.decrypt(ownership2, key2));
        System.out.println("创建时间:"+AESUtil.decrypt(create_time2, key2));
        System.out.println("*************************************************");




    }

}
