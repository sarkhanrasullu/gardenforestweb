<%@ page import="com.gardenforest.studentregistrationweb.StudentRepository" %>
<%@ page import="com.gardenforest.studentregistrationweb.Student" %>
<%@ page import="java.util.List" %>
<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>

<%
    StudentRepository repository = new StudentRepository();
    String text = "";
    List<Student> list = repository.getList();
    for(Student student: list) {
        text += student.getName()+" "+student.getSurname()+" "+student.getAge() +"<br/>";
    }
%>

<!DOCTYPE html>
<html>
    <head>
        <title>JSP - Hello World</title>
    </head>
    <body>
        <h1> Students </h1>
        <%=text%>
    </body>
</html>