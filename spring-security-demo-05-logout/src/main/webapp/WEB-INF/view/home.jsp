<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<html>
<head>
    <title>luv2code Company Home page</title>
</head>

<body>
    <h2>luv2code Company Home Page</h2>
    <hr>

    <p>
    Welcome to luv2code company Home Page
    </p>

    <!-- Add a logout button -->
    <form:form action="${pageContext.request.contextPath}/logout"
        method="POST">

        <input type="submit" value="LOGOUT" />

    </form:form>

</body>

</html>