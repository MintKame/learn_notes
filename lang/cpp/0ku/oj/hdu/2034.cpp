#include<stdio.h>
#include<stdlib.h>
void sort(int* a,int h,int t);
int main()
{
	int m,n;
	scanf("%d%d",&n,&m);
	while(m!=0||n!=0)
	{
		int *s=(int *)malloc(sizeof(int)*(m+n));
		for(int i=0;i<m+n;i++)
		{
			scanf("%d",&s[i]);
		}
		sort(s,0,n-1);
		sort(s,n,n+m-1);
		int j=n;
		int flag=0;		
		for(int i=0;i<n;i++)
		{
			while(s[j]<s[i]&&j<m+n)
			{
				j++;
				}	
			if(j==m+n&&i<n)
			{
				for(;i<n;i++)
				{
					printf("%d ",s[i]);
				}
				flag=1;
			}
			if(s[j]>s[i])
			{
				printf("%d ",s[i]);
				flag=1;
			}
		}
		if(flag==0)
		printf("NULL\n");
		else 
		putchar('\n');
		scanf("%d%d",&n,&m);
		free(s);
	}
	return 0;
 }
void sort(int* s,int head,int tail)
{
	int l=head;
	int r=tail;
	int key=s[l];
	while(l<r)
	{
		while(l<r&&s[r]>key)
		r--;
		s[l]=s[r];
		while(l<r&&s[l]<key)
		l++;
		s[r]=s[l];
	}
	s[l]=key;
	if(head<l)
	sort(s,head,l);
	if(l+1<tail)
	sort(s,l+1,tail);
}
