package com.springboot.hello.controller;

import com.springboot.hello.User;
import com.springboot.hello.dao.UserDao;
import com.springboot.hello.domian.dto.UserRequestDto;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1")
public class UserController {
    private final UserDao userDao;

    public UserController(UserDao userDao) {
        this.userDao = userDao;
    }

    @PostMapping("/user")
    public User addAndselect(@RequestBody UserRequestDto userRequestDto){
        User user = (new User(userRequestDto.getId(),userRequestDto.getName(),userRequestDto.getPassword()));
        userDao.add(user);
        return userDao.select(user.getId());
    }

    @DeleteMapping("user/deleteAll")
    public void deleteAll(){
        userDao.deleteAll();
    }

}
