package com.imadiaos.springbootjpa.data.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Lob;
import lombok.Getter;
import lombok.Setter;

/**
 * 用户实体类
 */
@Getter
@Setter
@Entity(name = "sys_user")
public class SysUser extends BaseEntity {
    /**
     * 用户名
     */
    @Column(unique = true)
    private String username;

    /**
     * 密码
     */
    private String password;

    /**
     * 电话
     */
    private String phone;

    /**
     * 个人介绍
     */
    @Lob
    private String introduce;
}
