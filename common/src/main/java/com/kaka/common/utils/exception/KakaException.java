package com.kaka.common.utils.exception;

import com.kaka.common.enums.ResultCode;
import org.springframework.http.HttpStatus;

/**
 * @author jsk
 * @Date 2018/12/14 11:35
 */
public class KakaException extends Exception {

    private String code;

    private HttpStatus status;

    public HttpStatus getStatus() {
        return status;
    }

    public String getCode() {
        return code;
    }

    private KakaException() {
    }

    public KakaException(String message) {
        super(message);
        this.code = ResultCode.INTERNAL_SERVER_ERROR.getCode();
        this.status = HttpStatus.INTERNAL_SERVER_ERROR;
    }

    public KakaException(String code, HttpStatus status, String message) {
        super(message);
        this.code = code;
        this.status = status;
    }

    public KakaException(String code, HttpStatus status, String message, Throwable cause) {
        super(message, cause);
        this.code = ResultCode.INTERNAL_SERVER_ERROR.getCode();
        this.status = status;
    }

    public KakaException(String message, Throwable cause) {
        super(message, cause);
        this.code = ResultCode.INTERNAL_SERVER_ERROR.getCode();
        this.status = HttpStatus.INTERNAL_SERVER_ERROR;
    }

    public KakaException(Throwable cause) {
        super(cause);
        this.code = ResultCode.INTERNAL_SERVER_ERROR.getCode();
        this.status = HttpStatus.INTERNAL_SERVER_ERROR;
    }
}