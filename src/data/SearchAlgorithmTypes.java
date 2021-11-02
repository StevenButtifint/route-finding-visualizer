package data;

public enum SearchAlgorithmTypes {
	
	BREADTH_FIRST("breadthFirst"), DEPTH_FIRST("depthFirst");
	
	String algorithmName;
	
	SearchAlgorithmTypes(String algorithmName) {
		this.algorithmName = algorithmName;
	}
	
	public static SearchAlgorithmTypes[] getSearchAlgorithmTypes() {
		SearchAlgorithmTypes[] searchAlgorithmTypes = new SearchAlgorithmTypes[] {
				SearchAlgorithmTypes.BREADTH_FIRST, 
				SearchAlgorithmTypes.DEPTH_FIRST
				};
		return searchAlgorithmTypes;
		
	}
}
