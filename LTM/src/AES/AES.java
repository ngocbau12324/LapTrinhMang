/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package AES;

import java.awt.RenderingHints;
import java.io.UnsupportedEncodingException;
import java.security.InvalidKeyException;
import java.security.Key;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.security.NoSuchProviderException;
import java.util.Arrays;
import java.util.Base64;
import java.util.StringTokenizer;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.crypto.Cipher;
import javax.crypto.NoSuchPaddingException;
import javax.crypto.spec.SecretKeySpec;

/**
 *
 * @author NGOC BAU
 */
public class AES {
    
    public String encrypt(String strToEncrypt, String myKey) {
      try {
            MessageDigest sha = MessageDigest.getInstance("SHA-1");
            byte[] key = myKey.getBytes("UTF-8");
            key = sha.digest(key);
            key = Arrays.copyOf(key, 16);
            SecretKeySpec secretKey = new SecretKeySpec(key, "AES");
            Cipher cipher = Cipher.getInstance("AES/ECB/PKCS5Padding");
            cipher.init(Cipher.ENCRYPT_MODE, secretKey);
            return Base64.getEncoder().encodeToString(cipher.doFinal(strToEncrypt.getBytes("UTF-8")));
      } catch (Exception e) {
            System.out.println(e.toString());
      }
      return null;
}
    
    public String decrypt(String strToDecrypt, String myKey) {
      try {
            MessageDigest sha = MessageDigest.getInstance("SHA-1");
            byte[] key = myKey.getBytes("UTF-8");
            key = sha.digest(key);
            key = Arrays.copyOf(key, 16);
            SecretKeySpec secretKey = new SecretKeySpec(key, "AES");
            Cipher cipher = Cipher.getInstance("AES/ECB/PKCS5PADDING");
            cipher.init(Cipher.DECRYPT_MODE, secretKey);
            return new String(cipher.doFinal(Base64.getDecoder().decode(strToDecrypt)));
      } catch (Exception e) {
            System.out.println(e.toString());
      }
      return null;
}
    
    public static void main(String[] args) {
//      String secretKey = "TVD";
//      String originalString = "Nguyễn Ngọc Báu\nĐẸP Trai";
//
//      AES testAES = new AES();
//      String encryptedString = testAES.encrypt(originalString, secretKey);
//      System.out.println("Encrypt: " + encryptedString);
//      String decryptedString = testAES.decrypt(encryptedString, secretKey);
//      System.out.println("Decrypt: " + decryptedString);
        StringTokenizer st = new StringTokenizer("#tracuu;8.8.8.8",";");
        st.nextToken();
        System.out.println(st.countTokens()+st.nextToken()+st.countTokens());
        try {
            System.out.println(Double.parseDouble(""));
        } catch (Exception e) {
            System.out.println("Bị lỗi");
        }
        
}
}
