package mgl7361.mockproject.test;

import mgl7361.mockproject.*;
import mgl7361.framework.annotation.*;

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
