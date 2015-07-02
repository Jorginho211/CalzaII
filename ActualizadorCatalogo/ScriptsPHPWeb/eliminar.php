<?php
        header('Content-Type: text/html; charset=UTF-8');
        $host = "host";
        $user = "user";
        $pass = "pass";
        $bd = "bd";

        $modelo = $_GET['modelo'];

        if( !empty($modelo) ){
            $conexion = mysql_connect($host, $user, $pass);
            mysql_select_db($bd);

            $sql = "DELETE FROM zapatos WHERE modelo = '".$modelo."'";
            $result = mysql_query($sql);

            mysql_close($conexion);
        }
?>
