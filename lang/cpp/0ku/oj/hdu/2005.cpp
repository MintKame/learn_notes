#include<stdio.h>
int main()
{
	int y,m,d;
	const int eachMonth[13]={0,31,28,31,30,31,30,31,31,30,31,30,31};
	int ans=0;
	while(scanf("%d/%d/%d",&y,&m,&d)!=EOF)
	{
		ans=d;
		for(int i=1;i<m;i++)
		ans+=eachMonth[i];
		if(((y%400==0)||(y%4==0&&y%100!=0))&&m>2) 
		ans++;//只有月份大于2才可 
		printf("%d\n",ans);
	}
	return 0;
}
