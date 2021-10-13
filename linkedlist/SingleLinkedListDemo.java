package linkedlist;

import java.util.Stack;

/*
 * �������˼·��
 * ��ӣ�������
 * 1.�ȴ���һ��headͷ�ڵ㣬���þ��Ǳ�ʾ�����ͷ
 * 2.��������ÿ���һ���ڵ㣬����ֱ�Ӽ��뵽��������
 * 
 * ����
 * 1.ͨ��һ��������������������������������
 * 
 * ��Ҫ���ձ�ŵ�˳�����
 * 1.�����ҵ�����ӵĽڵ��λ�ã���ͨ������������ָ�룩��ͨ���������㶨��
 * 2.�µĽڵ�next=temp.next
 * 3.��temp.next=�µĽڵ�
 * 
 * �޸Ľڵ㹦��
 * 1.���ҵ��ýڵ㣬ͨ������
 * 2.temp.name=newHeroNode.name;
 *   temp.nickName=newHeroNode.name;
 * 
 * ��������ɾ��һ���ڵ��˼·
 * 1.�������ҵ���Ҫɾ��������ڵ��ǰһ���ڵ�temp
 * 2.temp.next=temp.next.next
 * 3.��ɾ���Ľڵ㣬����������������ָ�򣬻ᱻ�������ջ��ƻ���
 * 
 * ������ת˼·��
 * 1.�ȶ���һ���ڵ�reverseHead=new HeroNode();
 * 2.��ͷ��β����ԭ��������ÿ����һ���ڵ㣬�ͽ���ȡ�����������µ�����reverseHead����ǰ��
 * 3.ԭ���������head.next=reverseHead.next
 * 
 * ��δ��ͷ��ӡ������
 * 1.��������Ҫ����������ӡ������
 * 2.��ʽ1���Ƚ���������з�ת������Ȼ���ڱ������ɣ��������������ǻ��ƻ�ԭ���ĵ�����Ľṹ��������
 * 3.��ʽ2����������ջ������ݽṹ���������ڵ�ѹ�뵽ջ�У�����ջ���Ƚ�������ص㣬��ʵ���������ӡ��Ч��
 * 
 * ���ʱ����Ϊ����Ҫ���������һ����㣬ѭ������Ϊ cur.next!=null ����������֮��cur����β��㣬���Խ���ͷ�������Ϸ��㣬�������ձ�����Ҳ������ȥ��
 * ����ʱ����ΪҪ�ȶԵ�ǰ�������ݣ�ͷ��㲻�������ݣ���������Ϊ�գ������Ա���ʱ���ܴ�ͷ��㿪ʼ��Ӧ�ô��׽�㿪ʼ��ѭ������ӦΪ cur!=null ���������cur.next!=null�򲻻�ȶ����һ���������ݣ��������Ż������ıȽϸ����
 * 
 * �ܽ�
 * ��ӣ�ͷ��㿪ʼ��ѭ������Ϊ cur.next!=null��һֱ��ǰһ����㣩
 * ���ң��׽�㿪ʼ��ѭ������Ϊ cur!=null��������ȫ��
 * ����ѭ������ֱ��Ϊtrue����ѭ���ڲ��ж�
 */

public class SingleLinkedListDemo
{

	public static void main(String[] args)
	{
		//���в���
		//�ȴ����ڵ�
		HeroNode hero1=new HeroNode(1, "�ν�", "��ʱ��");
		HeroNode hero2=new HeroNode(2, "¬����", "������");
		HeroNode hero3=new HeroNode(3, "����", "�Ƕ���");
		HeroNode hero4=new HeroNode(4, "�ֳ�", "����ͷ");
		
		//����һ������
		SingleLikedList singleLikedList=new SingleLikedList();
		
		//����
		singleLikedList.add(hero1);
		singleLikedList.add(hero4);
		singleLikedList.add(hero2);
		singleLikedList.add(hero3);
		
		//����һ�µ�����ķ�ת����
		System.out.println("ԭ����������");
		singleLikedList.list();
		System.out.println("��ת������");
		reverseList(singleLikedList.getHead());
		singleLikedList.list();
		
		System.out.println("���������ӡ������û�иı�����Ľṹ");
		reversePrint(singleLikedList.getHead());
		
		//���밴�ձ�ŵ�˳��
		singleLikedList.addByOrder(hero1);
		singleLikedList.addByOrder(hero4);
		singleLikedList.addByOrder(hero2);
		singleLikedList.addByOrder(hero3);
		
		//��ʾһ��
		singleLikedList.list();
		
		//�����޸Ľڵ�ĵĴ���
		HeroNode newHerpNode=new HeroNode(2, "С¬", "Сβ��");
		singleLikedList.update(newHerpNode);
		System.out.println("�޸ĺ���������");
		singleLikedList.list();
		
		//ɾ��һ���ڵ�
		singleLikedList.del(1);
		singleLikedList.del(4);
		System.out.println("ɾ������������");
		singleLikedList.list();
		
		//����һ�� ����������Ч�ڵ�ĸ���
		System.out.println("��Ч�Ľڵ����="+getLength(singleLikedList.getHead()));//2
		
		//����һ�¿����Ƿ�õ��˵�����K���ڵ�
		HeroNode res=findLastIndexNode(singleLikedList.getHead(),3);
		System.out.println("res="+res);
	}
	
