package com.tryingpfq.user.api;

import com.tryingpfq.user.api.dto.UserQueryRequest;
import com.tryingpfq.user.api.dto.UserQueryResponse;


public interface IUserQueryService {


    /**
     * 根据用户id来查询用户信息
     * @param request
     * @return
     */
    UserQueryResponse getUserById(UserQueryRequest request);

    /**
     * 根据用户id来查询用户信息
     * @param request
     * @return
     */
    UserQueryResponse getUserByIdWithLimiter(UserQueryRequest request);
}
