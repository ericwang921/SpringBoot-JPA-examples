package com.imadiaos.springbootjpa.service;

import com.imadiaos.springbootjpa.data.model.SysUser;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface ISysUserService {
    /**
     * 分页查询用户信息
     * @param pageable 分页参数
     * @return 分页结果
     */
    Page<SysUser> findByPage(SysUser user, Pageable pageable);

    List<SysUser> findAll();

    SysUser findById(String id);

    SysUser findByUsername(String username);

    SysUser save(SysUser user);

    SysUser update(SysUser user);

    void deleteAll(List<String> ids);

    void deleteById(String id);

}
