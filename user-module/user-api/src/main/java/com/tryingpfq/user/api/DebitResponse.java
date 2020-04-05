package com.tryingpfq.user.api;

/**
 * @Author tryingpfq
 * @Date 2020/4/1
 */
public class DebitResponse {
    private int id;

    private String code;

    public static DebitResponse valueOf(int id, String code) {
        DebitResponse response = new DebitResponse();
        response.setId(id);
        response.setCode(code);
        return response;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }
}
