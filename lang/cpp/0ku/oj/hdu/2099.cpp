#include<stdio.h>
int main()
{
	int a,b;
	scanf("%d%d",&a,&b);
	while(a!=0||b!=0)
	{
		int i; 
		a*=100;
		for(i=0;i<100;i++)
		{
			if((a+i)%b==0)
			{
				if(i<10)//���Ǹ�λ��������ֻ��0 
				printf("0%d",i);//PE����ĩû�пո��ҵ���һ����break�ж� 
				else
				printf("%d",i);
				break; 
			}
		}
		for(int n=1;i+n*b<100;n++)
		{
			printf(" %d",i+n*b);
		}
		putchar('\n');
	scanf("%d%d",&a,&b);
	}
	return 0;
}
