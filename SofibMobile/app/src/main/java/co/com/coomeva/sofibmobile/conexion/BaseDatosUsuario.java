package co.com.coomeva.sofibmobile.conexion;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.os.Build;
import android.provider.BaseColumns;

import co.com.coomeva.sofibmobile.contrato.ContratoUsuario;

/**
 * Created by JuanCamilo on 10/20/16.
 */
public class BaseDatosUsuario extends SQLiteOpenHelper {

    private static final String NOMBRE_BASE_DATOS = "usuario_sofib.db";

    private static final int VERSION_ACTUAL = 1;

    private final Context contexto;

    interface Tablas {
        String USUARIO = "usuario";
    }

    interface Referencias {

        String ID_USUARIO = String.format("REFERENCES %s(%s)",
                Tablas.USUARIO, ContratoUsuario.Usuario.ID);
    }

    public BaseDatosUsuario(Context contexto) {
        super(contexto, NOMBRE_BASE_DATOS, null, VERSION_ACTUAL);
        this.contexto = contexto;
    }

    @Override
    public void onOpen(SQLiteDatabase db) {
        super.onOpen(db);
        if (!db.isReadOnly()) {
            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.JELLY_BEAN) {
                db.setForeignKeyConstraintsEnabled(true);
            } else {
                db.execSQL("PRAGMA foreign_keys=ON");
            }
        }
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(String.format("CREATE TABLE %s ( %s INTEGER PRIMARY KEY AUTOINCREMENT," +
                        "%s TEXT NOT NULL UNIQUE, %s TEXT NOT NULL,%s TEXT NOT NULL,%s TEXT NOT NULL,%s TEXT NOT NULL,%s TEXT NOT NULL)",
                Tablas.USUARIO, BaseColumns._ID,
                ContratoUsuario.Usuario.ID,
                ContratoUsuario.Usuario.TIPO_USUARIO,
                ContratoUsuario.Usuario.USUARIO,
                ContratoUsuario.Usuario.CONTRASENA,
                ContratoUsuario.Usuario.ROL,
                ContratoUsuario.Usuario.NOMBRE_USUARIO));
    }


    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

        db.execSQL("DROP TABLE IF EXISTS " + Tablas.USUARIO);

        onCreate(db);

    }


}
