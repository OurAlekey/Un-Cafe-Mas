package com.example.uncafemas;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

public class inicio extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void cafe(View v){
        Intent anterior = new Intent(this,cafe.class);
        int id = recibirDatos();
        Toast.makeText(this, "Cafes ", Toast.LENGTH_SHORT).show();
        anterior.putExtra("idOrden",id);
        startActivity(anterior);
        finish();
    }

    public void antojitos(View v){
        Intent anterior = new Intent(this,antojitos.class);
        int id = recibirDatos();
        Toast.makeText(this, "Antojitos ", Toast.LENGTH_SHORT).show();
            anterior.putExtra("idOrden",id);
            startActivity(anterior);


        finish();
    }

    public int recibirDatos(){
        Bundle datos = getIntent().getExtras();
        int id = datos.getInt("idOrden");
        System.out.println(id);
        return id;
    }

}