#include<stdio.h>
#include<string.h>
int main()
{
	char s[101]={};
	char bin[40]={};
	char r[40]={};
	scanf("%s",s);
	
	bin[0]=1;
	for(int i=100;i>=0;i--)
	{
//		printf("%d\t",i);
		//��λ��r��bin 
		if(s[i]=='1')
		for(int u=0;u<40;u++)
		{
			r[u]+=bin[u];
			for(int v=0;r[u+v]>9;v++)
			{
				r[u+v]-=10;
				r[u+v+1]++;
			}
		}
		for(int i=39;i>=0;i--)//
//		printf("%d",r[i]);
//		int l=strlen(bin);
		//����forѭ����l�滻Ϊstr������l����str���ϸ��£����� 
		//�������λ��������*2�����󣬸ģ���ÿλ*2�ٽ�λ
		//��strlen���ַ�������0������str �������ַ�0->'0',�������޷���ʼ��Ϊ'0'�� 
		for(int j=0;j<40;j++)
			bin[j]*=2;
//		l=strlen(bin);
		for(int j=0;j<40;j++)
		{
			if(bin[j]>9)
			{
				bin[j]-=10;
				bin[j+1]++;
			}
		}
//		putchar('\t');
//		for(int i=strlen(bin)-1;i>=0;i--)//
//		printf("%d",bin[i]);
//		putchar('\n');
	}
	//��������н�β��0���ȴ����һλ��������0���ٴ���һλ��ʼ���
	int cnt=39;
	for(;r[cnt]==0;cnt--); 
	for(;cnt>=0;cnt--)
	printf("%d",r[cnt]);
	return 0;
 } 
