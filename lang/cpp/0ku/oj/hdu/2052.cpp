#include<stdio.h>
void bian(int);
void kong(int);
int main()
{
	int m,n;
	while(scanf("%d%d",&m,&n)!=EOF)
	{
		bian(m);
		for(int i=0;i<n;i++)
		kong(m);
		bian(m);
	}
	return 0;
}
void bian(int n)
{
	putchar('+');
	for(int i=0;i<n;i++)
	putchar('-');
	putchar('+');
	putchar('\n');
}
void kong(int n)
{
	putchar('|');
	for(int i=0;i<n;i++)
	putchar(' ');
	putchar('|');
	putchar('\n');
}
