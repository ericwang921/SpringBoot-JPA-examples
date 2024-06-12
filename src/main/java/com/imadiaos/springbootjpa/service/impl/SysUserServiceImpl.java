package com.imadiaos.springbootjpa.service.impl;

import cn.hutool.core.util.StrUtil;
import com.imadiaos.springbootjpa.data.model.SysUser;
import com.imadiaos.springbootjpa.data.repo.SysUserRepository;
import com.imadiaos.springbootjpa.service.ISysUserService;
import jakarta.persistence.criteria.Predicate;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class SysUserServiceImpl implements ISysUserService {

    private final SysUserRepository sysUserRepository;

    public SysUserServiceImpl(SysUserRepository sysUserRepository) {
        this.sysUserRepository = sysUserRepository;
    }

    @Override
    public Page<SysUser> findByPage(SysUser user, Pageable pageable) {
        Specification<SysUser> spec = (root, query, criteriaBuilder) -> {
            List<Predicate> predicates = new ArrayList<>();
            if (StrUtil.isNotBlank(user.getUsername())) {
                predicates.add(criteriaBuilder.like(root.get("username"), "%" + user.getUsername() + "%"));
            }
            if (StrUtil.isNotBlank(user.getPhone())) {
                predicates.add(criteriaBuilder.equal(root.get("phone"), user.getPhone()));
            }
            return criteriaBuilder.and(predicates.toArray(new Predicate[0]));
        };
        return sysUserRepository.findAll(spec, pageable);
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
    public SysUser save(SysUser user) {
        return sysUserRepository.save(user);
    }

    @Override
    public SysUser update(SysUser user) {
        if (sysUserRepository.findById(user.getId()).isEmpty()) {
            throw new RuntimeException("未查询到数据");
        }
        return sysUserRepository.save(user);
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
