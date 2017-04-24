package co.com.coomeva.sofibmobile;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.Window;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;

import org.json.JSONArray;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

import co.com.coomeva.sofibmobile.R;
import co.com.coomeva.sofibmobile.conexion.OperacionesBaseDatos;
import co.com.coomeva.sofibmobile.dto.BitacoraDTO;
import co.com.coomeva.sofibmobile.modelo.Usuario;
import co.com.coomeva.sofibmobile.task.ConexionServicioTaskPOST;
import co.com.coomeva.sofibmobile.utils.Constantes;
import cz.msebera.android.httpclient.NameValuePair;
import cz.msebera.android.httpclient.message.BasicNameValuePair;


public class LoginView extends AppCompatActivity {

    public static Usuario usuarioSesion;
    private String nomUsuario;
    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        getSupportActionBar().hide();
        final OperacionesBaseDatos datos = OperacionesBaseDatos.obtenerInstancia(getApplicationContext());
        try {

            List<Usuario> usuariosEcontrados = datos.obtenerUsuarios();
            if (usuariosEcontrados!=null && !usuariosEcontrados.isEmpty()) {
                usuarioSesion = usuariosEcontrados.get(0);
                //TODO: Pendiente de quitar el rol quemado
                usuarioSesion.setRol(Constantes.usuarioAdmin);
                Intent intent = new Intent(this, ConsultaSolicitudAtencionView.class);
                startActivity(intent);
            }

            final EditText txtUser = (EditText) findViewById(R.id.editTextUser);
            final EditText txtPass = (EditText) findViewById(R.id.editTextPass);
            final RadioGroup radioGroupTipoUsuario = (RadioGroup) findViewById(R.id.radioGroudTipoUsuario);

            ImageButton button = (ImageButton) findViewById(R.id.imageButton);
            button.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {


                    try {

//                   List<NameValuePair> listParams = new ArrayList<NameValuePair>();
//                   listParams.add(new BasicNameValuePair("tipocredencial","UP"));
//                   listParams.add(new BasicNameValuePair("documento","dnsepr07"));
//                   listParams.add(new BasicNameValuePair("clave","ap5wOCTx"));
//                   listParams.add(new BasicNameValuePair("idAplicacion","50"));
//                   listParams.add(new BasicNameValuePair("tipoAutenticacion","PROFILE_MANAGER"));
//                   listParams.add(new BasicNameValuePair("referenciaOrigen","sofib"));

                        //TODO: poner autenticacion
                        String usuario = txtUser.getText().toString();
                        String password = txtPass.getText().toString();


                        if (usuario == null || usuario.equals("")) {
                            throw new Exception(getResources().getString(R.string.aviso_usuario));
                        }

                        if (password == null || password.equals("")) {
                            throw new Exception(getResources().getString(R.string.aviso_password));
                        }


                        String parametroURL = "";
                        int selectedId = radioGroupTipoUsuario.getCheckedRadioButtonId();
                        String tipoUsuario = "";
                        switch (selectedId) {
                            case R.id.radioButton:
                                tipoUsuario = "INTERNO";
                                parametroURL = "UP";
                                break;
                            case R.id.radioButton2:
                                tipoUsuario = "EXTERNO";
                                parametroURL = "UI";
                                break;
                        }

//                         String listParams = "/UP/" + usuario + "/" + password + "/50/PROFILE_MANAGER/sofib";
                        String listParams = "/"+parametroURL+"/" + usuario + "/" + password + "/50/PROFILE_MANAGER/sofib";

                        if (autenticarProfile(listParams)) {
                            datos.getDb().beginTransaction();
                            Usuario usuarioBD = new Usuario(null, tipoUsuario, usuario, password, "", nomUsuario);
                            //TODO: Pendiente de quitar el rol quemado
                            usuarioBD.setRol(Constantes.usuarioAdmin);
                            usuarioSesion = usuarioBD;
                            datos.insertarUsuario(usuarioBD);
                            Intent intent = new Intent(view.getContext(), ConsultaSolicitudAtencionView.class);
                            startActivity(intent);
                            datos.getDb().setTransactionSuccessful();
                        } else {
                            throw new Exception(getResources().getString(R.string.error_autenticacion));
                        }

                    } catch (Exception e) {
                        Toast.makeText(view.getContext(), e.getMessage(), Toast.LENGTH_LONG).show();
                    } finally {
                        if (datos.getDb().inTransaction()){
                            datos.getDb().endTransaction();
                        }
                    }
                }
            });


        }catch (Exception e){
            Toast.makeText(this, e.getMessage(), Toast.LENGTH_LONG).show();
        }

    }



    private boolean autenticarProfile(String listParams){

        boolean respuesta = false;

        try {

            ConexionServicioTaskPOST task = new ConexionServicioTaskPOST(this, listParams);

            synchronized (task) {
                task.execute().wait();
            }
            JSONObject respJSONSpinner = ConexionServicioTaskPOST.respJSON;
            JSONObject jsonArrayError = respJSONSpinner.optJSONObject("errorBean");
            String codigoError = jsonArrayError.getString("codigo");

            if (codigoError.equals("0")){
                respuesta = true;
            }

            JSONObject jsonArrayUsuario = respJSONSpinner.optJSONObject("usuarioDTO");
            if (jsonArrayUsuario!=null){
                String nombreUsuario = "";
                if (jsonArrayUsuario.getString("nombre")!=null && !jsonArrayUsuario.getString("nombre").equals("")){
                    nombreUsuario += jsonArrayUsuario.getString("nombre")+" ";
                }

                if (jsonArrayUsuario.getString("primerApellido")!=null && !jsonArrayUsuario.getString("primerApellido").equals("")){
                    nombreUsuario += jsonArrayUsuario.getString("primerApellido")+" ";
                }
                if (jsonArrayUsuario.getString("segundoApellido")!=null && !jsonArrayUsuario.getString("segundoApellido").equals("")){
                    nombreUsuario += jsonArrayUsuario.getString("segundoApellido");
                }
                nomUsuario = nombreUsuario;

            }

        }catch (Exception e){
            Toast.makeText(this ,e.getMessage(), Toast.LENGTH_LONG).show();
        }
        return respuesta ;
    }

}
