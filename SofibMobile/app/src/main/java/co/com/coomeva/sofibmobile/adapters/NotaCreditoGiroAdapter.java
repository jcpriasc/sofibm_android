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
import co.com.coomeva.sofibmobile.dto.NotaCreditoGiroDTO;

/**
 * Created by JuanCamilo on 9/25/16.
 */
public class NotaCreditoGiroAdapter extends ArrayAdapter<NotaCreditoGiroDTO> {


    private Context context;
    private List<NotaCreditoGiroDTO> lstNotaCreditoGiros;
    LayoutInflater inflater;

    public NotaCreditoGiroAdapter(Context context, List<NotaCreditoGiroDTO> lstNotaCreditoGiros) {
        super(context, R.layout.adapter_nota_credito_giro, lstNotaCreditoGiros);
        this.context = context;
        this.lstNotaCreditoGiros = lstNotaCreditoGiros;

    }

    public class ViewHolder{

        TextView txtConsecutivoNotaCredito;
        TextView txtIdGiroAsociado;
        TextView txtNombreBeneficiario;
        TextView txtTipoGiro;
    }


    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        if (convertView==null){
            inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            convertView = inflater.inflate(R.layout.adapter_nota_credito_giro, null);
        }

        ViewHolder viewHolder = new ViewHolder();

        viewHolder.txtConsecutivoNotaCredito = (TextView) convertView.findViewById(R.id.txtConsecutivoNotaCredito);
        viewHolder.txtIdGiroAsociado = (TextView) convertView.findViewById(R.id.txtIdGiroAsociado);
        viewHolder.txtNombreBeneficiario = (TextView) convertView.findViewById(R.id.txtNombreBeneficiario);
        viewHolder.txtTipoGiro = (TextView) convertView.findViewById(R.id.txtTipoGiro);

        viewHolder.txtConsecutivoNotaCredito.setText(lstNotaCreditoGiros.get(position).getConsecutivoNotaCredito());
        viewHolder.txtIdGiroAsociado.setText(lstNotaCreditoGiros.get(position).getIdGiroAsociado());
        viewHolder.txtNombreBeneficiario.setText(lstNotaCreditoGiros.get(position).getNombreBeneficiario());
        viewHolder.txtTipoGiro.setText(lstNotaCreditoGiros.get(position).getTipoGiro());

        return convertView;
    }
}
