package JillBike;

import java.util.ArrayList;
import java.util.Scanner;

import javax.jws.Oneway;

public class JillBike {
public static void main(String args[]){

	Scanner in=new Scanner(System.in);
	int n=in.nextInt();
	int m=in.nextInt();
	int[][] hill=new int[m][n];

	
	//System.out.println(m+n);
	for(int i=0; i<m; i++){
		for(int j=0; j<n; j++){
			int a=in.nextInt();
			hill[i][j]=a;
		}
	}
	Hill h=new Hill(n,m,hill);
	//h.display();
	while(true){
		int m1=in.nextInt();
		int n1=in.nextInt();
		int m2=in.nextInt();
		int n2=in.nextInt();
		if(m1==m2&&n1==n2&&m1==0)
			break;
		h.one_way(m1-1, n1-1, m2-1, n2-1);		
	}
	//h.display();
	while(true){
		int m1=in.nextInt();
		int n1=in.nextInt();
		int m2=in.nextInt();
		int n2=in.nextInt();
//		int m1=2;
//		int m2=2;
//		int n1=3;
//		int n2=3;
		if(m1==m2&&n1==n2&&m1==0)
			break;
		boolean[][] visited = new boolean[m][n];
		for(int i=0; i<m; i++){
			for(int j=0; j<n; j++){			
				visited[i][j]=false;
			}
		}		
		visited[m1-1][n1-1]=true;
		ArrayList<Node> path;
		path=new ArrayList<Node>();
		path.add(new Node(m1-1,n1-1));
		h.route_found=false;
		h.find_path(m1-1, n1-1, m2-1, n2-1,visited,path,0);
		if(!h.route_found)
			System.out.println("There is no acceptable path from "+m1+"-"+n1+" to "+m2+"-"+n2+".");
		else if(m1==m2&&n1==n2){
			System.out.println("To get from "+m1+"-"+n1+" to "+m2+"-"+n2+", stay put!");
		}
		else if(h.route_found)
		System.out.println("Jill must ascend "+h.min_cost+" meters to get from "+m1+"-"+n1+" to "+m2+"-"+n2+".");
		
		
	}
	
	
	
}
}
