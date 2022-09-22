#include<stdio.h>
#include<string.h>
void sSort(char a[][20],int,int);
int sCmp(char* a,char *b);
int main()
{
	//字符串数组
	int n;
	char s[20][20]={};
	//输入
	scanf("%d",&n);
	for(int i=0;i<n;i++)
	{
		scanf("%s",s[i]);
	}
	//bijiao
	sSort(s,0,n-1);
	// 输出 
	for(int i=0;i<n;i++)
	{
		printf("%s",s[i]);
	}	
	return 0;
 }
//sort
int sCmp(char *a,char *b)
{
	int sa=strlen(a);
	int sb=strlen(b);
	int min=0;
	int len=sa;
	if(sa>sb)
	{
		len=sb;
		min=2;
	}
	else if(sa<sb)
	{
		min=1;
	}
	int ans=strncmp(a,b,len); 
	if(ans==0)
	{
		//应当比较较大数余下位数 和较小数 
		if(min==1)
		{
			ans=sCmp(a,b+len);
		}
		else if(min==2)
		{
			ans=sCmp(a+len,b);
		}
//		if(sa>sb)
//		ret=-1;
//		else if(sa<sb)
//		ret=1;
//		else 
//		ret=0;
	}
	return ans;
}
void sSort(char s[][20],int first,int last)
{
	char key[20]={};//
	strcpy(key,s[first]);
	int l=first,r=last;
	while(l<r)
	{
		while(l<r&&sCmp(s[r],key)<=0)//比较字符串strcpy
		r--;
		strcpy(s[l],s[r]);//c,bec
		s[l][strlen(s[r])]=0;
		while(l<r&&sCmp(s[l],key)>=0)//strcpy，前一个先为空才可 
		l++;
		strcpy(s[r],s[l]);
		s[r][strlen(s[l])]=0;
	}
	strcpy(s[l],key);
	s[l][strlen(key)]=0;
	if(first<l-1)
	{
		sSort(s,first,l-1);
	}
	if(l+1<last)
	{
		sSort(s,l+1,last);
	}
 }  
