package co.com.coomeva.sofibmobile.adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import java.util.List;

import co.com.coomeva.sofibmobile.R;
import co.com.coomeva.sofibmobile.dto.GirosDTO;
import co.com.coomeva.sofibmobile.dto.ServicioNoAsistencialDTO;

/**
 * Created by JuanCamilo on 9/25/16.
 */
public class GiroAdapter extends ArrayAdapter<GirosDTO> {


    private Context context;
    private List<GirosDTO> lstGiros;
    LayoutInflater inflater;

    public GiroAdapter(Context context, List<GirosDTO> lstGiros) {
        super(context, R.layout.adapter_giros, lstGiros);
        this.context = context;
        this.lstGiros = lstGiros;

    }

    public class ViewHolder{

        TextView txtId;
        TextView txtTipoGiro;
        TextView txtIdentificacionBeneficiario;
        TextView txtBeneficiario;
        TextView txtEstado;
    }


    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        if (convertView==null){
            inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            convertView = inflater.inflate(R.layout.adapter_giros, null);
        }

        ViewHolder viewHolder = new ViewHolder();

        viewHolder.txtId = (TextView) convertView.findViewById(R.id.txtId);
        viewHolder.txtTipoGiro = (TextView) convertView.findViewById(R.id.txtTipoGiro);
        viewHolder.txtIdentificacionBeneficiario = (TextView) convertView.findViewById(R.id.txtIdentificacionBeneficiario);
        viewHolder.txtBeneficiario = (TextView) convertView.findViewById(R.id.txtBeneficiario);
        viewHolder.txtEstado = (TextView) convertView.findViewById(R.id.txtEstado);

        viewHolder.txtId.setText(lstGiros.get(position).getId());
        viewHolder.txtTipoGiro.setText(lstGiros.get(position).getTipoGiro());
        viewHolder.txtIdentificacionBeneficiario.setText(lstGiros.get(position).getIdentificacionBeneficiario());
        viewHolder.txtBeneficiario.setText(lstGiros.get(position).getBeneficiario());
        viewHolder.txtEstado.setText(lstGiros.get(position).getEstado());

        return convertView;
    }
}
