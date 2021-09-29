package tree;

/*
 * ��������ǰ�����򣬺���ı�������
 * 
 * 1.����һ�ö�����
 * 2.ǰ���������������ڵ㣬�ٱ�����������������
 *  2.1�������ǰ�ڵ㣨��ʼ��ʱ����root�ڵ㣩
 *  2.2������ӽڵ㲻Ϊ�գ���ݹ����ǰ�����
 *  2.3������ӽڵ㲻Ϊ�գ���ݹ����ǰ�����
 *  
 * 3.����������ȱ�������������������ڵ㣬�ٱ���������
 *  3.1�����ǰ�ڵ�����ӽڵ㲻Ϊ�գ���ݹ��������
 *  3.2�����ǰ�ڵ�
 *  3.3�����ǰ�ڵ�����ӽڵ㲻Ϊ�գ���ݹ��������
 *  
 * 4.ǰ��������ȱ������������ٱ��������������������ڵ�
 *  4.1�����ǰ�ڵ�����ӽڵ㲻Ϊ�գ���ݹ�������
 *  4.2�����ǰ�ڵ�����ӽڵ㲻Ϊ�գ���ݹ�������
 *  4.3�����ǰ�ڵ�
 *  
 * С�᣺��������ڵ��˳�򣬾�ȷ����ǰ�������Ǻ���
 */

public class BinaryTreeDemo {

    public static void main(String[] args) {
	//����Ҫ����һ�ö�����
	BinaryTree binaryTree=new BinaryTree();
	
	//������Ҫ�Ľڵ�
	HeroNode node1=new HeroNode(1, "�ν�");
	HeroNode node2=new HeroNode(2, "����");
	HeroNode node3=new HeroNode(3, "¬����");
	HeroNode node4=new HeroNode(4, "�ֳ�");
	HeroNode node5=new HeroNode(5, "��ʤ");
	
	//˵�����������ֶ������ö���������������ѧϰ�Եݹ�ķ�ʽ����������
	node1.setLeft(node2);
	node1.setRight(node3);
	node3.setLeft(node5);
	node3.setRight(node4);
	
	binaryTree.setRoot(node1);
	
	//����
	System.out.println("ǰ�����");//1�� 2�� 3�� 5�� 4
	binaryTree.preOrder();
	
	//����
	System.out.println("�������");//2�� 1�� 5�� 3�� 4
	binaryTree.infixOrder();
	
	//����
	System.out.println("�������");//2�� 5�� 4�� 3�� 1
	binaryTree.postOrder();
    }

}

//����BinaryTree ������
class BinaryTree {
    private HeroNode root;

    public void setRoot(HeroNode root) {
        this.root = root;
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
}

//�ȴ���HeroNode�ڵ�
class HeroNode {
    private int no;
    private String name;
    private HeroNode left;//Ĭ��null
    private HeroNode right;//Ĭ��null
    
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
}
