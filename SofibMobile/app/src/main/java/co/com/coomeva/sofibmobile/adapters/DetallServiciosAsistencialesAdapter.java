package co.com.coomeva.sofibmobile.adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import java.util.List;

import co.com.coomeva.sofibmobile.R;
import co.com.coomeva.sofibmobile.dto.DetallServiciosAsistencialesDTO;
import co.com.coomeva.sofibmobile.dto.DetalleAutorizacionesDTO;

/**
 * Created by JuanCamilo on 9/25/16.
 */
public class DetallServiciosAsistencialesAdapter extends ArrayAdapter<DetallServiciosAsistencialesDTO> {


    private Context context;
    private List<DetallServiciosAsistencialesDTO> listDetallServiciosAsistenciales;
    LayoutInflater inflater;

    public DetallServiciosAsistencialesAdapter(Context context, List<DetallServiciosAsistencialesDTO> listDetallServiciosAsistenciales) {
        super(context, R.layout.adapter_detalle_de_servicio_asistencial, listDetallServiciosAsistenciales);

        this.context = context;
        this.listDetallServiciosAsistenciales = listDetallServiciosAsistenciales;

    }

    public class ViewHolder{
        TextView txtEstado;
        TextView txtFecha;
    }


    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        if (convertView==null){
            inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            convertView = inflater.inflate(R.layout.adapter_detalle_de_servicio_asistencial, null);
        }

        ViewHolder viewHolder = new ViewHolder();

        viewHolder.txtEstado = (TextView) convertView.findViewById(R.id.textEstado);
        viewHolder.txtFecha = (TextView) convertView.findViewById(R.id.textFecha);

        viewHolder.txtEstado.setText(listDetallServiciosAsistenciales.get(position).getEstado());
        viewHolder.txtFecha.setText(listDetallServiciosAsistenciales.get(position).getFechaTexto());

        return convertView;
    }
}
