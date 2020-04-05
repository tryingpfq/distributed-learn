package com.tryingpfq.user.provider.service;

import com.alibaba.dubbo.common.logger.Logger;
import com.alibaba.dubbo.common.logger.LoggerFactory;
import com.tryingpfq.user.api.IUserCoreService;
import com.tryingpfq.user.api.constants.Constants;
import com.tryingpfq.user.api.constants.ResponseCodeEnum;
import com.tryingpfq.user.api.dto.UserLoginRequest;
import com.tryingpfq.user.api.dto.UserLoginResponse;
import com.tryingpfq.user.api.dto.UserRegisterRequest;
import com.tryingpfq.user.api.dto.UserRegisterResponse;
import com.tryingpfq.user.provider.entity.User;
import com.tryingpfq.user.provider.persistence.UserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DuplicateKeyException;

import java.util.Date;

/**
 * @Author tryingpfq
 * @Date 2020/4/5
 */
public class UserCoreServiceImpl implements IUserCoreService {

    private final Logger logger= LoggerFactory.getLogger(UserCoreServiceImpl.class);

    @Autowired
    UserMapper userMapper;

    @Override
    public UserLoginResponse login(UserLoginRequest userLoginRequest) {
        logger.info("begin UserCoreService.login,request:【"+userLoginRequest+"】");
        UserLoginResponse response=new UserLoginResponse();
        try{

            User user=userMapper.getUserByUserName(userLoginRequest.getUsername());
            if(user==null||!user.getPassword().equals(userLoginRequest.getPassword())){
                response.setCode(ResponseCodeEnum.USER_OR_PASSWORD_ERROR.getCode());
                response.setMsg(ResponseCodeEnum.USER_OR_PASSWORD_ERROR.getMsg());
                return response;
            }
            response.setAvatar(user.getAvatar());
            response.setMobile(user.getMobile());
            response.setRealName(user.getRealname());
            response.setSex(user.getSex());

            response.setCode(ResponseCodeEnum.SYS_SUCCESS.getCode());
            response.setMsg(ResponseCodeEnum.SYS_SUCCESS.getMsg());
            return response;
        }catch(Exception e){
            response.setCode("exception");
            response.setMsg("exception mesg");
        }finally {
            logger.info("login response:【"+response+"】");
        }
        return response;
    }

    @Override
    public UserRegisterResponse register(UserRegisterRequest userRegisterRequest) {
        logger.info("begin UserCoreService.register,request:【"+userRegisterRequest+"】");

        UserRegisterResponse response=new UserRegisterResponse();
        try{
            User user=new User();
            user.setUsername(userRegisterRequest.getUsername());
            user.setPassword(userRegisterRequest.getPassword());
            user.setStatus(Constants.FORZEN_USER_STATUS);
            user.setCreateTime(new Date());

            int effectRow=userMapper.insertSelective(user);
            if(effectRow>0){
                response.setCode(ResponseCodeEnum.SYS_SUCCESS.getCode());
                response.setMsg(ResponseCodeEnum.SYS_SUCCESS.getMsg());
                return  response;
            }
            response.setCode(ResponseCodeEnum.DATA_SAVE_ERROR.getCode());
            response.setMsg(ResponseCodeEnum.DATA_SAVE_ERROR.getMsg());
            return  response;
        }catch (DuplicateKeyException e){

        }catch(Exception e){
            response.setCode("exception");
            response.setMsg("exception mesg");
        }finally {
            logger.info("register response:【"+response+"】");
        }
        return response;
    }
}
