import java.util.Date;
import java.util.Scanner;


public class Paths {
	public static long[][] memo;
	static int m,n;
public static void main(String[] args){
	Scanner in = new Scanner(System.in);
	m=in.nextInt();
	 n = in.nextInt();
	memo=new long[m][n];
	for(int i=0; i<m; i++)
		for(int j=0; j<n; j++)
			memo[i][j]=-1;
	
	Long time1 = System.currentTimeMillis();
	//System.out.println("Before:"+time2);
	memo[m-1][n-1]=find_ways(m-1,n-1);	
	Long time2 = System.currentTimeMillis();
	System.out.println(time2-time1);
	System.out.println(memo[m-1][n-1]);
}
public static long find_ways(int m,int n){
	if(m<0||n<0)
		return 0;
	if(m==0&&n==0)
		return 1;
	if(memo[m][n]!=-1)
		return memo[m][n];
	long k= find_ways(m-1,n)+find_ways(m,n-1);
	//return k;
	memo[m][n]=k;
	return k;
}
}
