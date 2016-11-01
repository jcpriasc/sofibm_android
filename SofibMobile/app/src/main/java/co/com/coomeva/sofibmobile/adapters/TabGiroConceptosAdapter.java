package co.com.coomeva.sofibmobile.adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import java.util.List;

import co.com.coomeva.sofibmobile.R;
import co.com.coomeva.sofibmobile.dto.ConceptosDTO;
import co.com.coomeva.sofibmobile.dto.ManutencionDTO;

/**
 * Created by JuanCamilo on 9/25/16.
 */
public class TabGiroConceptosAdapter extends ArrayAdapter<ConceptosDTO> {


    private Context context;
    private List<ConceptosDTO> lstConceptos;
    LayoutInflater inflater;

    public TabGiroConceptosAdapter(Context context, List<ConceptosDTO> lstConceptos) {
        super(context, R.layout.adapter_tab_giro_conceptos, lstConceptos);
        this.context = context;
        this.lstConceptos = lstConceptos;

    }

    public class ViewHolder{

        TextView txtConcepto;
        TextView txtDescripcion;
        TextView txtCantidad;
        TextView txtValor;
        TextView txtReliquidacion;
        TextView txtSubTotal;
        TextView txtTrm;
        TextView txtTotal;
    }


    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        if (convertView==null){
            inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            convertView = inflater.inflate(R.layout.adapter_tab_giro_conceptos, null);
        }

        ViewHolder viewHolder = new ViewHolder();

        viewHolder.txtConcepto = (TextView) convertView.findViewById(R.id.txtConcepto);
        viewHolder.txtDescripcion = (TextView) convertView.findViewById(R.id.txtDescripcion);
        viewHolder.txtCantidad = (TextView) convertView.findViewById(R.id.txtCantidad);
        viewHolder.txtValor = (TextView) convertView.findViewById(R.id.txtValor);
        viewHolder.txtReliquidacion = (TextView) convertView.findViewById(R.id.txtReliquidacion);
        viewHolder.txtSubTotal = (TextView) convertView.findViewById(R.id.txtSubTotal);
        viewHolder.txtTrm = (TextView) convertView.findViewById(R.id.txtTrm);
        viewHolder.txtTotal = (TextView) convertView.findViewById(R.id.txtTotal);

        viewHolder.txtConcepto.setText(lstConceptos.get(position).getConcepto());
        viewHolder.txtDescripcion.setText(lstConceptos.get(position).getDescripcion());
        viewHolder.txtCantidad.setText(lstConceptos.get(position).getCantidad());
        viewHolder.txtValor.setText(lstConceptos.get(position).getValorTexto());
        viewHolder.txtReliquidacion.setText(lstConceptos.get(position).getReliquidacion());
        viewHolder.txtSubTotal.setText(lstConceptos.get(position).getSubtotalTexto());
        viewHolder.txtTrm.setText(lstConceptos.get(position).getTrmTexto());
        viewHolder.txtTotal.setText(lstConceptos.get(position).getTotalTexto());


        return convertView;
    }
}
