package fr.aelion.repositories;

import fr.aelion.dbal.DbConnect;
import fr.aelion.dbal.postgres.PgConnect;
import fr.aelion.helpers.exceptions.StudentException;
import fr.aelion.models.Student;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class StudentRepository extends Repository<Student> {

    /**
     * Connection Instance to our RDBMS
     */
    private DbConnect dbConnect;

    public StudentRepository(Class<Student> className) throws StudentException {
        super(className); // Ref to Parent constructor
        this.dbConnect = PgConnect.getInstance();
    }


    /**
     *
     * @return List of Students of our DB
     */
    public List<Student> findAll() throws SQLException {
        ArrayList<Student> students = new ArrayList<>();

        // Need a SQL Query
        String sqlQuery = getSelectQuery().substring(0, getSelectQuery().length() - 1) + " ORDER BY last_name, first_name";

        // SELECT id, last_name, first_name, email, phone_number, login, password FROM student ORDER BY last_name, first_name;
        // Send sqlQuery to RDBMS => Need to create a Statement object
        Connection connection = this.dbConnect.connect();
        Statement statement = connection.createStatement();
        ResultSet resultSet = statement.executeQuery(sqlQuery);

        // Exploit the ResultSet object => Loop over a cursor
        while (resultSet.next()) {
            Student student = new Student();

            student.setId(resultSet.getInt("id"));
            student.setFirstName(resultSet.getString("first_name"));
            student.setLastName(resultSet.getString("last_name"));
            student.setEmail(resultSet.getString("email"));
            student.setPhoneNumber(resultSet.getString("phone_number"));
            student.setLogin(resultSet.getString("login"));
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
    public Student findByLoginAndPassword(String login, String password) throws SQLException, StudentException {
        Connection connection = dbConnect.connect();
        // Need a SQL Query
        String sqlQuery =  getSelectQuery().substring(0, getSelectQuery().length() - 1) + " WHERE login = ? AND password = ?;";

        PreparedStatement preparedStatement = connection.prepareStatement(sqlQuery);
        preparedStatement.setString(1, login);
        preparedStatement.setString(2, password);

        ResultSet resultSet = preparedStatement.executeQuery();

        if (resultSet.next()) {
            Student student = new Student();

            student.setId(resultSet.getInt("id"));
            student.setLastName(resultSet.getString("last_name"));
            student.setFirstName(resultSet.getString("first_name"));
            student.setEmail(resultSet.getString("email"));
            student.setPhoneNumber(resultSet.getString("phone_number"));
            student.setLogin(resultSet.getString("login"));
            student.setPassword(resultSet.getString("password"));

            preparedStatement.close();
            resultSet.close();
            this.dbConnect.disconnect();

            return student;
        }
        preparedStatement.close();
        resultSet.close();
        this.dbConnect.disconnect();
        throw StudentException.studentNotFoundException();
    }

    public Student find(int id) throws SQLException, StudentException {
        Connection connection = dbConnect.connect();
        // Need a SQL Query
        String sqlQuery = getSelectQuery().substring(0, getSelectQuery().length() - 1) + " WHERE id = ?;";

        PreparedStatement preparedStatement = connection.prepareStatement(sqlQuery);
        preparedStatement.setInt(1, id);

        ResultSet resultSet = preparedStatement.executeQuery();
        Cursor cursor = new Cursor();
        cursor.setResultSet(resultSet);


        if (resultSet.next()) {
            Student student = new Student();

            student.setId(resultSet.getInt("id"));
            student.setLastName(resultSet.getString("last_name"));
            student.setFirstName(resultSet.getString("first_name"));
            student.setEmail(resultSet.getString("email"));
            student.setPhoneNumber(resultSet.getString("phone_number"));
            student.setLogin(resultSet.getString("login"));
            student.setPassword(resultSet.getString("password"));

            preparedStatement.close();
            resultSet.close();
            this.dbConnect.disconnect();

            return student;
        }
        preparedStatement.close();
        resultSet.close();
        this.dbConnect.disconnect();
        throw StudentException.studentNotFoundException();

    }

    public Student byLoginAndPassword(String login, String password) throws SQLException, StudentException {
        ArrayList<Student> students = new ArrayList<>();

        // Need a SQL Query
        String sqlQuery = "SELECT id, last_name, first_name, email, phone_number, login, password ";
        sqlQuery += "FROM student ORDER BY login, password;";
        // Send sqlQuery to RDBMS => Need to create a Statement object
        Connection connection = this.dbConnect.connect();
        Statement statement = connection.createStatement();
        ResultSet resultSet = statement.executeQuery(sqlQuery);

        // Exploit the ResultSet object => Loop over a cursor
        while (resultSet.next()) {
            if(login.equals(resultSet.getString("login")) && password.equals(resultSet.getString("password"))) {
                Student student = new Student();

                student.setId(resultSet.getInt(1));
                student.setLastName(resultSet.getString("last_name"));
                student.setFirstName(resultSet.getString("first_name"));
                student.setEmail(resultSet.getString("email"));
                student.setPhoneNumber(resultSet.getString("phone_number"));
                student.setLogin(resultSet.getString("login"));
                student.setPassword(resultSet.getString("password"));

                return student;
            }
        }
        // Free resources
        statement.close();
        resultSet.close();
        this.dbConnect.disconnect();

        // Finally return students list
        throw StudentException.studentNotFoundException();
    }

}

/**
 * Récupérer la liste de tous les Student
 * Pour chaque Student
 *  Si le login et le password sont égaux à ceux que je trouve dans la base => ok
 *      construire le Student
 *      retourner le Student
 *  Sinon
 *      Lever une exception NotFound
 */
