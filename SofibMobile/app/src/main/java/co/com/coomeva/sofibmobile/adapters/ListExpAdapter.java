package co.com.coomeva.sofibmobile.adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseExpandableListAdapter;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

import co.com.coomeva.sofibmobile.R;
import co.com.coomeva.sofibmobile.dto.ListExpDTO;
import co.com.coomeva.sofibmobile.dto.ListExpDetalleDTO;

/**
 * Created by JuanCamilo on 9/30/16.
 */
public class ListExpAdapter extends BaseExpandableListAdapter {

    private Context context;
    private ArrayList<ListExpDTO> bitacoraList;
    private ArrayList<ListExpDTO> bitacoraOriginalList;

    public ListExpAdapter(Context context, ArrayList<ListExpDTO> bitacoraList) {
        this.context = context;
        this.bitacoraList = bitacoraList;
    }

    @Override
    public int getGroupCount() {
        return bitacoraList.size();
    }

    @Override
    public int getChildrenCount(int i) {
        return bitacoraList.get(i).getBitacoraDetalleList().size();
    }

    @Override
    public Object getGroup(int i) {
        return bitacoraList.get(i);
    }

    @Override
    public Object getChild(int i, int i1) {
        return bitacoraList.get(i).getBitacoraDetalleList().get(i1);
    }

    @Override
    public long getGroupId(int i) {
        return i;
    }

    @Override
    public long getChildId(int i, int i1) {
        return i1;
    }

    @Override
    public boolean hasStableIds() {
        return true;
    }

    @Override
    public View getGroupView(int i, boolean b, View view, ViewGroup viewGroup) {

        ListExpDTO listExpDTO = (ListExpDTO) getGroup(i);
        if (view==null){
            LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            view = inflater.inflate(R.layout.adapter_padre_bitacora, null);
        }

        TextView descripcion = (TextView) view.findViewById(R.id.textDescripcion);
        descripcion.setText(listExpDTO.getName());

        return view;
    }

    @Override
    public View getChildView(int i, int i1, boolean b, View view, ViewGroup viewGroup) {
        ListExpDetalleDTO listExpDetalleDTO = (ListExpDetalleDTO) getChild(i, i1);
        if (view==null){
            LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            view = inflater.inflate(R.layout.adapter_hijo_bitacora, null);
        }

        final TextView textDetalle = (TextView) view.findViewById(R.id.textSupOpcion);
        textDetalle.setText(listExpDetalleDTO.getText());

        final View finalView = view;
        textDetalle.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(finalView.getContext(), textDetalle.getText(), Toast.LENGTH_LONG).show();
            }
        });

        return view;
    }

    @Override
    public boolean isChildSelectable(int i, int i1) {
        return true;
    }

    public void filterData(String query){
        query = query.toLowerCase();
        bitacoraList.clear();

        if (query.isEmpty()){
            bitacoraList.addAll(bitacoraOriginalList);
        }else {
            for (ListExpDTO listExpDTO : bitacoraList) {
                ArrayList<ListExpDetalleDTO> bitacoraDetalleList = listExpDTO.getBitacoraDetalleList();
                ArrayList<ListExpDetalleDTO> newBitacoraDetalleList = new ArrayList<>();

                for (ListExpDetalleDTO listExpDetalleDTO :bitacoraDetalleList) {
                    if (listExpDetalleDTO.getText().toLowerCase().contains(query)){
                        newBitacoraDetalleList.add(listExpDetalleDTO);
                    }
                }

                if (newBitacoraDetalleList.size()>0){
                    ListExpDTO nListExpDTO = new ListExpDTO(newBitacoraDetalleList, listExpDTO.getName());
                    bitacoraList.add(nListExpDTO);
                }

            }
        }

        notifyDataSetChanged();
    }
}
