#include<stdio.h>
int main()
{
	int money[6]={100,50,10,5,2,1};
	int n;
	scanf("%d",&n);
	while(n!=0)
	{
		int ans=0;
		for(int i=0;i<n;i++)
		{
			int sum;
			scanf("%d",&sum);
			for(int j=0;j<6;j++)
			{
				ans+=sum/money[j];
				sum=sum-(sum/money[j])*money[j];
				if(sum==0) break;
			}
		}
		printf("%d\n",ans);
		scanf("%d",&n);
	}
	return 0;
}
