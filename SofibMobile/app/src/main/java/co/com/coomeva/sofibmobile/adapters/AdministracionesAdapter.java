package co.com.coomeva.sofibmobile.adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import java.util.List;

import co.com.coomeva.sofibmobile.R;
import co.com.coomeva.sofibmobile.dto.AdministracionesDTO;
import co.com.coomeva.sofibmobile.dto.DetalleUtilizacionesDTO;

/**
 * Created by JuanCamilo on 9/25/16.
 */
public class AdministracionesAdapter extends ArrayAdapter<AdministracionesDTO> {


    private Context context;
    private List<AdministracionesDTO> lstAdministraciones;
    LayoutInflater inflater;

    public AdministracionesAdapter(Context context, List<AdministracionesDTO> lstAdministraciones) {
        super(context, R.layout.adapter_detalle_administraciones, lstAdministraciones);
        this.context = context;
        this.lstAdministraciones = lstAdministraciones;

    }

    public class ViewHolder{

        TextView txtTotal;
        TextView txtTrm;
        TextView txtSubtotal;
        TextView txtPorcentajeIva;
        TextView txtValorIva;
        TextView txtFechaCreado;

    }


    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        if (convertView==null){
            inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            convertView = inflater.inflate(R.layout.adapter_detalle_administraciones, null);
        }

        ViewHolder viewHolder = new ViewHolder();

        viewHolder.txtTotal = (TextView) convertView.findViewById(R.id.txtTotal);
        viewHolder.txtTrm = (TextView) convertView.findViewById(R.id.txtTrm);
        viewHolder.txtSubtotal = (TextView) convertView.findViewById(R.id.txtSubtotal);
        viewHolder.txtPorcentajeIva = (TextView) convertView.findViewById(R.id.txtPorcentajeIva);
        viewHolder.txtValorIva = (TextView) convertView.findViewById(R.id.txtValorIva);
        viewHolder.txtFechaCreado = (TextView) convertView.findViewById(R.id.txtFechaCreado);

        viewHolder.txtTotal.setText(lstAdministraciones.get(position).getTotalAdministracionesTexto());
        viewHolder.txtTrm.setText(lstAdministraciones.get(position).getTrmTexto());
        viewHolder.txtSubtotal.setText(lstAdministraciones.get(position).getSubTotalTexto());
        viewHolder.txtPorcentajeIva.setText(lstAdministraciones.get(position).getPorcentajeIvaTexto());
        viewHolder.txtValorIva.setText(lstAdministraciones.get(position).getValorIvaTexto());
        viewHolder.txtFechaCreado.setText(lstAdministraciones.get(position).getFechaCreadoAdministracionesTexto());


        return convertView;
    }
}
