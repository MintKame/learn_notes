#include<stdio.h>
#include<ctype.h>
#define len 5
//北京车牌号 
int main()
{
	char s[6]={};
	int cnt=0;
	int r=0;
	scanf("%s",s);
	for(int i=0;i<len;i++)
	s[i]=toupper(s[i]);//转化为大写 
	if(!isdigit(s[len-1]))//判断最后一位是否数字 
	r=-1;
	for(int i=0;i<len&&r==0;i++)
	{
		if(!isalnum(s[i])||s[i]=='I'||s[i]=='O')
		{
			r=-1;
			break;
		}
		if(isalpha(s[i]))
		cnt++;
	}
	if(r==0&&cnt==2)
	printf("yes:%s",s);
	else
	printf("no.");	
	return 0;
 } 
