package com.skyinfo.taishantimer.test.util;
import org.springframework.util.Base64Utils;
import org.springframework.util.StringUtils;

import javax.crypto.Cipher;
import javax.crypto.KeyGenerator;
import javax.crypto.SecretKey;
import javax.crypto.spec.SecretKeySpec;
import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * @author john.zhang
 * @description
 * @date 2021/8/16 21:57
 */
public class EncryptUtils {
    private static final String KEY_ALGORITHM = "AES";
    private static final String DEFAULT_CIPHER_ALGORITHM = "AES/ECB/PKCS5Padding";//默认的加密算法
    //自定义密码
    public static final String ASSETS_DEV_PWD_FIELD = "jnh2021";


    /**
     * AES 加密操作
     *
     * @param content  待加密内容
     * @param password 加密密码
     * @return 返回Base64转码后的加密数据
     */
    public static String encrypt(String content, String password) {
        try {
            Cipher cipher = Cipher.getInstance(DEFAULT_CIPHER_ALGORITHM);// 创建密码器

            byte[] byteContent = content.getBytes("utf-8");

            cipher.init(Cipher.ENCRYPT_MODE, getSecretKey(password));// 初始化为加密模式的密码器

            byte[] result = cipher.doFinal(byteContent);// 加密

            return Base64Utils.encodeToString(result);//通过Base64转码返回
        } catch (Exception ex) {
            Logger.getLogger(AESUtil.class.getName()).log(Level.SEVERE, null, ex);
        }

        return null;
    }

    /**
     * AES 解密操作
     *
     * @param content
     * @param password
     * @return
     */
    public static String decrypt(String content, String password) {

        try {
            if (StringUtils.isEmpty(content)){
                return "";
            }
            //实例化
            Cipher cipher = Cipher.getInstance(DEFAULT_CIPHER_ALGORITHM);

            //使用密钥初始化，设置为解密模式
            cipher.init(Cipher.DECRYPT_MODE, getSecretKey(password));

            //执行操作
            byte[] result = cipher.doFinal(Base64Utils.decodeFromString(content));
            String s = new String(result, "utf-8");
            return s;
        } catch (Exception ex) {
            ex.printStackTrace();
            Logger.getLogger(AESUtil.class.getName()).log(Level.SEVERE, null, ex);
        }

        return null;
    }

    /**
     * 生成加密秘钥
     *
     * @return
     */
    private static SecretKeySpec getSecretKey(String password) {
        //返回生成指定算法密钥生成器的 KeyGenerator 对象
        KeyGenerator kg = null;
        try {
            kg = KeyGenerator.getInstance(KEY_ALGORITHM);
            SecureRandom random = SecureRandom.getInstance("SHA1PRNG");
            random.setSeed(password.getBytes());
            //AES 要求密钥长度为 128
            kg.init(128, random);
            //生成一个密钥
            SecretKey secretKey = kg.generateKey();
            return new SecretKeySpec(secretKey.getEncoded(), KEY_ALGORITHM);// 转换为AES专用密钥
        } catch (NoSuchAlgorithmException ex) {
            Logger.getLogger(AESUtil.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }

    public static void main(String[] args) {
        String origin = "金德爱";
        String ddd = "320921198501217139";
        String encrypt = EncryptUtils.encrypt(origin, EncryptUtils.ASSETS_DEV_PWD_FIELD);
        String encrypt2 = EncryptUtils.encrypt(ddd, EncryptUtils.ASSETS_DEV_PWD_FIELD);

        String decrypt = EncryptUtils.decrypt("G4m6Gy1r9c8qesTGakSplw==", EncryptUtils.ASSETS_DEV_PWD_FIELD);
        String decrypt1 = EncryptUtils.decrypt("ClZlQqV6ya+nb+oOF7hCEjYX6Nz1//YC34In/EIBMZw=", EncryptUtils.ASSETS_DEV_PWD_FIELD);
        String decrypt2 = EncryptUtils.decrypt("GEFECCstWyN2Mrf7v5IgCbKZFUjoYdiF1A/6lmy+MB3mXKfvzxoqTNck6OtbFT2H/dmiFm7Y4x/oiUSb+QJg6sI0HpXdUHl1sFC8hWWrg1Ulh+vtnRqg2SS/N5pVLHMC", EncryptUtils.ASSETS_DEV_PWD_FIELD);
        String decrypt3 = EncryptUtils.decrypt("FhCJA/Ow9wK9eFyGU1RYOA==", EncryptUtils.ASSETS_DEV_PWD_FIELD);
        String decrypt4 = EncryptUtils.decrypt("iXtFl1ZKmVob/vnhWPA6xNgFMZMdxsj2vlPrgKlBjJg=", EncryptUtils.ASSETS_DEV_PWD_FIELD);
        String decrypt5 = EncryptUtils.decrypt("5iIrX02Z2NlnQ9bJPVCibQ==", EncryptUtils.ASSETS_DEV_PWD_FIELD);
        String decrypt6 = EncryptUtils.decrypt("WzxXr0PzG7SZ0+I4NmSnbA==", EncryptUtils.ASSETS_DEV_PWD_FIELD);
        String decrypt7 = EncryptUtils.decrypt("o8dLQPW2kuEG1hNZc+Z5Tw==", EncryptUtils.ASSETS_DEV_PWD_FIELD);
        String decrypt8 = EncryptUtils.decrypt("ZS9ojvSji4PpIcnwb7giBg==", EncryptUtils.ASSETS_DEV_PWD_FIELD);
        String decrypt9 = EncryptUtils.decrypt("fMp3eTzfIDf7g4yTPIjGuw==", EncryptUtils.ASSETS_DEV_PWD_FIELD);
        String decrypt10 = EncryptUtils.decrypt("KakFdYDvmhQf4axKqS/h5w==", EncryptUtils.ASSETS_DEV_PWD_FIELD);
        String decrypt11 = EncryptUtils.decrypt("deK1qXFXGWZglMxRK+pqzw==", EncryptUtils.ASSETS_DEV_PWD_FIELD);

//        System.out.println(origin);
//
//        System.out.println(encrypt);
//        System.out.println(encrypt2);
        System.out.println(decrypt);
        System.out.println(decrypt1);
        System.out.println(decrypt2);
        System.out.println(decrypt3);
        System.out.println(decrypt4);
        System.out.println(decrypt5);
        System.out.println(decrypt6);
        System.out.println(decrypt7);
        System.out.println(decrypt8);
        System.out.println(decrypt9);
        System.out.println(decrypt10);
        System.out.println(decrypt11);
    }
}

