package com.example.requestpermission;

import android.content.Context;
import android.os.Bundle;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class recycle1 extends Fragment {
   private RecyclerView recycle;
   ArrayList<constructorRecycler> list=new ArrayList<>();
   View v;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        v=inflater.inflate(R.layout.recycle1,container,false);
        recycle=v.findViewById(R.id.recy);
        recycle.setLayoutManager(new LinearLayoutManager(getContext()));
        list.add(new constructorRecycler(R.drawable.download,"img1"));
        list.add(new constructorRecycler(R.drawable.inst,"Insta"));
        list.add(new constructorRecycler(R.drawable.smile,"Smile"));
        list.add(new constructorRecycler(R.drawable.login,"Login"));
        RvAdapter adap=new RvAdapter(list);
        recycle.setAdapter(adap);
        recycle.setHasFixedSize(true);
        return v;

    }
}


