package com.gardenforest.studentregistrationweb;

import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

@WebServlet(name = "helloServlet", value = "/hello-servlet")
public class HelloServlet extends HttpServlet {

    private final StudentRepository repository = new StudentRepository();

    @Override
    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
        String text = "";
        List<Student> list = repository.getList();
        for(Student student: list) {
            text += student.getName()+" "+student.getSurname()+" "+student.getAge() +"<br/>";
        }

        response.setContentType("text/html");

        PrintWriter out = response.getWriter();
        out.println("<html>" +
                "<body>" +
                    "<h1> Students </h1>" +
                    text+
                "</body>" +
                "</html>");
    }

    @Override
    public void doPut(HttpServletRequest request, HttpServletResponse response) throws IOException {
        response.setContentType("text/html");

        // Hello  GET readonly - select
        PrintWriter out = response.getWriter();
        out.println("<html>" +
                "<body>" +
                "<h1> Hello World! </h1>" +
                "</body>" +
                "</html>");
    }

    @Override
    public void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException {
        response.setContentType("text/html");

        // Hello  GET readonly - select
        PrintWriter out = response.getWriter();
        out.println("<html>" +
                "<body>" +
                "<h1> Hello World! </h1>" +
                "</body>" +
                "</html>");
    }

    @Override
    public void doDelete(HttpServletRequest request, HttpServletResponse response) throws IOException {
        response.setContentType("text/html");

        // Hello  GET readonly - select
        PrintWriter out = response.getWriter();
        out.println("<html>" +
                "<body>" +
                "<h1> Hello World! </h1>" +
                "</body>" +
                "</html>");
    }

    @Override
    public void doPatch(HttpServletRequest request, HttpServletResponse response) throws IOException {
        response.setContentType("text/html");

        // Hello  GET readonly - select
        PrintWriter out = response.getWriter();
        out.println("<html>" +
                "<body>" +
                "<h1> Hello World! </h1>" +
                "</body>" +
                "</html>");
    }

    //HTTP qaydalaridir biz bunlara emel etmeliyik



}