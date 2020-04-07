package ru.scadarnull.databases;

import java.sql.*;

public class DMLTest {
    public static void main(String[] args) throws SQLException {
        try (Connection c = DriverManager.getConnection("jdbc:mysql://localhost:3306/world?useUnicode=true&serverTimezone=UTC", "root", "pwd")) {
            try(PreparedStatement ps = c.prepareStatement("INSERT INTO city (Name, CountryCode, District, Population) VALUES(?, ?, ?, ?)")){
                ps.setString(1, "QWE");
                ps.setString(2, "AFG");
                ps.setString(3, "asd");
                ps.setLong(4, 42132);
                int inserted = ps.executeUpdate();
                System.out.println("inserted = " + inserted + " row");
            }
            try(PreparedStatement ps = c.prepareStatement("UPDATE city SET Name=?,CountryCode=?,District=?,Population=? WHERE id = 1")){
                ps.setString(1, "QWE");
                ps.setString(2, "AFG");
                ps.setString(3, "asd");
                ps.setLong(4, 42132);
                int updated = ps.executeUpdate();
                System.out.println("updated = " + updated + " row");
            }
            try(PreparedStatement ps = c.prepareStatement("DELETE FROM city WHERE id=?")){
                ps.setInt(1, 4);
                int deleted = ps.executeUpdate();
                System.out.println("deleted = " + deleted + " row");
            }
        }
    }
}
