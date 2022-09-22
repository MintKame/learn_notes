#include<stdio.h>
#include<ctype.h>
#include<string.h>
int main()
{
	int n;
	scanf("%d",&n);
	for(int i=0;i<n;i++)
	{
		char s[51]={0};
		scanf("%s",s);
		if(strlen(s)>16||strlen(s)<8)
		{
			printf("NO\n");
			continue;
		}
		int t1=0,t2=0,t3=0,t4=0;
		for(int j=0;j<strlen(s);j++)
		{
			if(isdigit(s[j])) t1=1;
			else if(isupper(s[j])) t2=1;
			else if(islower(s[j])) t3=1;	
			else t4=1;
		}
		if(t1+t2+t3+t4>=3)
		printf("YES\n");
		else		
		printf("NO\n");
	}
}

