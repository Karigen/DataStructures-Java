package tree.threadedbinarytree;

/*
 * һ���ڵ�ĵ�ǰһ���ڵ㣬��Ϊǰ���ڵ�
 * һ���ڵ�ĵĺ�һ���ڵ㣬��Ϊ��̽ڵ�
 */

public class ThreadedBinaryTreeDemo {

    public static void main(String[] args) {
	//����һ�����������������Ĺ���
	HeroNode node1=new HeroNode(1, "tom");
	HeroNode node2=new HeroNode(3, "jack");
	HeroNode node3=new HeroNode(6, "smith");
	HeroNode node4=new HeroNode(8, "mary");
	HeroNode node5=new HeroNode(10, "king");
	HeroNode node6=new HeroNode(14, "dim");
	
	//����������������Ҫ�ݹ鴴�������ڼ򵥴���ʹ���ֶ�����
	node1.setLeft(node2);
	node1.setRight(node3);
	node2.setLeft(node4);
	node2.setRight(node5);
	node3.setLeft(node6);
	
	//����������
	ThreadedBinaryTree threadedBinaryTree=new ThreadedBinaryTree();
	threadedBinaryTree.setRoot(node1);
	threadedBinaryTree.threadedNodes();
	
	//���ԣ���10�Žڵ����
	HeroNode leftNode=node5.getLeft();
	HeroNode rightNode=node5.getRight();
	System.out.println("10�Žڵ��ǰ���ڵ���="+leftNode);//3
	System.out.println("10�Žڵ�ĺ�̽ڵ���="+rightNode);//1
	
	//���������������󣬲�����ʹ��ԭ���ı�������
	//threadedBinaryTree.infixOrder();
	System.out.println("ʹ���������ķ�ʽ���� ������������");
	threadedBinaryTree.threadedList();//8, 3, 10, 1, 14, 6
    }

}

//����ThreadedBinaryTree ʵ�������������ܵĶ�����
class ThreadedBinaryTree {
    private HeroNode root;
    
    //Ϊ��ʵ������������Ҫ����һ��ָ��ǰ�ڵ��ǰ���ڵ��ָ��
    //�ڵݹ����������ʱpre���Ǳ���ǰһ���ڵ�
    private HeroNode pre=null;

    public void setRoot(HeroNode root) {
        this.root = root;
    }
    
    //����threadedNodes����
    public void threadedNodes() {
	this.threadedNodes(root);
    }
    
    //�����������������ķ���
    public void threadedList() {
	//����һ���������洢��ǰ�����Ľڵ㣬��root��ʼ
	HeroNode node=root;
	while (node!=null) {
	    //ѭ�����ҵ�leftType == 1�Ľڵ㣬��һ���ҵ�����8�ڵ�
	    //�������ű������仯����Ϊ��leftType == 1ʱ��˵���ýڵ���ǰ�����������������Ч�ڵ�
	    while (node.getLeftType()==0) {
		node=node.getLeft();
	    }
	    
	    //��ӡ��ǰ����ڵ�
	    System.out.println(node);
	    
	    //�����ǰ�ڵ����ָ��ָ���ʱ��̽ڵ㣬��һֱ���
	    while (node.getRightType()==1) {
		//��ȡ����ǰ�ڵ�ĺ�̽ڵ�
		node=node.getRight();
		System.out.println(node);
	    }
	    
	    //�滻��������Ľڵ�
	    node=node.getRight();
	}
    }
    
    //��д�Զ��������������������ķ���
    /**
     * 
     * @param node ���ǵ�ǰ��Ҫ�������Ľڵ�
     */
    public void threadedNodes(HeroNode node) {
	//���node==null������������
	if (node==null) {
	    return;
	}
	
	//��һ����������������
	threadedNodes(node.getLeft());
	
	//��������������ǰ�ڵ�[���Ѷ�]
	
	//����ǰ�ڵ��ǰ���ڵ�
	if (node.getLeft()==null) {
	    //�õ�ǰ�ڵ����ָ��ָ��ǰ���ڵ�
	    node.setLeft(pre);
	    
	    //�޸ĵ�ǰ�ڵ���ָ������ͣ�ָ��ǰ���ڵ�
	    node.setLeftType(1);
	}
	
	//�����̽ڵ�
	if (pre!=null&&pre.getRight()==null) {
	    //��ǰ���ڵ����ָ��ָ��ǰ�ڵ�
	    pre.setRight(node);
	    //�޸�ǰ���ڵ����ָ������
	    pre.setRightType(1);
	}
	
	//ÿ����һ���ڵ���õ�ǰ�ڵ�����һ���ڵ��ǰ���ڵ�
	pre=node;
	
	//��������������������
	threadedNodes(node.getRight());
    }
    
