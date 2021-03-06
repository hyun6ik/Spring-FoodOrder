package com.example.foodorder.utils;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor(access = AccessLevel.PRIVATE)
public enum ErrorCode {

    NOT_FOUND_EXCEPTION_USER(404, "해당 하는 계정을 찾을 수 없습니다."),
    NOT_FOUND_EXCEPTION_BOARD(404,"해당 하는 게시글을 찾을 수 없습니다."),

    ALREADY_EXIST_EXCEPTION_USER(400, "이미 존재하는 계정입니다."),
    ALREADY_EXIST_EXCEPTION_NICKNAME(400, "이미 존재하는 별명입니다.");



    private int code;
    private String message;

    ErrorCode(int code, String message) {
        this.code = code;
        this.message = message;
    }

}
