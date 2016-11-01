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
import co.com.coomeva.sofibmobile.dto.ManutencionDTO;

/**
 * Created by JuanCamilo on 9/25/16.
 */
public class TabGiroManutencionAdapter extends ArrayAdapter<ManutencionDTO> {


    private Context context;
    private List<ManutencionDTO> lstManutencion;
    LayoutInflater inflater;

    public TabGiroManutencionAdapter(Context context, List<ManutencionDTO> lstManutencion) {
        super(context, R.layout.adapter_tab_giro_manutencion, lstManutencion);
        this.context = context;
        this.lstManutencion = lstManutencion;

    }

    public class ViewHolder{

        TextView txtEstado;
        TextView txtEdadDesde;
        TextView txtEdadHasta;
        TextView txtMontoDiario;

    }


    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        if (convertView==null){
            inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            convertView = inflater.inflate(R.layout.adapter_tab_giro_manutencion, null);
        }

        ViewHolder viewHolder = new ViewHolder();

        viewHolder.txtEstado = (TextView) convertView.findViewById(R.id.txtEstado);
        viewHolder.txtEdadDesde = (TextView) convertView.findViewById(R.id.txtEdadDesde);
        viewHolder.txtEdadHasta = (TextView) convertView.findViewById(R.id.txtEdadHasta);
        viewHolder.txtMontoDiario = (TextView) convertView.findViewById(R.id.txtMontoDiario);

        viewHolder.txtEstado.setText(lstManutencion.get(position).getEstado());
        viewHolder.txtEdadDesde.setText(lstManutencion.get(position).getEdadDesde());
        viewHolder.txtEdadHasta.setText(lstManutencion.get(position).getEdadHasta());
        viewHolder.txtMontoDiario.setText(lstManutencion.get(position).getMontoDiarioTexto());


        return convertView;
    }
}
