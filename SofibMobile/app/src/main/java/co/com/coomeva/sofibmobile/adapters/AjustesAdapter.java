package co.com.coomeva.sofibmobile.adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.List;

import co.com.coomeva.sofibmobile.R;
import co.com.coomeva.sofibmobile.dto.AjusteDTO;
import co.com.coomeva.sofibmobile.dto.DocumentosMedicosDTO;
import co.com.coomeva.sofibmobile.fragments.DocumentosMedicosFragment;

/**
 * Created by JuanCamilo on 9/25/16.
 */
public class AjustesAdapter extends ArrayAdapter<AjusteDTO> {


    private Context context;
    private List<AjusteDTO> listAjustes;
    LayoutInflater inflater;

    public AjustesAdapter(Context context, List<AjusteDTO> listAjustes) {
        super(context, R.layout.adapter_ajustes, listAjustes);

        this.context = context;
        this.listAjustes = listAjustes;

    }

    public class ViewHolder{
        TextView textAjuste;
        ImageView imgAjuste;
    }


    @Override
    public View getView(final int position, View convertView, ViewGroup parent) {

        if (convertView==null){
            inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            convertView = inflater.inflate(R.layout.adapter_ajustes, null);
        }

        final ViewHolder viewHolder = new ViewHolder();

        viewHolder.textAjuste = (TextView) convertView.findViewById(R.id.textAjuste);
        viewHolder.imgAjuste = (ImageView) convertView.findViewById(R.id.imgAjuste);

        viewHolder.textAjuste.setText(listAjustes.get(position).getNombre());
        viewHolder.imgAjuste.setImageResource(listAjustes.get(position).getImagen());

        return convertView;
    }

}
