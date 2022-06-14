package com.myplantdiary.enterprise.dao;

import com.myplantdiary.enterprise.dto.Plant;
import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

import java.util.List;

public interface IPlantRetrofitDAO {
    //I want to put a get request to this endpoint
    @GET("/perl/mobile/viewplantsjsonarray.pl")
    //query parameter: ?Combined_Name= Oak=>@Query("Combined_Name") String combinedName, retrofit will take care of adding the parameter to the endpoin
    Call<List<Plant>> getPlants(@Query("Combined_Name") String combinedName);
    //we need to create a Retrofit client instance: RetrofitClientInstance =>
}
