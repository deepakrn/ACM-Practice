import java.util.Scanner;


public class MissingPages {
public static void main(String args[]){
	Scanner in = new Scanner(System.in);
	int n=1;
	while(n>0){
		n=in.nextInt();
		if(n==0)
			break;
		int p=in.nextInt();
		int temp=p;
		if(p<n/2){			
			if(p%2==0)
				p--;
			int diff=n/2-p;
			int k=n/2+diff;
			if(temp%2==1){
				temp++;
			System.out.println(temp+" "+k+" "+(k+1));
			}
			else{
				System.out.println(p+" "+k+" "+(k+1));
			}
		}		
		else{
			
			if(p%2==1)
				p++;
			int diff=p-n/2-1;
			int k=n/2+1-diff;			
			if(temp%2==0){
				temp--;
			System.out.println((k-1)+" "+k+" "+temp);
			}
			else{
				System.out.println((k-1)+" "+k+" "+p);
			}
		}
		
		
	}
}
}
