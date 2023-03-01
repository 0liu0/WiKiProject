package com.liuche.wiki.mapper;

import com.liuche.wiki.domain.User;

import java.util.List;

public interface UserMapper {
    List<User> selectAll();
}
