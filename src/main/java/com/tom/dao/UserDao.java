package com.tom.dao;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.tom.entity.pojo.User;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;
import org.springframework.stereotype.Repository;

/**
 * @Author BeiChen
 * @Date 2021/8/11 11:42
 * @Version 1.0
 */
@Repository
public interface UserDao extends BaseMapper<User> {

    /**
     * 登录时通过用户名获取用户全部信息
     * @param loginName 用户登录时获得的用户名
     * @return 返回查询到的user
     */
    @Select("SELECT * FROM tb_user WHERE username = #{loginName}")
    User UserLogin(@Param("loginName") String loginName);

    /**
     * 更新角色
     * @param user User的实例化对象
     */
    @Update("UPDATE tb_user SET role = #{user.role} WHERE uid = #{user.uid}")
    int updateRole(@Param("user")User user);

    /**
     * 通过用户id查询用户角色
     *
     * @param uid 用户id
     * @return 用户角色
     */
    @Select("SELECT * FROM tb_user WHERE uid = #{uid}")
    User selectById(@Param("uid") String uid);

}
