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
	
	

}
