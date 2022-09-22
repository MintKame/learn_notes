#include<stdio.h>
#include<stdlib.h>
typedef struct x{
	int num;
	struct x* next;
}Node;
int main()
{
//	FILE* f1=fopen("P1160_3.in","r");
	Node* head=(Node *)malloc(sizeof(Node));
	head->num=0;
	Node* start=(Node *)malloc(sizeof(Node));
	start->num=1;
	head->next=start;
	start->next=NULL;
	int n;
	scanf("%d",&n);
	for(int i=2;i<=n;i++)
	{
		int k,p;
		scanf("%d%d",&k,&p);
		//ÕÒ
		Node* find=head;
		while(find->next->num!=k)
		{
			find=find->next;
		} 
		//´æ+cha
		Node* temp=(Node *)malloc(sizeof(Node));
		temp->num=i;
		if(p==1)
		find=find->next;
		temp->next=find->next;
		find->next=temp;			
	}
	//É¾ 
	int m;
	scanf("%d",&m);
	for(int i=0;i<m;i++)
	{
		int serch;
		scanf("%d",&serch);	
		//ÕÒµ½/ÕÒ²»µ½
		Node* temp=head;
		while(temp->next!=NULL&&temp->next->num!=serch)
		{
			temp=temp->next;
		}
		if(temp->next!=NULL)
		{
			Node* aaa=temp->next;
			temp->next=temp->next->next;
		}		
	}
	//out
	Node* temp1=head->next;
	while(temp1!=NULL)
	{
		printf("%d ",temp1->num);
		Node* temp2=temp1;
		temp1=temp1->next;
		free(temp2);
	}
	putchar('\n');
	return 0;
}
