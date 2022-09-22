#include<stdio.h>
#include<string.h>
int main()
{
	char s[256]={};
	scanf("%[^@]",s);
	int l=0;
	int r=0;
	int len=strlen(s);
	for(int i=0;i<len;i++)
	{
		if(s[i]=='(')
		l++;
		else if(s[i]==')')
		r++;
		if(r>l)
		{
			printf("NO");
			return 0;
		}
	}
	if(l==r)
	printf("YES");
	else
	printf("NO");
	return 0;
 } 
