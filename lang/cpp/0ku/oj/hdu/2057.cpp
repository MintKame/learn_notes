#include<stdio.h>
int main()
{
	char a[20]={0};
	char b[20]={0};

	while(~scanf("%s%s",a,b))
	{
		char c[20]={0};
		//a，b每位转成数字for 
		int len_a=strlen(a);
		int len_b=strlen(b);
		for(int i=1;i<len_a;i++)
		{
			if(isdigit(a[i]))
			a[i]=a[i]-'0';
			else
			a[i]=a[i]-'A'+10;
		}
		for(int i=1;i<len_b;i++)
		{
			if(isdigit(b[i]))
			b[i]=b[i]-'0';
			else
			b[i]=b[i]-'A'+10;			
		}
		//tag记录正负 if
		int tag_a=1;
		int tag_b=1;
		if(a[0]=='-')
		tag_a=-1;
		if(b[0]=='-')
		tag_b=-1;
		//每位算到c（用tag和a，b）for 
		int len_c=(len_a>len_b)?len_a:len_b;
		int temp=len_c;
		if(len_a>=len_b)
		{
			while(len_b>1)
			c[--temp]=tag_a*a[--len_a]+tag_b*b[--len_b];
			while(len_a>1)
			c[--temp]=tag_a*a[--len_a];
		}
		else
		{
			while(len_a>1)
			c[--temp]=tag_a*a[--len_a]+tag_b*b[--len_b];
			while(len_b>1)
			c[--temp]=tag_b*b[--len_b];
		}
		//c判断进位 for if 
		for(int i=len_c-1;i>0;i--)
		{
			if(c[i]>=16) 
			{
				c[i-1]+=c[i]/16;
				c[i]%=16;
			}
			else if(c[i]<0)
			{
				while(c[i]<0)
				{
					c[i]+=16;
					c[i-1]-=1;		
				}
			}
		}
		//为负的计算
		int w=0;
		int tag=1;
		for(;c[w]==0;w++);
		if(c[w]<0) 
		{
			tag=-1;
			int temp=c_len-1;
			c[temp]--;
			for(;temp>w;temp--)
			c[temp]-=15;
		}
		//c判断进位 for if 
		for(int i=len_c-1;i>w;i--)
		{
			if(c[i]<0)
			{
				while(c[i]<0)
				{
					c[i]+=16;
					c[i-1]-=1;		
				}
			}
		}

		//输出：数字直接%d，字母判断转化输出for if 


	}
	return 0;
 } 
