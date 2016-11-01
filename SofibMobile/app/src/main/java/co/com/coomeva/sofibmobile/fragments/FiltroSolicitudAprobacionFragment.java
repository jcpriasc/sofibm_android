package co.com.coomeva.sofibmobile.fragments;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.Spinner;

import co.com.coomeva.sofibmobile.R;

/**
 * Created by JuanCamilo on 9/25/16.
 */
public class FiltroSolicitudAprobacionFragment extends Fragment{

    ImageView imgConsultarSolicitudes;
    Spinner spinnerConvenio;
    Spinner spinnerEstado;
    Spinner spinnerCiudadInicial;
    Spinner spinnerCiudadActual;
    Spinner spinnerTraslado;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_filtro_solicitud_aprobacion, container, false);

        imgConsultarSolicitudes = (ImageView) view.findViewById(R.id.search_action);
        spinnerConvenio = (Spinner) view.findViewById(R.id.spinner_convenios);
        ArrayAdapter<CharSequence> adapterConvenio  = ArrayAdapter.createFromResource(view.getContext(),R.array.convenio_array, android.R.layout.simple_spinner_item);
        adapterConvenio.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinnerConvenio.setAdapter(adapterConvenio);

        spinnerEstado = (Spinner) view.findViewById(R.id.spinner_estados);
        ArrayAdapter<CharSequence> adapterEstado = ArrayAdapter.createFromResource(view.getContext(),R.array.estado_array, android.R.layout.simple_spinner_item);
        adapterEstado.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinnerEstado.setAdapter(adapterEstado);

        spinnerCiudadInicial = (Spinner) view.findViewById(R.id.spinner_ciudad_inicial);
        ArrayAdapter<CharSequence> adapterCiudadInicial = ArrayAdapter.createFromResource(view.getContext(),R.array.ciudad_inicial_array, android.R.layout.simple_spinner_item);
        adapterCiudadInicial.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinnerCiudadInicial.setAdapter(adapterCiudadInicial);


        spinnerCiudadActual = (Spinner) view.findViewById(R.id.spinner_ciudad_actual);
        ArrayAdapter<CharSequence> adapterCiudadActual = ArrayAdapter.createFromResource(view.getContext(),R.array.ciudad_actual_array, android.R.layout.simple_spinner_item);
        adapterCiudadActual.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinnerCiudadActual.setAdapter(adapterCiudadActual);

        spinnerTraslado = (Spinner) view.findViewById(R.id.spinner_traslado);
        ArrayAdapter<CharSequence> adapterTraslado = ArrayAdapter.createFromResource(view.getContext(),R.array.traslado_array, android.R.layout.simple_spinner_item);
        adapterTraslado.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinnerTraslado.setAdapter(adapterTraslado);

        imgConsultarSolicitudes.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                FragmentTransaction ft = getActivity().getSupportFragmentManager().beginTransaction();
                Fragment fragment = new ConsultaSolicitudAprobacionFragment();
                fragment.setArguments(getActivity().getIntent().getExtras());
                ft.replace(R.id.fragment_container_consulta_solicitud_aprobacion, fragment, "ConsultaSolicitudAprobacionFragment").addToBackStack("ConsultaSolicitudAprobacionFragment").commit();

            }
        });

        return view;
    }
}
