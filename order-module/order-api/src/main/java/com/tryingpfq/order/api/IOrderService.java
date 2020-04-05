package com.tryingpfq.order.api;

/**
 * @author tryingpfq
 * @date 2020/3/30
 **/
public interface IOrderService {

    OrderResponse order(OrderRequest request);
}
