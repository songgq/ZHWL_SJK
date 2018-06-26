package com.ustcsoft.jt.util;

import org.apache.commons.codec.binary.Base64;

import java.io.UnsupportedEncodingException;

/**
 * @author mapp
 * @des
 * @date 2018/4/19
 */
public class Base64Util {

    private static final String UTF_8 = "UTF-8";

    /**
     * 对给定的字符串进行base64解码操作
     */
    public static String decodeData(String inputData) {
        try {
            if (null == inputData) {
                return null;
            }
            return new String(Base64.decodeBase64(inputData.getBytes(UTF_8)), UTF_8);
        } catch (UnsupportedEncodingException e) {

        }

        return null;
    }

    /**
     * 对给定的字符串进行base64加密操作
     */
    public static String encodeData(String inputData) {
        try {
            if (null == inputData) {
                return null;
            }
            return new String(Base64.encodeBase64(inputData.getBytes(UTF_8)), UTF_8);
        } catch (UnsupportedEncodingException e) {
        }

        return null;
    }

    public static void main(String[] args) {
        System.out.println(Base64Util.encodeData("{\n" +
                "  \"age\": \"15\",\n" +
                "  \"name\": \"xiaoming\"\n" +
                "}"));
        System.out.println(Base64Util.decodeData("ewogICJhZ2UiOiAiMTUiLAogICJuYW1lIjogInhpYW9taW5nIgp9"));
    }
}
