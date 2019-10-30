package com.example.demo.common;

import com.alibaba.fastjson.JSON;


/**
 * 返回页面的当个对象的封装
 * {"errCode":"","msg":"","data":{"id":"","name":"",.....}}
 */
public class ResultObject<T> {

	private Integer errCode;
	private String msg;
	private T data;

	public ResultObject() {
		this(ResultError.SUCCESS);
	}
	
	public ResultObject(T data) {
		this(ResultError.SUCCESS);
		this.data = data;
	}

	public ResultObject(ResultError resultError) {
		this.errCode = resultError.getErrorCode();
		this.msg = resultError.getErrorMessage();
	}

	public ResultObject(ResultError resultError, String msg) {
		this.errCode = resultError.getErrorCode();
		this.msg = msg;
	}

	public static String toResult(ResultError resultError ,Object data){
		ResultObject resultObject = new ResultObject();
		resultObject.setErrCode(resultError.getErrorCode());
		resultObject.setMsg(resultError.getErrorMessage());
		resultObject.setData(data);
		return resultObject.toJSONString();
	}

	public static String toResult(ResultError resultError ){
		return toResult(resultError , null);
	}

	public Integer getErrCode() {
		return errCode;
	}

	public void setErrCode(Integer errCode) {
		this.errCode = errCode;
	}

	public String getMsg() {
		return msg;
	}

	public void setMsg(String msg) {
		this.msg = msg;
	}

	public T getData() {
		return data;
	}

	public void setData(T data) {
		this.data = data;
	}

	@Override
	public String toString() {
		return JSON.toJSONString(this);
	}

	public String toJSONString() {
		return JSON.toJSONString(this);
	}
}
