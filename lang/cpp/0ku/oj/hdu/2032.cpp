#include<stdio.h>
#include<stdlib.h>
int main()
{
	int n;
	while(~scanf("%d",&n))
	{
		int s[30]={1};
		for(int i=1;i<=n;i++)//本行个数为i 
		{
			for(int j=(i-1)/2;j>0;j--)
			{
				if(i%2==1&&j==(i-1)/2)
				{
					s[j]=2*s[j-1];
				}
				else
				s[j]=s[j]+s[j-1];
//				printf("(%d %d %d)",i,j,s[j]);
			}
			int k;
			for(k=0;k<(i+1)/2;k++)
			{
				printf("%d",s[k]);
				if(k!=i-1)
				putchar(' ');
			}
			for(;k<i;k++)
			{
				printf("%d",s[i-k-1]);
				if(k!=i-1)
				putchar(' ');
			}
			putchar('\n');
		}	
		putchar('\n');	
	}
	return 0;
}
