package chenjie.rsa;

import javax.crypto.BadPaddingException;
import javax.crypto.Cipher;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.NoSuchPaddingException;
import java.io.UnsupportedEncodingException;
import java.security.InvalidKeyException;
import java.security.KeyFactory;
import java.security.NoSuchAlgorithmException;
import java.security.PrivateKey;
import java.security.interfaces.RSAPublicKey;
import java.security.spec.InvalidKeySpecException;
import java.security.spec.PKCS8EncodedKeySpec;
import java.security.spec.X509EncodedKeySpec;
import java.util.Base64;

public class PubKeyEnc {

    public static  String pubKenEnc(String text, String pubKey) throws NoSuchAlgorithmException, InvalidKeySpecException, NoSuchPaddingException, InvalidKeyException, UnsupportedEncodingException, IllegalBlockSizeException, BadPaddingException {
        byte[] decoded = Base64.getDecoder().decode(pubKey);
        RSAPublicKey publicKey = (RSAPublicKey) KeyFactory.getInstance("RSA").generatePublic(new X509EncodedKeySpec(decoded));

        Cipher cipher = Cipher.getInstance("RSA");
        cipher.init(Cipher.ENCRYPT_MODE, publicKey);
        String outStr = Base64.getEncoder().encodeToString(cipher.doFinal(text.getBytes("UTF-8")));
        System.out.println(outStr);
        return outStr;
    }

    public static String privateKeyEncrypt(String str, String privateKey) throws Exception {
        //base64编码的公钥
        byte[] decoded = Base64.getDecoder().decode(privateKey);
        PrivateKey priKey = KeyFactory.getInstance("RSA").
                generatePrivate(new X509EncodedKeySpec(decoded));
        //RSA加密
        Cipher cipher = Cipher.getInstance("RSA");
        cipher.init(Cipher.ENCRYPT_MODE, priKey);
        String outStr = Base64.getEncoder().encodeToString(cipher.doFinal(str.getBytes()));
        System.out.println(outStr);
        return outStr;
    }


    public static void main(String[] args) throws Exception {
        String pubKey = "MIIBIjANBgkqhkiG9w0BAQEFAAOCAQ8AMIIBCgKCAQEAvU6bTtKciT9xpPjGn6ALEISlKyipMhQEi6H8I38s3UQ9VODPmL44u4oO1wFT5qH7ptRxEdADkfL314+nNT2XQ64WlHAYIoCfpIKQbsR5a73bfzs8lGJYpKth0w8Xdx2ntGKL29B4MG5F3VK0vD4Nd9ZyLQuSg3vqvcvNdUDtysBUdlzwLZw1oJ2GEv7clxt3kbXAi00dPZFNMPK6qdxs1MTeNN46C5U3FiMUP1u3wdFCGJPkAOcwHIPytOMnStnVVO8iDTxatRP0pm/Vh/nVTHMAY7xPOGXOAO4sIzoq/Lcuj8/An00nRohby1QYjhagXgHoIo5uyU6WrX9umi0iVQIDAQAB";

        pubKenEnc("admin", pubKey);


    }
}
