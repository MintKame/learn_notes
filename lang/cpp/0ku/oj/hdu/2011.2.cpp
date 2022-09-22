#include<stdio.h>
int main()
{
	int n;
	scanf("%d",&n);
	for(int i=0;i<n;i++)
	{
		int m;
		double ans=0;
		int tag=1;
		scanf("%d",&m);
		for(int j=1;j<=m;j++)
		{
			ans+=tag/(double)j;
			tag*=-1;
		}
		printf("%.2lf\n",ans);
	}
	return 0;
 } 
