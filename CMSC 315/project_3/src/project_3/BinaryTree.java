/*
 * Created by: Antonio Scalfaro
 * CMSC 315
 * 2/20/2024
 * Project 3 - BST
 * This is the BinaryTree class that will create a bst when given a string (which should be
 * already verified to be in the correct format). It contains a private TreeNode class for
 * creating each node of the tree which has 3 class varibales, int val, TreeNode left, TreeNode
 * right and a constructor method. There is one class variable private TreeNode root and there
 * are 18 class methods:
 * private TreeNode buildTree(String) - A recursive method for building a bst from the user input
 * 										string.
 * private String extractSubtree(String, int, int) - A method to return a substring of the next
 * 											subtree in the given string.
 * private int findMatchingParenthesis(String, int) - A method to return the index of the matching
 * 											paren to the given string, used to help create subtree
 * 											substring.
 * private TreeNode buildBalancedTree(int[], int, int) - A recursive method that creates a balanced 
 * 											bst and returns its root node.
 * public BinaryTree(String) - Constructor for bst class, calls buildTree
 * public BinaryTree(ArrayList<String>) - Creates balanced bst from given ArrayList
 * public printIndented() - Calls recursive printIndented(TreeNode, int) method
 * private printIndented(TreeNode, int) - Recursive method to print each node value in indented
 * 										 form.
 * public int getHeight() - Calls recursive height(TreeNode) method
 * private int height(TreeNode) - A recursive method to calculate the height of a given bst
 * public boolean isBalanced() - Calls recursive checkBalance(TreeNode) method.
 * private int checkBalance(TreeNode) - A recursive method that checks if a bst is balanced and
 * 										returns -1 if not balanced.
 * public boolean isValidBST() - Calls recursive isValidBST(TreeNode, int, int) method
 * private boolean isValidBST(TreeNode, int, int) - A recursive method to check if the given bst
 * 											is a valid bst.
 * public ArrayList<Integer> getValues() - A method that calls the recursive
 * 										preOrderTraversal(TreeNode, ArrayList<Integer>) method and
 * 										returns and ArrayList of those values.
 * private ArrayList<Integer> preOrderTaversal(TreeNode, ArrayList<Integer>) - A recursive method
 * 										that adds node values to ArrayList and returns the list.
 * public rebalance() - Calls recursive method collectValuesInOrder(TreeNode, ArrayList<Integer>)
 * 						to build an inorder list of the tree values and then builds a balanced
 * 						bst with those values by calling buildBalancedTree().
 * private collectValuesInOrder(TreeNode, ArrayList<Integer>) - A recursive method that stores the
 * 										values of the bst in order in the given ArrayList.
 * */

package project_3;
import java.util.ArrayList;

public class BinaryTree {
	private TreeNode root;
	
	private static class TreeNode{
		int val;
		TreeNode left;
		TreeNode right;
		
		public TreeNode(int val){
			this.val = val;
		}
	}
	
	private TreeNode buildTree(String preorder) {
		
		if (preorder == null || preorder.isEmpty() || preorder.charAt(0) != '(') {
	        return null;
	    }
	    
	    int rootValEnd = preorder.indexOf(' ');
	    int rootVal = Integer.parseInt(preorder.substring(1, rootValEnd));
	    TreeNode root = new TreeNode(rootVal);
	    
	    if (findMatchingParenthesis(preorder, rootValEnd + 1) == -1) {
	    	root.left = null;
	    	root.right = null;
	    	return root;
	    }
	    int leftSubtreeEnd = findMatchingParenthesis(preorder, rootValEnd + 1);
	    String leftSubtree = extractSubtree(preorder, rootValEnd + 1, leftSubtreeEnd);
	    root.left = leftSubtree.equals("*") ? null : buildTree(leftSubtree);
	    
	    int rightSubtreeEnd = findMatchingParenthesis(preorder, leftSubtreeEnd + 1);
	    String rightSubtree = extractSubtree(preorder, leftSubtreeEnd + 1, rightSubtreeEnd);
	    root.right = rightSubtree.equals("*") ? null : buildTree(rightSubtree);
	    
	    return root;
	}

