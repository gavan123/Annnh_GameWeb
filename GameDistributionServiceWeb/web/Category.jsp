<%-- 
    Document   : Category.jsp
    Created on : Oct 13, 2022, 10:35:25 AM
    Author     : Strongest
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
        <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">
        <script src="https://code.jquery.com/jquery-3.6.1.min.js" integrity="sha256-o88AwQnZB+VDvE9tvIXrMQaPlFFSUTR+nldQm1LuPXQ=" crossorigin="anonymous"></script>
        <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.2/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-Zenh87qX5JnK2Jl0vWa8Ck2rdkQ2Bzep5IDxbcnCeuOxjzrPF/et3URy9Bv1WTRi" crossorigin="anonymous">
        <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.2.2/dist/js/bootstrap.bundle.min.js" integrity="sha384-OERcA2EqjJCMA+/3y+gxIOqMEjwtxJY7qPCqsdltbNJuaOe923+mo//f6V8Qbsw3" crossorigin="anonymous"></script>
        <link rel="stylesheet" href="css/Header.css"/>
        <style>
            section{
                width: 70%;
                margin: 0 auto;
                display: flex;
                min-height: 900px;
            }
            .crap div{
                -webkit-filter: brightness(100%);
                box-shadow: 2px 6px 8px 0 rgba(22, 22, 26, 0.18);
                color: white;
                opacity: 1;
                width: 100%;
                height: 200px;
                margin-top: 35px;
                background: radial-gradient(30% 40% at 40% 30%, rgba(33, 36, 41, .5) 0%, rgba(33, 36, 41, 0) 100%) no-repeat, #212429;
                background-size: 100%, 100%;
                border-radius: 15px;
            }
            .crap div:last-child{
                margin-bottom: 35px;
            }
            .crap div:hover{
                -webkit-filter: brightness(70%);
                cursor: pointer;
            }
        </style>
    </head>
    <body>
        <header><jsp:include page="Header.jsp" /></header>
        <section>
            <div class="container crap" style="display: block">
                <c:forEach items="${requestScope.cate}" var="c">
                    <div style="background-image: url('${c.cover}')" onclick="window.location.href='cate?genre=${c.categoryID}'">
                        <h2 style="padding: 50px">${c.categoryName}</h2>
                    </div>
                </c:forEach>
            </div>
        </section>
        <footer>
            <jsp:include page="footer.jsp"/>
        </footer>
    </body>
</html>
