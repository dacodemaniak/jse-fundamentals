package fr.aelion.services;

import fr.aelion.helpers.exceptions.StudentException;
import fr.aelion.models.Student;
import fr.aelion.repositories.StudentRepository;

import java.lang.reflect.InvocationTargetException;
import java.sql.SQLException;
import java.util.List;

public class StudentService {
    private StudentRepository studentRepository = new StudentRepository(Student.class);

    public StudentService() throws StudentException {
    }

    public List<Student> findAll() throws SQLException, InvocationTargetException, NoSuchMethodException, InstantiationException, IllegalAccessException {
        return this.studentRepository.findAll();
    }

    public Student findById(int id) throws StudentException, SQLException, InvocationTargetException, NoSuchMethodException, InstantiationException, IllegalAccessException {
        return this.studentRepository.findById(id);
    }

    public Student byLoginAndPassword(String login, String password) throws StudentException, SQLException, InvocationTargetException, NoSuchMethodException, InstantiationException, IllegalAccessException {
        return this.studentRepository.findByLoginAndPassword(login, password);
    }
}
