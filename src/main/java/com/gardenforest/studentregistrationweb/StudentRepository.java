package com.gardenforest.studentregistrationweb;

import java.math.BigDecimal;
import java.sql.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class StudentRepository {

    static {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
    }

    public void insert(Student student) {
        try (Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/education",
                "root", "11111111")) {
            PreparedStatement statement = connection.prepareStatement(
                    "insert into students(name, surname, age, scholarship, university_id) values (?,?,?,?,?)");
            statement.setString(1, student.getName());
            statement.setString(2, student.getSurname());
            statement.setInt(3, student.getAge());
            statement.setBigDecimal(4, student.getScholarship());
            statement.setInt(5, student.getUniversityId());

            statement.execute();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void update(Student student) {
        try (Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/education",
                "root", "11111111")) {
            PreparedStatement statement = connection.prepareStatement(
                    "update students set " +
                            " name = ?, " +
                            " surname=?, " +
                            " age=?, " +
                            " scholarship=?, " +
                            " university_id=? " +
                            " where id = ? ");
            statement.setString(1, student.getName());
            statement.setString(2, student.getSurname());
            statement.setInt(3, student.getAge());
            statement.setBigDecimal(4, student.getScholarship());
            statement.setInt(5, student.getUniversityId());
            statement.setInt(6, student.getId());

            statement.execute();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void delete(Integer id) {
        try (Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/education", "root", "11111111")) {//try-with-resources Closeable finally
            PreparedStatement statement = connection.prepareStatement("delete from students where id = ?");
            statement.setInt(1, id);

            statement.execute();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public List<Student> getList() {
        try (Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/education", "root", "11111111")) {//try-with-resources Closeable finally
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery("select * from students");

            List<Student> result = new ArrayList<>();
            while (resultSet.next()) {
                int id = resultSet.getInt("id");
                String name = resultSet.getString("name");
                String surname = resultSet.getString("surname");
                int age = resultSet.getInt("age");
                BigDecimal scholarship = resultSet.getBigDecimal("scholarship");
                int universityId = resultSet.getInt("university_id");

                Student student = new Student(id, name, surname, age, scholarship, universityId);

                result.add(student);
            }
            return result;
        } catch (SQLException e) {
            e.printStackTrace();
            return Collections.emptyList();
        }
    }

    public Student getById(Integer id) {
        try (Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/education", "root", "11111111")) {//try-with-resources Closeable finally
            PreparedStatement statement = connection.prepareStatement("select * from students where id=?");
            statement.setInt(1, id);

            ResultSet resultSet = statement.executeQuery();

            if (resultSet.next()) {
                int studentId = resultSet.getInt("id");
                String name = resultSet.getString("name");
                String surname = resultSet.getString("surname");
                int age = resultSet.getInt("age");
                BigDecimal scholarship = resultSet.getBigDecimal("scholarship");
                int universityId = resultSet.getInt("university_id");

                return new Student(studentId, name, surname, age, scholarship, universityId);
            }
            return null;
        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        }
    }

}
