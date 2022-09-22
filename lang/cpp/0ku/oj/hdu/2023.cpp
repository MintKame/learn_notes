#include<stdio.h>
int main()
{
	int n,m;
	int tag=0;
	while(scanf("%d%d",&n,&m)!=EOF)//到下一组是上一组数据是否清空 
	{
//		if(tag==0)
//		tag=1;
//		else
//		{
//			putchar('\n');
//		}
		double s[51][6]={0};
		for(int i=1;i<=n;i++)
		{
			for(int j=1;j<=m;j++)
			{
				scanf("%lf",&s[i][j]);
				s[i][0]+=s[i][j];
				s[0][j]+=s[i][j];
			}
			s[0][0]+=s[i][0];
		}
		s[0][0]/=n;//为人科平均分
		for(int j=1;j<=n;j++)
		{
			if(j>1)
			putchar(' ');
			printf("%.2lf",s[j][0]/m);
		} 
		putchar('\n');
		for(int j=1;j<=m;j++)
		{
			if(j>1)
			putchar(' ');
			printf("%.2lf",s[0][j]/n);		
		}		
		putchar('\n');
		int cnt=0;
		for(int i=1;i<=n;i++)
		{
			if(s[i][0]<s[0][0])//
			continue;
			int j;
			for(j=1;j<=m;j++)
			{
				if(s[i][j]<s[0][j]/n)
				break;
			}
			if(j>m) cnt++;
		}
		printf("%d\n\n",cnt);
	}
	return 0;
}
