package co.com.coomeva.sofibmobile.conexion;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import java.util.ArrayList;
import java.util.List;

import co.com.coomeva.sofibmobile.contrato.ContratoUsuario;
import co.com.coomeva.sofibmobile.modelo.Usuario;

/**
 * Created by JuanCamilo on 10/20/16.
 */
public final class OperacionesBaseDatos {

    private static BaseDatosUsuario baseDatos;

    private static OperacionesBaseDatos instancia = new OperacionesBaseDatos();

    private OperacionesBaseDatos() {
    }

    public static OperacionesBaseDatos obtenerInstancia(Context contexto) {
        if (baseDatos == null) {
            baseDatos = new BaseDatosUsuario(contexto);
        }
        return instancia;
    }

    public List<Usuario> obtenerUsuarios() {

        List<Usuario> list = null;
        try {
            SQLiteDatabase db = baseDatos.getReadableDatabase();

            String sql = String.format("SELECT * FROM %s",
                    BaseDatosUsuario.Tablas.USUARIO);


            Cursor cursor = db.rawQuery(sql, null);

            if (cursor.moveToFirst()){
                list = new ArrayList<Usuario>();
                do {

                    Usuario dto = new Usuario();

                    dto.tipoUsuario=cursor.getString(cursor.getColumnIndex(ContratoUsuario.Usuario.TIPO_USUARIO));
                    dto.usuario=cursor.getString(cursor.getColumnIndex(ContratoUsuario.Usuario.USUARIO));
                    dto.contrasena=cursor.getString(cursor.getColumnIndex(ContratoUsuario.Usuario.CONTRASENA));
                    dto.rol=cursor.getString(cursor.getColumnIndex(ContratoUsuario.Usuario.ROL));
                    dto.nombreUsuario=cursor.getString(cursor.getColumnIndex(ContratoUsuario.Usuario.NOMBRE_USUARIO));

                    list.add(dto);

                }while (cursor.moveToNext());
            }
        }catch (Exception e){

        }

        return list;

    }

    public String insertarUsuario(Usuario usuario) {
        SQLiteDatabase db = baseDatos.getWritableDatabase();

        ContentValues valores = new ContentValues();
        // Generar Pk
        String idUsuario = ContratoUsuario.Usuario.generarIdUsuario();
        valores.put(ContratoUsuario.Usuario.ID, idUsuario);
        valores.put(ContratoUsuario.Usuario.TIPO_USUARIO, usuario.tipoUsuario);
        valores.put(ContratoUsuario.Usuario.USUARIO, usuario.usuario);
        valores.put(ContratoUsuario.Usuario.CONTRASENA, usuario.contrasena);
        valores.put(ContratoUsuario.Usuario.ROL, usuario.rol);
        valores.put(ContratoUsuario.Usuario.NOMBRE_USUARIO, usuario.nombreUsuario);

        db.insertOrThrow(BaseDatosUsuario.Tablas.USUARIO, null, valores);

        return idUsuario;

    }

    public void eliminarUsuario() {
        SQLiteDatabase db = baseDatos.getWritableDatabase();
        db.delete(BaseDatosUsuario.Tablas.USUARIO, null, null);
    }

    public SQLiteDatabase getDb() {
        return baseDatos.getWritableDatabase();
    }
}