    //ɾ���ڵ�
    public void delNode(int no) {
	if (root!=null) {
	    //���ֻ��rootһ���ڵ㣬������Ҫ�����ж�root�ǲ��Ǿ���Ҫɾ���Ľڵ�
	    if (root.getNo()==no) {
		root=null;
	    } else {
		//�ݹ�ɾ��
		root.delNode(no);
	    }
	} else {
	    System.out.println("����������ɾ��");
	}
    }
    
    //ǰ�����
    public void preOrder() {
	if (this.root!=null) {
	    this.root.preOrder();
	} else {
	    System.out.println("������Ϊ�գ��޷�����");
	}
    }
    
    //�������
    public void infixOrder() {
	if (this.root!=null) {
	    this.root.infixOrder();
	} else {
	    System.out.println("������Ϊ�գ��޷�����");
	}
    }
    
    //�������
    public void postOrder() {
	if (this.root!=null) {
	    this.root.postOrder();
	} else {
	    System.out.println("������Ϊ�գ��޷�����");
	}
    }
    
    //ǰ�����
    public HeroNode preOrderSearch(int no) {
	if (root!=null) {
	    return root.preOrderSearch(no);
	} else {
	    return null;
	}
    }
    
    //�������
    public HeroNode infixOrderSearch(int no) {
	if (root!=null) {
	    return root.infixOrderSearch(no);
	} else {
	    return null;
	}
    }
    
    //�������
    public HeroNode postOrderSearch(int no) {
	if (root!=null) {
	    return root.postOrderSearch(no);
	} else {
	    return null;
	}
    }
}

//����HeroNode
class HeroNode {
    private int no;
    private String name;
    private HeroNode left;//Ĭ��null
    private HeroNode right;//Ĭ��null
    
    //˵��
    //1.���leftType == 0��ʾָ������������������1�����ָ��ǰ���ڵ�
    //2.���rightType == 0��ʾָ������������������1�����ָ���̽ڵ�
    private int leftType;
    private int rightType;
    
    public int getLeftType() {
        return leftType;
    }

    public void setLeftType(int leftType) {
        this.leftType = leftType;
    }

    public int getRightType() {
        return rightType;
    }

    public void setRightType(int rightType) {
        this.rightType = rightType;
    }

    public HeroNode(int no, String name) {
	super();
	this.no = no;
	this.name = name;
    }

    public int getNo() {
        return no;
    }

