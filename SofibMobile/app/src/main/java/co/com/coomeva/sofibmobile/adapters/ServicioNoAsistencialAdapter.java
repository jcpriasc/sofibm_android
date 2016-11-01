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
import co.com.coomeva.sofibmobile.dto.ServicioNoAsistencialDTO;

/**
 * Created by JuanCamilo on 9/25/16.
 */
public class ServicioNoAsistencialAdapter extends ArrayAdapter<ServicioNoAsistencialDTO> {


    private Context context;
    private List<ServicioNoAsistencialDTO> listSerivicioNoAsistencial;
    LayoutInflater inflater;

    public ServicioNoAsistencialAdapter(Context context, List<ServicioNoAsistencialDTO> listSerivicioNoAsistencial) {
        super(context, R.layout.adapter_servicio_no_asistencial, listSerivicioNoAsistencial);
        this.context = context;
        this.listSerivicioNoAsistencial = listSerivicioNoAsistencial;

    }

    public class ViewHolder{

        TextView txtNumeroSolicitud;
        TextView txtTipoSolicitud;
        TextView txtCiudad;

    }


    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        if (convertView==null){
            inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            convertView = inflater.inflate(R.layout.adapter_servicio_no_asistencial, null);
        }

        ViewHolder viewHolder = new ViewHolder();

        viewHolder.txtNumeroSolicitud = (TextView) convertView.findViewById(R.id.txtNumeroSolicitud);
        viewHolder.txtTipoSolicitud = (TextView) convertView.findViewById(R.id.txtTipoSolicitud);
        viewHolder.txtCiudad = (TextView) convertView.findViewById(R.id.txtCiudad);

        viewHolder.txtNumeroSolicitud.setText(listSerivicioNoAsistencial.get(position).getNumeroSolicitud());
        viewHolder.txtTipoSolicitud.setText(listSerivicioNoAsistencial.get(position).getTipoSolicitud());
        viewHolder.txtCiudad.setText(listSerivicioNoAsistencial.get(position).getCiudad());

        return convertView;
    }
}
