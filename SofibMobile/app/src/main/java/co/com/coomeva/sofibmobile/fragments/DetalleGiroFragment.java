package co.com.coomeva.sofibmobile.fragments;

import android.os.Bundle;
import android.os.Environment;
import android.support.annotation.Nullable;
import android.support.design.widget.FloatingActionButton;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import org.json.JSONArray;
import org.json.JSONObject;

import java.io.File;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

import co.com.coomeva.sofibmobile.LoginView;
import co.com.coomeva.sofibmobile.R;
import co.com.coomeva.sofibmobile.dto.ConceptosDTO;
import co.com.coomeva.sofibmobile.dto.DetalleGiroDTO;
import co.com.coomeva.sofibmobile.dto.DetalleServicioNoAsistencialDTO;
import co.com.coomeva.sofibmobile.dto.HistoricoGirosDTO;
import co.com.coomeva.sofibmobile.dto.ManutencionDTO;
import co.com.coomeva.sofibmobile.dto.ServicioAdicionalDTO;
import co.com.coomeva.sofibmobile.modelo.Usuario;
import co.com.coomeva.sofibmobile.task.ConexionDescargaArchivoTask;
import co.com.coomeva.sofibmobile.task.ConexionServicioListaTask;
import co.com.coomeva.sofibmobile.utils.Utilities;

/**
 * Created by JuanCamilo on 9/25/16.
 */
public class DetalleGiroFragment extends Fragment{

    private TextView txtId;
    private TextView txtCiudad;
    private TextView txtEstado;
    private TextView txtTipoGiro;
    private TextView txtTipoBeneficiario;
    private TextView txtTipoIdentificacionBeneficiario;
    private TextView txtIdentificacionBeneficiario;
    private TextView txtBeneficiario;
    private TextView txtFechaInicio;
    private TextView txtFechaFin;
    private TextView txtValorMonedaExtranjero;
    private TextView txtValorMonedaLocal;
    private TextView txtRegistraDevolucion;
    private TextView txtValorDevolucion;
    private TextView txtLegalizado;
    private TextView txtValorLegalizado;
    private TextView txtJustificacionAnulacion;
    private TextView txtAprobadoGiro;

    private FloatingActionButton btnDetalle;
    private FloatingActionButton btnDescargar;

