#include<stdio.h>
#include<math.h>
int main()
{
	int m,n,k,l;
	int i,j,r;
	int hs[21][21]={0};
	int px[400][3]={};
	scanf("%d%d%d",&m,&n,&k);
	for(i=0;i<m;i++)
	{
		for(j=0;j<n;j++)
		scanf("%d",&hs[i][j]);
	}
	int x,y,temp;
	for(l=0;l<400;l++){
		temp=0;
		x=20;
		y=20;
		for(i=0;i<m;i++)
		{
			for(j=0;j<n;j++)
			{
				if(temp<hs[i][j])
				{
					x=i;
					y=j;
					temp=hs[i][j];
				}
			}
		}
		hs[x][y]=0;
		px[l][0]=x;
		px[l][1]=y;
		px[l][2]=temp;		
	}
	//+2+y0+xiangdui+ 
//	已经排序完了，之后就是算步数并于要求比较  cnt+1+y,k
	x=px[0][0];
	y=px[0][1];
	int cnt=x+1;
	r=px[0][2];
	if(cnt+x+2>k) printf("0");
	else
	{
		for(i=1;i<=400;i++)
		{
			if(cnt+abs(px[i][0]-x)+abs(px[i][1]-y)+px[i][0]+2>=k)
			break;
			cnt+=1+abs(px[i][0]-x)+abs(px[i][1]-y);
			x=px[i][0];
			y=px[i][1];
			r+=px[i][2];
		} 
		printf("%d",r);	
	}
	return 0;
}

