package linkedlist;

import java.util.Stack;

//��ʾStack�Ļ���ʹ��
public class TeskStack
{

	public static void main(String[] args)
	{
		Stack<String> stack=new Stack<String>();
		
		//��ջ
		stack.add("jack");
		stack.add("tom");
		stack.add("smith");
		
		//ȡ��
		//smith��tom��jack
		while (stack.size()>0)
		{
			System.out.println(stack.pop());//pop���ǽ�ջ��������ȡ��
		}
	}

}
