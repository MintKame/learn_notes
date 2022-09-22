#include<stdio.h>
int main()
{
	int n;
	scanf("%d",&n);
	while(n!=0)
	{
		int s[100];
		int min_i=0;
		for(int i=0;i<n;i++)
		{
			scanf("%d",&s[i]);
			if(s[i]<s[min_i])
			min_i=i;
		}
		if(min_i!=0)
		{
			int temp=s[0];
			s[0]=s[min_i];
			s[min_i]=temp;
		}
		for(int i=0;i<n-1;i++)
		{
			printf("%d ",s[i]);
		}
		printf("%d\n",s[n-1]);
		scanf("%d",&n);
	}
	return 0;
}
