package com.example.rascalserver.Exception;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public enum ErrorCode {
    /* Common Error */

//    NOT_FOUND("COMMON-ERR-404", "PAGE NOT FOUND"),
//    INTER_SERVER_ERROR("COMMON-ERR-500", "INTER SERVER ERRROR"),
//    INVALID_INPUT_VALUE("COMMON-ERR-400", " Invalid Input Value"),
//    METHOD_NOT_ALLOWED("COMMON-ERR-405", " Invalid Input Value"),
//    HANDLE_ACCESS_DENIED("COMMON-ERR-403", "Access is Denied"),
//
//    /* User Error */
//    EMAIL_DUPLICATION("MEMBER-ERR-400", "EMAIL DUPLICATED"),

    LOGIN_FAILED(-1001, "로그인에 실패하였습니다."),
    NOT_FOUND(404, "찾을 수 없습니다."),
    ;

    private int code;
    private String message;
}
