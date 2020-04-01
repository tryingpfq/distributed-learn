package com.tryingpfq.provider.order.service;

import com.alibaba.dubbo.config.annotation.Service;
import com.tryingpfq.provider.api.order.IOrderService;
import com.tryingpfq.provider.api.order.OrderRequest;
import com.tryingpfq.provider.api.order.OrderResponse;
import com.tryingpfq.provider.user.service.DebitRequest;
import com.tryingpfq.provider.user.service.DebitResponse;
import com.tryingpfq.provider.user.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.jta.JtaTransactionManager;

import javax.transaction.SystemException;
import javax.transaction.UserTransaction;

/**
 * @author tryingpfq
 * @date 2020/3/30
 **/
@Service
public class OrderServiceImpl implements IOrderService {
    @Autowired
    JtaTransactionManager springTransactionManager;

    @Autowired
    IUserService userService;

    public OrderResponse order(OrderRequest request) {
        OrderResponse response=new OrderResponse();
        //order下单后调用user更新余额
        UserTransaction userTransaction=springTransactionManager.getUserTransaction();
        DebitResponse debitResponse = null;
        try {
            userTransaction.begin();
           // orderDao.insertOrder();
            debitResponse= userService.debit( DebitRequest.valueOf(1,100));
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
