package graph;

import java.util.ArrayList;
import java.util.Arrays;

/*
 * ������ȱ����㷨���裺
 * 1.���ʳ�ʼ���v������ǽ��vΪ�ѷ���
 * 2.���ҽ��v�ĵ�һ���ڽӽ��w
 * 3.��w���ڣ������ִ��4�����w�����ڣ���ص���1��������v����һ��������
 * 4.��wδ�����ʣ���w����������ȱ����ݹ飨����w������һ��v��Ȼ����в���123��
 * 5.���ҽ��v��w�ڽӽ�����һ���ڽӽ�㣬ת������3
 */

public class Graph {

    private ArrayList<String> vertexList;// �洢���㼯��
    private int[][] edges;// �洢ͼ��Ӧ���ڽӾ���
    private int numOfEdges;// ��ʾ�ߵ���Ŀ

    // ��������bollean[],��¼ĳ������Ƿ񱶷���
    private boolean[] isVisited;

    public static void main(String[] args) {
	// ����һ��ͼ�Ƿ񴴽�ok
	int n = 5;// ���ĸ���
	String[] vertexs = { "A", "B", "C", "D", "E" };

	// ����ͼ����
	Graph graph = new Graph(n);

	// ѭ������ӽ��
	for (String vertex : vertexs) {
	    graph.insertVertex(vertex);
	}

	// ��ӱ�
	// A-B A-C B-C B-D B-E
	graph.insertEdge(0, 1, 1);// A-B
	graph.insertEdge(0, 2, 1);//
	graph.insertEdge(1, 2, 1);//
	graph.insertEdge(1, 3, 1);//
	graph.insertEdge(1, 4, 1);//

	// ��ʾһ���ڽӾ���
	graph.showGraph();

	// ����һ�ѣ����ǵ�dfs�����Ƿ�ok
	System.out.println("��ȱ���");
	graph.dfs();// A->B->C->D->E
    }

    // ������
    public Graph(int n) {
	// ��ʼ�������vertexList
	edges = new int[n][n];
	vertexList = new ArrayList<String>(n);
	numOfEdges = 0;
	isVisited = new boolean[n];
    }

    // �õ���һ���ڽӽ����±�w
    /**
     * 
     * @param index
     * @return ������ھͷ��ض�Ӧ���±꣬���򷵻�-1
     */
    public int getFirstNeighbor(int index) {
	for (int j = 0; j < vertexList.size(); j++) {
	    if (edges[index][j] > 0) {
		return j;
	    }
	}

	return -1;
    }

    // ����ǰһ���ڽӽ����±�����ȡ��һ���ڽӽ��
    public int getNextNeighbor(int v1, int v2) {
	for (int j = v2 + 1; j < vertexList.size(); j++) {
	    if (edges[v1][j] > 0) {
		return j;
	    }
	}

	return -1;
    }

    // ������ȱ����㷨
    // i ��һ�ξ���0
    private void dfs(boolean[] isVisited, int i) {
	// �������Ƿ��ʸý�㣬���
	System.out.print(getValueByIndex(i) + "->");

	// ���ý������Ϊ�Ѿ�����
	isVisited[i] = true;

	// ���ҽ��i�ĵ�һ���ڽӽ��w
	int w = getFirstNeighbor(i);

	while (w != -1) {// ˵����
	    if (!isVisited[w]) {
		dfs(isVisited, w);
	    }

	    // ���w����Ѿ������ʹ�
	    w = getNextNeighbor(i, w);
	}
    }

    // ��dfs����һ�����أ������������еĽ�㣬������dfs
    public void dfs() {
	// �������еĽ�㣬����dfs[����]
	for (int i = 0; i < getNumOfVertex(); i++) {
	    if (!isVisited[i]) {
		dfs(isVisited, i);
	    }
	}
    }

    // ͼ�г��õķ���
    // ���ؽ��ĸ���
    public int getNumOfVertex() {
	return vertexList.size();
    }

    // ��ʾͼ��Ӧ�ľ���
    public void showGraph() {
	for (int[] link : edges) {
	    System.out.println(Arrays.toString(link));
	}
    }

    // �õ��ߵ���Ŀ
    public int getNumOfEdges() {
	return numOfEdges;
    }

    // ���ؽ��i���±꣩��Ӧ������ 0->"A" 1->"B" 2->"C"
    public String getValueByIndex(int index) {
	return vertexList.get(index);
    }

    // ����v1��v2��Ȩֵ
    public int getWeight(int v1, int v2) {
	return edges[v1][v2];
    }

    // ������
    public void insertVertex(String vertex) {
	vertexList.add(vertex);
    }

    // ��ӱ�
    /**
     * 
     * @param v1     ��ʾ����±꼴�ǵڼ������� "A"-"B" "A"->0 "B"->1
     * @param v2     �ڶ��������Ӧ���±�
     * @param weight ��ʾ
     */
    public void insertEdge(int v1, int v2, int weight) {
	edges[v1][v2] = weight;
	edges[v2][v1] = weight;
	numOfEdges++;
    }

}