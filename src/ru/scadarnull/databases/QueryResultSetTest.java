package ru.scadarnull.databases;

import java.sql.*;

public class QueryResultSetTest { //Униеверсальный обработчик
    public static void main(String[] args) throws SQLException {
        try(Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/world?useUnicode=true&serverTimezone=UTC", "root", "pwd")){
            try(Statement st = connection.createStatement()) {
                try(ResultSet rs = st.executeQuery("SELECT * FROM city LIMIT 10")){
                    ResultSetMetaData meta= rs.getMetaData();
                    for (int i = 1; i <= meta.getColumnCount(); i++) {
                        System.out.printf("%12s", meta.getColumnLabel(i));
                        if(i != meta.getColumnCount()){
                            System.out.print("| ");
                        }
                    }

                    System.out.println("\n-------------------------------------------------------------------------------");
                    while(rs.next()){
                        for (int i = 1; i <= meta.getColumnCount(); i++) {
                            System.out.printf("%12s", String.valueOf(rs.getObject(i)));
                            if(i != meta.getColumnCount()){
                                System.out.print("| ");
                            }
                        }
                        System.out.println("\n-------------------------------------------------------------------------------");
                    }
                }
            }
        }
    }
}
