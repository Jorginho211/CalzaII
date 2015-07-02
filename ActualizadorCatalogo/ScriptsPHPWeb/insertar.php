<?php
        header('Content-Type: text/html; charset=UTF-8');
        $host = "host";
        $user = "user";
        $pass = "pass";
        $bd = "bd";

        $modelo = $_GET['modelo'];
        $tallas = $_GET['tallas'];
        $precio = $_GET['precio'];
        $imagen = $_GET['imagen'];
        $tipo = $_GET['tipo'];

        if( !empty($modelo) && !empty($tallas) && is_numeric($precio) && !empty($imagen) && ($tipo == "nino" || $tipo == "nina" || $tipo == "hombre" || $tipo == "mujer") ){
                $conexion = mysql_connect($host, $user, $pass);
                mysql_select_db($bd);

                $sql = "SELECT * FROM zapatos WHERE modelo LIKE '".$modelo."'";
                $result = mysql_query($sql);

                $urlImagen = "http://proba24.net76.net/fotos/".$tipo."/".$imagen.".jpeg";

                if (mysql_fetch_array($result)) {
                        $sql = "UPDATE zapatos SET tallas = '".$tallas."', precio = ".$precio.", imagen = '".$urlImagen."', tipo = '".$tipo."' WHERE modelo LIKE '".$modelo."'";
                }
                else {
                        $sql = "INSERT INTO zapatos (modelo,tallas,imagen,precio,tipo) VALUES ('".$modelo."','".$tallas."','".$urlImagen."',".$precio.",'".$tipo."')";
                }

                mysql_query($sql);
                mysql_close($conexion);
        }
?>
