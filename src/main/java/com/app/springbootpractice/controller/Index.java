package com.app.springbootpractice.controller;

import com.app.springbootpractice.model.User;
import com.app.springbootpractice.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Controller
@RequiredArgsConstructor
public class Index {
 private final UserService userService;
    @GetMapping("/index")
    // mpa  dua du lieu qua model
    public String index(Model model){
        List<User> userList = userService.findAll();
        User user  =userService.findById(1);
        model.addAttribute("title","Trang Chủ");
        model.addAttribute("userList",userList);
        model.addAttribute("user",user);

        return "index";
    }
    @GetMapping("/search")
    public String search(Model model , @RequestParam(value="userName",required =false)String userName){
        User user = userService.findByUserName(userName);
        model.addAttribute("user",user);
        return "search";
    }
    @GetMapping("/user/save")
    public String getUser(Model model){
        model.addAttribute("userSave",new User());
        return "curd";
    }
    @PostMapping("/user/save")
    public String postUser(@ModelAttribute("userSave") User user, Model model){
        userService.save(user);
        if(user.getUserId() != null){
            model.addAttribute("successMessage","Luu thanh cong");
            model.addAttribute("saveUser",new User());
        }else{
            model.addAttribute("errorMessage","Luu khong thanh cong");
            model.addAttribute("saveUser",new User());
        }
        return "curd";
    }



}
