package com.example.uncafemas;

import androidx.appcompat.app.AppCompatActivity;

import android.content.ContentValues;
import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class cafe extends AppCompatActivity {


    TextView frapeTxt,americanoTxt,capuchinoTxt,lateTxt;
public String Capuchino= "Capuchino",Late = "Late",Americano = "Americano",Frape="Frape";
int contadorCap=0,contadorLate=0,contadorAme=0,contadorFrap=0;
Button MasCapuchino,MenosCapuchino,MasLate,MenosLate,MasFrape,MenosFrape,MasAmericano,MenosAmericano;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cafe);

        frapeTxt=findViewById(R.id.FrapeTxt);
        americanoTxt=findViewById(R.id.AmericanoTxt);
        capuchinoTxt=findViewById(R.id.CapuchinoTxt);
        lateTxt=findViewById(R.id.LateTxt);

        MasCapuchino =(Button)findViewById(R.id.masCapuchino);
        MasCapuchino.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                contadorCap=contadorCap+1;
                capuchinoTxt.setText("    " +contadorCap);

            }
        });


        MenosCapuchino =(Button)findViewById(R.id.menosCapuchino);
        MenosCapuchino.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(contadorCap>0){
                contadorCap=contadorCap-1;
                    capuchinoTxt.setText("    " +contadorCap);
                }else {
                    contadorCap = 0;
                    capuchinoTxt.setText("    " +contadorCap);

                }
            }
        });

        MasAmericano =(Button)findViewById(R.id.masAmericano);
        MasAmericano.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                contadorAme = contadorAme+1;
                americanoTxt.setText("    " +contadorAme);
            }
        });

        MenosAmericano =(Button)findViewById(R.id.menosAmericano);
        MenosAmericano.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(contadorAme>0){
                    contadorAme=contadorAme-1;
                    americanoTxt.setText("    " +contadorAme);
                }else{
                    contadorAme=0;
                    americanoTxt.setText("    " +contadorAme);
                }
            }
        });

        MasLate =(Button)findViewById(R.id.masLAte);
        MasLate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                contadorLate=contadorLate+1;
                lateTxt.setText("    " +contadorLate);
            }
        });
        MenosLate =(Button)findViewById(R.id.menosLate);
        MenosLate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(contadorLate>0){
                    contadorLate=contadorLate-1;
                    lateTxt.setText("    " +contadorLate);
                }else{
                    contadorLate=0;
                    lateTxt.setText("    " +contadorLate);
                }
            }
        });
        MasFrape =(Button)findViewById(R.id.masFrape);
        MasFrape.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                contadorFrap=contadorFrap+1;
                frapeTxt.setText("    " +contadorFrap + " ");
            }
        });
        MenosFrape =(Button)findViewById(R.id.menosFrape);
        MenosFrape.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(contadorFrap>0){
                    contadorFrap=contadorFrap-1;
                    frapeTxt.setText("    " +contadorFrap + " ");
                }else{
                    contadorFrap=0;
                    frapeTxt.setText("    "+contadorFrap + " ");
                }
            }
        });




    }

    public void regresar(View view){

        String Orden = "orden";
        int precioCap,precioAme,precioFrap,precioLate;
        int numOrden = recibirDatos();
        int monto1=25,monto2=20,monto3=30,monto4=20;
        precioCap = monto1*contadorCap;
        precioAme = monto2*contadorAme;
        precioFrap = monto3*contadorFrap;
        precioLate = monto4*contadorLate;



        AdminSQLiteOpenHelper admin = new AdminSQLiteOpenHelper(this,
                "administracion", null, 1);
        SQLiteDatabase bd = admin.getWritableDatabase();

        if(contadorCap >0){
            ContentValues cap = new ContentValues();

            cap.put("descripcion",Capuchino);
            cap.put("cantidad",contadorCap);
            cap.put("monto",monto1);
            cap.put("precio",precioCap);
            cap.put("idOrden",numOrden);
            bd.insert("articulos", null, cap);
            contadorCap=0;
        }

        if(contadorAme >0){
            ContentValues ame = new ContentValues();

            ame.put("descripcion",Americano);
            ame.put("cantidad",contadorAme);
            ame.put("monto",monto2);
            ame.put("precio",precioAme);
            ame.put("idOrden",numOrden);
            bd.insert("articulos", null, ame);
            contadorAme=0;
        }
        if(contadorFrap >0){
            ContentValues frap = new ContentValues();

            frap.put("descripcion",Frape);
            frap.put("cantidad",contadorFrap);
            frap.put("monto",monto3);
            frap.put("precio",precioFrap);
            frap.put("idOrden",numOrden);
            bd.insert("articulos", null, frap);
            contadorFrap=0;
        }

        if(contadorLate >0){
            ContentValues late = new ContentValues();

            late.put("descripcion",Late);
            late.put("cantidad",contadorLate);
            late.put("monto",monto4);
            late.put("precio",precioLate);
            late.put("idOrden",numOrden);
            bd.insert("articulos", null, late);
            contadorLate=0;
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
        int precioCap,precioAme,precioFrap,precioLate;
        int numOrden = recibirDatos();
        int monto1=25,monto2=20,monto3=30,monto4=20;
        precioCap = monto1*contadorCap;
        precioAme = monto2*contadorAme;
        precioFrap = monto3*contadorFrap;
        precioLate = monto4*contadorLate;




        AdminSQLiteOpenHelper admin = new AdminSQLiteOpenHelper(this,
                "administracion", null, 1);
        SQLiteDatabase bd = admin.getWritableDatabase();





        if(contadorCap >0){
            ContentValues cap = new ContentValues();

            cap.put("descripcion",Capuchino);
            cap.put("cantidad",contadorCap);
            cap.put("monto",monto1);
            cap.put("precio",precioCap);
            cap.put("idOrden",numOrden);
            bd.insert("articulos", null, cap);
            contadorCap=0;
        }

        if(contadorAme >0){
            ContentValues cap = new ContentValues();

            cap.put("descripcion",Americano);
            cap.put("cantidad",contadorAme);
            cap.put("monto",monto2);
            cap.put("precio",precioAme);
            cap.put("idOrden",numOrden);
            bd.insert("articulos", null, cap);
            contadorAme=0;
        }
        if(contadorFrap >0){
            ContentValues cap = new ContentValues();

            cap.put("descripcion",Frape);
            cap.put("cantidad",contadorFrap);
            cap.put("monto",monto3);
            cap.put("precio",precioFrap);
            cap.put("idOrden",numOrden);
            bd.insert("articulos", null, cap);
            contadorFrap=0;
        }

        if(contadorLate >0){
            ContentValues cap = new ContentValues();

            cap.put("descripcion",Late);
            cap.put("cantidad",contadorLate);
            cap.put("monto",monto4);
            cap.put("precio",precioLate);
            cap.put("idOrden",numOrden);
            bd.insert("articulos", null, cap);
            contadorLate=0;
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
        return id;
    }





}