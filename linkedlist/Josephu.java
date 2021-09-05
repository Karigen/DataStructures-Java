package linkedlist;

/*
 * ����һ������Ļ�������˼·
 * 1.�ȴ�����һ���ڵ㣬��firstָ��ýڵ㣬���γɻ���
 * 2.��������ÿ����һ���µĽڵ㣬�ͰѸýڵ㣬���뵽���еĻ��������м���
 * 
 * ������������
 * 1.����һ������ָ�루������curBoy��ָ��first�ڵ�
 * 2.Ȼ��ͨ��һ��whileѭ������������curBoy==first����
 * 
 * �����û������롣����һ��С����Ȧ��˳��
 * n=5������5����
 * k=1���ӵ�һ���˿�ʼ����
 * m=2����2��
 * 
 * 1.���󴴽�һ������ָ�루������helper������Ӧ��ָ����������������ڵ�
 *  ���䣺С������ǰ������first��helper�ƶ�k-1��
 * 2.��С������ʱ������first��helperָ��ͬʱ���ƶ�m-1�Σ�Ȼ���Ȧ
 * 3.��ʱ�Ϳ��Խ�first��helperָ���С���ڵ��Ȧ
 *  first=first.next
 *  helper=helper.next
 *  ԭ��firstָ��Ľڵ��û���κ����ã��ͻᱻ����
 * 
 * ��Ȧ��˳��
 * 2->4->1->5->3
 */

public class Josephu {

    public static void main(String[] args) {
	//����һ�ѿ����������������ͱ����Ƿ�ok
	CircleSingleLinkedList circleSingleLinkedList=new CircleSingleLinkedList();
	circleSingleLinkedList.addBoy(5);//����5��С���ڵ�
	circleSingleLinkedList.showBoy();
	
	//����һ��С����Ȧ�Ƿ���ȷ
	circleSingleLinkedList.contBoy(1, 2, 5);//2->4->1->5->3
    }

}

//����һ�����εĵ�������
class CircleSingleLinkedList {
    //����һ��first�ڵ㣬��ǰû�б��
    private Boy first=null;//new Boy(-1);
    //���С���ڵ㣬������һ����������
    public void addBoy(int nums) {
	//nums ��һ������У��
	if (nums<1) {
	    System.out.println("nums��ֵ����ȷ");
	    return;
	}
	Boy curBoy=null;//����ָ�룬����������������
	//ʹ��for���������ǵĻ�������
	for (int i = 1; i <= nums; i++) {
	    //���ݱ�Ŵ���С���ڵ�
	    Boy boy=new Boy(i);
	    //����ǵ�һ��С��
	    if (i==1) {
		first=boy;
		first.setNext(first);//���ɻ�
		curBoy=first;//��curBoyָ���һ��С��
	    } else {
		curBoy.setNext(boy);//
		boy.setNext(first);//
		curBoy=boy;
	    }
	}
    }
    
    //������ǰ�Ļ�������
    public void showBoy() {
	//�ж������Ƿ�Ϊ��
	if (first==null) {
	    System.out.println("û���κ�С��");
	    return;
	}
	//��Ϊfirst���ܶ������������Ȼʹ��һ������ָ����ɱ���
	Boy curBoy=first;
	while (true) {
	    System.out.printf("С���ı�� %d \n",curBoy.getNo());
	    if (curBoy.getNext()==first) {//˵���Ѿ��������
		break;
	    }
	    curBoy=curBoy.getNext();//curBoy����
	}
    }
    
    //�����û������룬�����С����Ȧ��˳��
    /**
     * 
     * @param startNo ��ʾ�ӵڼ���С����ʼ����
     * @param countNum ��ʾ������
     * @param nums ��ʾ����ж���С����Ȧ��
     */
    public void contBoy(int startNo,int countNum,int nums) {
	//�ȶ����ݽ���У��
	if (first==null||startNo<1||startNo>nums) {
	    System.out.println("����������������������");
	    return;
	}
	//����һ������ָ�룬�������С����Ȧ
	Boy helper=first;
	//���󴴽�һ������ָ�루������helper������Ӧ��ָ����������������ڵ�
	while (true) {
	    if (helper.getNext()==first) {//˵��helperָ�����С���ڵ�
		break;
	    }
	    helper=helper.getNext();
	}
	//С������ǰ������first��helper�ƶ�k-1��
	for (int j = 0; j < startNo-1; j++) {
	    first=first.getNext();
	    helper=helper.getNext();
	}
	//��С������ʱ������first��helperָ��ͬʱ���ƶ�m-1�Σ�Ȼ���Ȧ
	//������һ��ѭ��������ֱ��Ȧ��ֻ��һ���ڵ�
	while (true) {
	    if (helper==first) {//˵��Ȧ��ֻ��һ���ڵ�
		break;
	    }
	    //��first helperָ��ͬʱ���ƶ�countNum-1
	    for (int j = 0; j < countNum-1; j++) {
		first=first.getNext();
		helper=helper.getNext();
	    }
	    //��ʱfirstָ��Ľڵ㣬����Ҫ��Ȧ��С���ڵ�
	    System.out.printf("С��%d��Ȧ\n", first.getNo());
	    //��ʱ��firstָ���С����Ȧ
	    first=first.getNext();
	    helper.setNext(first);
	}
	System.out.printf("�������Ȧ�е�С�����%d\n",first.getNo());
    }
}

//����һ��Boy�࣬��ʾһ���ڵ�
class Boy {
    private int no;//���
    private Boy next;//ָ����һ���ڵ㣬Ĭ��null
    public Boy(int no) {
	this.no=no;
    }
    public int getNo() {
        return no;
    }
    public void setNo(int no) {
        this.no = no;
    }
    public Boy getNext() {
        return next;
    }
    public void setNext(Boy next) {
        this.next = next;
    }
}