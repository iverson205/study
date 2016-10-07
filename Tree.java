package algorithm;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

/**
 * @author Allen
 * @version 2016年9月14日 下午3:12:10 类说明
 */

class TreeNode
{
	int val = 0;
	TreeNode left;
	TreeNode right;

	public TreeNode(int val)
	{
		this.val = val;
	}
}

public class Tree
{

	public static void main(String[] args)
	{
		TreeNode root=bulidTree();
		//深度遍历
//		depthFirstTraversa(root);
		//广度遍历
//		breadthFirstSearch(root);
		//前序遍历=深度遍历
//		firstSearch(root);
//		firstSearch1(root);
		//中序遍历
		midSearch(root);
		System.out.println();
		midSearch1(root);
		//后序遍历

	}

	private static void midSearch(TreeNode root)
	{
		/*递归实现*/
		if(root==null)
		{
//			System.out.println("空树");
			return;
		}
		else 
		{			
			midSearch(root.left);
			System.out.print(root.val+" ");
			midSearch(root.right);
		}
		
	}
	private static void midSearch1(TreeNode root)
	{
		/*非递归实现
		 * 1，左边一条线压入栈，
		 * 2，弹出一个元素，并打印
		 * 3，检查弹出的元素是否有右子树，有的话将其作为一棵树重复步骤1*/
		if(root==null)
		{
			System.out.println("空树");
			return;
		}
		Stack<TreeNode> stack=new Stack<TreeNode>();

		while(!stack.isEmpty()||root!=null)
		{
			if(root!=null)
			{
				stack.push(root);
				root=root.left;
			}
			else
			{				
				root=stack.pop();
				System.out.print(root.val+" ");				
				root=root.right;
			}
		}
		
	}

	private static void firstSearch(TreeNode root)
	{
		/*递归实现*/
		if(root==null)
		{
//			System.out.println("空树");
			return;
		}
		else 
		{			
			System.out.print(root.val+" ");
			firstSearch(root.left);
			firstSearch(root.right);
		}
	}
	
	private static void firstSearch1(TreeNode root)
	{
		/*非递归实现*/
		if(root==null)
		{
			System.out.println("空树");
			return;
		}
		Stack<TreeNode> stack=new Stack<TreeNode>();
		stack.push(root);
		while(!stack.isEmpty())
		{
			TreeNode tmp=stack.pop();			
			System.out.print(tmp.val+" ");
			
			if(tmp.right!=null)
				stack.push(tmp.right);
			
			if(tmp.left!=null)
				stack.push(tmp.left);
		}
	}

	private static void breadthFirstSearch(TreeNode root)
	{
		if(root==null)
		{
			System.out.println("空树");
			return;
		}
		 Queue<TreeNode> qu=new LinkedList<TreeNode>();//辅助空间--队列
		 TreeNode last=root;//上一次队列中最后进队的元素
		 TreeNode nlast=root;//当前队列中最后进队的元素
		
		qu.add(root);
		while(!qu.isEmpty())
		{
			TreeNode tmp=qu.poll();
			System.out.print(tmp.val+" ");
			if(tmp==last)//分层打印，换行(如果当前打印的节点是最后进队的节点，也就是该层最后一个节点）
				System.out.println();
			last=nlast;
			if(tmp.left!=null)
				{
					qu.add(tmp.left);
					nlast=tmp.left;
				}
			if(tmp.right!=null)
				{
					qu.add(tmp.right);
					nlast=tmp.right;
				}
		}
	}

	private static void depthFirstTraversa(TreeNode root)
	{
		Stack<TreeNode> stack=new Stack<TreeNode>();//辅助空间--->栈
		if(root==null)
		{
			System.out.println("空树");
			return;
		}
		stack.push(root);
		
		while(!stack.isEmpty())
		{
			TreeNode temp=stack.pop();
			System.out.print(temp.val+" ");
			if(temp.right!=null)
				stack.push(temp.right);			
			if(temp.left!=null)
				stack.push(temp.left);
		}
		

	}

	private static TreeNode  bulidTree()
	{
				
		TreeNode[] root=new TreeNode[6];
		for(int i=0;i<6;i++)
		{
			root[i]=new TreeNode(i+1);
		}
		
		root[0].left=root[1];
		root[0].right=root[2];
		root[1].left=root[3];
		root[1].right=root[4];
		root[2].right=root[5];
		
		return root[0];
		
	}

}
