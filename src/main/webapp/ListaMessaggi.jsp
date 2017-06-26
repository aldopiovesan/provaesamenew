<%-- 
    Document   : ListaMessaggi
    Created on : 22-giu-2017, 14.23.06
    Author     : tss
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>

    <style>
        tr, td{
            border-bottom:solid 2px green;
            padding:2px;
        }

        table{

            border: solid 2px green;
            margin:auto;
        }      

    </style>
    <head>
        <link href="//netdna.bootstrapcdn.com/bootstrap/3.0.0/css/bootstrap.min.css" rel="stylesheet">
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <br>
        <br>
        <div class="container no-padding">
            <div class="col-md-4 no-padding" > 
                <form method="POST" action="logout">
                    <button  class="btn btn-default" type="submit">exit</button>   
                </form>
            </div>        
        </div>



        <br>
        <div class="container">    
            <tbody>     
            <table class="table table-bordered">

                <tr> 
                    <td>Id messaggio</td> 
                    <td>User</td> 
                    <td>Contenuto</td>
                    <td>Data</td>
                </tr>

                <c:forEach items="${msg.findbyUser()}" var="mex">

                    <tr>
                        <td><c:out value="${mex.idMessaggio}"/></td>   
                        <td><c:out value="${mex.idUtente.user}"/></td>
                        <td><c:out value="${mex.contenuto}"/></td>
                        <td><c:out value="${mex.dataCrezione}"/></td>
                        <td> <form method="POST" action="delete">
                                <input type="submit" class="btn btn-default" value="delete">
                                <input type="hidden" value="${mex.idMessaggio}" name="idMex"> <!--serve per prendere l'id del messaggio e cancellarlo, altrimento nn lo riconoscerebbe-->
                            </form>
                        </td>
                    </tr>

                </c:forEach>

            </table><br>

            <form method="POST" action="add">

                <div class="form-group">
                    <label for="contenuto">Contenuto</label>
                    <input type="text" class="form-control" id="contenuto" placeholder="contenuto" name="contenuto">
                </div>


                <input type="submit" class="btn btn-default" value="invio">
            </form>

        </tbody>
    </div>
</body>
</html>
