package fr.aelion.repositories;

import fr.aelion.dbal.DbConnect;
import fr.aelion.dbal.postgres.PgConnect;
import fr.aelion.helpers.builders.students.StudentBuilder;
import fr.aelion.helpers.exceptions.StudentException;
import fr.aelion.models.Student;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class StudentRepository {

    /**
     * Connection Instance to our RDBMS
     */
    private DbConnect dbConnect;

    public StudentRepository() throws StudentException {
        this.dbConnect = PgConnect.getInstance();
    }

    /**
     *
     * @return List of Students of our DB
     */
    public List<Student> findAll() throws SQLException {
        ArrayList<Student> students = new ArrayList<>();

        // Need a SQL Query
        String sqlQuery = "SELECT id, last_name, first_name, email, phone_number, login, password ";
        sqlQuery += "FROM student ORDER BY last_name, first_name;";
        // SELECT id, last_name, first_name, email, phone_number, login, password FROM student ORDER BY last_name, first_name;
        // Send sqlQuery to RDBMS => Need to create a Statement object
        Connection connection = this.dbConnect.connect();
        Statement statement = connection.createStatement();
        ResultSet resultSet = statement.executeQuery(sqlQuery);

        // Exploit the ResultSet object => Loop over a cursor
        while (resultSet.next()) {
            Student student = new Student();

            student.setId(resultSet.getInt(1));
            student.setLastName(resultSet.getString("last_name"));
            student.setFirstName(resultSet.getString("first_name"));
            student.setEmail(resultSet.getString("email"));
            student.setPhoneNumber(resultSet.getString("phone_number"));
            student.setUsername(resultSet.getString("login"));
            student.setPassword(resultSet.getString("password"));

            // Add brand new Student object to the ArrayList
            students.add(student);

        }
        // Free resources
        statement.close();
        resultSet.close();
        this.dbConnect.disconnect();

        // Finally return students list
        return students;
    }
    public Student findByLoginAndPassword(String login, String password) {
        return null;
    }

}
