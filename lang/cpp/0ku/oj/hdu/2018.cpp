#include<stdio.h>
int main()
{
	int n;
	int s[55]={0,1};
	for(int i=2;i<55;i++)
	{
		if(i-3<1)
		s[i]=s[i-1]+1;
		else
		s[i]=s[i-1]+s[i-3];
	}
	scanf("%d",&n);
	while(n!=0)
	{
		printf("%d\n",s[n]);
		scanf("%d",&n);
	}
	return 0;
}
