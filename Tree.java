package algorithm;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

/**
 * @author Allen
 * @version 2016��9��14�� ����3:12:10 ��˵��
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
		//��ȱ���
//		depthFirstTraversa(root);
		//��ȱ���
//		breadthFirstSearch(root);
		//ǰ�����=��ȱ���
//		firstSearch(root);
//		firstSearch1(root);
		//�������
		midSearch(root);
		System.out.println();
		midSearch1(root);
		//�������

	}

	private static void midSearch(TreeNode root)
	{
		/*�ݹ�ʵ��*/
		if(root==null)
		{
//			System.out.println("����");
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
		/*�ǵݹ�ʵ��
		 * 1�����һ����ѹ��ջ��
		 * 2������һ��Ԫ�أ�����ӡ
		 * 3����鵯����Ԫ���Ƿ������������еĻ�������Ϊһ�����ظ�����1*/
		if(root==null)
		{
			System.out.println("����");
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
		/*�ݹ�ʵ��*/
		if(root==null)
		{
//			System.out.println("����");
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
		/*�ǵݹ�ʵ��*/
		if(root==null)
		{
			System.out.println("����");
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
			System.out.println("����");
			return;
		}
		 Queue<TreeNode> qu=new LinkedList<TreeNode>();//�����ռ�--����
		 TreeNode last=root;//��һ�ζ����������ӵ�Ԫ��
		 TreeNode nlast=root;//��ǰ�����������ӵ�Ԫ��
		
		qu.add(root);
		while(!qu.isEmpty())
		{
			TreeNode tmp=qu.poll();
			System.out.print(tmp.val+" ");
			if(tmp==last)//�ֲ��ӡ������(�����ǰ��ӡ�Ľڵ��������ӵĽڵ㣬Ҳ���Ǹò����һ���ڵ㣩
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
		Stack<TreeNode> stack=new Stack<TreeNode>();//�����ռ�--->ջ
		if(root==null)
		{
			System.out.println("����");
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