	private String extractSubtree(String preorder, int start, int end) {
		if (start > end) {
	        return "";
	    }
	    return preorder.substring(start, end + 1).trim();
	}
	
	private int findMatchingParenthesis(String preorder, int start) {
	    int count = 0;
	    for (int i = start; i < preorder.length(); i++) {
	        char c = preorder.charAt(i);
	        if (c == '(') {
	            count++;
	        } else if (c == ')') {
	            count--;
	            if (count == 0) {
	                return i;
	            }
	        }
	    }
	    return -1;
	}
	
	private TreeNode buildBalancedTree(int[] values, int start, int end) {
		if (start > end)
			return null;
		int mid = (start + end) / 2;
		TreeNode node = new TreeNode(values[mid]);
		node.left = buildBalancedTree(values, start, mid - 1);
		node.right = buildBalancedTree(values, mid + 1, end);
		return node;
	}
	
	public BinaryTree(String preorder) {
		this.root = buildTree(preorder);
	}
	
	public BinaryTree(ArrayList<Integer> values) {
		int[] valArr = new int[values.size()];
		for(int i = 0; i < values.size(); i++)
			valArr[i] = values.get(i);
		this.root = buildBalancedTree(valArr, 0, valArr.length - 1);
	}
	
	public void printIndented() {
		printIndented(root, 0);
	}
	
	private void printIndented(TreeNode node, int depth) {
		if (node == null)
			return;
		for (int i = 0; i < depth; i++)
			System.out.print("  ");
		System.out.println(node.val);
		printIndented(node.left, depth + 1);
		printIndented(node.right, depth + 1);
	}
	
	public int getHeight() {
		return height(root);
	}
	
	private int height(TreeNode node) {
		if (node == null) {
			return -1;
		}
		int leftHeight = height(node.left);
		int rightHeight = height(node.right);
		
		return Math.max(leftHeight, rightHeight) + 1;
	}
	
	public boolean isBalanced() {
		return checkBalance(root) != -1;
	}
	
	private int checkBalance(TreeNode node) {
		if (node == null)
			return 0;
		int leftHeight = checkBalance(node.left);
		if (leftHeight == -1)
			return -1;
		int rightHeight = checkBalance(node.right);
		if (rightHeight == -1 || Math.abs(leftHeight - rightHeight) > 1)
			return -1;
		return Math.max(leftHeight, rightHeight) + 1;
		
	}
	
	public boolean isValidBST() {
	    return isValidBST(root, Integer.MIN_VALUE, Integer.MAX_VALUE);
	}

	private boolean isValidBST(TreeNode node, int min, int max) {
	    if (node == null) {
	        return true;
	    }
	    if (node.val <= min || node.val >= max) {
	        return false;
	    }
	    return isValidBST(node.left, min, node.val) && isValidBST(node.right, node.val, max);
	}
	
	public ArrayList<Integer> getValues() {
		ArrayList<Integer> values = new ArrayList<>();
		preOrderTraversal(root, values);
		return values;
	}
	
	private void preOrderTraversal(TreeNode node, ArrayList<Integer> values) {
		if (node != null) {
			values.add(node.val);
			preOrderTraversal(node.left, values);
			preOrderTraversal(node.right, values);
		}
	}
	
	public void rebalance() {
	    ArrayList<Integer> sortedValues = new ArrayList<>();
	    collectValuesInOrder(root, sortedValues);
	    int[] sortedArray = sortedValues.stream().mapToInt(Integer::intValue).toArray();
	    this.root = buildBalancedTree(sortedArray, 0, sortedArray.length - 1);
	}

	private void collectValuesInOrder(TreeNode node, ArrayList<Integer> values) {
	    if (node == null) {
	        return;
	    }
	    collectValuesInOrder(node.left, values);
	    values.add(node.val);
	    collectValuesInOrder(node.right, values);
	}

}
