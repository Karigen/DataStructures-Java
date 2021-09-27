package hashtable;

/*
 * ��ϣ��ʵ������һ����������
 */

import java.util.Scanner;

public class HashTableDemo {

    public static void main(String[] args) {
	
	//������ϣ��
	HashTable hashTable=new HashTable(7);
	
	//дһ���򵥵Ĳ˵�
	String key="";
	Scanner scanner=new Scanner(System.in);
	while (true) {
	    System.out.println("add:��ӹ�Ա");
	    System.out.println("list:��ʾ��Ա");
	    System.out.println("find:���ҹ�Ա");
	    System.out.println("exit:�˳�ϵͳ");
	    
	    key=scanner.next();
	    
	    switch(key) {
	    case"add":
		System.out.println("����id");
		int id=scanner.nextInt();
		System.out.println("��������");
		String name=scanner.next();
		
		//������Ա
		Employee employee=new Employee(id, name);
		hashTable.add(employee);
		break;
	    case"list":
		hashTable.list();
		break;
	    case"find":
		System.out.println("������Ҫ���ҵ�id");
		id=scanner.nextInt();
		hashTable.findEmpById(id);
		break;
	    case"exit":
		scanner.close();
		System.exit(0);
		break;
	    default:
		break;
	    }
	}
    }

}

//����HashTable�����������
class HashTable {
    private EmployeeLinkedList[] empLinkedListArray;
    private int size;//��ʾһ���ж���������
    
    //������
    public HashTable(int size) {
	this.size=size;
	//��ʼ��empLinkedListArray
	empLinkedListArray=new EmployeeLinkedList[size];
	//�� ��һ���ӣ���ʱ��Ҫ���˷ֱ��ʼ��ÿ������
	for (int i = 0; i < size; i++) {
	    empLinkedListArray[i]=new EmployeeLinkedList();
	}
    }
    
    //��ӹ�Ա
    public void add(Employee employee) {
	//����Ա��id���õ���Ա��Ӧ����ӵ���������
	int empLinkedListNO=hashFun(employee.id);
	
	//��emp��ӵ���Ӧ��������
	empLinkedListArray[empLinkedListNO].add(employee);
    }
    
    //�������е���������hashTable
    public void list() {
	for (int i = 0; i < size; i++) {
	    empLinkedListArray[i].list(i);
	}
    }
    
    //���������id���ҹ�Ա
    public void findEmpById(int id) {
	//ʹ��ɢ�к���ȷ���������������
	int empLinkedListNO=hashFun(id);
	Employee employee=empLinkedListArray[empLinkedListNO].findEmpById(id);
	if (employee!=null) {//�ҵ�
	    System.out.printf("�ڵ�%d���������ҵ� ��Ա id = %d\n",empLinkedListNO+1,id);
	} else {
	    System.out.println("�ڹ�ϣ���У�û���ҵ��ù�Ա");
	}

    }
    
    //��дɢ�к�����ʹ��һ���򵥵�ȡģ��
    public int hashFun(int id) {
	return id%size;
    }
    
}

//��ʾһ����Ա
class Employee {
    public int id;
    public String name;
    public Employee next;//nextĬ��Ϊnull
    
    public Employee(int id, String name) {
	super();
	this.id = id;
	this.name = name;
    }
}

//����һ��EmployeeLinkedList����ʾ����
class EmployeeLinkedList {
    //ͷָ�룬ָ���һ��Employee�����������������head��ֱ��ָ���һ��Employee
    private Employee head;//Ĭ��null
    
    //��ӹ�Ա������
    //˵��
    //1.�ٶ�������ӹ�Աʱ��id������������id�ķ������Ǵ�С����
    //������ǽ��ù�Աֱ�Ӽ��뵽���������󼴿�
    public void add(Employee employee) {
	//�������ӵ�һ����Ա
	if (head==null) {
	    head=employee;
	    return;
	}
	//������ǵ�һ����Ա����ʹ��һ��������ָ�룬������λ�����
	Employee curEmp=head;
	while (true) {
	    if (curEmp.next==null) {//˵�����������
		break;
	    }
	    curEmp=curEmp.next;//����
	}
	//�˳�ʱֱ�ӽ�employee��������
	curEmp.next=employee;
    }
    
    //��������Ĺ�Ա��Ϣ
    public void list(int no) {
	if (head==null) {//˵������Ϊ��
	    System.out.println("�� "+(no+1)+" ����Ϊ��");
	    return;
	}
	
	System.out.print("�� "+(no+1)+" �������ϢΪ");
	Employee curEmp=head;//����ָ��
	while (true) {
	    System.out.printf(" => id=%d name=%s\t",curEmp.id,curEmp.name);
	    if (curEmp.next==null) {//˵��curEmp�Ѿ������ڵ�
		break;
	    }
	    curEmp=curEmp.next;//���ƣ�����
	}
	System.out.println();
    }
    
    //����id���ҹ�Ա
    //������ҵ����ͷ���Employee�����û���ҵ����ͷ���null
    public Employee findEmpById(int id) {
	//�ж������Ƿ�Ϊ��
	if (head==null) {
	    System.out.println("����Ϊ��");
	    return null;
	}
	
	//����ָ��
	Employee curEmp=head;
	while (true) {//
	    if (curEmp.id==id) {//�ҵ�
		break;//��ʱcurEmp��ָ��Ҫ���ҵĹ�Ա
	    }
	    
	    //�˳�
	    if (curEmp.next==null) {//˵��������ǰ����û���ҵ��ù�Ա
		curEmp=null;
		break;
	    }
	    
	    curEmp=curEmp.next;//����
	}
	
	return curEmp;
	
    }
    
}