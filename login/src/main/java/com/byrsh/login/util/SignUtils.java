package com.byrsh.login.util;

import org.apache.commons.codec.binary.Hex;
import org.apache.commons.codec.digest.DigestUtils;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import javax.crypto.Mac;
import javax.crypto.spec.SecretKeySpec;
import java.util.Map;
import java.util.SortedMap;
import java.util.TreeMap;

/**
 * @Author: yangrusheng
 * @Description:
 * @Date: Created in 14:36 2018/5/10
 * @Modified By:
 */
public class SignUtils {

    private static final Logger LOGGER = LogManager.getLogger(SignUtils.class);

    /**
     * 微信支付签名算法(详见:https://pay.weixin.qq.com/wiki/doc/api/tools/cash_coupon.php?chapter=4_3).
     * 参数值为空、文件类型、sign字段参数不参与签名
     *
     * @param params        参数信息
     * @param signAlg       签名算法
     * @param signKey       签名key
     * @return               签名字符串
     */
    public static String createSign(Map<String, String> params, String signAlg, String signKey) {
        SortedMap<String, String> sortedMap = new TreeMap<>(params);

        StringBuilder toSign = new StringBuilder();
        for (String key : sortedMap.keySet()) {
            String value = params.get(key);
            boolean isSign = false;

            //剔除参数值为空、文件类型、sign字段参数
            if (StringUtil.isEmpty(value) || key.endsWith("file") || key.equals("sign")){
                isSign = false;
            } else {
                isSign = true;
            }
            if (isSign){
                toSign.append(key).append("=").append(value).append("&");
            }
        }
        //拼接密钥
        toSign.append("key=").append(signKey);

        if (signAlg.equals("HMAC-SHA256")) {
            return createHmacSha256Sign(toSign.toString(), signKey).toUpperCase();
        } else {
            return DigestUtils.md5Hex(toSign.toString()).toUpperCase();
        }
    }

    /**
     *
     * @param params        参数信息
     * @param signAlg       签名算法
     * @param signKey       签名key
     * @param sign          要检验的签名
     * @return
     */
    public static boolean checkSign(Map<String, String> params, String signAlg, String signKey, String sign){
        String newSign = createSign(params, signAlg, signKey);
        return sign.equals(newSign);
    }

    private static String createHmacSha256Sign(String data, String signKey) {
        try {
            Mac sha256_HMAC = Mac.getInstance("HmacSHA256");
            SecretKeySpec secret_key = new SecretKeySpec(signKey.getBytes("UTF-8"), "HmacSHA256");
            sha256_HMAC.init(secret_key);
            return Hex.encodeHexString(sha256_HMAC.doFinal(data.getBytes("UTF-8")));
        } catch (Exception e) {
            LOGGER.error("create sign with hmacSha256 error: ", e);
        }
        return null;
    }

}
