package com.example.requestpermission;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;
import retrofit2.http.GET;
import retrofit2.http.Query;

public class retro extends Fragment {

    View v;
    private RecyclerView.LayoutManager manager;
    ArrayList<const_retro> list = new ArrayList<>();
    private RecyclerView rv;
    private retro_adapter retroAdapter;
    int i = 1, p = 2;

    public retro() {
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        if (v == null) {
            v = inflater.inflate(R.layout.retrofit, container, false);
            rv = v.findViewById(R.id.rc);
            rv.setLayoutManager(new LinearLayoutManager(getContext()));
            getJsonResponse();

        }
        return v;

    }

    private void getJsonResponse() {
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("https://jsonplaceholder.typicode.com/")
                .addConverterFactory(GsonConverterFactory.create())
                .build();
        RequestInterface requestInterface = retrofit.create(RequestInterface.class);
        Call<List<const_retro>> cl = requestInterface.getresponse();

        if (isConnectedToNetwork()) {
            cl.enqueue(new Callback<List<const_retro>>() {
                @Override
                public void onResponse(Call<List<const_retro>> call, Response<List<const_retro>> response) {
                    list = new ArrayList<>(response.body());
                    retroAdapter = new retro_adapter(getActivity(), list);
                    rv.setAdapter(retroAdapter);
                    Toast.makeText(getActivity(), "Success", Toast.LENGTH_SHORT).show();
                }

                @Override
                public void onFailure(Call<List<const_retro>> call, Throwable t) {
                    Toast.makeText(getActivity(), "Failed", Toast.LENGTH_SHORT).show();
                }

            });
        }else

        {
            Toast.makeText(getActivity(), "Internet Connection required", Toast.LENGTH_SHORT).show();

        }

    }


    private boolean isConnectedToNetwork() {
        ConnectivityManager connectivityManager = (ConnectivityManager) getContext().getSystemService( Context.CONNECTIVITY_SERVICE );
        NetworkInfo networkInfo = connectivityManager.getActiveNetworkInfo();
        return networkInfo != null && networkInfo.isConnected();
    }
    interface RequestInterface {
        @GET("todos")
        Call<List<const_retro>> getresponse();
    }

}
