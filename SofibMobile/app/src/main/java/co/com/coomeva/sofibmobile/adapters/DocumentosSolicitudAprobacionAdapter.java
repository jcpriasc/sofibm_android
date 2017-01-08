package co.com.coomeva.sofibmobile.adapters;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.support.v4.content.FileProvider;
import android.util.Base64;
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
import co.com.coomeva.sofibmobile.dto.DocumentosAprobacionDTO;
import co.com.coomeva.sofibmobile.dto.DocumentosMedicosDTO;
import co.com.coomeva.sofibmobile.fragments.DocumentosMedicosFragment;
import co.com.coomeva.sofibmobile.fragments.TabSolicitudAprobacionFragment;
import co.com.coomeva.sofibmobile.utils.Utilities;

/**
 * Created by JuanCamilo on 9/25/16.
 */
public class DocumentosSolicitudAprobacionAdapter extends ArrayAdapter<DocumentosAprobacionDTO> {


    private Context context;
    private List<DocumentosAprobacionDTO> lstDocumentosAprobacion;
    LayoutInflater inflater;

    public DocumentosSolicitudAprobacionAdapter(Context context, List<DocumentosAprobacionDTO> lstDocumentosAprobacion) {
        super(context, R.layout.adapter_tab_solicitud_aprobacion_documentos, lstDocumentosAprobacion);

        this.context = context;
        this.lstDocumentosAprobacion = lstDocumentosAprobacion;

    }

    public class ViewHolder{
        TextView txtNombre;
        ImageView iconOpcion;
    }


    @Override
    public View getView(final int position, View convertView, ViewGroup parent) {

        if (convertView==null){
            inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            convertView = inflater.inflate(R.layout.adapter_tab_solicitud_aprobacion_documentos, null);
        }

        final ViewHolder viewHolder = new ViewHolder();

        viewHolder.txtNombre = (TextView) convertView.findViewById(R.id.textNombre);
        viewHolder.iconOpcion = (ImageView) convertView.findViewById(R.id.icon_opcion);

        viewHolder.txtNombre.setText(lstDocumentosAprobacion.get(position).getNombreDocumento());

//        InputStream inputStream  = new ByteArrayInputStream(listDocumentoMedico.get(position).getImagen());
//        Bitmap bitmap  = BitmapFactory.decodeStream(inputStream);
//        viewHolder.iconOpcion.setImageBitmap(bitmap);

        viewHolder.iconOpcion.setTag(position);
        viewHolder.iconOpcion.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (viewHolder.iconOpcion!=null){
                    try {

                        String nombreArchivo = TabSolicitudAprobacionFragment.detalleSolicitudAprobacionDTO.getLstDocumentoAprobacion().get((int)viewHolder.iconOpcion.getTag()).getNombreDocumento().toString();
                        String archivo = TabSolicitudAprobacionFragment.detalleSolicitudAprobacionDTO.getLstDocumentoAprobacion().get((int)viewHolder.iconOpcion.getTag()).getArchivoString();

                        byte[] archivoArray = Base64.decode(archivo, Base64.DEFAULT);

                        File rootDirectory = new File(context.getFilesDir(), "docs");

                        if (!rootDirectory.exists()) {
                            rootDirectory.mkdirs();
                        }

                        File someFile = new File(rootDirectory, nombreArchivo);
                        someFile.createNewFile();
                        FileOutputStream fos = new FileOutputStream(someFile);
                        fos.write(archivoArray);
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
