package co.com.coomeva.sofibmobile.adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import java.util.List;

import co.com.coomeva.sofibmobile.R;
import co.com.coomeva.sofibmobile.dto.NotaCreditoDebitoDTO;
import co.com.coomeva.sofibmobile.dto.UtilizacionesDTO;

/**
 * Created by JuanCamilo on 9/25/16.
 */
public class UtilizacionesAdapter extends ArrayAdapter<UtilizacionesDTO> {


    private Context context;
    private List<UtilizacionesDTO> lstUtilizaciones;
    LayoutInflater inflater;

    public UtilizacionesAdapter(Context context, List<UtilizacionesDTO> lstUtilizaciones) {
        super(context, R.layout.adapter_utilizaciones, lstUtilizaciones);
        this.context = context;
        this.lstUtilizaciones = lstUtilizaciones;

    }

    public class ViewHolder{

        TextView txtConvenio;
        TextView txtDesde;
        TextView txtHasta;

    }


    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        if (convertView==null){
            inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            convertView = inflater.inflate(R.layout.adapter_utilizaciones, null);
        }

        ViewHolder viewHolder = new ViewHolder();

        viewHolder.txtConvenio = (TextView) convertView.findViewById(R.id.txtConvenio);
        viewHolder.txtDesde = (TextView) convertView.findViewById(R.id.txtDesde);
        viewHolder.txtHasta = (TextView) convertView.findViewById(R.id.txtHasta);

        viewHolder.txtConvenio.setText(lstUtilizaciones.get(position).getConvenio());
        viewHolder.txtDesde.setText(lstUtilizaciones.get(position).getDesdeTexto());
        viewHolder.txtHasta.setText(lstUtilizaciones.get(position).getHastaTexto());

        return convertView;
    }
}
