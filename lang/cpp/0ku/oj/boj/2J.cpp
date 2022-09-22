#include<stdio.h>
//Êä³ö×Ö·û´® 
int main()
{
	int n;
	char s[5][11]={};
	int order[5]={};
	scanf("%d",&n);
	for(int i=0;i<n;i++)
	scanf("%s",s[i]);
	for(int i=0;i<n;i++)
	scanf("%d",&order[i]);
	int i;
	for(i=0;i<n-1;i++)
	printf("%s ",s[order[i]]);
	printf("%s",s[order[i]]); 
	return 0;
 } 
