package co.com.coomeva.sofibmobile;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.os.Bundle;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.DisplayMetrics;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.CompoundButton;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.Switch;
import android.widget.TextView;
import android.widget.Toast;
import android.widget.ToggleButton;

import com.google.android.gms.common.api.GoogleApiClient;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

import co.com.coomeva.sofibmobile.R;
import co.com.coomeva.sofibmobile.adapters.AjustesAdapter;
import co.com.coomeva.sofibmobile.adapters.ConsultaSolicitudAtencionAdapter;
import co.com.coomeva.sofibmobile.conexion.OperacionesBaseDatos;
import co.com.coomeva.sofibmobile.dto.AjusteDTO;
import co.com.coomeva.sofibmobile.dto.ConsultaSolicitudDTO;
import co.com.coomeva.sofibmobile.fragments.FiltroSolicitudAtencionFragment;

public class AjustesView extends AppCompatActivity {


    private AjustesAdapter ajustesAdapter;
    private List<AjusteDTO> ajusteList = new ArrayList<>();
    private ListView listViewAjustes;
    private TextView textNombreUsuario;
    private TextView textTipoUsuario;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        try {
            super.onCreate(savedInstanceState);
            setContentView(R.layout.activity_ajustes);

            textNombreUsuario = (TextView) findViewById(R.id.textNombreUsuario);
            textTipoUsuario = (TextView) findViewById(R.id.textTipoUsuario);
            listViewAjustes = (ListView) findViewById(R.id.listSolicitudes);
            ajusteList = new ArrayList<>();
            ajusteList.add(new AjusteDTO(getResources().getString(R.string.lbl_cerrar_sesion), R.mipmap.ic_power_settings));
            ajusteList.add(new AjusteDTO(getResources().getString(R.string.lbl_cambiar_idioma), R.mipmap.ic_earth));

            ajustesAdapter = new AjustesAdapter(this, ajusteList);
            listViewAjustes.setAdapter(ajustesAdapter);

            textNombreUsuario.setText(LoginView.usuarioSesion.nombreUsuario);
            textTipoUsuario.setText(LoginView.usuarioSesion.tipoUsuario);

            listViewAjustes.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                @Override
                public void onItemClick(AdapterView<?> adapterView, final View view, int i, long l) {
                    if (i==0){
                        final AlertDialog.Builder dialogoCerrar = new AlertDialog.Builder(AjustesView.this);
                        final TextView textView = new TextView(AjustesView.this);

                        textView.setText(view.getResources().getString(R.string.lbl_aviso_cerrar_sesion));
                        LinearLayout ll=new LinearLayout(AjustesView.this);
                        ll.setOrientation(LinearLayout.VERTICAL);
                        ll.addView(textView);

                        LinearLayout.LayoutParams lp = new LinearLayout.LayoutParams(
                                LinearLayout.LayoutParams.MATCH_PARENT,
                                LinearLayout.LayoutParams.MATCH_PARENT);

                        lp.setMargins(30, 40, 30, 0);
                        textView.setLayoutParams(lp);

                        dialogoCerrar.setView(ll);

                        dialogoCerrar.setPositiveButton(view.getResources().getString(R.string.lbl_cancelar), new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialogInterface, int i) {


                            }
                        });

                        dialogoCerrar.setNegativeButton(view.getResources().getString(R.string.lbl_cerrar_sesion), new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialogInterface, int i) {
                                OperacionesBaseDatos datos = null;
                                try {
                                    datos = OperacionesBaseDatos.obtenerInstancia(getApplicationContext());
                                    datos.getDb().beginTransaction();
                                    datos.eliminarUsuario();
                                    datos.getDb().setTransactionSuccessful();

                                    Intent intentLogin = new Intent(view.getContext(), LoginView.class);
                                    startActivity(intentLogin);

                                }catch (Exception e){
                                    Toast.makeText(view.getContext(), e.getMessage(), Toast.LENGTH_LONG).show();
                                }finally {
                                    datos.getDb().endTransaction();
                                }
                            }
                        });

                        dialogoCerrar.show();

                    }else if (i==1){

                        AlertDialog.Builder dialogIdiomas = new AlertDialog.Builder(AjustesView.this);
                        dialogIdiomas.setTitle(R.string.lbl_cambiar_idioma);
                        dialogIdiomas.setItems(R.array.opcionesIdiomaArray, new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialogInterface, int which) {

                                Resources res = getResources();
                                // Change locale settings in the app.
                                DisplayMetrics dm = res.getDisplayMetrics();
                                android.content.res.Configuration conf = res.getConfiguration();

                                if (which == 0) {
                                    conf.locale = new Locale("en");
                                } else if (which == 1) {
                                    conf.locale = new Locale("es");
                                }
                                res.updateConfiguration(conf, dm);

                                Intent intentInicio = new Intent(view.getContext(), ConsultaSolicitudAtencionView.class);
                                startActivity(intentInicio);
                            }
                        });
                        dialogIdiomas.show();

                    }
                }
            });


        } catch (Exception e) {
            Log.e(e.getMessage(), e.getMessage());
        }

    }



}
