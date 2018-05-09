package com.example.usuario.myapplication;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class TipoBusqueda extends AppCompatActivity {

    Button btnConsultarCliente;
    Button btnReporteventas;
    Button btnCancelar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tipo_busqueda);

        btnConsultarCliente = (Button) findViewById(R.id.consultaCliente);
        btnCancelar = (Button) findViewById(R.id.botonVolverDashBoard);
        btnReporteventas = (Button) findViewById(R.id.botonReporteVentas);

        btnCancelar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });

        btnConsultarCliente.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(v.getContext(),ConsultaClientes.class);
                startActivity(i);
            }
        });

        btnReporteventas.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(v.getContext(), ReporteVentas.class);
                startActivity(i);
            }
        });
    }
}
