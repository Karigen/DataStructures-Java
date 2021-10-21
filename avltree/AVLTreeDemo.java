package avltree;

/*
 * AVLTree
 * ������
 * 1.����һ���½�� newNode ������һ���µĽ�㣬ֵ���ڵ�ǰ������ֵ
 * 2.���½�������������Ϊ��ǰ����������
 * 3.���½�������������Ϊ��ǰ������������������
 * 4.�ѵ�ǰ����ֵ��Ϊ���ӽ���ֵ
 * 5.�ѵ�ǰ�������������óɵ�ǰ������������������
 * 6.�ѵ�ǰ���������������ӽ�㣩���ó��µĽ��
 */

public class AVLTreeDemo {

    public static void main(String[] args) {
	int[] arr = { 4, 3, 6, 5, 7, 8 };

	// ����һ��AVLTree����
	AVLTree avlTree = new AVLTree();

	// ��ӽ��
	for (int i = 0; i < arr.length; i++) {
	    avlTree.add(new Node(arr[i]));
	}

	// ����
	System.out.println("�������");
	avlTree.infixOrder();

	System.out.println("��ƽ�⴦���");
	System.out.println("���ĸ߶�=" + avlTree.getRoot().height());// 4
	System.out.println("�����������߶�=" + avlTree.getRoot().leftHeight());// 1
	System.out.println("�����������߶�=" + avlTree.getRoot().rightHeight());// 3
    }

}

//����AVLtree
class AVLTree {
    private Node root;

    public Node getRoot() {
	return root;
    }

    public void setRoot(Node root) {
	this.root = root;
    }

    // ����Ҫɾ���Ľ��
    public Node search(int value) {
	if (root == null) {
	    return null;
	} else {
	    return root.search(value);
	}
    }

    // ���Ҹ����
    public Node searchParent(int value) {
	if (root == null) {
	    return null;
	} else {
	    return root.searchParent(value);
	}
    }

    // ��д����
    // 1.���ص�����nodeΪ���ڵ�Ķ�������������С����ֵ
    // 2.ɾ��nodeΪ���ڵ�Ķ�������������С���
    /**
     * 
     * @param node ����Ľ�㣨���������������ĸ��ڵ㣩
     * @return ���ص�����nodeΪ���ڵ�Ķ�������������С����ֵ
     */
    public int delRightTreeMin(Node node) {
	Node target = node;

	// ѭ���������ӽ�㣬�ͻ��ҵ���Сֵ
	while (target.left != null) {
	    target = target.left;
	}

	// ��ʱtarget��ָ������С���
	// ɾ����С���
	delNode(target.value);
	return target.value;
    }

    // ɾ���ڵ�
    public void delNode(int value) {
	if (root == null) {
	    return;
	} else {
	    // 1.�������ҵ�Ҫɾ���Ľ�� targetNode
	    Node targetNode = search(value);

	    // ���û���ҵ�Ҫɾ���Ľ��
	    if (targetNode == null) {
		return;
	    }

	    // ������Ƿ��ֵ�ǰ��ö���������ֻ��һ�����
	    if (root.left == null && root.right == null) {
		root = null;
		return;
	    }

	    // ȥ�ҵ�targetNode�ĸ����
	    Node parent = searchParent(value);

	    // ���Ҫɾ���Ľ����Ҷ�ӽ��
	    if (targetNode.left == null && targetNode.right == null) {
		// �ж�targetNode�Ǹ��������ӽ�㣬�������ӽ��
		if (parent.left != null && parent.left.value == value) {// �����ӽڵ�
		    parent.left = null;
		} else if (parent.right != null && parent.right.value == value) {// �����ӽڵ�
		    parent.right = null;
		}
	    } else if (targetNode.left != null && targetNode.right != null) {// ɾ�������������Ľ��
		int minVal = delRightTreeMin(targetNode.right);
		targetNode.value = minVal;
	    } else {// ɾ��ֻ��һ�������Ľ��
		if (targetNode.left != null) {// ���Ҫɾ���Ľ�������ӽ��
		    if (parent != null) {
			// ���targetNode��parent�����ӽ��
			if (parent.left.value == value) {
			    parent.left = targetNode.left;
			} else {// targetNode��parent�����ӽ��
			    parent.right = targetNode.left;
			}
		    } else {
			root = targetNode.left;
		    }
		} else {// ���Ҫɾ���Ľ�������ӽ��
		    if (parent != null) {
			// ���targetNode��parent�����ӽ��
			if (parent.left.value == value) {
			    parent.left = targetNode.right;
			} else {// ���targetNode��parent�����ӽ��
			    parent.right = targetNode.right;
			}
		    } else {
			root = targetNode.right;
		    }
		}
	    }
	}
    }

