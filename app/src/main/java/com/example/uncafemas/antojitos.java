package com.example.uncafemas;

import androidx.appcompat.app.AppCompatActivity;

import android.content.ContentValues;
import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class antojitos extends AppCompatActivity {
    TextView crepasTxt,nachosTxt,popusasTxt,hamburguesaTxt;
    String Crepas = "Crepas", Nachos ="Nachos",Popusas ="Popusas",Hamburguesa = "Hamburguesa";
    int contadorCrep = 0,contadorNa = 0, contadorPo = 0, contadorHa =0;
    Button masCrepas,menosCrepas,masNachos,menosNachos,masPopusas,menosPopusas,masHamburguesa,menosHamburguesa;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_antojitos);
        crepasTxt=findViewById(R.id.CrepasTxt);
        nachosTxt=findViewById(R.id.NachosTxt);
        popusasTxt=findViewById(R.id.PopusaTxt);
        hamburguesaTxt=findViewById(R.id.HamburgesaTxt);

        masCrepas=(Button) findViewById(R.id.MasCrepas);
        masCrepas.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                contadorCrep=contadorCrep+1;
                crepasTxt.setText("    " +contadorCrep);
            }
        });

        menosCrepas=(Button) findViewById(R.id.MenosCrepas);
        menosCrepas.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(contadorCrep>0){
                    contadorCrep=contadorCrep-1;
                }else{
                    contadorCrep = 0;
                }
                crepasTxt.setText("    " +contadorCrep);
            }
        });

        masHamburguesa=(Button) findViewById(R.id.MasHamburguesa);
        masHamburguesa.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                contadorHa=contadorHa+1;
                hamburguesaTxt.setText("    " +contadorHa);
            }
        });

        menosHamburguesa=(Button) findViewById(R.id.MenosHamburguesa);
        menosHamburguesa.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(contadorHa>0){
                    contadorHa=contadorHa-1;
                }else{
                    contadorHa = 0;
                }
                hamburguesaTxt.setText("    " +contadorHa);
            }
        });

        masPopusas=(Button) findViewById(R.id.MasPopusa);
        masPopusas.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                contadorPo=contadorPo+1;
                popusasTxt.setText("    " +contadorPo);
            }
        });

        menosPopusas=(Button) findViewById(R.id.MenosPopusa);
        menosPopusas.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(contadorPo>0){
                    contadorPo=contadorPo-1;
                }else{
                    contadorPo = 0;
                }
                popusasTxt.setText("    " +contadorPo);
            }
        });

        masNachos=(Button) findViewById(R.id.MasNachos);
        masNachos.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                contadorNa=contadorNa+1;
                nachosTxt.setText("    " +contadorNa);
            }
        });

        menosNachos=(Button) findViewById(R.id.MenosNachos);
        menosNachos.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(contadorNa>0){
                    contadorNa=contadorNa-1;
                }else{
                    contadorNa = 0;
                }
                nachosTxt.setText("    " +contadorNa);
            }
        });



    }

    public void regresar(View view){


        int precioCrepas,precioNachos,precioPopusas,precioHamburguesa;
        int numOrden = recibirDatos();
        int monto1 = 20,monto2 =30,monto3=35,monto4=25;
        AdminSQLiteOpenHelper admin = new AdminSQLiteOpenHelper(this,
                "administracion", null, 1);

        SQLiteDatabase bd = admin.getWritableDatabase();
        precioCrepas = contadorCrep*monto1;
        precioNachos = contadorNa*monto2;
        precioPopusas = contadorPo *monto3;
        precioHamburguesa = contadorHa*monto4;
        if(contadorCrep>0){
            ContentValues crep = new ContentValues();
            crep.put("descripcion",Crepas);
            crep.put("cantidad",contadorCrep);
            crep.put("monto",monto1);
            crep.put("precio",precioCrepas);
            crep.put("idOrden",numOrden);
            bd.insert("articulos", null, crep);
            contadorCrep=0;

        }
        if(contadorNa>0){
            ContentValues na = new ContentValues();
            na.put("descripcion",Nachos);
            na.put("cantidad",contadorNa);
            na.put("monto",monto2);
            na.put("precio",precioNachos);
            na.put("idOrden",numOrden);
            bd.insert("articulos", null, na);
            contadorNa=0;
        }
        if(contadorPo>0){
            ContentValues po = new ContentValues();
            po.put("descripcion",Popusas);
            po.put("cantidad",contadorPo);
            po.put("monto",monto3);
            po.put("precio",precioPopusas);
            po.put("idOrden",numOrden);
            bd.insert("articulos", null, po);
            contadorPo=0;
        }
        if(contadorHa>0){
            ContentValues ha = new ContentValues();
            ha.put("descripcion",Hamburguesa);
            ha.put("cantidad",contadorHa);
            ha.put("monto",monto4);
            ha.put("precio",precioHamburguesa);
            ha.put("idOrden",numOrden);
            bd.insert("articulos", null, ha);
            contadorHa=0;
        }
        Toast.makeText(this, "Se cargaron los datos ",
                Toast.LENGTH_SHORT).show();

        bd.close();



        Intent anterior = new Intent(this,inicio.class);
        int id = recibirDatos();
        anterior.putExtra("idOrden",id);
        startActivity(anterior);
        finish();





    }

    public void total(View view){
        String Orden = "orden";

        int precioCrepas,precioNachos,precioPopusas,precioHamburguesa;
        int numOrden = recibirDatos();
        int monto1 = 20,monto2 =30,monto3=35,monto4=25;
        precioCrepas = contadorCrep*monto1;
        precioNachos = contadorNa*monto2;
        precioPopusas = contadorPo *monto3;
        precioHamburguesa = contadorHa*monto4;

        AdminSQLiteOpenHelper admin = new AdminSQLiteOpenHelper(this,
                "administracion", null, 1);
        SQLiteDatabase bd = admin.getWritableDatabase();

        if(contadorCrep>0){
            ContentValues crep = new ContentValues();
            crep.put("descripcion",Crepas);
            crep.put("cantidad",contadorCrep);
            crep.put("monto",monto1);
            crep.put("precio",precioCrepas);
            crep.put("idOrden",numOrden);
            bd.insert("articulos", null, crep);
            contadorCrep=0;

        }
        if(contadorNa>0){
            ContentValues na = new ContentValues();
            na.put("descripcion",Nachos);
            na.put("cantidad",contadorNa);
            na.put("monto",monto2);
            na.put("precio",precioNachos);
            na.put("idOrden",numOrden);
            bd.insert("articulos", null, na);
            contadorNa=0;
        }
        if(contadorPo>0){
            ContentValues po = new ContentValues();
            po.put("descripcion",Popusas);
            po.put("cantidad",contadorPo);
            po.put("monto",monto3);
            po.put("precio",precioPopusas);
            po.put("idOrden",numOrden);
            bd.insert("articulos", null, po);
            contadorPo=0;
        }
        if(contadorHa>0){
            ContentValues ha = new ContentValues();
            ha.put("descripcion",Hamburguesa);
            ha.put("cantidad",contadorHa);
            ha.put("monto",monto4);
            ha.put("precio",precioHamburguesa);
            ha.put("idOrden",numOrden);
            bd.insert("articulos", null, ha);
            contadorHa=0;
        }
        Toast.makeText(this, "Se cargaron los datos ",
                Toast.LENGTH_SHORT).show();

        bd.close();

        Intent anterior = new Intent(this,total.class);
        anterior.putExtra("idFilro",numOrden);
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