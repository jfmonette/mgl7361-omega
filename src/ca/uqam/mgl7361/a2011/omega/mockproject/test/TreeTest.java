package ca.uqam.mgl7361.a2011.omega.mockproject.test;

import ca.uqam.mgl7361.a2011.omega.mockproject.*;
import ca.uqam.mgl7361.a2011.omega.framework.annotation.*;

public class TreeTest {
	private static Branch branch;
	
	@Setup
	public static void createBranch() {
		branch = new Branch();
	}
	
	@Test
	public static void addingBranchesToATree() {
		Tree tree = new Tree();
		tree.AddBranch(branch);
	}
	
	@Teardown
	public static void destroyBranch() {
		branch = null;
	}

}
