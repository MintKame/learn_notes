#include<stdio.h>
#include<stdlib.h>
void mys(int *,int,int);
int main()
{
	int n;
	scanf("%d",&n);
	while(n!=0)
	{
		int s[105]={0};
		for(int i=0;i<n;i++)
		{
			scanf("%d",&s[i]);
		}
		mys(s,0,n-1);
		for(int i=n-1;i>0;i--)
		{
			printf("%d ",s[i]);
		}
		printf("%d\n",s[0]);
		scanf("%d",&n);
	}
 }
void mys(int *s,int first,int last)
{
	int l=first;
	int r=last;
	int key=s[first];
	while(l<r)
	{
		while(l<r&&abs(s[r])>=abs(key))
		r--;
		s[l]=s[r];
		while(l<r&&abs(s[l])<=abs(key))
		l++;
		s[r]=s[l];
	}
	s[l]=key;
	if(first<l)
	mys(s,first,l);
	if(l+1<last)
	mys(s,l+1,last);
	
 } 
