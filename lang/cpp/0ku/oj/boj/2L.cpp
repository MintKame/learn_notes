#include<stdio.h>
int main()
{
	int a,b;
	scanf("%d %d",&a,&b);
	int s[30000]={};
	int k=0;
	for(int j=a;j<=b;j++)
	{
		int r=1;
		if(j%2==0)
		r=0;
		for(int i=3;r==1&&i*i<=j;i+=2)
		{
			if(j%i==0)
			{
				r=0;
				break;
			}
		}
		if(r==1)
		{
		s[k++]=j;
		}
	}
	
//for���ж�Ҫ��s��ʼ��Ϊ0 
	for(int i=0;s[i]!=0;i++)
	{
		int r=1;
		int weishu=1;
		int temp=s[i];//��ʱ����siÿ�θ��º���� 
		for(;temp/weishu!=0;weishu*=10);//������λ 
		weishu/=10;
//		printf("%d\n",weishu);
		for(;weishu>1;weishu/=100)//���³���100������temp����һ����2λ 
		{
			if(temp/weishu!=temp%10)
			{
				r=0;
				break;
			}
//			printf("%d %d\n",temp/weishu,temp%10);
			temp-=((temp/weishu)*weishu);
			temp/=10;
		}
		if(r==1)
		printf("%d\n",s[i]);
	
	}
	return 0;
}
//��Ϊ151����һ����������һ���������������Һʹ��ҵ����ǿ�һ���ģ�������151�ǻ�����������дһ���������ҳ���Χ[a,b] (5��a��b��100000)������л���������
//���룺ֻ��һ�У�Ϊ�������������δ���a,b ��
//�����ÿ�������������һ�С�����������֤����Ϸ���������ٰ���һ������������
//��������
//100 200
//�������
//101
//131
//151
//181
//191
