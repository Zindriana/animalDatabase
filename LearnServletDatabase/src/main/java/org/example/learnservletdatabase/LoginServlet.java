package org.example.learnservletdatabase;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

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
    List<User> users = animalDatabase.getAllUsers();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //resp.sendRedirect("/LearnServletDatabase_war_exploded/ListOfAnimals");
        HttpSession session = req.getSession(true);
        animalDatabase.createUsers();
        users = animalDatabase.getAllUsers();
        PrintWriter out = resp.getWriter();

        for (User user: users){
            out.println(user.getName());
        }

    }

    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws IOException, ServletException {
        HttpSession session = req.getSession(true);
        String username = req.getParameter("name");
        String password = req.getParameter("password");
        PrintWriter out = resp.getWriter();
        out.println("usertest: " + username);

        for(User user: users){
          if (user.getName() == null) {
              req.getRequestDispatcher("/register.jsp").forward(req, resp);
          } else if(user.getName().equals(username) && user.getPassword().equals(password)) { // användaren fanns och rätt lössenord angavs
              session = req.getSession(true);
            session.setAttribute("name", username);
              out.println("usertest: " + username);

            resp.sendRedirect("/LearnServletDatabase_war_exploded/ListOfAnimals/");
              //req.getRequestDispatcher("/ListOfAnimals/").forward(req, resp);
          } else { // användaren fanns men fel lösenord
              out.println("passtest: " + password);
            //resp.sendRedirect("/login.jsp?error=invalid%20login");
          }
    }
}}
