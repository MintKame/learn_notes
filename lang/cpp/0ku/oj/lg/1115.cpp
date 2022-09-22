#include<stdio.h>
#include<math.h>
int main()
{
	long long int n;
//	printf("%lf",pow(2,15));
	scanf("%lld",&n);
	int i=0;
	int temp;
	scanf("%d",&temp);
	long long int sum=temp;
	long long int max=sum;
	for(i=1;i<n&&temp<=0;i++)
	{
		scanf("%d",&temp);
		if(temp>max)
		{
			max=temp;
			sum=temp;
		}
	}
	for(;i<n;i++)
	{
		scanf("%d",&temp);
		sum+=temp;
		if(sum>max)
		{
			max=sum;
		}
		else if(sum<0)
		{
			sum=0;
		}
	}
	printf("%lld",max);
	return 0;
}
