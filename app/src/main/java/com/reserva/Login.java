package com.reserva;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class Login extends Activity {

    EditText txtUsuario, txtContra;
    TextView lblMsj;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        txtUsuario=(EditText) findViewById(R.id.txtusuario);
        txtContra = (EditText) findViewById(R.id.txtcontra);

    }

    public void entrar(View laVistaXML){

        String usr = "Christopher";
        String contras= "1234";
        int idUsuario = 15;
        if(txtUsuario.getText().toString().equals(usr) && txtContra.getText().toString().equals(contras) ){

            Intent miIntento = new Intent(this, MainActivity.class);
            miIntento.putExtra("idUsr", idUsuario );
            miIntento.putExtra("nombreusr", usr);
            startActivity(miIntento);
        } else{
            String msj = "Usuario o Contraseña inválidos";
            //lblMsj.setText(msj);
            Toast.makeText(this, msj, Toast.LENGTH_LONG).show();
        }
    }
}
