package linkedlist;

import java.util.Stack;

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
 * 
 * 单链表反转思路：
 * 1.先定义一个节点reverseHead=new HeroNode();
 * 2.从头到尾遍历原来的链表，每遍历一个节点，就将其取出，并放在新的链表reverseHead的最前端
 * 3.原来的链表的head.next=reverseHead.next
 * 
 * 从未到头打印单链表
 * 1.上面的题的要求就是逆序打印单链表。
 * 2.方式1：先将单链表进行反转操作，然后在遍历即可，这样做的问题是会破坏原来的单链表的结构，不建议
 * 3.方式2：可以利用栈这个数据结构，将各个节点压入到栈中，利用栈的先进后出的特点，就实现了逆序打印的效果
 * 
 * 添加时，因为遍历要遍历到最后一个结点，循环条件为 cur.next!=null ，这样遍历之后cur就是尾结点，所以将从头结点遍历较方便，这样将空表的情况也包含进去了
 * 查找时，因为要比对当前结点的内容（头结点不能有内容，或者内容为空），所以遍历时不能从头结点开始，应该从首结点开始，循环条件应为 cur!=null ，（如果是cur.next!=null则不会比对最后一个结点的内容），这样才会完整的比较各结点
 * 
 * 总结
 * 添加：头结点开始，循环条件为 cur.next!=null（一直是前一个结点）
 * 查找：首结点开始，循环条件为 cur!=null（遍历完全）
 * 或者循环条件直接为true，在循环内部判断
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
		singleLikedList.add(hero1);
		singleLikedList.add(hero4);
		singleLikedList.add(hero2);
		singleLikedList.add(hero3);
		
		//测试一下单链表的反转功能
		System.out.println("原来链表的情况");
		singleLikedList.list();
		System.out.println("反转单链表");
		reverseList(singleLikedList.getHead());
		singleLikedList.list();
		
		System.out.println("测试逆序打印单链表，没有改变链表的结构");
		reversePrint(singleLikedList.getHead());
		
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
		System.out.println("删除后的链表情况");
		singleLikedList.list();
		
		//测试一下 求单链表中有效节点的个数
		System.out.println("有效的节点个数="+getLength(singleLikedList.getHead()));//2
		
		//测试一下看看是否得到了倒数第K个节点
		HeroNode res=findLastIndexNode(singleLikedList.getHead(),3);
		System.out.println("res="+res);
	}
	
	//方式2：
	//可以利用栈这个数据结构，将各个节点压入到栈中，利用栈的先进后出的特点，就实现了逆序打印的效果
	public static void reversePrint(HeroNode head)
	{
		if (head.next==null)
		{
			return;//空链表，不能打印
		}
		//创建一个栈，将各个节点压入栈中
		Stack<HeroNode> stack=new Stack<HeroNode>();
		HeroNode cur=head.next;
		//将链表的所有节点压入栈
		while (cur!=null)
		{
			stack.push(cur);
			cur=cur.next;//cur后移，这样就可以压入下一个节点
		}
		//将栈中的节点进行打印，pop出栈
		while (stack.size()>0)
		{
			System.out.println(stack.pop());//stack的特点是先进后出
		}
	}
	
	//将单链表进行反转
	public static void reverseList(HeroNode head)
	{
		//如果当前链表为空，或者只有一个节点，无需反转，直接返回
		if (head.next==null||head.next.next==null)
		{
			return;
		}
		//定义一个辅助的指针（变量），帮助我们遍历原来的链表
		HeroNode cur=head.next;
		HeroNode next=null;//指向当前节点[cur]的下一个节点
		HeroNode reverseHead=new HeroNode(0, "", "");
		//遍历原来的链表，每遍历一个节点，就将其取出，并放在新的链表reverseHead的最前端
		//动脑筋
		while (cur!=null)
		{
			next=cur.next;//先暂时保存当前节点的下一个节点，因为后面需要使用
			cur.next=reverseHead.next;//将cur的下一个节点指向新链表的最前端
			reverseHead.next=cur;//将cur连接到新的链表上
			cur=next;//让cur后移
		}
		//将head.next指向reverseHead.next，实现了单链表的反转
		head.next=reverseHead.next;
	}
	
	//查找单链表中的倒数第k个节点【新浪面试题】
	//思路
	//1.编写一个方法，接收head节点，同时接收一个index
	//2.index表示倒数第index个节点
	//3.先把链表从头到尾遍历，得到链表的总的长度 getLength
	//4.得到size后，我们从链表的第一个开始遍历(size-index)个，就可以得到
	//5.如果找到了，就返回该节点，否则返回null
	public static HeroNode findLastIndexNode(HeroNode head,int index)
	{
		//判断如果链表为空，返回null
		if (head.next==null)
		{
			return null;//没有找到
		}
		//第一个遍历得到链表的长度（节点个数）
		int size=getLength(head);
		//第二次遍历size-index位置，就是我们倒数的第K个节点
		//先做一个index的校验
		if (index<=0||index>size)
		{
			return null;
		}
		//定义辅助变量,for 循环定位到倒数的index
		HeroNode cur=head.next;//3 //3-1=2
		for (int i=0;i<size-index;i++)
		{
			cur=cur.next;
		}
		return cur;
	}
	
	//方法：获取到单链表的结点的个数（如果是带头结点的链表，需要不统计头节点）
	/**
	 * 
	 * @param head 链表的头节点
	 * @return 返回的是有效节点的个数
	 */
	public static int getLength(HeroNode head)
	{
		if (head.next==null)//空链表
		{
			return 0;
		}
		int length=0;
		//定义一个辅助的变量，这里我们没有统计头节点
		HeroNode cur=head.next;
		while (cur!=null)
		{
			length++;
			cur=cur.next;//遍历
		}
		return length;
	}
	//合并两个有序的单链表，合并之后的链表依然有序【课后联系】
}

//定义SingleLinkedList管理我们的英雄
class SingleLikedList
{
	//先初始化一个头节点,头节点不要动，不要存放具体的数据
	private HeroNode head=new HeroNode(0,"","");
	
	//返回头节点
	public HeroNode getHead()
	{
		return head;
	}

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
	
	//修改节点的信息，根据编号来修该，即no不能改
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
	public HeroNode next;//指向下一个节点
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