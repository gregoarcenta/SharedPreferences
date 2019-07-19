package com.arcentales.sharedpreferences;

import android.app.Activity;
import android.content.Context;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    EditText colorLetra, tamañoLetra, tipoLetra;
    TextView txtColor, txtTamaño, txtTipo;
    Button guardar, leer;
    SharedPreferences preferences;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        colorLetra = (EditText) findViewById(R.id.colorTexto);
        tamañoLetra = (EditText) findViewById(R.id.tamañoLetra);
        tipoLetra = (EditText) findViewById(R.id.tipoLetra);
        guardar = (Button) findViewById(R.id.botonGuardar);
        leer = (Button) findViewById(R.id.botonLeer);
        txtColor = (TextView) findViewById(R.id.txtColor);
        txtTamaño = (TextView) findViewById(R.id.txtTamaño);
        txtTipo = (TextView) findViewById(R.id.txtTipo);

        preferences=getSharedPreferences("preferences", Context.MODE_PRIVATE);

        guardar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                SharedPreferences.Editor editor = preferences.edit();
                editor.putString("color", colorLetra.getText().toString());
                editor.putString("tamaño", tamañoLetra.getText().toString());
                editor.putString("tipo", tipoLetra.getText().toString());
                editor.apply();
                Toast.makeText(MainActivity.this,"Datos Guardados",Toast.LENGTH_SHORT).show();
            }
        });

        leer.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                txtColor.setText( "Color: "+preferences.getString("color", ""));
                txtTamaño.setText( "Tamaño: "+preferences.getString("tamaño",""));
                txtTipo.setText( "Tipo: "+preferences.getString("tipo", ""));

            }
        });

    }
}
