#include<stdio.h>
#include<math.h>
int main()
{
	double a;
	while(scanf("%lf",&a)==1)
	{
		printf("%.2lf\n",fabs(a));
	}
	return 0;
}
