package tree;

/*
 * 二叉树的前序，中序，后序的遍历步骤
 * 
 * 1.创建一棵二叉树
 * 2.前序遍历：先输出父节点，再遍历左子树和右子树
 *  2.1先输出当前节点（初始的时候是root节点）
 *  2.2如果左子节点不为空，则递归继续前序遍历
 *  2.3如果右子节点不为空，则递归继续前序遍历
 *  
 * 3.中序遍历：先遍历左子树，再输出父节点，再遍历右子树
 *  3.1如果当前节点的左子节点不为空，则递归中序遍历
 *  3.2输出当前节点
 *  3.3如果当前节点的右子节点不为空，则递归中序遍历
 *  
 * 4.前序遍历：先遍历左子树，再遍历右子树，最后输出父节点
 *  4.1如果当前节点的左子节点不为空，则递归后序遍历
 *  4.2如果当前节点的右子节点不为空，则递归后序遍历
 *  4.3输出当前节点
 *  
 * 小结：看输出父节点的顺序，就确定是前序，中序还是后序
 * 
 * 前序查找思路
 * 1.先判断当前节点的no是否等于要查找的
 * 2.如果是相等，则返回当前节点
 * 3.如果不等，则判断当前节点的左子节点是否为空，如果不空，则递归前序查找
 * 4.如果左递归前序查找，找到节点，则返回，否则继续判断，当前节点的右子节点是否为空，如果不空，则继续向右递归前序查找
 * 
 * 中序遍历思路
 * 1.判断当前节点的左子节点是否为空，如果不空，则递归中序查找
 * 2.如果找到，则返回，如果没有找到，就和当前节点比较，如果是则返回当前节点，否则继续进行右递归的中序查找
 * 3.如果右递归中序查找，找到就返回，否则返回null
 * 
 * 后续查找思路
 * 1.判断当前节点的左子节点是否为空，如果不为空，则递归后续查找
 * 2.如果找到，就返回，如果没有找到，就判断当前节点的右子节点是否为空，如果不为空，则右递归进行后序查找，如果找到，就返回
 * 3.就和当前节点进行比较，如果是则返回，否则返回null
 */

public class BinaryTreeDemo {

    public static void main(String[] args) {
	//先需要创建一棵二叉树
	BinaryTree binaryTree=new BinaryTree();
	
	//创建需要的节点
	HeroNode node1=new HeroNode(1, "宋江");
	HeroNode node2=new HeroNode(2, "吴用");
	HeroNode node3=new HeroNode(3, "卢俊义");
	HeroNode node4=new HeroNode(4, "林冲");
	HeroNode node5=new HeroNode(5, "关胜");
	
	//说明，我们先手动创建该二叉树，后面我们学习以递归的方式创建二叉树
	node1.setLeft(node2);
	node1.setRight(node3);
	node3.setLeft(node5);
	node3.setRight(node4);
	
	binaryTree.setRoot(node1);
	
	//测试
	System.out.println("前序遍历");//1， 2， 3， 5， 4
	binaryTree.preOrder();
	
	//测试
	System.out.println("中序遍历");//2， 1， 5， 3， 4
	binaryTree.infixOrder();
	
	//测试
	System.out.println("后序遍历");//2， 5， 4， 3， 1
	binaryTree.postOrder();
	
	/*
	
	//前序遍历
	//前序遍历的次数：4
	System.out.println("前序遍历方式：");
	HeroNode resNode=binaryTree.preOrderSearch(5);
	if (resNode!=null) {
	    System.out.printf("找到了，信息为no=%d name=%s",resNode.getNo(),resNode.getName());
	} else {
	    System.out.printf("没有找到no=%d的英雄",5);
	}
	
	
	
	//中序遍历查找
	//中序遍历3次
	System.out.println("中序遍历方式：");
	HeroNode resNode=binaryTree.infixOrderSearch(5);
	if (resNode!=null) {
	    System.out.printf("找到了，信息为no=%d name=%s",resNode.getNo(),resNode.getName());
	} else {
	    System.out.printf("没有找到no=%d的英雄",5);
	}
	
	*/
	
	//后序遍历查找
	//后序遍历查找的次数 2次
	System.out.println("后序遍历方式：");
	HeroNode resNode=binaryTree.postOrderSearch(2);
	if (resNode!=null) {
	    System.out.printf("找到了，信息为no=%d name=%s",resNode.getNo(),resNode.getName());
	} else {
	    System.out.printf("没有找到no=%d的英雄",2);
	}
    }

}

//定义BinaryTree 二叉树
class BinaryTree {
    private HeroNode root;

    public void setRoot(HeroNode root) {
        this.root = root;
    }
    
