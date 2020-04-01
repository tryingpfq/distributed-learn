package com.tryingpfq.provider.user.service;

import org.springframework.stereotype.Service;

/**
 * @Author tryingpfq
 * @Date 2020/4/1
 */
@Service
public class UserServiceImpl implements IUserService {
    @Override
    public DebitResponse debit(DebitRequest request) {
        DebitResponse response = DebitResponse.valueOf(1, "123");
        return response;
    }
}
