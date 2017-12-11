package com.example.macas.codemenu;

import java.util.List;
import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.Headers;
import retrofit2.http.POST;
import retrofit2.http.Path;

/**
 * Created by macas on 30/11/17.
 */

public interface cardapioService {

    @GET(" /listaItem ")
    Call<cardapio> getListaItem( @Path("ctrlCar") String ctrl);


    @FormUrlEncoded
    @POST(" /listaItem.java")
    Call<List<cardapio>> getListaCardapio( @Field("method") String method);



}
