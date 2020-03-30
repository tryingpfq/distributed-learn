package com.tryingpfq.provider.api.order;

import java.io.Serializable;

/**
 * @author tryingpfq
 * @date 2020/3/30
 **/
public class OrderResponse implements Serializable {
    private String resp;

    public String getResp() {
        return resp;
    }

    public void setResp(String resp) {
        this.resp = resp;
    }
}
