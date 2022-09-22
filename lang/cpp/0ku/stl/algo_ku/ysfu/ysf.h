#include <stdio.h>
typedef struct ysf
{
    int number;
    char name[50];
    char gender;
    struct ysf *next;
} Node;
typedef struct a
{
    Node *first;
    Node *last;
    int cnt;
} List;
/*
 *创建一个空循环链表
 *@return 空链表
 **/
List creatList();
/*
 * 根据数据创建节点，并加到链表
 *@param 链表指针l，节点的数据n，na，c
 **/
void addList(List *l, int n, char *na, char c);
/*
 * 输出链表
 *@param 链表指针
 **/
void showList(List *l);
/*
 * 根据number查找
 *@param 链表指针，要找的数
 *@return 该节点的上一个节点的地址,未找到NULL
 **/
Node *findList(List *l, int num);
/*
 * 删除下一个节点
 *@param 链表的指针，被删节点的前一个节点的指针
 *@return被删节点的编号,空链表返回-1
 **/
int deleteList(List *pList, Node *pNode);
