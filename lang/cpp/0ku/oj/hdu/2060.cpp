//15 red balls and 6 color balls
//12 * 1+7 * 12++ 2 + 3 + 4 + 5 + 6 + 7
#include<stdio.h>
int main()
{
	int n;
	scanf("%d",&n); 
 	for(int i=0;i<n;i++)
 	{
 		//输入
	 	int num,p,o;
		scanf("%d%d%d",&num,&p,&o);
		//算最大，比较 
		int s=0;
		if(num>6)
		s=(num-6)*8+27;
		else
		{
			for(int i=0;i<num;i++)
			s+=(7-i);
		}
		//输出
		if(s+p>=o)
		printf("Yes\n");
		else
		printf("No\n");
	 }
	return 0;
}
//能赢/平YES，不能NO 
