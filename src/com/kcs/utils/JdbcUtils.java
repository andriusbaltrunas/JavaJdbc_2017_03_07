package com.kcs.utils;

import java.sql.Connection;
import java.sql.DatabaseMetaData;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * Created by andriusbaltrunas on 3/7/2017.
 */
public class JdbcUtils {

    public static boolean isTableExist(Connection connection, String tableName){
        boolean isExist = false;
        try {
            DatabaseMetaData metaData = connection.getMetaData();
            ResultSet resultSet = metaData.getTables(null, null, tableName, null);
            isExist = resultSet.next();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return isExist;
    }
}
