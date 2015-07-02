package calzaII.calzaII.calzaII;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import calzaII.calzaII.calzaII.R;
import android.app.Activity;
import android.graphics.Color;
import android.graphics.drawable.Drawable;
import android.opengl.Visibility;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

public class Listado extends Activity {

	ViewGroup layoutListado;
	LayoutInflater inflater;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.listado);
		
		layoutListado = (ViewGroup) findViewById(R.id.content);
		inflater = LayoutInflater.from(this);
		
		TextView tipoCalzado = (TextView) findViewById(R.id.tipo);
		TextView modelo;
		TextView tallas;
		TextView precio;
		ImageView imagen;
		String tipo = getIntent().getExtras().getString("tipo");
		tipoCalzado.setText("Calzado para "+tipo+":");
		tipo = tipo.replace('ñ', 'n');
		
		try {
			//Conexión e recollida de datos en formato json
			URL url = new URL("http://proba24.net76.net/calza2.php?tipo="+tipo);
			URLConnection con = url.openConnection();
			BufferedReader reader = new BufferedReader(new InputStreamReader(con.getInputStream()));
			con.connect();
			
			//Linear Layout para cada zapato
			LinearLayout zapato;
			
			//Data actual e data de inserccion para realizar os calculos de novo producto
			SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
			Date fechaActual = new Date();
			Date fechaZapato;
			
			JSONObject jObject = null;
			
			//Array de zapatos en formato JSON
			JSONArray array = new JSONArray(reader.readLine());
			
			for(int i = 0; i < array.length(); i++){
				jObject = array.getJSONObject(i); //Recollese cada zapato individual
				
				//Realizase a diferencia en dias desde a sua inserccion co actual
				fechaZapato = dateFormat.parse((String) jObject.get("fecha"));
				long dias = (fechaActual.getTime() - fechaZapato.getTime()) / (1000 * 60 * 60 * 24);
				
				//Dentro de cada zapato recollese o layout, e views
				zapato = (LinearLayout) inflater.inflate(R.layout.zapato, null, false);
				modelo = (TextView) zapato.findViewById(R.id.modelo);
				tallas = (TextView) zapato.findViewById(R.id.tallas);
				precio = (TextView) zapato.findViewById(R.id.precio);
				imagen = (ImageView) zapato.findViewById(R.id.imagen);
				
				//Se a diferenza en dias e menor a 15 dias considerase zapato novo e ponse visible a sua marca
				if(dias < 15){
					TextView novo = (TextView) zapato.findViewById(R.id.novo);
					novo.setBackgroundColor(Color.RED);
					novo.setVisibility(TextView.VISIBLE);
				}
				
				
				//Establecense os atributos
				modelo.setText("Modelo: " + jObject.get("modelo"));
				tallas.setText("Tallas: " + jObject.get("tallas"));
				precio.setText("Precio: " + String.format("%.2f", Float.parseFloat((String) jObject.get("precio"))) + " € (IVA Incluido)");
				
				//Engadese o layout zapato a lista de zapatos
				layoutListado.addView(zapato);
				
				//Fio para cargar a imaxe, pasando o ImageView e a url da imaxe
				new ImagenCalzado(imagen, jObject.get("imagen").toString()).start();
			}
			
			reader.close();
			
		} catch (MalformedURLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (JSONException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}