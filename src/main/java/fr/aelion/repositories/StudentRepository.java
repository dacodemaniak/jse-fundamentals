package fr.aelion.repositories;

import fr.aelion.dbal.DbConnect;
import fr.aelion.dbal.builder.QueryBuilder;
import fr.aelion.dbal.mapper.EntityMapper;
import fr.aelion.dbal.postgres.PgConnect;
import fr.aelion.dbal.repositories.Repository;
import fr.aelion.helpers.exceptions.StudentException;
import fr.aelion.models.Student;

import java.lang.reflect.InvocationTargetException;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class StudentRepository extends Repository<Student> {

    /**
     * Connection Instance to our RDBMS
     */
    private DbConnect dbConnect;
    private EntityMapper entityMapper;

    private QueryBuilder queryBuilder;

    public StudentRepository(Class<Student> className) throws StudentException {
        super(className); // Ref to Parent constructor
        this.dbConnect = PgConnect.getInstance();
        entityMapper = new EntityMapper(className);
    }


    /**
     *
     * @return List of Students of our DB
     */
    public List<Student> findAll() throws SQLException, InvocationTargetException, NoSuchMethodException, IllegalAccessException, InstantiationException {
        ArrayList<Student> students = new ArrayList<>();

        queryBuilder = new QueryBuilder(this);
        queryBuilder
                .select()
                .order("lastName")
                .order("firstName");
        // Need a SQL Query
        String sqlQuery = queryBuilder.build();

        // Send sqlQuery to RDBMS => Need to create a Statement object
        Connection connection = this.dbConnect.connect();
        Statement statement = connection.createStatement();
        ResultSet resultSet = statement.executeQuery(sqlQuery);

        // Exploit the ResultSet object => Loop over a cursor
        while (resultSet.next()) {
            // Add brand new Student object to the ArrayList
            students.add((Student) entityMapper.map(resultSet));
        }
        // Free resources
        statement.close();
        resultSet.close();
        this.dbConnect.disconnect();

        // Finally return students list
        return students;
    }
    public Student findByLoginAndPassword(String login, String password) throws SQLException, StudentException, InvocationTargetException, NoSuchMethodException, InstantiationException, IllegalAccessException {
        Connection connection = dbConnect.connect();
        // Need a SQL Query
        queryBuilder = new QueryBuilder(this);
        queryBuilder
                .select()
                .where("login")
                .andWhere("password");
        // Need a SQL Query
        String sqlQuery = queryBuilder.build();

        PreparedStatement preparedStatement = connection.prepareStatement(sqlQuery);
        preparedStatement.setString(1, login);
        preparedStatement.setString(2, password);

        ResultSet resultSet = preparedStatement.executeQuery();

        if (resultSet.next()) {
            Student student = (Student) entityMapper.map(resultSet);

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

    public Student findById(int id) throws StudentException, InvocationTargetException, NoSuchMethodException, InstantiationException, IllegalAccessException, SQLException {
        Connection connection = dbConnect.connect();
        // Need a SQL Query
        queryBuilder = new QueryBuilder(this);
        queryBuilder
                .select()
                .where("id");
        // Need a SQL Query
        String sqlQuery = queryBuilder.build();

        PreparedStatement preparedStatement = connection.prepareStatement(sqlQuery);
        preparedStatement.setInt(1, id);

        ResultSet resultSet = preparedStatement.executeQuery();
        Cursor cursor = new Cursor();
        cursor.setResultSet(resultSet);


        if (resultSet.next()) {
            Student student = (Student) entityMapper.map(resultSet);

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

    public Student byLoginAndPassword(String login, String password) throws SQLException, StudentException, InvocationTargetException, NoSuchMethodException, InstantiationException, IllegalAccessException {
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
                Student student = (Student) entityMapper.map(resultSet);

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
