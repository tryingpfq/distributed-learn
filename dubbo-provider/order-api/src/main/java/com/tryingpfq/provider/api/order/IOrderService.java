package com.tryingpfq.provider.api.order;

/**
 * @author tryingpfq
 * @date 2020/3/30
 **/
public interface IOrderService {

    OrderResponse order(OrderRequest request);
}
