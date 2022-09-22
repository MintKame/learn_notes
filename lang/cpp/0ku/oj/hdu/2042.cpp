#include<stdio.h>
int main()
{
	int n;
	scanf("%d",&n);
	for(int i=0;i<n;i++)
	{
		int m;
		int temp=3;
		scanf("%d",&m);
		for(int j=0;j<m;j++)
		{
			temp=(temp-1)*2;
		}
		printf("%d\n",temp);
	}
	return 0;
 } 
