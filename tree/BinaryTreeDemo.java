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
 * 
 * ǰ�����˼·
 * 1.���жϵ�ǰ�ڵ��no�Ƿ����Ҫ���ҵ�
 * 2.�������ȣ��򷵻ص�ǰ�ڵ�
 * 3.������ȣ����жϵ�ǰ�ڵ�����ӽڵ��Ƿ�Ϊ�գ�������գ���ݹ�ǰ�����
 * 4.�����ݹ�ǰ����ң��ҵ��ڵ㣬�򷵻أ���������жϣ���ǰ�ڵ�����ӽڵ��Ƿ�Ϊ�գ�������գ���������ҵݹ�ǰ�����
 * 
 * �������˼·
 * 1.�жϵ�ǰ�ڵ�����ӽڵ��Ƿ�Ϊ�գ�������գ���ݹ��������
 * 2.����ҵ����򷵻أ����û���ҵ����ͺ͵�ǰ�ڵ�Ƚϣ�������򷵻ص�ǰ�ڵ㣬������������ҵݹ���������
 * 3.����ҵݹ�������ң��ҵ��ͷ��أ����򷵻�null
 * 
 * ��������˼·
 * 1.�жϵ�ǰ�ڵ�����ӽڵ��Ƿ�Ϊ�գ������Ϊ�գ���ݹ��������
 * 2.����ҵ����ͷ��أ����û���ҵ������жϵ�ǰ�ڵ�����ӽڵ��Ƿ�Ϊ�գ������Ϊ�գ����ҵݹ���к�����ң�����ҵ����ͷ���
 * 3.�ͺ͵�ǰ�ڵ���бȽϣ�������򷵻أ����򷵻�null
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
	
	/*
	
	//ǰ�����
	//ǰ������Ĵ�����4
	System.out.println("ǰ�������ʽ��");
	HeroNode resNode=binaryTree.preOrderSearch(5);
	if (resNode!=null) {
	    System.out.printf("�ҵ��ˣ���ϢΪno=%d name=%s",resNode.getNo(),resNode.getName());
	} else {
	    System.out.printf("û���ҵ�no=%d��Ӣ��",5);
	}
	
	
	
	//�����������
	//�������3��
	System.out.println("���������ʽ��");
	HeroNode resNode=binaryTree.infixOrderSearch(5);
	if (resNode!=null) {
	    System.out.printf("�ҵ��ˣ���ϢΪno=%d name=%s",resNode.getNo(),resNode.getName());
	} else {
	    System.out.printf("û���ҵ�no=%d��Ӣ��",5);
	}
	
	*/
	
	//�����������
	//����������ҵĴ��� 2��
	System.out.println("���������ʽ��");
	HeroNode resNode=binaryTree.postOrderSearch(2);
	if (resNode!=null) {
	    System.out.printf("�ҵ��ˣ���ϢΪno=%d name=%s",resNode.getNo(),resNode.getName());
	} else {
	    System.out.printf("û���ҵ�no=%d��Ӣ��",2);
	}
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
