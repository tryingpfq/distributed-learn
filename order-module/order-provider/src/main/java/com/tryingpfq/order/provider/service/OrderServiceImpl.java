package com.tryingpfq.order.provider.service;

import com.tryingpfq.order.api.IOrderService;
import com.tryingpfq.order.api.OrderRequest;
import com.tryingpfq.order.api.OrderResponse;
import com.tryingpfq.user.api.DebitRequest;
import com.tryingpfq.user.api.DebitResponse;
import com.tryingpfq.user.api.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.jta.JtaTransactionManager;

import javax.transaction.SystemException;
import javax.transaction.UserTransaction;

/**
 * @author tryingpfq
 * @date 2020/3/30
 **/
@Service(value = "orderService")
public class OrderServiceImpl implements IOrderService {
    @Autowired
    JtaTransactionManager springTransactionManager;

    @Autowired
    IUserService userServices;

    public OrderResponse order(OrderRequest request) {
        System.err.println(request.toString());
        OrderResponse response=new OrderResponse();
        //order下单后调用user更新余额
        UserTransaction userTransaction=springTransactionManager.getUserTransaction();
        DebitResponse debitResponse = null;
        try {
            userTransaction.begin();
           // orderDao.insertOrder();
            debitResponse= userServices.debit( DebitRequest.valueOf(1,100));
            userTransaction.commit();
        }catch(Exception e){
            try {
                userTransaction.rollback();
            } catch (SystemException e1) {
                e1.printStackTrace();
            }
        }
        response.setResp(debitResponse.getCode());
        return response;
    }
}
