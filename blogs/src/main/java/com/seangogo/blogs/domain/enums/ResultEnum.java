package com.seangogo.blogs.domain.enums;

import lombok.Getter;

/**
 * Created by sean on 2017/9/11.
 */
@Getter
public enum ResultEnum implements CodeEnum {
    SUCCESS(0, "成功"),
    PARAM_ERROR(1, "参数不正确"),
    OBJ_NOT_EXIST(10, "对象不存在"),
    CODE_ERROR(1001, "验证码不正确"),
    EMAIL_EXIST(1002,"帐号|Email已经存在！"),


    ;

    private Integer code;

    private String message;

    ResultEnum(Integer code, String message) {
        this.code = code;
        this.message = message;
    }

}
