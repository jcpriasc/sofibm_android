package co.com.coomeva.sofibmobile.utils;

import java.io.Serializable;

/**
 * Created by cesarlopez on 12/10/16.
 */
public class Constantes implements Serializable {

    public static String urlServicioRestServicioNoAsistencial = "http://pruebas-sectorsalud.coomeva.com.co/saludmp-ws/jax-rs/saludmp-sofibmobile/serviciosNoAsistenciales/{sistema}/{token}/{consSolicitud}";

    public static String usuarioLogistico = "LOGISTICO";
    public static String usuarioMedico = "MEDICO";
    public static String usuarioAdmin = "ADMIN";

    public static String tipoUsuarioInterno = "INTERNO";
    public static String tipoUsuarioExterno = "EXTERNO";

}
