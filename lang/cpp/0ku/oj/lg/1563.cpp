#include <stdio.h>
#include <stdlib.h>
typedef struct{
	char job[11];//小写 
	int dir;//0内，1外	
}People;//逆时针 
People p[100005];
int main(){
	long int n,m;
	scanf("%ld%ld",&n,&m);
	for(long int j=0;j<n;j++)
	{
		scanf("%d%s",&p[j].dir,p[j].job);
	}
	long int add=0;
	for(long int j=0;j<m;j++)
	{
		int lr;		//左0右 1
		long int num;	//人数 
		scanf("%d%ld",&lr,&num);//%%%
		if((p[add].dir==0&&lr==1)||(p[add].dir==1&&lr==0))
		{
			add+=num;
			add%=n;
		}
		else
		{
			add+=n-num;
			add%=n;
		}
	}	
	printf("%s",p[add].job);	
	return 0;
}
 
