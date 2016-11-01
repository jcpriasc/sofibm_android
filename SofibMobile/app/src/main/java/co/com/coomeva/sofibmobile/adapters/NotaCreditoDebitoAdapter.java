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
import co.com.coomeva.sofibmobile.dto.NotaCreditoDebitoDTO;

/**
 * Created by JuanCamilo on 9/25/16.
 */
public class NotaCreditoDebitoAdapter extends ArrayAdapter<NotaCreditoDebitoDTO> {


    private Context context;
    private List<NotaCreditoDebitoDTO> lstNotaCreditodDebito;
    LayoutInflater inflater;

    public NotaCreditoDebitoAdapter(Context context, List<NotaCreditoDebitoDTO> lstNotaCreditodDebito) {
        super(context, R.layout.adapter_nota_credito_debito, lstNotaCreditodDebito);
        this.context = context;
        this.lstNotaCreditodDebito = lstNotaCreditodDebito;

    }

    public class ViewHolder{

        TextView txtNumeroNota;
        TextView txtNumeroFactura;
        TextView txtFechaExpedicion;
        TextView txtFechaAprobacion;
    }


    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        if (convertView==null){
            inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            convertView = inflater.inflate(R.layout.adapter_nota_credito_debito, null);
        }

        ViewHolder viewHolder = new ViewHolder();

        viewHolder.txtNumeroNota = (TextView) convertView.findViewById(R.id.txtNumeroNota);
        viewHolder.txtNumeroFactura = (TextView) convertView.findViewById(R.id.txtNumeroFactura);
        viewHolder.txtFechaExpedicion = (TextView) convertView.findViewById(R.id.txtFechaExpedicion);
        viewHolder.txtFechaAprobacion = (TextView) convertView.findViewById(R.id.txtFechaAprobacion);

        viewHolder.txtNumeroNota.setText(lstNotaCreditodDebito.get(position).getNumeroNota());
        viewHolder.txtNumeroFactura.setText(lstNotaCreditodDebito.get(position).getNumeroFactura());
        viewHolder.txtFechaExpedicion.setText(lstNotaCreditodDebito.get(position).getFechaExpedicionTexto());
        viewHolder.txtFechaAprobacion.setText(lstNotaCreditodDebito.get(position).getFechaAprobacionTexto());

        return convertView;
    }
}
