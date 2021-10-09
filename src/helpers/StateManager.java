package helpers;


import data.Editor;
import data.MainMenu;


public class StateManager {
	
	public static enum GameState {
		MAINMENU, EDITOR
	}
	
	public static GameState gameState = GameState.MAINMENU;
	public static MainMenu mainMenu;
	public static Editor editor;
	
}
