package com.tryingpfq.user.provider.service;

import com.tryingpfq.user.api.DebitRequest;
import com.tryingpfq.user.api.DebitResponse;
import com.tryingpfq.user.api.IUserService;
import org.springframework.stereotype.Service;

/**
 * @Author tryingpfq
 * @Date 2020/4/1
 */
@Service(value = "userService")
public class UserServiceImpl implements IUserService {
    @Override
    public DebitResponse debit(DebitRequest request) {
        DebitResponse response = DebitResponse.valueOf(1, "123");
        return response;
    }
}
