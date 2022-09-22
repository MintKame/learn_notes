#include<stdio.h>
#include<string.h>
int main()
{
	char s[101]={};
	char r[50]={};
	char b[50]={};
	scanf("%s",s);
	int l=strlen(s);
	b[l]=1;
	for(int i=l-1;i>=0;i--)
	{
		if(s[i]=='1')
		for(int j=l;j>0;j--)
		{
			r[j]+=b[j];
			for(int k=0;r[j-k]>9;k++)
			{
				r[j-k]-=10;
				r[j-k-1]++;
			}
		}
		for(int j=l;j>0;j--)
		{
			b[j]*=2;
		}
		for(int j=l;j>0;j--)
		{
			if(b[j]>9){
				b[j]-=10;
				b[j-1]++;
			}
		}
	}
	int i;
	for(i=0;r[i]==0;i++);
	for(;i<l-1;i++)
	printf("%d",r[i]);
	return 0;
}
