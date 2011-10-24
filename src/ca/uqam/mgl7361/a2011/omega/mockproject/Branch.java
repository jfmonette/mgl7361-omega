package ca.uqam.mgl7361.a2011.omega.mockproject;

import java.util.Collection;
import java.util.ArrayList;

public class Branch {
	private Collection<Leaf> leaves = new ArrayList<Leaf>();

	public void AddLeaf(Leaf leaf) {
		this.leaves.add(leaf);
	}
	
	public Collection<Leaf> GetLeaves() {
		return this.leaves;
	}
}
