package dz.cut.springmvcsimpleapp.repositories;

import dz.cut.springmvcsimpleapp.entities.Student;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

// StudentRepository.java
public interface StudentRepository extends JpaRepository<Student,Long> {
    Student findStudentById(Long id);
    Page<Student> findStudentByNameContains(String kw, Pageable pageable);
}
