package com.moyeo.common;

import com.fasterxml.jackson.annotation.JsonIgnore;
import io.micrometer.common.lang.Nullable;
import org.springframework.http.HttpStatus;


public record CommonResponse<T>(
        @JsonIgnore // 실제 응답에 포함되지 않음
        int httpStatus,
        String statusMessage,
        @Nullable T resultData
        //@Nullable ExceptionDto error
) {
    public CommonResponse(int httpStatus, String statusMessage, T resultData) {
        this.httpStatus = httpStatus;
        this.statusMessage = statusMessage;
        this.resultData = resultData;
    }

    // 200
    public static <T> CommonResponse<T> ok(@Nullable final T data) {
        return new CommonResponse<>(HttpStatus.OK.value(), "success", data);
    }

    // 201
    public static <T> CommonResponse<T> created(@Nullable final T data) {
        return new CommonResponse<>(HttpStatus.CREATED.value(), "success", data);
    }

    public static <T> CommonResponse<T> error(final CustomException e) {
        return new CommonResponse<>(e.getErrorCode().getHttpStatus().value(), "faild", null);
    }
}
