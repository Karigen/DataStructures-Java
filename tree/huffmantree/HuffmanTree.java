package tree.huffmantree;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/*
 * ���ɺշ������Ĳ���
 * 1.��С����������򣬽�ÿһ�����ݣ�ÿ�����ݶ���һ���ڵ㣬ÿ���ڵ㿴����һ����򵥵Ķ�����
 * 2.ȡ�����ڵ�Ȩֵ��С�����ö�����
 * 3.���һ���µĶ����������µĶ������ĸ��ڵ��Ȩֵ��ǰ�����ö��������ڵ�Ȩֵ�ĺ�
 * 4.�ٽ���ζ��������Ը��ڵ��Ȩֵ��С�ٴ����򣬲����ظ�1-2-3-4�Ĳ��裬ֱ�������У����е����ݶ��������͵õ�һ�úշ�����
 */

public class HuffmanTree {

    public static void main(String[] args) {
	int[] arr= {13, 7, 8, 3, 29, 6, 1};
	Node root=createHuffmanTree(arr);
	
	//����һ��
	preOrder(root);//
    }
    
    //��дһ��ǰ������ķ���
    public static void preOrder(Node root) {
	if (root!=null) {
	    root.preOrder();
	} else {
	    System.out.println("�ǿ��������ܱ���");
	}
    }
    
    //�����շ������ķ���
    /**
     * 
     * @param arr ��Ҫ�����ɺշ�����������
     * @return �����ú�ĺշ�������root�ڵ�
     */
    public static Node createHuffmanTree(int[] arr) {
	//��һ��Ϊ�˲�������
	//1.����arr����
	//2.��arr��ÿ��Ԫ�ع���һ��Node
	//3.��Node���뵽ArrayList��
	List<Node> nodes=new ArrayList<Node>();
	for (int value : arr) {
	    nodes.add(new Node(value));
	}
	
	//���Ǵ���Ĺ�����һ��ѭ���Ĺ���
	while (nodes.size()>1) {
	    //���� ��С����
	    Collections.sort(nodes);
	    
	    System.out.println("nodes ="+nodes);
	
	    //ȡ�����ڵ�Ȩֵ��С�����ö�����
	    //1.ȡ��Ȩֵ��С�Ľڵ㣨��������
	    Node leftNode=nodes.get(0);
	
	    //2.ȡ��Ȩֵ��С�Ľڵ㣨��������
	    Node rightNode=nodes.get(1);
	
	    //3.����һ���µĶ�����
	    Node parent=new Node(leftNode.value+rightNode.value);
	    parent.left=leftNode;
	    parent.right=rightNode;
	
	    //4.��ArrayListɾ��������Ķ�����
	    nodes.remove(leftNode);
	    nodes.remove(rightNode);
	
	    //5.��parent���뵽nodes
	    nodes.add(parent);
	}
	
	//���غշ�������root�ڵ�
	return nodes.get(0);
    }
}

//�����ڵ���
//Ϊ����Node����֧������Collections��������
//��Nodeʵ��Comparable�ӿ�
class Node implements Comparable<Node> {
    int value;//�ڵ�Ȩֵ
    Node left;//ָ�����ӽڵ�
    Node right;//ָ�����ӽڵ�
    
    //дһ��ǰ�����
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
	// TODO �Զ����ɵķ������
	//��ʾ��С�����������
	return this.value-o.value;
    }
    
    
}