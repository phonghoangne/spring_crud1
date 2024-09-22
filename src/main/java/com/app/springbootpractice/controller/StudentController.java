package com.app.springbootpractice.controller;

import com.app.springbootpractice.model.Student;
import com.app.springbootpractice.model.University;
import com.app.springbootpractice.service.StudentService;
import com.app.springbootpractice.service.UniversityService;
import com.app.springbootpractice.service.impl.StudentService1Impl;
import com.app.springbootpractice.service.impl.StudentServiceImpl;
import com.app.springbootpractice.ultil.Helper;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;

@RequiredArgsConstructor
@Controller
@RequestMapping("/student")
public class StudentController {

    @Autowired
    @Qualifier("studentServiceImpl")
    private StudentService studentService;

    private final Helper helper;

    private  final UniversityService universityService;

    @GetMapping("/view")
    public String findAll(Model model) {
        List<Student> students = studentService.findAll();
        model.addAttribute("students", students);
        model.addAttribute("student", new Student());
        model.addAttribute("flagSave", true);
        model.addAttribute("university",universityService.findAll());
        return "student/list";
    }

    @PostMapping("/save")
    public String save(@ModelAttribute(name = "student") Student student, Model model) {
//        Path upLoad = Paths.get("src/uploads");
//        helper.saveImage(file,upLoad);
//        student.setImage(file.getOriginalFilename());
        studentService.save(student);
        List<Student> students = studentService.findAll();
        model.addAttribute("message", "Luu thanh cong");
        model.addAttribute("students", students);
        model.addAttribute("student", new Student());
        model.addAttribute("flagSave", true);
        return "redirect:/student/view";
    }

    @GetMapping("/edit/{id}")
    public String edit(@PathVariable Integer id, Model model) {
        List<Student> student1 = studentService.findAll();
        model.addAttribute("students", student1);
        model.addAttribute("student1", studentService.findById(id));
        model.addAttribute("flagSave", true);
        return "student/list";
    }

    @PostMapping("/edit/{id}")
    public String update(@PathVariable Integer id, Model model, @ModelAttribute Student student) {
        List<Student> student1 = studentService.findAll();
        model.addAttribute("student", student1);
        model.addAttribute("flagSave", true);
        //update

        student.setId(id);
        studentService.save(student);
        model.addAttribute("message", "Update thanh cong");
        model.addAttribute("student", new Student());
        return "redirect:/student/view";
    }


    @GetMapping("/delete/{id}")
    public String delete(@PathVariable Integer id, Model model) {
        List<Student> student1 = studentService.findAll();
        model.addAttribute("student", student1);
        //update
        studentService.delete(id);
        model.addAttribute("message", "Xoa thanh cong");
        model.addAttribute("student", new Student());
        return "redirect:/student/view";
    }

    @GetMapping("/hello")
    public String hello(Model model)
    {
        model.addAttribute("hello",studentService.testBean());
        return "student/test";
    }

    @PostMapping("/saveImage")
            public String saveImage ( Model model
            , @RequestParam("image")MultipartFile file)
    {  Path upLoad = Paths.get("src/uploads");
        helper.saveImage(file,upLoad);
        return "redirect:/student/view";
    }
}
