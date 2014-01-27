package com.jayasagar.ds.curious.tree.binary;

import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;

import com.jayasagar.ds.curious.tree.traversal.TreeTraversal;

public class BSTTest {

	private static BST bst;

	@BeforeClass
	public static void setup() {
		bst = new BST();
		
		// Act
		bst.insert(7);
		bst.insert(9);
		bst.insert(5);
		bst.insert(3);
		bst.insert(10);
		bst.insert(12);
				
	}
	
	@Test
	public void bst_search_test_should_exist() {
		// Act and Assert
		org.junit.Assert.assertTrue(bst.find(9));
	}
	
	@Test
	public void bst_search_test_should_NOT_exist() {
		BST bst = new BST();
		
		// Act
		bst.insert(7);
		bst.insert(9);
		bst.insert(8);
		
		// Act and Assert
		org.junit.Assert.assertFalse(bst.find(1));
		org.junit.Assert.assertTrue(bst.find(8));
		
	}
	
	@Test 
	public void findElementsAtKthLevel_test() {
		// level exceeded height
		Assert.assertEquals(0, bst.findElementsAtKthLevel(4).size());
		
		//
		Assert.assertEquals(2, bst.findElementsAtKthLevel(2).size());
		Assert.assertEquals(1, bst.findElementsAtKthLevel(0).size());
	}
	
	@Test
	public void binary_serach_tree_insert_should_work() {
		// Assert 
		org.junit.Assert.assertEquals(6, bst.getSize());
	}
	
	@Test
	public void binary_search_tree_height_test() {
		// Assert 
		org.junit.Assert.assertEquals(4, bst.getHeight());
	}
	
	@Test
	public void traversals_test() {
		// InOrder -- Assert :) -> Not really assert, but check manually in console
		TreeTraversal.inOrder(bst.getRoot());
				
		// Pre order
		TreeTraversal.preOrder(bst.getRoot());
		// post Order
		TreeTraversal.postOrder(bst.getRoot());
	}
}
