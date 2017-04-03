package co.com.coomeva.sofibmobile.fragments;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.util.Base64;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Toast;

import org.json.JSONArray;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import co.com.coomeva.sofibmobile.BitacoraView;
import co.com.coomeva.sofibmobile.ConsultaSolicitudAtencionView;
import co.com.coomeva.sofibmobile.R;
import co.com.coomeva.sofibmobile.adapters.BitacoraAdapter;
import co.com.coomeva.sofibmobile.adapters.InformesMedicosAdapter;
import co.com.coomeva.sofibmobile.dto.BitacoraDTO;
import co.com.coomeva.sofibmobile.dto.DescipcionDTO;
import co.com.coomeva.sofibmobile.dto.DetalleInformeMedicoDTO;
import co.com.coomeva.sofibmobile.dto.DocumentosMedicosDTO;
import co.com.coomeva.sofibmobile.dto.InformesMedicosDTO;
import co.com.coomeva.sofibmobile.task.ConexionDescargaArchivoTask;
import co.com.coomeva.sofibmobile.task.ConexionServicioListaTask;
import co.com.coomeva.sofibmobile.task.ConexionServicioTask;

/**
 * Created by JuanCamilo on 9/25/16.
 */
public class InformesMedicosFragment extends Fragment{

    private InformesMedicosAdapter informesMedicosAdapter;
    private ListView listViewInformesMedicosAdapter;
    private List<InformesMedicosDTO> informesMedicosList = new ArrayList<>();
    public static DetalleInformeMedicoDTO detalleInformeMedicoSeleccionado;
    private InformesMedicosDTO informeMedico;
    private List<DocumentosMedicosDTO> lstDocumentos;
    private List<DescipcionDTO> lstProcedimientos;
    private List<DescipcionDTO> lstMedicina;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_consulta_bitacora, container, false);

        listViewInformesMedicosAdapter = (ListView) view.findViewById(R.id.listSolicitudes);

        informesMedicosList = new ArrayList<>();
        informesMedicosList.addAll(OpcionesSecundariasFragment.lstInformesMedicos);

        informesMedicosAdapter = new InformesMedicosAdapter(view.getContext(), informesMedicosList);
        listViewInformesMedicosAdapter.setAdapter(informesMedicosAdapter);


        listViewInformesMedicosAdapter.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView adapterView, View view, int i, long l) {
                try {

                    if(informeMedico == null){
                        informeMedico = new InformesMedicosDTO();
                    }

                    informeMedico = informesMedicosList.get(i);


                    AlertDialog.Builder dialogOpciones = new AlertDialog.Builder(view.getContext());
                    dialogOpciones.setTitle(R.string.lbl_opciones);
                    dialogOpciones.setItems(R.array.opciones_informes_medicos, new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialogInterface, int which) {
                            if (which == 0) {



                                String params = getActivity().getResources().getString(R.string.address_service_token)+ informeMedico.getConsInformeMedico();
                                if (consultarDetalleInformesmedicos(getActivity().getResources().getString(R.string.complement_InformesMedicos_detalle), params)){

                                    FragmentTransaction ft = getActivity().getSupportFragmentManager().beginTransaction();
                                    Fragment fragment = new TabInformesMedicosFragment();
                                    fragment.setArguments(getActivity().getIntent().getExtras());
                                    ft.replace(R.id.fragment_container_informes_medicos, fragment, "TabInformesMedicosFragment").addToBackStack("TabInformesMedicosFragment").commit();

                                }else {
                                    Toast.makeText(getActivity(), getActivity().getResources().getString(R.string.lbl_sin_resultados), Toast.LENGTH_LONG).show();
                                }

                            }else if (which == 1) {

                                try {

                                    String params = "http://pruebas-sofib.coomeva.com.co/cni-web/exportDocument?format=pdf&reportName=informe_medico&CONS_INFORME_MEDICO="+informeMedico.getConsInformeMedico()+"&CONS_SOLICITUD_ATENCION="+ ConsultaSolicitudAtencionView.solicitudAtencionSeleccionada.getNumeroSolicitud()+"&nocache=15416516316";

                                    ConexionDescargaArchivoTask task = new ConexionDescargaArchivoTask(getActivity(),params, "");

                                    synchronized (task) {
                                        task.execute().wait();
                                    }

                                }catch (Exception e) {
                                    Toast.makeText(getActivity(), e.getMessage(), Toast.LENGTH_LONG).show();
                                }

                            }else if (which == 2) {
                                try {

                                    String params = "http://pruebas-sofib.coomeva.com.co/cni-web/exportDocument?format=pdf&reportName=informe_medico&CONS_INFORME_MEDICO="+informeMedico.getConsInformeMedico()+"&CONS_SOLICITUD_ATENCION="+ ConsultaSolicitudAtencionView.solicitudAtencionSeleccionada.getNumeroSolicitud()+"&nocache=15416516316&REPORT_LOCALE=USD";

                                    ConexionDescargaArchivoTask task = new ConexionDescargaArchivoTask(getActivity(),params, "");

                                    synchronized (task) {
                                        task.execute().wait();
                                    }

                                }catch (Exception e) {
                                    Toast.makeText(getActivity(), e.getMessage(), Toast.LENGTH_LONG).show();
                                }
                            }
                        }
                    });

                    dialogOpciones.show();

                }catch (Exception e){
                    e.printStackTrace();
                }
            }
        });

        return view;
    }

    private boolean consultarDetalleInformesmedicos(String serviceName, String listParams){

        boolean respuesta = false;

        try {

            ConexionServicioTask task = new ConexionServicioTask(getActivity(), serviceName, listParams);

            detalleInformeMedicoSeleccionado = new DetalleInformeMedicoDTO();

            synchronized (task) {
                task.execute().wait();
            }

            JSONArray respJSONSpinner = ConexionServicioTask.respJSON;

            String[] result = new String[respJSONSpinner.length()];

            if (result!=null && result.length>0) {

                for (int j = 0; j < respJSONSpinner.length(); j++) {

                        respuesta = true;
                        JSONObject obj = respJSONSpinner.getJSONObject(j);

                        String entidadPrestadora = (obj.getString("prestador") != null && !obj.getString("prestador").equals("null")) ? obj.getString("prestador") : "";
                        String evolucionPaciente = (obj.getString("evoluciondelpaciente") != null && !obj.getString("evoluciondelpaciente").equals("null")) ? obj.getString("evoluciondelpaciente") : "";
                        String tipoPaciente = (obj.getString("pacienteEstado") != null && !obj.getString("pacienteEstado").equals("null")) ? obj.getString("pacienteEstado") : "";
                        String dadoAlta = (obj.getString("dadoAlta") != null && !obj.getString("dadoAlta").equals("null")) ? obj.getString("dadoAlta") : "";
                        String fallecido = (obj.getString("fallecido") != null && !obj.getString("fallecido").equals("null")) ? obj.getString("fallecido") : "";
                        String fechaHospitalizacion = (obj.getString("fechaInicioHospitaliza") != null && !obj.getString("fechaInicioHospitaliza").equals("null")) ? obj.getString("fechaInicioHospitaliza") : "";
                        String fechaFinHospitalizacion = (obj.getString("fechaFinHospitaliza") != null && !obj.getString("fechaFinHospitaliza").equals("null")) ? obj.getString("fechaFinHospitaliza") : "";
                        String id = (obj.getString("fechaInicioHospitaliza") != null && !obj.getString("fechaInicioHospitaliza").equals("null")) ? obj.getString("fechaInicioHospitaliza") : "";


                        detalleInformeMedicoSeleccionado.setEntidadPrestadora(entidadPrestadora);
                        detalleInformeMedicoSeleccionado.setEvolucionPaciente(evolucionPaciente);
                        detalleInformeMedicoSeleccionado.setTipoPaciente(tipoPaciente);
                        detalleInformeMedicoSeleccionado.setDadoAlta(dadoAlta);
                        detalleInformeMedicoSeleccionado.setFallecido(fallecido);
                        detalleInformeMedicoSeleccionado.setFechaHospitalizacion(fechaHospitalizacion);
                        detalleInformeMedicoSeleccionado.setFechaFinHospitalizacion(fechaFinHospitalizacion);

                        ///////////////////////////////////////////////////////////////////////////////
                        JSONArray jsonArrayMedicamentos = obj.optJSONArray("medicamentoNombre");

                        lstMedicina = new ArrayList<DescipcionDTO>();

                        for (int x = 0; x < jsonArrayMedicamentos.length(); x++) {
                            JSONObject medicamento = jsonArrayMedicamentos.getJSONObject(x);

                            String medicamentoNombre = (medicamento.getString("medicamentoNombre") != null && !medicamento.getString("medicamentoNombre").equals("null")) ? medicamento.getString("medicamentoNombre") : "";

                            DescipcionDTO medicamentoDTO = new DescipcionDTO();
                            medicamentoDTO.setDescripcion(medicamentoNombre);
                            lstMedicina.add(medicamentoDTO);
                        }

                        detalleInformeMedicoSeleccionado.setLstMedicina(lstMedicina);

                        ///////////////////////////////////////////////////////////////////////////////


                        JSONArray jsonArrayProcedimiento = obj.optJSONArray("nombreProcedimiento");

                        lstProcedimientos = new ArrayList<DescipcionDTO>();


                        for (int x = 0; x < jsonArrayProcedimiento.length(); x++) {
                            JSONObject procedimiento = jsonArrayProcedimiento.getJSONObject(x);

                            String nombreProcedimiento = (procedimiento.getString("nombreProcedimiento") != null && !procedimiento.getString("nombreProcedimiento").equals("null")) ? procedimiento.getString("nombreProcedimiento") : "";

                            DescipcionDTO procedimientoDTO = new DescipcionDTO();
                            procedimientoDTO.setDescripcion(nombreProcedimiento);
                            lstProcedimientos.add(procedimientoDTO);
                        }

                        detalleInformeMedicoSeleccionado.setLstProcedimientos(lstProcedimientos);

                        ///////////////////////////////////////////////////////////////////////////////


                        JSONArray jsonArrayDocumentos = obj.optJSONArray("archivo");

                            lstDocumentos = new ArrayList<DocumentosMedicosDTO>();
                        

                        for (int x = 0; x < jsonArrayDocumentos.length(); x++) {
                            JSONObject docu = jsonArrayDocumentos.getJSONObject(x);

                            String nombre = (docu.getString("nombreDocumento") != null && !docu.getString("nombreDocumento").equals("null")) ? docu.getString("nombreDocumento") : "";
                            String tipoDocumento = (docu.getString("tipoDocumento") != null && !docu.getString("tipoDocumento").equals("null")) ? docu.getString("tipoDocumento") : "";
                            String archivo = (docu.getString("archivo") != null && !docu.getString("archivo").equals("null")) ? docu.getString("archivo") : "";
                            String idDocu = (docu.getString("id") != null && !docu.getString("id").equals("null")) ? docu.getString("id") : "";


                            byte[] archivoArray = Base64.decode(archivo, Base64.DEFAULT);

                            DocumentosMedicosDTO documentosMedicosDTO = new DocumentosMedicosDTO();
                            documentosMedicosDTO.setNombre(nombre);
                            documentosMedicosDTO.setTipoDocumento(tipoDocumento);
                            documentosMedicosDTO.setImagen(archivoArray);
                            documentosMedicosDTO.setId(idDocu);
                            lstDocumentos.add(documentosMedicosDTO);
                        }

                        detalleInformeMedicoSeleccionado.setLstDocumentos(lstDocumentos);

                    }

            }

        }catch (Exception e){
            Toast.makeText(getActivity(),e.getMessage(), Toast.LENGTH_LONG).show();
        }
        return respuesta ;
    }

}
