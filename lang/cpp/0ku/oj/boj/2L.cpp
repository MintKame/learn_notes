#include<stdio.h>
int main()
{
	int a,b;
	scanf("%d %d",&a,&b);
	int s[30000]={};
	int k=0;
	for(int j=a;j<=b;j++)
	{
		int r=1;
		if(j%2==0)
		r=0;
		for(int i=3;r==1&&i*i<=j;i+=2)
		{
			if(j%i==0)
			{
				r=0;
				break;
			}
		}
		if(r==1)
		{
		s[k++]=j;
		}
	}
	
//for的判断要求s初始化为0 
	for(int i=0;s[i]!=0;i++)
	{
		int r=1;
		int weishu=1;
		int temp=s[i];//临时储存si每次更新后的数 
		for(;temp/weishu!=0;weishu*=10);//获得最高位 
		weishu/=10;
//		printf("%d\n",weishu);
		for(;weishu>1;weishu/=100)//更新除以100，由于temp更新一次少2位 
		{
			if(temp/weishu!=temp%10)
			{
				r=0;
				break;
			}
//			printf("%d %d\n",temp/weishu,temp%10);
			temp-=((temp/weishu)*weishu);
			temp/=10;
		}
		if(r==1)
		printf("%d\n",s[i]);
	
	}
	return 0;
}
//因为151既是一个质数又是一个回文数（从左到右和从右到左是看一样的），所以151是回文质数。请写一个程序来找出范围[a,b] (5≤a≤b≤100000)间的所有回文质数。
//输入：只有一行，为两个整数，依次代表a,b 。
//输出：每个回文质数输出一行。测试用例保证输入合法且输出至少包含一个回文质数。
//输入样例
//100 200
//输出样例
//101
//131
//151
//181
//191
