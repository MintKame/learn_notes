#include<stdio.h>
#include<stdlib.h>
#include<ctype.h>
#include<string.h>
typedef struct u{
	int value;
	struct u* next;
}Node;
int main()
{
	Node* head=(Node *)malloc(sizeof(Node));;
	char s[1005]={};
	//输入直到@ 一个一个 
	scanf("%[^@]",s);
	int len=strlen(s);
	for(int i=0;i<len;i++)
	{
		//		判断 
		int num=0;
		if(isdigit(s[i]))
		{
			num=s[i]-'0';
			while(isdigit(s[++i]))
			{
				num=num*10+s[i]-'0';
			}
			//数入栈.再申请
			Node* temp=(Node *)malloc(sizeof(Node));
			temp->value=num;
			temp->next=head;
			head=temp;
		}	
		else
		{
			//操作：取数，运算后放回 
			int a,b;
			Node* temp=head->next;
			a=head->value;
			b=temp->value;
			switch(s[i])
			{
				case '+':
				temp->value+=a;
				break;
				case '-':
				temp->value-=a;
				break;				
				case '*':
				temp->value*=a;
				break;
				case '/':
				temp->value/=a;
				break;
				case '%':
				temp->value%=a;
				break;
			}
			temp=head;
			head=head->next;			
			free(temp);
//	printf("%d\n",head->value);
		}		 
	}
	//输出 
	printf("%d",head->value);
	free(head);
	return 0;
 } 
