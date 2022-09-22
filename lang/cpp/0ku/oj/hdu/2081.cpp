#include<stdio.h>
int main()
{
	int n;
	scanf("%d",&n);
	for(int i=0;i<n;i++)
	{
		getchar();
		for(int j=0;j<6;j++)
		{
			getchar();
		}
		int num;
		scanf("%d",&num);
		printf("6%05d\n",num);
	}
	return 0;
}
