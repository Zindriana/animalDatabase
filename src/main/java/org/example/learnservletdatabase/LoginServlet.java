package org.example.learnservletdatabase;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;

@WebServlet("/Login")
public class LoginServlet extends HttpServlet {

    private AnimalDatabase animalDatabase = new AnimalDatabase();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.sendRedirect("/LearnServletDatabase_war_exploded/ListOfAnimals");
        /*animalDatabase.createUsers();
        List<User> users = animalDatabase.getAllUsers();
        PrintWriter out = resp.getWriter();

        for (User user: users){
            out.println(user.getName());
        }*/
    }

}
