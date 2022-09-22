#include<stdio.h>
#include<string.h>
void p1(int k);
void p2(int k);    
void p3(int k);   
void p4(int k);
void p5(int k);       
int main()
{
	int k;
	char s[300]={};
	scanf("%d%s",&k,s);
	int cnt=strlen(s);
//	5parts
	cnt--;
	for(int i=0;i<=cnt;i++)
	{
		switch(s[i])
		{
			case '1':
			case '4':
				p5(k);
				break;
			default:
				p1(k);
				break;
		}
		if(i!=cnt)
		putchar(' ');	
	}
	putchar('\n');
	for(int j=0;j<k;j++)
	{
		for(int i=0;i<=cnt;i++)
		{
			switch(s[i])
			{
				case '1':
				case '2':
				case '3':
				case '7':			
					p2(k);
					break;
				case '5':
				case '6':			
					p3(k);
					break;
				default://4890
					p4(k);
					break;
			}
			if(i!=cnt)
			putchar(' ');		
		}
		putchar('\n');
	} 
	for(int i=0;i<=cnt;i++)
	{
		switch(s[i])
		{
			case '1':
			case '7':
			case '0':
				p5(k);
				break;
			default:
				p1(k);
				break;
		}
		if(i!=cnt)
		putchar(' ');	
	}
	putchar('\n');
	for(int j=0;j<k;j++)
	{
		for(int i=0;i<=cnt;i++)
		{
			switch(s[i])
			{
				case '2':
					p3(k);
					break;
				case '0':
				case '8':
				case '6':			
					p4(k);
					break;
				default:
					p2(k);
					break;
			}
			if(i!=cnt)
			putchar(' ');		
		}
		putchar('\n');
	}
	for(int i=0;i<=cnt;i++)
	{
		switch(s[i])
		{
			case '1':
			case '7':
			case '4':
				p5(k);
				break;
			default:
				p1(k);
				break;
		}
		if(i!=cnt)
		putchar(' ');	
	}
	putchar('\n');
	return 0;
 } 
void p1(int k)
{
	putchar(' ');
	for(int i=0;i<k;i++)
	putchar('-');	
	putchar(' ');
}
void p2(int k)    
{
	for(int i=0;i<k+1;i++)
	putchar(' ');	
	putchar('|');
}
void p3(int k) 
{
	putchar('|');
	for(int i=0;i<k+1;i++)
	putchar(' ');
}  
void p4(int k)
{
	putchar('|');
	for(int i=0;i<k;i++)
	putchar(' ');	
	putchar('|');
}
void p5(int k)
{
	for(int i=0;i<k+2;i++)
	putchar(' ');
}  
//      --   --        --   --   --   --   --   -- 
//   |    |    | |  | |    |       | |  | |  | |  |
//   |    |    | |  | |    |       | |  | |  | |  |
//      --   --   --   --   --        --   --      
//   | |       |    |    | |  |    | |  |    | |  |
//   | |       |    |    | |  |    | |  |    | |  |
//      --   --        --   --        --   --   -- 
