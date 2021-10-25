package graph;

import java.util.ArrayList;
import java.util.Arrays;

/*
 * 深度优先遍历算法步骤：
 * 1.访问初始结点v，并标记结点v为已访问
 * 2.查找结点v的第一个邻接结点w
 * 3.若w存在，则继续执行4，如果w不存在，则回到第1步，将从v的下一个结点继续
 * 4.若w未被访问，对w进行深度优先遍历递归（即把w当作另一个v，然后进行步骤123）
 * 5.查找结点v的w邻接结点的下一个邻接结点，转到步骤3
 */

public class Graph {

    private ArrayList<String> vertexList;// 存储顶点集合
    private int[][] edges;// 存储图对应的邻接矩阵
    private int numOfEdges;// 表示边的数目

    // 定义数组bollean[],记录某个结点是否倍访问
    private boolean[] isVisited;

    public static void main(String[] args) {
	// 测试一把图是否创建ok
	int n = 5;// 结点的个数
	String[] vertexs = { "A", "B", "C", "D", "E" };

	// 创建图对象
	Graph graph = new Graph(n);

	// 循环的添加结点
	for (String vertex : vertexs) {
	    graph.insertVertex(vertex);
	}

	// 添加边
	// A-B A-C B-C B-D B-E
	graph.insertEdge(0, 1, 1);// A-B
	graph.insertEdge(0, 2, 1);//
	graph.insertEdge(1, 2, 1);//
	graph.insertEdge(1, 3, 1);//
	graph.insertEdge(1, 4, 1);//

	// 显示一把邻接矩阵
	graph.showGraph();

	// 测试一把，我们的dfs遍历是否ok
	System.out.println("深度遍历");
	graph.dfs();// A->B->C->D->E
    }

    // 构造器
    public Graph(int n) {
	// 初始化矩阵和vertexList
	edges = new int[n][n];
	vertexList = new ArrayList<String>(n);
	numOfEdges = 0;
	isVisited = new boolean[n];
    }

    // 得到第一个邻接结点的下标w
    /**
     * 
     * @param index
     * @return 如果存在就返回对应的下标，否则返回-1
     */
    public int getFirstNeighbor(int index) {
	for (int j = 0; j < vertexList.size(); j++) {
	    if (edges[index][j] > 0) {
		return j;
	    }
	}

	return -1;
    }

    // 根据前一个邻接结点的下标来获取下一个邻接结点
    public int getNextNeighbor(int v1, int v2) {
	for (int j = v2 + 1; j < vertexList.size(); j++) {
	    if (edges[v1][j] > 0) {
		return j;
	    }
	}

	return -1;
    }

    // 深度优先遍历算法
    // i 第一次就是0
    private void dfs(boolean[] isVisited, int i) {
	// 首先我们访问该结点，输出
	System.out.print(getValueByIndex(i) + "->");

	// 将该结点设置为已经访问
	isVisited[i] = true;

	// 查找结点i的第一个邻接结点w
	int w = getFirstNeighbor(i);

	while (w != -1) {// 说明有
	    if (!isVisited[w]) {
		dfs(isVisited, w);
	    }

	    // 如果w结点已经倍访问过
	    w = getNextNeighbor(i, w);
	}
    }

    // 对dfs进行一个重载，遍历我们所有的结点，并进行dfs
    public void dfs() {
	// 遍历所有的结点，进行dfs[回溯]
	for (int i = 0; i < getNumOfVertex(); i++) {
	    if (!isVisited[i]) {
		dfs(isVisited, i);
	    }
	}
    }

    // 图中常用的方法
    // 返回结点的个数
    public int getNumOfVertex() {
	return vertexList.size();
    }

    // 显示图对应的矩阵
    public void showGraph() {
	for (int[] link : edges) {
	    System.out.println(Arrays.toString(link));
	}
    }

    // 得到边的数目
    public int getNumOfEdges() {
	return numOfEdges;
    }

    // 返回结点i（下标）对应的数据 0->"A" 1->"B" 2->"C"
    public String getValueByIndex(int index) {
	return vertexList.get(index);
    }

    // 返回v1和v2的权值
    public int getWeight(int v1, int v2) {
	return edges[v1][v2];
    }

    // 插入结点
    public void insertVertex(String vertex) {
	vertexList.add(vertex);
    }

    // 添加边
    /**
     * 
     * @param v1     表示点的下标即是第几个顶点 "A"-"B" "A"->0 "B"->1
     * @param v2     第二个顶点对应的下标
     * @param weight 表示
     */
    public void insertEdge(int v1, int v2, int weight) {
	edges[v1][v2] = weight;
	edges[v2][v1] = weight;
	numOfEdges++;
    }

}