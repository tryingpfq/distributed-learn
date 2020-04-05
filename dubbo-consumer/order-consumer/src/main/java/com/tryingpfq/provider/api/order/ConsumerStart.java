package com.tryingpfq.provider.api.order;

import com.tryingpfq.user.api.DebitRequest;
import com.tryingpfq.user.api.DebitResponse;
import com.tryingpfq.user.api.IUserService;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.io.IOException;

/**
 * @author tryingpfq
 * @date 2020/3/30
 **/
public class ConsumerStart {
    public static void main(String[] args) throws IOException {
        ClassPathXmlApplicationContext context=new ClassPathXmlApplicationContext("spring/applicationDubbo.xml");

        //用户下单过程
        IUserService services=(IUserService)context.getBean("userServices");

        DebitResponse debit = services.debit(new DebitRequest());
        System.err.println(debit.toString());
//        OrderRequest request= new OrderRequest();
//        request.setId(1);
//        request.setName("tryingpfq");
//        OrderResponse response=services.order(request);

//        System.out.println(response);

        //Order.doOrder();
        System.in.read();
    }
}
