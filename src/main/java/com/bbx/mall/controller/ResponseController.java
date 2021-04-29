package com.bbx.mall.controller;

import com.bbx.mall.common.BizException;
import com.bbx.mall.common.ResultBody;
import com.bbx.mall.common.StatusEnum;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.HttpRequestMethodNotSupportedException;
import org.springframework.web.bind.MissingServletRequestParameterException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.NoHandlerFoundException;

import javax.servlet.http.HttpServletRequest;

@ControllerAdvice
public class ResponseController {
    private static final Logger logger = LoggerFactory.getLogger(ResponseController.class);

    /**
     * 处理自定义的业务异常
     * @param req
     * @param e
     * @return
     */
    @ExceptionHandler(value = BizException.class)
    @ResponseBody
    public ResultBody bizExceptionHandler(HttpServletRequest req, BizException e){
        logger.error("发生业务异常！原因是：",e.getErrorMsg());
        return ResultBody.error(e.getErrorCode(),e.getErrorMsg());
    }

    @ExceptionHandler(value = Exception.class)
    @ResponseBody
    public ResultBody exceptionHandler(HttpServletRequest req, Exception e){
        //||e instanceof NoHandlerFoundException
        if(e instanceof HttpRequestMethodNotSupportedException||e instanceof NoHandlerFoundException){
            //处理404或method错误
            logger.error("请求错误，接口方法不存在",e);
            return ResultBody.error(StatusEnum.NOT_FOUND);
        }else if(e instanceof NullPointerException){
            //null
            logger.error("发生空指针异常！原因是:",e);
            return ResultBody.error(StatusEnum.BODY_NOT_MATCH);
        }else if(e instanceof MissingServletRequestParameterException){
            //处理请求参数缺失
            MissingServletRequestParameterException MissingParams = (MissingServletRequestParameterException) e;
            logger.error("发生业务异常！原因是：",e);
            return ResultBody.error("500","请求参数缺失"+MissingParams.getParameterName());
        }else{
            //处理其他异常
            logger.error("未知异常！原因是:",e);
            return ResultBody.error(StatusEnum.INTERNAL_SERVER_ERROR);
        }
    }

}
