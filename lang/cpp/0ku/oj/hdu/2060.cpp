//15 red balls and 6 color balls
//12 * 1+7 * 12++ 2 + 3 + 4 + 5 + 6 + 7
#include<stdio.h>
int main()
{
	int n;
	scanf("%d",&n); 
 	for(int i=0;i<n;i++)
 	{
 		//����
	 	int num,p,o;
		scanf("%d%d%d",&num,&p,&o);
		//����󣬱Ƚ� 
		int s=0;
		if(num>6)
		s=(num-6)*8+27;
		else
		{
			for(int i=0;i<num;i++)
			s+=(7-i);
		}
		//���
		if(s+p>=o)
		printf("Yes\n");
		else
		printf("No\n");
	 }
	return 0;
}
//��Ӯ/ƽYES������NO 
