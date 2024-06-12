package com.imadiaos.springbootjpa.service.impl;

import com.imadiaos.springbootjpa.data.model.SysUser;
import com.imadiaos.springbootjpa.data.repo.SysUserRepository;
import com.imadiaos.springbootjpa.service.ISysUserService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SysUserServiceImpl implements ISysUserService {

    private final SysUserRepository sysUserRepository;

    public SysUserServiceImpl(SysUserRepository sysUserRepository) {
        this.sysUserRepository = sysUserRepository;
    }

    @Override
    public Page<SysUser> findByPage(Pageable pageable) {
        return sysUserRepository.findAll(pageable);
    }

    @Override
    public List<SysUser> findAll() {
        return sysUserRepository.findAll();
    }

    @Override
    public SysUser findById(String id) {
        return sysUserRepository.findById(id).orElse(null);
    }

    @Override
    public SysUser findByUsername(String username) {
        return sysUserRepository.findByUsername(username).orElse(null);
    }

    @Override
    public SysUser save(SysUser sysUser) {
        return sysUserRepository.save(sysUser);
    }

    @Override
    public SysUser update(SysUser sysUser) {
        if (sysUserRepository.findById(sysUser.getId()).isEmpty()) {
            throw new RuntimeException("未查询到数据");
        }
        return sysUserRepository.save(sysUser);
    }

    @Override
    public void deleteAll(List<String> ids) {
        sysUserRepository.deleteAllById(ids);
    }

    @Override
    public void deleteById(String id) {
        sysUserRepository.deleteById(id);
    }
}
