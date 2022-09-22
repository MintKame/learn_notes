#include<stdio.h>
int main()
{
	int n,m;
	scanf("%d%d",&n,&m);
	while(n!=0||m!=0)
	{
		//(a+x)*(x-a+1)/2==m->x=
		int a;
		int is=(n>m)?n:m;
		for(a=1;a<=is;a++)
		{
			int x;
			int tag=0;
			for(x=a;x<=is;x++)
			{
				if((a+x)*(x-a+1)/2==m)
				{
					tag=1;
					break;
				}
				else if((a+x)*(x-a+1)/2>m)
				break;
			}
			if(tag==1)
			printf("[%d,%d]\n",a,x);
		}
		putchar('\n');
		scanf("%d%d",&n,&m);		
	}
	return 0;
 } 
