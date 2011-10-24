package ca.uqam.mgl7361.a2011.omega.mockproject.test;

import ca.uqam.mgl7361.a2011.omega.mockproject.*;
import ca.uqam.mgl7361.a2011.omega.framework.annotation.*;

public class BranchTest {
	private static Leaf leaf;
	
	@Setup
	public static void createLeaf() {
		leaf = new Leaf();
	}
	
	@Test
	public static void AddingLeavesToABranch() {
		Branch branch = new Branch();
		branch.AddLeaf(leaf);
	}
	
	@Teardown
	public static void destroyLeaf() {
		leaf = null;
	}
}
