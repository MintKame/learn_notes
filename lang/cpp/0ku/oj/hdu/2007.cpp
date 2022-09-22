#include<stdio.h>
int main()
{
	int m,n;
	while(scanf("%d%d",&m,&n)!=EOF)
	{
		//2数不一定按大小
		if(m>n)
		{
			int temp=m;
			m=n;
			n=temp; 
		 } 
		int ji=0,ou=0;//算结果的变量是否清空 
		if(m%2==0)
		{
			for(int i=m;i<=n;i+=2)
			ou+=i*i;
			for(int i=m+1;i<=n;i+=2)
			ji+=i*i*i;
		}
		else
		{
			for(int i=m+1;i<=n;i+=2)
			ou+=i*i;
			for(int i=m;i<=n;i+=2)
			ji+=i*i*i;
		}
		printf("%d %d\n",ou,ji);//算数是否int足够  
	 } 
	return 0;
 }  
