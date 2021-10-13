package linkedlist;

/*
 * ˫������
 * 1.�����͵�����һ����ֻ�ǿ�����ǰ��Ҳ�������
 * 2.��ӣ�Ĭ����ӵ�˫����������
 *  1.���ҵ�˫��������������ڵ�
 *  2.temp.next=newHeroNode
 *  3.mewHeroNode.pre=temp
 * 3.�޸�˼·��ԭ���ĵ�������һ��
 * 4.ɾ��
 *  1.��Ϊ��˫��������ˣ����ǿ���ʵ������ɾ��ĳ���ڵ�
 *  2.ֱ���ҵ�Ҫɾ��������ڵ㣬����temp
 *  3.temp.pre=temp.next
 *  4.temp.next.pre=temp.pre
 *  
 *  pre next �������Ӽ���
 *  ��ɾʱ�����������
 *  
 *  ͷ���/β��㲻�������������ڣ���ͷ���/β��㲻�뻷��ֻ����nextָ��ָ���ڽ��
 */

public class DoubleLinkedListDemo
{

	public static void main(String[] args)
	{
		//����
		System.out.println("˫������Ĳ���");
		//�ȴ����ڵ�
		HeroNode2 hero1=new HeroNode2(1, "�ν�", "��ʱ��");
		HeroNode2 hero2=new HeroNode2(2, "¬����", "������");
		HeroNode2 hero3=new HeroNode2(3, "����", "�Ƕ���");
		HeroNode2 hero4=new HeroNode2(4, "�ֳ�", "����ͷ");
		//����һ��˫���������
		DoubleLinkedList doubleLinkedList=new DoubleLinkedList();
		doubleLinkedList.add(hero1);
		doubleLinkedList.add(hero2);
		doubleLinkedList.add(hero3);
		doubleLinkedList.add(hero4);
		
		doubleLinkedList.list();
		
		//�޸�
		HeroNode2 newHeroNode2=new HeroNode2(4, "����ʤ", "������");
		doubleLinkedList.update(newHeroNode2);
		System.out.println("�޸ĺ���������");
		doubleLinkedList.list();
		
		//ɾ��
		doubleLinkedList.del(3);
		System.out.println("ɾ������������");
		doubleLinkedList.list();
		
		//��ҵ
		//˫������ĵڶ�����ӷ�ʽ�����ձ��˳��
		//���յ������˳����ӣ������޸ļ���
	}

}

//����һ��˫���������
class DoubleLinkedList
{
	//�ȳ�ʼ��һ��ͷ�ڵ�,ͷ�ڵ㲻Ҫ������Ҫ��ž��������
	private HeroNode2 head=new HeroNode2(0,"","");
	
	//����ͷ�ڵ�
	public HeroNode2 getHead()
	{
		return head;
	}

	//����˫������ķ���
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
		HeroNode2 temp=head.next;
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
	
	//���һ���ڵ㵽˫����������
	public void add(HeroNode2 heroNode)
	{
		//��Ϊhead�ڵ㲻�ܶ������������Ҫһ����������temp
		HeroNode2 temp=head;
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
		//�γ�һ��˫������
		temp.next=heroNode;
		heroNode.pre=temp;
	}
	
	//�޸�һ���ڵ�����ݣ����Կ���˫������Ľڵ������޸ĺ͵�������һ��
	//ֻ�ǽڵ�����͸ĳ�HeroNode2
	public void update(HeroNode2 newHeroNode)
	{
		//�ж��Ƿ��
		if (head.next==null)
		{
			System.out.println("����Ϊ��");
			return;
		}
		//�ҵ���Ҫ�޸ĵĽڵ㣬����no���
		//����һ����������
		HeroNode2 temp=head.next;
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
	
	//��˫��������ɾ��һ���ڵ�
	//˵��
	//1.����˫���������ǿ���ֱ���ҵ�Ҫɾ��������ڵ�
	//2.�ҵ�������ɾ������
	public void del(int no)
	{
		
		//�жϵ�ǰ�����Ƿ�Ϊ��
		if (head.next==null)//������
		{
			System.out.println("����Ϊ�գ��޷�ɾ��");
			return;
		}
		
		HeroNode2 temp=head.next;//����������ָ�룩
		boolean flag=false;//��־�Ƿ��ҵ���ɾ���Ľڵ�
		while (true)
		{
			if (temp==null)//�Ѿ��ҵ���������
			{
				break;
			}
			if (temp.no==no)
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
			//temp.next=temp.next.next;����������
			temp.pre.next=temp.next;
			//�������Ǵ���������⣿
			//����������һ���ڵ㣬�Ͳ���Ҫִ�������Ǿ仰��������ֿ�ָ���쳣
			if(temp.next!=null)
			{
				temp.next.pre=temp.pre;
			}
		}
		else
		{
			System.out.printf("Ҫɾ���� %d �ڵ㲻����\n",no);
		}
	}
}

//����һ��HeroNode��ÿ��HeroNode�������һ���ڵ�
class HeroNode2
{
	public int no;
	public String name;
	public String nickName;
	public HeroNode2 next;//ָ����һ���ڵ㣬Ĭ��Ϊnull
	public HeroNode2 pre;//ָ��ǰһ���ڵ㣬Ĭ��Ϊnull
	//������
	public HeroNode2(int no,String name,String nickName)
	{
		this.no=no;
		this.name=name;
		this.nickName=nickName;
	}
	
	//Ϊ����ʾ���㣬������дtoString
	@Override
	public String toString()
	{
		return "HeroNode2 [no=" + no + ", name=" + name + ", nickName=" + nickName + "]";
	}
}