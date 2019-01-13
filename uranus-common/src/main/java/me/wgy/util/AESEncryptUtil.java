package me.wgy.util;

import java.security.SecureRandom;
import java.util.Base64;
import javax.crypto.Cipher;
import javax.crypto.KeyGenerator;
import javax.crypto.SecretKey;
import javax.crypto.spec.SecretKeySpec;
import lombok.extern.slf4j.Slf4j;

/**
 * @author wgy
 * @date 2018/12/23
 */
@Slf4j
public class AESEncryptUtil {

  public static AESEncryptUtil AESEncryptUtil;

  private AESEncryptUtil() {
    //单例
  }

  /**
   * 双重锁
   */
  public static AESEncryptUtil getInstance() {
    if (AESEncryptUtil == null) {
      synchronized (AESEncryptUtil.class) {
        if (AESEncryptUtil == null) {
          AESEncryptUtil = new AESEncryptUtil();
        }
      }
    }
    return AESEncryptUtil;
  }

  /**
   * 加密
   */
  public String encrypt(String encodeRules, String content) {
    try {
      //1.构造密钥生成器，指定为AES算法,不区分大小写
      KeyGenerator keygen = KeyGenerator.getInstance("AES");
      //2.根据ecnodeRules规则初始化密钥生成器
      //生成一个128位的随机源,根据传入的字节数组
      SecureRandom random = SecureRandom.getInstance("SHA1PRNG");
      random.setSeed(encodeRules.getBytes());
      keygen.init(128, random);
      //3.产生原始对称密钥
      SecretKey originalKey = keygen.generateKey();
      //4.获得原始对称密钥的字节数组
      byte[] raw = originalKey.getEncoded();
      //5.根据字节数组生成AES密钥
      SecretKey key = new SecretKeySpec(raw, "AES");
      //6.根据指定算法AES自成密码器
      Cipher cipher = Cipher.getInstance("AES");
      //7.初始化密码器，第一个参数为加密(Encrypt_mode)或者解密解密(Decrypt_mode)操作，第二个参数为使用的KEY
      cipher.init(Cipher.ENCRYPT_MODE, key);
      //8.获取加密内容的字节数组(这里要设置为utf-8)不然内容中如果有中文和英文混合中文就会解密为乱码
      byte[] contentByte = content.getBytes("utf-8");
      //9.根据密码器的初始化方式--加密：将数据加密
      byte[] encryptByte = cipher.doFinal(contentByte);
      //10.将加密后的数据转换为字符串
      String encryptStr = new String(Base64.getEncoder().encodeToString(encryptByte));
      //11.将字符串返回
      return encryptStr;
    } catch (Exception e) {
      log.error("AES encrypt Exception", e);
      return null;
    }
  }

  /**
   * 解密
   */
  public String decrypt(String encodeRules, String content) {
    try {
      //1.构造密钥生成器，指定为AES算法,不区分大小写
      KeyGenerator keygen = KeyGenerator.getInstance("AES");
      //2.根据ecnodeRules规则初始化密钥生成器
      //生成一个128位的随机源,根据传入的字节数组
      SecureRandom random = SecureRandom.getInstance("SHA1PRNG");
      random.setSeed(encodeRules.getBytes());
      keygen.init(128, random);
      //3.产生原始对称密钥
      SecretKey originalKey = keygen.generateKey();
      //4.获得原始对称密钥的字节数组
      byte[] raw = originalKey.getEncoded();
      //5.根据字节数组生成AES密钥
      SecretKey key = new SecretKeySpec(raw, "AES");
      //6.根据指定算法AES自成密码器
      Cipher cipher = Cipher.getInstance("AES");
      //7.初始化密码器，第一个参数为加密(Encrypt_mode)或者解密(Decrypt_mode)操作，第二个参数为使用的KEY
      cipher.init(Cipher.DECRYPT_MODE, key);
      //8.将加密并编码后的内容解码成字节数组
      byte[] contentByte = Base64.getDecoder().decode(content);
      /*
       * 解密
       */
      byte[] decryptByte = cipher.doFinal(contentByte);
      String decryptStr = new String(decryptByte, "utf-8");
      return decryptStr;
    } catch (Exception e) {
      log.error("AES decrypt Exception", e);
      return "";
    }
  }

  public static void main(String[] args) {
    // 密钥的种子，可以是任何形式，本质是字节数组
    String strKey = "AESKey";
    // 密码的明文
    String clearPwd = "My world is full of wonders! No body can match my spirit";
    // 密码加密后的密文
    String encryptStr = getInstance().encrypt(strKey, clearPwd);
    System.out.println(encryptStr);
    // 解密后的字符串
    String decryptedPwd = getInstance().decrypt(strKey, encryptStr);
    System.out.println(decryptedPwd);

  }
}
