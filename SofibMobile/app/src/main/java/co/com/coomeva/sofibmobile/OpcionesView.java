package co.com.coomeva.sofibmobile;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.NavigationView;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.Gravity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import co.com.coomeva.sofibmobile.R;
import co.com.coomeva.sofibmobile.dto.OpcionesDTO;
import co.com.coomeva.sofibmobile.fragments.FiltroSolicitudAprobacionFragment;
import co.com.coomeva.sofibmobile.fragments.OpcionesPrincipalesFragment;
import co.com.coomeva.sofibmobile.fragments.OpcionesSecundariasFragment;
import co.com.coomeva.sofibmobile.utils.Constantes;

public class OpcionesView extends AppCompatActivity {

    private DrawerLayout drawerLayout;
    private NavigationView navView;

    private ActionBarDrawerToggle mDrawerToggle;


    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_opciones);

        //Se cargan los valores para el header del menu
        TextView txtNumeroSolicitudMenu;
        TextView txtUsuarioMenu;
        View view = this.findViewById(R.id.menu_lateral_id);
        txtNumeroSolicitudMenu = (TextView)view.findViewById(R.id.txtNumeroSolicitudMenu);
        txtUsuarioMenu = (TextView)view.findViewById(R.id.txtUsuarioMenu);
        txtNumeroSolicitudMenu.setText(ConsultaSolicitudAtencionView.solicitudAtencionSeleccionada.getNumeroSolicitud());
        txtUsuarioMenu.setText(ConsultaSolicitudAtencionView.solicitudAtencionSeleccionada.getNombrePaciente());

        Toolbar toolbar;
        toolbar = (Toolbar) findViewById(R.id.idToolBar);
        toolbar.setTitleTextColor(getResources().getColor(R.color.color_select));
        setSupportActionBar(toolbar);


        drawerLayout = (DrawerLayout)findViewById(R.id.drawer_layout);
        navView = (NavigationView)findViewById(R.id.navview);

        if(LoginView.usuarioSesion != null && LoginView.usuarioSesion.getRol().equals(Constantes.usuarioMedico)){
            navView.getMenu().getItem(0).setVisible(true);
            navView.getMenu().getItem(1).setVisible(false);
        }else if(LoginView.usuarioSesion != null && LoginView.usuarioSesion.getRol().equals(Constantes.usuarioLogistico)){
            navView.getMenu().getItem(0).setVisible(false);
            navView.getMenu().getItem(1).setVisible(true);
        }else if(LoginView.usuarioSesion != null && LoginView.usuarioSesion.getRol().equals(Constantes.usuarioAdmin)){
            navView.getMenu().getItem(0).setVisible(true);
            navView.getMenu().getItem(1).setVisible(true);
        }else{
            navView.getMenu().getItem(0).setVisible(false);
            navView.getMenu().getItem(1).setVisible(false);
        }


        navView.setNavigationItemSelectedListener(
                new NavigationView.OnNavigationItemSelectedListener() {
                    @Override
                    public boolean onNavigationItemSelected(MenuItem menuItem) {
                        boolean fragmentTransaction = false;
                        String params = "";
                        try {

                            switch (menuItem.getItemId()) {
                                case R.id.menu_autorizaciones:
                                    params = getApplicationContext().getResources().getString(R.string.address_service_token)+ ConsultaSolicitudAtencionView.solicitudAtencionSeleccionada.getNumeroSolicitud();
                                    if (OpcionesSecundariasFragment.consultarAutorizaciones(getApplicationContext().getResources().getString(R.string.complement_Autorizaciones), params, OpcionesView.this)){
                                        Intent intentAutorizacion = new Intent(getApplicationContext(), AutorizacionesView.class);
                                        startActivity(intentAutorizacion);
                                    }else {
                                        throw new Exception(getApplicationContext().getResources().getString(R.string.lbl_sin_resultados));
                                    }
                                    break;
                                case R.id.menu_servicio_asistencial:
                                    if (OpcionesSecundariasFragment.consultarServiciosAsistenciales(getApplicationContext().getResources().getString(R.string.complement_ServiciosAsistenciales), params, OpcionesView.this)) {
                                        Intent intentServiciosAsistenciales = new Intent(getApplicationContext(), ServiciosAsistencialesView.class);
                                        startActivity(intentServiciosAsistenciales);
                                    }else {
                                        throw new Exception(getApplicationContext().getResources().getString(R.string.lbl_sin_resultados));
                                    }
                                    break;
                                case R.id.menu_informes_medicos:
                                    params = getApplicationContext().getResources().getString(R.string.address_service_token)+ ConsultaSolicitudAtencionView.solicitudAtencionSeleccionada.getNumeroSolicitud();
                                    if (OpcionesSecundariasFragment.consultarInformesMedicos(getApplicationContext().getResources().getString(R.string.complement_InformesMedicos), params, OpcionesView.this)) {
                                        Intent intentInformesMedicos = new Intent(getApplicationContext(), InformesMedicosView.class);
                                        startActivity(intentInformesMedicos);
                                    }else {
                                        throw new Exception(getApplicationContext().getResources().getString(R.string.lbl_sin_resultados));
                                    }
                                    break;
                                case R.id.menu_documentos_medicos:
                                    params = getApplicationContext().getResources().getString(R.string.address_service_token)+ ConsultaSolicitudAtencionView.solicitudAtencionSeleccionada.getNumeroSolicitud();
                                    if (OpcionesSecundariasFragment.consultarDocumentosMedicos(getApplicationContext().getResources().getString(R.string.complement_DocumentosMedicos), params, OpcionesView.this)){
                                        Intent intentDocumentosMedicos = new Intent(getApplicationContext(), DocumentosMedicosView.class);
                                        startActivity(intentDocumentosMedicos);
                                    }else {
                                        throw new Exception(getApplicationContext().getResources().getString(R.string.lbl_sin_resultados));
                                    }
                                    break;
                                case R.id.menu_bitacoras:
                                    Intent intentBitacora = new Intent(getApplicationContext(), BitacoraView.class);
                                    startActivity(intentBitacora);
                                    break;
                                case R.id.menu_epicrisis:
                                    params = getApplicationContext().getResources().getString(R.string.address_service_token)+ ConsultaSolicitudAtencionView.solicitudAtencionSeleccionada.getNumeroSolicitud();
                                    if (OpcionesSecundariasFragment.consultarEpicrisis(getApplicationContext().getResources().getString(R.string.complement_Epicrisis), params, OpcionesView.this)){
                                        Intent intentEpicrisis = new Intent(getApplicationContext(), EpicrisisView.class);
                                        startActivity(intentEpicrisis);
                                    }else {
                                        throw new Exception(getApplicationContext().getResources().getString(R.string.lbl_sin_resultados));
                                    }
                                    break;
                                case R.id.menu_procedimientos_adicionales:
                                    params = getApplicationContext().getResources().getString(R.string.address_service_token)+ ConsultaSolicitudAtencionView.solicitudAtencionSeleccionada.getNumeroSolicitud();
                                    if (OpcionesSecundariasFragment.consultarProcedimientosAdicionales(getApplicationContext().getResources().getString(R.string.complement_ProcedimientoAdicionales), params, OpcionesView.this)){
                                        Intent intentProcedimientosAdicionales = new Intent(getApplicationContext(), ProcedimientosAdicionalesView.class);
                                        startActivity(intentProcedimientosAdicionales);
                                    }else {
                                        throw new Exception(getApplicationContext().getResources().getString(R.string.lbl_sin_resultados));
                                    }
                                    break;
                                case R.id.menu_funcionarios_externos:
                                    params = getApplicationContext().getResources().getString(R.string.address_service_token)+ ConsultaSolicitudAtencionView.solicitudAtencionSeleccionada.getNumeroSolicitud();
                                    if (OpcionesSecundariasFragment.consultarFuncionariosExternos(getApplicationContext().getResources().getString(R.string.complement_FuncionariosExternos), params, OpcionesView.this)){
                                        Intent intentFuncionariosExternos = new Intent(getApplicationContext(), FuncionariosExternosView.class);
                                        startActivity(intentFuncionariosExternos);
                                    }else {
                                        throw new Exception(getApplicationContext().getResources().getString(R.string.lbl_sin_resultados));
                                    }
                                    break;
                                case R.id.menu_consultar_solicitudes_aprobacion:
                                    if( LoginView.usuarioSesion != null && LoginView.usuarioSesion.getTipoUsuario().equals( getApplicationContext().getResources().getString(R.string.usuario_interno)) ){
                                        FiltroSolicitudAprobacionFragment.tipoAprobacion = "m";
                                        Intent intentConsultarSolicitudesAprobacionNoAsistencial = new Intent(getApplicationContext(), ConsultaSolicitudAprobacionView.class);
                                        startActivity(intentConsultarSolicitudesAprobacionNoAsistencial);

                                    }else{
                                        params = getApplicationContext().getResources().getString(R.string.address_service_token)+"0/0/0/"+ ConsultaSolicitudAtencionView.solicitudAtencionSeleccionada.getNumeroSolicitud()+"/m";
                                        if (OpcionesSecundariasFragment.consultarSolicitudAprobacion(getApplicationContext().getResources().getString(R.string.complement_aprobacion), params, OpcionesView.this)){
                                            Intent intentConsultarSolicitudesAprobacionAsistencial = new Intent(getApplicationContext(), ConsultaSolicitudAprobacionView.class);
                                            startActivity(intentConsultarSolicitudesAprobacionAsistencial);
                                        }else {
                                            throw new Exception(getApplicationContext().getResources().getString(R.string.lbl_sin_resultados));
                                        }

                                    }
                                    break;
                                case R.id.menu_servicio_no_asistencial:
                                    params = getApplicationContext().getResources().getString(R.string.address_service_token)+ ConsultaSolicitudAtencionView.solicitudAtencionSeleccionada.getNumeroSolicitud();
                                    if (OpcionesSecundariasFragment.consultarServicioNoAsistencial(getApplicationContext().getResources().getString(R.string.complement_serviciosNoAsistenciales), params, OpcionesView.this)){
                                        Intent intentSolicitudNoAsistencial = new Intent(getApplicationContext(), SolicitudNoAsistencialView.class);
                                        startActivity(intentSolicitudNoAsistencial);
                                    }else {
                                        throw new Exception(getApplicationContext().getResources().getString(R.string.lbl_sin_resultados));
                                    }
                                    break;
                                case R.id.menu_giro:
                                    params = getApplicationContext().getResources().getString(R.string.address_service_token)+ ConsultaSolicitudAtencionView.solicitudAtencionSeleccionada.getNumeroSolicitud();
                                    if (OpcionesSecundariasFragment.consultarGiros(getApplicationContext().getResources().getString(R.string.complement_giro), params, OpcionesView.this)){
                                        Intent intentGiros = new Intent(getApplicationContext(), GiroView.class);
                                        startActivity(intentGiros);
                                    }else {
                                        throw new Exception(getApplicationContext().getResources().getString(R.string.lbl_sin_resultados));
                                    }
                                    break;
                                case R.id.menu_nota_credito_giro:
                                    params = getApplicationContext().getResources().getString(R.string.address_service_token)+ ConsultaSolicitudAtencionView.solicitudAtencionSeleccionada.getNumeroSolicitud();
                                    if (OpcionesSecundariasFragment.consultarNotasCreditoGiro(getApplicationContext().getResources().getString(R.string.complement_giro_notaCredito), params, OpcionesView.this)){
                                        Intent intentNotaCreditoGiros = new Intent(getApplicationContext(), NotaCreditoGiroView.class);
                                        startActivity(intentNotaCreditoGiros);
                                    }else {
                                        throw new Exception(getApplicationContext().getResources().getString(R.string.lbl_sin_resultados));
                                    }
                                    break;
                                case R.id.menu_lbl_titulo_facturafactura:
                                    params = getApplicationContext().getResources().getString(R.string.address_service_token)+ ConsultaSolicitudAtencionView.solicitudAtencionSeleccionada.getNumeroSolicitud();
                                    if (OpcionesSecundariasFragment.consultarFactura(getApplicationContext().getResources().getString(R.string.complement_factura), params, OpcionesView.this)){
                                        Intent intentFacturas = new Intent(getApplicationContext(), FacturaView.class);
                                        startActivity(intentFacturas);
                                    }else {
                                        throw new Exception(getApplicationContext().getResources().getString(R.string.lbl_sin_resultados));
                                    }
                                    break;
                                case R.id.menu_notas_credito_debito:
                                    params = getApplicationContext().getResources().getString(R.string.address_service_token)+ ConsultaSolicitudAtencionView.solicitudAtencionSeleccionada.getNumeroSolicitud();
                                    if (OpcionesSecundariasFragment.consultarNotasCreditoDebito(getApplicationContext().getResources().getString(R.string.complement_nota), params, OpcionesView.this)){
                                        Intent intentNotaCreditoDebito = new Intent(getApplicationContext(), NotasCreditoDebitoView.class);
                                        startActivity(intentNotaCreditoDebito);
                                    }else {
                                        throw new Exception(getApplicationContext().getResources().getString(R.string.lbl_sin_resultados));
                                    }

                                    break;
                                case R.id.menu_utilizaciones:
                                    params = getApplicationContext().getResources().getString(R.string.address_service_token)+ ConsultaSolicitudAtencionView.solicitudAtencionSeleccionada.getNumeroSolicitud();
                                    if (OpcionesSecundariasFragment.consultarUtilizaciones(getApplicationContext().getResources().getString(R.string.complement_utilizaciones), params, OpcionesView.this)){
                                        Intent intentUtilizaciones = new Intent(getApplicationContext(), UtilizacionesView.class);
                                        startActivity(intentUtilizaciones);
                                    }else {
                                        throw new Exception(getApplicationContext().getResources().getString(R.string.lbl_sin_resultados));
                                    }
                                    break;
                                case R.id.menu_encuesta_satisfaccion:
                                    params = getApplicationContext().getResources().getString(R.string.address_service_token)+ ConsultaSolicitudAtencionView.solicitudAtencionSeleccionada.getNumeroSolicitud();
                                    if (OpcionesSecundariasFragment.consultarEncuesta(getApplicationContext().getResources().getString(R.string.complement_encuesta), params, OpcionesView.this)){
                                        Intent intentEncuesta= new Intent(getApplicationContext(), EncuestaView.class);
                                        startActivity(intentEncuesta);
                                    }else {
                                        throw new Exception(getApplicationContext().getResources().getString(R.string.lbl_sin_resultados));
                                    }
                                    break;
                                case R.id.menu_solicitudes_aprobacion_logistica:
                                    if( LoginView.usuarioSesion != null && LoginView.usuarioSesion.getTipoUsuario().equals( getApplicationContext().getResources().getString(R.string.usuario_interno)) ){
                                        FiltroSolicitudAprobacionFragment.tipoAprobacion = "l";
                                        Intent intentConsultarSolicitudesAprobacionLogis= new Intent(getApplicationContext(), ConsultaSolicitudAprobacionView.class);
                                        startActivity(intentConsultarSolicitudesAprobacionLogis);

                                    }else{
                                        params = getApplicationContext().getResources().getString(R.string.address_service_token)+"0/0/0/"+ ConsultaSolicitudAtencionView.solicitudAtencionSeleccionada.getNumeroSolicitud()+"/l";
                                        if (OpcionesSecundariasFragment.consultarSolicitudAprobacion(getApplicationContext().getResources().getString(R.string.complement_aprobacion), params, OpcionesView.this)){
                                            Intent intentConsultarSolicitudesAprobacionAsistencial = new Intent(getApplicationContext(), ConsultaSolicitudAprobacionView.class);
                                            startActivity(intentConsultarSolicitudesAprobacionAsistencial);
                                        }else {
                                            throw new Exception(getApplicationContext().getResources().getString(R.string.lbl_sin_resultados));
                                        }

                                    }
                                    break;
                            }

                        }catch (Exception e){
                            Toast.makeText(getApplicationContext(),e.getMessage(), Toast.LENGTH_LONG).show();
                        }
                        drawerLayout.closeDrawers();

                        return true;
                    }
                });

        try {
            mDrawerToggle = new ActionBarDrawerToggle(this, drawerLayout, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close) {
                @Override
                public void onDrawerOpened(View drawerView) {
                    super.onDrawerOpened(drawerView);

                }

                @Override
                public void onDrawerClosed(View drawerView) {
                    super.onDrawerClosed(drawerView);

                }
            };
            mDrawerToggle.setDrawerIndicatorEnabled(false);
            drawerLayout.setDrawerListener(mDrawerToggle);
            mDrawerToggle.syncState();


            toolbar.setNavigationIcon(R.mipmap.icon_menu);
            toolbar.setNavigationOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    drawerLayout.openDrawer(Gravity.LEFT);
                }
            });
        }catch (Exception ex){
            Log.e(ex.getMessage(),ex.getMessage());
        }

        OpcionesDTO opcion = null;
        if(LoginView.usuarioSesion!=null && LoginView.usuarioSesion.getRol().equals(Constantes.usuarioMedico)){

            opcion = new OpcionesDTO("1", getResources().getString(R.string.lbl_consultar_info_medica), R.mipmap.consultarinfomed);
            OpcionesPrincipalesFragment.opcionSeleccionada = opcion;
            getSupportFragmentManager().beginTransaction()
                    .add(R.id.fragment_container_opciones, new OpcionesSecundariasFragment(), "OpcionesSecundariasFragment")
                    .commit();

        } else if(LoginView.usuarioSesion!=null && LoginView.usuarioSesion.getRol().equals(Constantes.usuarioLogistico)){
            opcion = new OpcionesDTO("2", getResources().getString(R.string.lbl_consultar_info_logistica), R.mipmap.consultarinfo);
            OpcionesPrincipalesFragment.opcionSeleccionada = opcion;
            getSupportFragmentManager().beginTransaction()
                    .add(R.id.fragment_container_opciones, new OpcionesSecundariasFragment(), "OpcionesSecundariasFragment")
                    .commit();


        } else if(LoginView.usuarioSesion!=null && LoginView.usuarioSesion.getRol().equals(Constantes.usuarioAdmin)){
            getSupportFragmentManager().beginTransaction()
                    .add(R.id.fragment_container_opciones, new OpcionesPrincipalesFragment(), "OpcionesPrincipalesFragment")
                    .commit();

        }



    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_toolbar, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case R.id.action_settings:
                Intent intentAjustes = new Intent(getApplicationContext(), AjustesView.class);
                startActivity(intentAjustes);
                return true;
            case R.id.action_buscar:
                Intent intentFiltro = new Intent(getApplicationContext(), ConsultaSolicitudAtencionView.class);
                startActivity(intentFiltro);
                return true;

            default:
                return super.onOptionsItemSelected(item);
        }
    }
}
