#include<stdio.h>
#include<string.h>
int main()
{
	char s[101]={};
	char bin[40]={};
	char r[40]={};
	scanf("%s",s);
	
	bin[0]=1;
	for(int i=100;i>=0;i--)
	{
//		printf("%d\t",i);
		//按位加r与bin 
		if(s[i]=='1')
		for(int u=0;u<40;u++)
		{
			r[u]+=bin[u];
			for(int v=0;r[u+v]>9;v++)
			{
				r[u+v]-=10;
				r[u+v+1]++;
			}
		}
		for(int i=39;i>=0;i--)//
//		printf("%d",r[i]);
//		int l=strlen(bin);
		//若在for循环中l替换为str，由于l增大，str不断更新，错误 
		//若加完低位进的数再*2，错误，改：先每位*2再进位
		//用strlen，字符串若有0出现则str ，改用字符0->'0',不可行无法初始化为'0'， 
		for(int j=0;j<40;j++)
			bin[j]*=2;
//		l=strlen(bin);
		for(int j=0;j<40;j++)
		{
			if(bin[j]>9)
			{
				bin[j]-=10;
				bin[j+1]++;
			}
		}
//		putchar('\t');
//		for(int i=strlen(bin)-1;i>=0;i--)//
//		printf("%d",bin[i]);
//		putchar('\n');
	}
	//跳过结果中结尾的0，先从最后一位遍历至非0，再从这一位开始输出
	int cnt=39;
	for(;r[cnt]==0;cnt--); 
	for(;cnt>=0;cnt--)
	printf("%d",r[cnt]);
	return 0;
 } 
