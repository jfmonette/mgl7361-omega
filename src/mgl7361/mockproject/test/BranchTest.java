package mgl7361.mockproject.test;

import mgl7361.mockproject.*;
import mgl7361.framework.annotation.*;

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
