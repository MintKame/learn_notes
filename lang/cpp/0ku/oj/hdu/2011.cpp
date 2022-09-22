#include<stdio.h>
int main()
{
	int m;
	scanf("%d",&m);
	for(int i=0;i<m;i++)
	{
		int n;
		scanf("%d",&n);
		double ans=0;
		double a=1;
		int flag=1;
		for(int j=0;j<n;j++)
		{
			ans+=flag*a;
			a/=2;
			flag*=-1;
			}	
		printf("%.2lf\n",ans);
	}
	return 0;
}
