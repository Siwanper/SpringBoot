package com.swp.springBoot2web.domain;

import org.springframework.data.jpa.repository.JpaRepository;

/**
 * DESCRIPTION：   ${DESCRIPTION}
 *
 * @ProjectName: springBoot2-web
 * @Package: com.swp.springBoot2web.domain
 * @Author: Siwanper
 * @CreateDate: 2018/9/19 下午10:28
 * @Version: 1.0
 * <p>Copyright: Copyright (c) 2018</p>
 */
public interface UserRepository extends JpaRepository<User, Long> {

    User findByUserName(String userName);
    User findByUserNameOrEmail(String userName,String email);

}
