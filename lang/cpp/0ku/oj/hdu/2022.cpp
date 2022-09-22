#include<stdio.h>
#include<stdlib.h>
#include<math.h>
int main()
{
//	printf("%lf",pow(2,31));/
	int m,n;
	while(~scanf("%d%d",&m,&n))
	{
		int ans=0,x=0,y=0;
		for(int i=1;i<=m;i++)
		{
			for(int j=1;j<=n;j++)
			{
				int temp;
				scanf("%d",&temp);
	//			if(temp==-2147483648)
	//			{
	//				printf("%d %d -2147483678",i,j);
	//				return 0;
	//			}
				if(abs(temp)>abs(ans))
				{
					x=i;
					y=j;
					ans=temp;
	//				printf("%d %d %d\n",x,y,ans);
				}
			}
		}
	printf("%d %d %d\n",x,y,ans);
	}


	return 0;
}

