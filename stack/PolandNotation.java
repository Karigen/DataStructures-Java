package stack;

/*
 *�沨���������(3+4)*5-6 => 3 4 + 5 * 6 -��
 *1.��������ɨ�裬��3��4ѹ��ջ
 *2.����+���������˵���4��3��4Ϊջ��Ԫ�أ�3Ϊ�Ŷ�Ԫ�أ��������3+4��ֵ����7���ٽ�7��ջ
 *3.��5��ջ��
 *4.��������*���������˵���5��7�������7*5=35����35��ջ��
 *5.��6��ջ��
 *6.�����-������������35-6��ֵ����29���ɴ˵ó����ս����
 */

import java.util.List;
import java.util.ArrayList;
import java.util.Stack;

public class PolandNotation {
    public static void main(String[] args) {
	//�ȶ���һ���沨�����ʽ
	//(3+4)*5-6 => 3 4 + 5 * 6 -
	//˵��Ϊ�˷��㣬�沨�����ʽ�����ֺͷ���ʹ�ÿո����
	String suffixExpression="3 4 + 5 * 6 -";
	
	//˼·
	//1.�Ƚ�"3 4 + 5 * 6 -"�ŵ�ArrayList��
	//2.��ArrayList���ݸ�һ������������ArrayList���վ��ɼ���
	List<String> rpnList=getListString(suffixExpression);
	System.out.println("rpnList="+rpnList);
	
	int res=calculate(rpnList);
	System.out.println("����Ľ����="+res);
    }
    //��һ���沨�����ʽ�����ν�������������뵽һ��ArrayList��
    public static List<String> getListString(String suffixExpression) {
	//��suffixExpression�ָ�
	String[] split=suffixExpression.split(" ");
	List<String> list=new ArrayList<String>();
	for (String ele : split) {
	    list.add(ele);
	}
	return list;
    }
    
    //��ɶ��沨�����ʽ�ļ���
    //1.��������ɨ�裬��3��4ѹ��ջ
    //2.����+���������˵���4��3��4Ϊջ��Ԫ�أ�3Ϊ�Ŷ�Ԫ�أ��������3+4��ֵ����7���ٽ�7��ջ
    //3.��5��ջ����������*���������˵���5��7�������7*5=35����35��ջ����6��ջ�������-������������35-6��ֵ����29���ɴ˵ó����ս����
    public static int calculate(List<String> ls) {
	//����ջ��ֻ��Ҫһ��ջ����
	Stack<String> stack=new Stack<String>();
	//����ls
	for (String item : ls) {
	    //����ʹ��������ʽ��ȡ����
	    if (item.matches("\\d+")) {//ƥ����Ƕ�λ��
		//��ջ
		stack.push(item);
	    } else {
		//pop���������������㣬����ջ
		int num2=Integer.parseInt(stack.pop());
		int num1=Integer.parseInt(stack.pop());
		int res=0;
		if (item.equals("+")) {
		    res=num1+num2;
		} else if (item.equals("-")) {
		    res=num1-num2;
		} else if (item.equals("*")) {
		    res=num1*num2;
		} else if (item.equals("/")) {
		    res=num1/num2;
		} else {
		    throw new RuntimeException("���������");
		}
		//��res��ջ
		stack.push(""+res);
	    }
	}
	//�������stack�е�������������
	return Integer.parseInt(stack.pop());
    }
}
