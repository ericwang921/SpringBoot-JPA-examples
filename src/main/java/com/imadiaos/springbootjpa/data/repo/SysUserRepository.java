package com.imadiaos.springbootjpa.data.repo;

import com.imadiaos.springbootjpa.data.model.SysUser;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface SysUserRepository extends JpaRepository<SysUser, String>, JpaSpecificationExecutor<SysUser> {
    /**
     * 根据username精确查询
     */
    Optional<SysUser> findByUsername(String username);

}
