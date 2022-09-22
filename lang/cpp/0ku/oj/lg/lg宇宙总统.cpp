#include<stdio.h>
#include<string.h>
int main()
{
	int n=0;
	char a[20][101]={};
	scanf("%d",&n);
	for(int i=0;i<n;i++)
	scanf("%s",a[i]);
	int num=0;
	char* v=a[num];
	for(int i=1;i<n;i++)
	{
		int swap=0;
//		printf("%d %d %d\n",num,i,strcmp(a[i],v));
		if(strlen(a[i])>strlen(v))
		swap=1;
		else if(strlen(a[i])==strlen(v))
		if(strcmp(a[i],v)>0)
		swap=1;
		if(swap==1)
		{
			num=i;
			v=a[num];
		}
	}
	printf("%d\n%s",num+1,v);
	return 0;
 }
