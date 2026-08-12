package com.gardenforest.studentregistrationweb;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.math.BigDecimal;
import java.util.List;

@WebServlet(name = "studentsServlet", value = "/students")
public class StudentServlet extends HttpServlet {


    private final StudentRepository repository = new StudentRepository();


    @Override
    public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        List<StudentEntity> list = repository.getList();

        request.setAttribute("studentList", list);

        request.getRequestDispatcher("index.jsp").forward(request, response);
    }

    @Override
    public void doPut(HttpServletRequest request, HttpServletResponse response) throws IOException {
        request.getSession().setAttribute("user", request.getParameter("name"));

        StudentEntity student = new StudentEntity();
        student.setId(Integer.parseInt(request.getParameter("id")));
        student.setName(request.getParameter("name"));
        student.setSurname(request.getParameter("surname"));
        student.setAge(Integer.parseInt(request.getParameter("age")));
        student.setScholarship(new BigDecimal(request.getParameter("scholarship")));
        student.setUniversityId(Integer.parseInt(request.getParameter("universityId")));

        repository.update(student);
    }

    @Override
    public void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException {
        if (request.getParameter("action").equals("delete")) {
            doDelete(request, response);
            return;
        } else if (request.getParameter("action").equals("update")) {
            doPut(request, response);
            return;
        }

        StudentEntity student = new StudentEntity();
        student.setName(request.getParameter("name"));
        student.setSurname(request.getParameter("surname"));
        student.setAge(Integer.parseInt(request.getParameter("age")));
        student.setScholarship(new BigDecimal(request.getParameter("scholarship")));
        student.setUniversityId(Integer.parseInt(request.getParameter("universityId")));

        repository.insert(student);

        response.sendRedirect("index.jsp");
    }

    @Override
    public void doDelete(HttpServletRequest request, HttpServletResponse response) throws IOException {
        repository.delete(Integer.parseInt(request.getParameter("id")));
    }

}