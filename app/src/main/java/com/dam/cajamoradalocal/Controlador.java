package com.dam.cajamoradalocal;

import android.content.SharedPreferences;
import android.graphics.Color;
import android.os.Bundle;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

public class Controlador extends AppCompatActivity {
    private TextView txt1;
    private static final String PREFS_NAME = "Mis ajustes"; //
    private static final String KEY_ACCESOS = "contadoZorra";
    private static final String PALABRA_PREFIJO = "Número  de acceso a la app:";
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.pantalla_principal);
        txt1=findViewById(R.id.texto1);

        // Obtener el SharePreferences
        SharedPreferences sharedPreferences = getSharedPreferences(PREFS_NAME, MODE_PRIVATE);
        int contadorAccesos = sharedPreferences.getInt(KEY_ACCESOS, -1);
        contadorAccesos++;
        // Guardar el nuevo valor del contador en SharedPreference
        SharedPreferences.Editor editor = sharedPreferences.edit();
        editor.putInt(KEY_ACCESOS, contadorAccesos);
        editor.apply();
        // modificando el tamaño y la imagen del texto
        txt1.setTextSize(25);
        txt1.setText(PALABRA_PREFIJO+String.valueOf(contadorAccesos));

    }
}
