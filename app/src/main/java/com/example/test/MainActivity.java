package com.example.test;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import com.google.firebase.FirebaseApp;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

public class MainActivity extends AppCompatActivity {
    EditText etNombre, etApellido, etCorreo, etContrasena;
    ListView lvDatos;

    Spinner opciones, opciones2, opciones3, opciones4;
    Button btGuardar;

    private List<Persona> listPerson = new ArrayList<Persona>();
    ArrayAdapter<Persona> arrayAdapterPersona;

    Persona personaSelected;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        opciones = (Spinner)findViewById(R.id.spEmbarcaciones);
        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this, R.array.opciones, android.R.layout.simple_spinner_item);
        opciones.setAdapter(adapter);

        opciones2 = (Spinner)findViewById(R.id.spDestinos);
        ArrayAdapter<CharSequence> adapter2 = ArrayAdapter.createFromResource(this, R.array.opciones2, android.R.layout.simple_spinner_item);
        opciones2.setAdapter(adapter2);

        opciones3 = (Spinner)findViewById(R.id.spPasajeros);
        ArrayAdapter<CharSequence> adapter3 = ArrayAdapter.createFromResource(this, R.array.opciones3, android.R.layout.simple_spinner_item);
        opciones3.setAdapter(adapter3);

        opciones4 = (Spinner)findViewById(R.id.spHora);
        ArrayAdapter<CharSequence> adapter4 = ArrayAdapter.createFromResource(this, R.array.opciones4, android.R.layout.simple_spinner_item);
        opciones4.setAdapter(adapter4);






    }








    private void validacion() {
        String nombre = etNombre.getText().toString();
        String apellido = etApellido.getText().toString();
        String correo = etCorreo.getText().toString();
        String contrasena = etContrasena.getText().toString();
        if(nombre.equals("")){
            etNombre.setError("Required");
        } else if(apellido.equals("")){
            etApellido.setError("Required");
        }else if(correo.equals("")){
            etCorreo.setError("Required");
        }else if(contrasena.equals("")){
            etContrasena.setError("Required");
        }
    }

    private void limpiarCajas() {
        etNombre.setText("");
        etApellido.setText("");
        etCorreo.setText("");
        etContrasena.setText("");
    }
}