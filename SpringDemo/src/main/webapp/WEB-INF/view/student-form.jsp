<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page isELIgnored="false"%>
<!DOCTYPE html>
<html>
<head>
    <title>Student Registration Form</title>
</head>

<body>
    <form:form action="processForm" modelAttribute="student">
        First name: <form:input path="firstName" />
        <br><br>
        Last name: <form:input path="lastName" />
        <br><br>
        Country:
        <form:select path="country">
            <form:options items="${student.countryOptions}" />
        </form:select>
        <br><br>

        Favorite Language:
        <form:radiobutton path="favoriteLanguage" value="Java" />Java
        <form:radiobutton path="favoriteLanguage" value="C#" />C#
        <form:radiobutton path="favoriteLanguage" value="PHP" />PHP
        <form:radiobutton path="favoriteLanguage" value="Ruby" />Ruby

        <br><br>

        Operating Systems:
        Linux <form:checkbox path="operatingSystems" value="Linux" />
        MacOS <form:checkbox path="operatingSystems" value="MacOS" />
        MSWindows <form:checkbox path="operatingSystems" value="MSWindows" />
        <br><br>
        <input type="submit" value="Submit" />

    </form:form>


</body>

</html>