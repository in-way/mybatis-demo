

package com.batis.demo.config.response;


import java.util.Optional;

public class GbpsResponse<T> {

    private Integer status;
    private String message;
    private Object errorDetail;
    private T data;

    /**
     * 标准报文对象成功时的构造方法。
     * 主要用于框架自动调用，自动调用时，java的泛型判定会失效，无法直接使用下面的success方法来调用。
     * @param data 返回对象，如果是Java8的Optional对象，会做一层自动解包的动作。{@link Optional}
     * @return 标准报文成功对象。
     */
    public static GbpsResponse autoSuccess(Object data) {
        if (data != null && data instanceof Optional) {
            return success((Optional<?>) data);
        }
        return build(data, GbpsResponseCode.SUCCESS, null);
    }

    /**
     * 标准报文对象成功时的构造方法。
     *
     * @param data 返回对象
     * @param <T>  返回对象类型。
     * @return 标准报文成功对象。
     */
    public static <T> GbpsResponse<?> success(T data) {
        return build(data, GbpsResponseCode.SUCCESS, null);
    }

    /**
     * 标准报文对象成功时的构造方法。
     *
     * @param optional 数据对象的Optional包装
     * @param <T> 返回对象类型。
     * @return 标准报文成功对象。
     */
    public static <T> GbpsResponse<T> success(Optional<T> optional) {
        T data = optional.orElse(null);
        return build(data, GbpsResponseCode.SUCCESS, null);
    }

    public static <T> GbpsResponse<T> fail(GbpsResponseCode responseCode) {
        return fail(responseCode, null);
    }

    public static <T> GbpsResponse<T> fail(GbpsResponseCode responseCode, Object detail) {
        return build(null, responseCode, detail);
    }

    public static <T> GbpsResponse<T> fail(Integer status, String message) {
        return fail(status, message, null);
    }

    public static <T> GbpsResponse<T> fail(Integer status, String message, Object detail) {
        return build(null, status, message, detail);
    }

    private static <T> GbpsResponse<T> build(T data, Integer status, String message, Object detail) {
        GbpsResponse GbpsResponse = new GbpsResponse();
        GbpsResponse.setData(data);
        GbpsResponse.setStatus(status);
        GbpsResponse.setMessage(message);
        GbpsResponse.setErrorDetail(detail);
        return GbpsResponse;
    }
    private static <T> GbpsResponse<T> build(T data, GbpsResponseCode responseCode, Object detail) {
        return build(data, responseCode.getCode(), responseCode.getMessage(), detail);
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }

    public Object getErrorDetail() {
        return errorDetail;
    }

    public void setErrorDetail(Object errorDetail) {
        this.errorDetail = errorDetail;
    }

}

