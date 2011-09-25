package mgl7361.mockproject;

import java.util.Collection;
import java.util.ArrayList;

public class Forest {
	private Collection<Tree> trees = new ArrayList<Tree>();
	
	public void AddTree(Tree tree) {
		this.trees.add(tree);
	}
	
	public Collection<Tree> GetTrees() {
		return this.trees;
	}

}
