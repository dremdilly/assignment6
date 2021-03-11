package com.company.singleton;

import java.sql.*;

public class Database {
    private static Connection con;
    private Database() {
        String connectionUrl = "jdbc:postgresql://localhost:5432/assignment6";
        try {
            Class.forName("org.postgresql.Driver");

            con = DriverManager.getConnection(connectionUrl, "postgres", "1234demo");
        } catch (Exception e) {
            System.out.println(e);
        }
    }

    private static class DatabaseHolder {
        public static final Database instance = new Database();
    }

    public static Database getInstance() {
        return DatabaseHolder.instance;
    }

    public void query(String sql) {
        try {
            Statement st = con.createStatement();

            ResultSet rs = st.executeQuery(sql);

            if(rs.next()) {
                System.out.println(rs.getString("id"));
                System.out.println(rs.getString("name"));
                System.out.println(rs.getString("surname"));
                if(rs.getString("gender") == "t") {
                    System.out.println("Male");
                } else {
                    System.out.println("Female");
                }
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        } finally {
            try {
                con.close();
            } catch (SQLException throwables) {
                throwables.printStackTrace();
            }
        }
    }
}

class Application {
    public static void main(String[] args) {
        Database foo = Database.getInstance();
        foo.query("SELECT id,name,surname,gender FROM users");

        Database bar = Database.getInstance();
        bar.query("SELECT id,name,surname,gender FROM users");
    }
}