#include<stdio.h>
#include<string.h>
//入为一个二进制大整数（大整数大于0，不带符号，无前导0，至少1位数字，且不超过100位数字）。要求将该整数转换成十进制数，并输出。
//建议：用字符数组存储大整数。
//
//输入样例
//1001001100101100000001011010010
//输出样例
//1234567890 
int main()
{
	//二进制转十进制，无除法，不用strlen判断位数 
	char s[101]={};
	char r[101]={};
	char b[101]={};
	scanf("%s",s);
	int l=strlen(s)-1;
	b[l]=1;
	for(int i=l;i>=0;i--)
	{
		if(s[i]=='1')
		for(int j=l;j>=0;j--)//最后要到j=0 
		{
			r[j]+=b[j];
			if(r[j]>9)
			{
				r[j]-=10;
				r[j-1]++;
			}
		}
//		每位要*的数：先*2在判断是否进位 
		for(int j=l;j>=0;j--)
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
	for(i=0;r[i]==0;i++);//跳过前导0 ，若r为0则单独判断 
	if(i>l)
	printf("0"); 
	for(;i<=l;i++)
	//i与l比较？ 
	printf("%d",r[i]);
	return 0;
}
