**1、spring data jpa介绍**
Spring Data JPA 是 Spring 基于 ORM 框架、JPA 规范的基础上封装的一套JPA应用框架，可使开发者用极简的代码即可实现对数据的访问和操作。它提供了包括增删改查等在内的常用功能，且易于扩展！

**2、基本查询**
1、预先生成方法
    继承JpaRepository
2、自定义简单查询
    自定义的简单查询就是根据方法名来自动生成SQL，主要的语法是findXXBy,readAXXBy,queryXXBy,countXXBy, getXXBy后面跟属性名称 
    也使用一些加一些关键字And、 Or
    修改、删除、统计也是类似语法
    基本上SQL体系中的关键词都可以使用，例如：LIKE、 IgnoreCase、 OrderBy。
    
**3.复杂查询**
在实际的开发中我们需要用到分页、删选、连表等查询的时候就需要特殊的方法或者自定义SQL
1、分页查询
    spring data jpa已经帮我们实现了分页的功能，在查询的方法中，需要传入参数Pageable ,当查询中有多个参数的时候Pageable建议做为最后一个参数传入
   ` Sort sort = new Sort(Direction.DESC, "id");
    Pageable pageable = new PageRequest(page, size, sort);`
2、自定义SQL查询
    在SQL的查询方法上面使用@Query注解，如涉及到删除和修改在需要加上@Modifying.也可以根据需要添加 @Transactional 对事物的支持，查询超时的设置等