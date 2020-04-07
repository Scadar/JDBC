package ru.scadarnull.databases;

import javax.sql.DataSource;
import javax.xml.crypto.dsig.keyinfo.PGPData;
import java.sql.*;

public class GetConnectionTest {
    public static void main(String[] args) throws SQLException {
        try (Connection c = DriverManager.getConnection("jdbc:mysql://localhost:3306/world?useUnicode=true&serverTimezone=UTC", "root", "pwd")) {
            try (Statement st = c.createStatement()) {
                int result = st.executeUpdate("DELETE FROM city WHERE id = 5");
                System.out.println("Deleted " + result + "row(s)");
            }

            try (PreparedStatement ps = c.prepareStatement("DELETE FROM city WHERE id = ?")) {//параметризированный
                ps.setInt(1, 10);
                int result = ps.executeUpdate();
                System.out.println("Deleted " + result + "row(s)");
            }

            try (Statement st = c.createStatement()) {
                try (ResultSet rs = st.executeQuery("select Name from city")) {
                    //code
                }
            }
        }


    }
}
