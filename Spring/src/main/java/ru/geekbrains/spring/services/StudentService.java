package ru.geekbrains.spring.services;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import ru.geekbrains.spring.entities.Student;
import ru.geekbrains.spring.repositories.StudentRepository;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class StudentService {

    private final StudentRepository studentRepository;

    public Student getStudentById(Long id) {
        return studentRepository.getById(id);
    }

    public List<Student> getAllStudents() {
        return studentRepository.findAll();
    }

    public void deleteById(Long id) {
        studentRepository.deleteById(id);
    }

    public Student saveStudent(Student student) {
        return studentRepository.save(student);
    }

    public Student updateStudent(Student student) {
        Student studentFromDB = getStudentById(student.getId());
        if (studentFromDB != null) {
            studentFromDB.setMark(student.getMark());
            studentFromDB.setName(student.getName());
            return studentRepository.save(studentFromDB);
        }
        return null;
    }
}
