package org.example.learnservletdatabase;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class AnimalDatabase {

    private Connection conn;
    List<User> users = new ArrayList<>();

    public AnimalDatabase() {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            conn = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/animals", "root", "");
        } catch (ClassNotFoundException | SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public void createAnimal(String name, int age, String specie, String username){
        String sql = "INSERT INTO animallist (name, age, specie, owner) VALUES (?, ?, ?, ?)";

        try {
            PreparedStatement pstmt = conn.prepareStatement(sql);
            pstmt.setString(1, name);
            pstmt.setInt(2, age);
            pstmt.setString(3, specie);
            pstmt.setString(4, username);

            pstmt.execute();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public void updateAnimal(int id, String name, int age, String specie){
        String sql = "UPDATE animallist SET name = ?, age = ?, specie = ? WHERE id = ?";

        try {
            PreparedStatement pstmt = conn.prepareStatement(sql);
            pstmt.setString(1, name);
            pstmt.setInt(2, age);
            pstmt.setString(3, specie);
            pstmt.setInt(4, id);

            pstmt.execute();
            System.out.println("SQL command executed!");
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public void deleteAnimal(int id){
        String sql = "DELETE FROM animallist WHERE id = ?";
        try {
            PreparedStatement pstmt = conn.prepareStatement(sql);
            pstmt.setInt(1, id);
            pstmt.execute();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
    public void createUsers(){

        Statement stmt = null;
        try {
            stmt = conn.createStatement();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

        // Create table
        try {
            stmt.execute("CREATE TABLE IF NOT EXISTS users (id INT(2) AUTO_INCREMENT PRIMARY KEY, name varchar(255), password varchar(32))");
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

        // Truncate table
        try {
            stmt.execute("TRUNCATE TABLE users");
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

        // Insert into table
        try {
            stmt.execute("INSERT INTO users (name, password) VALUES ('Yves', '12345'), ('Eva', '12345'), ('Agnes', '12345'), ('Bert', '12345')");
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }


    }

    public List<User> getAllUsers(){
        String sql = "SELECT name, password FROM users";

        try {
            PreparedStatement pstmt = conn.prepareStatement(sql);
            ResultSet rs = pstmt.executeQuery();

            while(rs.next()) {
                User user = new User();

                user.setName(rs.getString("Name"));
                user.setPassword(rs.getString("Password"));

                users.add(user);
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

        return users;
    }


    public List<Animal> getAll(String username){
        List<Animal> animals = new ArrayList<>();
        String sql = "SELECT id, name, age, specie FROM animalList WHERE owner = ?";

        try {
            PreparedStatement pstmt = conn.prepareStatement(sql);
            pstmt.setString(1, username);
            ResultSet rs = pstmt.executeQuery();

            while(rs.next()) {
                Animal animal = new Animal();

                animal.setId(rs.getInt("id"));
                animal.setName(rs.getString("Name"));
                animal.setAge(rs.getInt("Age"));
                animal.setSpecie(rs.getString("Specie"));

                animals.add(animal);
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

        return animals;
    }
}
