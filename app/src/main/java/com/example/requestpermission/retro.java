package com.example.requestpermission;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.ProgressBar;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class retro extends Fragment {

    View v;
    private RecyclerView.LayoutManager manager;
    ArrayList<const_retro> list = new ArrayList<>();
    private RecyclerView rv;
    private retro_adapter retroAdapter;
    private ProgressBar progressBar;
    int i = 1, p = 0;
    int count = 10;
    public retro() {
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
       if(v==null) {
           v = inflater.inflate(R.layout.retrofit, container, false);
           rv = v.findViewById(R.id.rc);
           rv.setLayoutManager(new LinearLayoutManager(getContext()));

       }
           return v;

    }

}
