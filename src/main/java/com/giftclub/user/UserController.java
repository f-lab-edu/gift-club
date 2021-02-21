package com.giftclub.user;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/user")
public class UserController {
    @Autowired
    private UserMapper userMapper;

    @PostMapping("")
    public User post(@RequestBody User user) {
        userMapper.insert(user);
        return user;
    }

    @GetMapping("")
    public List<User> getAll() {
        return userMapper.getAll();
    }

    @GetMapping("/{id}")
    public User getById(@PathVariable("id") int id) {
        return userMapper.getById(id);
    }
}
