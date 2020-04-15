package com.example.jobfinder;
import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;

public interface MyRetrofit {
    @GET("python")
    Call<List<DataSet>> getDataSet();

}
