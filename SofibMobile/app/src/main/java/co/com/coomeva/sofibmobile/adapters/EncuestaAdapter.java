package co.com.coomeva.sofibmobile.adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import java.util.List;

import co.com.coomeva.sofibmobile.R;
import co.com.coomeva.sofibmobile.dto.EncuestaDTO;
import co.com.coomeva.sofibmobile.dto.UtilizacionesDTO;

/**
 * Created by JuanCamilo on 9/25/16.
 */
public class EncuestaAdapter extends ArrayAdapter<EncuestaDTO> {


    private Context context;
    private List<EncuestaDTO> lstEncuesta;
    LayoutInflater inflater;

    public EncuestaAdapter(Context context, List<EncuestaDTO> lstEncuesta) {
        super(context, R.layout.adapter_encuesta, lstEncuesta);
        this.context = context;
        this.lstEncuesta = lstEncuesta;

    }

    public class ViewHolder{

        TextView txtPregunta;
        TextView txtRespuesta;
        TextView txtObservacion;

    }


    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        if (convertView==null){
            inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            convertView = inflater.inflate(R.layout.adapter_encuesta, null);
        }

        ViewHolder viewHolder = new ViewHolder();

        viewHolder.txtPregunta = (TextView) convertView.findViewById(R.id.txtPregunta);
        viewHolder.txtRespuesta = (TextView) convertView.findViewById(R.id.txtRespuesta);
        viewHolder.txtObservacion = (TextView) convertView.findViewById(R.id.txtObservacion);

        viewHolder.txtPregunta.setText(lstEncuesta.get(position).getPregunta());
        viewHolder.txtRespuesta.setText(lstEncuesta.get(position).getRespuesta());
        viewHolder.txtObservacion.setText(lstEncuesta.get(position).getObservacion());

        return convertView;
    }
}
