package com.example.usuario.myapplication;

import android.content.ContentValues;
import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.usuario.myapplication.Conexion.Connect;
import com.example.usuario.myapplication.Utilidades.Utilidades;

public class RegistroVentas extends AppCompatActivity {

    EditText idVentas, cliente, producto, tiempo, precio;
    Button btnRegistrarVentas, btnCancelarVentas;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registro_ventas);

        idVentas = (EditText) findViewById(R.id.campoIdVenta);
        cliente = (EditText) findViewById(R.id.campoCliente);
        producto = (EditText) findViewById(R.id.campoProducto);
        tiempo = (EditText) findViewById(R.id.campoTiempo);
        precio = (EditText) findViewById(R.id.campoPrecio);

        btnRegistrarVentas = (Button) findViewById(R.id.botonVender);
        btnCancelarVentas = (Button) findViewById(R.id.botonCancelar);

        btnRegistrarVentas.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                registrarVentas();
            }
        });

        btnCancelarVentas.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(v.getContext(), DashBoard.class);
                startActivity(i);
            }
        });
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
