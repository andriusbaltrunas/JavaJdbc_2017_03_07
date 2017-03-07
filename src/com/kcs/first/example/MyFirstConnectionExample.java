package com.kcs.first.example;

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
                getStudents(connection);
            }
        } catch (SQLException e) {
            System.out.println("Connection to db fail " + e);
        }

    }

    private static void getStudents(Connection connection){
        try {
            Statement st = connection.createStatement();
            ResultSet resultSet = st.executeQuery("SELECT * FROM students");
            while (resultSet.next()){
                System.out.println("id >> " + resultSet.getInt(1)//stupelio indeksas
                        + " userName >> " + resultSet.getString("name") // stulpelio vardas
                        + " surname >> " + resultSet.getString("surname")
                        + " phone >> " + resultSet.getString(4)
                        + " email >> " + resultSet.getString("email"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
