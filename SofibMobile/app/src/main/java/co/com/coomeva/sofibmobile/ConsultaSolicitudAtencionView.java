package co.com.coomeva.sofibmobile;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Toast;

import com.google.android.gms.common.api.GoogleApiClient;

import co.com.coomeva.sofibmobile.dto.ConsultaSolicitudDTO;
import co.com.coomeva.sofibmobile.fragments.FiltroSolicitudAtencionFragment;

public class ConsultaSolicitudAtencionView extends AppCompatActivity {

    public static ConsultaSolicitudDTO solicitudAtencionSeleccionada;
    /**
     * ATTENTION: This was auto-generated to implement the App Indexing API.
     * See https://g.co/AppIndexing/AndroidStudio for more information.
     */
    private GoogleApiClient client;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        try {
            super.onCreate(savedInstanceState);
            setContentView(R.layout.activity_consulta_solicitud_atencion);

            Toolbar toolbar;
            toolbar = (Toolbar) findViewById(R.id.idToolBar);
            toolbar.setTitleTextColor(getResources().getColor(R.color.color_select));
            setSupportActionBar(toolbar);

            getSupportFragmentManager().beginTransaction()
                    .add(R.id.fragment_container_consulta_solicitud_atencion, new FiltroSolicitudAtencionFragment(), "FiltroSolicitudAtencionFragment")
                    .commit();

        } catch (Exception e) {
            Log.e(e.getMessage(), e.getMessage());
        }

    }
    public static ConsultaSolicitudDTO getSolicitudAtencionSeleccionada() {
        return solicitudAtencionSeleccionada;
    }

    public static void setSolicitudAtencionSeleccionada(ConsultaSolicitudDTO solicitudAtencionSeleccionada) {
        ConsultaSolicitudAtencionView.solicitudAtencionSeleccionada = solicitudAtencionSeleccionada;
    }

    boolean doubleBackToExitPressedOnce = false;

    @Override
    public void onBackPressed() {

        String fragmentCurrent = getActiveFragment();

        if (fragmentCurrent == null) {
            if (doubleBackToExitPressedOnce) {
                Intent intent = new Intent(Intent.ACTION_MAIN);
                intent.addCategory(Intent.CATEGORY_HOME);
                intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                startActivity(intent);
                return;
            }

            this.doubleBackToExitPressedOnce = true;
            Toast.makeText(this, getResources().getString(R.string.lbl_doble_back), Toast.LENGTH_SHORT).show();

            new Handler().postDelayed(new Runnable() {

                @Override
                public void run() {
                    doubleBackToExitPressedOnce = false;
                }
            }, 2000);
        }else {
            super.onBackPressed();
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_toolbar_filtros, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case R.id.action_settings:
                Intent intentFiltro = new Intent(getApplicationContext(), AjustesView.class);
                startActivity(intentFiltro);
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }

    public String getActiveFragment() {
        if (getSupportFragmentManager().getBackStackEntryCount() == 0) {
            return null;
        }else {
            return getSupportFragmentManager().getBackStackEntryAt(getSupportFragmentManager().getBackStackEntryCount() - 1).getName();
        }
    }


}
