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

public class MainActivity extends AppCompatActivity {

    EditText correo;
    EditText contrasena;
    Button btnLogin;
    Button btnRegistro;

    public static final String MyPREFERENCES = "MyPrefs" ;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        contrasena = findViewById(R.id.editText);
        correo = findViewById(R.id.editText2);
        btnLogin = findViewById(R.id.buttonIngresar);

        btnRegistro = findViewById(R.id.btnregistrousuario);

        Connect conexion = new Connect(this,"db_usuarios",null,1);
        Connect conn = new Connect(this,"db_ventas",null,1);
        Connect con = new Connect(this,"db_clientes",null,1);

        btnLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                ingresar();
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

    public void ingresar(){


        Connect conexion = new Connect(this,"db_usuarios",null,1);
        SQLiteDatabase db = conexion.getWritableDatabase();

        String usuario = correo.getText().toString();
        String password = contrasena.getText().toString();

        Cursor fila=db.rawQuery("select correo,contrasena from usuario where correo='" + usuario
                        + "' and contrasena='" + password + "'",null);


         if (fila.moveToNext()){
             String usua = fila.getString(0);
             String pas = fila.getString(1);
             if (usuario.equals(usua) && password.equals(pas)){

                 Intent intent = new Intent(getApplicationContext(),DashBoard.class);
                 startActivity(intent);
                 correo.setText("");
                 contrasena.setText("");

             }


         }else {
             Toast.makeText(getApplicationContext(),"Usuario o Contraseña incorrectos", Toast.LENGTH_SHORT).show();
         }
    }
}
