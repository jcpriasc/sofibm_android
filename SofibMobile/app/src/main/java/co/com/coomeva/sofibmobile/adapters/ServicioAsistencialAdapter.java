package co.com.coomeva.sofibmobile.adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import java.util.List;

import co.com.coomeva.sofibmobile.R;
import co.com.coomeva.sofibmobile.dto.ServicioAsistencialDTO;
import co.com.coomeva.sofibmobile.dto.ServicioNoAsistencialDTO;

/**
 * Created by JuanCamilo on 9/25/16.
 */
public class ServicioAsistencialAdapter extends ArrayAdapter<ServicioAsistencialDTO> {


    private Context context;
    private List<ServicioAsistencialDTO> listSerivicioAsistencial;
    LayoutInflater inflater;

    public ServicioAsistencialAdapter(Context context, List<ServicioAsistencialDTO> listSerivicioAsistencial) {
        super(context, R.layout.adapter_servicio_asistencial, listSerivicioAsistencial);
        this.context = context;
        this.listSerivicioAsistencial = listSerivicioAsistencial;

    }

    public class ViewHolder{

        TextView txtNumeroOrden;
        TextView txtIdPrestador;
        TextView txtNombrePrestador;
        TextView txtTipoServicio;

    }


    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        if (convertView==null){
            inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            convertView = inflater.inflate(R.layout.adapter_servicio_asistencial, null);
        }

        ViewHolder viewHolder = new ViewHolder();

        viewHolder.txtNumeroOrden = (TextView) convertView.findViewById(R.id.txtNumeroOrden);
        viewHolder.txtIdPrestador = (TextView) convertView.findViewById(R.id.txtIdPrestador);
        viewHolder.txtNombrePrestador = (TextView) convertView.findViewById(R.id.txtNombrePrestador);
        viewHolder.txtTipoServicio = (TextView) convertView.findViewById(R.id.txtTipoServicio);

        viewHolder.txtNumeroOrden.setText(listSerivicioAsistencial.get(position).getNumeroOrden());
        viewHolder.txtIdPrestador.setText(listSerivicioAsistencial.get(position).getIdPrestador());
        viewHolder.txtNombrePrestador.setText(listSerivicioAsistencial.get(position).getNombrePrestador());
        viewHolder.txtTipoServicio.setText(listSerivicioAsistencial.get(position).getTipoServicio());

        return convertView;
    }
}
