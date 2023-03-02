package fr.aelion.services;

import fr.aelion.helpers.exceptions.StudentException;
import fr.aelion.models.Student;
import fr.aelion.repositories.StudentRepository;

import java.sql.SQLException;
import java.util.List;

public class StudentService {
    private StudentRepository studentRepository = new StudentRepository();

    public StudentService() throws StudentException {
    }

    public List<Student> findAll() throws SQLException {
        return this.studentRepository.findAll();
    }

    public Student findById(int id) throws StudentException, SQLException {
        return this.studentRepository.find(id);
    }

    public Student byLoginAndPassword(String login, String password) throws StudentException, SQLException {
        return this.studentRepository.findByLoginAndPassword(login, password);
    }
}
