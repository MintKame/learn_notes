#include<stdio.h>
#include<math.h>
int main()
{
	double sum=0,each,num;
	while(scanf("%*s%lf%lf",&each,&num)!=EOF)//EOF�ж�������� 	//*�������� 
	{
//		getchar();//����getchar 
		sum+=each*num;
	}
//	if(10*sum-(int)(10*sum)-0.5<0)//==/��=����Ҫ fabs..<1E-6 
	printf("%.1lf\n",sum);
//	else
//	printf("%.1lf",sum+0.1);
	return 0;
}//eof�жϣ�ctrl+z+�س� 
//pe���ӻس� 
