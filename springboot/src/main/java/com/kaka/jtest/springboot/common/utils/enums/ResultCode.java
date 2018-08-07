package com.kaka.jtest.springboot.common.utils.enums;

/**
 * 系统自定义状态码
 *
 * @author shuangkaijia
 */
public enum ResultCode {

    SUCCESS("success", "操作成功"),
    FAILURE("failure", "操作失败"),
    OK("200", "操作成功"),
    //系统异常
    CODE_5500("8500", "服务器端内部异常"),// 5500
    //兼容原来代码
    INTERNAL_SERVER_ERROR("8500", "服务器端内部异常"),   //500
    //参数校验
    CODE_5400("8400", "输入参数不能为空"),  // 5400
    //兼容原来代码
    ILLEGAL_ARGUMENT("8400", "输入参数不能为空"),   // 400
    //鉴权
    CODE_5200("8200", "认证失败"),   // 5200
    //用户不存在
    CODE_5201("8201", "用户不存在"),  //  5201
    //Token验证失败
    CODE_5202("8202", "Token验证失败");  // 5202


    private String code;
    private String name;

    ResultCode(String code, String name) {
        this.code = code;
        this.name = name;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

}

