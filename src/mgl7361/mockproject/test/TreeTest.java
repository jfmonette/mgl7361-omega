package mgl7361.mockproject.test;

import mgl7361.mockproject.*;
import mgl7361.framework.annotation.*;

public class TreeTest {
	
	@Test
	public void AddingBranchesToATree() {
		Tree tree = new Tree();
		tree.AddBranch(new Branch());
	}

}
