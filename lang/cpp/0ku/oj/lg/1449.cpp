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
	//����ֱ��@ һ��һ�� 
	scanf("%[^@]",s);
	int len=strlen(s);
	for(int i=0;i<len;i++)
	{
		//		�ж� 
		int num=0;
		if(isdigit(s[i]))
		{
			num=s[i]-'0';
			while(isdigit(s[++i]))
			{
				num=num*10+s[i]-'0';
			}
			//����ջ.������
			Node* temp=(Node *)malloc(sizeof(Node));
			temp->value=num;
			temp->next=head;
			head=temp;
		}	
		else
		{
			//������ȡ���������Ż� 
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
	//��� 
	printf("%d",head->value);
	free(head);
	return 0;
 } 
