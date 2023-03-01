package com.liuche.wiki.service.impl;

import com.liuche.wiki.domain.User;
import com.liuche.wiki.mapper.UserMapper;
import com.liuche.wiki.service.UserService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class UserServiceImpl implements UserService {

    @Resource
    private UserMapper userMapper;
    @Override
    public List<User> selectAll() {
        return userMapper.selectAll();
    }
}
