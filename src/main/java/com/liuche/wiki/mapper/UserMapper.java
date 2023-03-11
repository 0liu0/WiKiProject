package com.liuche.wiki.mapper;

import com.liuche.wiki.domain.User;
import com.liuche.wiki.req.UserQueryReq;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface UserMapper {
    /**
     * 通过ID查询单条数据
     *
     * @param id 主键
     * @return 实例对象
     */
    User queryById(Long id);

    List<User> selectAll(UserQueryReq req);
    List<User> selectAll1();
    void saveUser(User req);
    void deleteUser(@Param("id") Long id);
    void saveUser2(User req);
}