	//��ʽ2��
	//��������ջ������ݽṹ���������ڵ�ѹ�뵽ջ�У�����ջ���Ƚ�������ص㣬��ʵ���������ӡ��Ч��
	public static void reversePrint(HeroNode head)
	{
		if (head.next==null)
		{
			return;//���������ܴ�ӡ
		}
		//����һ��ջ���������ڵ�ѹ��ջ��
		Stack<HeroNode> stack=new Stack<HeroNode>();
		HeroNode cur=head.next;
		//����������нڵ�ѹ��ջ
		while (cur!=null)
		{
			stack.push(cur);
			cur=cur.next;//cur���ƣ������Ϳ���ѹ����һ���ڵ�
		}
		//��ջ�еĽڵ���д�ӡ��pop��ջ
		while (stack.size()>0)
		{
			System.out.println(stack.pop());//stack���ص����Ƚ����
		}
	}
	
	//����������з�ת
	public static void reverseList(HeroNode head)
	{
		//�����ǰ����Ϊ�գ�����ֻ��һ���ڵ㣬���跴ת��ֱ�ӷ���
		if (head.next==null||head.next.next==null)
		{
			return;
		}
		//����һ��������ָ�루���������������Ǳ���ԭ��������
		HeroNode cur=head.next;
		HeroNode next=null;//ָ��ǰ�ڵ�[cur]����һ���ڵ�
		HeroNode reverseHead=new HeroNode(0, "", "");
		//����ԭ��������ÿ����һ���ڵ㣬�ͽ���ȡ�����������µ�����reverseHead����ǰ��
		//���Խ�
		while (cur!=null)
		{
			next=cur.next;//����ʱ���浱ǰ�ڵ����һ���ڵ㣬��Ϊ������Ҫʹ��
			cur.next=reverseHead.next;//��cur����һ���ڵ�ָ�����������ǰ��
			reverseHead.next=cur;//��cur���ӵ��µ�������
			cur=next;//��cur����
		}
		//��head.nextָ��reverseHead.next��ʵ���˵�����ķ�ת
		head.next=reverseHead.next;
	}
	
	//���ҵ������еĵ�����k���ڵ㡾���������⡿
	//˼·
	//1.��дһ������������head�ڵ㣬ͬʱ����һ��index
	//2.index��ʾ������index���ڵ�
	//3.�Ȱ������ͷ��β�������õ�������ܵĳ��� getLength
	//4.�õ�size�����Ǵ�����ĵ�һ����ʼ����(size-index)�����Ϳ��Եõ�
	//5.����ҵ��ˣ��ͷ��ظýڵ㣬���򷵻�null
	public static HeroNode findLastIndexNode(HeroNode head,int index)
	{
		//�ж��������Ϊ�գ�����null
		if (head.next==null)
		{
			return null;//û���ҵ�
		}
		//��һ�������õ�����ĳ��ȣ��ڵ������
		int size=getLength(head);
		//�ڶ��α���size-indexλ�ã��������ǵ����ĵ�K���ڵ�
		//����һ��index��У��
		if (index<=0||index>size)
		{
			return null;
		}
		//���帨������,for ѭ����λ��������index
		HeroNode cur=head.next;//3 //3-1=2
		for (int i=0;i<size-index;i++)
		{
			cur=cur.next;
		}
		return cur;
	}
	
	//��������ȡ��������Ľ��ĸ���������Ǵ�ͷ����������Ҫ��ͳ��ͷ�ڵ㣩
	/**
	 * 
	 * @param head �����ͷ�ڵ�
	 * @return ���ص�����Ч�ڵ�ĸ���
	 */
	public static int getLength(HeroNode head)
	{
		if (head.next==null)//������
		{
			return 0;
		}
		int length=0;
		//����һ�������ı�������������û��ͳ��ͷ�ڵ�
		HeroNode cur=head.next;
		while (cur!=null)
		{
			length++;
			cur=cur.next;//����
		}
		return length;
	}
	//�ϲ���������ĵ������ϲ�֮���������Ȼ���򡾿κ���ϵ��
}

//����SingleLinkedList�������ǵ�Ӣ��
class SingleLikedList
{
	//�ȳ�ʼ��һ��ͷ�ڵ�,ͷ�ڵ㲻Ҫ������Ҫ��ž��������
	private HeroNode head=new HeroNode(0,"","");
	
	//����ͷ�ڵ�
	public HeroNode getHead()
	{
		return head;
	}

	//��ӽڵ㵽��������
	//˼·���������Ǳ��˳��ʱ
	//1.�ҵ���ǰ��������ڵ�
	//2.���������ڵ��nextָ���µĽڵ�
	public void add(HeroNode heroNode)
	{
		//��Ϊhead�ڵ㲻�ܶ������������Ҫһ����������temp
		HeroNode temp=head;
		//���������ҵ����
		while (true)
		{
			//�ҵ���������
			if(temp.next==null)
			{
				break;
			}
			//���û���ҵ����,�ͽ�temp����
			temp=temp.next;
		}
		//���˳�whileѭ��ʱ��temp��ָ������������
		temp.next=heroNode;
	}
	
