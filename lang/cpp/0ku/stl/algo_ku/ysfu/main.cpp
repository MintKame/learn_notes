#include "ysf.h"
#include <stdio.h>
int main()
{
    int n;
    scanf("%d", &n);
    List data = creatList(); //创建循环链表
    List *pList = &data;
    for (int i = 0; i < n; i++) //将节点添加到链表
    {
        int num;
        char na[50];
        char gen;
        scanf("%d %s %c", &num, na, &gen);
        addList(pList, num, na, gen);
    }
    showList(pList); //输出链表
    int start, interv, remain;
    scanf("%d%d%d", &start, &interv, &remain);
    Node *pNode = NULL;
    pNode = findList(pList, start); //找到number为为start的节点
    while (pList->cnt > remain)
    {
        for (int i = 0; i < interv - 1; i++) //移动interv-1次
        {
            pNode = pNode->next;
        }
        int tmp = deleteList(pList, pNode);
        printf("%d\n", tmp);
    }
    showList(pList);
    getchar();
    return 0;
}
