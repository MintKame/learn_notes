#include<stdio.h>
int main()
{
	int n;
	scanf("%d",&n);
	for(int i=0;i<n;i++)
	{
		int h1,h2,m1,m2,s1,s2;
		scanf("%d%d%d%d%d%d",&h1,&m1,&s1,&h2,&m2,&s2);
		int h,m,s;
		s=s1+s2;
		h=h1+h2;		
		m=m1+m2;
		if(s>=60)
		{
			s%=60;
			m++;
		}
		if(m>=60)
		{
			m%=60;
			h++;
		}
		printf("%d %d %d\n",h,m,s);
 }
 	return 0;
}
