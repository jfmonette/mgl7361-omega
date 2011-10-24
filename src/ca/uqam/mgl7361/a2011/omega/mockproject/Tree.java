package ca.uqam.mgl7361.a2011.omega.mockproject;

import java.util.Collection;
import java.util.ArrayList;

public class Tree {
	private Collection<Branch> branches = new ArrayList<Branch>();

	public void AddBranch(Branch branch) {
		this.branches.add(branch);
	}
	
	public Collection<Branch> GetBranches() {
		return this.branches;
	}

}
