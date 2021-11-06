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
	
	public int getTileSize() {
		return this.tileSize;
	}
	
	public void editTile(int x, int y, TileType newType) {
		
		if (newType == TileType.START_TILE) {
			if (map[x][y].getType() != TileType.END_TILE) {
				clearTileType(TileType.START_TILE);
				//setTile(x, y, TileType.START_TILE);
				startX = x;
				startY = y;
				map[x][y] = new Tile(x*tileSize, y*tileSize, tileSize, tileSize, TileType.START_TILE);
			}
		}
		else if (newType == TileType.END_TILE) {
			if (map[x][y].getType() != TileType.START_TILE) {
				clearTileType(TileType.END_TILE);
				//setTile(x, y, TileType.END_TILE);
				map[x][y] = new Tile(x*tileSize, y*tileSize, tileSize, tileSize, TileType.END_TILE);
			}
		} else {
			//setTile(map, x, y, newType);
			map[x][y] = new Tile(x*tileSize, y*tileSize, tileSize, tileSize, newType);
		}
	}
	
	public void setTile(int x, int y, TileType newType) {
		map[x][y] = new Tile(x*tileSize, y*tileSize, tileSize, tileSize, newType);
	}
	
	
	private void clearTileType(TileType type) {
		for (int i=0; i<map.length; i++) {
			for (int j=0; j<map[i].length; j++) {
				if (map[i][j].getType() == type) {
					map[i][j] = new Tile(i*tileSize, j*tileSize, tileSize, tileSize, TileType.BLANK_TILE);
				}
			}
		}
	}
	
}
