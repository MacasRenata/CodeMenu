package com.example.macas.codemenu;

import android.provider.ContactsContract;
import android.util.Log;

import java.io.IOException;
import java.util.List;

import retrofit2.Call;
import retrofit2.Converter;
import retrofit2.Converter.Factory;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by macas on 30/11/17.
 */

public class cardapioDAO {

    //METODO PARA CONEXAO COM WEBSERVICE USANDO RETROFIT

    private static final String TAG = cardapioDAO.class.getSimpleName();

    private static final String BASE_URL = "https://notes-5aa5.restdb.io/rest/";
            //"http://localhost:8080/WebService/webresources";
            //"https://notes-5aa5.restdb.io/rest/";
            //"http://localhost:8084/CodeMenuWeb/";
            //"http://localhost:8080/WebService/webresources/item";

    private cardapioService service;

    public cardapioDAO() {
        Factory jsonFactory = GsonConverterFactory.create();
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(BASE_URL)
                .addConverterFactory(jsonFactory)
                .build();

        this.service = retrofit.create(cardapioService.class);
    }

    //METODO PARA @POST CHAMAR A LISTA DE ITENS DO WEBSERVICE COM A CLASSE CARDAPIOSERVICE

    public List<cardapio> listarCardapio() {
        Call<List<cardapio>> call = this.service.listaCardapio();
        List<cardapio> cardapios = null;

        try {
            Response<List<cardapio>> res = call.execute();

            if (res.isSuccessful()) {
                cardapios = res.body();
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
        return cardapios;
    }


    //METODO PARA @GET PARA ENVIAR LISTA DE PEDIDOS NA LISTA DE ITENS COM A CLASSE CARDAPIOSERVICE
/*
    public cardapio enviarPedido(cardapio enviarPed) {
        Call<cardapio> call = this.service.listaPedido(cardapio);
        cardapio newCardapio = null;

        try {
            Response<cardapio> res = call.execute();

            if (res.isSuccessful()) {
                newCardapio = res.body();
            } else {
                String errorBody = res.errorBody().string();
                int errorCode = res.code();
                String errorMessage = res.message();

                Log.e(TAG, "Request not successful - "
                        + errorBody + ": "
                        + errorCode
                        + " (" + errorMessage + ")");
            }
        } catch (IOException exc) {
            Log.e(TAG, "IO error during REST operation.", exc);
        }
        return newCardapio;
    }*/
}
