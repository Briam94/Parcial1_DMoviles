package com.example.usuario.myapplication;

import android.content.ContentValues;
import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

import com.example.usuario.myapplication.Conexion.Connect;
import com.example.usuario.myapplication.Modelos.Clientes;
import com.example.usuario.myapplication.Utilidades.Utilidades;

import java.util.ArrayList;

public class RegistroVentas extends AppCompatActivity {

    EditText idVentas, cliente, producto, tiempo, precio;
    Button btnRegistrarVentas, btnCancelarVentas;


    EditText cedulaBusqueda;
    Button buscar;


    Connect conn;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registro_ventas);

        idVentas = (EditText) findViewById(R.id.campoIdVenta);
        cliente = (EditText) findViewById(R.id.campoCliente);
        producto = (EditText) findViewById(R.id.campoProducto);
        tiempo = (EditText) findViewById(R.id.campoTiempo);
        precio = (EditText) findViewById(R.id.campoPrecio);


        cedulaBusqueda = (EditText) findViewById(R.id.editText3);
        buscar = (Button) findViewById(R.id.button2buscar);

        btnRegistrarVentas = (Button) findViewById(R.id.botonVender);
        btnCancelarVentas = (Button) findViewById(R.id.botonCancelar);

        conn = new Connect(getApplicationContext(),"db_clientes",null,1);

        buscar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                buscarCliente();
            }
        });

        btnRegistrarVentas.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                registrarVentas();
            }
        });

        btnCancelarVentas.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
    }

    public void buscarCliente(){
        SQLiteDatabase db = conn.getReadableDatabase();
        String[] parametros = {cedulaBusqueda.getText().toString()};
        String[] campos = {Utilidades.CAMPO_IDCLIENTE, Utilidades.CAMPO_NOMBRECLIENTE, Utilidades.CAMPO_CEDULACLIENTE,
                Utilidades.CAMPO_CORREOCLIENTE,Utilidades.CAMPO_TELEFONOCLIENTE, Utilidades.CAMPO_DIRECCIONCLIENTE};

        try {

            Cursor cursor = db.query(Utilidades.TABLA_CLIENTE,campos,Utilidades.CAMPO_CEDULACLIENTE + "=?",
                    parametros,null,null,null);
            cursor.moveToFirst();
            idVentas.setText(cursor.getString(2));
            cliente.setText(cursor.getString(1));
            cursor.close();

        }catch (Exception e){
            Toast.makeText(getApplicationContext(),"El Numero de cedula es erroneo o el cliente no existe",Toast.LENGTH_SHORT).show();

        }
    }


    public void registrarVentas(){

        Connect conn = new Connect(this,"db_ventas",null,1);

        SQLiteDatabase db = conn.getWritableDatabase();

        ContentValues values = new ContentValues();
        values.put(Utilidades.CAMPO_IDVENTA,idVentas.getText().toString());
        values.put(Utilidades.CAMPO_CLIENTE,cliente.getText().toString());
        values.put(Utilidades.CAMPO_PRODUCTO,producto.getText().toString());
        values.put(Utilidades.CAMPO_TIEMPO,tiempo.getText().toString());
        values.put(Utilidades.CAMPO_PRECIO,precio.getText().toString());

        Long idResultante = db.insert(Utilidades.TABLA_VENTA,Utilidades.CAMPO_PRODUCTO,values);

        Toast.makeText(getApplicationContext(),"VENTA EXITOSA",Toast.LENGTH_SHORT).show();
        db.close();

        Intent i = new Intent(getApplicationContext(),DashBoard.class);
        startActivity(i);
    }
}
