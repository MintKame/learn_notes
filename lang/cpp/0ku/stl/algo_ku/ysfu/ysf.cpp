#include "ysf.h"
#include <stdlib.h>
#include <string.h>
List creatList()
{
    List l;
    l.cnt = 0;
    l.first = NULL;
    l.last = NULL;
    return l;
}
void addList(List *l, int n, char *na, char c)
{
    Node *data = (Node *)malloc(sizeof(Node));
    data->gender = c;
    // data->name = na;
    strcpy(data->name, na);
    data->number = n;
    if (l->cnt == 0)
    {
        data->next = data;
        l->first = data;
        l->last = data;
    }
    else
    {
        data->next = l->first;
        l->last->next = data;
        l->last = data;
    }
    l->cnt++;
}
void showList(List *l)
{
    printf("number\tname\tgender\n");
    Node *tmp = l->first;
    for (size_t i = 0; i < l->cnt; i++)
    {
        printf("%d\t%s\t%c\n", tmp->number, tmp->name, tmp->gender);
        tmp = tmp->next;
    }
}
Node *findList(List *l, int num)
{
    int a = l->cnt;
    Node *tmp = l->first;
    for (int i = 0; i < a; i++)
    {
        if (tmp->next->number == num)
        {
            break;
        }
        tmp = tmp->next;
    }
    if (tmp->next->number == num)
    {
        return tmp;
    }
    else
    {
        return NULL;
    }
}
int deleteList(List *pList, Node *pNode)
{
    if (pList->cnt == 0)
    {
        return -1;
    }
    int ret;
    if (pList->cnt == 1)
    {
        ret = pNode->number;
        free(pNode);
    }
    else
    {
        ret = pNode->next->number;
        pNode->next = pNode->next->next;
        free(pNode->next);
    }
    return ret;
}
