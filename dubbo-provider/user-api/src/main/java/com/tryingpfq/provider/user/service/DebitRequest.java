package com.tryingpfq.provider.user.service;

/**
 * @Author tryingpfq
 * @Date 2020/4/1
 */
public class DebitRequest {
    private int id;

    private int value;

    public static DebitRequest valueOf(int id, int value) {
        DebitRequest request = new DebitRequest();
        request.setId(id);
        request.setValue(value);
        return request;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getValue() {
        return value;
    }

    public void setValue(int value) {
        this.value = value;
    }
}
