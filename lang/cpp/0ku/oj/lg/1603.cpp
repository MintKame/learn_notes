#include<stdio.h>
#include<string.h>
char num[][15]={" ","one","two","three","four","five","six","seven","eight",
"nine","ten","eleven","twelve","thirteen","fourteen",
"fifteen","sixteen","seventeen","eighteen","nineteen","twenty","first",
"second","third","a","both","another"};
int main()
{
	int s[6]={};
	int index=0;
	for(int j=0;j<6;j++)
	{
		char temp[20]={0};
		scanf("%s",temp);
		for(int i=1;i<=26;i++)
		{
			 if(strcmp(temp,num[i])==0)
			 {
//			 	printf("%s\n",temp);
			 	if(i<=20&&i>0)
			 	s[index++]=i;
				else if(i>20)
				{
				 	s[index++]=i%20;
					if(s[index-1]>3)
					s[index-1]-=3;					
				}
//				printf("%d %d\n",index-1,s[index-1]);
			 	break;
			 }
		}
	}
	for(int i=0;i<index;i++)
	{
		s[i]=(s[i]*s[i])%100;
	}
	for(int i=0;i<index-1;i++)
	{
		for(int j=i;j<index-i-1;j++)
		{
			if(s[j]>s[j+1])
			{
				int a=s[j];
				s[j]=s[j+1];
				s[j+1]=a;
			}
		}
	}
	printf("%d",s[0]);
	for(int i=1;i<index;i++)
	{
		printf("%02d",s[i]);
	}
	return 0;
 } 
