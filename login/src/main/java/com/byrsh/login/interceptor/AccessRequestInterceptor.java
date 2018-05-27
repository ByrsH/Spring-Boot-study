package com.byrsh.login.interceptor;

import com.byrsh.login.util.SignUtils;
import io.netty.util.internal.StringUtil;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.TimeUnit;

/**
 * @Author: yangrusheng
 * @Description:
 * @Date: Created in 10:48 2018/5/14
 * @Modified By:
 */
public class AccessRequestInterceptor extends HandlerInterceptorAdapter {

    private static final Logger LOGGER = LogManager.getLogger(AccessRequestInterceptor.class);

    private final StringRedisTemplate stringRedisTemplate;

    public AccessRequestInterceptor(StringRedisTemplate stringRedisTemplate) {
        this.stringRedisTemplate = stringRedisTemplate;
    }

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception{
        String accessToken = request.getHeader("access_token");
        String userId = request.getHeader("user_id");
        String timestamp = request.getHeader("timestamp");
        String nonceStr = request.getHeader("nonce_str");
        String sign = request.getHeader("sign");

        //判断时间戳是否有效
        Long maxMillis = System.currentTimeMillis() - Long.getLong(timestamp);
        if ( maxMillis < 0 || maxMillis > 60000){
            LOGGER.debug("request timeout");
            setResponse(response, REQUEST_TIMEOUT);
            return false;
        }

        //防止重复请求
        String noticeKey = "notice:"+userId+nonceStr;
        if (stringRedisTemplate.hasKey(noticeKey)){
            LOGGER.debug("repeat request");
            setResponse(response, REPEAT_REQUEST);
            return false;
        }

        String signKey;
        //校验是否处于登录状态
        if (!StringUtil.isNullOrEmpty(userId) && !StringUtil.isNullOrEmpty(accessToken)) {
            String tokenSignKey = stringRedisTemplate.opsForValue().get(userId);
            String token = tokenSignKey.split("\\+")[0];
            signKey = tokenSignKey.split("\\+")[1];
            if (token.equals(accessToken)){
                request.setAttribute("user_id", Long.valueOf(userId));
            }else if (token != null){
                LOGGER.debug("user login other device");
                setResponse(response, USER_LOGIN_OTHER_DEVICE);
                return false;
            }else {
                LOGGER.debug("access token is invalid");
                setResponse(response, ACCESS_TOKEN_ERROR);
                return false;
            }
        } else {
            LOGGER.debug("parameter is null");
            setResponse(response, PARAMETER_IS_NULL);
            return false;
        }

        //校验参数签名是否正确
        if (StringUtil.isNullOrEmpty(sign)){
            LOGGER.debug("request sign error");
            setResponse(response, REQUEST_SIGN_ERROR);
            return false;
        }else {
            Map<String, String> params = getParams(request);
            params.put("access_token",accessToken);
            params.put("user_id", userId);
            params.put("timestamp", timestamp);
            params.put("nonce_str", nonceStr);

            if (!SignUtils.checkSign(params, "HMAC-SHA256", signKey, sign)){
                LOGGER.debug("request sign error");
                setResponse(response, REQUEST_SIGN_ERROR);
                return false;
            }
        }

        //请求校验成功后，缓存notice_str，有效时间为60s
        stringRedisTemplate.opsForValue().set(noticeKey,"",60,TimeUnit.SECONDS);
        //更新token+signKey有效时间
        stringRedisTemplate.expire(userId, 60*60*24, TimeUnit.SECONDS);
        return super.preHandle(request, response, handler);
    }

    private Map<String, String> getParams(HttpServletRequest request) {
        Map<String, String> params = new HashMap<>();
        Enumeration<String> pNames = request.getParameterNames();
        while (pNames.hasMoreElements()){
            String pName = pNames.nextElement();
            //剔除文件类型参数
            if (!pName.endsWith("file")) {
                params.put(pName,request.getParameter(pName));
            }
        }
        return params;
    }

    private void setResponse(HttpServletResponse response, byte[] bytes) throws IOException {
        response.setCharacterEncoding("UTF-8");
        response.setContentType("application/json;charset=utf-8");
        response.getOutputStream().write(bytes);
    }

}
