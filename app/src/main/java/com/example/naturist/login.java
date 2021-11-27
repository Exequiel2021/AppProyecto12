package com.example.naturist;

import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseAuthUserCollisionException;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.util.HashMap;
import java.util.Map;

public class login extends AppCompatActivity {

    private EditText edtcorreoelectronico;
    private EditText edtcontraseña;
    private Button btningresar, btnregistrarse;


    private String CorreoElectronico = "";
    private String Contraseña = "";


    FirebaseAuth mAuth;
    DatabaseReference mdatabase;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        mAuth = FirebaseAuth.getInstance();
        mdatabase = FirebaseDatabase.getInstance().getReference();


        edtcorreoelectronico = (EditText) findViewById(R.id.edtcorreoelectronico);
        edtcontraseña = (EditText) findViewById(R.id.edtcontraseña);
        btnregistrarse = (Button) findViewById(R.id.bntregistrarse);


        btnregistrarse.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                CorreoElectronico = edtcorreoelectronico.getText().toString();
                Contraseña = edtcontraseña.getText().toString();

                if (!CorreoElectronico.isEmpty() && !Contraseña.isEmpty()) {
                    if (edtcontraseña.length() >= 6) {
                        RegistrarUsuario();

                    } else {
                        Toast.makeText(login.this, "La Contraseña Debe Tener Mas De 6 Caracteres", Toast.LENGTH_SHORT).show();
                    }


                } else {
                    Toast.makeText(login.this, "Debe Completar los campos", Toast.LENGTH_SHORT).show();
                }

            }
        });


    }

    private void RegistrarUsuario() {
        mAuth.createUserWithEmailAndPassword(CorreoElectronico, Contraseña).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
            @Override
            public void onComplete(@NonNull Task<AuthResult> task) {
            if (task.isSuccessful()){

                Map<String, Object> map = new HashMap<>();
                map.put( "CorreoElectronico", CorreoElectronico);
                map.put( "Contraseña", Contraseña);

                String id = mAuth.getCurrentUser().getUid();

                mdatabase.child("Users").child(id).setValue(map).addOnCompleteListener(new OnCompleteListener<Void>() {
                    @Override
                    public void onComplete(@NonNull Task<Void> task) {
                        if (task.isSuccessful()){
                            int pos = CorreoElectronico.indexOf("@");
                            String user =CorreoElectronico.substring(0,pos);
                            Toast.makeText(login.this, "Bienvenido: "+ edtcorreoelectronico.getText(),  Toast.LENGTH_LONG).show();
                            Intent intencion = new Intent(getApplication(),menu.class);
                            intencion.putExtra(menu.user, user);
                            startActivity(intencion);
                        }else {
                            Toast.makeText(login.this, "No se Logro Crear Los Datos Correctamente", Toast.LENGTH_SHORT).show();
                        }

                    }
                });


            }else{
                Toast.makeText(login.this,"No Se Pudo Registrar Este Usuario",Toast.LENGTH_SHORT).show();
            }
            }

        });
    }
}



