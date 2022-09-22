#include<stdio.h>
int main()
{
	int n;
	scanf("%d",&n);
	for(int i=0;i<n;i++)
	{
		double a,b,c;
		scanf("%lf%lf%lf",&a,&b,&c);
		if(a+b<=c||a+c<=b||b+c<=a)
		{
			printf("NO\n");
			continue;		
		}
		printf("YES\n");
	}	
	return 0;
}
