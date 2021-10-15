package data;

public enum TileType {
	
	BLANK_TILE("blank_tile", true), WALL_TILE("wall_tile", false), START_TILE("start_tile", true),
	CHECKPOINT_TILE("checkpoint_tile", true), END_TILE("end_tile", true),
	BLANK_TILE_SEARCHED("blank_tile_searched", true), START_TILE_SEARCHED("start_tile_searched", true),
	CHECKPOINT_TILE_SEARCHED("checkpoint_tile_searched", true), END_TILE_SEARCHED("end_tile_searched", true),
	CHECKPOINT_TILE_COMPLETE("checkpoint_tile_complete", true), START_TILE_COMPLETE("start_tile_complete", true),
	END_TILE_COMPLETE("end_tile_complete", true), PATH_TILE("path_tile", true);
	
	String textureName;
	boolean pathable;
	
	TileType(String textureName, boolean pathable) {
		this.textureName = textureName;
		this.pathable = pathable;
	}

}
