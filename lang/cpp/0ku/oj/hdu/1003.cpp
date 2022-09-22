#include<stdio.h>
int main()
{
	int n;
	scanf("%d",&n);
	for(int i=0;i<n;i++)
	{
		int m;
		scanf("%d",&m);
		int j=0;
		int temp,l,r;
		long long sum=0;
		do
		{
			scanf("%d",&temp);
			j++;
		}while(temp<0);
		l=j;
		r=j;
		sum+=temp;
		for(;j<=m-1;j++)
		{
			scanf("%d",&temp);
			if(sum+temp<0)
			{
				sum=0;
				l=0;
				r=0;
			}
			else{
				sum+=temp;
				r=j;
				if(l==0)
				l=j;
			}
		}
		scanf("%d",&temp);
		if(temp>=0)
		{
				sum+=temp;
				r++;
				if(l==0)
				l=r;
		}
		printf("Case %d:\n%d %lld %d\n",i+1,sum,l,r);
		if(i<n-1) putchar('\n');
	}
	return 0;
}
