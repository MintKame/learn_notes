#include<stdio.h>
int main()
{
	int a,b;
	scanf("%d%d",&a,&b);
	while(a!=0||b!=0)
	{
		int i; 
		a*=100;
		for(i=0;i<100;i++)
		{
			if((a+i)%b==0)
			{
				if(i<10)//考虑个位数，而非只有0 
				printf("0%d",i);//PE：行末没有空格，找到第一个后break判断 
				else
				printf("%d",i);
				break; 
			}
		}
		for(int n=1;i+n*b<100;n++)
		{
			printf(" %d",i+n*b);
		}
		putchar('\n');
	scanf("%d%d",&a,&b);
	}
	return 0;
}
