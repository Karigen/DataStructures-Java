package tree.huffmantree;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/*
 * 构成赫夫曼树的步骤
 * 1.从小到大进行排序，将每一个数据，每个数据都是一个节点，每个节点看成是一棵最简单的二叉树
 * 2.取出根节点权值最小的两棵二叉树
 * 3.组成一棵新的二叉树，该新的二叉树的根节点的权值是前面两棵二叉树根节点权值的和
 * 4.再将这课二叉树，以根节点的权值大小再次排序，不断重复1-2-3-4的步骤，直到数列中，所有的数据都被处理，就得到一棵赫夫曼树
 */

public class HuffmanTree {

    public static void main(String[] args) {
	int[] arr= {13, 7, 8, 3, 29, 6, 1};
	Node root=createHuffmanTree(arr);
	
	//测试一把
	preOrder(root);//
    }
    
    //编写一个前序遍历的方法
    public static void preOrder(Node root) {
	if (root!=null) {
	    root.preOrder();
	} else {
	    System.out.println("是空树，不能遍历");
	}
    }
    
    //创建赫夫曼树的方法
    /**
     * 
     * @param arr 需要创建成赫夫曼树的数组
     * @return 创建好后的赫夫曼树的root节点
     */
    public static Node createHuffmanTree(int[] arr) {
	//第一步为了操作方便
	//1.遍历arr数组
	//2.将arr的每个元素构成一个Node
	//3.将Node放入到ArrayList中
	List<Node> nodes=new ArrayList<Node>();
	for (int value : arr) {
	    nodes.add(new Node(value));
	}
	
	//我们处理的过程是一个循环的过程
	while (nodes.size()>1) {
	    //排序 从小到大
	    Collections.sort(nodes);
	    
	    System.out.println("nodes ="+nodes);
	
	    //取出根节点权值最小的两棵二叉树
	    //1.取出权值最小的节点（二叉树）
	    Node leftNode=nodes.get(0);
	
	    //2.取出权值次小的节点（二叉树）
	    Node rightNode=nodes.get(1);
	
	    //3.构建一棵新的二叉树
	    Node parent=new Node(leftNode.value+rightNode.value);
	    parent.left=leftNode;
	    parent.right=rightNode;
	
	    //4.从ArrayList删除处理过的二叉树
	    nodes.remove(leftNode);
	    nodes.remove(rightNode);
	
	    //5.将parent加入到nodes
	    nodes.add(parent);
	}
	
	//返回赫夫曼树的root节点
	return nodes.get(0);
    }
}

//创建节点类
//为了让Node对象支持排序Collections集合排序
//让Node实现Comparable接口
class Node implements Comparable<Node> {
    int value;//节点权值
    Node left;//指向左子节点
    Node right;//指向右子节点
    
    //写一个前序遍历
    public void preOrder() {
	System.out.println(this);
	
	if (this.left!=null) {
	    this.left.preOrder();
	}
	
	if (this.right!=null) {
	    this.right.preOrder();
	}
    }
    
    public Node(int value) {
	this.value = value;
    }

    @Override
    public String toString() {
	return "Node [value=" + value + "]";
    }

    @Override
    public int compareTo(Node o) {
	// TODO 自动生成的方法存根
	//表示从小到大进行排序
	return this.value-o.value;
    }
    
    
}