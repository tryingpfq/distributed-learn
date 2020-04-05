package com.tryingpfq.order.api;

import java.io.Serializable;

/**
 * @author tryingpfq
 * @date 2020/3/30
 **/
public class OrderRequest implements Serializable {
    private int id;

    private String name;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "OrderRequest{" +
                "id=" + id +
                ", name='" + name + '\'' +
                '}';
    }
}
