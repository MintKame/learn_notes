#include<stdio.h>
#include<string.h>
int main()
{
	int n;
	scanf("%d",&n);
	getchar();
	for(int i=0;i<n;i++)
	{
		char s[1000]={0};
		gets(s);
		int ans=0;
		int len=strlen(s);
		for(int j=0;j<len;j++)
		{
			if(s[j]<0)
			ans++;
		}
		printf("%d\n",ans/2);
	}
	return 0;
 } 
