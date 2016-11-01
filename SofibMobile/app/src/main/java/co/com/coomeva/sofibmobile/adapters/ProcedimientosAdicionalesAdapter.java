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
import co.com.coomeva.sofibmobile.dto.ProcedimientosAdicionalesDTO;

/**
 * Created by JuanCamilo on 9/25/16.
 */
public class ProcedimientosAdicionalesAdapter extends ArrayAdapter<ProcedimientosAdicionalesDTO> {


    private Context context;
    private List<ProcedimientosAdicionalesDTO> listProcedimientosAdicionales;
    LayoutInflater inflater;

    public ProcedimientosAdicionalesAdapter(Context context, List<ProcedimientosAdicionalesDTO> listProcedimientosAdicionales) {
        super(context, R.layout.adapter_procedimiento_adicional, listProcedimientosAdicionales);

        this.context = context;
        this.listProcedimientosAdicionales = listProcedimientosAdicionales;

    }

    public class ViewHolder{
        TextView txtProcedimiento;
        TextView txtCiudad;
        TextView txtPrestadorProveedor;
    }


    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        if (convertView==null){
            inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            convertView = inflater.inflate(R.layout.adapter_procedimiento_adicional, null);
        }

        ViewHolder viewHolder = new ViewHolder();

        viewHolder.txtProcedimiento = (TextView) convertView.findViewById(R.id.textProcedimiento);
        viewHolder.txtCiudad = (TextView) convertView.findViewById(R.id.textCiudad);
        viewHolder.txtPrestadorProveedor = (TextView) convertView.findViewById(R.id.textPrestadorProveedor);


        viewHolder.txtProcedimiento.setText(listProcedimientosAdicionales.get(position).getNombreProcedimiento());
        viewHolder.txtCiudad.setText(listProcedimientosAdicionales.get(position).getCiudad());
        viewHolder.txtPrestadorProveedor.setText(listProcedimientosAdicionales.get(position).getPrestadorProveedor());

        return convertView;
    }
}