    //前序遍历
    public void preOrder() {
	if (this.root!=null) {
	    this.root.preOrder();
	} else {
	    System.out.println("二叉树为空，无法遍历");
	}
    }
    
    //中序遍历
    public void infixOrder() {
	if (this.root!=null) {
	    this.root.infixOrder();
	} else {
	    System.out.println("二叉树为空，无法遍历");
	}
    }
    
    //后序遍历
    public void postOrder() {
	if (this.root!=null) {
	    this.root.postOrder();
	} else {
	    System.out.println("二叉树为空，无法遍历");
	}
    }
    
    //前序遍历
    public HeroNode preOrderSearch(int no) {
	if (root!=null) {
	    return root.preOrderSearch(no);
	} else {
	    return null;
	}
    }
    
    //中序遍历
    public HeroNode infixOrderSearch(int no) {
	if (root!=null) {
	    return root.infixOrderSearch(no);
	} else {
	    return null;
	}
    }
    
    //后序遍历
    public HeroNode postOrderSearch(int no) {
	if (root!=null) {
	    return root.postOrderSearch(no);
	} else {
	    return null;
	}
    }
}

//先创建HeroNode节点
class HeroNode {
    private int no;
    private String name;
    private HeroNode left;//默认null
    private HeroNode right;//默认null
    
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
    
    //编写前序遍历的方法
    public void preOrder() {
	System.out.println(this);//先输出父节点
	
	//递归向左子树前序遍历
	if (this.left!=null) {
	    this.left.preOrder();
	}
	
	//递归向右子树前序遍历
	if (this.right!=null) {
	    this.right.preOrder();
	}
    }
    
    //编写中序遍历的方法
    public void infixOrder() {
	//递归向左子树中序遍历
	if (this.left!=null) {
	    this.left.infixOrder();
	}
	
	//输出父节点
	System.out.println(this);
	
	//递归向右子树中序遍历
	if (this.right!=null) {
	    this.right.infixOrder();
	}
    }
    
    //编写后序遍历的方法
    public void postOrder() {
	if (this.left!=null) {
	    this.left.postOrder();
	}
	
	if (this.right!=null) {
	    this.right.postOrder();
	}
	
	System.out.println(this);
    }
    
    //前序遍历查找
    /**
     * 
     * @param no 查找no
     * @return 如果找到就返回该node，如果没有找到就返回null
     */
    public HeroNode preOrderSearch(int no) {
	System.out.println("进入前序遍历");
	
	//先比较当前节点是不是
	if (this.no==no) {
	    return this;
	}
	
	//1.则判断当前节点的左子节点是否为空，如果不空，则递归前序查找
	//2.如果左递归前序查找，找到节点，则返回
	HeroNode resNode=null;
	if (this.left!=null) {
	    resNode=this.left.preOrderSearch(no);
	}
	
	if (resNode!=null) {//说明我们左子树找到
	    return resNode;
	}
	
	//1.左递归前序查找，找到节点，则返回，否则继续判断，
	//2.当前节点的右子节点是否为空，如果不空，则继续向右递归前序查找
	if (this.right!=null) {
	    resNode=this.right.preOrderSearch(no);
	}
	
	return resNode;
    }
    
    //中序遍历查找
    public HeroNode infixOrderSearch(int no) {
	//判断当前节点的左子节点是否为空，如果不空，则递归中序查找
	HeroNode resNode=null;
	if (this.left!=null) {
	    resNode=this.left.infixOrderSearch(no);
	}
	
	if (resNode!=null) {
	    return resNode;
	}
	
	System.out.println("进入中序查找");
	
	//如果找到，则返回，如果没有找到，就和当前节点比较，如果是则返回当前节点
	if (this.no==no) {
	    return this;
	}
	
	//否则继续进行右递归的中序查找
	if (this.right!=null) {
	    resNode=this.right.infixOrderSearch(no);
	}
	
	return resNode;
    }
    
    //后序遍历查找
    public HeroNode postOrderSearch(int no) {
	//判断当前节点的左子节点是否为空，如果不为空，则递归后续查找
	HeroNode resNode=null;
	if (this.left!=null) {
	    resNode=this.left.postOrderSearch(no);
	}
	
	if (resNode!=null) {//说明在左子树找到
	    return resNode;
	}
	
	//如果左子树没有找到，则向右子树递归进行后续遍历查找
	if (this.right!=null) {
	    resNode=this.right.postOrderSearch(no);
	}
	
	if (resNode!=null) {
	    return resNode;
	}
	
	System.out.println("进入后序查找");
	
	//如果左右子树都没有找到，就比较当前而节点是不是
	if (this.no==no) {
	    return this;
	}
	
	return resNode;
    }
}
