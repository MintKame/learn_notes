#include<stdio.h>
int s[10000001][2]={0};
int main()
{
	int n;
	scanf("%d",&n);
	while(n!=0)
	{
		for(int i=0;i<n;i++)
		{
			scanf("%d",&s[i][0]);
			for(int j=0;j<i;j++)
			{
				if(s[j][0]==s[i][0])
				{
					s[j][1]=-1;
					s[i][1]=-1;
					break;
				}
			}
		}
		for(int i=0;i<n;i++)
		{
			if(s[i][1]!=-1)
			printf("%d\n",s[i][0]);
		}
		scanf("%d",&n);
	}
	return 0;
}
