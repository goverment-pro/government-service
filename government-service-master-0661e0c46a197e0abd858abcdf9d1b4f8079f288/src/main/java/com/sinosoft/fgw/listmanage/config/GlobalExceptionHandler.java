package com.sinosoft.fgw.listmanage.config;

import com.sinosoft.fgw.listmanage.base.entity.RestfulResponse;
import com.sinosoft.fgw.listmanage.base.enums.MsgEnum;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * Created by liuruijie on 2016/12/28.
 * 全局异常处理，捕获所有Controller中抛出的异常。
 */
@Slf4j
@ControllerAdvice
public class GlobalExceptionHandler {

   /**
    * 处理全局异常
    * @param e 异常
    * @return
    */
   @ExceptionHandler(Exception.class)
   @ResponseBody
   public Object exceptionHandler(Exception e){
      log.error("接口调用异常", e);
      return RestfulResponse.fail(MsgEnum.SERVER_ERROR);
   }
}