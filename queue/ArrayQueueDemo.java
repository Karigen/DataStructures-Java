package queue;

/*
 * ����ģ����У������еİ�����
 * 1.���б����������б���ʹ������Ľṹ���洢���е����ݣ�������������������ͼ������maxSize�Ǹö��е����������
 * 2.��Ϊ���е�����������Ƿֱ��ǰ���������ģ������Ҫ��������front��rear�ֱ��¼����ǰ��˵��±꣬front����������������ı䣬��ͼ��ʾ
 * 
 * ���ݴ�����У�
 * 1.��βָ�������ƣ�rear+1����front==rear���ա�
 * 2.��βָ��rearС�ڶ��е�����±�maxSize-1�������ݴ���rear��ָ������Ԫ���У������޷��������ݣ�rear==maxSize-1����������
 * 	rear�Ƕ�����󡾺���
 * 	front�Ƕ�����ǰԪ�ء�������
 */

import java.util.Scanner;

public class ArrayQueueDemo
{

	public static void main(String[] args)
	{
		//����һ��
		//����һ������
		ArrayQueue queue=new ArrayQueue(3);
		char key=' ';//�����û�����
		Scanner scanner=new Scanner(System.in);
		boolean loop=true;
		//���һ���˵�
		while (loop)
		{
			System.out.println("s(show)����ʾ����");
			System.out.println("e(exit)���˳�����");
			System.out.println("a(add)��������ݵ�����");
			System.out.println("g(get)���Ӷ�����ȡ������");
			System.out.println("h(head)���鿴����ͷ������");
			key=scanner.next().charAt(0);//����һ���ַ�
			switch(key)
			{
			case's':
				queue.showQueue();
				break;
			case'a':
				System.out.println("����һ������");
				int value=scanner.nextInt();
				queue.addQueue(value);
				break;
			case'g':
				try
				{
					int res=queue.getQueue();
					System.out.printf("ȡ����������%d\n",res);
				}
				catch (Exception e)
				{
					System.out.println(e.getMessage());
				}
				break;
			case'h'://�鿴����ͷ������
				try
				{
					int res=queue.headQueue();
					System.out.printf("����ͷ��������%d\n",res);
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
		System.out.println("�����˳�");
		
		//����������Ż�
		//1.Ŀǰ����ʹ��һ�ξͲ������ˣ�û�дﵽ���õ�Ч��
		//2.���������ʹ���㷨���Ľ���һ�����ζ��� ȡģ��%
	}

}

//ʹ������ģ�����-��дһ��ArrayQueue��
class ArrayQueue
{
	private int maxSize;//��ʾ������������
	private int front;//����ͷ���±꣩
	private int rear;//����β���±꣩
	private int[] arr;//���������ڴ�����ݣ�ģ�����
	
	//�������еĹ�����
	public ArrayQueue(int arrMaxSize)
	{
		maxSize=arrMaxSize;
		arr=new int[maxSize];
		front=-1;//ָ�����ͷ����������frontʱָ�����ͷ��ǰһ��λ�ã�
		rear=-1;//ָ�����β��ָ�����β�����ݣ������Ƕ������һ�����ݣ�
	}
	
	//�ж϶����Ƿ���
	public boolean isFull()
	{
		return rear==maxSize-1;
	}
	
	//�ж϶����Ƿ�Ϊ��
	public boolean isEmpty()
	{
		return rear==front;
	}
	
	//��Ӷ��е�����
	public void addQueue(int n)
	{
		//�ж϶����Ƿ���
		if (isFull())
		{
			System.out.println("�����������ܼ�������");
			return;
		}
		rear++;//��rear����
		arr[rear]=n;
	}
	
	//��ȡ���е����ݣ�������
	public int getQueue()
	{
		//�ж϶����Ƿ��
		if (isEmpty())
		{
			//ͨ���׳��쳣
			throw new RuntimeException("���пգ�����ȡ����");
		}
		front++;
		return arr[front];
	}
	
	//��ʾ���е���������
	public void showQueue()
	{
		//����
		if (isEmpty())
		{
			System.out.println("���пյģ�û������");
			return;
		}
		for (int i=0;i<arr.length;i++)
		{
			System.out.printf("arr[%d]=%d\n",i,arr[i]);
		}
	}
	
	//��ʾ���е�ͷ���ݣ�ע�ⲻ��ȡ����
	public int headQueue()
	{
		if (isEmpty())
		{
			throw new RuntimeException("���пյģ�û������");
		}
		return arr[front+1];
	}
}