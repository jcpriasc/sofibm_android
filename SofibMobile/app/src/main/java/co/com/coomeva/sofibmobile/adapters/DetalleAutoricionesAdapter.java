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
import co.com.coomeva.sofibmobile.dto.DetalleAutorizacionesDTO;

/**
 * Created by JuanCamilo on 9/25/16.
 */
public class DetalleAutoricionesAdapter extends ArrayAdapter<DetalleAutorizacionesDTO> {


    private Context context;
    private List<DetalleAutorizacionesDTO> listDetalleAutorizaciones;
    LayoutInflater inflater;

    public DetalleAutoricionesAdapter(Context context, List<DetalleAutorizacionesDTO> listDetalleAutorizaciones) {
        super(context, R.layout.adapter_detalle_de_autorizacion, listDetalleAutorizaciones);

        this.context = context;
        this.listDetalleAutorizaciones = listDetalleAutorizaciones;

    }

    public class ViewHolder{
        TextView txtDescripcion;
        TextView txtEstado;
        TextView txtJustificacion;
    }


    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        if (convertView==null){
            inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            convertView = inflater.inflate(R.layout.adapter_detalle_de_autorizacion, null);
        }

        ViewHolder viewHolder = new ViewHolder();

        viewHolder.txtDescripcion = (TextView) convertView.findViewById(R.id.textDescripcion);
        viewHolder.txtEstado = (TextView) convertView.findViewById(R.id.textEstado);
        viewHolder.txtJustificacion = (TextView) convertView.findViewById(R.id.textJustificacionCancelacion);

        viewHolder.txtDescripcion.setText(listDetalleAutorizaciones.get(position).getDescripcion());
        viewHolder.txtEstado.setText(listDetalleAutorizaciones.get(position).getEstado());
        viewHolder.txtJustificacion.setText(listDetalleAutorizaciones.get(position).getJustificacionCancelado());

        return convertView;
    }
}
