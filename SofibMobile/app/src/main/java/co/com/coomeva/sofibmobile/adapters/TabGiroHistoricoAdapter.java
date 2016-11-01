package co.com.coomeva.sofibmobile.adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import java.util.List;

import co.com.coomeva.sofibmobile.R;
import co.com.coomeva.sofibmobile.dto.HistoricoGirosDTO;
import co.com.coomeva.sofibmobile.dto.ManutencionDTO;

/**
 * Created by JuanCamilo on 9/25/16.
 */
public class TabGiroHistoricoAdapter extends ArrayAdapter<HistoricoGirosDTO> {


    private Context context;
    private List<HistoricoGirosDTO> lstHistoricoGiros;
    LayoutInflater inflater;

    public TabGiroHistoricoAdapter(Context context, List<HistoricoGirosDTO> lstHistoricoGiros) {
        super(context, R.layout.adapter_tab_giro_historico, lstHistoricoGiros);
        this.context = context;
        this.lstHistoricoGiros = lstHistoricoGiros;

    }

    public class ViewHolder{

        TextView txtId;
        TextView txtCiudad;
        TextView txtConvenio;
        TextView txtEstado;
        TextView txtTipoGiro;


    }


    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        if (convertView==null){
            inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            convertView = inflater.inflate(R.layout.adapter_tab_giro_historico, null);
        }

        ViewHolder viewHolder = new ViewHolder();

        viewHolder.txtId = (TextView) convertView.findViewById(R.id.txtId);
        viewHolder.txtCiudad = (TextView) convertView.findViewById(R.id.txtCiudad);
        viewHolder.txtConvenio = (TextView) convertView.findViewById(R.id.txtConvenio);
        viewHolder.txtEstado = (TextView) convertView.findViewById(R.id.txtEstado);
        viewHolder.txtTipoGiro = (TextView) convertView.findViewById(R.id.txtTipoGiro);

        viewHolder.txtId.setText(lstHistoricoGiros.get(position).getId());
        viewHolder.txtCiudad.setText(lstHistoricoGiros.get(position).getCiudad());
        viewHolder.txtConvenio.setText(lstHistoricoGiros.get(position).getConvenio());
        viewHolder.txtEstado.setText(lstHistoricoGiros.get(position).getEstado());
        viewHolder.txtTipoGiro.setText(lstHistoricoGiros.get(position).getTipoGiro());


        return convertView;
    }
}
