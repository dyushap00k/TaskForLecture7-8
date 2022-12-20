<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Registration</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css" rel="stylesheet"
          integrity="sha384-EVSTQN3/azprG1Anm3QDgpJLIm9Nao0Yz1ztcQTwFspd3yD65VohhpuuCOmLASjC" crossorigin="anonymous">
    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap-icons@1.5.0/font/bootstrap-icons.css">
</head>


<body>
<div class="container-fluid vh-100" style="margin-top:100px">
    <div class="" style="margin-top:50px">
        <div class="rounded d-flex justify-content-center">
            <div class="col-md-4 col-sm-12 shadow-lg p-5 bg-light">
                <div class="text-center">
                    <h3 class="text-primary">Registration</h3>
                </div>
                <form action="${pageContext.request.contextPath}/registration" method="post">
                    <div class="p-4">
                        <div class="input-group mb-3">
                                    <span class="input-group-text bg-primary">
                                        <i class="bi bi-person-plus-fill text-white"></i></span>
                            <input type="text" class="form-control" placeholder="Name" name="name">
                        </div>
                        <div class="input-group mb-3">
                                    <span class="input-group-text bg-primary">
                                        <i class="bi bi-person-plus-fill text-white"></i></span>
                            <input type="text" class="form-control" placeholder="Username" name="login">
                        </div>
                        <div class="input-group mb-3">
                                    <span class="input-group-text bg-primary">
                                        <i class="bi bi-key-fill text-white"></i></span>
                            <input type="password" class="form-control" placeholder="password" name="password">
                        </div>
                        <button class="btn btn-primary text-center mt-2" type="submit">
                            Create an account
                        </button>
                        <p class="text-center mt-5">Already have an account? <a
                                href="${pageContext.request.contextPath}/login">Click here.</a></p>
                        <c:if test="${isAlreadyUsedLogin}">
                            <p class="text-center mt-5"><font color="red">This login already used</font>
                            </p>
                        </c:if>
                        <c:if test="${incorrect_input}">
                            <p class="text-center mt-5"><font color="red">Name, login and password must not contain spaces</font>
                            <p class="text-center mt-5"><font color="red">Login must contain more than 6 chars</font>
                            <p class="text-center mt-5"><font color="red">Password must contain more than 8 chars</font>
                            </p>
                        </c:if>
                    </div>
                </form>
            </div>
        </div>
    </div>
</div>
</body>
</html>

