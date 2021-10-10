package userInterface;

import org.newdawn.slick.opengl.Texture;

public class Button {
	
	private String name;
	private Texture texture;
	private int x, y, width, height;
	
	//different constructors for different classes to use
	public Button(String name, Texture texture, int x, int y, int width, int height) {
		this.name = name;
		this.texture = texture;
		this.x = x;
		this.y = y;
		this.width = width;
		this.height = height;
	}
	
	public Button(String name, Texture texture, int x, int y) {
		this.name = name;
		this.texture = texture;
		this.x = x;
		this.y = y;
		this.width = texture.getImageWidth();
		this.height = texture.getImageHeight();
	}

}
