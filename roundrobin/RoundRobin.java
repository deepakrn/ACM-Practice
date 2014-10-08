package roundrobin;

import java.util.Scanner;

public class RoundRobin {
	static int count=0;
	static int val=0;
public static void main(String args[]){
	Scanner in = new Scanner(System.in);
	
	while(true){
		
		int n=in.nextInt();
		if(n==0)
			break;
		int t=in.nextInt();
		
		int[] A= new int[n];
		for(int i=0; i<n; i++)
			A[i]=0;
		int start=0;
		int k=0;
		do{			
			k=modify(A,t,n,start);
			start=k+1;
			A[k]=-1;
//			System.out.println("K:"+k);
//			System.out.println("A:");
//			for(int i=0; i<n; i++)
//				System.out.print(A[i]+" ");
			
		}while(!check_end(A,n));
		
		
	}
}
public static void soln(int[] A,int n){
	int i=0;
	while(A[i]==-1)
		i++;
	val=A[i];
	count=1;
	i++;
	for(;i<n; i++)
		if(A[i]!=-1)
			count++;
}
public static boolean check_end(int[] A,int n){
	int i=0;
	while(A[i]==-1)
		i++;
	int val=A[i];
	for(;i<n;i++)
		if(A[i]!=-1)
			if(A[i]!=val)
				return false;
	soln(A,n);
	System.out.println(count+" "+val);
	return true;
}
public static int modify(int[] A,int T,int n,int start){

	int i=start;
	for(i=start; T>0; T-- ){
		
		if(A[i]==-1){
			T++;
			i=(i+1)%n;
			continue;
		}
		else{
		A[i]++;
		i=(i+1)%n;
		}
		
	}
	if(i==0)
		return n-1;
	else
	return (i-1)%n;
}
}
