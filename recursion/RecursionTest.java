package recursion;

/*
 *�ݹ���ù���
 *1.ִ��һ������ʱ���ʹ���һ���µ��ܱ����Ķ����ռ䣨ջ�ռ䣩
 *2.�����ľֲ������Ƕ����ģ������໥Ӱ��
 *3.���������ʹ�õ����������͵ı������ͻṲ����������͵�����
 *4.�ݹ�������˳��ݹ�������ƽ�������������޵ݹ飬����StackOverflowError
 *5.��һ������ִ����ϣ���������return���ͻ᷵�أ�����˭���ã��ͽ�������ظ�˭��ͬʱ������ִ����ϻ��߷���ʱ���÷���Ҳ��ִ�����
 */

public class RecursionTest {

    public static void main(String[] args) {
	//ͨ����ӡ���⣬�ع˵ݹ�ĵ��û���
	//test(4);
	
	int res=factorial(3);
	System.out.println("res="+res);
    }
    
    //��ӡ����
    public static void test(int n) {
	if (n>2) {
	    test(n-1);
	} //else {
	    System.out.println("n="+n);
	//}
    }
    
    //�׳�����
    public static int factorial(int n) {
	if (n==1) {
	    return 1;
	} else {
	    return factorial(n-1)*n;
	}
    }
}
