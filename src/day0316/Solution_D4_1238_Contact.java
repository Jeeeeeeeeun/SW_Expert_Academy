package day0316;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

class Node {
	public int from;
	public ArrayList<Integer> list = new ArrayList<>();
	public Node(int from) {
		this.from = from;
	}
}

public class Solution_D4_1238_Contact {

	static ArrayList<Node> graph;
	static boolean[] visited;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String s = br.readLine();
		while (s != null) {
			StringTokenizer st = new StringTokenizer(s, " ");

			int length = Integer.parseInt(st.nextToken());
			int start = Integer.parseInt(st.nextToken());

			graph = new ArrayList<>();

			st = new StringTokenizer(br.readLine(), " ");
			int from = Integer.parseInt(st.nextToken());
			int to = Integer.parseInt(st.nextToken());
			graph.add(new Node(from)); // from
			graph.get(0).list.add(to); // to
			
			System.out.println();

//			for (int i = 0; i < length; i++) {
//				int from =  Integer.parseInt(st.nextToken());
//				int to =  Integer.parseInt(st.nextToken());
//				
//				boolean isExist = false;
//				for (int j = 0; j < graph.size(); j++) {
//					if(graph.get(j).from==from) {
//						isExist = true;
//						graph.get(j).add(to);
//					}
//				}
//				
//				if(!isExist) {
//					graph.add(new ArrayList<Integer>());
//					graph.get(graph.size()-1).add(from);
//					graph.get(graph.size()-1).add(to);
//				}
//				
//			}
//			
			
			
			s = br.readLine();
		}

	}
}