    public void setNo(int no) {
        this.no = no;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public HeroNode getLeft() {
        return left;
    }

    public void setLeft(HeroNode left) {
        this.left = left;
    }

    public HeroNode getRight() {
        return right;
    }

    public void setRight(HeroNode right) {
        this.right = right;
    }

    @Override
    public String toString() {
	return "HeroNode [no=" + no + ", name=" + name + "]";
    }
    
    //�ݹ�ɾ���ڵ�
    //1.���ɾ���Ľڵ���Ҷ�ӽڵ㣬��ɾ���ýڵ�
    //2.���ɾ���Ľڵ��Ƿ�Ҷ�ӽڵ㣬��ɾ��������
    public void delNode(int no) {
	//˼·
	//1.��Ϊ���ǵĶ������ǵ���ģ������������жϵ�ǰ�ڵ���ӽڵ������Ҫɾ���ڵ㣬������ȥ�жϵ�ǰ����ڵ��ǲ�����Ҫɾ���ڵ�
	//2.�����ǰ�ڵ�����ӽڵ㲻Ϊ�գ��������ӽڵ����Ҫɾ���Ľڵ㣬�ͽ�this.left=null;���Ҿͷ��أ������ݹ�ɾ����
	//3.�����ǰ�ڵ�����ӽڵ㲻Ϊ�գ��������ӽڵ����Ҫɾ���Ľڵ㣬�ͽ�this.right=null;���Ҿͷ��أ������ݹ�ɾ����
	//4.�����2�͵�3��û��ɾ���ڵ㣬��ô���Ǿ���Ҫ�����������еݹ�ɾ��
	//5.�����4��Ҳû��ɾ���ڵ㣬��Ӧ�������������еݹ�ɾ��
	
	//2.�����ǰ�ڵ�����ӽڵ㲻Ϊ�գ��������ӽڵ����Ҫɾ���Ľڵ㣬�ͽ�this.left=null;���Ҿͷ��أ������ݹ�ɾ����
	if (this.left!=null&&this.left.no==no) {
	    this.left=null;
	    return;
	}
	
	//3.�����ǰ�ڵ�����ӽڵ㲻Ϊ�գ��������ӽڵ����Ҫɾ���Ľڵ㣬�ͽ�this.right=null;���Ҿͷ��أ������ݹ�ɾ����
	if (this.right!=null&&this.right.no==no) {
	    this.right=null;
	    return;
	}
	
	//4.�����2�͵�3��û��ɾ���ڵ㣬��ô���Ǿ���Ҫ�����������еݹ�ɾ��
	if (this.left!=null) {
	    this.left.delNode(no);
	}
	
	//5.�����4��Ҳû��ɾ���ڵ㣬��Ӧ�������������еݹ�ɾ��
	if (this.right!=null) {
	    this.right.delNode(no);
	}
    }
    
    //��дǰ������ķ���
    public void preOrder() {
	System.out.println(this);//��������ڵ�
	
	//�ݹ���������ǰ�����
	if (this.left!=null) {
	    this.left.preOrder();
	}
	
	//�ݹ���������ǰ�����
	if (this.right!=null) {
	    this.right.preOrder();
	}
    }
    
    //��д��������ķ���
    public void infixOrder() {
	//�ݹ����������������
	if (this.left!=null) {
	    this.left.infixOrder();
	}
	
	//������ڵ�
	System.out.println(this);
	
	//�ݹ����������������
	if (this.right!=null) {
	    this.right.infixOrder();
	}
    }
    
    //��д��������ķ���
    public void postOrder() {
	if (this.left!=null) {
	    this.left.postOrder();
	}
	
	if (this.right!=null) {
	    this.right.postOrder();
	}
	
	System.out.println(this);
    }
    
    //ǰ���������
    /**
     * 
     * @param no ����no
     * @return ����ҵ��ͷ��ظ�node�����û���ҵ��ͷ���null
     */
    public HeroNode preOrderSearch(int no) {
	System.out.println("����ǰ�����");
	
	//�ȱȽϵ�ǰ�ڵ��ǲ���
	if (this.no==no) {
	    return this;
	}
	
	//1.���жϵ�ǰ�ڵ�����ӽڵ��Ƿ�Ϊ�գ�������գ���ݹ�ǰ�����
	//2.�����ݹ�ǰ����ң��ҵ��ڵ㣬�򷵻�
	HeroNode resNode=null;
	if (this.left!=null) {
	    resNode=this.left.preOrderSearch(no);
	}
	
	if (resNode!=null) {//˵�������������ҵ�
	    return resNode;
	}
	
	//1.��ݹ�ǰ����ң��ҵ��ڵ㣬�򷵻أ���������жϣ�
	//2.��ǰ�ڵ�����ӽڵ��Ƿ�Ϊ�գ�������գ���������ҵݹ�ǰ�����
	if (this.right!=null) {
	    resNode=this.right.preOrderSearch(no);
	}
	
	return resNode;
    }
    
    //�����������
    public HeroNode infixOrderSearch(int no) {
	//�жϵ�ǰ�ڵ�����ӽڵ��Ƿ�Ϊ�գ�������գ���ݹ��������
	HeroNode resNode=null;
	if (this.left!=null) {
	    resNode=this.left.infixOrderSearch(no);
	}
	
	if (resNode!=null) {
	    return resNode;
	}
	
	System.out.println("�����������");
	
	//����ҵ����򷵻أ����û���ҵ����ͺ͵�ǰ�ڵ�Ƚϣ�������򷵻ص�ǰ�ڵ�
	if (this.no==no) {
	    return this;
	}
	
	//������������ҵݹ���������
	if (this.right!=null) {
	    resNode=this.right.infixOrderSearch(no);
	}
	
	return resNode;
    }
    
    //�����������
    public HeroNode postOrderSearch(int no) {
	//�жϵ�ǰ�ڵ�����ӽڵ��Ƿ�Ϊ�գ������Ϊ�գ���ݹ��������
	HeroNode resNode=null;
	if (this.left!=null) {
	    resNode=this.left.postOrderSearch(no);
	}
	
	if (resNode!=null) {//˵�����������ҵ�
	    return resNode;
	}
	
	//���������û���ҵ��������������ݹ���к�����������
	if (this.right!=null) {
	    resNode=this.right.postOrderSearch(no);
	}
	
	if (resNode!=null) {
	    return resNode;
	}
	
	System.out.println("����������");
	
	//�������������û���ҵ����ͱȽϵ�ǰ���ڵ��ǲ���
	if (this.no==no) {
	    return this;
	}
	
	return resNode;
    }
}
