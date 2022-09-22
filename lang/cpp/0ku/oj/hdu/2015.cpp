#include<stdio.h>
int main()
{
	int n,m;
	while(scanf("%d%d",&n,&m)!=EOF)
	{
		for(int i=0;i<n/m-1;i++)
		{
			printf("%d ",2*i*m+1+m);
		}
		if(n%m!=0)
		{
			printf("%d ",2*(n/m-1)*m+1+m);
			printf("%d",((n/m)*m+1)*2+n-n/m*m-1);
		}
		else
		printf("%d",2*(n/m-1)*m+1+m);
		putchar('\n');
	}
	return 0;
}
