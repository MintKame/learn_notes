#include<stdio.h>
#include<math.h>
int main()
{
	int m;
	double n;
	while(~scanf("%lf%d",&n,&m))
	{
		double ans=0;
		for(int i=0;i<m;i++)
		{
			ans+=n;
			n=sqrt(n);
		}
		printf("%.2lf\n",ans);
	}
	return 0;
 } 
