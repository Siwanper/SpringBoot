package com.swp.springbootshiro.entity;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;

/**
 * 描述:
 * 权限
 *
 * @version 1.0.0
 * @outhor ios
 * @create 2018-10-07 10:20 AM
 */
@Entity
public class SysPermission implements Serializable {
    private static final long serialVersionUID = 5679989579293174307L;
    @Id
    @GeneratedValue
    private Integer id;
    private String name;
    @Column(columnDefinition = "enum('menu','button')")
    private String resourceType; // 资源类型 【menu|button】
    private String url; // 资源路径
    private String permission; // 权限字符串,menu例子：role:*,button例子:role:create,role:update,role:delete,role:view
    private Long parentId; // 父编号
    private String parentIds; // 父编号列表
    private Boolean available = Boolean.FALSE; // 是否有效

    @ManyToMany
    @JoinTable(name = "SysRolePermission", joinColumns = { @JoinColumn(name = "permissionId")} , inverseJoinColumns = { @JoinColumn(name = "roleId")})
    private List<SysRole> roles;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getResourceType() {
        return resourceType;
    }

    public void setResourceType(String resourceType) {
        this.resourceType = resourceType;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getPermission() {
        return permission;
    }

    public void setPermission(String permission) {
        this.permission = permission;
    }

    public Long getParentId() {
        return parentId;
    }

    public void setParentId(Long parentId) {
        this.parentId = parentId;
    }

    public String getParentIds() {
        return parentIds;
    }

    public void setParentIds(String parentIds) {
        this.parentIds = parentIds;
    }

    public Boolean getAvailable() {
        return available;
    }

    public void setAvailable(Boolean available) {
        this.available = available;
    }

    public List<SysRole> getRoles() {
        return roles;
    }

    public void setRoles(List<SysRole> roles) {
        this.roles = roles;
    }
}
