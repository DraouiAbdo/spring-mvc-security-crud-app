package dz.cut.springmvcsimpleapp.service;

import dz.cut.springmvcsimpleapp.entities.Student;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;


public interface IStudentService {
    Student addNewStudent(Student student);
    void deleteStudentById(Long id);
    Student findStudentById(Long id);
    Page<Student> findStudentsByNameContains(String keyword, Pageable page);
    List<Student> findAll();
}
