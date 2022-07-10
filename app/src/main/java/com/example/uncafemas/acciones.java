package com.example.uncafemas;

import androidx.appcompat.app.AppCompatActivity;

import android.content.ContentValues;
import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;

public class acciones extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_acciones2);
    }



    public void nuevaOrden(View v){
        String Orden = "orden";
        int id = IdOrden();
        AdminSQLiteOpenHelper admin = new AdminSQLiteOpenHelper(this,
                "administracion", null, 1);
        SQLiteDatabase bd = admin.getWritableDatabase();
        ContentValues registro = new ContentValues();

        registro.put("pedido",id);
        registro.put("descripcio",Orden);
        bd.insert("ordenes", null, registro);

        Intent anterior = new Intent(this,inicio.class);

        System.out.println(id);
        anterior.putExtra("idOrden",id);
        startActivity(anterior);


        finish();
    }
    public  void pedidos(View v){
        Intent anterior = new Intent(this,Ordenes.class);
        startActivity(anterior);
    }

    public int IdOrden(){
        int  idOrdenes = 0,numOrden;


        AdminSQLiteOpenHelper admin = new AdminSQLiteOpenHelper(this,
                "administracion", null, 1);
        SQLiteDatabase bd = admin.getWritableDatabase();
        ContentValues orden = new ContentValues();



        Cursor fila = bd.rawQuery(
                "select  pedido  from ordenes  ", null);
        if(fila.moveToLast()){
            idOrdenes=(fila.getInt(0));
            System.out.println(idOrdenes);
        }
        bd.close();


        numOrden=idOrdenes+1;



        return  numOrden;
    }

}