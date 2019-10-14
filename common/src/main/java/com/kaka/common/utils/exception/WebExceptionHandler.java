package com.kaka.common.utils.exception;

import com.kaka.common.base.BaseResult;
import com.kaka.common.constants.Constants;
import com.kaka.common.utils.TraceIdUtil;
import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;

import javax.servlet.http.HttpServletRequest;

/**
 * @author jsk
 * @Date 2018/12/19 14:17
 */
public class WebExceptionHandler {
    private final Logger logger = LoggerFactory.getLogger("");

    @ExceptionHandler(KakaException.class)
    public ResponseEntity<?> operateExp(KakaException ex, HttpServletRequest request) {
        logger.error("处理" + request.getRequestURI() + "请求系统业务异常,如下:", ex);
        HttpStatus status = ex.getStatus();
        String traceId = TraceIdUtil.getTraceId();
        String language = request.getHeader(Constants.ACCEPT_LANGUAGE);
        String message = ex.getMessage();
        String businessMessage = ex.getMessage();
        if (StringUtils.isNotBlank(language)) {
            String codeMessage = "根据code获取message";
            if (StringUtils.isNotBlank(codeMessage)) {
                message = codeMessage;
                if (StringUtils.isBlank(businessMessage)) {
                    businessMessage = message;
                }
            }
        }
        BaseResult result = new BaseResult();
        result.setSessionId(traceId);
        result.setCode(ex.getCode());
        result.setMessage(message);
        result.setBusinessMessage(businessMessage);

        //针对204 做特殊处理，采用实际的httpCode
        if (status.value() == 204) {
            return new ResponseEntity(result, status);
        } else {
            return new ResponseEntity(result, HttpStatus.OK);
        }

    }
}
