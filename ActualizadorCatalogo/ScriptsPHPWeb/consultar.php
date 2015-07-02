<?php
        header('Content-Type: text/html; charset=UTF-8');
        $host = "host";
        $user = "user";
        $pass = "pass";
        $bd = "bd";

        $tipo = $_GET['tipo'];

        $conexion = mysql_connect($host, $user, $pass);
        mysql_select_db($bd);

        $sql = "SELECT modelo,imagen FROM zapatos WHERE tipo LIKE '%".$tipo."%'";
        $result = mysql_query($sql);

        while($fila = mysql_fetch_array($result)){
            echo $fila['modelo'].";".$fila['imagen']."\n";
        }

        mysql_close($conexion);
?>
