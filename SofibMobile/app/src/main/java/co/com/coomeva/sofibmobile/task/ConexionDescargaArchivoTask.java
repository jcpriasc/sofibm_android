package co.com.coomeva.sofibmobile.task;

import android.app.ProgressDialog;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.AsyncTask;
import android.os.Environment;
import android.support.v4.content.FileProvider;
import android.widget.Toast;

import org.json.JSONArray;

import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLConnection;

import co.com.coomeva.sofibmobile.R;
import co.com.coomeva.sofibmobile.utils.Utilities;
import cz.msebera.android.httpclient.HttpResponse;
import cz.msebera.android.httpclient.client.HttpClient;
import cz.msebera.android.httpclient.client.methods.HttpGet;
import cz.msebera.android.httpclient.impl.client.DefaultHttpClient;
import cz.msebera.android.httpclient.util.ByteArrayBuffer;
import cz.msebera.android.httpclient.util.EntityUtils;

/**
 * Created by cesarlopez on 12/10/16.
 */
public class ConexionDescargaArchivoTask extends AsyncTask<String,Integer,JSONArray>{

    //Objeto del contexto en que se va a mostrar los componentes
    private Context context;
    //Objeto para manejar dialogos
    private ProgressDialog dialog;
    private String service_name;
//    private List<NameValuePair> listParams;
    private String listParams;

    public static JSONArray respJSON = null;

    public ConexionDescargaArchivoTask(Context context, String service_name, String listParams){
        this.context = context;
        this.service_name = service_name;
        this.listParams = listParams;
    }

    @Override
    protected void onPreExecute() {

        //Se inicializa el dialogo y se colocan sus propiedades
        dialog = new ProgressDialog(context);
        dialog.setMessage(context.getResources().getString(R.string.lbl_cargando));
        dialog.setIndeterminate(true);
        dialog.show();
        super.onPreExecute();
    }

    protected synchronized JSONArray doInBackground(String... params) {

        try
        {

            File rootDirectory = new File(context.getFilesDir(), "docs");

            if (!rootDirectory.exists()) {
                rootDirectory.mkdirs();
            }

            //indico URL al archivo
            String DownloadUrl=service_name;
            //nombre que tendrá el archivo
            String fileName="reporteGiro.pdf";


            URL url = new URL(DownloadUrl);
            File file = new File(rootDirectory, fileName);

            URLConnection ucon = url.openConnection();

            InputStream is = ucon.getInputStream();
            BufferedInputStream bis = new BufferedInputStream(is);

            ByteArrayBuffer baf = new ByteArrayBuffer(5000);
            int current = 0;
            while ((current = bis.read()) != -1) {
                baf.append((byte) current);
            }


            FileOutputStream fos = new FileOutputStream(file);
            fos.write(baf.toByteArray());
            fos.flush();
            fos.close();

            String serviceIntent = Utilities.serviceIntent(file);
            Uri uri = FileProvider.getUriForFile(context, "co.com.coomeva.sofibmobile", file);
            Intent intent = new Intent(Intent.ACTION_VIEW);
            intent.setDataAndType(uri, serviceIntent);
            intent.setFlags(Intent.FLAG_GRANT_READ_URI_PERMISSION);

            context.startActivity(intent);

        }
        catch(Exception ex){
            Toast.makeText(context,ex.getMessage(), Toast.LENGTH_LONG).show();
        }finally {
            notifyAll();
        }

        return respJSON;
    }




    @Override
    protected void onPostExecute(JSONArray result) {
        dialog.dismiss();
    }


}