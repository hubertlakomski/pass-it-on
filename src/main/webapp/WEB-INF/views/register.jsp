<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix = "fmt" uri = "http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<!DOCTYPE html>
<html lang="pl">
<head>
    <meta charset="UTF-8" />
    <meta name="viewport" content="width=device-width, initial-scale=1.0" />
    <meta http-equiv="X-UA-Compatible" content="ie=edge" />
    <title>Document</title>
    <link type="text/css" rel="stylesheet" href="<c:url value="/resources/css/style.css"/>" />
</head>
<body>
<header>
    <jsp:include page="/WEB-INF/views/header.jsp"/>
</header>

    <section class="login-page">
        <h2>Załóż konto</h2>
        <form:form action="/register" method="post" modelAttribute="registerData">
            <div class="form-group">
                <input  type="email" name="email" placeholder="Email" />
            </div>
            <div class="form-group">
                <input required="required" type="password" name="password" placeholder="Hasło" />
            </div>
            <div class="form-group">
                <input required="required" type="password" name="password2" placeholder="Powtórz hasło" />
            </div>

            <div class="form-group form-group--buttons">
                <a href="/login" class="btn btn--without-border">Zaloguj się</a>
                <button class="btn" type="submit">Załóż konto</button>
            </div>
        </form:form>
    </section>

<jsp:include page="/WEB-INF/views/footer.jsp"/>
</body>
</html>
