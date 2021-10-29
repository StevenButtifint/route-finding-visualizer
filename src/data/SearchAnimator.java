package data;

import java.util.List;

import searchAlgorithms.*;


public class SearchAnimator {
	
	
	private TileGrid grid;
	private SearchAlgorithmTypes algorithmType;
	private boolean searchComplete, pathAnimation;
	private BreadthFirstSearch breadthFirstSearch;
	private DepthFirstSearch depthFirstSearch;
	
	
	public SearchAnimator(TileGrid grid, SearchAlgorithmTypes algorithmType) {		
		this.grid = grid;
		this.algorithmType = algorithmType;
		this.grid.setTile(this.grid.getStartX(), this.grid.getStartY(), TileType.START_TILE_SEARCHED);
		this.breadthFirstSearch = new BreadthFirstSearch(this.grid);
		this.depthFirstSearch = new DepthFirstSearch(this.grid);
	}
	
	
	
	
	public TileGrid clearSearch() {
		for (int x = 0; x<grid.getTilesX(); x++) {
			for (int y = 0; y<grid.getTilesY(); y++) {
				TileType tileType = grid.getTileType(x, y);	
				switch(tileType) {
					case BLANK_TILE_SEARCHED:
					case PATH_TILE:
						this.grid.setTile(x, y, TileType.BLANK_TILE);
						break;
					case CHECKPOINT_TILE_SEARCHED:
					case CHECKPOINT_TILE_COMPLETE:
						this.grid.setTile(x, y, TileType.CHECKPOINT_TILE);
						break;
					case END_TILE_SEARCHED:
					case END_TILE_COMPLETE:
						this.grid.setTile(x, y, TileType.END_TILE);
						break;
					case START_TILE_SEARCHED:
					case START_TILE_COMPLETE:
						this.grid.setTile(x, y, TileType.START_TILE);
						break;
					default:
						break;
				}
			}
		}
		return this.grid;
	}
	

}
