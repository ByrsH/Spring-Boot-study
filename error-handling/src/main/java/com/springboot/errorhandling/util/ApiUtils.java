package com.springboot.errorhandling.util;

import com.springboot.errorhandling.web.ApiResponseBody;
import com.springboot.errorhandling.web.ErrorCodeInterface;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

/**
 * @Author: yrs
 * @Description:
 * @Date: Greated in 17:36 2018/1/3
 * @Modified By:
 */
public class ApiUtils {
    private static final Logger LOG = LoggerFactory.getLogger(ApiUtils.class);

    public static ResponseEntity getResponseBody(ErrorCodeInterface errorCodeInterface){
        LOG.debug("response entity --> errorCode=[{}], payload=[{}]", errorCodeInterface, null);
        return new ResponseEntity(new ApiResponseBody(errorCodeInterface), HttpStatus.OK);
    }

    public static ResponseEntity getResponseBody(ErrorCodeInterface errorCodeInterface, Object result){
        LOG.debug("response entity --> errorCode=[{}], payload=[{}]", errorCodeInterface, result);
        return new ResponseEntity(new ApiResponseBody(errorCodeInterface, result), HttpStatus.OK);
    }
}
