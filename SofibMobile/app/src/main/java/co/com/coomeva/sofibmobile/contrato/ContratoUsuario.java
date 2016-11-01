package co.com.coomeva.sofibmobile.contrato;

import java.util.UUID;

/**
 * Created by JuanCamilo on 10/20/16.
 */
public class ContratoUsuario {

    interface ColumnasUsuario {

        String ID = "id";
        String TIPO_USUARIO = "tipo_usuario";
        String USUARIO = "usuario";
        String CONTRASENA = "contrasena";
        String ROL = "rol";
        String NOMBRE_USUARIO = "nombre_usuario";

    }

    public static class Usuario implements ColumnasUsuario {
        public static String generarIdUsuario() {
            return "US-" + UUID.randomUUID().toString();
        }
    }

    public ContratoUsuario() {

    }
}
