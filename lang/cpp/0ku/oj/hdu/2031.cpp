#include<stdio.h>
void f(int n,int r);
int main()
{
	int n,r;
	while(~scanf("%d%d",&n,&r))
	{
		if(n>=0)
		f(n,r);
		else
		{
			printf("-");
			f(-1*n,r);
		}
		printf("\n");
	}
	return 0;
}
void f(int n,int r) 
{
	if(n/r>0)
	f(n/r,r);
	n%=r;
	if(n>=0&&n<=9)	
	printf("%d",n);
	else
	printf("%c",n+'A'-10);
	return;
}
