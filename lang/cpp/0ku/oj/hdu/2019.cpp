#include<stdio.h>
int main()
{
	int n,m;
	scanf("%d%d",&n,&m);
	while(n!=0||m!=0)
	{
		int temp;
		int tag=0;
		for(int i=0;i<n-1;i++)
		{
			scanf("%d",&temp);		
			if(m<=temp&&tag==0)
			{
				tag=1;
				printf("%d %d ",m,temp);
			}
			else
			printf("%d ",temp);
		}
		scanf("%d",&temp);		
		if(m<=temp&&tag==0)
		{
			tag=1;
			printf("%d %d",m,temp);
		}
		else if(tag==1)
		printf("%d",temp);
		else
		printf("%d %d",temp,m);
		putchar('\n');
		scanf("%d%d",&n,&m);
	}
	return 0;
}
