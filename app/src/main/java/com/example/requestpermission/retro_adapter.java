package com.example.requestpermission;

import android.content.Context;
import android.graphics.Color;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.fragment.app.FragmentActivity;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class retro_adapter extends RecyclerView.Adapter<retro_adapter.viewholder>
{
    ArrayList<const_retro> al;
    private Context context;

    public retro_adapter(Context context, ArrayList<const_retro> al) {
        this.al = al;
        this.context=context;
    }


    @NonNull
    @Override
    public viewholder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
         View v= LayoutInflater.from(parent.getContext()).inflate(R.layout.retrofit_items,parent,false);
         return new viewholder(v);

    }

    @Override
    public void onBindViewHolder(@NonNull viewholder holder, int position) {
        holder.id.setText(al.get(position).getId().toString());
        holder.Title.setText(al.get(position).getTitle());
        holder.status.setText(al.get(position).getCompleted().toString());
        if (al.get( position ).getCompleted().toString() == "true"){
            holder.status.setTextColor( Color.GREEN );
        }else {
            holder.status.setTextColor( Color.RED );
        }
    }

    @Override
    public int getItemCount() {
        return al.size();
    }

    class viewholder extends RecyclerView.ViewHolder
    {

        TextView id;
        TextView Title;
        TextView status;

        public viewholder(@NonNull View itemView) {
            super(itemView);

            id = itemView.findViewById(R.id.txt1);
            Title=itemView.findViewById(R.id.txt2);
            status= itemView.findViewById(R.id.txt3);
        }
    }
}
