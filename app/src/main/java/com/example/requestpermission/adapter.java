package com.example.requestpermission;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

class RvAdapter extends RecyclerView.Adapter<RvAdapter.viewholder>
    {
        ArrayList<constructorRecycler> CR;

        public RvAdapter(ArrayList<constructorRecycler> CR) {
            this.CR = CR;
        }

        View v;


        @NonNull
        @Override
        public viewholder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
            v=LayoutInflater.from(parent.getContext()).inflate(R.layout.recycleritems,parent,false);
            return new viewholder(v);
        }

        @Override
        public void onBindViewHolder(@NonNull viewholder holder, int position) {
            holder.img.setImageResource(CR.get(position).getImg());
            holder.txt.setText(CR.get(position).getTitle());
        }

        @Override
        public int getItemCount() {
            return CR.size();
        }
        class viewholder extends RecyclerView.ViewHolder
        {
            ImageView img;
            TextView txt;

            public viewholder(@NonNull View itemView) {
                super(itemView);

                img = itemView.findViewById(R.id.imgview);
                txt = itemView.findViewById(R.id.txtview);
            }
        }

    }


