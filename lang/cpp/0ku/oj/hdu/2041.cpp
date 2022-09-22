#include<stdio.h>
int main()
{
	int n;
	int s[41]={0,1,2,3,5,8,};
	for(int i=6;i<=40;i++)
	s[i]=s[i-1]+s[i-2];
	scanf("%d",&n);
	for(int i=0;i<n;i++)
	{
		int t;
		scanf("%d",&t);
		printf("%d\n",s[t-1]);
	}
	return 0;
}
