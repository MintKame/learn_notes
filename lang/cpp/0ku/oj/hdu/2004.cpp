#include<stdio.h>
int main()
{
	int a;
	while(scanf("%d",&a)==1)
	{
		if(a>100||a<0)
		printf("Score is error!\n");
		else if(a==100)
		printf("A\n");
		else
		switch(a/10)		
		{
			case 9:
				printf("A\n");
				break;
			case 8:
				printf("B\n");
				break;
			case 7:
				printf("C\n");
				break;
			case 6:
				printf("D\n");
				break;
			default:
				printf("E\n");
				break;
		}
	}
	return 0;
}
