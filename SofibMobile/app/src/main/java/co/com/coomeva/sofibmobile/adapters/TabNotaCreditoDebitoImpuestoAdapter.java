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
import co.com.coomeva.sofibmobile.dto.ImpuestoNotaCreditoDebitoDTO;

/**
 * Created by JuanCamilo on 9/25/16.
 */
public class TabNotaCreditoDebitoImpuestoAdapter extends ArrayAdapter<ImpuestoNotaCreditoDebitoDTO> {


    private Context context;
    private List<ImpuestoNotaCreditoDebitoDTO> lstImpuestoNotaCreditoDebito;
    LayoutInflater inflater;

    public TabNotaCreditoDebitoImpuestoAdapter(Context context, List<ImpuestoNotaCreditoDebitoDTO> lstImpuestoNotaCreditoDebito) {
        super(context, R.layout.adapter_tab_nota_credito_impuesto, lstImpuestoNotaCreditoDebito);
        this.context = context;
        this.lstImpuestoNotaCreditoDebito = lstImpuestoNotaCreditoDebito;

    }

    public class ViewHolder{

        TextView txtProveedor;
        TextView txtNumeroOrden;
        TextView txtServicio;
        TextView txtValorServicio;

    }


    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        if (convertView==null){
            inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            convertView = inflater.inflate(R.layout.adapter_tab_nota_credito_impuesto, null);
        }

        ViewHolder viewHolder = new ViewHolder();

        viewHolder.txtProveedor = (TextView) convertView.findViewById(R.id.txtProveedor);
        viewHolder.txtNumeroOrden = (TextView) convertView.findViewById(R.id.txtNumeroOrden);
        viewHolder.txtServicio = (TextView) convertView.findViewById(R.id.txtServicio);
        viewHolder.txtValorServicio = (TextView) convertView.findViewById(R.id.txtValorServicio);

        viewHolder.txtProveedor.setText(lstImpuestoNotaCreditoDebito.get(position).getProveedor());
        viewHolder.txtNumeroOrden.setText(lstImpuestoNotaCreditoDebito.get(position).getNumeroOrdenServicio());
        viewHolder.txtServicio.setText(lstImpuestoNotaCreditoDebito.get(position).getServicio());
        viewHolder.txtValorServicio.setText(lstImpuestoNotaCreditoDebito.get(position).getValorServicioTexto());

        return convertView;
    }
}