    private List<ManutencionDTO> lstManutencion = new ArrayList<ManutencionDTO>();
    private List<ConceptosDTO> lstConceptos = new ArrayList<ConceptosDTO>();
    private List<HistoricoGirosDTO> lstHistoricoGiro= new ArrayList<HistoricoGirosDTO>();
    public static DetalleGiroDTO detalleGiroDTO;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_detalle_giro, container, false);

        //Se enlaza los componentes Android al fragment
        txtId = (TextView) view.findViewById(R.id.txtId);
        txtCiudad = (TextView) view.findViewById(R.id.txtCiudad);
        txtEstado = (TextView) view.findViewById(R.id.txtEstado);
        txtTipoGiro = (TextView) view.findViewById(R.id.txtTipoGiro);
        txtTipoBeneficiario = (TextView) view.findViewById(R.id.txtTipoBeneficiario);
        txtTipoIdentificacionBeneficiario = (TextView) view.findViewById(R.id.txtTipoIdentificacionBeneficiario);
        txtIdentificacionBeneficiario = (TextView) view.findViewById(R.id.txtIdentificacionBeneficiario);
        txtBeneficiario = (TextView) view.findViewById(R.id.txtBeneficiario);
        txtFechaInicio = (TextView) view.findViewById(R.id.txtFechaInicio);
        txtFechaFin = (TextView) view.findViewById(R.id.txtFechaFin);
        txtValorMonedaExtranjero = (TextView) view.findViewById(R.id.txtValorMonedaExtranjero);
        txtValorMonedaLocal = (TextView) view.findViewById(R.id.txtValorMonedaLocal);
        txtRegistraDevolucion = (TextView) view.findViewById(R.id.txtRegistraDevolucion);
        txtValorDevolucion = (TextView) view.findViewById(R.id.txtValorDevolucion);
        txtLegalizado = (TextView) view.findViewById(R.id.txtLegalizado);
        txtValorLegalizado = (TextView) view.findViewById(R.id.txtValorLegalizado);
        txtJustificacionAnulacion = (TextView) view.findViewById(R.id.txtJustificacionAnulacion);
        txtAprobadoGiro = (TextView) view.findViewById(R.id.txtAprobadoGiro);

        btnDetalle = (FloatingActionButton) view.findViewById(R.id.btnDetalle);
        btnDescargar = (FloatingActionButton) view.findViewById(R.id.btnDescargar);
        try {


        //Se colocan los datos del giro estatica del View a los componentes para mostrar su informacion
        txtId.setText(getResources().getString(R.string.lbl_numero_solicitud) + ": "+GiroFragment.giro.getId());
        txtEstado.setText(getResources().getString(R.string.lbl_estado) + ": "+GiroFragment.giro.getEstado());
        txtTipoGiro.setText(getResources().getString(R.string.lbl_tipo_giro) + ": "+GiroFragment.giro.getTipoGiro());
        txtIdentificacionBeneficiario.setText(getResources().getString(R.string.lbl_identificacion_beneficiario) + ": "+GiroFragment.giro.getIdentificacionBeneficiario());
        txtBeneficiario.setText(getResources().getString(R.string.lbl_beneficiario) + ": "+GiroFragment.giro.getBeneficiario());
        txtCiudad.setText(GiroFragment.giro.getCiudad());
        txtTipoBeneficiario.setText(GiroFragment.giro.getTipoBeneficiario());
        txtTipoIdentificacionBeneficiario.setText(GiroFragment.giro.getTipoIdentificacionBeneficiario());
        txtFechaInicio.setText(GiroFragment.giro.getFechaInicioTexto());
        txtFechaFin.setText(GiroFragment.giro.getFechaFinTexto());
        txtValorMonedaExtranjero.setText(GiroFragment.giro.getValorMonedaExtranjeroTexto());
        txtValorMonedaLocal.setText(GiroFragment.giro.getValorMonedaLocalTexto());
        txtRegistraDevolucion.setText(GiroFragment.giro.getRegistraDevolucion());
        txtValorDevolucion.setText(GiroFragment.giro.getValorDevolucionTexto());
        txtLegalizado.setText(GiroFragment.giro.getLegalizado());
        txtValorLegalizado.setText(GiroFragment.giro.getValorLegalizadoTexto());
        txtJustificacionAnulacion.setText(GiroFragment.giro.getJustificacionAnulacion());
        txtAprobadoGiro.setText(GiroFragment.giro.getAprobadorGiro());

        }catch (Exception e) {
            Toast.makeText(view.getContext(), e.getMessage(), Toast.LENGTH_LONG).show();
        }

        btnDetalle.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                try {

                    String params = getActivity().getResources().getString(R.string.address_service_token)+ GiroFragment.giro.getCons();
                    if (consultarDetalleGiro(getActivity().getResources().getString(R.string.complement_giro_detalle), params)){

                        FragmentTransaction ft = getActivity().getSupportFragmentManager().beginTransaction();
                        Fragment fragment = new TabGiroFragment();
                        fragment.setArguments(getActivity().getIntent().getExtras());
                        ft.replace(R.id.fragment_container_giro, fragment, "TabGiroFragment").addToBackStack("TabGiroFragment").commit();

                    }else {
                        throw new Exception(getActivity().getResources().getString(R.string.lbl_sin_resultados));
                    }

                }catch (Exception e) {
                    Toast.makeText(view.getContext(), e.getMessage(), Toast.LENGTH_LONG).show();
                }
            }
        });

        btnDescargar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                try {

//                    String params = "http://pruebas-sofib.coomeva.com.co/cni-web/exportDocument?format=pdf&useDataSource=true&reportName=reporteGiro&ID_GIRO="+GiroFragment.giro.getCons()+"&NOMBRE_ROL="+ LoginView.usuarioSesion.getRol();
                    String params = "http://sofib.coomeva.com.co/cni-web/exportDocument?format=pdf&useDataSource=true&reportName=reporteGiro&ID_GIRO="+GiroFragment.giro.getCons()+"&NOMBRE_ROL="+ LoginView.usuarioSesion.getRol();

                    ConexionDescargaArchivoTask task = new ConexionDescargaArchivoTask(getActivity(),params, "");

                    synchronized (task) {
                        task.execute().wait();
                    }

                }catch (Exception e) {
                    Toast.makeText(view.getContext(), e.getMessage(), Toast.LENGTH_LONG).show();
                }
            }
        });

        Toast.makeText(view.getContext(), getActivity().getResources().getString(R.string.toast_scroll), Toast.LENGTH_LONG).show();

        return view;
    }





    private boolean consultarDetalleGiro(String serviceName, String listParams){

        boolean respuesta = false;

        try {

            ConexionServicioListaTask task = new ConexionServicioListaTask(getActivity(), serviceName, listParams);

            detalleGiroDTO = new DetalleGiroDTO();

            synchronized (task) {
                task.execute().wait();
            }

            if (ConexionServicioListaTask.respJSON !=null){
                respuesta = true;
                JSONObject obj = ConexionServicioListaTask.respJSON;

                String beneficiario = (obj.getString("beneficiario") != null && !obj.getString("beneficiario").equals("null")) ? obj.getString("beneficiario"):"";
                String fechaInicio = (obj.getString("fechaInicio") != null && !obj.getString("fechaInicio").equals("null")) ? obj.getString("fechaInicio"):"";
                String fechaFin = (obj.getString("fechaFin") != null && !obj.getString("fechaFin").equals("null")) ? obj.getString("fechaFin" ):"";
                String acompañanteMonto = (obj.getString("acompañanteMonto") != null && !obj.getString("acompañanteMonto").equals("null")) ? obj.getString("acompañanteMonto"):"";

                detalleGiroDTO.setBeneficiario(beneficiario);
                detalleGiroDTO.setFechaInicioTexto(fechaInicio);
                detalleGiroDTO.setFechaFinTexto(fechaFin);
                detalleGiroDTO.setMontoDiarioAcompañanteTexto(Utilities.formatearNumeroTexto(acompañanteMonto));

                ///////////////////////////////////////////////////////////////////////////////
                JSONArray jsonArraManutencios = obj.optJSONArray("manutencion");

//                if(lstManutencion == null){
                    lstManutencion = new ArrayList<ManutencionDTO>();
//                }

                for (int x = 0; x < jsonArraManutencios.length(); x++) {
                    JSONObject manutencion = jsonArraManutencios.getJSONObject(x);

                    String estado = (manutencion.getString("estado") != null && !manutencion.getString("estado").equals("null")) ? manutencion.getString("estado"):"";
                    String edadDesde = (manutencion.getString("edadDesde") != null && !manutencion.getString("edadDesde").equals("null")) ? manutencion.getString("edadDesde"):"";
                    String edadHasta = (manutencion.getString("edadHasta") != null && !manutencion.getString("edadHasta").equals("null")) ? manutencion.getString("edadHasta" ):"";
                    String montoDiario = (manutencion.getString("montoDiario") != null && !manutencion.getString("montoDiario").equals("null")) ? manutencion.getString("montoDiario" ):"";

                    ManutencionDTO manutencionDTO = new ManutencionDTO(estado,edadHasta,edadDesde,Utilities.formatearNumeroTexto(montoDiario));
                    lstManutencion.add(manutencionDTO);
                }

                detalleGiroDTO.setLstManutencion(lstManutencion);

                ///////////////////////////////////////////////////////////////////////////////


                JSONArray jsonArrayConcepto = obj.optJSONArray("concepto");

//                if(lstConceptos == null){
                    lstConceptos = new ArrayList<ConceptosDTO>();
//                }

                Double subTotalConcepto = 0d;
                Double totalConcepto = 0d;


                for (int x = 0; x < jsonArrayConcepto.length(); x++) {
                    JSONObject manutencion = jsonArrayConcepto.getJSONObject(x);

                    String concepto = (manutencion.getString("concepto") != null && !manutencion.getString("concepto").equals("null")) ? manutencion.getString("concepto"):"";
                    String descripcion = (manutencion.getString("descripcion") != null && !manutencion.getString("descripcion").equals("null")) ? manutencion.getString("descripcion"):"";
                    String cantidad = (manutencion.getString("cantidad") != null && !manutencion.getString("cantidad").equals("null")) ? manutencion.getString("cantidad" ):"";
                    String valor = (manutencion.getString("valor") != null && !manutencion.getString("valor").equals("null")) ? manutencion.getString("valor" ):"";
                    String reliquidacion = (manutencion.getString("reliquidacion") != null && !manutencion.getString("reliquidacion").equals("null")) ? manutencion.getString("reliquidacion"):"";
                    String subtotal = (manutencion.getString("subtotal") != null && !manutencion.getString("subtotal").equals("null")) ? manutencion.getString("subtotal"):"";
                    String trm = (manutencion.getString("trm") != null && !manutencion.getString("trm").equals("null")) ? manutencion.getString("trm" ):"";
                    String total = (manutencion.getString("total") != null && !manutencion.getString("total").equals("null")) ? manutencion.getString("total" ):"";

                    subTotalConcepto =  subTotalConcepto + Double.parseDouble(subtotal);
                    totalConcepto = totalConcepto + Double.parseDouble(total);


                    ConceptosDTO conceptoDTO = new ConceptosDTO(concepto,descripcion,cantidad,Utilities.formatearNumeroTexto(valor),reliquidacion,Utilities.formatearNumeroTexto(subtotal),Utilities.formatearNumeroTexto(trm),Utilities.formatearNumeroTexto(total));
                    lstConceptos.add(conceptoDTO);
                }

                detalleGiroDTO.setLstConceptos(lstConceptos);

                ///////////////////////////////////////////////////////////////////////////////

                JSONObject jsonHistorico = obj.optJSONObject("historico");
               // JSONArray jsonArrayHistorico = jsonHistorico.optJSONArray("concepto");


//                if(lstHistoricoGiro == null){
                    lstHistoricoGiro = new ArrayList<HistoricoGirosDTO>();
//                }

                if(jsonHistorico != null) {

                        String id = (jsonHistorico.getString("id") != null && !jsonHistorico.getString("id").equals("null")) ? jsonHistorico.getString("id") : "";
                        String ciudad = (jsonHistorico.getString("ciudad") != null && !jsonHistorico.getString("ciudad").equals("null")) ? jsonHistorico.getString("ciudad") : "";
                        String estado = (jsonHistorico.getString("estado") != null && !jsonHistorico.getString("estado").equals("null")) ? jsonHistorico.getString("estado") : "";
                        String convenio = (jsonHistorico.getString("convenio") != null && !jsonHistorico.getString("convenio").equals("null")) ? jsonHistorico.getString("convenio") : "";
                        String tipoGiro = (jsonHistorico.getString("tipoGiro") != null && !jsonHistorico.getString("tipoGiro").equals("null")) ? jsonHistorico.getString("tipoGiro") : "";
                        String tipoBeneficiario = (jsonHistorico.getString("tipoBeneficiario") != null && !jsonHistorico.getString("tipoBeneficiario").equals("null")) ? jsonHistorico.getString("tipoBeneficiario") : "";
                        String beneficiarioHistorico = (jsonHistorico.getString("beneficiario") != null && !jsonHistorico.getString("beneficiario").equals("null")) ? jsonHistorico.getString("beneficiario") : "";
                        String fechaInicioHistorico = (jsonHistorico.getString("fechaInicio") != null && !jsonHistorico.getString("fechaInicio").equals("null")) ? jsonHistorico.getString("fechaInicio") : "";
                        String fechaFinHistorico = (jsonHistorico.getString("fechaFin") != null && !jsonHistorico.getString("fechaFin").equals("null")) ? jsonHistorico.getString("fechaFin") : "";
                        String valorMonedaExtranjera = (jsonHistorico.getString("valorMonedaExtranjera") != null && !jsonHistorico.getString("valorMonedaExtranjera").equals("null")) ? jsonHistorico.getString("valorMonedaExtranjera") : "";
                        String valorMonedaLocal = (jsonHistorico.getString("valorMonedaLocal") != null && !jsonHistorico.getString("valorMonedaLocal").equals("null")) ? jsonHistorico.getString("valorMonedaLocal") : "";
                        String registraDevolucion = (jsonHistorico.getString("registraDevolucion") != null && !jsonHistorico.getString("registraDevolucion").equals("null")) ? jsonHistorico.getString("registraDevolucion") : "";
                        String valorDevolucion = (jsonHistorico.getString("valorDevolucion") != null && !jsonHistorico.getString("valorDevolucion").equals("null")) ? jsonHistorico.getString("valorDevolucion") : "";
                        String legalizado = (jsonHistorico.getString("legalizado") != null && !jsonHistorico.getString("legalizado").equals("null")) ? jsonHistorico.getString("legalizado") : "";
                        String valorLegalizado = (jsonHistorico.getString("valorLegalizado") != null && !jsonHistorico.getString("valorLegalizado").equals("null")) ? jsonHistorico.getString("valorLegalizado") : "";

                        HistoricoGirosDTO historicoDTO = new HistoricoGirosDTO(id, ciudad, estado, convenio, tipoGiro, tipoBeneficiario, beneficiarioHistorico, fechaInicioHistorico,
                                fechaFinHistorico, Utilities.formatearNumeroTexto(valorMonedaExtranjera),Utilities.formatearNumeroTexto(valorMonedaLocal) , registraDevolucion, Utilities.formatearNumeroTexto(valorDevolucion), legalizado, Utilities.formatearNumeroTexto(valorLegalizado));
                        lstHistoricoGiro.add(historicoDTO);

                }
                detalleGiroDTO.setLstHistoricoGiro(lstHistoricoGiro);


                detalleGiroDTO.setTotalConceptos(totalConcepto);
                detalleGiroDTO.setSubtotalConceptos(subTotalConcepto);

            }

        }catch (Exception e){
            Toast.makeText(getActivity(),e.getMessage(), Toast.LENGTH_LONG).show();
        }
        return respuesta ;
    }
}
