package co.com.coomeva.sofibmobile.adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import java.util.List;

import co.com.coomeva.sofibmobile.R;
import co.com.coomeva.sofibmobile.dto.ConsultaSolicitudDTO;

/**
 * Created by JuanCamilo on 9/25/16.
 */
public class ConsultaSolicitudAtencionAdapter extends ArrayAdapter<ConsultaSolicitudDTO> {


    private Context context;
    private List<ConsultaSolicitudDTO> listConsultaSolicitud;
    LayoutInflater inflater;

    public ConsultaSolicitudAtencionAdapter(Context context, List<ConsultaSolicitudDTO> listConsultaSolicitud) {
        super(context, R.layout.adapter_consulta_solicitudes_atencion, listConsultaSolicitud);

        this.context = context;
        this.listConsultaSolicitud = listConsultaSolicitud;

    }

    public class ViewHolder{

        TextView txtNumeroSolicitud;
        TextView txtIdentificacion;
        TextView txtNombre;
        TextView txtConvenio;

    }


    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        if (convertView==null){
            inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            convertView = inflater.inflate(R.layout.adapter_consulta_solicitudes_atencion, null);
        }

        ViewHolder viewHolder = new ViewHolder();


        viewHolder.txtNumeroSolicitud = (TextView) convertView.findViewById(R.id.textNumeroSolicitud);
        viewHolder.txtIdentificacion = (TextView) convertView.findViewById(R.id.textIdentificacion);
        viewHolder.txtNombre = (TextView) convertView.findViewById(R.id.textNombre);
        viewHolder.txtConvenio = (TextView) convertView.findViewById(R.id.textConvenio);

        viewHolder.txtNumeroSolicitud.setText(listConsultaSolicitud.get(position).getNumeroSolicitud());
        viewHolder.txtIdentificacion.setText(listConsultaSolicitud.get(position).getIdentificacion());
        viewHolder.txtNombre.setText(listConsultaSolicitud.get(position).getNombrePaciente());
        viewHolder.txtConvenio.setText(listConsultaSolicitud.get(position).getConvenio());

        return convertView;
    }
}
