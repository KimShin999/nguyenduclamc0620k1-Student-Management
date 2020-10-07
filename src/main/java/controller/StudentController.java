package controller;

import model.Student;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import service.StudentService;
import service.StudentServiceImpl;

import java.util.List;

@Controller
public class StudentController {
    private StudentService studentService = new StudentServiceImpl();

    @GetMapping("/")
    public String index(Model model){
        List<Student> studentList = studentService.findAll();
        model.addAttribute("students",studentList);
        return "/index";
    }

    @GetMapping("/students/create")
    public String create(Model model) {
        model.addAttribute("students", new Student());
        return "/create";
    }

    @PostMapping("/students/save")
    public String save(Student student, RedirectAttributes redirect) {
        student.setId((int)(Math.random() * 10000));
        studentService.save(student);
        redirect.addFlashAttribute("ketqua", "Saved customer successfully!");
        return "redirect:/";
    }

    @GetMapping("/students/{id}/edit")
    public String edit(@PathVariable int id, Model model) {
        model.addAttribute("students", studentService.findById(id));
        return "/edit";
    }

    @PostMapping("/students/update")
    public String update(Student students, RedirectAttributes redirect) {
        studentService.update(students.getId(), students);
        redirect.addFlashAttribute("success", "Modified customer successfully!");
        return "redirect:/";
    }

    @GetMapping("/students/{id}/delete")
    public String delete(@PathVariable int id, Model model) {
        model.addAttribute("students", studentService.findById(id));
        return "/delete";
    }

    @PostMapping("/students/delete")
    public String delete(Student student, RedirectAttributes redirect) {
        studentService.remove(student.getId());
        redirect.addFlashAttribute("success", "Removed customer successfully!");
        return "redirect:/";
    }

    @GetMapping("/students/{id}/view")
    public String view(@PathVariable int id, Model model) {
        model.addAttribute("students", studentService.findById(id));
        return "/view";
    }
}
