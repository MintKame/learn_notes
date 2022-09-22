#include<stdio.h>
#include<string.h>
char s[1005]={0};
char a[1005]={0};
char* temp;
int main()
{
	while(~scanf("%s",s)&&s[0]!='#')
	{
		scanf("%s",a);
		temp=s;
		int cnt=0;
		while(1)
		{
			temp=strstr(temp,a);//直接加会越界 
			if(temp!=NULL)
			{
				temp+=strlen(a);
				cnt++;
			} 
			else
			break;
		}
		printf("%d\n",cnt);
	}
	return 0;
 } 
