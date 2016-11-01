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
import co.com.coomeva.sofibmobile.dto.FuncionariosExternosDTO;

/**
 * Created by JuanCamilo on 9/25/16.
 */
public class FuncionariosExternosAdapter extends ArrayAdapter<FuncionariosExternosDTO> {


    private Context context;
    private List<FuncionariosExternosDTO> listFuncionariosExternos;
    LayoutInflater inflater;

    public FuncionariosExternosAdapter(Context context, List<FuncionariosExternosDTO> listFuncionariosExternos) {
        super(context, R.layout.adapter_funcionarios_externos, listFuncionariosExternos);

        this.context = context;
        this.listFuncionariosExternos = listFuncionariosExternos;

    }

    public class ViewHolder{
        TextView textFuncionarioExterno;
        TextView textFechaHoraCita;
        TextView textMedico;
        TextView textEspecialidad;
    }


    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        if (convertView==null){
            inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            convertView = inflater.inflate(R.layout.adapter_funcionarios_externos, null);
        }

        ViewHolder viewHolder = new ViewHolder();

        viewHolder.textFuncionarioExterno = (TextView) convertView.findViewById(R.id.textFuncionarioExterno);
        viewHolder.textFechaHoraCita = (TextView) convertView.findViewById(R.id.textFechaHoraCita);
        viewHolder.textMedico = (TextView) convertView.findViewById(R.id.textMedico);
        viewHolder.textEspecialidad = (TextView) convertView.findViewById(R.id.textEspecialidad);

        viewHolder.textFuncionarioExterno.setText(listFuncionariosExternos.get(position).getFuncionariosExternosAreaMedica());
        viewHolder.textFechaHoraCita.setText(listFuncionariosExternos.get(position).getFechaCitaTexto());
        viewHolder.textMedico.setText(listFuncionariosExternos.get(position).getMedico());
        viewHolder.textEspecialidad.setText(listFuncionariosExternos.get(position).getEspecialidad());

        return convertView;
    }
}
