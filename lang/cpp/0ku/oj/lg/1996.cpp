#include<stdio.h>
#include<stdlib.h>
typedef struct o{
	int value;
	struct o* next;
}Node;
int main()
{
	int n,m;//n:1,m:1
	scanf("%d%d",&n,&m);
	//�½�+����value+
	Node* head=(Node*)malloc(sizeof(Node));
	head->value=1;
	head->next=NULL;
	Node* p=head; 
	for(int i=2;i<=n;i++)
	{
//		printf("1");
		Node *temp=(Node*)malloc(sizeof(Node));
		temp->value=i;
		temp->next=NULL;
		p->next=temp;
//		printf("%d %d\n",p->value,p->next->value);
		p=p->next;
	}
	//���һ��ָ��ͷ 
	p->next=head;
//	printf("%d %d\n",p->value,p->next->value);
	//������next �����Լ� 
	//a=1,a%3==0,�����free 
	int cnt=0;
	p=head;
	while(p->next!=p)
	{
		cnt++;
		if((cnt+1)%m==0)//��p����һ��Ҫ���� 
		{
			Node *temp=p->next;//free
			printf("%d ",p->next->value);
			p->next=p->next->next;
			free(temp);
		}
		else
		p=p->next;
	}	 
	//������һ�� 
	//free���һ�� 
	printf("%d",p->value);
	free(p); 
	return 0;
 } 
