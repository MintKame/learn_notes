#include<stdio.h>
#include<ctype.h>
#include<string.h>
int main()
{
	int n;
	char s[10][31]={};
	int r[10][4]={};
	scanf("%d",&n);
	for(int i=0;i<n;i++)
	scanf("%s",s[i]);
	for(int i=0;i<n;i++)
	{
		if(strlen(s[i])<6)
		break;
		for(int j=0;j<strlen(s[i]);j++)
		{
			if(isdigit(s[i][j]))
			r[i][1]=1;
			else if(islower(s[i][j]))
			r[i][2]=1;
			else if(isupper(s[i][j]))
			r[i][3]=1;
			else
			r[i][0]=1;
		}
	}
	for(int i=0;i<n;i++)
	{
		if(r[i][0]+r[i][1]+r[i][2]+r[i][3]>=3)
		printf("yes\n");
		else
		printf("no\n");
	}
	return 0;
}
//
//ĳ��վ�涨ע���˺�ʱ�������ﵽһ��ǿ�Ȳſ��ԡ����ǹ涨���볤������6λ�����֡���д��ĸ��Сд��ĸ�����ţ�~!@#$%^&*()[]}{|\<>?/.,:����;�������������ٰ�������źϸ���������дһ�γ������ж�һ�������Ƿ�ϸ�
//���룺
//��һ��Ϊһ������n(0<n<10),�����������������
//�����n�в���������ÿ��Ϊһ�����Ȳ�����30���ַ���
//�����
//��n�У��������n�в����������Ӧ���������ϸ������yes���������no��
//
//��������
//2
//123456
//Hello2018.
//�������
//no
//yes
