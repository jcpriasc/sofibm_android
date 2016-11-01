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
import co.com.coomeva.sofibmobile.dto.ServicioAdicionalDTO;

/**
 * Created by JuanCamilo on 9/25/16.
 */
public class DetalleServiciosAdicionadosAdapter extends ArrayAdapter<ServicioAdicionalDTO> {


    private Context context;
    private List<ServicioAdicionalDTO> lstServicioAdicional;
    LayoutInflater inflater;

    public DetalleServiciosAdicionadosAdapter(Context context, List<ServicioAdicionalDTO> lstServicioAdicional) {
        super(context, R.layout.adapter_detalle_servicios_adicionado, lstServicioAdicional);
        this.context = context;
        this.lstServicioAdicional = lstServicioAdicional;

    }

    public class ViewHolder{

        TextView txtNombre;
        TextView txtDescripcion;
        TextView txtProveedor;

    }


    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        if (convertView==null){
            inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            convertView = inflater.inflate(R.layout.adapter_detalle_servicios_adicionado, null);
        }

        ViewHolder viewHolder = new ViewHolder();

        viewHolder.txtNombre = (TextView) convertView.findViewById(R.id.txtNombre);
        viewHolder.txtDescripcion = (TextView) convertView.findViewById(R.id.txtDescripcion);
        viewHolder.txtProveedor = (TextView) convertView.findViewById(R.id.txtProveedor);

        viewHolder.txtNombre.setText(lstServicioAdicional.get(position).getNombre());
        viewHolder.txtDescripcion.setText(lstServicioAdicional.get(position).getDescripcion());
        viewHolder.txtProveedor.setText(lstServicioAdicional.get(position).getProveedor());

        return convertView;
    }
}
