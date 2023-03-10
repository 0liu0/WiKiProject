package com.liuche.wiki.controller;

import com.liuche.wiki.exception.BusinessException;
import com.liuche.wiki.resp.CommonResp;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.validation.BindException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * 统一异常处理、数据预处理等
 */
@ControllerAdvice
public class ControllerExceptionHandler {

    private static final Logger LOG = LoggerFactory.getLogger(ControllerExceptionHandler.class);

    /**
     * 校验异常统一处理
     * @param e
     * @return
     */
    @ExceptionHandler(value = BindException.class)
    @ResponseBody
    public CommonResp validExceptionHandler(BindException e) {
        CommonResp commonResp = new CommonResp();
        LOG.warn("参数校验失败：{}", e.getBindingResult().getAllErrors().get(0).getDefaultMessage());
        commonResp.setSuccess(false);
        commonResp.setMessage(e.getBindingResult().getAllErrors().get(0).getDefaultMessage());
        return commonResp;
    }
    // NullPointerException
    @ExceptionHandler(value = NullPointerException.class)
    @ResponseBody
    public CommonResp NullPointerExceptionHandler(NullPointerException e) {
        CommonResp commonResp = new CommonResp();
        LOG.warn("参数校验失败：{}", e.getMessage());
        commonResp.setSuccess(true);
        commonResp.setMessage(e.getMessage());
        commonResp.setContent("对不起后端爆出了空指针异常");
        return commonResp;
    }

    // BusinessException
    @ExceptionHandler(value = BusinessException.class)
    @ResponseBody
    public CommonResp BusinessExceptionHandler(BusinessException e) {
        CommonResp commonResp = new CommonResp();
        LOG.warn("业务异常：{}", e.getCode().getDesc());
        commonResp.setSuccess(false);
        commonResp.setMessage(e.getMessage());
        commonResp.setContent(e.getCode().getDesc());
        return commonResp;
    }

    // Exception
    @ExceptionHandler(value = Exception.class)
    @ResponseBody
    public CommonResp ExceptionHandler(Exception e) {
        CommonResp commonResp = new CommonResp();
        LOG.error("系统异常：{}", e);
        commonResp.setSuccess(false);
        commonResp.setMessage("系统出现异常，请联系管理员");
        return commonResp;
    }
}
