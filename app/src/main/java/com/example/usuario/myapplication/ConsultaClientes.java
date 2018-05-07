package com.example.usuario.myapplication;

import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.usuario.myapplication.Conexion.Connect;
import com.example.usuario.myapplication.Utilidades.Utilidades;

public class ConsultaClientes extends AppCompatActivity {

    EditText idConsultaCliente, nombreConsultaCliente, cedulaConsultaCliente, correoConsultaCliente,
        telefonoConsultaCliente, direccionConsultaCliente;

    Button btnBusquedaCliente, btnCancelarBusqueda;

    Connect conn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_consulta_clientes);

        conn = new Connect(getApplicationContext(),"db_clientes",null,1);

        idConsultaCliente = (EditText) findViewById(R.id.idResultadoCliente);
        nombreConsultaCliente = (EditText) findViewById(R.id.nombreResultadoCliente);
        cedulaConsultaCliente = (EditText) findViewById(R.id.campoCedulaBusqueda);
        correoConsultaCliente = (EditText) findViewById(R.id.correoResultadoCliente);
        telefonoConsultaCliente = (EditText) findViewById(R.id.telefonoResultadoCliente);
        direccionConsultaCliente = (EditText) findViewById(R.id.direccionResultadoCliente);

        btnBusquedaCliente = (Button) findViewById(R.id.botonBuscarCliente);
        btnCancelarBusqueda = (Button) findViewById(R.id.botonCancelarBusqueda);

        btnCancelarBusqueda.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(v.getContext(),TipoBusqueda.class);
                startActivity(i);
            }
        });

        btnBusquedaCliente.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                buscarCliente();
            }
        });
    }

    public void buscarCliente(){
        SQLiteDatabase db = conn.getReadableDatabase();
        String[] parametros = {cedulaConsultaCliente.getText().toString()};
        String[] campos = {Utilidades.CAMPO_IDCLIENTE, Utilidades.CAMPO_NOMBRECLIENTE, Utilidades.CAMPO_CORREOCLIENTE,
                            Utilidades.CAMPO_TELEFONOCLIENTE, Utilidades.CAMPO_DIRECCIONCLIENTE};

        try {

            Cursor cursor = db.query(Utilidades.TABLA_CLIENTE,campos,Utilidades.CAMPO_CEDULACLIENTE + "=?",
                    parametros,null,null,null);
            cursor.moveToFirst();
            idConsultaCliente.setText(cursor.getString(0));
            nombreConsultaCliente.setText(cursor.getString(1));
            correoConsultaCliente.setText(cursor.getString(2));
            telefonoConsultaCliente.setText(cursor.getString(3));
            direccionConsultaCliente.setText(cursor.getString(4));
            cursor.close();

        }catch (Exception e){
            Toast.makeText(getApplicationContext(),"El Numero de cedula es erroneo o el cliente no existe",Toast.LENGTH_SHORT).show();
            limpiar();
        }
    }

    public void limpiar(){

        idConsultaCliente.setText("");
        nombreConsultaCliente.setText("");
        correoConsultaCliente.setText("");
        telefonoConsultaCliente.setText("");
        direccionConsultaCliente.setText("");
    }
}
