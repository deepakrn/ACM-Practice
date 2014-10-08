package JillBike;

import java.util.ArrayList;

public class Hill {
public int n;
public int m;
public int[][] hill=new int[m][n];
public boolean[][] up = new boolean[m][n];
public boolean[][] down = new boolean[m][n];
public boolean[][] right=new boolean[m][n];
public boolean[][] left = new boolean[m][n];
public boolean[][] road_left=new boolean[m][n];
public boolean[][] road_right=new boolean[m][n];
public boolean[][] road_up=new boolean[m][n];
public boolean[][] road_down=new boolean[m][n];
public int min_cost;
boolean route_found;
ArrayList<Node> shortest_path=new ArrayList<Node>();

int mod(int a,int b){
	return b-a;
}
Hill(int n,int m, int[][] hill){
	this.n=n;
	this.m=m;
	this.hill=hill;
	up = new boolean[m][n];
	down = new boolean[m][n];
	right=new boolean[m][n];
	 left = new boolean[m][n];
	 road_up = new boolean[m][n];
	 road_down = new boolean[m][n];
	 road_right=new boolean[m][n];
	 road_left = new boolean[m][n];
	 min_cost=10000000;
	 route_found=false;
	
	for(int i=0; i<m; i++){
		for(int j=0; j<n; j++){
			up[i][j]=right[i][j]=left[i][j]=down[i][j]=true;
			road_up[i][j]=road_down[i][j]=road_left[i][j]=road_right[i][j]=false;			
		}
	}
	for(int i=0; i<m; i++){
		for(int j=0; j<n; j++){
			if(i==0)
				up[i][j]=false;
			if(j==0)
				left[i][j]=false;
			if(i==m-1)
				down[i][j]=false;
			if(j==n-1)				
				right[i][j]=false;
				
				
			if(i>0){
				if(mod(hill[i][j],hill[i-1][j])>10)
					up[i][j]=false;									
			}
			if(j>0){
				if(mod(hill[i][j],hill[i][j-1])>10)
				left[i][j]=false;	
			}
			if(i<m-1){
				if(mod(hill[i][j],hill[i+1][j])>10)
					down[i][j]=false;
			}
			if(j<n-1){
				if(mod(hill[i][j],hill[i][j+1])>10)
					right[i][j]=false;
			}
		}
	}
}
public boolean[][] new_visited(boolean[][] a){
	boolean[][] visited = new boolean[m][n];
	for(int i=0; i<m; i++){
		for(int j=0; j<n; j++){			
			visited[i][j]=a[i][j];
		}
	}
	return visited;
}
public void find_path(int m1,int n1,int m2,int n2,boolean[][] visit,ArrayList<Node> path,int cost){
	if(cost>min_cost)
		return;	
	ArrayList<Node> path1=(ArrayList<Node>)path.clone();
	boolean[][] visited= new_visited(visit);
	//System.out.println((m1+1)+" "+(n1+1));
	visited[m1][n1]=true;
	if(m1==m2&&n1==n2){
		if(cost<min_cost){
			shortest_path=path;
			min_cost=cost;
		}
		route_found=true;
		//System.out.println("GOAL");
		return;
	}
		
	if(up[m1][n1]&&road_up[m1][n1]){
		if(visited[m1-1][n1]==false){
			path1.add(new Node(m1-1,n1));
			if(hill[m1-1][n1]-hill[m1][n1]>0)
			cost+=hill[m1-1][n1]-hill[m1][n1];
			find_path(m1-1, n1, m2, n2,visited,path1,cost);
		}
	}
	if(right[m1][n1]&&road_right[m1][n1]){
		if(visited[m1][n1+1]==false){
			if(hill[m1][n1+1]-hill[m1][n1]>0)
				cost+=hill[m1][n1+1]-hill[m1][n1];
			path1.add(new Node(m1,n1+1));
			find_path(m1, n1+1, m2, n2,visited,path1,cost);
		}
	}
	if(left[m1][n1]&&road_left[m1][n1]){
		if(visited[m1][n1-1]==false){
			if(hill[m1][n1-1]-hill[m1][n1]>0)
				cost+=hill[m1][n1-1]-hill[m1][n1];
			path1.add(new Node(m1,n1-1));
			find_path(m1,n1-1,m2,n2,visited,path1,cost);
		}
	}
	if(down[m1][n1]&&road_down[m1][n1]){
		if(visited[m1+1][n1]==false){
			if(hill[m1+1][n1]-hill[m1][n1]>0)
				cost+=hill[m1+1][n1]-hill[m1][n1];
			path1.add(new Node(m1+1,n1));
			find_path(m1+1, n1, m2, n2,visited,path1,cost);
		}
	}
}
public void one_way(int m1,int n1,int m2,int n2){
	if(m1==m2){
		if(n1>n2){
			for(int j=n1; j>n2; j--)
				road_left[m1][j]=true;
		}
		else{
			for(int j=n1; j<n2; j++)
				road_right[m1][j]=true;
		}
	}
	if(n1==n2){
		if(m1>m2){
			for(int j=m1; j>m2; j--)
				road_up[j][n1]=true;
		}
		else{
			for(int j=m1; j<m2; j++)
				road_down[j][n1]=true;
		}
	}
}
public void display(){
	for(int i=0; i<m; i++){
		System.out.println("");
		for(int j=0; j<n; j++)
			System.out.print(hill[i][j]+" ");
	}
	System.out.println("UP:");
	for(int i=0; i<m; i++){
		System.out.println("");
		for(int j=0; j<n; j++)
			System.out.print(up[i][j]+" ");
	}
	System.out.println("Down:");
	for(int i=0; i<m; i++){
		System.out.println("");
		for(int j=0; j<n; j++)
			System.out.print(down[i][j]+" ");
	}
	System.out.println("Right");
	for(int i=0; i<m; i++){
		System.out.println("");
		for(int j=0; j<n; j++)
			System.out.print(right[i][j]+" ");
	}
	System.out.println("Left:");
	for(int i=0; i<m; i++){
		System.out.println("");
		for(int j=0; j<n; j++)
			System.out.print(left[i][j]+" ");
	}
	System.out.println("UP:");
	for(int i=0; i<m; i++){
		System.out.println("");
		for(int j=0; j<n; j++)
			System.out.print(road_up[i][j]+" ");
	}
	System.out.println("Down:");
	for(int i=0; i<m; i++){
		System.out.println("");
		for(int j=0; j<n; j++)
			System.out.print(road_down[i][j]+" ");
	}
	System.out.println("Right");
	for(int i=0; i<m; i++){
		System.out.println("");
		for(int j=0; j<n; j++)
			System.out.print(road_right[i][j]+" ");
	}
	System.out.println("Left:");
	for(int i=0; i<m; i++){
		System.out.println("");
		for(int j=0; j<n; j++)
			System.out.print(road_left[i][j]+" ");
	}
}


}
