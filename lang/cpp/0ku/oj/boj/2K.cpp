#include<stdio.h>
int main()
{
	const int xs[17]={7,9,10,5,8,4,2,1,6,3,7,9,10,5,8,4,2,};
	int n;
	int r[12]={1,0,'X'-'0',9,8,7,6,5,4,3,2,};
	int s[100][19]={};
	scanf("%d",&n);
	for(int i=0;i<n;i++)
	{
		for(int j=0;j<18;j++)
		{
 			scanf("%1d",&s[i][j]);
		}
		scanf("%c",&s[i][17]); 
		s[i][17]-='0';
		
	 } 
	 //s[i][17]用scanf输入不可用%d，scanf中第一个参数：把输入当作什么类型，输入后再根据储存的变量类型转换 
	for(int i=0;i<n;i++)
	{
		int t=0;
		for(int j=0;j<17;j++)
		{
			t+=xs[j]*s[i][j];
		}
		t%=11;
		if(s[i][17]!=r[t])
		printf("wrong\n");
		else
		printf("right\n");
//34052419800101001X
//-
	}
	return 0;
 } 
