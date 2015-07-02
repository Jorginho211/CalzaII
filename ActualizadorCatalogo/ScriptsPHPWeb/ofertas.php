<?php
        header('Content-Type: text/html; charset=UTF-8');
        $host = "host";
        $user = "user";
        $pass = "pass";
        $bd = "bd";

        $tipo = $_GET['tipo'];

        $conexion = mysql_connect($host, $user, $pass);
        mysql_select_db($bd);

        $sql = "SELECT descripcion FROM ofertas ORDER BY id DESC";
        $result = mysql_query($sql);

        while($fila = mysql_fetch_array($result)){
            echo $fila['descripcion']."\n";
        }

        mysql_close($conexion);
?>
