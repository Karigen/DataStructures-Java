package linkedlist;

/*
 * 双向链表
 * 1.遍历和单链表一样，只是可以向前，也可以向后
 * 2.添加（默认添加到双向链表的最后）
 *  1.先找到双向链表的最后这个节点
 *  2.temp.next=newHeroNode
 *  3.mewHeroNode.pre=temp
 * 3.修改思路和原来的单向链表一样
 * 4.删除
 *  1.因为是双向链表，因此，我们可以实现自我删除某个节点
 *  2.直接找到要删除的这个节点，比如temp
 *  3.temp.pre=temp.next
 *  4.temp.next.pre=temp.pre
 *  
 *  pre next 看成链子即可
 *  增删时都是现连后断
 *  
 *  头结点/尾结点不算在正经链表内，即头结点/尾结点不入环，只用其next指针指向环内结点
 */

public class DoubleLinkedListDemo
{

	public static void main(String[] args)
	{
		//测试
		System.out.println("双向链表的测试");
		//先创建节点
		HeroNode2 hero1=new HeroNode2(1, "宋江", "及时雨");
		HeroNode2 hero2=new HeroNode2(2, "卢俊义", "玉麒麟");
		HeroNode2 hero3=new HeroNode2(3, "吴用", "智多星");
		HeroNode2 hero4=new HeroNode2(4, "林冲", "豹子头");
		//创建一个双向链表对象
		DoubleLinkedList doubleLinkedList=new DoubleLinkedList();
		doubleLinkedList.add(hero1);
		doubleLinkedList.add(hero2);
		doubleLinkedList.add(hero3);
		doubleLinkedList.add(hero4);
		
		doubleLinkedList.list();
		
		//修改
		HeroNode2 newHeroNode2=new HeroNode2(4, "公孙胜", "入云龙");
		doubleLinkedList.update(newHeroNode2);
		System.out.println("修改后的链表情况");
		doubleLinkedList.list();
		
		//删除
		doubleLinkedList.del(3);
		System.out.println("删除后的链表情况");
		doubleLinkedList.list();
		
		//作业
		//双向链表的第二种添加方式：按照编号顺序
		//按照单链表的顺序添加，稍作修改即可
	}

}

//创建一个双向链表的类
class DoubleLinkedList
{
	//先初始化一个头节点,头节点不要动，不要存放具体的数据
	private HeroNode2 head=new HeroNode2(0,"","");
	
	//返回头节点
	public HeroNode2 getHead()
	{
		return head;
	}

	//遍历双向链表的方法
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
		HeroNode2 temp=head.next;
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
	
	//添加一个节点到双向链表的最后
	public void add(HeroNode2 heroNode)
	{
		//因为head节点不能动，因此我们需要一个辅助变量temp
		HeroNode2 temp=head;
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
		//形成一个双向链表
		temp.next=heroNode;
		heroNode.pre=temp;
	}
	
	//修改一个节点的内容，可以看到双向链表的节点内容修改和单向链表一样
	//只是节点的类型改成HeroNode2
	public void update(HeroNode2 newHeroNode)
	{
		//判断是否空
		if (head.next==null)
		{
			System.out.println("链表为空");
			return;
		}
		//找到需要修改的节点，根据no编号
		//定义一个辅助变量
		HeroNode2 temp=head.next;
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
	
	//从双向链表中删除一个节点
	//说明
	//1.对于双向链表，我们可以直接找到要删除的这个节点
	//2.找到后，自我删除即可
	public void del(int no)
	{
		
		//判断当前链表是否为空
		if (head.next==null)//空链表
		{
			System.out.println("链表为空，无法删除");
			return;
		}
		
		HeroNode2 temp=head.next;//辅助变量（指针）
		boolean flag=false;//标志是否找到待删除的节点
		while (true)
		{
			if (temp==null)//已经找到链表的最后
			{
				break;
			}
			if (temp.no==no)
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
			//temp.next=temp.next.next;【单项链表】
			temp.pre.next=temp.next;
			//这里我们大代码有问题？
			//如果是左最后一个节点，就不需要执行下面那句话，否则出现空指针异常
			if(temp.next!=null)
			{
				temp.next.pre=temp.pre;
			}
		}
		else
		{
			System.out.printf("要删除的 %d 节点不存在\n",no);
		}
	}
}

//定义一个HeroNode，每个HeroNode对象就是一个节点
class HeroNode2
{
	public int no;
	public String name;
	public String nickName;
	public HeroNode2 next;//指向下一个节点，默认为null
	public HeroNode2 pre;//指向前一个节点，默认为null
	//构造器
	public HeroNode2(int no,String name,String nickName)
	{
		this.no=no;
		this.name=name;
		this.nickName=nickName;
	}
	
	//为了显示方便，我们重写toString
	@Override
	public String toString()
	{
		return "HeroNode2 [no=" + no + ", name=" + name + ", nickName=" + nickName + "]";
	}
}