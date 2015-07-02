package calzaII.calzaII.calzaII;

import calzaII.calzaII.calzaII.R;
import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;

public class MainActivity extends Activity implements OnClickListener{

	Button btnNiño;
	Button btnNiña;
	Button btnHombre;
	Button btnMujer;
	Button btnOfertas;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		
		btnNiño = (Button) findViewById(R.id.btnNiño);
		btnNiña = (Button) findViewById(R.id.btnNiña);
		btnHombre = (Button) findViewById(R.id.btnHombre);
		btnMujer = (Button) findViewById(R.id.btnMujer);
		btnOfertas = (Button) findViewById(R.id.btnOfertas);
		
		btnNiño.setOnClickListener(this);
		btnNiña.setOnClickListener(this);
		btnHombre.setOnClickListener(this);
		btnMujer.setOnClickListener(this);
		btnOfertas.setOnClickListener(this);
	}

	

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// TODO Auto-generated method stub
		super.onCreateOptionsMenu(menu);
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}


	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
		// TODO Auto-generated method stub
		return super.onOptionsItemSelected(item);
	}

	@Override
	public void onClick(View v) {
		Intent intent = new Intent("Listado");
		
		switch (v.getId()) {
			case R.id.btnNiño:
				intent.putExtra("tipo", "niño");
			break;
			case R.id.btnNiña:
				intent.putExtra("tipo", "niña");
			break;
			case R.id.btnHombre:
				intent.putExtra("tipo", "hombre");
			break;
			case R.id.btnMujer:
				intent.putExtra("tipo", "mujer");
			break;
			case R.id.btnOfertas:
				intent = new Intent("Listado_Ofertas");
				startActivity(intent);
				break;
		}
		
		startActivity(intent);
	}
}
