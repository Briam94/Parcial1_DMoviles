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

public class Registro_Usuarios extends AppCompatActivity {

    EditText id, correo, contraseña;
    Button btnregistrar, btnCancelar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registro__usuarios);

        id = (EditText) findViewById(R.id.campoid);
        correo = (EditText) findViewById(R.id.campoemail);
        contraseña = (EditText) findViewById(R.id.campocontraseña);

        btnregistrar = (Button) findViewById(R.id.registro);
        btnCancelar = (Button) findViewById(R.id.cancelar);

        btnregistrar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                registrarUsuario();
            }
        });

        btnCancelar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(v.getContext(), MainActivity.class);
                startActivity(i);

            }
        });
    }

    private void registrarUsuario() {

        Connect conexion = new Connect(this,"db_usuarios",null,1);

        SQLiteDatabase db = conexion.getWritableDatabase();

        ContentValues values = new ContentValues();
        values.put(Utilidades.CAMPO_ID,id.getText().toString());
        values.put(Utilidades.CAMPO_CORREO,correo.getText().toString());
        values.put(Utilidades.CAMPO_CONTRASENA,contraseña.getText().toString());

        Long idResultante = db.insert(Utilidades.TABLA_USUARIO, Utilidades.CAMPO_ID,values);

        //Toast.makeText(getApplicationContext(), "Registro exitoso del usuario: " +  idResultante,Toast.LENGTH_SHORT).show();
        Toast.makeText(getApplicationContext(), "Registro exitoso",Toast.LENGTH_SHORT).show();
        db.close();

        Intent i = new Intent(getApplicationContext(),MainActivity.class);
        startActivity(i);

    }


}
