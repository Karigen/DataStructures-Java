package binarysorttree;

public class BinarySortTreeDemo {

    public static void main(String[] args) {
	// TODO �Զ����ɵķ������
	int[] arr= {7, 3, 10, 12, 5, 1, 9};
	BinarySortTree binarySortTree=new BinarySortTree();
	
	//ѭ������ӽ�㵽����������
	for (int i = 0; i < arr.length; i++) {
	    binarySortTree.add(new Node(arr[i]));
	}
	
	//�����������������
	System.out.println("�����������������");
	binarySortTree.infixOrder();//1�� 3�� 5�� 7�� 9�� 10�� 12
    }

}

//��������������
class BinarySortTree{
    private Node root;
    
    //��ӽ��ķ���
    public void add(Node node) {
	if (root==null) {
	    root=node;//���rootΪ����ֱ����rootָ��node
	} else {
	    root.add(node);
	}
    }
    
    //�������
    public void infixOrder() {
	if (root!=null) {
	    root.infixOrder();
	} else {
	    System.out.println("����������Ϊ�գ����ܱ���");
	}
    }
}

//����Node���
class Node{
    int value;
    Node left;
    Node right;
    
    public Node(int value) {
	super();
	this.value = value;
    }
    
    @Override
    public String toString() {
	return "Node [value=" + value + "]";
    }

    //��ӽ��ķ���
    //�ݹ����ʽ��ӽ�㣬ע�����������������Ҫ��
    public void add(Node node) {
	if (node==null) {
	    return;
	}
	
	//�жϴ���Ľ���ֵ���͵�ǰ�����ĸ�����ֵ�Ĺ�ϵ
	if (node.value<this.value) {
	    //�����ǰ�������ӽ��Ϊnull
	    if (this.left==null) {
		this.left=node;
	    } else {
		//�ݹ�������������
		this.left.add(node);
	    }
	} else {//��ӵĽ���ֵ���ڵ�ǰ����ֵ
	    if (this.right==null) {
		this.right=node;
	    } else {
		//�ݹ�������������
		this.right.add(node);
	    }
	}
    }
    
    //�������
    public void infixOrder() {
	if (this.left!=null) {
	    this.left.infixOrder();
	}
	
	System.out.println(this);
	
	if (this.right!=null) {
	    this.right.infixOrder();
	}
    }
}