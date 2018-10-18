package com.swp.repository;

import com.swp.entity.Visitor;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * 描述:
 * 访问者API
 *
 * @version 1.0.0
 * @outhor ios
 * @create 2018-10-18 11:12 AM
 */
public interface VisitorRepository extends JpaRepository<Visitor, Long> {

    public Visitor findByIp(String ip);

}
