package ru.scadarnull.databases;

import java.sql.*;

public class ResultSetTest {
    public static void main(String[] args) throws SQLException {
        try (Connection c = DriverManager.getConnection("jdbc:mysql://localhost:3306/world?useUnicode=true&serverTimezone=UTC", "root", "pwd")) {
            try (Statement st = c.createStatement()) {
                try (ResultSet rs = st.executeQuery("select * from city WHERE Population > 220000 LIMIT 10")) {
                    while(rs.next()){
                        System.out.println(rs.getInt(1) + ", " + rs.getString(2) + ", " + rs.getLong(5));
                    }
                }
                System.out.println("----------------------------------------------");
                try (ResultSet rs = st.executeQuery("select * from city WHERE id < 20")) {
                    while(rs.next()){
                        System.out.println(rs.getInt(1) + ", " + rs.getString(2) + ", " + rs.getLong(5));
                    }
                }
            }
        }


    }
}
