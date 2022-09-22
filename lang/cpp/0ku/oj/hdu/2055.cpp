#include<stdio.h>
#include<ctype.h>
int main()
{
	int n;
	scanf("%d",&n);
	for(int i=0;i<n;i++)
	{
		char c;
		int t;
		scanf("\n%c%d",&c,&t);
		if(isupper(c))
		printf("%d\n",c-'A'+1+t);
		else
		printf("%d\n",-1*(c-'a'+1)+t);		
		
	}
	return 0;
}
