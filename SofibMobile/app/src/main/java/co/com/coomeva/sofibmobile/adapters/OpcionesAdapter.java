package co.com.coomeva.sofibmobile.adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;

import co.com.coomeva.sofibmobile.R;
import co.com.coomeva.sofibmobile.dto.ConsultaSolicitudDTO;
import co.com.coomeva.sofibmobile.dto.OpcionesDTO;

/**
 * Created by JuanCamilo on 9/25/16.
 */
public class OpcionesAdapter extends ArrayAdapter<OpcionesDTO> {


    private Context context;
    private List<OpcionesDTO> listOpciones;
    LayoutInflater inflater;

    public OpcionesAdapter(Context context, List<OpcionesDTO> listOpciones) {
        super(context, R.layout.adapter_opciones, listOpciones);

        this.context = context;
        this.listOpciones = listOpciones;

    }

    public class ViewHolder{

        TextView txtNombreOpcion;
        ImageView imageView;

    }


    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        if (convertView==null){
            inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            convertView = inflater.inflate(R.layout.adapter_opciones, null);
        }

        ViewHolder viewHolder = new ViewHolder();


        viewHolder.txtNombreOpcion = (TextView) convertView.findViewById(R.id.nombre_opcion);
        viewHolder.imageView = (ImageView) convertView.findViewById(R.id.icon_opcion);

        viewHolder.txtNombreOpcion.setText(listOpciones.get(position).getNombreOpcion());
        viewHolder.imageView.setImageResource(listOpciones.get(position).getIcono());

        return convertView;
    }
}
