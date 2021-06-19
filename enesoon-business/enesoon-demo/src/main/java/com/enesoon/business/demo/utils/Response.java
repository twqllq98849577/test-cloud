package com.enesoon.business.demo.utils;

import java.io.Serializable;
import lombok.Data;
import lombok.experimental.Accessors;


/**
 * @author Cash Zhang
 * @version v1.0
 * @since 2019/01/28 21:47
 */
@Data
@Accessors(chain = true)
public class Response<T> implements Serializable {
 
  private static final long serialVersionUID = 5005318709330004756L;
  /**
   * 状态码
   */
  private Integer code=0;
  /**
   * 描述
   */
  private String msg="";
  /**
   * 结果集
   */
  private T data;
 
  public static <T> Response<T> ok() {
    return restResult(ErrorCode.SUCCESS, null, null);
  }
 
  public static <T> Response<T> ok(T data) {
    return restResult(ErrorCode.SUCCESS, null, data);
  }
 
  public static <T> Response<T> ok(Integer code, T data) {
    return restResult(code, null, data);
  }
 
  public static <T> Response<T> failed(Integer code) {
    return restResult(code, null, null);
  }
 
  public static <T> Response<T> failed(int code, String msg) {
    return restResult(code, msg, null);
  }
 
  private static <T> Response<T> restResult(Integer code, String msg, T data) {
    Response<T> apiResult = new Response<>();
    apiResult.setCode(code);
    apiResult.setMsg(msg);
    apiResult.setData(data);
    return apiResult;
  }
 
}
