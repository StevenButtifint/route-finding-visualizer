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
	
	
	public TileType getSearchedType(int x,int y) {
		TileType type = map[x][y].getType();
		TileType searchType = TileType.START_TILE;//invalid response
		switch(type) {
		case BLANK_TILE:
			searchType = TileType.BLANK_TILE_SEARCHED;
			break;
		case CHECKPOINT_TILE:
			searchType = TileType.CHECKPOINT_TILE_SEARCHED;
			break;
		case END_TILE:
			searchType = TileType.END_TILE_SEARCHED;
			break;
		default:
			break;
		}
		return searchType;
	}
	
	public TileType getCompleteType(int x,int y) {
		TileType type = map[x][y].getType();
		TileType searchType = TileType.START_TILE;//invalid response
		switch(type) {
		case BLANK_TILE_SEARCHED:
			searchType = TileType.PATH_TILE;
			break;
		case CHECKPOINT_TILE_SEARCHED:
			searchType = TileType.CHECKPOINT_TILE_COMPLETE;
			break;
		case END_TILE_SEARCHED:
			searchType = TileType.END_TILE_COMPLETE;
			break;
		case START_TILE_SEARCHED:
			searchType = TileType.START_TILE_COMPLETE;
			break;
		default:
			break;
		}
		return searchType;
	}
	
	public TileType getTileType(int x, int y) {
		return map[x][y].getType();
	}
	
}
