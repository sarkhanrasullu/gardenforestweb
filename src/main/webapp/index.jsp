<%@ page import="com.gardenforest.studentregistrationweb.StudentRepository" %>
<%@ page import="com.gardenforest.studentregistrationweb.Student" %>
<%@ page import="java.util.List" %>
<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>

<%
    StudentRepository repository = new StudentRepository();
    List<Student> list = repository.getList();

%>

<!DOCTYPE html>
<html>
    <head>
        <title>JSP - Hello World</title>
        <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.8/dist/css/bootstrap.min.css" rel="stylesheet">
        <script>
            function sayHello() {
                var nameElement = document.getElementById("name");

                alert(nameElement.value);
            }

            function copyText() {
                var nameElement = document.getElementById("name");
                var nameElement2 = document.getElementById("name2");

                nameElement2.value = nameElement.value;
            }
        </script>
    </head>
    <body class="bg-light">

    <div class="container mt-5">

        <div class="card shadow">
            <div class="card-header bg-primary text-white">
                <h3 class="mb-0">Students</h3>
            </div>

            <div class="card-body">

                <table class="table table-striped table-hover align-middle">
                    <thead class="table-dark">
                    <tr>
                        <th>Name</th>
                        <th>Surname</th>
                        <th>Age</th>
                        <th>Actions</th>
                    </tr>
                    </thead>

                    <tbody>

                    <% for (Student student : list) { %>
                    <tr>
                        <td><%= student.getName() %>
                        </td>
                        <td><%= student.getSurname() %>
                        </td>
                        <td><%= student.getAge() %>
                        </td>
                        <td>
                            <button
                                    class="btn btn-warning btn-sm"
                                    onclick="openUpdateModal(
                                            '<%=student.getId()%>',
                                            '<%=student.getName()%>',
                                            '<%=student.getSurname()%>',
                                            '<%=student.getAge()%>',
                                            '<%=student.getScholarship()%>',
                                            '<%=student.getUniversityId()%>')">
                                Update
                            </button>

                            <button
                                    class="btn btn-danger btn-sm"
                                    onclick="openDeleteModal('<%=student.getId()%>')">
                                Delete
                            </button>
                        </td>
                    </tr>
                    <% } %>

                    </tbody>
                </table>
                <button class="btn btn-success mb-3"
                        data-bs-toggle="modal"
                        data-bs-target="#insertModal">
                    Add Student
                </button>

            </div>
        </div>

        <div class="modal fade" id="insertModal">

            <div class="modal-dialog">

                <div class="modal-content">

                    <div class="modal-header">
                        <h5>Add Student</h5>
                        <button class="btn-close" data-bs-dismiss="modal"></button>
                    </div>

                    <div class="modal-body">

                        <input id="insertName" class="form-control mb-2" placeholder="Name">
                        <input id="insertSurname" class="form-control mb-2" placeholder="Surname">
                        <input id="insertAge" class="form-control mb-2" type="number" placeholder="Age">
                        <input id="insertScholarship" class="form-control mb-2" type="number" placeholder="Scholarship">
                        <input id="insertUniversityId" class="form-control" type="number" placeholder="University">

                    </div>

                    <div class="modal-footer">

                        <button class="btn btn-success" onclick="insertStudent()">
                            Save
                        </button>

                    </div>

                </div>

            </div>

        </div>

        <div class="modal fade" id="updateModal">

            <div class="modal-dialog">

                <div class="modal-content">

                    <div class="modal-header">
                        <h5>Update Student</h5>
                        <button class="btn-close" data-bs-dismiss="modal"></button>
                    </div>

                    <div class="modal-body">

                        <input type="hidden" id="updateId">

                        <input id="updateName" class="form-control mb-2">
                        <input id="updateSurname" class="form-control mb-2">
                        <input id="updateAge" class="form-control mb-2" type="number">
                        <input id="updateScholarship" class="form-control mb-2" type="number">
                        <input id="updateUniversityId" class="form-control" type="number">

                    </div>

                    <div class="modal-footer">

                        <button class="btn btn-warning" onclick="updateStudent()">
                            Update
                        </button>

                    </div>

                </div>

            </div>

        </div>

        <div class="modal fade" id="deleteModal">

            <div class="modal-dialog">

                <div class="modal-content">

                    <div class="modal-header">
                        <h5>Delete Student</h5>
                    </div>

                    <div class="modal-body">
                        Delete this student?
                        <input type="hidden" id="deleteId">
                    </div>

                    <div class="modal-footer">

                        <button class="btn btn-secondary"
                                data-bs-dismiss="modal">
                            Cancel
                        </button>

                        <button class="btn btn-danger"
                                onclick="deleteStudent()">
                            Delete
                        </button>

                    </div>

                </div>

            </div>

        </div>

    </div>

    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.7/dist/js/bootstrap.bundle.min.js"></script>

    <script>
        function insertStudent() {

            const form = new URLSearchParams();

            form.append("name", document.getElementById("insertName").value);
            form.append("surname", document.getElementById("insertSurname").value);
            form.append("age", document.getElementById("insertAge").value);
            form.append("scholarship", document.getElementById("insertScholarship").value);
            form.append("universityId", document.getElementById("insertUniversityId").value);

            fetch("students", {
                method: "POST",
                body: form
            }).then(() => location.reload());
        }

        function openUpdateModal(id, name, surname, age, scholarship, universityId) {

            updateId.value = id;
            updateName.value = name;
            updateSurname.value = surname;
            updateAge.value = age;
            updateScholarship.value = scholarship;
            updateUniversityId.value = universityId;

            new bootstrap.Modal(document.getElementById("updateModal")).show();
        }

        function updateStudent() {
            const form = new URLSearchParams();

            form.append("id", updateId.value);
            form.append("name", updateName.value);
            form.append("surname", updateSurname.value);
            form.append("age", updateAge.value);
            form.append("scholarship", updateScholarship.value);
            form.append("universityId", updateUniversityId.value);
            form.append("action", 'update');

            fetch("students", {
                method: "POST",
                body: form
            }).then(() => location.reload());
        }

        function openDeleteModal(id) {

            deleteId.value = id;

            new bootstrap.Modal(document.getElementById("deleteModal")).show();
        }

        function deleteStudent() {

            const form = new URLSearchParams();

            form.append("id", deleteId.value);
            form.append("action", 'delete');

            fetch("students", {
                method: "POST",
                body: form
            }).then(() => location.reload());
        }
    </script>
    </body>
</html>