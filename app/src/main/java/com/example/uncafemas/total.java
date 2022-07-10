package com.example.uncafemas;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import com.example.uncafemas.adaptador.ListaOrdeneseAdaptador;
import com.example.uncafemas.entidades.Ordenes;

import java.util.ArrayList;

public class total extends AppCompatActivity {

  //  TextView descripcion,cantidad,precio;
 RecyclerView listaOrdenes;
 ArrayList<Ordenes> listaOrden;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_total);
        listaOrdenes=findViewById(R.id.Total);
        listaOrdenes.setLayoutManager(new LinearLayoutManager(this));

        listaOrden = new ArrayList<>();
        ListaOrdeneseAdaptador adaptador= new ListaOrdeneseAdaptador(TotalOrden());
        listaOrdenes.setAdapter(adaptador);


     //   descripcion=findViewById(R.id.Descripcion);
     //   cantidad=findViewById(R.id.Cantidad);
      //  precio=findViewById(R.id.Precio);
    }

    public void finalizar(View view){
        Intent anterior = new Intent(this,acciones.class);
        Toast.makeText(this, "Inicio ", Toast.LENGTH_SHORT).show();
        startActivity(anterior);
        finish();
    }



    public ArrayList<Ordenes> TotalOrden(){
        int id = recibirDatos();
        System.out.println(id);
        AdminSQLiteOpenHelper admin = new AdminSQLiteOpenHelper(this,
                "administracion", null, 1);
        SQLiteDatabase bd = admin.getWritableDatabase();

        ArrayList<Ordenes> ordenes = new ArrayList<>();
        Ordenes orden = null;
        Cursor cursor = null;
        cursor=bd.rawQuery("select descripcion,cantidad,precio,monto from articulos where idOrden =" +id , null);
        if(cursor.moveToFirst()){
            do{

                orden = new Ordenes();
                orden.setDescipcion(cursor.getString(0));
                orden.setCantidad(cursor.getInt(1));
                orden.setPrecio(cursor.getInt(2));
                orden.setMonto(cursor.getInt(3));
                ordenes.add(orden);
            }while (cursor.moveToNext());
        }
        cursor.close();
        return ordenes;
    }

    public int recibirDatos(){
        Bundle datos = getIntent().getExtras();
        int id = datos.getInt("idFilro");
        return id;
    }
}

