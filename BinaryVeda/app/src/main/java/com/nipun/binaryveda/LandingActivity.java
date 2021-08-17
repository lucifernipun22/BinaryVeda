package com.nipun.binaryveda;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.nipun.binaryveda.adapter.MyAdapter;
import com.nipun.binaryveda.data.ModelItem;
import com.nipun.binaryveda.network.ApiClientJava;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class LandingActivity extends AppCompatActivity {

    private MyAdapter dataAdapter;
    private ArrayList<ModelItem> carModels = new ArrayList<>();
    private RecyclerView recyclerView;
    private CardView btnRegister;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        /**
         * Initialize all the variable in this function
         */
        intiView();

        /**
         * function is use to fetch the api from the server.
         */
        apiCall();

    }

    /**
     * Initialize all the variable in this function
     */
    private void intiView() {
        recyclerView = findViewById(R.id.recycleView);
        btnRegister = findViewById(R.id.btnRegister);

        /**
         * set intent here if user click the register button the redirect to the ProfilePageActivity
         */
        btnRegister.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(LandingActivity.this, ProfilePageActivity.class);
                startActivity(intent);
            }
        });

    }

    /**
     * function is use to fetch the api from the server.
     */
    private void apiCall() {

        /**
         * Create the network and initialize th url by using retrofit library.
         */
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("http://demo9977805.mockable.io/")
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        //initialize ApiClient here
        ApiClientJava request = retrofit.create(ApiClientJava.class);
        Call<List<ModelItem>> call1 = request.getData();
        call1.enqueue(new Callback<List<ModelItem>>() {
            @Override
            public void onResponse(Call<List<ModelItem>> call, Response<List<ModelItem>> response) {

                /**
                 * check if response is successfully fetch from the api the update our ui
                 */
                if (response.isSuccessful() && response.body() != null) {
                    carModels = new ArrayList<>(response.body());
                    dataAdapter = new MyAdapter(carModels, LandingActivity.this);

                    // use linearLayoutManger to set the recyclerView
                    LinearLayoutManager llm = new LinearLayoutManager(LandingActivity.this, RecyclerView.VERTICAL, false);
                    //set layoutManger here
                    recyclerView.setLayoutManager(llm);
                    //set adapter here
                    recyclerView.setAdapter(dataAdapter);
                    dataAdapter.notifyDataSetChanged();
                }
            }

            /**
             * check if not get the response from the api then show toast message.
             */
            @Override
            public void onFailure(Call<List<ModelItem>> call, Throwable t) {

                Toast.makeText(LandingActivity.this, "Oops! Something went wrong!", Toast.LENGTH_SHORT).show();
            }

        });
    }
}
