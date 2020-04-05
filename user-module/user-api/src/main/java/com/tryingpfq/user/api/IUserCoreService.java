package com.tryingpfq.user.api;

import com.tryingpfq.user.api.dto.UserLoginRequest;
import com.tryingpfq.user.api.dto.UserLoginResponse;
import com.tryingpfq.user.api.dto.UserRegisterRequest;
import com.tryingpfq.user.api.dto.UserRegisterResponse;

/**
 * 腾讯课堂搜索 咕泡学院
 * 加群获取视频：608583947
 * 风骚的Michael 老师
 */
public interface IUserCoreService {

    /**
     * 用户登录操作
     * @param userLoginRequest
     * @return
     */
    UserLoginResponse login(UserLoginRequest userLoginRequest);


    /*
     * 注册
     */
    UserRegisterResponse register(UserRegisterRequest userRegisterRequest);
}
