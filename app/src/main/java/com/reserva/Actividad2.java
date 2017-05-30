package com.reserva;

import android.app.Activity;
import android.content.ContentValues;
import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

public class Actividad2 extends Activity {

	String nombre = "", fecha = "", hora = "";
	int personas = 0;
	TextView muestraDatos;


	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.actividad2);

		muestraDatos = (TextView) findViewById(R.id.muestraDatos);

		Bundle recibe = new Bundle();
		recibe = this.getIntent().getExtras();

		nombre = recibe.getString("nombre");
		personas = recibe.getInt("personas");
		fecha = recibe.getString("fecha");
		hora = recibe.getString("hora");

		muestraDatos.setText("Reservacion a nombre de:\n" + nombre + "\n" + personas
				+ " personas\nFecha: " + fecha + "\nHora: " + hora + "\n");

	}

    public void hacerOtraReserva(View v) {
        Intent envia = new Intent(this, MainActivity.class);
        finish();
        startActivity(envia);
    }

	public void mandarCorreo(View correo)
	{
		Intent intent = new Intent(Intent.ACTION_SEND);
		intent.setType("text/plain");
		intent.putExtra(Intent.EXTRA_SUBJECT, "Contacto");
		intent.putExtra(Intent.EXTRA_TEXT, "Comentarios o sugerencias");
		intent.putExtra(Intent.EXTRA_EMAIL, new String[] { "reservacionesChris@gmail.com"} );
		startActivity(intent);
	}

	public void googleMaps(View maps)
	{
		Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse("geo:19.5652097, -99.26469980000002"));
		startActivity(intent);
	}


	public void llamadaTelefono(View llamada)
	{
		Intent intent = new Intent(Intent.ACTION_CALL, Uri.parse("tel:5585741962"));
		startActivity(intent);
	}

}
