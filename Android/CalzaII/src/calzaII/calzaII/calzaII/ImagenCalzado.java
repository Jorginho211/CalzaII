package calzaII.calzaII.calzaII;

import java.io.IOException;
import java.net.URL;

import android.graphics.drawable.Drawable;
import android.widget.ImageView;
import android.widget.TextView;

public class ImagenCalzado extends Thread{
	
	private ImageView imagen;
	private String url;
	
	public ImagenCalzado(ImageView imagen, String url) {
		super();
		this.imagen = imagen;
		this.url = url;
	}

	public void run(){
		try {
			//Recolle a imaxe da url e situa no ImageView
			URL urlImagen = new URL(this.url);
			Drawable drawable = Drawable.createFromStream(urlImagen.openStream(), "src");
			this.imagen.setImageDrawable(drawable);
			
			this.finalize();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (Throwable e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
