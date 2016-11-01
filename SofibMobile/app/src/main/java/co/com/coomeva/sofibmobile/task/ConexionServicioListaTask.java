package co.com.coomeva.sofibmobile.task;

import android.app.ProgressDialog;
import android.content.Context;
import android.os.AsyncTask;
import android.widget.Toast;

import org.json.JSONArray;
import org.json.JSONObject;

import co.com.coomeva.sofibmobile.R;
import cz.msebera.android.httpclient.HttpResponse;
import cz.msebera.android.httpclient.client.HttpClient;
import cz.msebera.android.httpclient.client.methods.HttpGet;
import cz.msebera.android.httpclient.impl.client.DefaultHttpClient;
import cz.msebera.android.httpclient.util.EntityUtils;

/**
 * Created by cesarlopez on 12/10/16.
 */
public class ConexionServicioListaTask extends AsyncTask<String,Integer,JSONObject>{

    //Objeto del contexto en que se va a mostrar los componentes
    private Context context;
    //Objeto para manejar dialogos
    private ProgressDialog dialog;
    private String service_name;
//    private List<NameValuePair> listParams;
    private String listParams;

    public static JSONObject respJSON = null;

    public ConexionServicioListaTask(Context context, String service_name, String listParams){
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

    protected synchronized JSONObject doInBackground(String... params) {

        try
        {

            HttpClient httpClient = new DefaultHttpClient();
//            HttpPost post = new HttpPost(context.getResources().getString(R.string.address_service_aut)+service_name);
//            post.setEntity(new UrlEncodedFormEntity(listParams));
//            post.setHeader("content-type", "application/json");

            HttpGet del = new HttpGet(context.getResources().getString(R.string.address_service_aut)+service_name+listParams);
            del.setHeader("content-type", "application/json");

            HttpResponse resp = httpClient.execute(del);
            String respStr = EntityUtils.toString(resp.getEntity());
            respJSON = new JSONObject(respStr);

        }
        catch(Exception ex){
            Toast.makeText(context,ex.getMessage(), Toast.LENGTH_LONG).show();
        }finally {
            notifyAll();
        }

        return respJSON;
    }




    @Override
    protected void onPostExecute(JSONObject result) {
        dialog.dismiss();
    }


}