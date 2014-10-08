import java.util.Scanner;


public class Balance {
public int A[];
public int size;
public static int max(int a,int b){
	if(a>b)
		return a;
	return b;
}
public static void main(String args[]){
	Scanner in = new Scanner(System.in);	
	while(true){
		int A[];
		int size;
		size=in.nextInt();
		if(size==0)
			break;
		A=new int[size];
		int sum=0;
		for(int i=0; i<size; i++)
		{
			A[i]=in.nextInt();
			sum+=A[i];
		}
		if(sum%2!=0)
		{
			System.out.println("impossible");
			continue;
		}
		sum=sum/2;
		boolean[][] DP=new boolean[size+1][sum+1];
		for(int i=0; i<=size; i++){
			for(int j=0; j<=sum; j++){
				if(i==0)
					DP[i][j]=false;
				if(j==0)
					DP[i][j]=true;
			}
		}	
		for(int i=1; i<=size; i++){
			for(int j=0; j<=sum; j++){
				if(j-A[i-1]<0){
					DP[i][j]=DP[i-1][j];
				}
				else{					
					DP[i][j]=DP[i-1][j]||DP[i-1][j-A[i-1]];
				}
			}
		}
		if(DP[size][sum])
		System.out.println("possible");
		else
		System.out.println("impossible");
		
	}
}
}

