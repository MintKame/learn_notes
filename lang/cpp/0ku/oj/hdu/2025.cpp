#include<stdio.h>
#include<string.h>
int main()
{
	char s[105]={0};
	while(scanf("%s",s)!=EOF)
	{
		int max=s[0];
		for(int i=0;i<strlen(s);i++)
		{
			if(s[i]>max)
			{
				max=s[i];
			}
		}
		for(int i=0;i<strlen(s);i++)
		{
			if(s[i]==max)
			printf("%c(max)",s[i]);
			else
			printf("%c",s[i]);
		}
		putchar('\n');
	}
	return 0;
}
