package mgl7361.mockproject.test;

import mgl7361.mockproject.*;
import mgl7361.framework.annotation.*;

public class ForestTest {
	
	@Test
	public void AddingTreesToAForest() {
		Forest forest = new Forest();
		forest.AddTree(new Tree());
	}
}
