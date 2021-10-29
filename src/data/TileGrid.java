package data;


public class TileGrid {
	
	public Tile[][] map;
	
	private int startX;
	private int startY;
	
	private int xTiles = 20;
	private int yTiles = 15;
	
	private int tileSize = 48;
	
	public TileGrid() {
		map = new Tile[xTiles][yTiles];
		for (int i=0; i<map.length; i++) {
			for (int j=0; j<map[i].length; j++) {
				map[i][j] = new Tile(i*tileSize, j*tileSize, tileSize, tileSize, TileType.BLANK_TILE);
			}
		}
	}
	
	public TileGrid(int[][] newMap) {
		map = new Tile[xTiles][yTiles];
		
		for (int i=0; i<map.length; i++) {
			for (int j=0; j<map[i].length; j++) {
				switch(newMap[j][i]) {
				case 0:
					map[i][j] = new Tile(i*tileSize, j*tileSize, tileSize, tileSize, TileType.BLANK_TILE);
					break;
				case 1:
					map[i][j] = new Tile(i*tileSize, j*tileSize, tileSize, tileSize, TileType.START_TILE);
					break;
				case 2:
					map[i][j] = new Tile(i*tileSize, j*tileSize, tileSize, tileSize, TileType.CHECKPOINT_TILE);
					break;
				case 3:
					map[i][j] = new Tile(i*tileSize, j*tileSize, tileSize, tileSize, TileType.END_TILE);
					break;
				case 4:
					map[i][j] = new Tile(i*tileSize, j*tileSize, tileSize, tileSize, TileType.WALL_TILE);
					break;
				case 5:
					map[i][j] = new Tile(i*tileSize, j*tileSize, tileSize, tileSize, TileType.BLANK_TILE_SEARCHED);
					break;
				case 6:
					map[i][j] = new Tile(i*tileSize, j*tileSize, tileSize, tileSize, TileType.START_TILE_SEARCHED);
					break;
				case 7:
					map[i][j] = new Tile(i*tileSize, j*tileSize, tileSize, tileSize, TileType.CHECKPOINT_TILE_SEARCHED);
					break;
				case 8:
					map[i][j] = new Tile(i*tileSize, j*tileSize, tileSize, tileSize, TileType.END_TILE_SEARCHED);
					break;
				case 9:
					map[i][j] = new Tile(i*tileSize, j*tileSize, tileSize, tileSize, TileType.START_TILE_COMPLETE);
					break;
				case 10:
					map[i][j] = new Tile(i*tileSize, j*tileSize, tileSize, tileSize, TileType.CHECKPOINT_TILE_COMPLETE);
					break;
				case 11:
					map[i][j] = new Tile(i*tileSize, j*tileSize, tileSize, tileSize, TileType.END_TILE_COMPLETE);
					break;
				case 12:
					map[i][j] = new Tile(i*tileSize, j*tileSize, tileSize, tileSize, TileType.PATH_TILE);
				}
			} 
		}
	}
	
	
}