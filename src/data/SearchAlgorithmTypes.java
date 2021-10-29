package data;

public enum SearchAlgorithmTypes {
	
	BREADTH_FIRST("breadthFirst"), DEPTH_FIRST("depthFirst");
	
	String algorithmName;
	
	SearchAlgorithmTypes(String algorithmName) {
		this.algorithmName = algorithmName;
	}
}
