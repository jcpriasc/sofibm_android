package co.com.coomeva.sofibmobile.adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import java.util.List;

import co.com.coomeva.sofibmobile.R;
import co.com.coomeva.sofibmobile.dto.FacturaDTO;
import co.com.coomeva.sofibmobile.dto.NotaCreditoGiroDTO;

/**
 * Created by JuanCamilo on 9/25/16.
 */
public class FacturaAdapter extends ArrayAdapter<FacturaDTO> {


    private Context context;
    private List<FacturaDTO> lstFactura;
    LayoutInflater inflater;

    public FacturaAdapter(Context context, List<FacturaDTO> lstFactura) {
        super(context, R.layout.adapter_factura, lstFactura);
        this.context = context;
        this.lstFactura = lstFactura;

    }

    public class ViewHolder{

        TextView txtNumeroFactura;
        TextView txtFechaExpedicion;
        TextView txtEstado;
        TextView txtValorTotalFactura;
    }


    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        if (convertView==null){
            inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            convertView = inflater.inflate(R.layout.adapter_factura, null);
        }

        ViewHolder viewHolder = new ViewHolder();

        viewHolder.txtNumeroFactura = (TextView) convertView.findViewById(R.id.txtNumeroFactura);
        viewHolder.txtFechaExpedicion = (TextView) convertView.findViewById(R.id.txtFechaExpedicion);
        viewHolder.txtEstado = (TextView) convertView.findViewById(R.id.txtEstado);
        viewHolder.txtValorTotalFactura = (TextView) convertView.findViewById(R.id.txtValorTotalFactura);

        viewHolder.txtNumeroFactura.setText(lstFactura.get(position).getNumeroFactura());
        viewHolder.txtFechaExpedicion.setText(lstFactura.get(position).getFechaExpedicionTexto());
        viewHolder.txtEstado.setText(lstFactura.get(position).getEstado());
        viewHolder.txtValorTotalFactura.setText(lstFactura.get(position).getValorTotalFacturaTexto());

        return convertView;
    }
}
