#include<stdio.h>
int main()
{
	int l,r;
	while(~scanf("%d%d",&l,&r))
	{
		int tag=0;
		for(int i=l;i<=r;i++)
		{
			int a=i%10;
			int c=i/100;
			int b=i/10%10;
			if(a*a*a+b*b*b+c*c*c==i)
			{
				if(tag==1)
				printf(" %d",i);
				else
				{
					printf("%d",i);
					tag=1;
				}
			}
		}
		if(tag==0)
		printf("no\n");
		else
		printf("\n");
	}
	return 0;
}
