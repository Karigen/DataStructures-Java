package linkedlist;

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
		//singleLikedList.add(hero1);
		//singleLikedList.add(hero4);
		//singleLikedList.add(hero2);
		//singleLikedList.add(hero3);
		
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
		singleLikedList.del(2);
		singleLikedList.del(3);
		System.out.println("ɾ������������");
		singleLikedList.list();
	}

}

//����SingleLinkedList�������ǵ�Ӣ��
class SingleLikedList
{
	//�ȳ�ʼ��һ��ͷ�ڵ�,ͷ�ڵ㲻Ҫ������Ҫ��ž��������
	private HeroNode head=new HeroNode(0,"","");
	
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
	public HeroNode next;
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