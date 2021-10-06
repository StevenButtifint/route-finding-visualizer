package data;

import org.lwjgl.opengl.Display;
import helpers.Clock;
import helpers.StateManager;


import static helpers.Artist.*;

//LWJGL opengl

public class Boot {
	
	public Boot() {
		
		InitializeSession();

		while (!Display.isCloseRequested()) {
			Clock.update();
			StateManager.update();	
			Display.update();
			Display.sync(60);
		}
		Display.destroy();
	}
	
	public static void main(String[] args) {
		new Boot();
	}

}
