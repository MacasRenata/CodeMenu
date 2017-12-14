package com.example.macas.codemenu;

import android.util.Log;

import java.io.IOException;
import java.util.List;

import retrofit2.Call;
import retrofit2.Converter;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by macas on 30/11/17.
 */

public class pedidoDAO {

    //METODO PARA CONEXAO COM WEBSERVICE USANDO RETROFIT

    private static final String TAG = pedidoDAO.class.getSimpleName();

    private static final String BASE_URL = "https://notes-5aa5.restdb.io/rest/";
    //"https://notes-5aa5.restdb.io/rest/";
    //"http://localhost:8084/CodeMenuWeb/";
    //"http://localhost:8080/WebService/webresources/item";

    private pedidoService service;

    public pedidoDAO() {
        Converter.Factory jsonFactory = GsonConverterFactory.create();
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(BASE_URL)
                .addConverterFactory(jsonFactory)
                .build();

        this.service = retrofit.create(pedidoService.class);
    }

    //METODO PARA @POST CHAMAR A LISTA DE ITENS DO WEBSERVICE COM A CLASSE CARDAPIOSERVICE

    public List<pedido> listarPedido() {
        Call<List<pedido>> call = this.service.listaPedido();
        List<pedido> ped = null;

        try {
            Response<List<pedido>> res = call.execute();

            if (res.isSuccessful()) {
                ped = res.body();
            } else {
                String errorBody = res.errorBody().string();
                int errorCode = res.code();
                String errorMessage = res.message();

                Log.e(TAG, "Request not successful - "
                        + errorBody + ": "
                        + errorCode
                        + "(" + errorMessage + ")");
            }
        } catch (IOException exc){
            Log.e(TAG, "IO error during REST operation.", exc);
        }
        return ped;
    }

}
