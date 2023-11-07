package com.example.retrofitapp;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ArrayAdapter;

import com.example.retrofitapp.databinding.ActivityMainBinding;
import com.example.retrofitapp.model.Data;
import com.example.retrofitapp.model.Users;
import com.example.retrofitapp.network.ApiClient;
import com.example.retrofitapp.network.ApiService;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        ActivityMainBinding binding=ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        ApiService client = ApiClient.getInstance();
        Call<Users> response = client.getAllUsers();
        List<String> dataUser = new ArrayList<>();

        response.enqueue(new Callback<Users>() {
            @Override
            public void onResponse(Call<Users> call, Response<Users> response) {
                for (Data data : response.body().getData()) {
                    dataUser.add(data.getEmployee_name());
                }
                ArrayAdapter<String> ListAdapter = new ArrayAdapter<>(
                        MainActivity.this, android.R.layout.simple_list_item_1, dataUser);
                binding.tvNama.setAdapter(ListAdapter);
            }

            @Override
            public void onFailure(Call<Users> call, Throwable t) {

            }
    });
    }
}