    // ��ӽ��ķ���
    public void add(Node node) {
	if (root == null) {
	    root = node;// ���rootΪ����ֱ����rootָ��node
	} else {
	    root.add(node);
	}
    }

    // �������--�����Ǵ�С�����˳��
    public void infixOrder() {
	if (root != null) {
	    root.infixOrder();
	} else {
	    System.out.println("����������Ϊ�գ����ܱ���");
	}
    }
}

//����Node���
class Node {
    int value;
    Node left;
    Node right;

    public Node(int value) {
	super();
	this.value = value;
    }

    // �����������ĸ߶�
    public int leftHeight() {
	if (left == null) {
	    return 0;
	}

	return left.height();
    }

    // �����������ĸ߶�
    public int rightHeight() {
	if (right == null) {
	    return 0;
	}

	return right.height();
    }

    // �����Ըý��Ϊ���ڵ�����ĸ߶�
    public int height() {
	return Math.max(left == null ? 0 : left.height(), right == null ? 0 : right.height()) + 1;
    }

    // ����ת����
    private void leftRotate() {
	// �����µĽ�㣬�Ե�ǰ������ֵ
	Node newNode = new Node(value);

	// ���½�������������Ϊ��ǰ����������
	newNode.left = left;

	// ���½�������������Ϊ��ǰ������������������
	newNode.right = right.left;

	// �ѵ�ǰ����ֵ��Ϊ���ӽ���ֵ
	value = right.value;

	// �ѵ�ǰ�������������óɵ�ǰ������������������
	right = right.right;

	// �ѵ�ǰ���������������ӽ�㣩���ó��µĽ��
	left = newNode;
    }

    // ����Ҫɾ���Ľ��
    /**
     * 
     * @param value ϣ��ɾ���Ľ���ֵ
     * @return ����ҵ��ͷ��ظý�㣬���򷵻�null
     */
    public Node search(int value) {
	if (value == this.value) {// �ҵ������Ǹý��
	    return this;
	} else if (value < this.value) {// ������ҵ�ֵС�ڵ�ǰ��㣬���������ݹ����
	    // ������ӽ��Ϊ��
	    if (this.left == null) {
		return null;
	    }

	    return this.left.search(value);
	} else {// ������ҵ�ֵ���ڵ�ǰ��㣬���������ݹ����
	    if (this.right == null) {
		return null;
	    }

	    return this.right.search(value);
	}
    }

    // ����Ҫɾ�����ĸ����
    /**
     * 
     * @param value Ҫ�ҵĽ���ֵ
     * @return ���ص���Ҫɾ�����ĸ���㣬���û�оͷ���null
     */
    public Node searchParent(int value) {
	// �����ǰ������Ҫɾ�����ĸ���㣬�ͷ���
	if ((this.left != null && this.left.value == value) || (this.right != null && this.right.value == value)) {
	    return this;
	} else {
	    // ������ҵ�ֵС�ڵ�ǰ����ֵ�����ҵ�ǰ�������ӽ�㲻Ϊ��
	    if (value < this.value && this.left != null) {
		return this.left.searchParent(value);// ���������ݹ����
	    } else if (value >= this.value && this.right != null) {
		return this.right.searchParent(value);// ���������ݹ����
	    } else {
		return null;// û���ҵ������
	    }
	}
    }

    @Override
    public String toString() {
	return "Node [value=" + value + "]";
    }

    // ��ӽ��ķ���
    // �ݹ����ʽ��ӽ�㣬ע�����������������Ҫ��
    public void add(Node node) {
	if (node == null) {
	    return;
	}

	// �жϴ���Ľ���ֵ���͵�ǰ�����ĸ�����ֵ�Ĺ�ϵ
	if (node.value < this.value) {
	    // �����ǰ�������ӽ��Ϊnull
	    if (this.left == null) {
		this.left = node;
	    } else {
		// �ݹ�������������
		this.left.add(node);
	    }
	} else {// ��ӵĽ���ֵ���ڵ�ǰ����ֵ�����ߵ��ڣ�
	    if (this.right == null) {
		this.right = node;
	    } else {
		// �ݹ�������������
		this.right.add(node);
	    }
	}

	// �������һ��������������������ĸ߶�-�������ĸ߶ȣ�>1������ת
	if (rightHeight() - leftHeight() > 1) {
	    leftRotate();// ����ת
	}
    }

    // �������
    public void infixOrder() {
	if (this.left != null) {
	    this.left.infixOrder();
	}

	System.out.println(this);

	if (this.right != null) {
	    this.right.infixOrder();
	}
    }
}