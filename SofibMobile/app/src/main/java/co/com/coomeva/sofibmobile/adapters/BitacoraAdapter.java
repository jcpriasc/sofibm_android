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
import co.com.coomeva.sofibmobile.dto.ConsultaSolicitudDTO;

/**
 * Created by JuanCamilo on 9/25/16.
 */
public class BitacoraAdapter extends ArrayAdapter<BitacoraDTO> {


    private Context context;
    private List<BitacoraDTO> listBitacora;
    LayoutInflater inflater;

    public BitacoraAdapter(Context context, List<BitacoraDTO> listBitacora) {
        super(context, R.layout.adapter_consulta_bitacora, listBitacora);

        this.context = context;
        this.listBitacora = listBitacora;

    }

    public class ViewHolder{

        TextView txtNumeroSolicitud;
        TextView txtNombrePaciente;
        TextView txtTipoRegistro;
        TextView txtTipoAccion;
        TextView txtEstado;

    }


    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        if (convertView==null){
            inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            convertView = inflater.inflate(R.layout.adapter_consulta_bitacora, null);
        }

        ViewHolder viewHolder = new ViewHolder();


        viewHolder.txtNumeroSolicitud = (TextView) convertView.findViewById(R.id.textNumeroSolicitud);
        viewHolder.txtNombrePaciente = (TextView) convertView.findViewById(R.id.textNombrePaciente);
        viewHolder.txtTipoRegistro = (TextView) convertView.findViewById(R.id.textTipoRegistro);
        viewHolder.txtTipoAccion = (TextView) convertView.findViewById(R.id.textTipoAccion);
        viewHolder.txtEstado = (TextView) convertView.findViewById(R.id.textEstado);

        viewHolder.txtNumeroSolicitud.setText(listBitacora.get(position).getNumeroSolicitud());
        viewHolder.txtNombrePaciente.setText(listBitacora.get(position).getNombrePaciente());
        viewHolder.txtTipoRegistro.setText(listBitacora.get(position).getTipoRegistro());
        viewHolder.txtTipoAccion.setText(listBitacora.get(position).getTipoAccion());
        viewHolder.txtEstado.setText(listBitacora.get(position).getEstado());

        return convertView;
    }
}
