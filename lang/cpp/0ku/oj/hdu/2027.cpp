#include<stdio.h>
int main()
{
	int n;
	char c[5]={'a','e','i','o','u'};
	scanf("%d",&n);
	getchar();
	for(int i=0;i<n;i++)
	{
		int s[5]={0};
		char temp;
		while((temp=getchar())!='\n')
		{
			switch(temp)
			{
				case 'a':
					s[0]++;
					break;
				case 'e':
					s[1]++;
					break;
				case 'i':
					s[2]++;
					break;
				case 'o':
					s[3]++;
					break;				
				case 'u':
					s[4]++;
					break;
			}
		}
		for(int j=0;j<4;j++)
		{
			printf("%c:%d\n",c[j],s[j]);
		}
		if(i<n-1)
		printf("%c:%d\n\n",c[4],s[4]);
		else
		printf("%c:%d\n",c[4],s[4]);
	}
	return 0;
 } 
