package co.com.coomeva.sofibmobile.adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.util.List;

import co.com.coomeva.sofibmobile.R;
import co.com.coomeva.sofibmobile.dto.ConsultaSolicitudDTO;

/**
 * Created by JuanCamilo on 9/25/16.
 */
public class ConsultaSolicitudAdapter extends ArrayAdapter<ConsultaSolicitudDTO> {


    private Context context;
    private List<ConsultaSolicitudDTO> listConsultaSolicitud;
    LayoutInflater inflater;

    public ConsultaSolicitudAdapter(Context context, List<ConsultaSolicitudDTO> listConsultaSolicitud) {
        super(context, R.layout.adapter_detalle_consulta, listConsultaSolicitud);

        this.context = context;
        this.listConsultaSolicitud = listConsultaSolicitud;

    }

    public class ViewHolder{

        TextView txtNombrePaciente;
        TextView txtEstado;
        TextView txtFechaSolicitud;

    }


    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        if (convertView==null){
            inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            convertView = inflater.inflate(R.layout.adapter_detalle_consulta, null);
        }

        ViewHolder viewHolder = new ViewHolder();


        viewHolder.txtNombrePaciente = (TextView) convertView.findViewById(R.id.textNombrePaciente);
        viewHolder.txtEstado = (TextView) convertView.findViewById(R.id.textEstado);
        viewHolder.txtFechaSolicitud = (TextView) convertView.findViewById(R.id.textFechaSolicitud);

        viewHolder.txtNombrePaciente.setText(listConsultaSolicitud.get(position).getNombrePaciente());
        viewHolder.txtEstado.setText(listConsultaSolicitud.get(position).getEstado());
        viewHolder.txtFechaSolicitud.setText(listConsultaSolicitud.get(position).getFechaSolicitudString());

        return convertView;
    }
}
