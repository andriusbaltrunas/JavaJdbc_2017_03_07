package com.kcs.first.example;

import com.kcs.first.example.database.StudentsQuerys;
import com.kcs.utils.JdbcUtils;

import java.sql.*;

/**
 * Created by andriusbaltrunas on 3/7/2017.
 */
public class MyFirstConnectionExample {

    public static void main(String[] args) {

        try {
            Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/kcs", "root", "MySQL");

            if (connection != null){
                System.out.println("CONNECTED!!!!");
                StudentsQuerys studentsQuerys = new StudentsQuerys(connection);
                studentsQuerys.getStudents();
                System.out.println("is table exist >> " + JdbcUtils.isTableExist(connection, "students"));
                studentsQuerys.updateStudentName(3, "Jokubas");

                System.out.println("is student exist >> " + studentsQuerys.isStudentExist("Andrius", "Baltrunas"));
            }
        } catch (SQLException e) {
            System.out.println("Connection to db fail " + e);
        }

    }


}
