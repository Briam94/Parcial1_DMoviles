package com.example.usuario.myapplication;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.example.usuario.myapplication.Conexion.Connect;

public class MainActivity extends AppCompatActivity {

    EditText correo;
    Button btnLogin;
    Button btnRegistro;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        correo = findViewById(R.id.editText2);
        btnLogin = findViewById(R.id.buttonIngresar);

        btnRegistro = findViewById(R.id.btnregistrousuario);

        Connect conexion = new Connect(this,"db_usuarios",null,1);
        Connect conn = new Connect(this,"db_ventas",null,1);
        Connect con = new Connect(this,"db_clientes",null,1);

        btnLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String usuario = correo.getText().toString();
                Intent intent = new Intent(v.getContext(),DashBoard.class);
                startActivity(intent);
            }
        });

        btnRegistro.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(v.getContext(), Registro_Usuarios.class);
                startActivity(i);
            }
        });
    }
}
