package queue;

/*
 * 数组模拟队列（银行列的案例）
 * 1.队列本身是有序列表，若使用数组的结构来存储队列的数据，则队列数组的声明如下图，其中maxSize是该队列的最大容量。
 * 2.因为队列的输出、输入是分别从前后端来处理的，因此需要两个变量front及rear分别记录队列前后端的下标，front会随着数据输出而改变，如图所示
 * 
 * 数据存入队列：
 * 1.将尾指针往后移：rear+1，当front==rear【空】
 * 2.若尾指针rear小于队列的最大下标maxSize-1，则将数据存入rear所指的数组元素中，否则无法存入数据，rear==maxSize-1【队列满】
 * 	rear是队列最后【含】
 * 	front是队列最前元素【不含】
 */

import java.util.Scanner;

public class ArrayQueueDemo
{

	public static void main(String[] args)
	{
		//测试一把
		//创建一个队列
		ArrayQueue queue=new ArrayQueue(3);
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
		
		//问题分析并优化
		//1.目前数组使用一次就不能用了，没有达到复用的效果
		//2.将这个数组使用算法，改进成一个环形队列 取模：%
	}

}

//使用数组模拟队列-编写一个ArrayQueue类
class ArrayQueue
{
	private int maxSize;//表示数组的最大容量
	private int front;//队列头（下标）
	private int rear;//队列尾（下标）
	private int[] arr;//该数组用于存放数据，模拟队列
	
	//创建队列的构造器
	public ArrayQueue(int arrMaxSize)
	{
		maxSize=arrMaxSize;
		arr=new int[maxSize];
		front=-1;//指向队列头部，分析出front时指向队列头的前一个位置；
		rear=-1;//指向队列尾，指向队列尾的数据（即就是队列最后一个数据）
	}
	
	//判断队列是否满
	public boolean isFull()
	{
		return rear==maxSize-1;
	}
	
	//判断队列是否为空
	public boolean isEmpty()
	{
		return rear==front;
	}
	
	//添加队列到数列
	public void addQueue(int n)
	{
		//判断队列是否满
		if (isFull())
		{
			System.out.println("队列满，不能加入数据");
			return;
		}
		rear++;//让rear后移
		arr[rear]=n;
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
		front++;
		return arr[front];
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
		for (int i=0;i<arr.length;i++)
		{
			System.out.printf("arr[%d]=%d\n",i,arr[i]);
		}
	}
	
	//显示队列的头数据，注意不是取数据
	public int headQueue()
	{
		if (isEmpty())
		{
			throw new RuntimeException("队列空的，没有数据");
		}
		return arr[front+1];
	}
}