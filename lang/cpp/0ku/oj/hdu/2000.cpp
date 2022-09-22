#include<stdio.h>
int main()
{
	char a,b,c;
	while(scanf("%c%c%c",&a,&b,&c)!=EOF)
	{
		getchar();//ÎüÊÕ»»ĞĞ 
		char x=(a<b)?(a<c?a:c):(b<c?b:c);
		char z=(a>b)?(a>c?a:c):(b>c?b:c);
		char y=a+b+c-x-z;
		printf("%c %c %c\n",x,y,z);
	}
	return 0;
}
