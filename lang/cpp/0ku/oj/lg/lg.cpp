#include<stdio.h>
int main()
{
	const int wy1=11;
	const int wy2=21;
	char s[62501]={};
	int r1[5682][2]={};
	int r2[2980][2]={};
	int i1,i2,i;
	char t=0;
	//cnt为有效字母个数 
	for(i=0;s[i-1]!='E';i++)
	{
		scanf("%c",&t);
		if(t=='W'||t=='L'||t=='E')
		s[i]=t;
		else i--; 
	}
	int j;
	int cnt=i-1;
	int m=0;
	//第一种11  wy1 r1
	for(i1=0;m<cnt;i1++)
	{
		
		while(((r1[i1][0]<wy1)&&(r1[i1][1]<wy1))||((r1[i1][0]-r1[i1][1]>-2)&&(r1[i1][0]-r1[i1][1]<2)))
		{
			if(s[m]=='E')
			break;
			else if(s[m]=='W')
			r1[i1][1]++;
			else
			r1[i1][0]++;
			m++;
//			printf("%d %d %c %d %d\n",i,m,s[m],r1[i][1],r1[i][0]);
		}
	}
	//第二种21 
	for(i2=0,m=0;m<cnt;i2++)
	{
		while(((r2[i2][0]<wy2)&&(r2[i2][1]<wy2))||((r2[i2][0]-r2[i2][1]>-2)&&(r2[i2][0]-r2[i2][1]<2)))
		{
			if(s[m]=='E')
			break;
			else if(s[m]=='W')
			r2[i2][1]++;
			else
			r2[i2][0]++;
			m++;
//			printf("%d %d %c %d %d\n",i,m,s[m],r1[i][1],r1[i][0]);
		}
	}	//output
	if(cnt==0) printf("0:0\n");
	else{
		for(j=0;j<i1;j++)
		printf("%d:%d\n",r1[j][1],r1[j][0]);
		if(!(((r1[i1-1][0]<wy1)&&(r1[i1-1][1]<wy1))||((r1[i1-1][0]-r1[i1-1][1]>-2)&&(r1[i1-1][0]-r1[i1-1][1]<2))))
		printf("0:0\n");
	}
	printf("\n");
	if(cnt==0) printf("0:0\n");
	else{
		for(j=0;j<i2;j++)
		printf("%d:%d\n",r2[j][1],r2[j][0]);
		if(!(((r2[i2-1][0]<wy2)&&(r2[i2-1][1]<wy2))||((r2[i2-1][0]-r2[i2-1][1]>-2)&&(r2[i2-1][0]-r2[i2-1][1]<2))))
		printf("0:0\n");
	}
	return 0;
}
