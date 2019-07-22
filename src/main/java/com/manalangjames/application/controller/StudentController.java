package com.manalangjames.application.controller;

import com.manalangjames.application.entity.Student;
import com.manalangjames.application.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
public class StudentController {

    private final StudentService studentService;

    @Autowired
    public StudentController(StudentService studentService) {
        this.studentService = studentService;
    }

    @GetMapping("/")
    public String indexPage(Model model) {
        List<Student> students = studentService.findAll();
        Student student = new Student();
        model.addAttribute("listOfStudents", students);
        model.addAttribute("student", student);
        return "index";
    }

    @GetMapping("/edit/{id}")
    public ModelAndView editStudent(@PathVariable(value = "id") Integer id) {
        ModelAndView mav = new ModelAndView("edit-student");
        Student student = studentService.findById(id);
        mav.addObject(student);
        return mav;
    }

    @PostMapping("/save")
    public String saveStudent(@ModelAttribute("student") Student student) {
        studentService.save(student);
        return "redirect:/";
    }

    @GetMapping("/delete/{id}")
    public String deleteStudent(@PathVariable("id") Integer id) {
        studentService.deleteById(id);
        return "redirect:/";
    }

}
