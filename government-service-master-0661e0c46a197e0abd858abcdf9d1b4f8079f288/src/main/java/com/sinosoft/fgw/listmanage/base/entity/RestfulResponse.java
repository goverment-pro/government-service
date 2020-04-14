package com.sinosoft.fgw.listmanage.base.entity;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.sinosoft.fgw.listmanage.base.enums.MsgEnum;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;


@Getter
@Setter
@ToString(callSuper = true)
@EqualsAndHashCode
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonIgnoreProperties(value = {"hibernateLazyInitializer", "handler", "fieldHandler","statusCode"}, ignoreUnknown = true)
public class RestfulResponse<T> implements Response {
    private static final long serialVersionUID = -7443304902819898146L;

    private RestfulResponse(){}

    public static final int DEFAULT_OK = 20000;

    /**
     * [M] 平台状态码
     */
    private int code = DEFAULT_OK;


    private String msg;

    private T data;


    public static RestfulResponse success(){
        RestfulResponse restfulResponse = new RestfulResponse<>();
        restfulResponse.setCode(MsgEnum.SUCCESS.code());
        restfulResponse.setMsg(MsgEnum.SUCCESS.message());
        return restfulResponse;
    }

    public static <T> RestfulResponse<T> success(MsgEnum msgEnum, T data){
        RestfulResponse<T> restfulResponse = new RestfulResponse<>();
        restfulResponse.setCode(msgEnum.code());
        restfulResponse.setMsg(msgEnum.message());
        if(data != null){
            restfulResponse.setData(data);
        }
        return restfulResponse;
    }

    public static RestfulResponse fail(MsgEnum msgEnum){
        RestfulResponse restfulResponse = new RestfulResponse<>();
        restfulResponse.setCode(msgEnum.code());
        restfulResponse.setMsg(msgEnum.message());
        return restfulResponse;
    }
    public static RestfulResponse fail(){
        RestfulResponse restfulResponse = new RestfulResponse<>();
        restfulResponse.setCode(MsgEnum.SERVER_ERROR.code());
        restfulResponse.setMsg(MsgEnum.SERVER_ERROR.message());
        return restfulResponse;
    }
    public static <T> RestfulResponse<T> fail(MsgEnum msgEnum, T data){
        RestfulResponse<T> restfulResponse = new RestfulResponse<>();
        restfulResponse.setCode(msgEnum.code());
        restfulResponse.setMsg(msgEnum.message());
        if(data != null){
            restfulResponse.setData(data);
        }
        return restfulResponse;
    }
}
