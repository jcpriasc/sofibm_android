package co.com.coomeva.sofibmobile.adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import java.util.List;

import co.com.coomeva.sofibmobile.R;
import co.com.coomeva.sofibmobile.dto.ImpuestoNotaCreditoDebitoDTO;
import co.com.coomeva.sofibmobile.dto.ServicioNotaCreditoDebitoDTO;

/**
 * Created by JuanCamilo on 9/25/16.
 */
public class TabNotaCreditoDebitoServicioAdapter extends ArrayAdapter<ServicioNotaCreditoDebitoDTO> {


    private Context context;
    private List<ServicioNotaCreditoDebitoDTO> lstServicioNotaCreditoDebito;
    LayoutInflater inflater;

    public TabNotaCreditoDebitoServicioAdapter(Context context, List<ServicioNotaCreditoDebitoDTO> lstServicioNotaCreditoDebito) {
        super(context, R.layout.adapter_tab_nota_credito_servicio, lstServicioNotaCreditoDebito);
        this.context = context;
        this.lstServicioNotaCreditoDebito = lstServicioNotaCreditoDebito;

    }

    public class ViewHolder{

        TextView txtNumeroOrdenServicio;
        TextView txtTipoImpuesto;
        TextView txtServicio;
        TextView txtPorcentaje;
        TextView txtValorImpuesto;
        TextView txtAplicaSeguroHotelero;

    }


    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        if (convertView==null){
            inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            convertView = inflater.inflate(R.layout.adapter_tab_nota_credito_servicio, null);
        }

        ViewHolder viewHolder = new ViewHolder();

        viewHolder.txtNumeroOrdenServicio = (TextView) convertView.findViewById(R.id.txtNumeroOrdenServicio);
        viewHolder.txtTipoImpuesto = (TextView) convertView.findViewById(R.id.txtTipoImpuesto);
        viewHolder.txtServicio = (TextView) convertView.findViewById(R.id.txtServicio);
        viewHolder.txtPorcentaje = (TextView) convertView.findViewById(R.id.txtPorcentaje);
        viewHolder.txtValorImpuesto = (TextView) convertView.findViewById(R.id.txtValorImpuesto);
        viewHolder.txtAplicaSeguroHotelero = (TextView) convertView.findViewById(R.id.txtAplicaSeguroHotelero);

        viewHolder.txtNumeroOrdenServicio.setText(lstServicioNotaCreditoDebito.get(position).getNumeroOrdenServicio());
        viewHolder.txtTipoImpuesto.setText(lstServicioNotaCreditoDebito.get(position).getTipoImpuesto());
        viewHolder.txtServicio.setText(lstServicioNotaCreditoDebito.get(position).getServicio());
        viewHolder.txtPorcentaje.setText(lstServicioNotaCreditoDebito.get(position).getPorcentajeTexto());
        viewHolder.txtValorImpuesto.setText(lstServicioNotaCreditoDebito.get(position).getValorImpuestoTexto());
        viewHolder.txtAplicaSeguroHotelero.setText(lstServicioNotaCreditoDebito.get(position).getAplicaSeguroHotelero());

        return convertView;
    }
}
