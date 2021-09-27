package hashtable;

/*
 * 哈希表实际上是一个链表数组
 */

import java.util.Scanner;

public class HashTableDemo {

    public static void main(String[] args) {
	
	//创建哈希表
	HashTable hashTable=new HashTable(7);
	
	//写一个简单的菜单
	String key="";
	Scanner scanner=new Scanner(System.in);
	while (true) {
	    System.out.println("add:添加雇员");
	    System.out.println("list:显示雇员");
	    System.out.println("find:查找雇员");
	    System.out.println("exit:退出系统");
	    
	    key=scanner.next();
	    
	    switch(key) {
	    case"add":
		System.out.println("输入id");
		int id=scanner.nextInt();
		System.out.println("输入名字");
		String name=scanner.next();
		
		//创建雇员
		Employee employee=new Employee(id, name);
		hashTable.add(employee);
		break;
	    case"list":
		hashTable.list();
		break;
	    case"find":
		System.out.println("请输入要查找的id");
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

//创建HashTable管理多条链表
class HashTable {
    private EmployeeLinkedList[] empLinkedListArray;
    private int size;//表示一共有多少条链表
    
    //构造器
    public HashTable(int size) {
	this.size=size;
	//初始化empLinkedListArray
	empLinkedListArray=new EmployeeLinkedList[size];
	//？ 留一个坑，这时不要忘了分别初始化每个链表
	for (int i = 0; i < size; i++) {
	    empLinkedListArray[i]=new EmployeeLinkedList();
	}
    }
    
    //添加雇员
    public void add(Employee employee) {
	//根据员工id，得到该员工应当添加到哪条链表
	int empLinkedListNO=hashFun(employee.id);
	
	//将emp添加到对应的链表中
	empLinkedListArray[empLinkedListNO].add(employee);
    }
    
    //遍历所有的链表，遍历hashTable
    public void list() {
	for (int i = 0; i < size; i++) {
	    empLinkedListArray[i].list(i);
	}
    }
    
    //根据输入的id查找雇员
    public void findEmpById(int id) {
	//使用散列函数确定到哪条链表查找
	int empLinkedListNO=hashFun(id);
	Employee employee=empLinkedListArray[empLinkedListNO].findEmpById(id);
	if (employee!=null) {//找到
	    System.out.printf("在第%d条链表中找到 雇员 id = %d\n",empLinkedListNO+1,id);
	} else {
	    System.out.println("在哈希表中，没有找到该雇员");
	}

    }
    
    //编写散列函数，使用一个简单的取模法
    public int hashFun(int id) {
	return id%size;
    }
    
}

//表示一个雇员
class Employee {
    public int id;
    public String name;
    public Employee next;//next默认为null
    
    public Employee(int id, String name) {
	super();
	this.id = id;
	this.name = name;
    }
}

//创建一个EmployeeLinkedList，表示链表
class EmployeeLinkedList {
    //头指针，指向第一个Employee，因此我们这个链表的head是直接指向第一个Employee
    private Employee head;//默认null
    
    //添加雇员到链表
    //说明
    //1.假定，当添加雇员时，id是自增长，即id的分配总是从小到大
    //因此我们将该雇员直接加入到本链表的最后即可
    public void add(Employee employee) {
	//如果是添加第一个雇员
	if (head==null) {
	    head=employee;
	    return;
	}
	//如果不是第一个雇员，则使用一个辅助的指针，帮助定位到最后
	Employee curEmp=head;
	while (true) {
	    if (curEmp.next==null) {//说明到链表最后
		break;
	    }
	    curEmp=curEmp.next;//后移
	}
	//退出时直接将employee加入链表
	curEmp.next=employee;
    }
    
    //遍历链表的雇员信息
    public void list(int no) {
	if (head==null) {//说明链表为空
	    System.out.println("第 "+(no+1)+" 链表为空");
	    return;
	}
	
	System.out.print("第 "+(no+1)+" 链表的信息为");
	Employee curEmp=head;//辅助指针
	while (true) {
	    System.out.printf(" => id=%d name=%s\t",curEmp.id,curEmp.name);
	    if (curEmp.next==null) {//说明curEmp已经是最后节点
		break;
	    }
	    curEmp=curEmp.next;//后移，遍历
	}
	System.out.println();
    }
    
    //根据id查找雇员
    //如果查找到，就返回Employee，如果没有找到，就返回null
    public Employee findEmpById(int id) {
	//判断链表是否为空
	if (head==null) {
	    System.out.println("链表为空");
	    return null;
	}
	
	//辅助指针
	Employee curEmp=head;
	while (true) {//
	    if (curEmp.id==id) {//找到
		break;//这时curEmp就指向要查找的雇员
	    }
	    
	    //退出
	    if (curEmp.next==null) {//说明遍历当前链表没有找到该雇员
		curEmp=null;
		break;
	    }
	    
	    curEmp=curEmp.next;//后移
	}
	
	return curEmp;
	
    }
    
}