	//�ڶ��ַ�ʽ�����Ӣ��ʱ������������Ӣ�۲��뵽ָ��λ��
	//���������������������ʧ�ܣ���������ʾ��
	public void addByOrder(HeroNode heroNode)
	{
		//��Ϊͷ�ڵ㲻�ܶ������������Ȼͨ��һ������ָ�루�����������������ҵ���ӵ�λ��
		//��Ϊ��������������ҵ�temp��λ�����λ�õ�ǰһ���ڵ㣬������벻��
		HeroNode temp=head;
		boolean  flag=false;//flag��־��ӵı���Ƿ���ڣ�Ĭ��Ϊfalse
		while (true)
		{
			if (temp.next==null)//˵��temp�Ѿ����������
			{
				break;//
			}
			if (temp.next.no>heroNode.no)//λ���ҵ�������temp�ĺ������
			{
				break;
			}
			else if(temp.next.no==heroNode.no)//˵��ϣ����ӵ�heronode�ı���Ѿ�����
			{
				flag=true;//˵����Ŵ���
				break;
			}
			temp=temp.next;//���Ʊ�����ǰ����
		}
		//�ж�flag��ֵ
		if (flag)//������ӣ�˵����Ŵ���
		{
			System.out.printf("׼�������Ӣ�۵ı�� %d �Ѿ����ڣ����ܲ���\n",heroNode.no);
		}
		else
		{
			//���뵽�����У�temp�ĺ���
			heroNode.next=temp.next;
			temp.next=heroNode;
		}
	}
	
	//�޸Ľڵ����Ϣ�����ݱ�����޸ã���no���ܸ�
	//1.����newHeroNode��no���޸ļ���
	public void update(HeroNode newHeroNode)
	{
		//�ж��Ƿ��
		if (head.next==null)
		{
			System.out.println("����Ϊ��");
			return;
		}
		//�ҵ���Ҫ�޸ĵĽڵ㣬����no���
		//����һ����������
		HeroNode temp=head.next;
		boolean flag=false;//��ʾ�Ƿ��ҵ��ýڵ�
		while (true)
		{
			if (temp==null)
			{
				break;//�Ѿ�����������
			}
			if (temp.no==newHeroNode.no)
			{
				//�ҵ�
				flag=true;
				break;
			}
			temp=temp.next;
		}
		//����flag�ж��Ƿ��ҵ�Ҫ�޸ĵĽڵ�
		if (flag)
		{
			temp.name=newHeroNode.name;
			temp.nickName=newHeroNode.nickName;
		}
		else//û���ҵ�
		{
			System.out.printf("û���ҵ���� %d �Ľڵ㣬�����޸�\n",newHeroNode.no);
		}
	}
	
	//ɾ���ڵ�
	//˼·
	//1.head�ڵ㵫���ܶ������������Ҫһ��temp�����ڵ��ҵ���ɾ���ڵ��ǰһ���ڵ�
	//2.˵�������ڱȽ�ʱ����temp.next,no����Ҫɾ���Ľڵ��no�Ƚ�
	public void del(int no)
	{
		HeroNode temp=head;
		boolean flag=false;//��־�Ƿ��ҵ���ɾ���Ľڵ�
		while (true)
		{
			if (temp.next==null)//�Ѿ��ҵ���������
			{
				break;
			}
			if (temp.next.no==no)
			{
				//�ҵ��˴�ɾ���ڵ��ǰһ���ڵ�
				flag=true;
				break;
			}
			temp=temp.next;
		}
		//�ж�flag
		if (flag)//�ҵ�
		{
			temp.next=temp.next.next;
		}
		else
		{
			System.out.printf("Ҫɾ���� %d �ڵ㲻����\n",no);
		}
	}
	
	//��ʾ����������
	public void list()
	{
		//�ж������Ƿ�Ϊ��
		if (head.next==null)
		{
			System.out.println("����Ϊ��");
			return;
		}
		//��Ϊͷ�ڵ㲻�ܶ������������Ҫһ�������������б���
		HeroNode temp=head.next;
		while (true)
		{
			//�ж��Ƿ��������
			if (temp==null)
			{
				break;
			}
			//����ڵ����Ϣ
			System.out.println(temp);
			//��temp����
			temp=temp.next;
		}
	}
}

//����һ��HeroNode��ÿ��HeroNode�������һ���ڵ�
class HeroNode
{
	public int no;
	public String name;
	public String nickName;
	public HeroNode next;//ָ����һ���ڵ�
	//������
	public HeroNode(int no,String name,String nickName)
	{
		this.no=no;
		this.name=name;
		this.nickName=nickName;
	}
	
	//Ϊ����ʾ���㣬������дtoString
	@Override
	public String toString()
	{
		return "HeroNode [no=" + no + ", name=" + name + ", nickName=" + nickName + "]";
	}
}