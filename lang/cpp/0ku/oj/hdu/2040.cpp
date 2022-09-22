#include<stdio.h>
int main()
{

	int n;
	scanf("%d",&n);
	for(int j=0;j<n;j++)
	{
		int a,b;
		scanf("%d%d",&a,&b);
		int a1=0,b1=0;
		for(int i=1;i<a;i++)
		{
			if(a%i==0)
			a1+=i;
		}
//		printf("%d",a1);
		if(a1==b)
		{
			printf("YES\n");
			continue;
		}
		for(int i=1;i<b;i++)
		{
			if(b%i==0)
			b1+=i;
		}
		if(a==b1)
		{
			printf("YES\n");
		}
		else
		{
			printf("NO\n");
		}		
	}
}
