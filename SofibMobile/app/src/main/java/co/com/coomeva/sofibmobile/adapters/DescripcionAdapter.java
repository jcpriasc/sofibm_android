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
import co.com.coomeva.sofibmobile.dto.DescipcionDTO;

/**
 * Created by JuanCamilo on 9/25/16.
 */
public class DescripcionAdapter extends ArrayAdapter<DescipcionDTO> {


    private Context context;
    private List<DescipcionDTO> listDescipcion;
    LayoutInflater inflater;

    public DescripcionAdapter(Context context, List<DescipcionDTO> listDescipcion) {
        super(context, R.layout.adapter_descripcion, listDescipcion);

        this.context = context;
        this.listDescipcion = listDescipcion;

    }

    public class ViewHolder{
        TextView txtDescripcion;
    }


    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        if (convertView==null){
            inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            convertView = inflater.inflate(R.layout.adapter_descripcion, null);
        }

        ViewHolder viewHolder = new ViewHolder();

        viewHolder.txtDescripcion = (TextView) convertView.findViewById(R.id.textDescripcion);
        viewHolder.txtDescripcion.setText(listDescipcion.get(position).getDescripcion());

        return convertView;
    }
}
