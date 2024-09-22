package com.app.springbootpractice.controller;

import com.app.springbootpractice.model.University;
import com.app.springbootpractice.service.UniversityService;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.thymeleaf.model.IModel;

import java.util.List;

@RequiredArgsConstructor
@Controller
@RequestMapping("/university")
public class UniversityController {
    private final UniversityService universitySevice;
    @GetMapping("/view")
    public String findAll(Model model){
        List<University> universities = universitySevice.findAll();
        model.addAttribute("universities",universities);
        model.addAttribute("university", new University());
        model.addAttribute("flagSave",true);
        return "universities/list";
    }

    @PostMapping("/save")
    public String save(@ModelAttribute University university,Model model){
        universitySevice.save(university);
        List<University> universities = universitySevice.findAll();
        model.addAttribute("message", "Luu thanh cong");
        model.addAttribute("universities",universities);
        model.addAttribute("university",new University());
        model.addAttribute("flagSave",true);
        return "universities/list";
    }

    @GetMapping("/edit/{id}")
    public String edit(@PathVariable Integer id ,Model model){
        List<University> universities = universitySevice.findAll();
        model.addAttribute("universities",universities);
        model.addAttribute("university",universitySevice.findById(id));
        model.addAttribute("flagUpdate",true);
        return "universities/list";
    }
    @PostMapping("/edit/{id}")
    public String update(@PathVariable Integer id,Model model,@ModelAttribute University university){
        List<University> universities = universitySevice.findAll();
        model.addAttribute("universities",universities);
        model.addAttribute("flagUpdate",true);
        // update
        university.setId(id);
        universitySevice.save(university);
        model.addAttribute("message","Update thanh cong");
        model.addAttribute("university", new University());
        return "redirect:/university/view";
    }
    @GetMapping("/delete/{id}")
    public String delete(@PathVariable Integer id,Model model){
        List<University> universities = universitySevice.findAll();
        model.addAttribute("universities",universities);
        // update
        universitySevice.delete(id);
        model.addAttribute("message","Xoa thanh cong");
        model.addAttribute("university", new University());
        return "redirect:/university/view";
    }
}
