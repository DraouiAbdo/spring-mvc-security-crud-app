package dz.cut.springmvcsimpleapp.service;

import dz.cut.springmvcsimpleapp.entities.Student;
import dz.cut.springmvcsimpleapp.repositories.StudentRepository;
import lombok.AllArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service @Transactional @AllArgsConstructor
public class StudentService1 implements IStudentService {
    StudentRepository studentRepository;
    @Override
    public Student addNewStudent(Student student) {
        return studentRepository.save(student);
    }

    @Override
    public void deleteStudentById(Long id) {
        studentRepository.deleteById(id);
    }

    @Override
    public Student findStudentById(Long id) {
        return studentRepository.findStudentById(id);
    }

    @Override
    public Page<Student> findStudentsByNameContains(String keyword, Pageable pageable) {
        return studentRepository.findStudentByNameContains(keyword,pageable );
    }

    @Override
    public List<Student> findAll() {
        return studentRepository.findAll();
    }
}
