package com.example.usuario.myapplication.Conexion;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import com.example.usuario.myapplication.Utilidades.Utilidades;

public class Connect  extends SQLiteOpenHelper{



    public Connect(Context context, String name, SQLiteDatabase.CursorFactory factory, int version) {
        super(context, name, factory, version);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(Utilidades.CREAR_TABLA_USUARIO);
        db.execSQL("insert into " + Utilidades.TABLA_USUARIO + " values ('123','admin@correo.com','admin')");
        db.execSQL(Utilidades.CREAR_TABLA_VENTAS);
        db.execSQL(Utilidades.CREAR_TABLA_CLIENTES);

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS usuarios");
        db.execSQL("insert into " + Utilidades.TABLA_USUARIO + " values ('123','admin@correo.com','admin')");
        db.execSQL("DROP TABLE IF EXISTS ventas");
        db.execSQL("DROP TABLE IF EXISTS clientes");
        onCreate(db);
    }
}
