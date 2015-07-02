<?php
        header('Content-Type: text/html; charset=UTF-8');
        $host = "host";
        $user = "user";
        $pass = "pass";
        $bd = "bd";

        $descripcion = $_GET['descripcion'];

        if( !empty($descripcion) ){
            $conexion = mysql_connect($host, $user, $pass);
            mysql_select_db($bd);

            $sql = "DELETE FROM ofertas WHERE descripcion = '".$descripcion."'";
            $result = mysql_query($sql);

            mysql_close($conexion);
        }
?>
