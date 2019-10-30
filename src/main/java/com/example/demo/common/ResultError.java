package com.example.demo.common;

/**
 * 错误码
 */
public enum ResultError {
    SUCCESS(0, "成功"),
    ERR_UNKNOWN_EXCEPTION(2, "未知异常"),
    ERR_DB_EXCEPTION(3, "数据库修改或查询异常"),
    ERR_BUSINESS_EXCEPTION(4, "业务操作异常"),
    ERR_NOT_LOGIN(5, "未登录"),
    ERR_NO_AUTHORITY(6, "当前用户无此权限"),
    ERR_ALREADY_LOGIN(7,"账号已登录"),
    ERR_OPERATION_UNSUPPORTED(8, "操作不支持"),
    ERR_DATA_NOT_EXIST(9, "查询的信息不存在"),
    ERR_IDL_INVOKE_TEXCEPTION(10, "IDL调用异常"),
	ERR_TOKEN_INVALID(11, "token不正确"),
	ERR_FAIL_LOGIN(12, "登录失败,账号不存在或登录名密码错误"),
	ERR_DATA(13, "异常数据"),
    ERR_ARGUMENTS_INVALID(14, "参数不合法"),
    ERR_INVALID_LOGIN(15, "该平台暂停使用"),


    ERR_NOTMATCH_TYPE_INCORRECT(30,"不匹配规则只支持文本或者图片"),
    ERR_NOTMATCH_TYPE_EXIST(31,"已存在该类型的不匹配规则"),
    ERR_RULE_NOT_EXIST(32,"规则不存在,请刷新重试"),
    ERR_RULE_NAME_EXIST(33,"规则名称不可重复添加"),
    ERR_RULE_TIME_EXPIRE(34 ,"规则有效日期已过期，请重新编辑"),

    ERR_ROBOT_PROXY_NOT_EXIST(40,"未设置机器人代理"),


    ERR_CONVERSATION_NOT_EXIST(50 ,"会话不存在"),


    ERR_KEY_RELATION_RULE_NOT_VALID(60 ,"规则中存在无效规则，请重新设置"),
    ERR_SIMILAR_KEYWORD_OF_KEYWORD_EXIST(61 ,"关键词已存在，请重新添加"),
    ERR_SIMILAR_KEYWORD_OF_SET_NOT_EXIST(62 ,"该配置已不存在，请刷新页面重试"),

    ERR_INVALID_PARAMETER(70,"非法参数"),
    ERR_MERCHANT_NOT_FOUNT(71,"供应商不存在");

    private int errorCode;

    private String errorMessage;

    ResultError(int errorCode, String errorMessage) {
        this.errorCode = errorCode;
        this.errorMessage = errorMessage;
    }

    public String getErrorMessage() {
        return errorMessage;
    }

    public int getErrorCode() {
        return errorCode;
    }
}
