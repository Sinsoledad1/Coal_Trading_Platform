package com.tom.exception;

/**
 * @author Alfalfa99
 * @version 1.0
 * @date 2020/11/1 15:24
 * 基础异常
 */
public class BasicException extends RuntimeException {
    public BasicException() {
    }

    public BasicException(String message) {
        super(message);
    }

    public BasicException(String message, Throwable cause) {
        super(message, cause);
    }

    public BasicException(Throwable cause) {
        super(cause);
    }

    public BasicException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
