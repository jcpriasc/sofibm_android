package co.com.coomeva.sofibmobile.adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import java.util.List;

import co.com.coomeva.sofibmobile.R;
import co.com.coomeva.sofibmobile.dto.DetalleFacturaDTO;
import co.com.coomeva.sofibmobile.dto.HistoricoGirosDTO;
import co.com.coomeva.sofibmobile.dto.ImpuestoFacturaDTO;

/**
 * Created by JuanCamilo on 9/25/16.
 */
public class TabFacturaImpuestoAdapter extends ArrayAdapter<ImpuestoFacturaDTO> {


    private Context context;
    private List<ImpuestoFacturaDTO> lstImpuestoFactura;
    LayoutInflater inflater;

    public TabFacturaImpuestoAdapter(Context context, List<ImpuestoFacturaDTO> lstImpuestoFactura) {
        super(context, R.layout.adapter_tab_factura_impuesto, lstImpuestoFactura);
        this.context = context;
        this.lstImpuestoFactura = lstImpuestoFactura;

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
            convertView = inflater.inflate(R.layout.adapter_tab_factura_impuesto, null);
        }

        ViewHolder viewHolder = new ViewHolder();

        viewHolder.txtNumeroOrdenServicio = (TextView) convertView.findViewById(R.id.txtNumeroOrdenServicio);
        viewHolder.txtTipoImpuesto = (TextView) convertView.findViewById(R.id.txtTipoImpuesto);
        viewHolder.txtServicio = (TextView) convertView.findViewById(R.id.txtServicio);
        viewHolder.txtPorcentaje = (TextView) convertView.findViewById(R.id.txtPorcentaje);
        viewHolder.txtValorImpuesto = (TextView) convertView.findViewById(R.id.txtValorImpuesto);
        viewHolder.txtAplicaSeguroHotelero = (TextView) convertView.findViewById(R.id.txtAplicaSeguroHotelero);

        viewHolder.txtNumeroOrdenServicio.setText(lstImpuestoFactura.get(position).getNumeroOrdenServicio());
        viewHolder.txtTipoImpuesto.setText(lstImpuestoFactura.get(position).getTipoImpuesto());
        viewHolder.txtServicio.setText(lstImpuestoFactura.get(position).getServicio());
        viewHolder.txtPorcentaje.setText(lstImpuestoFactura.get(position).getPorcentajeTexto());
        viewHolder.txtValorImpuesto.setText(lstImpuestoFactura.get(position).getValorImpuestoTexto());
        viewHolder.txtAplicaSeguroHotelero.setText(lstImpuestoFactura.get(position).getAplicaSeguroHotelero());


        return convertView;
    }
}
