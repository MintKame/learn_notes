#include<stdio.h>
int main()
{
	int n;
	while(scanf("%d",&n)!=EOF)
	{
		double temp;
		scanf("%lf",&temp);
		double sum=temp,min=temp,max=temp;
		for(int i=1;i<n;i++)
		{
			scanf("%lf",&temp);
			sum+=temp;
			if(temp>max)
			max=temp;
			else if(temp<min)
			min=temp;
		}
		printf("%.2lf\n",(sum-max-min)/(n-2));
	}
	return 0;
}
