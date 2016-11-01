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
import co.com.coomeva.sofibmobile.dto.DetalleFacturaDTO;
import co.com.coomeva.sofibmobile.dto.DetalleServicioNoAsistencialDTO;
import co.com.coomeva.sofibmobile.dto.ImpuestoFacturaDTO;
import co.com.coomeva.sofibmobile.dto.InformacionFacturaDTO;
import co.com.coomeva.sofibmobile.dto.ServicioAdicionalDTO;
import co.com.coomeva.sofibmobile.task.ConexionServicioListaTask;
import co.com.coomeva.sofibmobile.utils.Utilities;

/**
 * Created by JuanCamilo on 9/25/16.
 */
public class DetalleFacturaFragment extends Fragment{

    private TextView txtNumeroFactura;
    private TextView txtFechaExpedicion;
    private TextView txtEstado;
    private TextView txtValorTotalFactura;
    private TextView txtCiudad;
    private TextView txtFechaRadicacion;
    private TextView txtFechaAprobacionRechazo;
    private TextView txtFechaAnulacion;
    private TextView txtValorIva;
    private TextView txtValorTotalPagar;
    private TextView txtPrestadorProveedor;
    private TextView txtTipoServicio;

    private FloatingActionButton btnDetalle;

    public static DetalleFacturaDTO facturaSeleccionado;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_detalle_factura, container, false);

        //Se enlaza los componentes Android al fragment
        txtNumeroFactura = (TextView) view.findViewById(R.id.txtNumeroFactura);
        txtFechaExpedicion = (TextView) view.findViewById(R.id.txtFechaExpedicion);
        txtEstado = (TextView) view.findViewById(R.id.txtEstado);
        txtValorTotalFactura = (TextView) view.findViewById(R.id.txtValorTotalFactura);
        txtCiudad = (TextView) view.findViewById(R.id.txtCiudad);
        txtFechaRadicacion = (TextView) view.findViewById(R.id.txtFechaRadicacion);
        txtFechaAprobacionRechazo = (TextView) view.findViewById(R.id.txtFechaAprobacionRechazo);
        txtFechaAnulacion = (TextView) view.findViewById(R.id.txtFechaAnulacion);
        txtValorIva = (TextView) view.findViewById(R.id.txtValorIva);
        txtValorTotalPagar = (TextView) view.findViewById(R.id.txtValorTotalPagar);
        txtTipoServicio = (TextView) view.findViewById(R.id.txtTipoServicio);
        txtPrestadorProveedor = (TextView) view.findViewById(R.id.txtPrestadorProveedor);
        btnDetalle = (FloatingActionButton) view.findViewById(R.id.btnDetalle);

        try {

        //Se colocan los datos del giro estatica del View a los componentes para mostrar su informacio
            txtNumeroFactura.setText(getResources().getString(R.string.lbl_numero_factura) + ": "+FacturaFragment.facturaSeleccionado.getNumeroFactura());
            txtFechaExpedicion.setText(getResources().getString(R.string.lbl_fecha_expedicion) + ": "+FacturaFragment.facturaSeleccionado.getFechaExpedicionTexto());
            txtEstado.setText(getResources().getString(R.string.lbl_estado) + ": "+FacturaFragment.facturaSeleccionado.getEstado());
            txtValorTotalFactura.setText(getResources().getString(R.string.lbl_valor_total_factura) + ": "+FacturaFragment.facturaSeleccionado.getValorTotalFacturaTexto());
            txtCiudad.setText(FacturaFragment.facturaSeleccionado.getCiudad());
            txtFechaRadicacion.setText(FacturaFragment.facturaSeleccionado.getFechaRadicacionTexto());
            txtFechaAprobacionRechazo.setText(FacturaFragment.facturaSeleccionado.getFechaAprobacionRechazoTexto());
            txtFechaAnulacion.setText(FacturaFragment.facturaSeleccionado.getFechaAnulacionTexto());
            txtValorIva.setText(FacturaFragment.facturaSeleccionado.getValorIvaTexto());
            txtValorTotalPagar.setText(FacturaFragment.facturaSeleccionado.getValorTotalPagarTexto());
            txtTipoServicio.setText(FacturaFragment.facturaSeleccionado.getTipoServicio());
            txtPrestadorProveedor.setText(FacturaFragment.facturaSeleccionado.getPrestadorProveedor());

        }catch (Exception e) {
            Toast.makeText(view.getContext(), e.getMessage(), Toast.LENGTH_LONG).show();
        }

        btnDetalle.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                try {
                    String params = "/SAC/ABCD1234/"+FacturaFragment.facturaSeleccionado.getConsFactura();
                    if (consultarDetalleFacturas(getActivity().getResources().getString(R.string.complement_factura_detalle), params)){
                        FragmentTransaction ft = getActivity().getSupportFragmentManager().beginTransaction();
                        Fragment fragment = new TabFacturaFragment();
                        fragment.setArguments(getActivity().getIntent().getExtras());
                        ft.replace(R.id.fragment_container_factura, fragment, "TabFacturaFragment").addToBackStack("TabFacturaFragment").commit();
                    }

                }catch (Exception e) {
                    Toast.makeText(view.getContext(), e.getMessage(), Toast.LENGTH_LONG).show();
                }
            }
        });

        return view;
    }

    private boolean consultarDetalleFacturas(String serviceName, String listParams){

        boolean respuesta = false;

        try {

            ConexionServicioListaTask task = new ConexionServicioListaTask(getActivity(), serviceName, listParams);

            synchronized (task) {
                task.execute().wait();
            }

            if (ConexionServicioListaTask.respJSON !=null){
                respuesta = true;
                JSONObject obj = ConexionServicioListaTask.respJSON;

                String facturaNro = (obj.getString("facturaNro") != null && !obj.getString("facturaNro").equals("null")) ? obj.getString("facturaNro"):"";
                String fechaEmision = (obj.getString("fechaEmision") != null && !obj.getString("fechaEmision").equals("null")) ? obj.getString("fechaEmision"):"";
                String fechaVencimientoPago = (obj.getString("fechaVencimientoPago") != null && !obj.getString("fechaVencimientoPago").equals("null")) ? obj.getString("fechaVencimientoPago"):"";
                String fechaRecibidoCoomeva = (obj.getString("fechaRecibidoCoomeva") != null && !obj.getString("fechaRecibidoCoomeva").equals("null")) ? obj.getString("fechaRecibidoCoomeva"):"";
                String proveedor = (obj.getString("proveedor") != null && !obj.getString("proveedor").equals("null")) ? obj.getString("proveedor"):"";
                String descripcion = (obj.getString("descripcion") != null && !obj.getString("descripcion").equals("null")) ? obj.getString("descripcion"):"";
                String motivo = (obj.getString("motivo") != null && !obj.getString("motivo").equals("null")) ? obj.getString("motivo"):"";
                String valorGlosa = (obj.getString("valorGlosa") != null && !obj.getString("valorGlosa").equals("null")) ? obj.getString("valorGlosa"):"";
                String valorIva = (obj.getString("valorIva") != null && !obj.getString("valorIva").equals("null")) ? obj.getString("valorIva"):"";
                String valorTotalPagar = (obj.getString("valorTotalPagar") != null && !obj.getString("valorTotalPagar").equals("null")) ? obj.getString("valorTotalPagar"):"";
                String valorTotalFactura = (obj.getString("valorTotalFactura") != null && !obj.getString("valorTotalFactura").equals("null")) ? obj.getString("valorTotalFactura"):"";

                String aplicaGlosa = "";
                if(!valorGlosa.equals("") && !motivo.equals("") ){
                    aplicaGlosa = "SI";
                }else{
                    aplicaGlosa = "NO";
                }

                List<InformacionFacturaDTO> lstInformacionFactura = new ArrayList<>();
                List<ImpuestoFacturaDTO> lstImpuestoFactura = new ArrayList<>();

                JSONArray jsonArrayFactura = obj.optJSONArray("factura");

                for (int x = 0; x < jsonArrayFactura.length(); x++) {
                    JSONObject factura = jsonArrayFactura.getJSONObject(x);

                    String proveedorFact = (factura.getString("proveedor") != null && !factura.getString("proveedor").equals("null")) ? factura.getString("proveedor"):"";
                    String ordenServicio = (factura.getString("ordenServicio") != null && !factura.getString("ordenServicio").equals("null")) ? factura.getString("ordenServicio"):"";
                    String servicio = (factura.getString("servicio") != null && !factura.getString("servicio").equals("null")) ? factura.getString("servicio"):"";
                    String fechaInicio = (factura.getString("fechaInicio") != null && !factura.getString("fechaInicio").equals("null")) ? factura.getString("fechaInicio"):"";
                    String fechaFinalizaServicio = (factura.getString("fechaFinalizaServicio") != null && !factura.getString("fechaFinalizaServicio").equals("null")) ? factura.getString("fechaFinalizaServicio"):"";
                    String valorServicio = (factura.getString("valorServicio") != null && !factura.getString("valorServicio").equals("null")) ? factura.getString("valorServicio"):"";
                    String seguroHotelero = (factura.getString("seguroHotelero") != null && !factura.getString("seguroHotelero").equals("null")) ? factura.getString("seguroHotelero"):"";
                    String tipoPago = (factura.getString("tipoPago") != null && !factura.getString("tipoPago").equals("null")) ? factura.getString("tipoPago"):"";

                    InformacionFacturaDTO facturaDTO = new InformacionFacturaDTO(proveedor, ordenServicio, servicio, fechaInicio, fechaFinalizaServicio, Utilities.formatearNumeroTexto(valorServicio), seguroHotelero, tipoPago);

                    if (lstInformacionFactura==null){
                        lstInformacionFactura = new ArrayList<>();
                    }

                    lstInformacionFactura.add(facturaDTO);

                }

                JSONArray jsonArrayImpuesto = obj.optJSONArray("impuestos");

                for (int x = 0; x < jsonArrayImpuesto.length(); x++) {
                    JSONObject impuesto = jsonArrayImpuesto.getJSONObject(x);

                    String ordenServicio = (impuesto.getString("ordenServicio") != null && !impuesto.getString("ordenServicio").equals("null")) ? impuesto.getString("ordenServicio"):"";
                    String tipoImpuesto = (impuesto.getString("tipoImpuesto") != null && !impuesto.getString("tipoImpuesto").equals("null")) ? impuesto.getString("tipoImpuesto"):"";
                    String servicio = (impuesto.getString("servicio") != null && !impuesto.getString("servicio").equals("null")) ? impuesto.getString("servicio"):"";
                    String porcentaje = (impuesto.getString("porcentaje") != null && !impuesto.getString("porcentaje").equals("null")) ? impuesto.getString("porcentaje"):"";
                    String valorImpuesto = (impuesto.getString("valorImpuesto") != null && !impuesto.getString("valorImpuesto").equals("null")) ? impuesto.getString("valorImpuesto"):"";
                    String aplicaSeguro = (impuesto.getString("aplicaSeguro") != null && !impuesto.getString("aplicaSeguro").equals("null")) ? impuesto.getString("aplicaSeguro"):"";

                    ImpuestoFacturaDTO impuestoFacturaDTO = new ImpuestoFacturaDTO(ordenServicio, tipoImpuesto, servicio, porcentaje, valorImpuesto, aplicaSeguro);

                    if (lstImpuestoFactura==null){
                        lstImpuestoFactura = new ArrayList<>();
                    }

                    lstImpuestoFactura.add(impuestoFacturaDTO);

                }

                facturaSeleccionado = new DetalleFacturaDTO(facturaNro, fechaEmision, fechaVencimientoPago, fechaRecibidoCoomeva, proveedor, Utilities.formatearNumeroTexto(valorTotalFactura), Utilities.formatearNumeroTexto(valorIva), Utilities.formatearNumeroTexto(valorTotalPagar), descripcion, motivo, aplicaGlosa, Utilities.formatearNumeroTexto(valorGlosa), lstInformacionFactura, lstImpuestoFactura);

            }

        }catch (Exception e){
            Toast.makeText(getActivity(),e.getMessage(), Toast.LENGTH_LONG).show();
        }
        return respuesta ;
    }

}
