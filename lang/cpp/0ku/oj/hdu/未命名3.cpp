#include<stdio.h>
int main()
{
	int n,m;
	while(scanf("%d%d",&n,&m)!=EOF)
	{
		double ans=0;
		for(double i=n;i<=m;i++)
		{
			ans+=1/(i*i);
		}
		printf("%.5f",ans);
	}
	return 0;
}
