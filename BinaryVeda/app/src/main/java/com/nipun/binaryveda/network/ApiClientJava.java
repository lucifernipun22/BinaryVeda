package com.nipun.binaryveda.network;

import com.nipun.binaryveda.data.ModelItem;

import java.util.List;
import retrofit2.Call;
import retrofit2.http.GET;

/**
 * ApiClient is used to assign the method and which is used fetch from the server like @GET or @POST.
 */
public interface ApiClientJava {

    @GET("/binaryVedanipun")
    Call<List<ModelItem>> getData();
}