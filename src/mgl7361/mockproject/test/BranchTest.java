package mgl7361.mockproject.test;

import mgl7361.mockproject.*;
import mgl7361.framework.annotation.*;

public class BranchTest {
	
	@Test
	public static void AddingLeavesToABranch() {
		Branch branch = new Branch();
		branch.AddLeaf(new Leaf());
	}
}
