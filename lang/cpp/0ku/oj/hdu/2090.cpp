#include<stdio.h>
#include<math.h>
int main()
{
	double sum=0,each,num;
	while(scanf("%*s%lf%lf",&each,&num)!=EOF)//EOF判断输入结束 	//*跳过输入 
	{
//		getchar();//不用getchar 
		sum+=each*num;
	}
//	if(10*sum-(int)(10*sum)-0.5<0)//==/！=才需要 fabs..<1E-6 
	printf("%.1lf\n",sum);
//	else
//	printf("%.1lf",sum+0.1);
	return 0;
}//eof判断：ctrl+z+回车 
//pe：加回车 
