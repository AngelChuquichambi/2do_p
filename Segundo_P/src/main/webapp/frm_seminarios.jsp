<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Seminarios</title>
        <link href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.1.1/css/all.min.css" rel="stylesheet">
        <!-- Bootstrap CSS -->
        <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-1BmE4kWBq78iYhFldvKuhfTAU6auU8tT94WrHftjDbrCEXSU1oBoqyl2QvZ6jIW3" crossorigin="anonymous">
    </head>
    <body>
        <div class="container">
            <h1>Formulario de Seminario</h1>
            <br>
            <form action="controlador_seminarios" method="post">
                <input type="hidden" name="id" value="${seminarios.id}">
                <div class="form-group">
                    <label for="" class="form-label">Titulo</label>
                    <input type="text" class="form-control" name="titulo" value="${seminarios.titulo}" placeholder="Escriba su nombre">
                </div>
                <div class="form-group">
                    <label for="" class="form-label">Fecha</label>
                    <input type="text" class="form-control" name="fecha" value="${seminarios.fecha}" placeholder="Escriba su correo electronico">
                </div>
                <div class="form-group">
                    <label for="" class="form-label">Cupos</label>
                    <input type="text" class="form-control" name="cupo" value="${seminarios.cupo}" placeholder="Escriba su celular">
                </div>
                <br>    
                <button type="submit" class="btn btn-primary">Registrar</button>
            </form>
        </div>

        <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/js/bootstrap.bundle.min.js" integrity="sha384-ka7Sk0Gln4gmtz2MlQnikT1wXgYsOg+OMhuP+IlRH9sENBO0LRn5q+8nbTov4+1p" crossorigin="anonymous"></script>
    </body>
</html>

