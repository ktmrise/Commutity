package com.ktm.dto;

import com.ktm.Exception.CustomizeErrorCode;
import com.ktm.Exception.CustomizeException;
import lombok.Data;
import org.springframework.web.servlet.ModelAndView;

@Data
public class ResultDTO<T>{
    private Integer code;
    private String message;
    private T data;

    public static ResultDTO errorOf(Integer code, String message) {
        ResultDTO resultDTO = new ResultDTO();
        resultDTO.setCode(code);
        resultDTO.setMessage(message);
        return resultDTO;
    }


    public static ResultDTO errorOf(CustomizeErrorCode errorCode) {

        return errorOf(errorCode.getCode(), errorCode.getMessage());
    }

    public static ResultDTO errorOf(CustomizeException e) {
        return errorOf(e.getCode(), e.getMessage());
    }

    public static<T> ResultDTO okOf(T t) {

        ResultDTO resultDTO = new ResultDTO();
        resultDTO.setMessage("请求成功");
        resultDTO.setCode(200);
        resultDTO.setData(t);
        return resultDTO;
    }

    public static ResultDTO okOf() {

        ResultDTO resultDTO = new ResultDTO();
        resultDTO.setMessage("请求成功");
        resultDTO.setCode(200);
        return resultDTO;
    }


}
