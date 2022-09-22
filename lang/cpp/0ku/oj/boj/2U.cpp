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
//某网站规定注册账号时密码必须达到一定强度才可以。他们规定密码长度至少6位，数字、大写字母、小写字母、符号（~!@#$%^&*()[]}{|\<>?/.,:”‘;）这四类中至少包含三类才合格。现在请你写一段程序来判断一个密码是否合格。
//输入：
//第一行为一个整数n(0<n<10),代表测试用例组数，
//后边是n行测试用例，每行为一个长度不超过30的字符串
//输出：
//共n行，与输入的n行测试用例相对应，如果密码合格则输出yes，否则输出no。
//
//输入样例
//2
//123456
//Hello2018.
//输出样例
//no
//yes
