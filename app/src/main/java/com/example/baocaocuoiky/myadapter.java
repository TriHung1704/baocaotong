package com.example.baocaocuoiky;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class myadapter extends RecyclerView.Adapter<myadapter.myviewholder>
{
    ArrayList <model> dataholder;
    private model model;

    public myadapter(ArrayList<model> dataholder) {
        this.dataholder = dataholder;
    }

    @NonNull
    @Override
    public myviewholder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
       View view= LayoutInflater.from(parent.getContext()).inflate(R.layout.singlerow,parent,false);
       return new myviewholder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull myviewholder holder, int position) {
        holder.dquoctich.setText(dataholder.get(position).getQuoctich());
        holder.dhoten.setText(dataholder.get(position).getHoten());
        holder.dngaysinh.setText(dataholder.get(position).getNgaysinh());
        holder.dsdt.setText(dataholder.get(position).getSdt());
        holder.demail.setText(dataholder.get(position).getEmail());

    }

    @Override
    public int getItemCount() {
        return dataholder.size();
    }

    class myviewholder extends RecyclerView.ViewHolder{
        TextView dquoctich,dhoten,dngaysinh,dsdt,demail;

        public myviewholder(@NonNull View itemView) {
            super(itemView);

            dhoten=(TextView)itemView.findViewById(R.id.tvht);
            dquoctich=(TextView)itemView.findViewById(R.id.tvqt);
            dngaysinh=(TextView)itemView.findViewById(R.id.tvns);
            dsdt=(TextView)itemView.findViewById(R.id.tvsdt);
            demail=(TextView)itemView.findViewById(R.id.tvemail);

        }
    }
    public void filterList(ArrayList<model> filterList, model user1){
        dataholder = filterList;
        model = user1;
        notifyDataSetChanged();
    };
}
