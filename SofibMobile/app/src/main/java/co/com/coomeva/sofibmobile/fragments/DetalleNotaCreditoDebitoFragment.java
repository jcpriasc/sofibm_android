package co.com.coomeva.sofibmobile.fragments;

import android.os.Bundle;
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

import java.util.ArrayList;
import java.util.List;

import co.com.coomeva.sofibmobile.R;
import co.com.coomeva.sofibmobile.dto.ConceptosDTO;
import co.com.coomeva.sofibmobile.dto.DetalleGiroDTO;
import co.com.coomeva.sofibmobile.dto.DetalleNotaCreditoDebitoDTO;
import co.com.coomeva.sofibmobile.dto.HistoricoGirosDTO;
import co.com.coomeva.sofibmobile.dto.ImpuestoNotaCreditoDebitoDTO;
import co.com.coomeva.sofibmobile.dto.ManutencionDTO;
import co.com.coomeva.sofibmobile.dto.ServicioNotaCreditoDebitoDTO;
import co.com.coomeva.sofibmobile.task.ConexionServicioListaTask;
import co.com.coomeva.sofibmobile.utils.Utilities;

/**
 * Created by JuanCamilo on 9/25/16.
 */
public class DetalleNotaCreditoDebitoFragment extends Fragment{

    private TextView txtNumeroNota;
    private TextView txtNumeroFactura;
    private TextView txtFechaExpedicion;
    private TextView txtFechaAprobacion;
    private TextView txtCiudad;
    private TextView txtProveedor;
    private TextView txtMotivo;
    private TextView txtEstado;
    private TextView txtTipoNota;
    private TextView txtValorTotalNotaCredito;

