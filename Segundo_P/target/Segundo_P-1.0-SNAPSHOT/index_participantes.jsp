<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Paticipantes</title>
        <link href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.1.1/css/all.min.css" rel="stylesheet">
        <!-- Bootstrap CSS -->
        <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-1BmE4kWBq78iYhFldvKuhfTAU6auU8tT94WrHftjDbrCEXSU1oBoqyl2QvZ6jIW3" crossorigin="anonymous">
    </head>
    <body>
        <div class="container">
            <jsp:include page="META-INF/tabla.jsp">
                <jsp:param name="opcion" value="index_participantes" />
            </jsp:include>
            <h1>Participantes Inscritos</h1>
            <a href="controlador_participantes?action=nuevo" class="btn btn-primary btn-sm"><i class="fa-solid fa-circle-plus"> </i> Añadir Participante</a>
            <br><br>
            <table class="table table-striped">
                <tr>
                    <th>ID</th>
                    <th>Apellidos</th>
                    <th>Nombres</th>
                    <th>Seminario</th>
                    <th>Confirmado</th>
                    <th></th>
                    <th></th>

                </tr>
                <c:forEach var="item" items="${participante}">
                    <tr>
                        <td>${item.id}</td>
                        <td>${item.apellidos}</td>
                        <td>${item.nombres}</td>
                        <td>${item.id_seminario}</td>
                        <td>${item.confirmado}</td>

                        <td><a href="controlador_participantes?action=actualizar&id=${item.id}"><i class="fa-regular fa-pen-to-square"></i></a></td>
                        <td><a href="controlador_participantes?action=eliminar&id=${item.id}" onclick="return(confirm('Esta seguro?'))">
                                <i class="fa-solid fa-trash-can"></i>
                            </a>
                        </td>
                    </tr>
                </c:forEach>
            </table>
        </div>

        <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/js/bootstrap.bundle.min.js" integrity="sha384-ka7Sk0Gln4gmtz2MlQnikT1wXgYsOg+OMhuP+IlRH9sENBO0LRn5q+8nbTov4+1p" crossorigin="anonymous"></script>

    </body>
</html>
