package linkedlist;

/*
 * 链表设计思路：
 * 添加（创建）
 * 1.先创建一个head头节点，作用就是表示链表的头
 * 2.后面我们每添加一个节点，。就直接加入到链表的最后
 * 
 * 遍历
 * 1.通过一个辅助变量遍历，帮助遍历整个链表
 * 
 * 需要按照编号的顺序添加
 * 1.首先找到新添加的节点的位置，是通过辅助变量（指针），通过遍历来搞定的
 * 2.新的节点next=temp.next
 * 3.将temp.next=新的节点
 * 
 * 修改节点功能
 * 1.先找到该节点，通过遍历
 * 2.temp.name=newHeroNode.name;
 *   temp.nickName=newHeroNode.name;
 * 
 * 从链表中删除一个节点的思路
 * 1.我们先找到需要删除的这个节点的前一个节点temp
 * 2.temp.next=temp.next.next
 * 3.被删除的节点，将不会有其他引用指向，会被垃圾回收机制回收
 */

public class SingleLinkedListDemo
{

	public static void main(String[] args)
	{
		//进行测试
		//先创建节点
		HeroNode hero1=new HeroNode(1, "宋江", "及时雨");
		HeroNode hero2=new HeroNode(2, "卢俊义", "玉麒麟");
		HeroNode hero3=new HeroNode(3, "吴用", "智多星");
		HeroNode hero4=new HeroNode(4, "林冲", "豹子头");
		
		//创建一个链表
		SingleLikedList singleLikedList=new SingleLikedList();
		//加入
		//singleLikedList.add(hero1);
		//singleLikedList.add(hero4);
		//singleLikedList.add(hero2);
		//singleLikedList.add(hero3);
		
		//加入按照编号的顺序
		singleLikedList.addByOrder(hero1);
		singleLikedList.addByOrder(hero4);
		singleLikedList.addByOrder(hero2);
		singleLikedList.addByOrder(hero3);
		
		//显示一把
		singleLikedList.list();
		
		//测试修改节点的的代码
		HeroNode newHerpNode=new HeroNode(2, "小卢", "小尾巴");
		singleLikedList.update(newHerpNode);
		System.out.println("修改后的链表情况");
		singleLikedList.list();
		
		//删除一个节点
		singleLikedList.del(1);
		singleLikedList.del(4);
		singleLikedList.del(2);
		singleLikedList.del(3);
		System.out.println("删除后的链表情况");
		singleLikedList.list();
	}

}

//定义SingleLinkedList管理我们的英雄
class SingleLikedList
{
	//先初始化一个头节点,头节点不要动，不要存放具体的数据
	private HeroNode head=new HeroNode(0,"","");
	
	//添加节点到单向链表
	//思路，当不考虑编号顺序时
	//1.找到当前链表的最后节点
	//2.将最后这个节点的next指向新的节点
	public void add(HeroNode heroNode)
	{
		//因为head节点不能动，因此我们需要一个辅助变量temp
		HeroNode temp=head;
		//遍历链表，找到最后
		while (true)
		{
			//找到链表的最后
			if(temp.next==null)
			{
				break;
			}
			//如果没有找到最后,就将temp后移
			temp=temp.next;
		}
		//当退出while循环时，temp就指向了链表的最后
		temp.next=heroNode;
	}
	
	//第二种方式在添加英雄时，根据排名将英雄插入到指定位置
	//（如果有这个排名，则添加失败，并给出提示）
	public void addByOrder(HeroNode heroNode)
	{
		//因为头节点不能动，因此我们仍然通过一个辅助指针（变量）来帮助我们找到添加的位置
		//因为单链表，因此我们找的temp是位于添加位置的前一个节点，否则插入不了
		HeroNode temp=head;
		boolean  flag=false;//flag标志添加的编号是否存在，默认为false
		while (true)
		{
			if (temp.next==null)//说明temp已经到链表最后
			{
				break;//
			}
			if (temp.next.no>heroNode.no)//位置找到，就在temp的后面插入
			{
				break;
			}
			else if(temp.next.no==heroNode.no)//说明希望添加的heronode的编号已经存在
			{
				flag=true;//说明编号存在
				break;
			}
			temp=temp.next;//后移遍历当前链表
		}
		//判断flag的值
		if (flag)//不能添加，说明编号存在
		{
			System.out.printf("准备插入的英雄的编号 %d 已经存在，不能插入\n",heroNode.no);
		}
		else
		{
			//插入到链表中，temp的后面
			heroNode.next=temp.next;
			temp.next=heroNode;
		}
	}
	
	//修改节点的信息，根据编号来修该，即no不能该
	//1.根据newHeroNode的no来修改即可
	public void update(HeroNode newHeroNode)
	{
		//判断是否空
		if (head.next==null)
		{
			System.out.println("链表为空");
			return;
		}
		//找到需要修改的节点，根据no编号
		//定义一个辅助变量
		HeroNode temp=head.next;
		boolean flag=false;//表示是否找到该节点
		while (true)
		{
			if (temp==null)
			{
				break;//已经遍历完链表
			}
			if (temp.no==newHeroNode.no)
			{
				//找到
				flag=true;
				break;
			}
			temp=temp.next;
		}
		//根据flag判断是否找到要修改的节点
		if (flag)
		{
			temp.name=newHeroNode.name;
			temp.nickName=newHeroNode.nickName;
		}
		else//没有找到
		{
			System.out.printf("没有找到编号 %d 的节点，不能修改\n",newHeroNode.no);
		}
	}
	
	//删除节点
	//思路
	//1.head节点但不能动，因此我们需要一个temp辅助节点找到待删除节点的前一个节点
	//2.说明我们在比较时，是temp.next,no和需要删除的节点的no比较
	public void del(int no)
	{
		HeroNode temp=head;
		boolean flag=false;//标志是否找到待删除的节点
		while (true)
		{
			if (temp.next==null)//已经找到链表的最后
			{
				break;
			}
			if (temp.next.no==no)
			{
				//找到了待删除节点的前一个节点
				flag=true;
				break;
			}
			temp=temp.next;
		}
		//判断flag
		if (flag)//找到
		{
			temp.next=temp.next.next;
		}
		else
		{
			System.out.printf("要删除的 %d 节点不存在\n",no);
		}
	}
	
	//显示链表【遍历】
	public void list()
	{
		//判断链表是否为空
		if (head.next==null)
		{
			System.out.println("链表为空");
			return;
		}
		//因为头节点不能动，因此我们需要一个辅助变量进行遍历
		HeroNode temp=head.next;
		while (true)
		{
			//判断是否到链表最后
			if (temp==null)
			{
				break;
			}
			//输出节点的信息
			System.out.println(temp);
			//将temp后移
			temp=temp.next;
		}
	}
}

//定义一个HeroNode，每个HeroNode对象就是一个节点
class HeroNode
{
	public int no;
	public String name;
	public String nickName;
	public HeroNode next;
	//构造器
	public HeroNode(int no,String name,String nickName)
	{
		this.no=no;
		this.name=name;
		this.nickName=nickName;
	}
	
	//为了显示方便，我们重写toString
	@Override
	public String toString()
	{
		return "HeroNode [no=" + no + ", name=" + name + ", nickName=" + nickName + "]";
	}
}