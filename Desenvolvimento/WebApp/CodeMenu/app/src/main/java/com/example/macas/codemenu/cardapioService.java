package com.example.macas.codemenu;

import java.util.List;
import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.Headers;
import retrofit2.http.POST;

/**
 * Created by macas on 30/11/17.
 */

public interface cardapioService {

    @GET("cardapio")
    @Headers("x-apikey: a99c54bd6bfa3fb07ef171c1a43f51f29785e")
    Call<List<cardapio>> listCardapio();

    @POST("cardapio")
    @Headers("x-apikey: a99c54bd6bfa3fb07ef171c1a43f51f29785e")
    Call<cardapio> createCardapio(@Body cardapio cardapio);
}
