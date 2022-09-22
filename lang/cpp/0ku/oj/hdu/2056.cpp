#include<stdio.h>
#include<math.h>
int main()
{
	double x[4]={0};
	double y[4]={0};
	while(scanf("%lf%lf",&x[0],&y[0])!=EOF)
	{
		for(int i=1;i<4;i++)
		{
			scanf("%lf%lf",&x[i],&y[i]);
		}
		double a,b;
		if(x[0]>x[1])
		{
			double temp=x[0];
			x[0]=x[1];
			x[1]=temp;
		}
		if(x[2]>x[3])
		{
			double temp=x[2];
			x[2]=x[3];
			x[3]=temp;
		}
		if(y[0]>y[1])
		{
			double temp=y[0];
			y[0]=y[1];
			y[1]=temp;
		}
		if(y[2]>y[3])
		{
			double temp=y[2];
			y[2]=y[3];
			y[3]=temp;
		}
		//
		if(x[0]>x[3]||x[1]<x[2]||y[0]>y[3]||y[1]<y[2])
		{
			printf("0.00\n");
			continue;
		}
		a=(x[3]>x[1])?x[3]:x[1];
		a-=(x[0]<x[2])?x[0]:x[2];
		a-=fabs(x[0]-x[2])+fabs(x[1]-x[3]);
//		printf("%lf %lf %lf %lf;\n",y[0],y[1],y[2],y[3]);
		b=(y[3]>y[1])?y[3]:y[1];
//		printf("%.2lf %.2lf\n",a,b);
		b-=(y[0]<y[2])?y[0]:y[2];
//		printf("%.2lf %.2lf\n",a,b);
		b-=fabs(y[0]-y[2])+fabs(y[1]-y[3]);
//		printf("%.2lf %.2lf\n",a,b);
		printf("%.2lf\n",a*b);
	}
	return 0;
}
