package co.com.coomeva.sofibmobile.adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import java.util.List;

import co.com.coomeva.sofibmobile.R;
import co.com.coomeva.sofibmobile.dto.BitacoraDTO;
import co.com.coomeva.sofibmobile.dto.InformesMedicosDTO;

/**
 * Created by JuanCamilo on 9/25/16.
 */
public class InformesMedicosAdapter extends ArrayAdapter<InformesMedicosDTO> {


    private Context context;
    private List<InformesMedicosDTO> listInformesMedicos;
    LayoutInflater inflater;

    public InformesMedicosAdapter(Context context, List<InformesMedicosDTO> listInformesMedicos) {
        super(context, R.layout.adapter_consulta_informe_medico, listInformesMedicos);

        this.context = context;
        this.listInformesMedicos = listInformesMedicos;

    }

    public class ViewHolder{

        TextView txtFecha;
        TextView txtCiudad;
        TextView txtDadoDeAlta;
        TextView txtFallecio;
        TextView txtEstado;

    }


    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        if (convertView==null){
            inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            convertView = inflater.inflate(R.layout.adapter_consulta_informe_medico, null);
        }

        ViewHolder viewHolder = new ViewHolder();

        viewHolder.txtFecha = (TextView) convertView.findViewById(R.id.textFecha);
        viewHolder.txtCiudad = (TextView) convertView.findViewById(R.id.textCiudad);
        viewHolder.txtDadoDeAlta = (TextView) convertView.findViewById(R.id.textDadoAlta);
        viewHolder.txtFallecio = (TextView) convertView.findViewById(R.id.textFallecio);
        viewHolder.txtEstado = (TextView) convertView.findViewById(R.id.textEstado);

        viewHolder.txtFecha.setText(listInformesMedicos.get(position).getFechaCreadoString());
        viewHolder.txtCiudad.setText(listInformesMedicos.get(position).getCiudad());
        viewHolder.txtDadoDeAlta.setText(listInformesMedicos.get(position).getDadoDeAlta());
        viewHolder.txtFallecio.setText(listInformesMedicos.get(position).getFallecio());
        viewHolder.txtEstado.setText(listInformesMedicos.get(position).getEstado());

        return convertView;
    }
}
