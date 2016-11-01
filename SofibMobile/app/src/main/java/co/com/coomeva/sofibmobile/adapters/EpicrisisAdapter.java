package co.com.coomeva.sofibmobile.adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import java.util.List;

import co.com.coomeva.sofibmobile.R;
import co.com.coomeva.sofibmobile.dto.DocumentosMedicosDTO;

/**
 * Created by JuanCamilo on 9/25/16.
 */
public class EpicrisisAdapter extends ArrayAdapter<DocumentosMedicosDTO> {


    private Context context;
    private List<DocumentosMedicosDTO> listDocumentoMedico;
    LayoutInflater inflater;

    public EpicrisisAdapter(Context context, List<DocumentosMedicosDTO> listDocumentoMedico) {
        super(context, R.layout.adapter_epicrisis, listDocumentoMedico);

        this.context = context;
        this.listDocumentoMedico = listDocumentoMedico;

    }

    public class ViewHolder{
        TextView txtNombre;
    }


    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        if (convertView==null){
            inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            convertView = inflater.inflate(R.layout.adapter_epicrisis, null);
        }

        ViewHolder viewHolder = new ViewHolder();

        viewHolder.txtNombre = (TextView) convertView.findViewById(R.id.textNombre);
        viewHolder.txtNombre.setText(listDocumentoMedico.get(position).getNombre());

        return convertView;
    }
}
