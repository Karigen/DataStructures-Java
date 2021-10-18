package binarysorttree;

public class BinarySortTreeDemo {

    public static void main(String[] args) {
	// TODO �Զ����ɵķ������
	int[] arr= {7, 3, 10, 12, 5, 1, 9, 2};
	BinarySortTree binarySortTree=new BinarySortTree();
	
	//ѭ������ӽ�㵽����������
	for (int i = 0; i < arr.length; i++) {
	    binarySortTree.add(new Node(arr[i]));
	}
	
	//�����������������
	System.out.println("�����������������");
	binarySortTree.infixOrder();//1�� 3�� 5�� 7�� 9�� 10�� 12
	
	//����һ��ɾ��Ҷ�ӽ��
	binarySortTree.delNode(2);
	//binarySortTree.delNode(5);
	//binarySortTree.delNode(9);
	//binarySortTree.delNode(12);
	binarySortTree.delNode(1);
	
	System.out.println("ɾ���ڵ��");
	binarySortTree.infixOrder();
    }

}

//��������������
class BinarySortTree{
    private Node root;
    
    //����Ҫɾ���Ľ��
    public Node search(int value) {
	if (root==null) {
	    return null;
	} else {
	    return root.search(value);
	}
    }
    
    //���Ҹ����
    public Node searchParent(int value) {
	if (root==null) {
	    return null;
	} else {
	    return root.searchParent(value);
	}
    }
    
    //ɾ���ڵ�
    public void delNode(int value) {
	if (root==null) {
	    return;
	} else {
	    //1.�������ҵ�Ҫɾ���Ľ�� targetNode
	    Node targetNode=search(value);
	    
	    //���û���ҵ�Ҫɾ���Ľ��
	    if (targetNode==null) {
		return;
	    }
	    
	    //������Ƿ��ֵ�ǰ��ö���������ֻ��һ�����
	    if (root.left==null&&root.right==null) {
		root=null;
		return;
	    }
	    
	    //ȥ�ҵ�targetNode�ĸ����
	    Node parent=searchParent(value);
	    
	    //���Ҫɾ���Ľ����Ҷ�ӽ��
	    if (targetNode.left==null&&targetNode.right==null) {
		//�ж�targetNode�Ǹ��������ӽ�㣬�������ӽ��
		if (parent.left!=null&&parent.left.value==value) {//�����ӽڵ�
		    parent.left=null;
		} else if (parent.right!=null&&parent.right.value==value) {//�����ӽڵ�
		    parent.right=null;
		}
	    }
	}
    }
    
    //��ӽ��ķ���
    public void add(Node node) {
	if (root==null) {
	    root=node;//���rootΪ����ֱ����rootָ��node
	} else {
	    root.add(node);
	}
    }
    
    //�������--�����Ǵ�С�����˳��
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
    
    //����Ҫɾ���Ľ��
    /**
     * 
     * @param value ϣ��ɾ���Ľ���ֵ
     * @return ����ҵ��ͷ��ظý�㣬���򷵻�null
     */
    public Node search(int value) {
	if (value==this.value) {//�ҵ������Ǹý��
	    return this;
	} else if (value<this.value) {//������ҵ�ֵС�ڵ�ǰ��㣬���������ݹ����
	    //������ӽ��Ϊ��
	    if (this.left==null) {
		return null;
	    }
	    
	    return this.left.search(value);
	} else {//������ҵ�ֵ���ڵ�ǰ��㣬���������ݹ����
	    if (this.right==null) {
		return null;
	    }
	    
	    return this.right.search(value);
	}
    }
    
    //����Ҫɾ�����ĸ����
    /**
     * 
     * @param value Ҫ�ҵĽ���ֵ
     * @return ���ص���Ҫɾ�����ĸ���㣬���û�оͷ���null
     */
    public Node searchParent(int value) {
	//�����ǰ������Ҫɾ�����ĸ���㣬�ͷ���
	if ((	this.left!=null&&this.left.value==value)||(
		this.right!=null&&this.right.value==value)) {
	    return this;
	} else {
	    //������ҵ�ֵС�ڵ�ǰ����ֵ�����ҵ�ǰ�������ӽ�㲻Ϊ��
	    if (value<this.value&&this.left!=null) {
		return this.left.searchParent(value);//���������ݹ����
	    } else if (value>=this.value&&this.right!=null) {
		return this.right.searchParent(value);//���������ݹ����
	    } else {
		return null;//û���ҵ������
	    }
	}
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
	} else {//��ӵĽ���ֵ���ڵ�ǰ����ֵ�����ߵ��ڣ�
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