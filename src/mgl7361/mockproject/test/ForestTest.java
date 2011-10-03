package mgl7361.mockproject.test;

import mgl7361.mockproject.*;
import mgl7361.framework.annotation.*;

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
