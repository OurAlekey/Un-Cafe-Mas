package com.example.uncafemas.adaptador;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.uncafemas.R;
import com.example.uncafemas.entidades.Ordenes;

import java.util.ArrayList;

public class ListaOrdeneseAdaptador extends RecyclerView.Adapter<ListaOrdeneseAdaptador.OrdentoViewHolder> {


    ArrayList<Ordenes> listaOrdenes;

    public ListaOrdeneseAdaptador(ArrayList<Ordenes> listaOrdenes) {
        this.listaOrdenes = listaOrdenes;
    }

    @NonNull
    @Override
    public OrdentoViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.total_list,null,false);
        return new OrdentoViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull OrdentoViewHolder holder, int position) {
        holder.descripcion.setText(listaOrdenes.get(position).getDescipcion()+"                       ");
        holder.cantidad.setText(listaOrdenes.get(position).getCantidad()+"             ");
        holder.monto.setText(listaOrdenes.get(position).getPrecio()+"      ");
        holder.precio.setText(listaOrdenes.get(position).getMonto()+"      ");

    }

    @Override
    public int getItemCount() {
        return listaOrdenes.size();
    }

    public class OrdentoViewHolder extends RecyclerView.ViewHolder {

        TextView descripcion,cantidad,monto,precio;

        public OrdentoViewHolder(@NonNull View itemView) {
            super(itemView);
            descripcion=itemView.findViewById(R.id.Descpcion);
            cantidad=itemView.findViewById(R.id.cantidad);
            monto=itemView.findViewById(R.id.total);
            precio=itemView.findViewById(R.id.Monto);
        }
    }
}
