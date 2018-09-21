package com.swp.springBoot3jpathymleaf.repository;

import com.swp.springBoot3jpathymleaf.entity.User;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.transaction.annotation.Transactional;

/**
 * 描述:
 * 用户repository
 *
 * @version 1.0.0
 * @outhor ios
 * @create 2018-09-21 下午2:30
 */
public interface UserRepository extends JpaRepository<User,Long> {

    User findUserById(Long id);

    // 如果是修改和删除需要添加@Modifying
    // 根据需求添加@Transactional,查询超时时间
    @Modifying
    @Query("update User u set u.username = ?1 where u.id =?2")
    int modifyByIdAndUsername(String username, Long id);

    @Modifying
    @Query("delete from User where id=?1")
    @Transactional
    void deleteById(Long id);

    @Transactional(timeout = 10)
    @Query("select u from User u where username = ?1")
    void findByUsername(String username);
}
