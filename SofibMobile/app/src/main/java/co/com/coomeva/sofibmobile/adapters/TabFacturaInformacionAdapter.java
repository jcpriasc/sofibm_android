package co.com.coomeva.sofibmobile.adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import java.util.List;

import co.com.coomeva.sofibmobile.R;
import co.com.coomeva.sofibmobile.dto.ImpuestoFacturaDTO;
import co.com.coomeva.sofibmobile.dto.InformacionFacturaDTO;

/**
 * Created by JuanCamilo on 9/25/16.
 */
public class TabFacturaInformacionAdapter extends ArrayAdapter<InformacionFacturaDTO> {


    private Context context;
    private List<InformacionFacturaDTO> lstInformacionFactura;
    LayoutInflater inflater;

    public TabFacturaInformacionAdapter(Context context, List<InformacionFacturaDTO> lstInformacionFactura) {
        super(context, R.layout.adapter_tab_factura_informacion, lstInformacionFactura);
        this.context = context;
        this.lstInformacionFactura = lstInformacionFactura;

    }

    public class ViewHolder{

        TextView txtProveedor;
        TextView txtNumeroOrdenServicio;
        TextView txtServicio;
        TextView txtFechaInicio;
        TextView txtFechaFinalizacion;
        TextView txtValorServicio;
        TextView txtSeguroHotelero;
        TextView txtTipoPago;


    }


    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        if (convertView==null){
            inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            convertView = inflater.inflate(R.layout.adapter_tab_factura_informacion, null);
        }

        ViewHolder viewHolder = new ViewHolder();

        viewHolder.txtProveedor = (TextView) convertView.findViewById(R.id.txtProveedor);
        viewHolder.txtNumeroOrdenServicio = (TextView) convertView.findViewById(R.id.txtNumeroOrdenServicio);
        viewHolder.txtServicio = (TextView) convertView.findViewById(R.id.txtServicio);
        viewHolder.txtFechaInicio = (TextView) convertView.findViewById(R.id.txtFechaInicio);
        viewHolder.txtFechaFinalizacion = (TextView) convertView.findViewById(R.id.txtFechaFinalizacion);
        viewHolder.txtValorServicio = (TextView) convertView.findViewById(R.id.txtValorServicio);
        viewHolder.txtSeguroHotelero = (TextView) convertView.findViewById(R.id.txtSeguroHotelero);
        viewHolder.txtTipoPago = (TextView) convertView.findViewById(R.id.txtTipoPago);

        viewHolder.txtProveedor.setText(lstInformacionFactura.get(position).getProveedor());
        viewHolder.txtNumeroOrdenServicio.setText(lstInformacionFactura.get(position).getNumeroOrdenServicio());
        viewHolder.txtServicio.setText(lstInformacionFactura.get(position).getServicio());
        viewHolder.txtFechaInicio.setText(lstInformacionFactura.get(position).getFechaInicioTexto());
        viewHolder.txtFechaFinalizacion.setText(lstInformacionFactura.get(position).getFechaFinalizacionTexto());
        viewHolder.txtValorServicio.setText(lstInformacionFactura.get(position).getValorServicioTexto());
        viewHolder.txtSeguroHotelero.setText(lstInformacionFactura.get(position).getSeguroHoteleroTexto());
        viewHolder.txtTipoPago.setText(lstInformacionFactura.get(position).getTipoPago());


        return convertView;
    }
}
