package helpers;

import static org.lwjgl.opengl.GL11.GL_MODELVIEW;
import static org.lwjgl.opengl.GL11.GL_PROJECTION;
import static org.lwjgl.opengl.GL11.glLoadIdentity;
import static org.lwjgl.opengl.GL11.glMatrixMode;
import static org.lwjgl.opengl.GL11.glOrtho;

import java.io.IOException;
import java.io.InputStream;

import org.lwjgl.LWJGLException;
import org.lwjgl.opengl.Display;
import org.lwjgl.opengl.DisplayMode;
import org.newdawn.slick.opengl.Texture;
import org.newdawn.slick.opengl.TextureLoader;
import org.newdawn.slick.util.ResourceLoader;


import static org.lwjgl.opengl.GL11.*;

public class Artist {
	
	public static final int WIDTH = 1280, HEIGHT = 720;
			
	public static void InitializeSession() {
		Display.setTitle("Route Finding Visualizer");
		try {
			Display.setDisplayMode(new DisplayMode(WIDTH, HEIGHT));
			Display.create();
		} catch (LWJGLException e) {
			e.printStackTrace();
		}
		
		glMatrixMode(GL_PROJECTION);
		glLoadIdentity();
		glOrtho(0, WIDTH, HEIGHT, 0, 1, -1);
		glMatrixMode(GL_MODELVIEW);
		glEnable(GL_TEXTURE_2D);
		glEnable(GL_BLEND);
		glBlendFunc(GL_SRC_ALPHA, GL_ONE_MINUS_SRC_ALPHA);
	}
	
	public static void DrawQuad(float x, float y, float width, float height) {
		glBegin(GL_QUADS);
		glVertex2f(x, y); //top left corner
		glVertex2f(x + width, y); //top right corner
		glVertex2f(x + width, y + height); //bottom right corner
		glVertex2f(x, y + height); //bottom left corner
		glEnd();
	}
	
	public static void DrawQuadTexture(Texture texture, float x, float y, float width, float height) {
		texture.bind();
		glTranslatef(x, y, 0);
		glBegin(GL_QUADS);
		//top left
		glTexCoord2f(0, 0);
		glVertex2f(0, 0);
		//top right
		glTexCoord2f(1, 0);
		glVertex2f(width, 0);
		//bottom right
		glTexCoord2f(1, 1);
		glVertex2f(width, height);
		//bottom left
		glTexCoord2f(0, 1);
		glVertex2f(0, height);
		glEnd();
		glLoadIdentity();
	}
	
	public static Texture LoadTexture(String path, String fileType) {
		Texture texture = null;
		InputStream in = ResourceLoader.getResourceAsStream(path);
		try {
			texture = TextureLoader.getTexture(fileType, in);
		} catch (IOException e) {
			e.printStackTrace();
		}
		return texture;
		
	}
	
	public static Texture QuickLoad(String name) {
		Texture texture = null;
		texture = LoadTexture("res/" + name + ".png", "PNG");
		return texture;
	}
}
