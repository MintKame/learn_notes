#include<stdio.h>
#include<math.h>
int main()
{
	int m;
	double n;
	while(scanf("%lf%d",&n,&m)!=EOF)
	{
		double ans=0;
		for(int i=0;i<m;i++)
		{
			ans+=n;
			n=sqrt(n);
		}
		printf("%.2lf",ans);
	}	
	return 0;
 }
 
