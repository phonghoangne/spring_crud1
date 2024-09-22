package com.app.springbootpractice.service.impl;

import com.app.springbootpractice.model.User;
import com.app.springbootpractice.repostory.UserRepository;
import com.app.springbootpractice.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.yaml.snakeyaml.events.Event;

import java.util.List;

import static org.springframework.data.jpa.domain.AbstractPersistable_.id;

@Service   //@Service Đánh dấu một Class là tầng Service, phục vụ các logic nghiệp vụ.
@RequiredArgsConstructor // su dung cai nay thay vi autowire nhung phai khai bao  private final
public class UserServiceimpl implements UserService {
    // DI userRepo -> UserService
//    @Autowired
  private final  UserRepository userRepository;
    @Override
    public List<User> findAll() {
        List<User> listUser = userRepository.findAll(); // ket noi voi database
        return listUser;
    }


    @Override
    public User save(User user) {
       User userSave =     userRepository.save(user);
        return userSave;
    }

    @Override
    public User update(User integer) {
        return null;
    }

    @Override
    public void delete(Integer integer) {

    }

    @Override
    public User findById(Integer id) {
        User user =userRepository.findById(id).orElse(new User());
        return user;

    }

    @Override
    public User findByUserName(String userName) {
        return userRepository.findByUserName(userName).orElse(null);

    }

    @Override
    public Integer id(String userName) {
        return userRepository.getIdByUserName(userName);
    }
}
