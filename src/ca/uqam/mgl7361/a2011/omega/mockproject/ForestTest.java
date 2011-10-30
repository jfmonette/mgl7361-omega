package ca.uqam.mgl7361.a2011.omega.mockproject;

import ca.uqam.mgl7361.a2011.omega.framework.annotation.*;

public class ForestTest {
	private static Tree tree;
	
	@Setup
	public static void createTree() {
		tree = new Tree();
	}
	
	@Test
	public static void AddingTreesToAForest() {
		Forest forest = new Forest();
		forest.AddTree(tree);
	}
	
	@Teardown
	public static void destroyTree() {
		tree = null;
	}
}
