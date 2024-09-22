package com.app.springbootpractice.controller;

import com.app.springbootpractice.model.Student;
import com.app.springbootpractice.model.University;
import com.app.springbootpractice.service.StudentService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@RequiredArgsConstructor
@Controller
@RequestMapping("/student")
public class StudentController {
    private final StudentService studentService;


    @GetMapping("/view")
    public String findAll(Model model) {
        List<Student> students = studentService.findAll();
        model.addAttribute("students", students);
        model.addAttribute("student1", new Student());
        model.addAttribute("flagSave", true);
        return "student/list";
    }

    @PostMapping("/save")
    public String save(@ModelAttribute Student student, Model model) {
        studentService.save(student);
        List<Student> students = studentService.findAll();
        model.addAttribute("message", "Luu thanh cong");
        model.addAttribute("students", students);
        model.addAttribute("student", new Student());
        model.addAttribute("flagSave", true);
        return "student/list";
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
}
