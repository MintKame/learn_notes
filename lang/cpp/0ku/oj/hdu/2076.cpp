#include<stdio.h>
#include<math.h>
#define sky 22
int f(int base,int num);
int main()
{
	//10,12,16各位之和为22 
	int n;
	scanf("%d",&n);
	while(n!=0)
	{
		int temp=f(10,n);
		if(temp==f(12,n)&&f(16,n)==temp)
		printf("%d is a Sky Number.\n",n);
		else
		printf("%d is not a Sky Number.\n",n);
		scanf("%d",&n);
	}
	return 0;
}
int f(int base,int num)
{
	int sum=0;
	while(num)
	{
		sum+=num%base;
		num/=base;
	}
	return sum;
}
