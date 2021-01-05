import java.util.HashMap;

import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

public class locationInformation {
	
	Image image;
	ImageView imageView;
	
	public HashMap<String, String> locationInfo;
	
	public locationInformation()
	{
		//TO DO...
	}
	
	
	public ImageView getImage(String location)
	{
		image = new Image(location);
		ImageView imageView = new ImageView(image); 
		
		return imageView;
	}
	
	public String modifyString(String a)
	{
		String b = a.replace(' ', '/');
		String c = b.replace('/', '_');
		
		return c;
	}

}
