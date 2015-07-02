<?php
        header('Content-Type: text/html; charset=UTF-8');
        $host = "host";
        $user = "user";
        $pass = "pass";
        $bd = "bd";

        $tipo = $_GET['tipo'];
        
        $conexion = mysql_connect($host, $user, $pass);
        mysql_select_db($bd);

        $resultado = array();

        $sql = "SELECT * FROM zapatos WHERE tipo LIKE '".$tipo."' ORDER BY id DESC";
        $result = mysql_query($sql);

        while($fila = mysql_fetch_array($result)){
            $modelo = $fila['modelo'];
            $tallas = $fila['tallas'];
            $imagen = $fila['imagen'];
            $precio = $fila['precio'];
            $fecha = $fila['fecha'];

            $resultado[] = array( 'modelo' => $modelo, 'tallas' => $tallas, 'imagen' => $imagen, 'precio' => $precio, 'fecha' => $fecha );
        }

        mysql_close($conexion);

        print(json_encode($resultado));
?>
