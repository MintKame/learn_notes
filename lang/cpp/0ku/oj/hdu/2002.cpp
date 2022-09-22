#include<stdio.h>
#define PI 3.1415927
int main()
{
	double a;
	while(scanf("%lf",&a)==1)
	{
		printf("%.3lf\n",(a*a*a*PI*4)/3);
	}
	return 0;
}
