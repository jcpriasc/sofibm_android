package co.com.coomeva.sofibmobile.modelo;

/**
 * Created by JuanCamilo on 10/20/16.
 */
public class Usuario {

    public String id;
    public String tipoUsuario;
    public String usuario;
    public String contrasena;
    public String rol;
    public String nombreUsuario;

    public Usuario(String id, String tipoUsuario, String usuario, String contrasena, String rol, String nombreUsuario) {
        this.id = id;
        this.tipoUsuario = tipoUsuario;
        this.usuario = usuario;
        this.contrasena = contrasena;
        this.rol = rol;
        this.nombreUsuario = nombreUsuario;
    }

    public Usuario() {
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getTipoUsuario() {
        return tipoUsuario;
    }

    public void setTipoUsuario(String tipoUsuario) {
        this.tipoUsuario = tipoUsuario;
    }

    public String getUsuario() {
        return usuario;
    }

    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }

    public String getContrasena() {
        return contrasena;
    }

    public void setContrasena(String contrasena) {
        this.contrasena = contrasena;
    }

    public String getRol() {
        return rol;
    }

    public void setRol(String rol) {
        this.rol = rol;
    }

    public String getNombreUsuario() {
        return nombreUsuario;
    }

    public void setNombreUsuario(String nombreUsuario) {
        this.nombreUsuario = nombreUsuario;
    }
}
