package com.example.usuario.myapplication;

import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;

import com.example.usuario.myapplication.Conexion.Connect;
import com.example.usuario.myapplication.Modelos.Ventas;
import com.example.usuario.myapplication.Utilidades.Utilidades;

import java.util.ArrayList;

public class ReporteVentas extends AppCompatActivity {

    ListView listViewVentas;
    ArrayList<String> listaInformacion;
    ArrayList<Ventas> listaVentas;

    EditText campoConsulta;

    Button botonConsulta;
    Button cancelarReporte;

    Connect conn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_reporte_ventas);

        botonConsulta = findViewById(R.id.button);

        cancelarReporte = findViewById(R.id.button2);

        campoConsulta = (EditText) findViewById(R.id.editText4);

        Connect conn = new Connect(getApplicationContext(),"db_ventas",null,1);


        listViewVentas = (ListView) findViewById(R.id.listViewVentas);


        botonConsulta.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                consultarListaPersonas();
            }
        });

        //ArrayAdapter adaptador = new ArrayAdapter (this,android.R.layout.simple_list_item_1,listaInformacion);
        //listViewVentas.setAdapter(adaptador);

        cancelarReporte.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
    }

    private void consultarListaPersonas(){
        SQLiteDatabase db = conn.getReadableDatabase();

        Ventas venta = null;

        listaVentas = new ArrayList<Ventas>();

        Cursor cursor = db.rawQuery("SELECT * FROM " + Utilidades.TABLA_VENTA + " where  idVentas='" + campoConsulta + "'",null);

        while (cursor.moveToNext()){
            venta = new Ventas();
            venta.setIdVentas(cursor.getInt(0));
            venta.setCliente(cursor.getString(1));
            venta.setProducto(cursor.getString(2));
            venta.setTiempo(cursor.getString(3));
            venta.setPrecio(cursor.getString(4));

            listaVentas.add(venta);
        }

        obtenerLista();
    }

    private void obtenerLista(){
        listaInformacion = new ArrayList<String>();

        for (int i = 0; i < listaVentas.size(); i++){
            listaInformacion.add(listaVentas.get(i).getIdVentas() + " - " + listaVentas.get(i).getCliente());
        }

        ArrayAdapter adaptador = new ArrayAdapter(this,android.R.layout.simple_list_item_1,listaInformacion);
    }
}
