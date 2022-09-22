#include<stdio.h>
int main()
{
	int n,t1,t0,m,score,last;
	int  ren[5000][2]={};
	scanf("%d%d",&n,&m);
	for(int i=0;i<n;i++)
	scanf("%d%d",&ren[i][0],&ren[i][1]);
	last=1.5*m;
	for(int i=0;i<n-1;i++)
	{
		for(int j=0;j<n-i;j++)
		{
			if(ren[j][1]<ren[j+1][1])
			{
				t1=ren[j][1];
				t0=ren[j][0];
				ren[j][1]=ren[j+1][1];
				ren[j][0]=ren[j+1][0];
				ren[j+1][0]=t0;
				ren[j+1][1]=t1;
			}
			else if(ren[j][1]==ren[j+1][1]&&ren[j][0]>ren[j+1][0])
			{
				t1=ren[j][1];
				t0=ren[j][0];
				ren[j][1]=ren[j+1][1];
				ren[j][0]=ren[j+1][0];
				ren[j+1][0]=t0;
				ren[j+1][1]=t1;
			}
		}
	}
	score=ren[last-1][1];
	for(;ren[last][1]==score;last++);
	printf("%d %d\n",score,last);
	for(int i=0;i<last;i++){
		printf("%d %d\n",ren[i][0],ren[i][1]);
	}
	return 0;
}
