package co.com.coomeva.sofibmobile.fragments;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.util.Base64;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Toast;

import org.json.JSONArray;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

import co.com.coomeva.sofibmobile.AutorizacionesView;
import co.com.coomeva.sofibmobile.BitacoraView;
import co.com.coomeva.sofibmobile.ConsultaSolicitudAtencionView;
import co.com.coomeva.sofibmobile.InformesMedicosView;
import co.com.coomeva.sofibmobile.ConsultaSolicitudAprobacionView;
import co.com.coomeva.sofibmobile.EncuestaView;
import co.com.coomeva.sofibmobile.FacturaView;
import co.com.coomeva.sofibmobile.FuncionariosExternosView;
import co.com.coomeva.sofibmobile.GiroView;
import co.com.coomeva.sofibmobile.LoginView;
import co.com.coomeva.sofibmobile.NotaCreditoGiroView;
import co.com.coomeva.sofibmobile.DocumentosMedicosView;
import co.com.coomeva.sofibmobile.EpicrisisView;
import co.com.coomeva.sofibmobile.NotasCreditoDebitoView;
import co.com.coomeva.sofibmobile.ProcedimientosAdicionalesView;
import co.com.coomeva.sofibmobile.R;
import co.com.coomeva.sofibmobile.ServiciosAsistencialesView;
import co.com.coomeva.sofibmobile.SolicitudNoAsistencialView;
import co.com.coomeva.sofibmobile.UtilizacionesView;
import co.com.coomeva.sofibmobile.adapters.ConsultaSolicitudAtencionAdapter;
import co.com.coomeva.sofibmobile.adapters.OpcionesAdapter;
import co.com.coomeva.sofibmobile.dto.AutorizacionesDTO;
import co.com.coomeva.sofibmobile.dto.ConsultaSolicitudDTO;
import co.com.coomeva.sofibmobile.dto.DocumentosMedicosDTO;
import co.com.coomeva.sofibmobile.dto.EncuestaDTO;
import co.com.coomeva.sofibmobile.dto.FacturaDTO;
import co.com.coomeva.sofibmobile.dto.FuncionariosExternosDTO;
import co.com.coomeva.sofibmobile.dto.GirosDTO;
import co.com.coomeva.sofibmobile.dto.NotaCreditoDebitoDTO;
import co.com.coomeva.sofibmobile.dto.InformesMedicosDTO;
import co.com.coomeva.sofibmobile.dto.NotaCreditoGiroDTO;
import co.com.coomeva.sofibmobile.dto.OpcionesDTO;
import co.com.coomeva.sofibmobile.dto.ProcedimientosAdicionalesDTO;
import co.com.coomeva.sofibmobile.dto.ServicioAsistencialDTO;
import co.com.coomeva.sofibmobile.dto.ServicioNoAsistencialDTO;
import co.com.coomeva.sofibmobile.dto.UtilizacionesDTO;
import co.com.coomeva.sofibmobile.modelo.Usuario;
import co.com.coomeva.sofibmobile.task.ConexionServicioTask;
import co.com.coomeva.sofibmobile.utils.Utilities;

/**
 * Created by JuanCamilo on 9/25/16.
 */
public class OpcionesSecundariasFragment extends Fragment{


    private OpcionesAdapter opcionesAdapter;
    private ListView listViewOpcionesSecundarias;
    private List<OpcionesDTO> opcionesList = null;

    public static List<AutorizacionesDTO> autorizacionesList = new ArrayList<>();

    public static List<DocumentosMedicosDTO> documentosMedicosList = new ArrayList<>();
    public static List<DocumentosMedicosDTO> lstEpicrisis = new ArrayList<>();
    public static List<ProcedimientosAdicionalesDTO> lstProcedimientosAdicionales = new ArrayList<>();
    public static List<FacturaDTO> lstFacturaDTO = new ArrayList<FacturaDTO>();
    public static List<EncuestaDTO> lstEncuesta = new ArrayList<EncuestaDTO>();
    public static List<ServicioNoAsistencialDTO> lstSolicitudNoAsistencial = new ArrayList<ServicioNoAsistencialDTO>();
    public static List<GirosDTO> lstGiros = new ArrayList<GirosDTO>();
    public static List<InformesMedicosDTO> lstInformesMedicos = new ArrayList<InformesMedicosDTO>();
    public static List<FuncionariosExternosDTO> lstFuncionariosExternos = new ArrayList<FuncionariosExternosDTO>();
    public static List<NotaCreditoGiroDTO> lstNotaCreditoGiro = new ArrayList<NotaCreditoGiroDTO>();
    public static List<NotaCreditoDebitoDTO> lstNotaCreditoDebito= new ArrayList<NotaCreditoDebitoDTO>();
    public static List<UtilizacionesDTO> lstUtilizaciones= new ArrayList<UtilizacionesDTO>();
    public static List<ServicioAsistencialDTO> lstServiciosAsistenciales= new ArrayList<ServicioAsistencialDTO>();
    public static List<ConsultaSolicitudDTO> lstSolicitudAprobacion = new ArrayList<ConsultaSolicitudDTO>();

