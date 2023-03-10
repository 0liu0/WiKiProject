package com.liuche.wiki.service;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.liuche.wiki.domain.User;
import com.liuche.wiki.req.UserLoginQueryReq;
import com.liuche.wiki.req.UserPwdSaveReq;
import com.liuche.wiki.req.UserQueryReq;
import com.liuche.wiki.req.UserSaveReq;
import com.liuche.wiki.resp.PageResp;
import com.liuche.wiki.resp.UserLoginQueryResp;
import com.liuche.wiki.resp.UserQueryResp;

public interface UserService {
    User queryById(Long id);

    PageResp<UserQueryResp> selectAll(UserQueryReq req);
    boolean saveUser(UserSaveReq req);
    boolean deleteUser(Long id);
    boolean resetUserPwd(UserPwdSaveReq req);
    UserLoginQueryResp login(UserLoginQueryReq req) throws JsonProcessingException;
}
