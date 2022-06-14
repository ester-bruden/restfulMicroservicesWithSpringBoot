package com.myplantdiary.enterprise.dao;

import com.myplantdiary.enterprise.dto.Plant;
import org.springframework.stereotype.Repository;
import retrofit2.Call;
import retrofit2.Response;
import retrofit2.Retrofit;

import java.io.IOException;
import java.util.List;

@Repository
public class PlantDAO implements IPlantDAO{

    @Override
    public List<Plant> fetchPlants(String combinedName) throws IOException {
        // get an instance of retrofit from Retrofit static method, no need to create an object first
        Retrofit retrofitInstance = RetrofitClientInstance.getRetrofitInstance();
        //we crate an object that implements IPlantRetrofitDAO.class(type)
        IPlantRetrofitDAO plantRetrofitDAO = retrofitInstance.create(IPlantRetrofitDAO.class);
        // now we can retrieve our plants filtered. Retrofit is going to put this into an asynchronous call for us:user can still interact with the app while waiting for the response.
        // Call:generic type that represents all getPlants Method returns which is a list of plants
        Call<List<Plant>> allPlants = plantRetrofitDAO.getPlants(combinedName);
        // we start the call( we will required to throw an exception)
        // Response = returns a list of plant
        Response<List<Plant>> execute = allPlants.execute();
        //execute. body will finally return our plants received from the json put into our dto
        List<Plant> plants = execute.body();
        return plants;
    }
}
