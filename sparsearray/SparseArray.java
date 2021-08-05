package sparsearray;

/*
 * 二维数组 转 稀疏数组的思路（五子棋程序存盘退出和续上盘的功能）
 * 1.遍历 原始的二维数组，得到有效数据的个数sum
 * 2.根据sum就可以创建稀疏数组sparseArr int[sum+1][3]
 * 3.将二维数组的有效数据存入到稀疏数组
 * 
 * 稀疏数组转原始的二维数组的思路
 * 1.先读取稀疏数组的第一行，根据第一行的数据，创建原始的二维数组，比如上面的chessArr2=int[11][11]
 * 2.在读取稀疏数组的后几行数据，并赋值原始的二维数组即可
 */

public class SparseArray
{

	public static void main(String[] args)
	{
		//创建一个原始的二维数组 11 * 11
		//0：表示没有棋子，1表示黑子，2表示蓝子
		int chessArr1[][]=new int[11][11];
		chessArr1[1][2]=1;
		chessArr1[2][3]=2;
		chessArr1[4][5]=2;
		
		//输出原始的二维数组
		System.out.println("原始的二维数组");
		for(int[]row:chessArr1)
		{
			for(int data:row)
			{
				System.out.printf("%d\t",data);
			}
			System.out.println();
		}
		
		//将二维数组转化为稀疏数组
		//1.先遍历二维数组得到非0数据的个数
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
		
		//2.创建对应的稀疏数组
		int sparseArr[][]=new int[sum+1][3];
		//给稀疏数组赋值
		sparseArr[0][0]=11;
		sparseArr[0][1]=11;
		sparseArr[0][2]=sum;
		//遍历二维数组，将非0的值存放到稀疏数组中
		int count=0;//count 用于记录是第几个非0数据
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
		//输出稀疏数组的形式
		System.out.println();
		System.out.println("得到的稀疏数组为如下形式");
		for(int i=0;i<sparseArr.length;i++)
		{
			System.out.printf("%d\t%d\t%d\n",sparseArr[i][0],sparseArr[i][1],sparseArr[i][2]);
		}
		System.out.println();
		
		//将稀疏数组恢复成原始的二维数组
		//1.先读取稀疏数组的第一行，根据第一行的数据，创建原始的二维数组
		int chessArr2[][]=new int[sparseArr[0][0]][sparseArr[0][1]];
		
		//2.在读取稀疏数组的后几行数据，并赋值原始的二维数组即可
		for(int i=1;i<sparseArr.length;i++)//多维数组排在的一个的值为length
		{
			chessArr2[sparseArr[i][0]][sparseArr[i][1]]=sparseArr[i][2];
		}
		
		//输出恢复后的二维数组
		System.out.println();
		System.out.println("恢复后的二维数组");
		for(int[]row:chessArr2)
		{
			for(int data:row)
			{
				System.out.printf("%d\t",data);
			}
			System.out.println();
		}
		
		//课后练习（学完再说吧）
		//要求：
		//1.在前面的基础上，将稀疏数组盘存到磁盘上，比如map.data
		//2.恢复原来的数组时，读取map.data进行恢复
		
	}
	
}
