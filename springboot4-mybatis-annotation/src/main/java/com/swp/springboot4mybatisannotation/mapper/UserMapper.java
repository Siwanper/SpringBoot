package com.swp.springboot4mybatisannotation.mapper;

import com.swp.springboot4mybatisannotation.entity.User;
import com.swp.springboot4mybatisannotation.enums.UserSexEnum;
import org.apache.ibatis.annotations.*;

import java.util.List;

/**
 * 描述:
 * 用户Mapper
 *
 * @version 1.0.0
 * @outhor ios
 * @create 2018-09-25 上午10:52
 */
public interface UserMapper {

    @Select("SELECT * FROM users")
    @Results({
            @Result(column = "nick_name",property = "nickName"),
            @Result(column = "user_sex",property = "userSex",javaType = UserSexEnum.class)
    })
    public List<User> findAll();

    @Select("SELECT * FROM users WHERE id = #{id}")
    @Results({
            @Result(column = "nick_name",property = "nickName"),
            @Result(column = "user_sex",property = "userSex",javaType = UserSexEnum.class)
    })
    public User findUserById(Long id);

    @Insert("INSERT INTO users(userName, passWord, nick_name, user_sex) VALUES(#{userName}, #{passWord}, #{nickName}, #{userSex})")
    public void insertUser(User user);

    @Update("UPDATE users SET userName = #{userName}, passWord = #{passWord}, nick_name = #{nickName}, user_sex = #{userSex} WHERE id = #{id}")
    public void updateUser(User user);

    @Delete("DELETE FROM users WHERE id = #{id}")
    public void deleteUserById(Long id);
}
