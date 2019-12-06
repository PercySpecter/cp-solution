import java.io.*;
import java.util.*;
import java.math.BigInteger;
import java.text.*;
import java.math.*;
import java.util.regex.*;
	
public class Solution 
{
	static final int MOD = 1000000007;
	
	public static void main(String[] args) throws Exception
	{
		Scanner sc = new Scanner(System.in);
		int i , j;
		int T = sc.nextInt();
		outer : for(int tc = 1; tc <= T; tc++)
		{
			long x = sc.nextLong();
			long y = sc.nextLong();

			int n = sc.nextInt();
			int m = sc.nextInt();
			int k = sc.nextInt();

			long A[][] = new long[n][2];
			long B[][] = new long[m][2];
			long C[][] = new long[k][2];
			for(i = 0; i < n; i++)
			{
				A[i][0] = sc.nextLong();
				A[i][1] = sc.nextLong();
			}
			for(i = 0; i < m; i++)
			{
				B[i][0] = sc.nextLong();
				B[i][1] = sc.nextLong();
			}
			for(i = 0; i < k; i++)
			{
				C[i][0] = sc.nextLong();
				C[i][1] = sc.nextLong();
			}
			System.out.println(minDist(n,m,k,x,y,A,B,C));
		}
		sc.close();
    }

    static double minDist(int n , int m , int k , long x , long y , long A[][] , long B[][] , long C[][])
    {
    	int i , j;
    	double CA[] = new double[n];
    	double CB[] = new double[m];
    	double min = Long.MAX_VALUE;

    	for(i = 0; i < n; i++)
    	{
    		min = Long.MAX_VALUE;
    		for(j = 0; j < k; j++)
    		{
    			min = Math.min(min , Math.sqrt((A[i][0]-C[j][0])*(A[i][0]-C[j][0]) + (A[i][1]-C[j][1])*(A[i][1]-C[j][1])));
    		}
    		CA[i] = min;
    	}
    	for(i = 0; i < m; i++)
    	{
    		min = Long.MAX_VALUE;
    		for(j = 0; j < k; j++)
    		{
    			min = Math.min(min , Math.sqrt((B[i][0]-C[j][0])*(B[i][0]-C[j][0]) + (B[i][1]-C[j][1])*(B[i][1]-C[j][1])));
    		}
    		CB[i] = min;
    	}

    	min = Long.MAX_VALUE;
    	for(i = 0; i < n; i++)
    	{
    		double d = Math.sqrt((A[i][0]-x)*(A[i][0]-x) + (A[i][1]-y)*(A[i][1]-y));
    		for(j = 0; j < m; j++)
    		{
    			double tmp = CB[j]+d+Math.sqrt((A[i][0]-B[j][0])*(A[i][0]-B[j][0]) + (A[i][1]-B[j][1])*(A[i][1]-B[j][1]));
    			if(min > tmp)
    			{
    				min = tmp;
    			}
    		}
    	}
    	for(i = 0; i < m; i++)
    	{
    		double d = Math.sqrt((B[i][0]-x)*(B[i][0]-x) + (B[i][1]-y)*(B[i][1]-y));
    		for(j = 0; j < n; j++)
    		{
    			double tmp = CA[j]+d+Math.sqrt((A[j][0]-B[i][0])*(A[j][0]-B[i][0]) + (A[j][1]-B[i][1])*(A[j][1]-B[i][1]));
    			if(min > tmp)
    			{
    				min = tmp;
    			}
    		}
    	}

    	return min;
    }
}
