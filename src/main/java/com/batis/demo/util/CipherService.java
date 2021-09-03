package com.batis.demo.util;

import com.batis.demo.constant.CommonConstant;
import org.apache.commons.codec.DecoderException;
import org.apache.commons.codec.binary.Hex;
import org.apache.commons.io.IOUtils;
import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Component;

import javax.crypto.BadPaddingException;
import javax.crypto.Cipher;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.NoSuchPaddingException;
import javax.crypto.spec.SecretKeySpec;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.nio.charset.Charset;
import java.security.InvalidKeyException;
import java.security.Key;
import java.security.NoSuchAlgorithmException;
import java.util.Objects;
import java.util.regex.Pattern;

/**
 * cipher service
 * Created by Gavin on 2016/2/16.
 */
@Component
public class CipherService {

    private static final String HEX_DIGITS = "0123456789ABCDEF";

    private static final String KEY_ALGORITHM = "AES";

    private static final String DEFAULT_CIPHER_ALGORITHM = "AES/ECB/PKCS5Padding";

    private static final String SECRET_KEY_PATH = "secret_key_path";

    private static final Pattern ID_CARD_PATTERN = Pattern.compile("(?<=\\d{10})\\d(?=\\d{4})");

    private Key secretKey;

    public CipherService() throws NoSuchPaddingException, DecoderException, NoSuchAlgorithmException, IOException, BadPaddingException, IllegalBlockSizeException, InvalidKeyException {
        setSecretKey(System.getenv(SECRET_KEY_PATH));
    }

    public void setSecretKey(String path) throws IOException, NoSuchPaddingException, NoSuchAlgorithmException, InvalidKeyException, BadPaddingException, IllegalBlockSizeException, DecoderException {
        InputStream is = new FileInputStream(path);
        String key = IOUtils.toString(is);
        secretKey = new SecretKeySpec(parseHexStrToBytes(key), KEY_ALGORITHM);
    }

    private byte[] parseHexStrToBytes(String hexString) {
        try {
            return Hex.decodeHex(hexString.toCharArray());
        } catch (DecoderException e) {
            return new byte[0];
        }
    }

    private String parseBytes2HexStr(byte buf[]) {
        return new String(Hex.encodeHex(buf));
    }

    /**
     * 加密字符串
     * @param data 原文
     * @return 密文
     */
    public String encrypt(String data) {
        try {
            Cipher cipher = Cipher.getInstance(DEFAULT_CIPHER_ALGORITHM);
            cipher.init(Cipher.ENCRYPT_MODE, secretKey);
            byte[] result = cipher.doFinal(data.getBytes(Charset.forName(CommonConstant.DEFAULT_CHARSET)));
            return parseBytes2HexStr(result);
        } catch (NoSuchAlgorithmException | NoSuchPaddingException e) {
            return StringUtils.EMPTY;
        } catch (BadPaddingException | IllegalBlockSizeException | InvalidKeyException e) {
            return StringUtils.EMPTY;
        }
    }

    /**
     * 解密字符串
     * @param data 密文
     * @return 原文
     */
    public String decrypt(String data) {
        try {
            if(StringUtils.isEmpty(data))
                return StringUtils.EMPTY;
            Cipher cipher = Cipher.getInstance(DEFAULT_CIPHER_ALGORITHM);
            cipher.init(Cipher.DECRYPT_MODE, secretKey);
            byte[] result = cipher.doFinal(parseHexStrToBytes(data));
            if (Objects.isNull(result) || result.length == 0) {
                return data;
            } else {
                return new String(result, Charset.forName(CommonConstant.DEFAULT_CHARSET));
            }
        } catch (NoSuchAlgorithmException | NoSuchPaddingException | BadPaddingException | IllegalBlockSizeException | InvalidKeyException e) {
            return data;
        }
    }

    /**
     * 隐藏身份证部分数字，保留开头10位，结尾4位
     * 110103199801010534 -> 1101031998****0534
     * @param idCardNo 身份证号
     * @return 隐藏后的身份证
     */
    public String encodeIdCard(String idCardNo) {
        return ID_CARD_PATTERN.matcher(idCardNo).replaceAll("*");
    }
}
