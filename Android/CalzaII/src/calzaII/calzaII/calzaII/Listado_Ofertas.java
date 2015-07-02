package calzaII.calzaII.calzaII;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;
import java.util.ArrayList;

import calzaII.calzaII.calzaII.R;
import android.app.Activity;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;

public class Listado_Ofertas extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.listado_ofertas);

		ListView listadoOfertas = (ListView) findViewById(R.id.listaOfertas);

		ArrayList<String> ofertas = new ArrayList<String>();

		try {

			URL url = new URL("http://proba24.net76.net/ofertas.php");
			URLConnection con = url.openConnection();
			BufferedReader reader = new BufferedReader(new InputStreamReader(
					con.getInputStream()));
			con.connect();

			String oferta;

			while ((oferta = reader.readLine()) != null && oferta.length() > 0) {
				ofertas.add(oferta);
			}

			reader.close();

			ArrayAdapter<String> adaptador = new ArrayAdapter<String>(this,
					android.R.layout.simple_list_item_1, android.R.id.text1,
					ofertas);

			listadoOfertas.setAdapter(adaptador);

		} catch (MalformedURLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
