package tree;

/*
 * ���Ǿ����������ʵ���ȫ��������ÿ���ڵ��ֵ�����ڻ���������Һ��ӽڵ��ֵ����Ϊ�󶥶ѣ�û��Ҫ��ڵ�����ӵ�ֵ���Һ��ӵ�ֵ�Ĵ�С��ϵ
 * ÿ���ڵ��ֵ��С�ڻ���������Һ��ӽڵ��ֵ����ΪС����
 * ������ô󶥶ѣ��������С����
 */

import java.text.SimpleDateFormat;
//import java.util.Arrays;
import java.util.Date;

public class HeapSort {

    public static void main(String[] args) {
	//Ҫ�����������������
	//int[] arr= {4, 6, 8, 5, 9, -1, 90, 89, 56, -999};
	
	//����Ҫ��80000�������������
	int[]arr=new int[80000];
	for (int i = 0; i < 80000; i++) {
	    arr[i]=(int)(Math.random()*8000000);//����һ��[0,8000000)��
	}
	
	Date date1=new Date();
	SimpleDateFormat simpleDateFormat=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
	String date1Str=simpleDateFormat.format(date1);
	System.out.println("����ǰ��ʱ��="+date1Str);
	
	heapSort(arr);
	
	Date date2=new Date();
	String date2Str=simpleDateFormat.format(date2);
	System.out.println("������ʱ��="+date2Str);
    }
    
    //��дһ��������ķ���
    public static void heapSort(int[] arr) {
	int temp=0;
	//System.out.println("������");
	
	/*
	
	//�ֲ����
	adjustHeap(arr, 1, arr.length);
	System.out.println("��һ��"+Arrays.toString(arr));//4, 9, 8, 5, 6
	
	adjustHeap(arr, 0, arr.length);
	System.out.println("�ڶ���"+Arrays.toString(arr));//9, 6, 8, 5, 4
	
	*/
	
	//������ǵ����մ���
	//���������й�����һ���ѣ���������������ѡ��󶥶ѻ�С����
	for (int i = arr.length/2-1; i >= 0; i--) {
	    adjustHeap(arr, i, arr.length);
	}
	
	//���Ѷ�Ԫ����ĩβԪ�ؽ����������Ԫ�ء�����������ĩ��
	//���µ����ṹ��ʹ������Ѷ��壬Ȼ�����������ǰ�Ѷ�Ԫ���뵱ǰĩβԪ�أ�����ִ�е���+�������裬ֱ��������������
	for (int j = arr.length-1; j > 0; j--) {
	    //����
	    temp=arr[j];
	    arr[j]=arr[0];
	    arr[0]=temp;
	    adjustHeap(arr, 0, j);
	}
	
	//System.out.println("����="+Arrays.toString(arr));
    }
    
    //��һ�����飨����������������һ���󶥶�
    /**
     * ���ܣ���ɽ���i��Ӧ�ķ�Ҷ�ӽڵ���������ɴ󶥶�
     * ������{4, 6, 8, 5, 9}=��adjustHeap(i = 1)��=>{4, 9, 8, 5, 6}
     * {4, 9, 8, 5, 6}=��adjustHeap(i = 0)��=>{9, 6, 8, 5, 4}
     * @param arr ������������
     * @param i ��ʾ��Ҷ�ӽڵ��������е�����
     * @param length ��ʾ�Զ��ٸ�Ԫ�ؼ���������length�����𽥵ļ���
     */
    public static void adjustHeap(int[] arr, int i, int length) {
	int temp=arr[i];//��ȡ����ǰԪ�ص�ֵ����������ʱ����
	
	//��ʼ����
	//˵��
	//1.k = i*2+1��k��i�ڵ�����ӽڵ�
	for (int k = i*2+1; k < length; k=k*2+1) {
	    if (k+1<length&&arr[k]<arr[k+1]) {//˵�����ӽڵ��ֵС�����ӽڵ��ֵ
		k++;//kָ�����ӽڵ�
	    }
	    
	    if (arr[k]>temp) {//����ӽڵ���ڸ��ڵ�
		arr[i]=arr[k];//�ѽϴ��ֵ������ǰ�ڵ�
		i=k;//iָ��k������ѭ���Ƚ�
	    } else {
		break;
	    }
	}
	
	//��forѭ�������������Ѿ�����iΪ���ڵ���������ֵ������������ֲ���
	arr[i]=temp;//��tempֵ�ŵ��������λ��
    }
}