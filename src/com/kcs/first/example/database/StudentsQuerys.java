package com.kcs.first.example.database;

import com.kcs.first.example.vo.Student;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by andriusbaltrunas on 3/7/2017.
 */
public class StudentsQuerys {

    private Connection connection;

    public StudentsQuerys(Connection connection) {
        this.connection = connection;
        ;
    }

    public List<Student> getStudents() {
        List<Student> students = new ArrayList<>();
        try {
            Statement st = connection.createStatement();
            ResultSet resultSet = st.executeQuery("SELECT * FROM students");
            while (resultSet.next()) {
                //TODO sudeti i list students.add(new Student(........));;
               /* System.out.println("id >> " + resultSet.getInt(1)//stupelio indeksas
                        + " userName >> " + resultSet.getString("name") // stulpelio vardas
                        + " surname >> " + resultSet.getString("surname")
                        + " phone >> " + resultSet.getString(4)
                        + " email >> " + resultSet.getString("email"));*/
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return students;
    }

    public void updateStudentName(int studentId, String name) {

        try {
            Statement statement = connection.createStatement();
            statement.executeUpdate("UPDATE students SET name='" + name + "' WHERE id =" + studentId);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void insertStudent(Student student) {
        try {
            Statement statement = connection.createStatement();
            statement.execute("INSERT INTO students(name, surname, phone, email) VALUES('" + student.getName() + "', '"
                    + student.getSurname() + "', '" + student.getPhone() + "', '" + student.getEmail() + "')");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public boolean isStudentExist(String name, String surName) {
        boolean exist = false;
        try {
            PreparedStatement st = connection.prepareStatement("SELECT * FROM students WHERE name =? AND surname =?");
            st.setString(1, name);
            st.setString(2, surName);
            ResultSet resultSet = st.executeQuery();
            exist = resultSet.next();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return exist;
    }
}
