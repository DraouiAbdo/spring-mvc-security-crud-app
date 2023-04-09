package dz.cut.springmvcsimpleapp.web;

import dz.cut.springmvcsimpleapp.entities.Student;
import dz.cut.springmvcsimpleapp.service.IStudentService;
import dz.cut.springmvcsimpleapp.service.StudentService1;
import lombok.AllArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.validation.Valid;
import java.util.Date;
import java.util.List;

@Controller @AllArgsConstructor
public class StudentController {
    private  IStudentService studentService;

    @GetMapping("/index")
    public String listAllStudent(Model model,
                                 @RequestParam(name="page",defaultValue = "0")int page,
                                 @RequestParam(name="size", defaultValue = "5") int size,
                                 @RequestParam(name="keyword", defaultValue = "") String keyword){

        Page<Student> studentsPage = studentService.findStudentsByNameContains(keyword, PageRequest.of(page,size));
        model.addAttribute("studentsList",studentsPage.getContent());
        model.addAttribute("currentPage",page);
        model.addAttribute("pageSize",size);
        model.addAttribute("keyword",keyword);
        model.addAttribute("pages",new int[studentsPage.getTotalPages()]);


        return "index";
    }


    @PostMapping("/delete")
    public String delete(Model model,
                         @RequestParam() Long id){
        studentService.deleteStudentById(id);
        return "redirect:/index";
    }


    @GetMapping("/create")
    public String create(Model model){
        model.addAttribute("student",new Student());
        return "create";
    }
    @PostMapping(path = "/create")
    public String create(Model model, @Valid Student student, BindingResult bindingResult){
        if(bindingResult.hasErrors()) return "create";
        studentService.addNewStudent(student);
        return "create";
    }

    @GetMapping("/update")
    public String update(Model model, @RequestParam(defaultValue = "0") Long id){

        Student student  = studentService.findStudentById(id);


        model.addAttribute("student",student);
        return "update";

    }


    @PostMapping(path = "/update")
    public String update(Model model, @Valid Student student, BindingResult bindingResult){
        if(bindingResult.hasErrors()) return "update";
        studentService.addNewStudent(student);

        return "redirect:/index";
    }

    @GetMapping("/students")
    @ResponseBody
    public List<Student> listAllStudents(){
        return studentService.findAll();
    }

    @GetMapping("/")
    public String home(){
        return "redirect:/index";
    }
}










