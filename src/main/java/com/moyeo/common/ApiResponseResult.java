package com.moyeo.common;

import lombok.Getter;

@Getter
public class ApiResponseResult<T> {
    private CommonResponse<T> response;

    public ApiResponseResult() {
        super();
    }

    public ApiResponseResult(CommonResponse<T> response) {
        this.response = response;
    }


}
