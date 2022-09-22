#include<stdio.h>
#include<string.h>
int main()
{
	char temp;
	while((temp=getchar())!='#')
	{
		char s[200][100]={0};
		s[0][0]=temp;
		int i=0,j=1;
		while((temp=getchar())!='\n')
		{
			if(temp==' ')
			{
				for(int p=0;p<i;p++)
				{	
					if(strcmp(s[p],s[i])==0)
					{
						for(int q=0;q<strlen(s[i]);q++)
						s[i][q]=0;
						i--;
						break;
					}
				}		
				i++;
				j=0;
			}
			else
			{
				s[i][j++]=temp;
			}
		}
		printf("%d\n",i);
	}
	return 0;
}
