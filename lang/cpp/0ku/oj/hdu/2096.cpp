#include<stdio.h>
int main()
{
	int t;
	scanf("%d",&t);
	for(int i=0;i<t;i++)
	{
		int a,b;
		scanf("%d %d",&a,&b);
		printf("%d\n",(a%100+b%100)%100);
	}
	return 0;
}
