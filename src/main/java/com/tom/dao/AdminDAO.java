package com.tom.dao;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.tom.entity.pojo.Admin;
import com.tom.entity.pojo.User;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;


/**
 * @Author BeiChen
 * @Date 2021/8/12 0:49
 * @Version 1.0
 */
@Repository
public interface AdminDAO extends BaseMapper<Admin> {
    /**
     * 通过Uid查询该用户所有信息
     * @param uid
     * @return
     */
    @Select("SELECT * FROM tb_admin WHERE uid = #{uid}")
    Admin SearchByUid(@Param("uid") String uid);
}
