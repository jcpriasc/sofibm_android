package co.com.coomeva.sofibmobile.adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import java.util.List;

import co.com.coomeva.sofibmobile.R;
import co.com.coomeva.sofibmobile.dto.AutorizacionesDTO;
import co.com.coomeva.sofibmobile.dto.ConsultaSolicitudDTO;

/**
 * Created by JuanCamilo on 9/25/16.
 */
public class AutoricionesAdapter extends ArrayAdapter<AutorizacionesDTO> {


    private Context context;
    private List<AutorizacionesDTO> listAutorizaciones;
    LayoutInflater inflater;

    public AutoricionesAdapter(Context context, List<AutorizacionesDTO> listAutorizaciones) {
        super(context, R.layout.adapter_detalle_autorizacion, listAutorizaciones);

        this.context = context;
        this.listAutorizaciones = listAutorizaciones;

    }

    public class ViewHolder{
        TextView txtDescripcion;
        TextView txtCiudad;
        TextView txtTipoSolicitud;
        TextView txtFechaSolicitud;
        TextView txtEstado;
        TextView txtFechaAprobacion;
        TextView txtFechaRechazo;

    }


    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        if (convertView==null){
            inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            convertView = inflater.inflate(R.layout.adapter_detalle_autorizacion, null);
        }

        ViewHolder viewHolder = new ViewHolder();

        viewHolder.txtDescripcion = (TextView) convertView.findViewById(R.id.txtDescripcion);
        viewHolder.txtCiudad = (TextView) convertView.findViewById(R.id.txtCiudad);
        viewHolder.txtTipoSolicitud = (TextView) convertView.findViewById(R.id.txtTipoSolicitud);
        viewHolder.txtFechaSolicitud = (TextView) convertView.findViewById(R.id.txtFechaSolicitud);
        viewHolder.txtEstado = (TextView) convertView.findViewById(R.id.txtEstado);
        viewHolder.txtFechaAprobacion = (TextView) convertView.findViewById(R.id.txtFechaAprobacion);
        viewHolder.txtFechaRechazo = (TextView) convertView.findViewById(R.id.txtFechaRechazo);

        viewHolder.txtDescripcion.setText(listAutorizaciones.get(position).getDescripcion());
        viewHolder.txtCiudad.setText(listAutorizaciones.get(position).getCiudad());
        viewHolder.txtTipoSolicitud.setText(listAutorizaciones.get(position).getTipoSolicitud());
        viewHolder.txtFechaSolicitud.setText(listAutorizaciones.get(position).getFechaSolicitudString());
        viewHolder.txtEstado.setText(listAutorizaciones.get(position).getEstado());
        viewHolder.txtFechaAprobacion.setText(listAutorizaciones.get(position).getFechaAprobacionString());
        viewHolder.txtFechaRechazo.setText(listAutorizaciones.get(position).getFechaRechazoString());

        return convertView;
    }
}
