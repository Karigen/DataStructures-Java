package graph;

import java.util.ArrayList;
import java.util.Arrays;

public class Graph {

    private ArrayList<String> vertexList;// �洢���㼯��
    private int[][] edges;// �洢ͼ��Ӧ���ڽӾ���
    private int numOfEdges;// ��ʾ�ߵ���Ŀ

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
    }

    // ������
    public Graph(int n) {
	// ��ʼ�������vertexList
	edges = new int[n][n];
	vertexList = new ArrayList<String>(n);
	numOfEdges = 0;
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