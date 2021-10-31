package data;


public class Editor {
	private TileGrid grid;
	private Sandbox sandbox;
	
	
	public Editor(int[][] map) {
		grid = new TileGrid(map);
		sandbox = new Sandbox(grid);
	}
	
	
	public void update() {
		grid.Draw();
		sandbox.Update();
	}
	
	
	public String getTileTypeSelection() {
		return sandbox.getSelectedType();
	}
}
