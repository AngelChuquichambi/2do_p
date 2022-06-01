<%
    String opcion = request.getParameter("opcion");

%>


            <ul class="nav nav-tabs">
                <li class="nav-item">
                    <a class="nav-link <%= (opcion.equals("index_participantes") ? "active" : "") %>" href="controlador_participantes">Participantes</a>
                </li>
                <li class="nav-item">
                    <a class="nav-link <%= (opcion.equals("index_seminarios") ? "active" : "") %>" href="controlador_seminarios">Seminarios</a>
                </li>
            </ul>