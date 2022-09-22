#include<stdio.h>
#include<ctype.h>
#include<string.h>
int main()
{
	int wy,num,ordr,cnt;
	int i,j,k;
	char s[101]={};
	char temp;
	scanf("%d%d%d",&wy,&num,&ordr);
	scanf("%s",s);
	int len=strlen(s);
	for(i=0,cnt=0;i<len;i++)
	{
		cnt+=isalpha(s[i]);	
	}
	for(i=0;s[i]!=0;i++)
	{
		if(s[i]=='-')
		{
			if(i==0||i==len-1||s[i-1]=='-'||(isdigit(s[i-1])!=isdigit(s[i+1]))||((isdigit(s[i+1])==isdigit(s[i-1])&&(s[i-1]>=s[i+1]))))
			putchar('-');
			else if(wy==3)
			{
				for(j=0;j<cnt;j++)
				putchar('*');
			}
			else if(isdigit(s[i-1]))
			{
				if(ordr==1)
				for(j=0;j<s[i+1]-s[i-1]-1;j++)
				{
					for(k=0;k<num;k++)
					putchar(s[i-1]+j+1);
				}
				else
				for(j=0;j<s[i+1]-s[i-1]-1;j++)
				{
					for(k=0;k<num;k++)
					putchar(s[i+1]-j-1);
				}
			}		
			else if(wy==2)
			{
				s[i-1]=toupper(s[i-1]);
				temp=toupper(s[i+1]);
				if(ordr==1)
				for(j=0;j<temp-s[i-1]-1;j++)
				{
					for(k=0;k<num;k++)
					putchar(s[i-1]+j+1);
				}
				else
				for(j=0;j<temp-s[i-1]-1;j++)
				{
					for(k=0;k<num;k++)
					putchar(temp-j-1);
				}
			}
			else 			
			{
				s[i-1]=tolower(s[i-1]);
				s[i+1]=tolower(s[i+1]);
				if(ordr==1)
				for(j=0;j<s[i+1]-s[i-1]-1;j++)
				{
					for(k=0;k<num;k++)
					putchar(s[i-1]+j+1);
				}
				else
				for(j=0;j<s[i+1]-s[i-1]-1;j++)
				{
					for(k=0;k<num;k++)
					putchar(s[i+1]-j-1);
				}
			}
		}	
		else putchar(s[i]);	
	}	
	return 0;
}
