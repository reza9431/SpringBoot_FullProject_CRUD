package net.fullproject.spring_fullproject.Controller;

import net.fullproject.spring_fullproject.Entity.Student;
import net.fullproject.spring_fullproject.Repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@Controller
@RequestMapping("/students/")
public class StudentController {


    private  StudentRepository studentRepository;

    @Autowired
    public StudentController(StudentRepository studentRepository) {
        this.studentRepository = studentRepository;
    }

    @GetMapping("signup")
    public String showSignUpForm(Student student) {
        return "add-student";
    }

    @GetMapping("list")

    public String showUpdateForm(Model model) {
        model.addAttribute("students", studentRepository.findAll());
        return "index";
    }

    @PostMapping("add")
    public String addStudent(@Valid Student student, BindingResult result, Model model) {
        if (result.hasErrors()) {
            return "add-student";
        }

        studentRepository.save(student);
        return "redirect:list";
    }

    @GetMapping("edit/{id}")
    public String showUpdateForm(@PathVariable("id") long id, Model model) {
        Student student = studentRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Invalid student Id:" + id));
        model.addAttribute("student", student);
        return "update-student";
    }

    @PostMapping("update/{id}")
    public String updateStudent(@PathVariable("id") long id, @Valid Student student, BindingResult result,
                                Model model) {
        if (result.hasErrors()) {
            student.setId(id);
            return "update-student";
        }

        studentRepository.save(student);
        model.addAttribute("students", studentRepository.findAll());
        return "index";
    }

    @GetMapping("delete/{id}")
    public String deleteStudent(@PathVariable("id") long id, Model model) {
        Student student = studentRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Invalid student Id:" + id));
        studentRepository.delete(student);
        model.addAttribute("students", studentRepository.findAll());
        return "index";
    }

}