    public static JSONArray respJSON = null;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_opciones_secundarias, container, false);

        listViewOpcionesSecundarias = (ListView) view.findViewById(R.id.listOpcionesSecundarias);

        opcionesList = new ArrayList<>();

        if (OpcionesPrincipalesFragment.opcionSeleccionada!=null && OpcionesPrincipalesFragment.opcionSeleccionada.getId().equals("1")){
            opcionesList.add(new OpcionesDTO("1", getResources().getString(R.string.lbl_autorizaciones), R.mipmap.autorizaciones));
            opcionesList.add(new OpcionesDTO("2", getResources().getString(R.string.lbl_servicio_asistencial), R.mipmap.asistenciales));
            opcionesList.add(new OpcionesDTO("3", getResources().getString(R.string.lbl_informes_medicos), R.mipmap.infomedicos));
            opcionesList.add(new OpcionesDTO("4", getResources().getString(R.string.lbl_documentos_medicos), R.mipmap.docmedicos));
            opcionesList.add(new OpcionesDTO("5", getResources().getString(R.string.lbl_bitacoras), R.mipmap.bitacoras));
            opcionesList.add(new OpcionesDTO("6", getResources().getString(R.string.lbl_epicrisis), R.mipmap.epicrisis));
            opcionesList.add(new OpcionesDTO("7", getResources().getString(R.string.lbl_procedimientos_adicionales), R.mipmap.procedimientos));
            opcionesList.add(new OpcionesDTO("8", getResources().getString(R.string.lbl_funcionarios_externos), R.mipmap.citas));
            opcionesList.add(new OpcionesDTO("9", getResources().getString(R.string.lbl_consultar_solicitudes_aprobacion), R.mipmap.aprobacion));
        }else if (OpcionesPrincipalesFragment.opcionSeleccionada!=null && OpcionesPrincipalesFragment.opcionSeleccionada.getId().equals("2")){
            opcionesList.add(new OpcionesDTO("10", getResources().getString(R.string.lbl_servicio_no_asistencial), R.mipmap.noasistenciales));
            opcionesList.add(new OpcionesDTO("11", getResources().getString(R.string.lbl_titulo_giro), R.mipmap.giros));
            opcionesList.add(new OpcionesDTO("12", getResources().getString(R.string.lbl_titulo_nota_credito_giro), R.mipmap.creditogiros));
            opcionesList.add(new OpcionesDTO("13", getResources().getString(R.string.lbl_titulo_factura), R.mipmap.facturas));
            opcionesList.add(new OpcionesDTO("14", getResources().getString(R.string.lbl_titulo_notas_credito_debito), R.mipmap.debitocredito));
            opcionesList.add(new OpcionesDTO("15", getResources().getString(R.string.lbl_titulo_utilizaciones), R.mipmap.utilizacion));
            opcionesList.add(new OpcionesDTO("16", getResources().getString(R.string.lbl_titulo_encuesta_satisfaccion), R.mipmap.encuesta));
            opcionesList.add(new OpcionesDTO("17", getResources().getString(R.string.lbl_consultar_solicitudes_aprobacion), R.mipmap.aprobacion));
            opcionesList.add(new OpcionesDTO("18", getResources().getString(R.string.lbl_bitacoras), R.mipmap.bitacoras));
        }

        opcionesAdapter = new OpcionesAdapter(view.getContext(), opcionesList);
        listViewOpcionesSecundarias.setAdapter(opcionesAdapter);

        listViewOpcionesSecundarias.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView adapterView, View view, int i, long l) {
                try {

                    if(opcionesList.get(i).getId().equals("1")) {
                        String params = "/SAC/ABCD1234/"+ ConsultaSolicitudAtencionView.solicitudAtencionSeleccionada.getNumeroSolicitud();
                        if (consultarAutorizaciones(getActivity().getResources().getString(R.string.complement_Autorizaciones), params, getActivity())){
                            Intent intentAutorizacion = new Intent(view.getContext(), AutorizacionesView.class);
                            startActivity(intentAutorizacion);
                        }else {
                            throw new Exception(getActivity().getResources().getString(R.string.lbl_sin_resultados));
                        }
                    }else if(opcionesList.get(i).getId().equals("2")) {
                        String params = "/SAC/ABCD1234/"+ ConsultaSolicitudAtencionView.solicitudAtencionSeleccionada.getNumeroSolicitud();
                        if (consultarServiciosAsistenciales(getActivity().getResources().getString(R.string.complement_ServiciosAsistenciales), params, getActivity())) {
                            Intent intentServiciosAsistenciales = new Intent(view.getContext(), ServiciosAsistencialesView.class);
                            startActivity(intentServiciosAsistenciales);
                        }else {
                            throw new Exception(getActivity().getResources().getString(R.string.lbl_sin_resultados));
                        }
                    }else if(opcionesList.get(i).getId().equals("3")) {
                        String params = "/SAC/ABCD1234/"+ ConsultaSolicitudAtencionView.solicitudAtencionSeleccionada.getNumeroSolicitud();
                        if (consultarInformesMedicos(getActivity().getResources().getString(R.string.complement_InformesMedicos), params, getActivity())) {
                            Intent intentInformesMedicos = new Intent(view.getContext(), InformesMedicosView.class);
                            startActivity(intentInformesMedicos);
                        }else {
                            throw new Exception(getActivity().getResources().getString(R.string.lbl_sin_resultados));
                        }
                    }else if(opcionesList.get(i).getId().equals("4")) {
                        String params = "/SAC/ABCD1234/"+ ConsultaSolicitudAtencionView.solicitudAtencionSeleccionada.getNumeroSolicitud();
                        if (consultarDocumentosMedicos(getActivity().getResources().getString(R.string.complement_DocumentosMedicos), params, getActivity())){
                            Intent intentDocumentosMedicos = new Intent(view.getContext(), DocumentosMedicosView.class);
                            startActivity(intentDocumentosMedicos);
                        }else {
                            throw new Exception(getActivity().getResources().getString(R.string.lbl_sin_resultados));
                        }
                    }else if(opcionesList.get(i).getId().equals("5")) {
                        Intent intentBitacora = new Intent(view.getContext(), BitacoraView.class);
                        startActivity(intentBitacora);
                    }else if(opcionesList.get(i).getId().equals("6")) {
                        String params = "/SAC/ABCD1234/"+ ConsultaSolicitudAtencionView.solicitudAtencionSeleccionada.getNumeroSolicitud();
                        if (consultarEpicrisis(getActivity().getResources().getString(R.string.complement_Epicrisis), params, getActivity())){
                            Intent intentEpicrisis = new Intent(view.getContext(), EpicrisisView.class);
                            startActivity(intentEpicrisis);
                        }else {
                            throw new Exception(getActivity().getResources().getString(R.string.lbl_sin_resultados));
                        }
                    }else if(opcionesList.get(i).getId().equals("7")) {
                        String params = "/SAC/ABCD1234/"+ ConsultaSolicitudAtencionView.solicitudAtencionSeleccionada.getNumeroSolicitud();
                        if (consultarProcedimientosAdicionales(getActivity().getResources().getString(R.string.complement_ProcedimientoAdicionales), params, getActivity())){
                            Intent intentProcedimientosAdicionales = new Intent(view.getContext(), ProcedimientosAdicionalesView.class);
                            startActivity(intentProcedimientosAdicionales);
                        }else {
                            throw new Exception(getActivity().getResources().getString(R.string.lbl_sin_resultados));
                        }
                    }else if(opcionesList.get(i).getId().equals("8")) {
                        String params = "/SAC/ABCD1234/"+ ConsultaSolicitudAtencionView.solicitudAtencionSeleccionada.getNumeroSolicitud();
                        if (consultarFuncionariosExternos(getActivity().getResources().getString(R.string.complement_FuncionariosExternos), params, getActivity())){
                            Intent intentFuncionariosExternos = new Intent(view.getContext(), FuncionariosExternosView.class);
                            startActivity(intentFuncionariosExternos);
                        }else {
                            throw new Exception(getActivity().getResources().getString(R.string.lbl_sin_resultados));
                        }
                    }else if(opcionesList.get(i).getId().equals("9")) {

                        if( LoginView.usuarioSesion != null && LoginView.usuarioSesion.getTipoUsuario().equals( getActivity().getResources().getString(R.string.usuario_interno)) ){
                            FiltroSolicitudAprobacionFragment.tipoAprobacion = "m";
                            Intent intentConsultarSolicitudesAprobacionNoAsistencial = new Intent(view.getContext(), ConsultaSolicitudAprobacionView.class);
                            startActivity(intentConsultarSolicitudesAprobacionNoAsistencial);
                        }else{

                            String params = "/SAC/ABCD1234/0/0/0/"+ ConsultaSolicitudAtencionView.solicitudAtencionSeleccionada.getNumeroSolicitud()+"/m";
                            if (consultarSolicitudAprobacion(getActivity().getResources().getString(R.string.complement_aprobacion), params, getActivity())){
                                Intent intentConsultarSolicitudesAprobacionAsistencial = new Intent(view.getContext(), ConsultaSolicitudAprobacionView.class);
                                startActivity(intentConsultarSolicitudesAprobacionAsistencial);
                            }else {
                                throw new Exception(getActivity().getResources().getString(R.string.lbl_sin_resultados));
                            }
                        }

                    }else if(opcionesList.get(i).getId().equals("10")) {
                        String params = "/SAC/ABCD1234/"+ ConsultaSolicitudAtencionView.solicitudAtencionSeleccionada.getNumeroSolicitud();
                        if (consultarServicioNoAsistencial(getActivity().getResources().getString(R.string.complement_serviciosNoAsistenciales), params, getActivity())){
                            Intent intentSolicitudNoAsistencial = new Intent(view.getContext(), SolicitudNoAsistencialView.class);
                            startActivity(intentSolicitudNoAsistencial);
                        }else {
                            throw new Exception(getActivity().getResources().getString(R.string.lbl_sin_resultados));
                        }
                    }else if(opcionesList.get(i).getId().equals("11")) {
                        String params = "/SAC/ABCD1234/"+ ConsultaSolicitudAtencionView.solicitudAtencionSeleccionada.getNumeroSolicitud();
                        if (consultarGiros(getActivity().getResources().getString(R.string.complement_giro), params, getActivity())){
                            Intent intentGiros = new Intent(view.getContext(), GiroView.class);
                            startActivity(intentGiros);
                        }else {
                            throw new Exception(getActivity().getResources().getString(R.string.lbl_sin_resultados));
                        }
                    }else if(opcionesList.get(i).getId().equals("12")) {
                        String params = "/SAC/ABCD1234/"+ ConsultaSolicitudAtencionView.solicitudAtencionSeleccionada.getNumeroSolicitud();
                        if (consultarNotasCreditoGiro(getActivity().getResources().getString(R.string.complement_giro_notaCredito), params, getActivity())){
                            Intent intentNotaCreditoGiros = new Intent(view.getContext(), NotaCreditoGiroView.class);
                            startActivity(intentNotaCreditoGiros);
                        }else {
                            throw new Exception(getActivity().getResources().getString(R.string.lbl_sin_resultados));
                        }
                    }else if(opcionesList.get(i).getId().equals("13")) {
                        String params = "/SAC/ABCD1234/"+ ConsultaSolicitudAtencionView.solicitudAtencionSeleccionada.getNumeroSolicitud();
                        if (consultarFactura(getActivity().getResources().getString(R.string.complement_factura), params, getActivity())){
                            Intent intentFacturas = new Intent(view.getContext(), FacturaView.class);
                            startActivity(intentFacturas);
                        }else {
                            throw new Exception(getActivity().getResources().getString(R.string.lbl_sin_resultados));
                        }
                    }else if(opcionesList.get(i).getId().equals("14")) {
                        String params = "/SAC/ABCD1234/"+ ConsultaSolicitudAtencionView.solicitudAtencionSeleccionada.getNumeroSolicitud();
                        if (consultarNotasCreditoDebito(getActivity().getResources().getString(R.string.complement_nota), params, getActivity())){
                            Intent intentNotaCreditoDebito = new Intent(view.getContext(), NotasCreditoDebitoView.class);
                            startActivity(intentNotaCreditoDebito);
                        }else {
                            throw new Exception(getActivity().getResources().getString(R.string.lbl_sin_resultados));
                        }

                    }else if(opcionesList.get(i).getId().equals("15")) {
                        String params = "/SAC/ABCD1234/"+ ConsultaSolicitudAtencionView.solicitudAtencionSeleccionada.getNumeroSolicitud();
                        if (consultarUtilizaciones(getActivity().getResources().getString(R.string.complement_utilizaciones), params, getActivity())){
                            Intent intentUtilizaciones = new Intent(view.getContext(), UtilizacionesView.class);
                            startActivity(intentUtilizaciones);
                        }else {
                            throw new Exception(getActivity().getResources().getString(R.string.lbl_sin_resultados));
                        }

                    }else if(opcionesList.get(i).getId().equals("16")) {
                        String params = "/SAC/ABCD1234/"+ ConsultaSolicitudAtencionView.solicitudAtencionSeleccionada.getNumeroSolicitud();
                        if (consultarEncuesta(getActivity().getResources().getString(R.string.complement_encuesta), params, getActivity())){
                            Intent intentEncuesta= new Intent(view.getContext(), EncuestaView.class);
                            startActivity(intentEncuesta);
                        }else {
                            throw new Exception(getActivity().getResources().getString(R.string.lbl_sin_resultados));
                        }
                    }else if(opcionesList.get(i).getId().equals("17")) {

                        if( LoginView.usuarioSesion != null && LoginView.usuarioSesion.getTipoUsuario().equals( getActivity().getResources().getString(R.string.usuario_interno)) ){
                            FiltroSolicitudAprobacionFragment.tipoAprobacion = "l";
                            Intent intentConsultarSolicitudesAprobacionNoAsistencial = new Intent(view.getContext(), ConsultaSolicitudAprobacionView.class);
                            startActivity(intentConsultarSolicitudesAprobacionNoAsistencial);
                        }else{

                            String params = "/SAC/ABCD1234/0/0/0/"+ ConsultaSolicitudAtencionView.solicitudAtencionSeleccionada.getNumeroSolicitud()+"/l";
                            if (consultarSolicitudAprobacion(getActivity().getResources().getString(R.string.complement_aprobacion), params, getActivity())){
                                Intent intentConsultarSolicitudesAprobacionNoAsistencial = new Intent(view.getContext(), ConsultaSolicitudAprobacionView.class);
                                startActivity(intentConsultarSolicitudesAprobacionNoAsistencial);
                            }else {
                                throw new Exception(getActivity().getResources().getString(R.string.lbl_sin_resultados));
                            }

                        }

                    }else if(opcionesList.get(i).getId().equals("18")) {
                        Intent intentBitacora = new Intent(view.getContext(), BitacoraView.class);
                        startActivity(intentBitacora);
                    }

                }catch (Exception e){
                    Toast.makeText(getActivity(),e.getMessage(), Toast.LENGTH_LONG).show();
                }
            }
        });

        return view;
    }


    public static boolean consultarUtilizaciones(String serviceName, String listParams, Context contexto)throws Exception{

        boolean respuesta = false;

        try {

            ConexionServicioTask task = new ConexionServicioTask(contexto, serviceName, listParams);

            synchronized (task) {
                task.execute().wait();
            }
            JSONArray respJSONSpinner = ConexionServicioTask.respJSON;

            String[] result = new String[respJSONSpinner.length()];

            if (result!=null && result.length>0){
                lstUtilizaciones = new ArrayList<>();
                respuesta = true;
                for (int j = 0; j < respJSONSpinner.length(); j++) {
                    JSONObject obj = respJSONSpinner.getJSONObject(j);

                    String consConvenio = (obj.getString("consConvenio")!= null && !obj.getString("consConvenio").equals("null")) ? obj.getString("consConvenio"):"";
                    String convenio = (obj.getString("convenio") != null && !obj.getString("convenio").equals("null")) ? obj.getString("convenio"):"";
                    String desde = (obj.getString("desde") != null && !obj.getString("desde").equals("null")) ? obj.getString("desde"):"";
                    String hasta = (obj.getString("hasta")!= null && !obj.getString("hasta").equals("null")) ? obj.getString("hasta"):"";

                    UtilizacionesDTO dto = new UtilizacionesDTO(convenio,desde,hasta,consConvenio);
                    lstUtilizaciones.add(dto);

                }
            }

        }catch (Exception e){
            Toast.makeText(contexto,e.getMessage(), Toast.LENGTH_LONG).show();
        }
        return respuesta ;
    }


    public static  boolean consultarNotasCreditoDebito(String serviceName, String listParams, Context contexto)throws Exception{

        boolean respuesta = false;

        try {

            ConexionServicioTask task = new ConexionServicioTask(contexto, serviceName, listParams);

            synchronized (task) {
                task.execute().wait();
            }
            JSONArray respJSONSpinner = ConexionServicioTask.respJSON;

            String[] result = new String[respJSONSpinner.length()];

            if (result!=null && result.length>0){
                lstNotaCreditoDebito = new ArrayList<>();
                respuesta = true;
                for (int j = 0; j < respJSONSpinner.length(); j++) {
                    JSONObject obj = respJSONSpinner.getJSONObject(j);

                    String consNota = (obj.getString("consNota")!= null && !obj.getString("consNota").equals("null")) ? obj.getString("consNota"):"";
                    String numeroNota = (obj.getString("numeroNota") != null && !obj.getString("numeroNota").equals("null")) ? obj.getString("numeroNota"):"";
                    String ciudad = (obj.getString("ciudad") != null && !obj.getString("ciudad").equals("null")) ? obj.getString("ciudad"):"";
                    String numeroFactura = (obj.getString("numeroFactura")!= null && !obj.getString("numeroFactura").equals("null")) ? obj.getString("numeroFactura"):"";
                    String fechaExpedicion = (obj.getString("fechaExpedicion") != null && !obj.getString("fechaExpedicion").equals("null")) ? obj.getString("fechaExpedicion"):"";
                    String fechaAprobacion = (obj.getString("fechaAprobacion") != null && !obj.getString("fechaAprobacion").equals("null")) ? obj.getString("fechaAprobacion"):"";
                    String proveedor = (obj.getString("proveedor")!= null && !obj.getString("proveedor").equals("null")) ? obj.getString("proveedor"):"";
                    String motivo = (obj.getString("motivo") != null && !obj.getString("motivo").equals("null")) ? obj.getString("motivo"):"";
                    String estado = (obj.getString("estado") != null && !obj.getString("estado").equals("null")) ? obj.getString("estado"):"";
                    String tipoNota = (obj.getString("tipoNota")!= null && !obj.getString("tipoNota").equals("null")) ? obj.getString("tipoNota"):"";
                    String valorTotalNotaCredito = (obj.getString("valorTotalNotaCredito")!= null && !obj.getString("valorTotalNotaCredito").equals("null")) ? obj.getString("valorTotalNotaCredito"):"";

                    NotaCreditoDebitoDTO dto = new NotaCreditoDebitoDTO(numeroNota,numeroFactura,fechaExpedicion,fechaAprobacion,ciudad,estado,proveedor,motivo, tipoNota,Utilities.formatearNumeroTexto(valorTotalNotaCredito),consNota);
                    lstNotaCreditoDebito.add(dto);

                }
            }

        }catch (Exception e){
            Toast.makeText(contexto,e.getMessage(), Toast.LENGTH_LONG).show();
        }
        return respuesta ;
    }



    public static  boolean consultarAutorizaciones(String serviceName, String listParams, Context contexto)throws Exception{

        boolean respuesta = false;

        try {

            ConexionServicioTask task = new ConexionServicioTask(contexto, serviceName, listParams);

            synchronized (task) {
                task.execute().wait();
            }

            JSONArray respJSONSpinner = ConexionServicioTask.respJSON;

            String[] result = new String[respJSONSpinner.length()];

            if (result!=null && result.length>0){
                autorizacionesList = new ArrayList<>();
                respuesta = true;
                for (int j = 0; j < respJSONSpinner.length(); j++) {
                    JSONObject obj = respJSONSpinner.getJSONObject(j);

                    String solicitudDescripcion =(obj.getString("solicitudDescripcion") != null && !obj.getString("solicitudDescripcion").equals("null")) ? obj.getString("solicitudDescripcion"):"";
                    String solicitudTipo = (obj.getString("solicitudTipo") != null && !obj.getString("solicitudTipo").equals("null")) ? obj.getString("solicitudTipo"):"";
                    String estado = (obj.getString("estado") != null && !obj.getString("estado").equals("null")) ? obj.getString("estado"):"";
                    String fechaRechazo = (obj.getString("fechaRechazo") != null && !obj.getString("fechaRechazo").equals("null")) ? obj.getString("fechaRechazo"):"";
                    String solicitaCreadoFecha = (obj.getString("solicitaCreadoFecha") != null && !obj.getString("solicitaCreadoFecha").equals("null")) ? obj.getString("solicitaCreadoFecha"):"";
                    String autorizaCreadoFecha = (obj.getString("autorizaCreadoFecha") != null && !obj.getString("autorizaCreadoFecha").equals("null")) ? obj.getString("autorizaCreadoFecha"):"";
                    String ciudad = (obj.getString("ciudad") != null && !obj.getString("ciudad").equals("null")) ? obj.getString("ciudad"):"";
                    String consDetAutorizacion = (obj.getString("consDetAutorizacion") != null && !obj.getString("consDetAutorizacion").equals("null")) ? obj.getString("consDetAutorizacion"):"";

                    AutorizacionesDTO dto = new AutorizacionesDTO(solicitudDescripcion, ciudad, solicitudTipo, solicitaCreadoFecha, estado, autorizaCreadoFecha, fechaRechazo,consDetAutorizacion);
                    autorizacionesList.add(dto);

                }
            }

        }catch (Exception e){
            Toast.makeText(contexto,e.getMessage(), Toast.LENGTH_LONG).show();
        }
        return respuesta ;
    }



    public static  boolean consultarDocumentosMedicos(String serviceName, String listParams, Context contexto)throws Exception{
        boolean respuesta = false;

        try {

            ConexionServicioTask task = new ConexionServicioTask(contexto, serviceName, listParams);

            synchronized (task) {
                task.execute().wait();
            }

            JSONArray respJSONSpinner = ConexionServicioTask.respJSON;

            String[] result = new String[respJSONSpinner.length()];

            if (result!=null && result.length>0){
                documentosMedicosList = new ArrayList<>();
                respuesta = true;
                for (int j = 0; j < respJSONSpinner.length(); j++) {
                    JSONObject obj = respJSONSpinner.getJSONObject(j);


                    String x = "No se ha e";
                    String tipoArchivo = obj.getString("tipoArchivo");
                    String nombreDocumento = obj.getString("nombreDocumento");
                    String archivo = obj.getString("archivo");
                    String id = obj.getString("id");

                    byte[] archivoArray = Base64.decode(archivo, Base64.DEFAULT);

                    DocumentosMedicosDTO dto = new DocumentosMedicosDTO(nombreDocumento, tipoArchivo, archivoArray, id);
                    documentosMedicosList.add(dto);

                }
            }

        }catch (Exception e){
            Toast.makeText(contexto,e.getMessage(), Toast.LENGTH_LONG).show();
        }
        return respuesta ;
    }

    public static  boolean consultarEncuesta(String serviceName, String listParams, Context contexto)throws Exception{

        boolean respuesta = false;

        try {

            ConexionServicioTask task = new ConexionServicioTask(contexto, serviceName, listParams);

            synchronized (task) {
                task.execute().wait();
            }

            JSONArray respJSONSpinner = ConexionServicioTask.respJSON;

            String[] result = new String[respJSONSpinner.length()];

            if (result!=null && result.length>0){
                lstEncuesta = new ArrayList<>();
                respuesta = true;
                for (int j = 0; j < respJSONSpinner.length(); j++) {
                    JSONObject obj = respJSONSpinner.getJSONObject(j);

                    String preguntaEncuesta = (obj.getString("pregunta")!= null && !obj.getString("pregunta").equals("null")) ? obj.getString("pregunta"):"";
                    String respuestaEncuesta = (obj.getString("respuesta") != null && !obj.getString("respuesta").equals("null")) ? obj.getString("respuesta"):"";
                    String observacionEncuesta = (obj.getString("observacion") != null && !obj.getString("observacion").equals("null")) ? obj.getString("observacion"):"";

                    EncuestaDTO dto = new EncuestaDTO(preguntaEncuesta,respuestaEncuesta,observacionEncuesta);
                    lstEncuesta.add(dto);

                }
            }

        }catch (Exception e){
            Toast.makeText(contexto,e.getMessage(), Toast.LENGTH_LONG).show();
        }
        return respuesta ;
    }

    public static  boolean consultarServicioNoAsistencial(String serviceName, String listParams, Context contexto)throws Exception{

        boolean respuesta = false;

        try {

            ConexionServicioTask task = new ConexionServicioTask(contexto, serviceName, listParams);

            synchronized (task) {
                task.execute().wait();
            }

            JSONArray respJSONSpinner = ConexionServicioTask.respJSON;

            String[] result = new String[respJSONSpinner.length()];

            if (result!=null && result.length>0){
                lstSolicitudNoAsistencial = new ArrayList<>();
                respuesta = true;
                for (int j = 0; j < respJSONSpinner.length(); j++) {
                    JSONObject obj = respJSONSpinner.getJSONObject(j);

                    String codSolicitud = (obj.getString("codSolicitud") != null && !obj.getString("codSolicitud").equals("null")) ? obj.getString("codSolicitud"):"";
                    String tipoSolicitud = (obj.getString("tipoSolicitud") != null && !obj.getString("tipoSolicitud").equals("null")) ? obj.getString("tipoSolicitud"):"";
                    String ciudad = (obj.getString("ciudad") != null && !obj.getString("ciudad").equals("null")) ? obj.getString("ciudad" ):"";
                    String estado = (obj.getString("estado") != null && !obj.getString("estado").equals("null")) ? obj.getString("estado"):"";
                    String justificacionCancelado = (obj.getString("justificacionCancelado") != null && !obj.getString("justificacionCancelado").equals("null")) ? obj.getString("justificacionCancelado"):"";
                    String consservicio = (obj.getString("consservicio") != null && !obj.getString("consservicio").equals("null")) ? obj.getString("consservicio"):"";

                    ServicioNoAsistencialDTO dto = new ServicioNoAsistencialDTO(codSolicitud,tipoSolicitud,justificacionCancelado,ciudad,estado,consservicio);
                    lstSolicitudNoAsistencial.add(dto);

                }
            }

        }catch (Exception e){
            Toast.makeText(contexto,e.getMessage(), Toast.LENGTH_LONG).show();
        }
        return respuesta ;
    }

    public static  boolean consultarGiros(String serviceName, String listParams, Context contexto)throws Exception{

        boolean respuesta = false;

        try {

            ConexionServicioTask task = new ConexionServicioTask(contexto, serviceName, listParams);

            synchronized (task) {
                task.execute().wait();
            }

            JSONArray respJSONSpinner = ConexionServicioTask.respJSON;

            String[] result = new String[respJSONSpinner.length()];

            if (result!=null && result.length>0){
                lstGiros = new ArrayList<>();
                respuesta = true;
                for (int j = 0; j < respJSONSpinner.length(); j++) {
                    JSONObject obj = respJSONSpinner.getJSONObject(j);

                    String cons = (obj.getString("cons") != null && !obj.getString("cons").equals("null")) ? obj.getString("cons"):"";
                    String id = (obj.getString("id") != null && !obj.getString("id").equals("null")) ? obj.getString("id"):"";
                    String ciudad = (obj.getString("ciudad") != null && !obj.getString("ciudad").equals("null")) ? obj.getString("ciudad" ):"";
                    String estado = (obj.getString("estado") != null && !obj.getString("estado").equals("null")) ? obj.getString("estado"):"";
                    String tipoGiro = (obj.getString("tipoGiro") != null && !obj.getString("tipoGiro").equals("null")) ? obj.getString("tipoGiro"):"";
                    String tipoBeneficiario = (obj.getString("tipoBeneficiario") != null && !obj.getString("tipoBeneficiario").equals("null")) ? obj.getString("tipoBeneficiario"):"";
                    String tipoIdentificacionBeneficiario = (obj.getString("tipoIdentificacionBeneficiario") != null && !obj.getString("tipoIdentificacionBeneficiario").equals("null")) ? obj.getString("tipoIdentificacionBeneficiario"):"";
                    String identificacionBeneficiario = (obj.getString("identificacionBeneficiario") != null && !obj.getString("identificacionBeneficiario").equals("null")) ? obj.getString("identificacionBeneficiario"):"";
                    String beneficiario = (obj.getString("beneficiario") != null && !obj.getString("beneficiario").equals("null")) ? obj.getString("beneficiario" ):"";
                    String fechaInicio = (obj.getString("fechaInicio") != null && !obj.getString("fechaInicio").equals("null")) ? obj.getString("fechaInicio"):"";
                    String fechaFin = (obj.getString("fechaFin") != null && !obj.getString("fechaFin").equals("null")) ? obj.getString("fechaFin"):"";
                    String valorMonedaExtranjera = (obj.getString("valorMonedaExtranjera") != null && !obj.getString("valorMonedaExtranjera").equals("null")) ? obj.getString("valorMonedaExtranjera"):"";
                    String valorMonedaLocal = (obj.getString("valorMonedaLocal") != null && !obj.getString("valorMonedaLocal").equals("null")) ? obj.getString("valorMonedaLocal" ):"";
                    String registraDevolucion = (obj.getString("registraDevolucion") != null && !obj.getString("registraDevolucion").equals("null")) ? obj.getString("registraDevolucion"):"";
                    String valorDevolucion = (obj.getString("valorDevolucion") != null && !obj.getString("valorDevolucion").equals("null")) ? obj.getString("valorDevolucion"):"";
                    String legalizado = (obj.getString("legalizado") != null && !obj.getString("legalizado").equals("null")) ? obj.getString("legalizado"):"";
                    String valorLegalizado = (obj.getString("valorLegalizado") != null && !obj.getString("valorLegalizado").equals("null")) ? obj.getString("valorLegalizado" ):"";
                    String justificacionAnulacion = (obj.getString("justificacionAnulacion") != null && !obj.getString("justificacionAnulacion").equals("null")) ? obj.getString("justificacionAnulacion"):"";
                    String aprobadorGiro = (obj.getString("aprobadorGiro") != null && !obj.getString("aprobadorGiro").equals("null")) ? obj.getString("aprobadorGiro"):"";

                    GirosDTO dto = new GirosDTO(id,ciudad,estado,tipoGiro,tipoBeneficiario,tipoIdentificacionBeneficiario,identificacionBeneficiario,beneficiario,
                            fechaInicio,fechaFin,Utilities.formatearNumeroTexto(valorMonedaExtranjera),Utilities.formatearNumeroTexto(valorMonedaLocal),registraDevolucion,Utilities.formatearNumeroTexto(valorDevolucion),legalizado,Utilities.formatearNumeroTexto(valorLegalizado),justificacionAnulacion,aprobadorGiro,cons);
                    lstGiros.add(dto);

                }
            }

        }catch (Exception e){
            Toast.makeText(contexto,e.getMessage(), Toast.LENGTH_LONG).show();
        }
        return respuesta ;
    }
    public static  boolean consultarInformesMedicos(String serviceName, String listParams, Context contexto)throws Exception{

        boolean respuesta = false;

        try {

            ConexionServicioTask task = new ConexionServicioTask(contexto, serviceName, listParams);

            synchronized (task) {
                task.execute().wait();
            }

            JSONArray respJSONSpinner = ConexionServicioTask.respJSON;

            String[] result = new String[respJSONSpinner.length()];

            if (result!=null && result.length>0){
                lstInformesMedicos = new ArrayList<>();
                respuesta = true;
                for (int j = 0; j < respJSONSpinner.length(); j++) {
                    JSONObject obj = respJSONSpinner.getJSONObject(j);

                    String creadoFecha = (obj.getString("creadoFecha") != null && !obj.getString("creadoFecha").equals("null")) ? obj.getString("creadoFecha"):"";
                    String dadoAlta = (obj.getString("dadoAlta") != null && !obj.getString("dadoAlta").equals("null")) ? obj.getString("dadoAlta"):"";
                    String fallecido = (obj.getString("fallecido") != null && !obj.getString("fallecido").equals("null")) ? obj.getString("fallecido"):"";
                    String pacienteEstado = (obj.getString("pacienteEstado") != null && !obj.getString("pacienteEstado").equals("null")) ? obj.getString("pacienteEstado"):"";
                   // String tipoSolicitud = (obj.getString("cons") != null && !obj.getString("cons").equals("null")) ? obj.getString("cons"):"";
                    String ciudad = (obj.getString("ciudad") != null && !obj.getString("ciudad").equals("null")) ? obj.getString("ciudad"):"";
                    String consInformeMedico = (obj.getString("consInformeMedico") != null && !obj.getString("consInformeMedico").equals("null")) ? obj.getString("consInformeMedico"):"";

                    if (dadoAlta==null){
                        dadoAlta = "";
                    }else if (dadoAlta.equals("true")){
                        dadoAlta = "SI";
                    }else if (dadoAlta.equals("false")){
                        dadoAlta = "NO";
                    }

                    if (fallecido==null){
                        fallecido = "";
                    }else if (fallecido.equals("true")){
                        fallecido = "SI";
                    }else if (fallecido.equals("false")){
                        fallecido = "NO";
                    }


                    InformesMedicosDTO dto = new InformesMedicosDTO(ciudad, dadoAlta, fallecido, creadoFecha, pacienteEstado, consInformeMedico);
                    lstInformesMedicos.add(dto);

                }
            }

        }catch (Exception e){
            Toast.makeText(contexto,e.getMessage(), Toast.LENGTH_LONG).show();
        }
        return respuesta ;
    }

    public static  boolean consultarEpicrisis(String serviceName, String listParams, Context contexto)throws Exception{
        boolean respuesta = false;

        try {

            ConexionServicioTask task = new ConexionServicioTask(contexto, serviceName, listParams);

            synchronized (task) {
                task.execute().wait();
            }

            JSONArray respJSONSpinner = ConexionServicioTask.respJSON;

            String[] result = new String[respJSONSpinner.length()];

            if (result!=null && result.length>0){
                lstEpicrisis = new ArrayList<>();
                respuesta = true;
                for (int j = 0; j < respJSONSpinner.length(); j++) {
                    JSONObject obj = respJSONSpinner.getJSONObject(j);

                    String nombreDocumento = obj.getString("nombreDocumento");
                    String archivo = obj.getString("archivo");

                    byte[] archivoArray = Base64.decode(archivo, Base64.DEFAULT);

                    DocumentosMedicosDTO dto = new DocumentosMedicosDTO(nombreDocumento, null, archivoArray,"");
                    lstEpicrisis.add(dto);

                }
            }

        }catch (Exception e){
            Toast.makeText(contexto,e.getMessage(), Toast.LENGTH_LONG).show();
        }
        return respuesta ;
    }

    public static  boolean consultarProcedimientosAdicionales(String serviceName, String listParams, Context contexto)throws Exception{
        boolean respuesta = false;

        try {

            ConexionServicioTask task = new ConexionServicioTask(contexto, serviceName, listParams);

            synchronized (task) {
                task.execute().wait();
            }

            JSONArray respJSONSpinner = ConexionServicioTask.respJSON;

            String[] result = new String[respJSONSpinner.length()];

            if (result!=null && result.length>0){
                lstProcedimientosAdicionales = new ArrayList<>();
                respuesta = true;
                for (int j = 0; j < respJSONSpinner.length(); j++) {
                    JSONObject obj = respJSONSpinner.getJSONObject(j);

                    String procedimientoSolicitado = (obj.getString("procedimientoSolicitado") != null && !obj.getString("procedimientoSolicitado").equals("null")) ? obj.getString("procedimientoSolicitado"):"";
                    String ciudad = (obj.getString("ciudad") != null && !obj.getString("ciudad").equals("null")) ? obj.getString("ciudad"):"";
                    String prestadorNombre = (obj.getString("prestadorNombre") != null && !obj.getString("prestadorNombre").equals("null")) ? obj.getString("prestadorNombre"):"";

                    ProcedimientosAdicionalesDTO dto = new ProcedimientosAdicionalesDTO(procedimientoSolicitado, prestadorNombre, ciudad);
                    lstProcedimientosAdicionales.add(dto);

                }
            }

        }catch (Exception e){
            Toast.makeText(contexto,e.getMessage(), Toast.LENGTH_LONG).show();
        }
        return respuesta ;
    }

    public static  boolean consultarFuncionariosExternos(String serviceName, String listParams, Context contexto)throws Exception{
        boolean respuesta = false;

        try {

            ConexionServicioTask task = new ConexionServicioTask(contexto, serviceName, listParams);

            synchronized (task) {
                task.execute().wait();
            }

            JSONArray respJSONSpinner = ConexionServicioTask.respJSON;

            String[] result = new String[respJSONSpinner.length()];

            if (result!=null && result.length>0){
                lstFuncionariosExternos = new ArrayList<>();
                respuesta = true;
                for (int j = 0; j < respJSONSpinner.length(); j++) {
                    JSONObject obj = respJSONSpinner.getJSONObject(j);

                    String fechaCita = (obj.getString("fechaCita") != null && !obj.getString("fechaCita").equals("null")) ? obj.getString("fechaCita"):"";
                    String nombreMedico = (obj.getString("nombreMedico") != null && !obj.getString("nombreMedico").equals("null")) ? obj.getString("nombreMedico"):"";
                    String especialidad = (obj.getString("especialidad") != null && !obj.getString("especialidad").equals("null")) ? obj.getString("especialidad"):"";
                    String prestadorSolicitud = (obj.getString("prestadorSolicitud") != null && !obj.getString("prestadorSolicitud").equals("null")) ? obj.getString("prestadorSolicitud"):"";

                    FuncionariosExternosDTO dto = new FuncionariosExternosDTO(prestadorSolicitud,nombreMedico, especialidad, fechaCita);
                    lstFuncionariosExternos.add(dto);

                }
            }

        }catch (Exception e){
            Toast.makeText(contexto,e.getMessage(), Toast.LENGTH_LONG).show();
        }
        return respuesta ;
    }

    public static  boolean consultarFactura(String serviceName, String listParams, Context contexto)throws Exception{
        boolean respuesta = false;

        try {

            ConexionServicioTask task = new ConexionServicioTask(contexto, serviceName, listParams);

            synchronized (task) {
                task.execute().wait();
            }

            JSONArray respJSONSpinner = ConexionServicioTask.respJSON;

            String[] result = new String[respJSONSpinner.length()];

            if (result!=null && result.length>0){
                lstFacturaDTO = new ArrayList<>();
                respuesta = true;
                for (int j = 0; j < respJSONSpinner.length(); j++) {
                    JSONObject obj = respJSONSpinner.getJSONObject(j);

                    String facturaNro = (obj.getString("facturaNro") != null && !obj.getString("facturaNro").equals("null")) ? obj.getString("facturaNro"):"";
                    String fechaExpedicion = (obj.getString("fechaExpedicion") != null && !obj.getString("fechaExpedicion").equals("null")) ? obj.getString("fechaExpedicion"):"";
                    String ciudad = (obj.getString("ciudad") != null && !obj.getString("ciudad").equals("null")) ? obj.getString("ciudad"):"";
                    String estado = (obj.getString("estado") != null && !obj.getString("estado").equals("null")) ? obj.getString("estado"):"";
                    String fechaRadicacion = (obj.getString("fechaRadicacion") != null && !obj.getString("fechaRadicacion").equals("null")) ? obj.getString("fechaRadicacion"):"";
                    String fechaAprobacion = (obj.getString("fechaAprobacion") != null && !obj.getString("fechaAprobacion").equals("null")) ? obj.getString("fechaAprobacion"):"";
                    String fechaAnulacion = (obj.getString("fechaAnulacion") != null && !obj.getString("fechaAnulacion").equals("null")) ? obj.getString("fechaAnulacion"):"";
                    String valorIva = (obj.getString("valorIva") != null && !obj.getString("valorIva").equals("null")) ? obj.getString("valorIva"):"";
                    String valorTotalFactura = (obj.getString("valorTotalFactura") != null && !obj.getString("valorTotalFactura").equals("null")) ? obj.getString("valorTotalFactura"):"";
                    String valorTotalPagar = (obj.getString("valorTotalPagar") != null && !obj.getString("valorTotalPagar").equals("null")) ? obj.getString("valorTotalPagar"):"";
                    String proveedor = (obj.getString("proveedor") != null && !obj.getString("proveedor").equals("null")) ? obj.getString("proveedor"):"";
                    String tipoSolicitud = (obj.getString("tipoServicio") != null && !obj.getString("tipoServicio").equals("null")) ? obj.getString("tipoServicio"):"";
                    String consFactura = (obj.getString("consFactura") != null && !obj.getString("consFactura").equals("null")) ? obj.getString("consFactura"):"";

                    FacturaDTO dto = new FacturaDTO(facturaNro, fechaExpedicion, estado, Utilities.formatearNumeroTexto(valorTotalFactura), ciudad, fechaRadicacion, fechaAprobacion, fechaAnulacion, Utilities.formatearNumeroTexto(valorIva), Utilities.formatearNumeroTexto(valorTotalPagar), proveedor, tipoSolicitud, consFactura);
                    lstFacturaDTO.add(dto);

                }
            }

        }catch (Exception e){
            Toast.makeText(contexto,e.getMessage(), Toast.LENGTH_LONG).show();
        }
        return respuesta ;
    }

    public static  boolean consultarNotasCreditoGiro(String serviceName, String listParams, Context contexto) throws Exception{

        boolean respuesta = false;

        try {

            ConexionServicioTask task = new ConexionServicioTask(contexto, serviceName, listParams);

            synchronized (task) {
                task.execute().wait();
            }
            JSONArray respJSONSpinner = ConexionServicioTask.respJSON;

            String[] result = new String[respJSONSpinner.length()];

            if (result!=null && result.length>0){
                lstNotaCreditoGiro = new ArrayList<>();
                respuesta = true;
                for (int j = 0; j < respJSONSpinner.length(); j++) {
                    JSONObject obj = respJSONSpinner.getJSONObject(j);

                    String notaCredito = (obj.getString("notaCredito")!= null && !obj.getString("notaCredito").equals("null")) ? obj.getString("notaCredito"):"";
                    String ciudad = (obj.getString("ciudad") != null && !obj.getString("ciudad").equals("null")) ? obj.getString("ciudad"):"";
                    String giroAsociado = (obj.getString("giroAsociado") != null && !obj.getString("giroAsociado").equals("null")) ? obj.getString("giroAsociado"):"";
                    String tipoBeneficiario = (obj.getString("tipoBeneficiario")!= null && !obj.getString("tipoBeneficiario").equals("null")) ? obj.getString("tipoBeneficiario"):"";
                    String beneficiario = (obj.getString("beneficiario") != null && !obj.getString("beneficiario").equals("null")) ? obj.getString("beneficiario"):"";
                    String estado = (obj.getString("estado") != null && !obj.getString("estado").equals("null")) ? obj.getString("estado"):"";
                    String tipoGiro = (obj.getString("tipoGiro")!= null && !obj.getString("tipoGiro").equals("null")) ? obj.getString("tipoGiro"):"";
                    String valorNota = (obj.getString("valorNota") != null && !obj.getString("valorNota").equals("null")) ? obj.getString("valorNota"):"";
                    String fechaRegistro = (obj.getString("fechaRegistro") != null && !obj.getString("fechaRegistro").equals("null")) ? obj.getString("fechaRegistro"):"";
                    String fechaLiquidacion = (obj.getString("fechaLiquidacion")!= null && !obj.getString("fechaLiquidacion").equals("null")) ? obj.getString("fechaLiquidacion"):"";


                    NotaCreditoGiroDTO dto = new NotaCreditoGiroDTO(notaCredito,ciudad,giroAsociado,tipoBeneficiario,beneficiario,estado,tipoGiro, Utilities.formatearNumeroTexto(valorNota),fechaRegistro,fechaLiquidacion);
                    lstNotaCreditoGiro.add(dto);

                }
            }

        }catch (Exception e){
            Toast.makeText(contexto,e.getMessage(), Toast.LENGTH_LONG).show();
        }
        return respuesta ;
    }

    public static  boolean consultarServiciosAsistenciales(String serviceName, String listParams, Context contexto) throws Exception{

        boolean respuesta = false;

        try {

            ConexionServicioTask task = new ConexionServicioTask(contexto, serviceName, listParams);

            synchronized (task) {
                task.execute().wait();
            }
            JSONArray respJSONSpinner = ConexionServicioTask.respJSON;

            String[] result = new String[respJSONSpinner.length()];

            if (result!=null && result.length>0){
                lstServiciosAsistenciales = new ArrayList<>();
                respuesta = true;
                for (int j = 0; j < respJSONSpinner.length(); j++) {
                    JSONObject obj = respJSONSpinner.getJSONObject(j);

                    String numeroOrden = (obj.getString("numerioSias")!= null && !obj.getString("numerioSias").equals("null")) ? obj.getString("numerioSias"):"";
                    String sucursal = (obj.getString("ciudad") != null && !obj.getString("ciudad").equals("null")) ? obj.getString("ciudad"):"";
                    String idPrestador = (obj.getString("idPrestador") != null && !obj.getString("idPrestador").equals("null")) ? obj.getString("idPrestador"):"";
                    String nombrePrestador = (obj.getString("nombrePrestador")!= null && !obj.getString("nombrePrestador").equals("null")) ? obj.getString("nombrePrestador"):"";
                    String tipoServicio = (obj.getString("nombreServicio") != null && !obj.getString("nombreServicio").equals("null")) ? obj.getString("nombreServicio"):"";
                    String codigoProcedimiento = (obj.getString("codigoProcedimiento") != null && !obj.getString("codigoProcedimiento").equals("null")) ? obj.getString("codigoProcedimiento"):"";
                    String procedimientoEspanol = (obj.getString("nombreEspanol")!= null && !obj.getString("nombreEspanol").equals("null")) ? obj.getString("nombreEspanol"):"";
                    String procedimientoIngles = (obj.getString("nombreIngles") != null && !obj.getString("nombreIngles").equals("null")) ? obj.getString("nombreIngles"):"";
                    String cantidad = (obj.getString("cantidad") != null && !obj.getString("cantidad").equals("null")) ? obj.getString("cantidad"):"";
                    String estado = (obj.getString("estado")!= null && !obj.getString("estado").equals("null")) ? obj.getString("estado"):"";
                    String fechaString = (obj.getString("fecha")!= null && !obj.getString("fecha").equals("null")) ? obj.getString("fecha"):"";
                    String id = (obj.getString("id")!= null && !obj.getString("id").equals("null")) ? obj.getString("id"):"";

                    ServicioAsistencialDTO dto = new ServicioAsistencialDTO(numeroOrden,sucursal,idPrestador,nombrePrestador,tipoServicio,codigoProcedimiento,procedimientoEspanol,procedimientoIngles, cantidad,estado,fechaString,id);
                    lstServiciosAsistenciales.add(dto);

                }
            }

        }catch (Exception e){
            Toast.makeText(contexto,e.getMessage(), Toast.LENGTH_LONG).show();
        }
        return respuesta ;
    }

    public static  boolean consultarSolicitudAprobacion(String serviceName, String listParams, Context contexto) throws Exception{

        boolean respuesta = false;

        try {

            ConexionServicioTask task = new ConexionServicioTask(contexto, serviceName, listParams);

            synchronized (task) {
                task.execute().wait();
            }
            JSONArray respJSONSpinner = ConexionServicioTask.respJSON;

            String[] result = new String[respJSONSpinner.length()];

            if (result!=null && result.length>0){
                lstSolicitudAprobacion = new ArrayList<ConsultaSolicitudDTO>();
                respuesta = true;
                for (int j = 0; j < respJSONSpinner.length(); j++) {
                    JSONObject obj = respJSONSpinner.getJSONObject(j);

                    String solicitudDescripcion = (obj.getString("solicitudDescripcion")!= null && !obj.getString("solicitudDescripcion").equals("null")) ? obj.getString("solicitudDescripcion"):"";
                    String nombrePaciente = (obj.getString("nombrePaciente") != null && !obj.getString("nombrePaciente").equals("null")) ? obj.getString("nombrePaciente"):"";
                    String tipoAutorizacion = (obj.getString("tipoAutorizacion") != null && !obj.getString("tipoAutorizacion").equals("null")) ? obj.getString("tipoAutorizacion"):"";
                    String estado = (obj.getString("estado")!= null && !obj.getString("estado").equals("null")) ? obj.getString("estado"):"";
                    String tipoEntidad = (obj.getString("tipoEntidad") != null && !obj.getString("tipoEntidad").equals("null")) ? obj.getString("tipoEntidad"):"";
                    String solicitante = (obj.getString("solicitante") != null && !obj.getString("solicitante").equals("null")) ? obj.getString("solicitante"):"";
                    String fechaSolicitud = (obj.getString("fechaSolicitud")!= null && !obj.getString("fechaSolicitud").equals("null")) ? obj.getString("fechaSolicitud"):"";
                    String autoriza = (obj.getString("autoriza") != null && !obj.getString("autoriza").equals("null")) ? obj.getString("autoriza"):"";
                    String fechaAutorizacion = (obj.getString("fechaAutorizacion") != null && !obj.getString("fechaAutorizacion").equals("null")) ? obj.getString("fechaAutorizacion"):"";
                    String servicio = (obj.getString("servicio")!= null && !obj.getString("servicio").equals("null")) ? obj.getString("servicio"):"";
                    String proveedor = (obj.getString("proveedor")!= null && !obj.getString("proveedor").equals("null")) ? obj.getString("proveedor"):"";
                    String prestador = (obj.getString("prestador")!= null && !obj.getString("prestador").equals("null")) ? obj.getString("prestador"):"";
                    String justificacion = (obj.getString("justificacion")!= null && !obj.getString("justificacion").equals("null")) ? obj.getString("justificacion"):"";
                    String idAprobacion = (obj.getString("idAprobacion")!= null && !obj.getString("idAprobacion").equals("null")) ? obj.getString("idAprobacion"):"";



                    ConsultaSolicitudDTO dto = new ConsultaSolicitudDTO(nombrePaciente,estado,fechaSolicitud,solicitudDescripcion,tipoAutorizacion,tipoEntidad,solicitante,autoriza, fechaAutorizacion,servicio,proveedor,
                            prestador, justificacion,"","","","","","","","","",idAprobacion);
                    lstSolicitudAprobacion.add(dto);

                }
            }

        }catch (Exception e){
            Toast.makeText(contexto,e.getMessage(), Toast.LENGTH_LONG).show();
        }
        return respuesta ;
    }

}


