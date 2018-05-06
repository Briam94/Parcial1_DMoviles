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

public class RegistrarClientes extends AppCompatActivity {

    EditText idCliente, nombreCliente,cedulaCliente,
            correoCliente, telefonoCliente,  direccionCliente;

    Button btnRegistrarCliente, btnCancelarRegistroCliente;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registrar_clientes);

        idCliente = (EditText) findViewById(R.id.idClienteRegistra);
        nombreCliente = (EditText) findViewById(R.id.nombreCliente);
        cedulaCliente = (EditText) findViewById(R.id.cedulaCliente);
        correoCliente = (EditText) findViewById(R.id.correoCliente);
        telefonoCliente = (EditText) findViewById(R.id.telefonoCliente);
        direccionCliente = (EditText) findViewById(R.id.direccionCliente);

        btnCancelarRegistroCliente = (Button) findViewById(R.id.botonCancelarCliente);
        btnRegistrarCliente = (Button) findViewById(R.id.botonRegistrarCliente);

        btnRegistrarCliente.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                registrarCliente();
            }
        });

        btnCancelarRegistroCliente.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(v.getContext(),DashBoard.class);
                startActivity(i);

            }
        });

    }

    public void registrarCliente(){

        Connect con = new Connect(this,"db_clientes",null,1);

        SQLiteDatabase db = con.getWritableDatabase();

        ContentValues values = new ContentValues();
        values.put(Utilidades.CAMPO_IDCLIENTE,idCliente.getText().toString());
        values.put(Utilidades.CAMPO_NOMBRECLIENTE,nombreCliente.getText().toString());
        values.put(Utilidades.CAMPO_CEDULACLIENTE,cedulaCliente.getText().toString());
        values.put(Utilidades.CAMPO_CORREOCLIENTE,correoCliente.getText().toString());
        values.put(Utilidades.CAMPO_TELEFONOCLIENTE,telefonoCliente.getText().toString());
        values.put(Utilidades.CAMPO_DIRECCIONCLIENTE,direccionCliente.getText().toString());

        Long idResultante = db.insert(Utilidades.TABLA_CLIENTE, Utilidades.CAMPO_IDCLIENTE,values);

        Toast.makeText(getApplicationContext(), "Cliente Registrado Exitosamente",Toast.LENGTH_SHORT).show();
        db.close();


        Intent i = new Intent(getApplicationContext(),DashBoard.class);
        startActivity(i);

    }
}