    private FloatingActionButton btnDetalle;
    public static DetalleNotaCreditoDebitoDTO detalleNotaCreditoDebitoDTO;
    private static List<ImpuestoNotaCreditoDebitoDTO> lstImpuestos;
    private static List<ServicioNotaCreditoDebitoDTO> lstsServicios;



    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_detalle_nota_credito_debito, container, false);

        //Se enlaza los componentes Android al fragment
        txtNumeroNota = (TextView) view.findViewById(R.id.txtNumeroNota);
        txtNumeroFactura = (TextView) view.findViewById(R.id.txtNumeroFactura);
        txtFechaExpedicion = (TextView) view.findViewById(R.id.txtFechaExpedicion);
        txtFechaAprobacion = (TextView) view.findViewById(R.id.txtFechaAprobacion);
        txtCiudad = (TextView) view.findViewById(R.id.txtCiudad);
        txtProveedor = (TextView) view.findViewById(R.id.txtProveedor);
        txtMotivo = (TextView) view.findViewById(R.id.txtMotivo);
        txtEstado = (TextView) view.findViewById(R.id.txtEstado);
        txtTipoNota = (TextView) view.findViewById(R.id.txtTipoNota);
        txtValorTotalNotaCredito = (TextView) view.findViewById(R.id.txtValorTotalNotaCredito);

        btnDetalle = (FloatingActionButton) view.findViewById(R.id.btnDetalle);

        try {

        //Se colocan los datos del giro estatica del View a los componentes para mostrar su informacio
            txtNumeroNota.setText(getResources().getString(R.string.lbl_numero_nota) + ": "+NotaCreditoDebitoFragment.notaCreditoDebitoSeleccionado.getNumeroNota());
            txtNumeroFactura.setText(getResources().getString(R.string.lbl_numero_factura) + ": "+NotaCreditoDebitoFragment.notaCreditoDebitoSeleccionado.getNumeroFactura());
            txtFechaExpedicion.setText(getResources().getString(R.string.lbl_fecha_expedicion) + ": "+NotaCreditoDebitoFragment.notaCreditoDebitoSeleccionado.getFechaExpedicionTexto());
            txtFechaAprobacion.setText(getResources().getString(R.string.lbl_fecha_aprobacion) + ": "+NotaCreditoDebitoFragment.notaCreditoDebitoSeleccionado.getFechaAprobacionTexto());
            txtCiudad.setText(NotaCreditoDebitoFragment.notaCreditoDebitoSeleccionado.getCiudad());
            txtProveedor.setText(NotaCreditoDebitoFragment.notaCreditoDebitoSeleccionado.getProveedor());
            txtMotivo.setText(NotaCreditoDebitoFragment.notaCreditoDebitoSeleccionado.getMotivo());
            txtEstado.setText(NotaCreditoDebitoFragment.notaCreditoDebitoSeleccionado.getEstado());
            txtTipoNota.setText(NotaCreditoDebitoFragment.notaCreditoDebitoSeleccionado.getTipoNota());
            txtValorTotalNotaCredito.setText(NotaCreditoDebitoFragment.notaCreditoDebitoSeleccionado.getValorTotalNotaCreditoTexto());

        }catch (Exception e) {
            Toast.makeText(view.getContext(), e.getMessage(), Toast.LENGTH_LONG).show();
        }

        btnDetalle.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                try {

                        String params = "/SAC/ABCD1234/"+ NotaCreditoDebitoFragment.notaCreditoDebitoSeleccionado.getConsNota();
                        if (consultarDetalleNotaCreditoDebito(getActivity().getResources().getString(R.string.complement_nota_detalle), params)){

                            FragmentTransaction ft = getActivity().getSupportFragmentManager().beginTransaction();
                            Fragment fragment = new TabNotaCreditoDebitoFragment();
                            fragment.setArguments(getActivity().getIntent().getExtras());
                            ft.replace(R.id.fragment_container_nota_credito_debito, fragment, "TabNotaCreditoDebitoFragment").addToBackStack("TabNotaCreditoDebitoFragment").commit();

                        }else {
                            throw new Exception(getActivity().getResources().getString(R.string.lbl_sin_resultados));
                        }

                }catch (Exception e) {
                    Toast.makeText(view.getContext(), e.getMessage(), Toast.LENGTH_LONG).show();
                }
            }
        });

        return view;
    }
    private boolean consultarDetalleNotaCreditoDebito(String serviceName, String listParams){

        boolean respuesta = false;

        try {

            ConexionServicioListaTask task = new ConexionServicioListaTask(getActivity(), serviceName, listParams);

            detalleNotaCreditoDebitoDTO = new DetalleNotaCreditoDebitoDTO();

            synchronized (task) {
                task.execute().wait();
            }

            if (ConexionServicioListaTask.respJSON !=null){
                respuesta = true;
                JSONObject obj = ConexionServicioListaTask.respJSON;

                String facturaNro = (obj.getString("facturaNro") != null && !obj.getString("facturaNro").equals("null")) ? obj.getString("facturaNro"):"";
                String fechaEmision = (obj.getString("fechaEmision") != null && !obj.getString("fechaEmision").equals("null")) ? obj.getString("fechaEmision"):"";
                String fechaVencimiento = (obj.getString("fechaVencimiento") != null && !obj.getString("fechaVencimiento").equals("null")) ? obj.getString("fechaVencimiento" ):"";
                String fechaRecibido = (obj.getString("fechaRecibido") != null && !obj.getString("fechaRecibido").equals("null")) ? obj.getString("fechaRecibido"):"";
                String valorTotalFactura = (obj.getString("valorTotalFactura") != null && !obj.getString("valorTotalFactura").equals("null")) ? obj.getString("valorTotalFactura"):"";
                String valorTotalPagar = (obj.getString("valorTotalPagar") != null && !obj.getString("valorTotalPagar").equals("null")) ? obj.getString("valorTotalPagar"):"";
                String proveedor = (obj.getString("proveedor") != null && !obj.getString("proveedor").equals("null")) ? obj.getString("proveedor" ):"";
                String fechaExpedicionNota = (obj.getString("fechaExpedicionNota") != null && !obj.getString("fechaExpedicionNota").equals("null")) ? obj.getString("fechaExpedicionNota"):"";
                String fechaRecibidoCoomevaNota = (obj.getString("fechaRecibidoCoomevaNota") != null && !obj.getString("fechaRecibidoCoomevaNota").equals("null")) ? obj.getString("fechaRecibidoCoomevaNota"):"";
                String notaMotivo = (obj.getString("notaMotivo") != null && !obj.getString("notaMotivo").equals("null")) ? obj.getString("notaMotivo"):"";
                String orderServicio = (obj.getString("orderServicio") != null && !obj.getString("orderServicio").equals("null")) ? obj.getString("orderServicio" ):"";
                String servicio = (obj.getString("servicio") != null && !obj.getString("servicio").equals("null")) ? obj.getString("servicio"):"";
                String valorIva = (obj.getString("valorIva") != null && !obj.getString("valorIva").equals("null")) ? obj.getString("valorIva"):"";
                String valorTotalPagarNota = (obj.getString("valorTotalPagarNota") != null && !obj.getString("valorTotalPagarNota").equals("null")) ? obj.getString("valorTotalPagarNota"):"";
                String valorTotalNotaCredito = (obj.getString("valorTotalNotaCredito") != null && !obj.getString("valorTotalNotaCredito").equals("null")) ? obj.getString("valorTotalNotaCredito" ):"";
                String nroNota = (obj.getString("nroNota") != null && !obj.getString("nroNota").equals("null")) ? obj.getString("nroNota"):"";

                detalleNotaCreditoDebitoDTO.setNumeroFactura(facturaNro);
                detalleNotaCreditoDebitoDTO.setFechaEmisionTexto(fechaEmision);
                detalleNotaCreditoDebitoDTO.setFechaVencimientoPagoTexto(fechaVencimiento);
                detalleNotaCreditoDebitoDTO.setFechaRecibidoCoomevaTexto(fechaRecibido);
                detalleNotaCreditoDebitoDTO.setProveedor(proveedor);
                detalleNotaCreditoDebitoDTO.setValorTotalFacturaTexto(Utilities.formatearNumeroTexto(valorTotalFactura));
                detalleNotaCreditoDebitoDTO.setValorTotalAPagarTexto(Utilities.formatearNumeroTexto(valorTotalPagar));
                detalleNotaCreditoDebitoDTO.setNumeroNota(nroNota);
                detalleNotaCreditoDebitoDTO.setFechaExpedicionTexto(fechaExpedicionNota);
                detalleNotaCreditoDebitoDTO.setFechaRecibidoCoomevaNotaCreditoTexto(fechaRecibidoCoomevaNota);
                detalleNotaCreditoDebitoDTO.setMotivo(notaMotivo);
                detalleNotaCreditoDebitoDTO.setValorTotalNotaCreditoTexto(Utilities.formatearNumeroTexto(valorTotalNotaCredito));
                detalleNotaCreditoDebitoDTO.setValorIvaTexto(Utilities.formatearNumeroTexto(valorIva));
                detalleNotaCreditoDebitoDTO.setNumeroOrdenServicio(orderServicio);
                detalleNotaCreditoDebitoDTO.setServicio(servicio);

                ///////////////////////////////////////////////////////////////////////////////
                JSONArray jsonArrayImpuestos = obj.optJSONArray("facturas");

                if(lstImpuestos == null){
                    lstImpuestos = new ArrayList<ImpuestoNotaCreditoDebitoDTO>();
                }

                Double totalValorNota =0d;
                Double totalServicio=0d;
                Double totalSeguroHotelero=0d;

                for (int x = 0; x < jsonArrayImpuestos.length(); x++) {
                    JSONObject impuesto = jsonArrayImpuestos.getJSONObject(x);

                    String proveedorImpuesto = (impuesto.getString("proveedor") != null && !impuesto.getString("proveedor").equals("null")) ? impuesto.getString("proveedor"):"";
                    String numeroOrdenServicio = (impuesto.getString("ordenServicio") != null && !impuesto.getString("ordenServicio").equals("null")) ? impuesto.getString("ordenServicio"):"";
                    String servicioImpuesto = (impuesto.getString("servicio") != null && !impuesto.getString("servicio").equals("null")) ? impuesto.getString("servicio" ):"";
                    String fechaInicio = (impuesto.getString("fechaInicio") != null && !impuesto.getString("fechaInicio").equals("null")) ? impuesto.getString("fechaInicio" ):"";
                    String fechaFinalizacion = (impuesto.getString("fechaFinalizaServicio") != null && !impuesto.getString("fechaFinalizaServicio").equals("null")) ? impuesto.getString("fechaFinalizaServicio" ):"";
                    String valorServicio = (impuesto.getString("valorServicio") != null && !impuesto.getString("valorServicio").equals("null")) ? impuesto.getString("valorServicio"):"0";
                    String seguroHotelero = (impuesto.getString("seguroHotelero") != null && !impuesto.getString("seguroHotelero").equals("null")) ? impuesto.getString("seguroHotelero" ):"0";
                    String valorNota = (impuesto.getString("valorNota") != null && !impuesto.getString("valorNota").equals("null")) ? impuesto.getString("valorNota"):"0";

            //        String valorImpuesto = (impuesto.getString("valorImpuesto") != null && !impuesto.getString("valorImpuesto").equals("null")) ? impuesto.getString("valorImpuesto"):"";
            //        String aplicaSeguroHotelero = (impuesto.getString("aplicaSeguroHotelero") != null && !impuesto.getString("aplicaSeguroHotelero").equals("null")) ? impuesto.getString("aplicaSeguroHotelero"):"";

                    totalValorNota =  totalValorNota + Double.parseDouble(valorNota);
                    totalServicio = totalServicio + Double.parseDouble(valorServicio);
                    totalSeguroHotelero = totalSeguroHotelero + Double.parseDouble(seguroHotelero);

                    ImpuestoNotaCreditoDebitoDTO impuestoDTO = new ImpuestoNotaCreditoDebitoDTO(proveedorImpuesto,numeroOrdenServicio,servicioImpuesto,fechaInicio,
                            "","",fechaFinalizacion,Utilities.formatearNumeroTexto(seguroHotelero),Utilities.formatearNumeroTexto(valorServicio),Utilities.formatearNumeroTexto(valorNota));
                    lstImpuestos.add(impuestoDTO);
                }

                detalleNotaCreditoDebitoDTO.setValorTotalNotaTexto(Utilities.formatearNumeroDoubleAMoneda(totalValorNota));
                detalleNotaCreditoDebitoDTO.setValorTotalSeguroHoteleroTexto(Utilities.formatearNumeroDoubleAMoneda(totalSeguroHotelero));
                detalleNotaCreditoDebitoDTO.setValorTotalServicioTexto(Utilities.formatearNumeroDoubleAMoneda(totalServicio));

                detalleNotaCreditoDebitoDTO.setLsImpuestoNotaCreditoDebito(lstImpuestos);

                ///////////////////////////////////////////////////////////////////////////////


                JSONArray jsonArrayServicios = obj.optJSONArray("impuestos");

                if(lstsServicios == null){
                    lstsServicios = new ArrayList<ServicioNotaCreditoDebitoDTO>();
                }


                for (int x = 0; x < jsonArrayServicios.length(); x++) {
                    JSONObject servicioItem = jsonArrayServicios.getJSONObject(x);

                    String numeroOrdenServicio = (servicioItem.getString("numeroOrdenServicio") != null && !servicioItem.getString("numeroOrdenServicio").equals("null")) ? servicioItem.getString("numeroOrdenServicio"):"";
                    String tipoImpuesto = (servicioItem.getString("tipoImpuesto") != null && !servicioItem.getString("tipoImpuesto").equals("null")) ? servicioItem.getString("tipoImpuesto"):"";
                    String servicioServicio = (servicioItem.getString("servicio") != null && !servicioItem.getString("servicio").equals("null")) ? servicioItem.getString("servicio"):"";
                    String porcentaje = (servicioItem.getString("porcentaje") != null && !servicioItem.getString("porcentaje").equals("null")) ? servicioItem.getString("porcentaje"):"";
                    String valorImpuesto = (servicioItem.getString("valorImpuesto") != null && !servicioItem.getString("valorImpuesto").equals("null")) ? servicioItem.getString("valorImpuesto"):"";
                    String aplicaSeguroHotelero = (servicioItem.getString("aplicaSeguroHotelero") != null && !servicioItem.getString("aplicaSeguroHotelero").equals("null")) ? servicioItem.getString("aplicaSeguroHotelero"):"";

                    ServicioNotaCreditoDebitoDTO servicioDTO = new ServicioNotaCreditoDebitoDTO(numeroOrdenServicio,tipoImpuesto,servicioServicio,porcentaje+"%",Utilities.formatearNumeroTexto(valorImpuesto),aplicaSeguroHotelero);
                    lstsServicios.add(servicioDTO);
                }

                detalleNotaCreditoDebitoDTO.setLstServicioNotaCreditoDebito(lstsServicios);

            }

        }catch (Exception e){
            Toast.makeText(getActivity(),e.getMessage(), Toast.LENGTH_LONG).show();
        }
        return respuesta ;
    }

}
