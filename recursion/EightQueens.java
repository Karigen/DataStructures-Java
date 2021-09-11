package recursion;

/*
 * ˵��
 * 1.��һ���ʺ��һ�е�һ��
 * 2.�ڶ����ʺ�ڶ��е�һ���������������У�ֱ���ҵ����ʵ�
 * 3.�������ʺ�ڶ��е�һ���������������У�ֱ���ҵ����ʵ�
 * ������
 * 8.�ڰ˸��ʺ�ڶ��е�һ���������������У�ֱ���ҵ����ʵģ��ҵ���ȷ��
 * 9.��һ���ʺ��һ�еڶ���
 * ������
 */

public class EightQueens {

    //����һ��max��ʾ���ж��ٸ��ʺ�
    int max=8;
    
    //��������array������ʺ��λ�õĽ��
    int[] array=new int[max];
    
    static int count=0;
    static int judgeCount=0;
    
    public static void main(String[] args) {
	//����һ�ѣ�8�ʺ��Ƿ���ȷ
	EightQueens eightQueens=new EightQueens();
	eightQueens.check(0);
	System.out.printf("һ����%d�ⷨ",count);
	System.out.printf("һ���жϳ�ͻ�Ĵ���%d��",judgeCount);// 1.5w
    }
    
    //��дһ�����������õ�n���ʺ�
    //�ر�ע�⣺check ��ÿһ�εݹ�ʱ�����뵽check�ж��� for (int i = 0; i < max; i++) ����˻��л���
    private void check(int n) {
	if (n==max) {//n=8����ʵ8���ʺ����Ȼ�ź���
	    print();
	    return;
	}
	
	//���η���ʺ󣬲��ж��Ƿ��ͻ
	for (int i = 0; i < max; i++) {
	    //�Ȱѵ�ǰ����ʺ� n ���ŵ����еĵ�1��
	    array[n]=i;
	    //�жϵ����õ�n���ʺ�i��ʱ���Ƿ��ͻ
	    if (judge(n)) {//����ͻ
		//���ŷ�n+1���ʺ󣬼���ʼ�ݹ�
		check(n+1);
	    }
	    //�����ͻ���ͼ���ִ�� array[n]=i; ������n���ʺ�����ڱ��еĺ�һ��λ��
	}
    }
    
    //�鿴�����Ƿ��õ�n���ʺ󣬾�ȥ���ûʺ��Ƿ��ǰ���Ѿ��ڷŵĻʺ��ͻ
    /**
     * 
     * @param n ��ʾ��n���ʺ�
     * @return
     */
    private boolean judge(int n) {
	judgeCount++;
	for (int i = 0; i < n; i++) {
	    //˵��
	    //1. array[i]==array[n] ��ʾ�жϵ�n���ʺ��Ƿ��ǰ��ĵ�n-1���ʺ���ͬһ��
	    //2. Math.abs(n-i)==Math.abs(array[n]-array[i]) ��ʾ�жϵ�n���ʺ��Ƿ�͵�i���ʺ���ͬһб��
	    //3.�ж��Ƿ���ͬһ��û�б�Ҫ�ж�
	    if (array[i]==array[n]||Math.abs(n-i)==Math.abs(array[n]-array[i])) {
		return false;
	    }
	}
	return true;
    }
    
    //дһ�����������Խ��ʺ�ڷŵ�λ�����
    private void print() {
	count++;
	for (int i = 0; i < array.length; i++) {
	    System.out.print(array[i]+" ");
	}
	System.out.println();
    }
    
}