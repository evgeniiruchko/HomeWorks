package ru.geekbrains.spring.services;

import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.webjars.NotFoundException;
import ru.geekbrains.spring.entities.Student;
import ru.geekbrains.spring.repositories.StudentRepository;

import java.util.List;

@Service
@RequiredArgsConstructor
public class StudentService {

    private final StudentRepository studentRepository;

    public Student getStudentById(Long id) {
        return studentRepository.findById(id).orElseThrow(() -> new NotFoundException("Не найдено"));
    }

    @ExceptionHandler
    public ResponseEntity<Void> handleNotFoundException(NotFoundException e) {
        return ResponseEntity.notFound().build();
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
