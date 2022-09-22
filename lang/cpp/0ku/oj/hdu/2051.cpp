#include<stdio.h>
void tob(int);
int main()
{
	int n;
	while(scanf("%d",&n)!=EOF)
	{
		tob(n);
		putchar('\n');
	}
	return 0;
}
void tob(int n)
{
	if(n>0)
	tob(n/2);
	if(n!=0)
	printf("%d",n%2);
	return;
}
