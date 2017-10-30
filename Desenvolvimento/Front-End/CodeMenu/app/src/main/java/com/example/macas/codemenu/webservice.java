package com.example.macas.codemenu;

import org.xmlpull.v1.XmlPullParserException;
import java.io.BufferedInputStream;
import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

import android.os.AsyncTask;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.app.ActionBarActivity;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
/*
import org.springframework.http.converter.json.MappingJackson2HttpMessageConverter;
import org.springframework.web.client.RestTemplate;

*/
/**
 * Created by macas on 02/10/17.
 */

public class webservice {

    public class MainActivity extends menu_principal {

        @Override
        protected void onCreate(Bundle savedInstanceState) {
            super.onCreate(savedInstanceState);
            setContentView(R.layout.menu_principal);

        }

    }


}
/*
            if (savedInstanceState == null) {
                getSupportFragmentManager().beginTransaction()
                        .add(R.id.container, new PlaceholderFragment())
                        .commit();
            }
        }

        @Override
        protected void onStart() {
            super.onStart();
            new HttpRequestTask().execute();
        }

        @Override
        public boolean onCreateOptionsMenu(Menu menu) {

            // Inflate the menu; this adds items to the action bar if it is present.
            getMenuInflater().inflate(R.menu.main, menu);
            return true;
        }

        @Override
        public boolean onOptionsItemSelected(MenuItem item) {
            // Handle action bar item clicks here. The action bar will
            // automatically handle clicks on the Home/Up button, so long
            // as you specify a parent activity in AndroidManifest.xml.
            int id = item.getItemId();
            if (id == R.id.action_refresh) {
                new HttpRequestTask().execute();
                return true;
            }
            return super.onOptionsItemSelected(item);
        }

        /**
         * A placeholder fragment containing a simple view.
         */

  /*
        public static class PlaceholderFragment extends Fragment {

            public PlaceholderFragment() {
            }

            @Override
            public View onCreateView(LayoutInflater inflater, ViewGroup container,
                                     Bundle savedInstanceState) {
                View rootView = inflater.inflate(R.layout.fragment_main, container, false);
                return rootView;
            }
        }


        private class HttpRequestTask extends AsyncTask<Void, Void, Greeting> {
            @Override
            protected Greeting doInBackground(Void... params) {
                try {
                    final String url = "http://8080/cardapioRef";
                    RestTemplate restTemplate = new RestTemplate();
                    restTemplate.getMessageConverters().add(new MappingJackson2HttpMessageConverter());
                    Greeting greeting = restTemplate.getForObject(url, Greeting.class);
                    return greeting;
                } catch (Exception e) {
                    Log.e("MainActivity", e.getMessage(), e);
                }

                return null;
            }

            @Override
            protected void onPostExecute(Greeting greeting) {
                TextView greetingIdText = (TextView) findViewById(R.id.id_value);
                TextView greetingContentText = (TextView) findViewById(R.id.content_value);
                greetingIdText.setText(greeting.getId());
                greetingContentText.setText(greeting.getContent());
            }

        }

    } */

  /* segunda opção com buffer - testar"

    public int add (int i, int j) throws IOExeption, XmlPullParserException
    {
        HttpTransportSE HttpTrans = new HttpTransportSE(“http://http://8080/selecioonarRef/”);
        HttpTrans.call(“add”, envelope);
        Object resultado = envelope.getResponse ();
        return Integer.parseInt(resultado.toString());

    }

*/

//conexão com mySql NetBeans - ajustar

       /*

    public class WebService {

        private static String readStream(InputStream in){
            BufferedReader r = new BufferedReader(new InputStreamReader(in));
            StringBuilder total = new StringBuilder();
            String line;

            try {
                while ((line = r.readLine()) != null) {
                    total.append(line).append('\n');
                }
            }catch(Exception ex) {
                ex.printStackTrace();
            }
            return total.toString();
        }

        private static String request(String stringUrl){
            URL url = null;
            HttpURLConnection urlConnection = null;
            try {
                url = new URL(stringUrl);
                urlConnection = (HttpURLConnection) url.openConnection();
                InputStream in = new BufferedInputStream(urlConnection.getInputStream());
                return readStream(in);
            }
            catch (Exception e) {
                e.printStackTrace();
            }
            finally {
                urlConnection.disconnect();
            }
            return "";
        }

        public static Localizacao retornarLocalizacaoPorIp(String ip) throws JSONException {
            String responseBody = request("http://freegeoip.net/json/" + ip);
            JSONObject obj = new JSONObject(responseBody);
            String pais = obj.get("country_name").toString();
            String estado = obj.get("region_name").toString();
            String cidade = obj.get("city").toString();
            return new Localizacao(pais, estado, cidade);
        }
    }
*/




