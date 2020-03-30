package com.tryingpfq.provider.order.service;

import com.tryingpfq.provider.api.order.IOrderService;
import com.tryingpfq.provider.api.order.OrderRequest;
import com.tryingpfq.provider.api.order.OrderResponse;

/**
 * @author tryingpfq
 * @date 2020/3/30
 **/
public class OrderServiceImpl implements IOrderService {
    public OrderResponse order(OrderRequest request) {
        System.out.println("request is come:" + request.toString());
        OrderResponse response = new OrderResponse();
        response.setResp("response");
        return response;
    }
}
