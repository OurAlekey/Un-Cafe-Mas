package com.example.uncafemas;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import com.example.uncafemas.adaptador.ListaPedidosAdaptador;
import com.example.uncafemas.entidades.Pedidos;

import java.util.ArrayList;

public class Ordenes extends AppCompatActivity {
    private  EditText id;
    RecyclerView listaPedidos;
    ArrayList<Pedidos> pedidos;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);


        setContentView(R.layout.activity_ordenes);
        listaPedidos=findViewById(R.id.OrdenesR);
        listaPedidos.setLayoutManager(new LinearLayoutManager(this));

        pedidos= new ArrayList<>();
        ListaPedidosAdaptador adaptador = new ListaPedidosAdaptador(totalPedidos());
        listaPedidos.setAdapter(adaptador);

        id=findViewById(R.id.IdOrden);
    }
    public void regresar(View view){
        Intent anterior = new Intent(this,acciones.class);
        startActivity(anterior);
        finish();
        Toast.makeText(this, "Regresando", Toast.LENGTH_SHORT).show();
    }

    public ArrayList<Pedidos> totalPedidos(){
        AdminSQLiteOpenHelper admin = new AdminSQLiteOpenHelper(this,
                "administracion", null, 1);
        SQLiteDatabase bd = admin.getWritableDatabase();


        ArrayList<Pedidos> pedidosA= new ArrayList<>();
        Pedidos pedido = null;
        Cursor cursor = null;
        cursor=bd.rawQuery("select * from ordenes ", null);
        if(cursor.moveToFirst()){
            do{
                pedido = new Pedidos();
                pedido.setId(cursor.getInt(0));
                pedido.setDescripcion(cursor.getString(1));
                pedidosA.add(pedido);
            }while (cursor.moveToNext());

        }
        cursor.close();
        return pedidosA;
    }

    public void Eliminar(View view){
        AdminSQLiteOpenHelper admin = new AdminSQLiteOpenHelper(this,
                "administracion", null, 1);
        SQLiteDatabase bd = admin.getWritableDatabase();
        String cod = id.getText().toString();
        id.setText("");
        int cant = bd.delete("ordenes", "pedido=" + cod, null);

        if (cant == 1)
            Toast.makeText(this, "Se borró el artículo con dicho código",
                    Toast.LENGTH_SHORT).show();
        else
            Toast.makeText(this, "No existe un artículo con dicho código",
                    Toast.LENGTH_SHORT).show();

    }

    public void Editar(View view){


        Intent anterior = new Intent(this,inicio.class);
        int idD= Integer.parseInt(id.getText().toString());

        anterior.putExtra("idOrden",idD);
        startActivity(anterior);
        Toast.makeText(this, "Editando " + idD, Toast.LENGTH_SHORT).show();
        finish();

    }

    public void Consultar(View view){
        Intent anterior = new Intent(this,total.class);
        int idD= Integer.parseInt(id.getText().toString());

        anterior.putExtra("idFilro",idD);
        Toast.makeText(this, "Consultando " + idD, Toast.LENGTH_SHORT).show();
        startActivity(anterior);
        finish();

    }



}