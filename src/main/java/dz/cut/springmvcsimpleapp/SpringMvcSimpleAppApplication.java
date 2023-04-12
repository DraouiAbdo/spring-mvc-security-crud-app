package dz.cut.springmvcsimpleapp;

import dz.cut.springmvcsimpleapp.entities.Student;
import dz.cut.springmvcsimpleapp.service.IStudentService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.Date;
import java.util.stream.Stream;

@SpringBootApplication
public class SpringMvcSimpleAppApplication {

    public static void main(String[] args) {
        SpringApplication.run(SpringMvcSimpleAppApplication.class, args);
    }

    // SpringMvcSimpleAppApplication.java
    @Bean
    CommandLineRunner commandLineRunner(IStudentService studentService){
        return args -> {


            Student s1 = new Student(null,"Nasro",new Date(),true,50);
            Student s2 = new Student(null,"Omar",new Date(),false,20);
            Student s3 = new Student(null,"Youcef",new Date(),true,80);
            Student s4 = new Student(null,"Amine",new Date(),true,50);
            Student s5 = new Student(null,"Khaled",new Date(),false,20);
            Student s6 = new Student(null,"Aicha",new Date(),true,80);

            studentService.addNewStudent(s1);
            studentService.addNewStudent(s2);
            studentService.addNewStudent(s3);
            studentService.addNewStudent(s4);
            studentService.addNewStudent(s5);
            studentService.addNewStudent(s6);

//            Student s4 = studentService.findStudentByNameContains("ma");
//            System.out.println(s4.getName()+" rank is "+s4.getRank());

//            Student s5 = studentService.findStudentById(2L);
//            s5.setName("khaled");
//            studentService.addNewStudent(s5);



        };
    }
}
