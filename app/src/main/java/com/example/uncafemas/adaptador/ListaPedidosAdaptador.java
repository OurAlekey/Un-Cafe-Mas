package com.example.uncafemas.adaptador;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.uncafemas.R;
import com.example.uncafemas.entidades.Pedidos;

import java.util.ArrayList;

public class ListaPedidosAdaptador extends RecyclerView.Adapter<ListaPedidosAdaptador.PedidotoViewHolder> {
    ArrayList<Pedidos> pedidos;

    public ListaPedidosAdaptador(ArrayList<Pedidos> pedidos) {
        this.pedidos = pedidos;
    }

    @NonNull
    @Override
    public PedidotoViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.pedidos_list,null ,false);
        return new PedidotoViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull PedidotoViewHolder holder, int position) {
        holder.descripcion.setText(pedidos.get(position).getDescripcion()+"");
        holder.id.setText(pedidos.get(position).getId()+"");

    }

    @Override
    public int getItemCount() {
        System.out.println(pedidos.size());
        return pedidos.size();
    }

    public class PedidotoViewHolder extends RecyclerView.ViewHolder {
        TextView id,descripcion;
        public PedidotoViewHolder(@NonNull View itemView) {
            super(itemView);
            id=itemView.findViewById(R.id.Id);
            descripcion=itemView.findViewById(R.id.Descripcion);
        }
    }
}
