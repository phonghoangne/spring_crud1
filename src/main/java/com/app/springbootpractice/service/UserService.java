package com.app.springbootpractice.service;

import com.app.springbootpractice.model.User;

public interface UserService extends BaseModel<User,Integer> {
    User findByUserName(String name);
    Integer id (String userName);

}
