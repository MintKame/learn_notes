#include<stdio.h>
#include<string.h>
int main()
{
	char a[550]={'0'},b[550]={'0'};
	scanf("%s%s",a+1,b+1);//留一位进位 
	int pa=strlen(a)-1;
	int pb=strlen(b)-1;
	char *pM=pa>=pb?(a+pa):(b+pb);
	char *pm=pa>=pb?(b+pb):(a+pa);
	char *t2=pm;
	for(char *t1=pM;t2!=a&&t2!=b;t1--,t2--)
	{
		*t1+=*t2-'0';
	}
	char *t1=pM;
	int tag=0;
	do{
		if(tag==1)
		(*t1)++;
		tag=0;
		if(*t1>'9')
		{
			(*t1)-=10;
			tag=1;
		}
		t1--;
	}while(t1!=a&&t1!=b);
	char* o;
	if(pa>=pb)
	o=a+1;
	else
	o=b+1;
	if(tag==1)
	printf("1%s",o);
	else
	printf("%s",o);
	return 0;
}
