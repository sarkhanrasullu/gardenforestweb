<%@ page import="com.gardenforest.studentregistrationweb.StudentRepository" %>
<%@ page import="com.gardenforest.studentregistrationweb.Student" %>
<%@ page import="java.util.List" %>
<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>

<%
    StudentRepository repository = new StudentRepository();
    Student student = repository.getById(Integer.parseInt(request.getParameter("id")));

%>

<!DOCTYPE html>
<html>
<head>
    <title>Update Student</title>

    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.7/dist/css/bootstrap.min.css" rel="stylesheet">


</head>

<body class="bg-light">

<div class="container mt-5">

    <div class="row justify-content-center">

        <div class="col-md-6">

            <div class="card shadow">

                <div class="card-header bg-warning">
                    <h3 class="mb-0 text-center">Update Student</h3>
                </div>

                <div class="card-body">

                    <form method="POST" action="students">

                        <div class="mb-3">
                            <label class="form-label">Name</label>
                            <input type="text"
                                   name="name"
                                   class="form-control"
                                   value="<%=student.getName()%>">
                        </div>

                        <div class="mb-3">
                            <label class="form-label">Surname</label>
                            <input type="text"
                                   name="surname"
                                   class="form-control"
                                   value="<%=student.getSurname()%>">
                        </div>

                        <div class="mb-3">
                            <label class="form-label">Age</label>
                            <input type="number"
                                   name="age"
                                   class="form-control"
                                   value="<%=student.getAge()%>">
                        </div>

                        <div class="mb-3">
                            <label class="form-label">Scholarship</label>
                            <input type="number"
                                   name="scholarship"
                                   class="form-control"
                                   value="<%=student.getScholarship()%>">
                        </div>

                        <div class="mb-3">
                            <label class="form-label">University ID</label>
                            <input type="number"
                                   name="universityId"
                                   class="form-control"
                                   value="<%=student.getUniversityId()%>">
                        </div>

                        <input type="hidden" name="id" value="<%=student.getId()%>">
                        <input type="hidden" name="action" value="update">

                        <button type="submit" class="btn btn-warning">
                            Update Student
                        </button>

                        <a href="index.jsp" class="btn btn-secondary">
                            Back
                        </a>

                    </form>

                </div>

            </div>

        </div>

    </div>

</div>

</body>
</html>