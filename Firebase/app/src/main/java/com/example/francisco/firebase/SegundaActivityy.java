package com.example.francisco.firebase;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.io.FileReader;

public class SegundaActivityy extends AppCompatActivity {


    private Button mylogout, btnNuevo;

    private TextView mensajeTextView;
    private EditText mensajeEditText, mensaje2EditText;


  /*  DatabaseReference ref = FirebaseDatabase.getInstance().getReference("Alumnos");
    DatabaseReference mensajeRef = ref.child("Nombre");
    //DatabaseReference mensajeRef = ref.child("NoControl");*/


    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_segunda_activityy);

        mensajeTextView = (TextView) findViewById(R.id.mensajeTextView);
        mensajeEditText = (EditText) findViewById(R.id.mensajeEditText);
        mensaje2EditText = (EditText) findViewById(R.id.mensaje2EditText);

        mylogout = (Button) findViewById(R.id.logout);
        btnNuevo = (Button) findViewById(R.id.nuevo);


        FirebaseDatabase database = FirebaseDatabase.getInstance();
        final DatabaseReference myRef = database.getReference(FirebaseReferences.ALUMNOS_REFERENCE);
        btnNuevo.setOnClickListener(new View.OnClickListener() {

            String mensaje = mensajeEditText.getText().toString();
            String mensaje2 = mensaje2EditText.getText().toString();

            @Override
            public void onClick(View view) {
                Alumno alumno = new Alumno("Ingrid Gallegos" , "13400409");
                myRef.child(FirebaseReferences.ALUMNOS_REFERENCE).push().setValue(alumno);
            }
        });


        mylogout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                FirebaseAuth.getInstance().signOut();
                startActivity(new Intent(SegundaActivityy.this, MainActivity.class));
            }
        });

    }

    /*
    private void writeNewUser(String Nombre, String NoControl) {
        Alumno user = new Alumno(Nombre, NoControl);

        myRef.child("Alumnos").child(userId).setValue(user);
    }
*/

    @Override
    protected void onStart() {
        super.onStart();

/*
        // Read from the database
        mensajeRef.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                // This method is called once with the initial value and again
                // whenever data at this location is updated.
                String value = dataSnapshot.getValue(String.class);

                mensajeTextView.setText(value);

            }

            @Override
            public void onCancelled(DatabaseError error) {
                // Failed to read value
               // Log.w(TAG, "Failed to read value.", error.toException());
            }
        });

    }

    public void modificar(View view){
        String mensaje = mensajeEditText.getText().toString();
        String mensaje2 = mensaje2EditText.getText().toString();

        mensajeRef.setValue(mensaje);
        mensajeRef.setValue(mensaje2);

        mensajeEditText.setText("");
        mensaje2EditText.setText("");
    }
*/
    }
}
