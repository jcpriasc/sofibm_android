package co.com.coomeva.sofibmobile;

import android.app.SearchManager;
import android.content.Context;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ExpandableListView;
import android.widget.SearchView;

import java.util.ArrayList;

import co.com.coomeva.sofibmobile.adapters.ListExpAdapter;
import co.com.coomeva.sofibmobile.dto.ListExpDTO;
import co.com.coomeva.sofibmobile.dto.ListExpDetalleDTO;

public class ListExpView extends AppCompatActivity implements SearchView.OnQueryTextListener, SearchView.OnCloseListener{

    private SearchManager searchManager;
    private SearchView searchView;
    private ListExpAdapter listExpAdapterListView;
    private ExpandableListView bitacoraList;
    private ArrayList<ListExpDTO> listExpDTOList = new ArrayList<>();
    private ArrayList<ListExpDTO> showTheseListExpDTOList = new ArrayList<>();
    private MenuItem menuItem;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });


        searchManager = (SearchManager) getSystemService(Context.SEARCH_SERVICE);
        listExpDTOList = new ArrayList<>();
        showTheseListExpDTOList = new ArrayList<>();

        displayList();

        expandAll();

        //Se llama al fragment principal de solicitud no asistencial
//        getSupportFragmentManager().beginTransaction().add(R.id.fragment_container_bitacora, new ListExpFragment(), "ListExpFragment").commit();

    }

    private void cargarInformacion(){
        ArrayList<ListExpDetalleDTO> listExpDetalleDTOList = new ArrayList<>();
        ListExpDTO listExpDTO =null;

        listExpDetalleDTOList.add(new ListExpDetalleDTO(R.drawable.icon_search, "Es un hecho establecido hace demasiado tiempo que un lector se distraerá con el contenido del texto de un sitio mientras que mira su diseño. El punto de usar Lorem Ipsum es que tiene una distribución más o menos normal de las letras, al contrario de usar textos como por ejemplo \"Contenido aquí, contenido aquí\". Estos textos hacen parecerlo un español que se puede leer. Muchos paquetes de autoedición y editores de páginas web usan el Lorem Ipsum como su texto por defecto, y al hacer una búsqueda de \"Lorem Ipsum\" va a dar por resultado muchos sitios web que usan este texto si se encuentran en estado de desarrollo. Muchas versiones han evolucionado a través de los años, algunas veces por accidente, otras veces a propósito (por ejemplo insertándole humor y cosas por el estilo)."));
        listExpDetalleDTOList.add(new ListExpDetalleDTO(R.drawable.icon_search, "Es un hecho establecido hace demasiado tiempo que un lector se distraerá con el contenido del texto de un sitio mientras que mira su diseño. El punto de usar Lorem Ipsum es que tiene una distribución más o menos normal de las letras, al contrario de usar textos como por ejemplo \"Contenido aquí, contenido aquí\". Estos textos hacen parecerlo un español que se puede leer. Muchos paquetes de autoedición y editores de páginas web usan el Lorem Ipsum como su texto por defecto, y al hacer una búsqueda de \"Lorem Ipsum\" va a dar por resultado muchos sitios web que usan este texto si se encuentran en estado de desarrollo. Muchas versiones han evolucionado a través de los años, algunas veces por accidente, otras veces a propósito (por ejemplo insertándole humor y cosas por el estilo)."));
        listExpDTO = new ListExpDTO(listExpDetalleDTOList, "Opcion 1");
        listExpDTOList.add(listExpDTO);

        listExpDetalleDTOList = new ArrayList<>();
        listExpDetalleDTOList.add(new ListExpDetalleDTO(R.drawable.icon_search, "Es un hecho establecido hace demasiado tiempo que un lector se distraerá con el contenido del texto de un sitio mientras que mira su diseño. El punto de usar Lorem Ipsum es que tiene una distribución más o menos normal de las letras, al contrario de usar textos como por ejemplo \"Contenido aquí, contenido aquí\". Estos textos hacen parecerlo un español que se puede leer. Muchos paquetes de autoedición y editores de páginas web usan el Lorem Ipsum como su texto por defecto, y al hacer una búsqueda de \"Lorem Ipsum\" va a dar por resultado muchos sitios web que usan este texto si se encuentran en estado de desarrollo. Muchas versiones han evolucionado a través de los años, algunas veces por accidente, otras veces a propósito (por ejemplo insertándole humor y cosas por el estilo)."));
        listExpDetalleDTOList.add(new ListExpDetalleDTO(R.drawable.icon_search, "Es un hecho establecido hace demasiado tiempo que un lector se distraerá con el contenido del texto de un sitio mientras que mira su diseño. El punto de usar Lorem Ipsum es que tiene una distribución más o menos normal de las letras, al contrario de usar textos como por ejemplo \"Contenido aquí, contenido aquí\". Estos textos hacen parecerlo un español que se puede leer. Muchos paquetes de autoedición y editores de páginas web usan el Lorem Ipsum como su texto por defecto, y al hacer una búsqueda de \"Lorem Ipsum\" va a dar por resultado muchos sitios web que usan este texto si se encuentran en estado de desarrollo. Muchas versiones han evolucionado a través de los años, algunas veces por accidente, otras veces a propósito (por ejemplo insertándole humor y cosas por el estilo)."));
        listExpDTO = new ListExpDTO(listExpDetalleDTOList, "Opcion 2");
        listExpDTOList.add(listExpDTO);

    }

    public void expandAll(){
        int count = listExpAdapterListView.getGroupCount();
        for (int i = 0; i<count; i++){
            bitacoraList.expandGroup(i);
        }
    }

    public void displayList(){
        cargarInformacion();
        bitacoraList= (ExpandableListView) findViewById(R.id.expandableListView);
        listExpAdapterListView = new ListExpAdapter(ListExpView.this, listExpDTOList);
        bitacoraList.setAdapter(listExpAdapterListView);
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {

//        getMenuInflater().inflate(R.menu.menu, menu);
//        menuItem = menu.findItem(R.id.action_search);
//        searchView = (SearchView) MenuItemCompat.getActionView(menuItem);
//        searchView.setSearchableInfo(searchManager.getSearchableInfo(getComponentName()));
//        searchView.setIconifiedByDefault(false);
//        searchView.setOnQueryTextListener(this);
//        searchView.setOnCloseListener(this);
//        searchView.requestFocus();
        return true;
    }

    @Override
    public boolean onClose() {
        listExpAdapterListView.filterData("");
        expandAll();
        return false;
    }

    @Override
    public boolean onQueryTextSubmit(String s) {
        listExpAdapterListView.filterData(s);
        expandAll();
        return false;
    }

    @Override
    public boolean onQueryTextChange(String s) {
        listExpAdapterListView.filterData(s);
        expandAll();
        return false;
    }
}
