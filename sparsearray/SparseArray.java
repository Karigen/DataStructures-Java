package sparsearray;

/*
 * ��ά���� ת ϡ�������˼·���������������˳��������̵Ĺ��ܣ�
 * 1.���� ԭʼ�Ķ�ά���飬�õ���Ч���ݵĸ���sum
 * 2.����sum�Ϳ��Դ���ϡ������sparseArr int[sum+1][3]
 * 3.����ά�������Ч���ݴ��뵽ϡ������
 * 
 * ϡ������תԭʼ�Ķ�ά�����˼·
 * 1.�ȶ�ȡϡ������ĵ�һ�У����ݵ�һ�е����ݣ�����ԭʼ�Ķ�ά���飬���������chessArr2=int[11][11]
 * 2.�ڶ�ȡϡ������ĺ������ݣ�����ֵԭʼ�Ķ�ά���鼴��
 */

public class SparseArray
{

	public static void main(String[] args)
	{
		//����һ��ԭʼ�Ķ�ά���� 11 * 11
		//0����ʾû�����ӣ�1��ʾ���ӣ�2��ʾ����
		int chessArr1[][]=new int[11][11];
		chessArr1[1][2]=1;
		chessArr1[2][3]=2;
		chessArr1[4][5]=2;
		
		//���ԭʼ�Ķ�ά����
		System.out.println("ԭʼ�Ķ�ά����");
		for(int[]row:chessArr1)
		{
			for(int data:row)
			{
				System.out.printf("%d\t",data);
			}
			System.out.println();
		}
		
		//����ά����ת��Ϊϡ������
		//1.�ȱ�����ά����õ���0���ݵĸ���
		int sum=0;
		for(int i=0;i<chessArr1.length;i++)
		{
			for(int j=0;j<11;j++)
			{
				if(chessArr1[i][j]!=0)
				{
					sum++;
				}
			}
		}
		System.out.println("sum="+sum);
		
		//2.������Ӧ��ϡ������
		int sparseArr[][]=new int[sum+1][3];
		//��ϡ�����鸳ֵ
		sparseArr[0][0]=11;
		sparseArr[0][1]=11;
		sparseArr[0][2]=sum;
		//������ά���飬����0��ֵ��ŵ�ϡ��������
		int count=0;//count ���ڼ�¼�ǵڼ�����0����
		for(int i=0;i<chessArr1.length;i++)
		{
			for(int j=0;j<11;j++)
			{
				if(chessArr1[i][j]!=0)
				{
					count++;
					sparseArr[count][0]=i;
					sparseArr[count][1]=j;
					sparseArr[count][2]=chessArr1[i][j];
				}
			}
		}
		//���ϡ���������ʽ
		System.out.println();
		System.out.println("�õ���ϡ������Ϊ������ʽ");
		for(int i=0;i<sparseArr.length;i++)
		{
			System.out.printf("%d\t%d\t%d\n",sparseArr[i][0],sparseArr[i][1],sparseArr[i][2]);
		}
		System.out.println();
		
		//��ϡ������ָ���ԭʼ�Ķ�ά����
		//1.�ȶ�ȡϡ������ĵ�һ�У����ݵ�һ�е����ݣ�����ԭʼ�Ķ�ά����
		int chessArr2[][]=new int[sparseArr[0][0]][sparseArr[0][1]];
		
		//2.�ڶ�ȡϡ������ĺ������ݣ�����ֵԭʼ�Ķ�ά���鼴��
		for(int i=1;i<sparseArr.length;i++)//��ά�������ڵ�һ����ֵΪlength
		{
			chessArr2[sparseArr[i][0]][sparseArr[i][1]]=sparseArr[i][2];
		}
		
		//����ָ���Ķ�ά����
		System.out.println();
		System.out.println("�ָ���Ķ�ά����");
		for(int[]row:chessArr2)
		{
			for(int data:row)
			{
				System.out.printf("%d\t",data);
			}
			System.out.println();
		}
		
		//�κ���ϰ��ѧ����˵�ɣ�
		//Ҫ��
		//1.��ǰ��Ļ����ϣ���ϡ�������̴浽�����ϣ�����map.data
		//2.�ָ�ԭ��������ʱ����ȡmap.data���лָ�
		
	}
	
}
