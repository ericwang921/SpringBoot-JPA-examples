package com.imadiaos.springbootjpa.controller;

import com.imadiaos.springbootjpa.data.model.SysUser;
import com.imadiaos.springbootjpa.service.ISysUserService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("user")
public class UserController {

    private final ISysUserService userService;

    public UserController(ISysUserService userService) {
        this.userService = userService;
    }

    @GetMapping("getAllUser")
    public List<SysUser> getALlUser(){
        return userService.findAll();
    }

    @PostMapping("save")
    public SysUser saveUser(@RequestBody SysUser user){
        return userService.save(user);
    }

    @GetMapping("getUser")
    public SysUser getUser(String id){
        return userService.findById(id);
    }

    @PutMapping("update")
    public SysUser updateUser(@RequestBody SysUser user){
        return userService.update(user);
    }
}
