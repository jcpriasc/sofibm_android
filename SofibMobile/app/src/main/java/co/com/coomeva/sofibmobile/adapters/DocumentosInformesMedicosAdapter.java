package co.com.coomeva.sofibmobile.adapters;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.support.v4.content.FileProvider;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.util.List;

import co.com.coomeva.sofibmobile.R;
import co.com.coomeva.sofibmobile.dto.DocumentosMedicosDTO;
import co.com.coomeva.sofibmobile.fragments.DocumentosMedicosFragment;
import co.com.coomeva.sofibmobile.fragments.InformesMedicosFragment;
import co.com.coomeva.sofibmobile.utils.Utilities;

/**
 * Created by JuanCamilo on 9/25/16.
 */
public class DocumentosInformesMedicosAdapter extends ArrayAdapter<DocumentosMedicosDTO> {


    private Context context;
    private List<DocumentosMedicosDTO> listDocumentoMedico;
    LayoutInflater inflater;

    public DocumentosInformesMedicosAdapter(Context context, List<DocumentosMedicosDTO> listDocumentoMedico) {
        super(context, R.layout.adapter_documento_medico, listDocumentoMedico);

        this.context = context;
        this.listDocumentoMedico = listDocumentoMedico;

    }

    public class ViewHolder{
        TextView txtNombre;
        TextView txtTipoDocumento;
        ImageView iconOpcion;
    }


    @Override
    public View getView(final int position, View convertView, ViewGroup parent) {

        if (convertView==null){
            inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            convertView = inflater.inflate(R.layout.adapter_documento_medico, null);
        }

        final ViewHolder viewHolder = new ViewHolder();

        viewHolder.txtNombre = (TextView) convertView.findViewById(R.id.textNombre);
        viewHolder.txtTipoDocumento = (TextView) convertView.findViewById(R.id.textTipoDocumento);
        viewHolder.iconOpcion = (ImageView) convertView.findViewById(R.id.icon_opcion);

        viewHolder.txtNombre.setText(listDocumentoMedico.get(position).getNombre());
        viewHolder.txtTipoDocumento.setText(listDocumentoMedico.get(position).getTipoDocumento());

//        InputStream inputStream  = new ByteArrayInputStream(listDocumentoMedico.get(position).getImagen());
//        Bitmap bitmap  = BitmapFactory.decodeStream(inputStream);
//        viewHolder.iconOpcion.setImageBitmap(bitmap);

        viewHolder.iconOpcion.setTag(position);
        viewHolder.iconOpcion.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (viewHolder.iconOpcion!=null){
                    try {

                        String nombreArchivo = InformesMedicosFragment.detalleInformeMedicoSeleccionado.getLstDocumentos().get((int)viewHolder.iconOpcion.getTag()).getNombre().toString();
                        byte[] fileArray = DocumentosMedicosFragment.documentosMedicosList.get((int)viewHolder.iconOpcion.getTag()).getImagen();
                        File rootDirectory = new File(context.getFilesDir(), "docs");

                        if (!rootDirectory.exists()) {
                            rootDirectory.mkdirs();
                        }

                        File someFile = new File(rootDirectory, nombreArchivo);
                        someFile.createNewFile();
                        FileOutputStream fos = new FileOutputStream(someFile);
                        fos.write(fileArray);
                        fos.flush();
                        fos.close();
                        

                        String serviceIntent = Utilities.serviceIntent(someFile);
                        Uri uri = FileProvider.getUriForFile(context, "co.com.coomeva.sofibmobile", someFile);
                        Intent intent = new Intent(Intent.ACTION_VIEW);
                        intent.setDataAndType(uri, serviceIntent);
                        intent.setFlags(Intent.FLAG_GRANT_READ_URI_PERMISSION);

                        context.startActivity(intent);

                    } catch (FileNotFoundException e) {
                        e.printStackTrace();
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                }
            }
        });





        return convertView;
    }

}
