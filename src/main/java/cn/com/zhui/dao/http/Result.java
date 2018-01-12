package cn.com.zhui.dao.http;

import com.google.gson.annotations.Expose;

/**
 * 可以设置返回json格式
 */

public class Result {
    @Expose
    private boolean success;
    @Expose
    private String msg;
    @Expose
    private Object data;

    public Result(boolean success, String msg, Object data) {
        this.success = success;
        this.msg = msg;
        this.data = data;
    }

    public Result() {

    }

    public Result(boolean success, String msg) {
        this.success = success;
        this.msg = msg;
    }

    public static Result ok(){
        Result result = new Result();
        result.setSuccess(true);
        return result;
    }

    public static Result ok(String msg){
        Result result = new Result();
        result.setSuccess(true);
        result.setMsg(msg);
        return result;
    }

    public static Result ok(Object data){
        Result result = new Result();
        result.setSuccess(true);
        result.setData(data);
        return result;
    }

    public static Result fail(){
        Result result = new Result();
        result.setSuccess(false);
        return result;
    }

    public static Result fail(String msg){
        Result result = new Result();
        result.setSuccess(false);
        result.setMsg(msg);
        return result;
    }

    public static final int OPERATE_CODE_LOGIN = 100;

    public boolean isSuccess() {
        return success;
    }

    public void setSuccess(boolean success) {
        this.success = success;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public Object getData() {
        return data;
    }

    public void setData(Object data) {
        this.data = data;
    }
}
