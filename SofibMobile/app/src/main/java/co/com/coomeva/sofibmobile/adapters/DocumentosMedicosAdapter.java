package co.com.coomeva.sofibmobile.adapters;

import android.content.Context;
import android.content.Intent;
import android.content.res.AssetManager;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.net.Uri;
import android.os.Environment;
import android.support.v4.content.FileProvider;
import android.util.Base64;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import org.json.JSONArray;
import org.json.JSONObject;

import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

import co.com.coomeva.sofibmobile.ConsultaSolicitudAtencionView;
import co.com.coomeva.sofibmobile.R;
import co.com.coomeva.sofibmobile.dto.AutorizacionesDTO;
import co.com.coomeva.sofibmobile.dto.DocumentosMedicosDTO;
import co.com.coomeva.sofibmobile.fragments.DocumentosMedicosFragment;
import co.com.coomeva.sofibmobile.fragments.OpcionesSecundariasFragment;
import co.com.coomeva.sofibmobile.task.ConexionServicioListaTask;
import co.com.coomeva.sofibmobile.task.ConexionServicioTask;
import co.com.coomeva.sofibmobile.utils.Utilities;

/**
 * Created by JuanCamilo on 9/25/16.
 */
public class DocumentosMedicosAdapter extends ArrayAdapter<DocumentosMedicosDTO> {


    private Context context;
    private List<DocumentosMedicosDTO> listDocumentoMedico;
    LayoutInflater inflater;

    public DocumentosMedicosAdapter(Context context, List<DocumentosMedicosDTO> listDocumentoMedico) {
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

                    String tipoArchivo = "";
                    String nombreDocumento = "";
                    String archivo = "";
                    byte[] fileArray = new byte[0];

                    try {

                        String params = "SAC/ABCD1234/"+ OpcionesSecundariasFragment.documentosMedicosList.get((int)viewHolder.iconOpcion.getTag()).getId().toString();


                        ConexionServicioListaTask task = new ConexionServicioListaTask(context, getContext().getResources().getString(R.string.complement_documento_documento_medico), params);

                        synchronized (task) {
                            task.execute().wait();
                        }

                        if (ConexionServicioListaTask.respJSON !=null){
                            JSONObject obj = ConexionServicioListaTask.respJSON;

                            tipoArchivo = obj.getString("tipoArchivo");
                            nombreDocumento = obj.getString("nombreDocumento");
                            archivo = obj.getString("archivo");

                            fileArray = Base64.decode(archivo, Base64.DEFAULT);

                        }


                        File rootDirectory = new File(context.getFilesDir(), "docs");

                        if (!rootDirectory.exists()) {
                            rootDirectory.mkdirs();
                        }

                        File someFile = new File(rootDirectory, nombreDocumento);
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
