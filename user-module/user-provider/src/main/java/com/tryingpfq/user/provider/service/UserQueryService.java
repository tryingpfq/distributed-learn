package com.tryingpfq.user.provider.service;

import com.alibaba.dubbo.common.logger.Logger;
import com.alibaba.dubbo.common.logger.LoggerFactory;
import com.google.common.util.concurrent.RateLimiter;
import com.tryingpfq.user.api.IUserQueryService;
import com.tryingpfq.user.api.dto.UserQueryRequest;
import com.tryingpfq.user.api.dto.UserQueryResponse;
import com.tryingpfq.user.provider.persistence.UserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service("userQueryService")
public class UserQueryService implements IUserQueryService {
    Logger logger= LoggerFactory.getLogger(UserQueryService.class);

    @Autowired
    UserMapper userMapper;

    RateLimiter rateLimiter= RateLimiter.create(2.0);

    public UserQueryResponse getUserById(UserQueryRequest request) {
        UserQueryResponse response=new UserQueryResponse();

        return response;
    }

    private void beforeValidate(UserQueryRequest request){

    }

    public UserQueryResponse getUserByIdWithLimiter(UserQueryRequest request) {
        UserQueryResponse response=new UserQueryResponse();

        return response;
    }
}
