package com.seangogo.blogs.VO;

import com.seangogo.blogs.domain.enums.ResultEnum;
import lombok.Data;

/**
 * http请求返回的最外层对象
 * Created by 廖师兄
 * 2017-05-12 14:13
 */
@Data
public class ResultVO<T> {

    /** 错误码. */
    private Integer code;

    /** 提示信息. */
    private String msg;

    /** 具体内容. */
    private T data;

    public ResultVO(ResultEnum resultEnum, T data) {
        this.code = resultEnum.getCode();
        this.msg = resultEnum.getMessage();
        this.data = data;
    }
    public ResultVO(ResultEnum resultEnum) {
        this.code = resultEnum.getCode();
        this.msg = resultEnum.getMessage();
    }
}
