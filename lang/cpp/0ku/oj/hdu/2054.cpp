#include<stdio.h>
#include<math.h>
int main()
{
	double a,b;
	while(scanf("%lf%lf",&a,&b)!=EOF)
	{
		if(fabs(a-b)<1E-6)
		printf("YES\n");
		else
		printf("NO\n");
	}
	return 0;
}
