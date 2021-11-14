package data;

import org.lwjgl.input.Mouse;
import org.newdawn.slick.opengl.Texture;

import helpers.StateManager;
import helpers.StateManager.GameState;

import static helpers.Artist.*;
import userInterface.UserInterface;


public class MainMenu {
	
	private Texture background;
	private UserInterface menuUserInterface;
	private String tileTypeSelected;
	
	public MainMenu() {
		background = QuickLoad("mainmenu");
		this.menuUserInterface = new UserInterface();
		this.menuUserInterface.addButton("Create", "buttonTextures/create_icon", WIDTH/2 -268, (int) (HEIGHT * 0.75f));
		this.menuUserInterface.addButton("Quit", "buttonTextures/quit_icon", WIDTH/2 -268, (int) (HEIGHT * 0.85f));
		
		this.tileTypeSelected = TileType.START_TILE.toString();

		this.menuUserInterface.addButton("tileTypeSelection", "tileTextures/" + this.tileTypeSelected, WIDTH -99, (int) (HEIGHT * 0.23f));
		
		
		
	}
	
	private void updateButtons() {
		if (Mouse.isButtonDown(0)) {
			if (menuUserInterface.isButtonClicked("Create"))
				System.out.println("Play button clicked");
				StateManager.setState(GameState.EDITOR);
		}
	}

	public void update() {
		DrawQuadTexture(background, 0, 0, 2048, 1024);
		this.menuUserInterface.draw();
		updateButtons();
	}
	
	public void sidebarUpdate(String currentTileType) {
		if (tileTypeSelected != currentTileType) {
			tileTypeSelected = currentTileType;
			menuUserInterface.editButtonTexture("tileTextures/" + currentTileType, 2);				
		}
		update();
	}
}
