package co.com.coomeva.sofibmobile.adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import java.util.List;

import co.com.coomeva.sofibmobile.R;
import co.com.coomeva.sofibmobile.dto.DetalleUtilizacionesDTO;
import co.com.coomeva.sofibmobile.dto.UtilizacionesDTO;

/**
 * Created by JuanCamilo on 9/25/16.
 */
public class DetalleUtilizacionesAdapter extends ArrayAdapter<DetalleUtilizacionesDTO> {


    private Context context;
    private List<DetalleUtilizacionesDTO> lstDetalleUtilizaciones;
    LayoutInflater inflater;

    public DetalleUtilizacionesAdapter(Context context, List<DetalleUtilizacionesDTO> lstDetalleUtilizaciones) {
        super(context, R.layout.adapter_detalle_utilizaciones, lstDetalleUtilizaciones);
        this.context = context;
        this.lstDetalleUtilizaciones = lstDetalleUtilizaciones;

    }

    public class ViewHolder{

        TextView txtTipoSeguro;
        TextView txtNumeroSeguro;
        TextView txtPrestadorProveedor;
        TextView txtConcepto;
        TextView txtTotal;
        TextView txtTotalGlosa;
        TextView txtFechaCreado;

    }


    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        if (convertView==null){
            inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            convertView = inflater.inflate(R.layout.adapter_detalle_utilizaciones, null);
        }

        ViewHolder viewHolder = new ViewHolder();

        viewHolder.txtTipoSeguro = (TextView) convertView.findViewById(R.id.txtTipoSeguro);
        viewHolder.txtNumeroSeguro = (TextView) convertView.findViewById(R.id.txtNumeroSeguro);
        viewHolder.txtPrestadorProveedor = (TextView) convertView.findViewById(R.id.txtPrestadorProveedor);
        viewHolder.txtConcepto = (TextView) convertView.findViewById(R.id.txtConcepto);
        viewHolder.txtTotal = (TextView) convertView.findViewById(R.id.txtTotal);
        viewHolder.txtTotalGlosa = (TextView) convertView.findViewById(R.id.txtTotalGlosa);
        viewHolder.txtFechaCreado = (TextView) convertView.findViewById(R.id.txtFechaCreado);


        viewHolder.txtTipoSeguro.setText(lstDetalleUtilizaciones.get(position).getTipoSeguro());
        viewHolder.txtNumeroSeguro.setText(lstDetalleUtilizaciones.get(position).getNumeroSeguro());
        viewHolder.txtPrestadorProveedor.setText(lstDetalleUtilizaciones.get(position).getPrestadorProveedor());
        viewHolder.txtConcepto.setText(lstDetalleUtilizaciones.get(position).getConcepto());
        viewHolder.txtTotal.setText(lstDetalleUtilizaciones.get(position).getTotalUtilizacionesTexto());
        viewHolder.txtTotalGlosa.setText(lstDetalleUtilizaciones.get(position).getTotalGlosaTexto());
        viewHolder.txtFechaCreado.setText(lstDetalleUtilizaciones.get(position).getFechaCreadoTexto());


        return convertView;
    }
}
