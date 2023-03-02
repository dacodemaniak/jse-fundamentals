package fr.aelion.controllers;

import fr.aelion.annotations.Controller;
import fr.aelion.annotations.RequestMapping;
import fr.aelion.helpers.exceptions.StudentException;
import fr.aelion.models.Student;
import fr.aelion.services.StudentService;

import java.util.List;

@Controller
public class StudentController extends fr.aelion.controllers.Controller {
    private StudentService service = new StudentService();

    public StudentController() throws StudentException {
    }

    @RequestMapping(
           path="api/v1/student",
            method="GET"
    )
    public void findAll() {
        try {
            List<Student> students = service.findAll();
            StringBuilder builder = new StringBuilder();
            for (Student student : students) {
                builder
                        .append(student.getId())
                        .append("|")
                        .append(student.getLastName())
                        .append("|")
                        .append(student.getFirstName())
                        .append("\n");
            }
            System.out.println(builder.toString());
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

    }
}
