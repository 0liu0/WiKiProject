package com.liuche.wiki.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.liuche.wiki.domain.User;
import com.liuche.wiki.mapper.UserMapper;
import com.liuche.wiki.req.UserQueryReq;
import com.liuche.wiki.req.UserSaveReq;
import com.liuche.wiki.resp.UserQueryResp;
import com.liuche.wiki.resp.PageResp;
import com.liuche.wiki.service.UserService;
import com.liuche.wiki.utils.CopyUtil;
import com.liuche.wiki.utils.SnowFlake;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.ObjectUtils;

import java.util.List;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserMapper userMapper;
    @Autowired
    private SnowFlake snowFlake;
    @Override
    public User queryById(Long id) {
        return userMapper.queryById(id);
    }


    @Override
    public PageResp<UserQueryResp> selectAll(UserQueryReq req) {
        List<User> users; // 返回的数据
        String name = req.getLoginName();
        if (!ObjectUtils.isEmpty(name)){
            name = "%" + name + "%";
            req.setLoginName(name);
            PageHelper.startPage(req.getPage(), req.getSize()); // TODO 如果都没有的话就是不做分页
            users = userMapper.selectAll(req);
        }else {
            PageHelper.startPage(req.getPage(), req.getSize());
            users = userMapper.selectAll1();
        }
        PageInfo<User> p = new PageInfo<>(users); // 得到mysql中这些数据的信息
        List<UserQueryResp> userQueryResp = CopyUtil.copyList(users, UserQueryResp.class); // 转化
        PageResp<UserQueryResp> pageResp = new PageResp<>(); // 定义返回的信息
        pageResp.setList(userQueryResp); // 将users装入pageResp中
        pageResp.setTotal(p.getTotal()); // 将数据库总量装入返回值中
        return pageResp;
    }

    @Override
    public boolean saveUser(UserSaveReq req) {
        try {
            User user = CopyUtil.copy(req, User.class);
            if (!ObjectUtils.isEmpty(user.getId())){
                userMapper.saveUser(user);
            }else { // 执行新增的逻辑
                user.setId(snowFlake.nextId());
                userMapper.saveUser2(user);
            }
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    @Override
    public boolean deleteUser(Long id) {
        try {
            userMapper.deleteUser(id);
            return true;
        } catch (Exception e) {
            return false;
        }
    }
}
