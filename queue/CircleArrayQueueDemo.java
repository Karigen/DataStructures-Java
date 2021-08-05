package queue;

import java.util.Scanner;

/*
 * 思路如下：
 * 1.front变量的含义做一个调整：front指向队列的第一个元素，也就是说arr[front]就是队列的第一个元素，front的初始值=0
 * 2.rear变量的含义做一个调整：rear指向队列的最后一个元素的后一个位置，因为希望空出一个空间作为约定，rear的初始值=0
 * 3.当队列满时，条件时(rear+1)%maxSzie==front【满】
 * 4.对队列为空的条件，rear==front空
 * 5.当我们这样分析，队列中有效的数据个数(rear+maxSize-front)%maxSize//rear=1 front=0
 * 6.我们就可以在原来的队列上修改得到，一个环形数列
 */

public class CircleArrayQueueDemo
{

	public static void main(String[] args)
	{
		//测试一把
		System.out.println("测试数组模拟环形队列的案例");
		CircleArray queue=new CircleArray(4);//说明设置4，其队列的有效数据最大是3
		char key=' ';//接收用户输入
		Scanner scanner=new Scanner(System.in);
		boolean loop=true;
		//输出一个菜单
		while (loop)
		{
			System.out.println("s(show)：显示队列");
			System.out.println("e(exit)：退出程序");
			System.out.println("a(add)：添加数据到队列");
			System.out.println("g(get)：从队列中取出数据");
			System.out.println("h(head)：查看队列头的数据");
			key=scanner.next().charAt(0);//接收一个字符
			switch(key)
			{
			case's':
				queue.showQueue();
				break;
			case'a':
				System.out.println("输入一个数字");
				int value=scanner.nextInt();
				queue.addQueue(value);
				break;
			case'g':
				try
				{
					int res=queue.getQueue();
					System.out.printf("取出的数据是%d\n",res);
				}
				catch (Exception e)
				{
					System.out.println(e.getMessage());
				}
				break;
			case'h'://查看队列头的数据
				try
				{
					int res=queue.headQueue();
					System.out.printf("队列头的数据是%d\n",res);
				}
				catch (Exception e)
				{
					System.out.println(e.getMessage());
				}
				break;
			case'e':
				scanner.close();
				loop=false;
				break;
			default:
				break;
			}
		}
		System.out.println("程序退出");
	}

}


class CircleArray
{
	private int maxSize;//表示数组的最大容量
	
	//front 变量的含义做一个调整：front就指向队列的第一个元素，也就是arr[front]
	//front 的初始值=0
	private int front;
	
	//rear 变量的含义做一个调整：rear就指向队列的最后一个元素的后一个位置，因为希望空出一个空间作为约定
	//rear 的初始值=0
	private int rear;//队列尾（下标）
	private int[] arr;//该数组用于存放数据，模拟队列
	
	public CircleArray(int arrMaxSize)
	{
		maxSize=arrMaxSize;
		arr=new int[maxSize];
	}
	
	//判断队列是否满
	public boolean isFull()
	{
		return (rear+1)%maxSize==front;
	}
	
	//判断队列是否为空
	public boolean isEmpty()
	{
		return rear==front;
	}
	
	//添加数据到队列
	public void addQueue(int n)
	{
		//判断队列是否满
		if (isFull())
		{
			System.out.println("队列满，不能加入数据");
			return;
		}
		//直接将数据加入
		arr[rear]=n;
		//将rear后移，这里必须考虑取模
		rear=(rear+1)%maxSize;
	}
	
	//获取队列的数据，出队列
	public int getQueue()
	{
		//判断队列是否空
		if (isEmpty())
		{
			//通过抛出异常
			throw new RuntimeException("队列空，不能取数据");
		}
		//这里需要分析出front时指向队列的第一个元素
		//1.先把front对应的值保留到一个临时变量
		//2.将front后移，考虑取模
		//3.将临时保存的变量返回
		int value=arr[front];
		front=(front+1)%maxSize;
		return value;
	}
	
	//显示队列的所有数据
	public void showQueue()
	{
		//遍历
		if (isEmpty())
		{
			System.out.println("队列空的，没有数据");
			return;
		}
		//思路：从front开始遍历，遍历多少个元素
		//动脑筋
		for (int i=front;i<front+size();i++)
		{
			System.out.printf("arr[%d]=%d\n",i%maxSize,arr[i%maxSize]);
		}
	}
	
	//求出当前队列有效数据的个数
	public int size()
	{
		//rear=2
		//front=1
		//maxSize=3
		return (rear+maxSize-front)%maxSize;
	}
	
	//显示队列的头数据，注意不是取数据
	public int headQueue()
	{
		if (isEmpty())
		{
			throw new RuntimeException("队列空的，没有数据");
		}
		return arr[front];
	}
}