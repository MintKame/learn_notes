#include<stdio.h>
int main()
{
	int a,b;
	int ji=0,ou=0;
	while(scanf("%d%d",&a,&b)!=EOF)
	{
		ji=0,ou=0;
		if(a%2==0)
		{
			for(int i=a;i<=b;i+=2)
			ou+=i*i;
			for(int i=a+1;i<=b;i+=2)
			ji+=i*i*i;
		}
		else
		{
			for(int i=a+1;i<=b;i+=2)
			ou+=i*i;
			for(int i=a;i<=b;i+=2)
			ji+=i*i*i;
		}
		printf("%d %d\n",ou,ji);
	}
	
	return 0;
 } 
