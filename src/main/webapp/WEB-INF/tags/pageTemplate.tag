<%@ attribute name="pageTitle" %>
<%@tag description="base page template" pageEncoding="UTF-8" %>


<!DOCTYPE html>
<html>
<head>
    <title>${pageTitle}</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.2/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-Zenh87qX5JnK2Jl0vWa8Ck2rdkQ2Bzep5IDxbcnCeuOxjzrPF/et3URy9Bv1WTRi" crossorigin="anonymous">
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.2.2/dist/js/bootstrap.bundle.min.js" integrity="sha384-OERcA2EqjJCMA+/3y+gxIOqMEjwtxJY7qPCqsdltbNJuaOe923+mo//f6V8Qbsw3" crossorigin="anonymous"></script>

</head>
<body>
<jsp:include page="/WEB-INF/pages/menu.jsp"/>
    <main class="container-fluid mt-5">

        <jsp:doBody/>

    </main>


</body>

<jsp:include page="/WEB-INF/pages/footer.jsp"/>
<main class="container-fluid mt-5">

</main>

</html>