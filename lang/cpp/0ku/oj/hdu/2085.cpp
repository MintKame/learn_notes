#include<stdio.h>
int main()
{
	int n;
	scanf("%d",&n);
	while(n!=-1)
	{
		long long h=1;
		long long l=0;
		for(int i=0;i<n;i++)
		{
			long long th=h*3+l*2;
			long long tl=h+l;
			h=th;
			l=tl;
		}
		printf("%lld, %lld\n",h,l);//¸ñÊ½Æ¥Åä 
		scanf("%d",&n);
	}
	return 0;
 } 
