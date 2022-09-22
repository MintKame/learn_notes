#include<stdio.h>
#include<ctype.h>
int main()
{
	char s[101];
	for(int i=0;i<101;i++)
	{
		s[i]=0;
	}
	char *p=s+1;
	while((s[0]=getchar())!=EOF)
	{
		while((*p=getchar())!='\n')
		{
			p++;
		}
		s[0]=toupper(s[0]);
		for(int i=1;i<101;i++)
		{
			if(s[i-1]==' ')
			s[i]=toupper(s[i]);	
		}
		printf("%s",s);
		for(int i=0;i<101;i++)
		{
			s[i]=0;
		}
		p=s+1;
	}
	return 0;
}
