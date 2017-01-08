package co.com.coomeva.sofibmobile.adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import java.util.List;

import co.com.coomeva.sofibmobile.R;
import co.com.coomeva.sofibmobile.dto.ImpuestoFacturaDTO;
import co.com.coomeva.sofibmobile.dto.ProcedimientoDTO;

/**
 * Created by JuanCamilo on 9/25/16.
 */
public class TabSolicitudAprobacionProcedimientosAdapter extends ArrayAdapter<ProcedimientoDTO> {


    private Context context;
    private List<ProcedimientoDTO> lstProcedimientos;
    LayoutInflater inflater;

    public TabSolicitudAprobacionProcedimientosAdapter(Context context, List<ProcedimientoDTO> lstProcedimientos) {
        super(context, R.layout.adapter_tab_solicitud_aprobacion_procedimiento, lstProcedimientos);
        this.context = context;
        this.lstProcedimientos = lstProcedimientos;

    }

    public class ViewHolder{

        TextView txtNombre;
        TextView txtPrestador;

    }


    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        if (convertView==null){
            inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            convertView = inflater.inflate(R.layout.adapter_tab_solicitud_aprobacion_procedimiento, null);
        }

        ViewHolder viewHolder = new ViewHolder();

        viewHolder.txtNombre = (TextView) convertView.findViewById(R.id.txtNombre);
        viewHolder.txtPrestador = (TextView) convertView.findViewById(R.id.txtPrestador);

        viewHolder.txtNombre.setText(lstProcedimientos.get(position).getNombreProcedimiento());
        viewHolder.txtPrestador.setText(lstProcedimientos.get(position).getPrestadorProcedimiento());

        return convertView;
    }
}
