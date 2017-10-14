package com.example.macas.codemenu;

import org.xmlpull.v1.XmlPullParserException;

/**
 * Created by macas on 02/10/17.
 */

public class webservice {

  /*  public  webservice(){


    }
    public int add (int i, int j) throws IOExeption, XmlPullParserException
    {
        SoapObject  soap = new SoapObject (http://calculator.me.org/, “add”);
        SoapSerializationEnvelope envelope = new  SoapSerializationEnvelope(SoapEnvelope.VER11);
        HttpTransportSE HttpTrans = new HttpTransportSE(“http://192.xxxxxendereço do webservice bla bla”);
        HttpTrans.call(“add”, envelope);
        Object resultado = envelope.getResponse ();
        return Integer.parseInt(resultado.toString());

    }


    public static CardapioRef retornarDados(String ip) throws JSONException {
        String responseBody = request("http://freegeoip.net/json/" + ip);
        JSONObject obj = new JSONObject(responseBody);
        String pais = obj.get("country_name").toString();
        String estado = obj.get("region_name").toString();
        String cidade = obj.get("city").toString();
        return new Localizacao(pais, estado, cidade);
    }
*/

//conexão com mySql NetBeans - ajustar

       /* import java.io.BufferedInputStream;
import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

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



}
