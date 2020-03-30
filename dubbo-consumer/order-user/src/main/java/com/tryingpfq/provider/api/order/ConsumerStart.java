package com.tryingpfq.provider.api.order;

import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.io.IOException;

/**
 * @author tryingpfq
 * @date 2020/3/30
 **/
public class ConsumerStart {
    public static void main(String[] args) throws IOException {
        ClassPathXmlApplicationContext context=new ClassPathXmlApplicationContext("order-consumer.xml");

        //用户下单过程
        IOrderService services=(IOrderService)context.getBean("orderService");

        OrderRequest request= new OrderRequest();
        request.setId(1);
        request.setName("tryingpfq");
        OrderResponse response=services.order(request);

        System.out.println(response);

        //Order.doOrder();
        System.in.read();
    }
}
