package org.example.learnservletdatabase;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

@WebServlet("/ListOfAnimals/*")
public class AnimalServlet extends HttpServlet {

    private AnimalDatabase animalDatabase = new AnimalDatabase();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        List<Animal> animals = animalDatabase.getAll();
        resp.setContentType("text/html");
        PrintWriter out = resp.getWriter();

        for (Animal animal: animals){
            out.println("<br>" + animal.getId() + ") " + animal.getName() + " " + animal.getAge() + " " + animal.getSpecie());
        }

        out.println("<form action=\"animalAdd.jsp\" method=\"post\">");
        out.println("<input type=\"submit\" value=\"Add animal\">");
        out.println("</form>");

        out.println("<form action=\"animalUpdate.jsp\" method=\"post\">");
        out.println("<input type=\"submit\" value=\"Update animal\">");
        out.println("</form>");

        out.println("<form action=\"animalDelete.jsp\" method=\"post\">");
        out.println("<input type=\"submit\" value=\"Delete animal\">");
        out.println("</form>");
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
            HttpSession session = req.getSession(true);
            switch (req.getPathInfo()) {
            case "/": create(req, resp); break;
            case "/animalUpdate": update(req, resp); break;
            case "/animalDelete": delete(req, resp); break;
        }
            //String username = (String) session.getAttribute("username");

    }
    private void create(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException{
        String name = req.getParameter("name");
        int age = Integer.parseInt(req.getParameter("age"));
        String specie = req.getParameter("specie");

        animalDatabase.createAnimal(name, age, specie);

        resp.sendRedirect(req.getContextPath() + req.getServletPath());
    }

    private void update(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException{
        int id = Integer.parseInt(req.getParameter("id"));
        String name = req.getParameter("name");
        int age = Integer.parseInt(req.getParameter("age"));
        String specie = req.getParameter("specie");

        animalDatabase.updateAnimal(id, name, age, specie);

        resp.sendRedirect(req.getContextPath() + req.getServletPath());
    }

    private void delete(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        int id = Integer.parseInt(req.getParameter("id"));
        animalDatabase.deleteAnimal(id);
        resp.sendRedirect(req.getContextPath() + req.getServletPath());
    }
}