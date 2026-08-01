<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Delete Student</title>

    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.7/dist/css/bootstrap.min.css"
          rel="stylesheet">
</head>

<body class="bg-light">

<div class="container mt-5">

    <div class="row justify-content-center">

        <div class="col-md-5">

            <div class="card shadow">

                <div class="card-header bg-danger text-white text-center">
                    <h4 class="mb-0">Delete Student</h4>
                </div>

                <div class="card-body text-center">

                    <p class="fs-5">
                        Are you sure you want to delete this student?
                    </p>

                    <form method="POST" action="students">

                        <input type="hidden" name="id"
                               value="<%=request.getParameter("id")%>">

                        <input type="hidden" name="action"
                               value="delete">

                        <button type="submit" class="btn btn-danger">
                            Delete
                        </button>

                        <a href="index.jsp" class="btn btn-secondary">
                            Cancel
                        </a>

                    </form>

                </div>

            </div>

        </div>

    </div>

</div>

</body>
</html>