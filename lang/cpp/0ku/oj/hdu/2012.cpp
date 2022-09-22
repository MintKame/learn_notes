#include<stdio.h>
int main()
{
	int x,y;
	scanf("%d%d",&x,&y);
	while(x!=0||y!=0)
	{
		int ans=1;
		for(int j=x;ans==1&&j<=y;j++)
		{
			int temp=j*j+j+41;
			for(int k=2;k*k<temp;k++)
			{
				if(temp%k==0) 
				{
					ans=0;
					break;
				}
			}
		}
		if(ans==0)
		printf("Sorry\n");		
		else
		printf("OK\n");				
		scanf("%d%d",&x,&y);
	}
	return 0;
 } 
