
#include <stdio.h>
typedef struct as
{
    int d;
    int w;
    /* data */
} R;
R people[20005];
void qSort(R *, int first, int last);
void qqSort(R *, int first, int last);
int main()
{
    int e[11] = {};
    int n, k;
    // 第一行输入用空格隔开的两个整数，分别是n和k。
    // 第二行给出了10个正整数，分别是E[1]到E[10]。
    // 第三行给出了n个正整数，第i个数表示编号为i的人的权值W[i]。
    scanf("%d%d", &n, &k);
    for (int i = 0; i < 10; i++)
    {
        scanf("%d", &e[i + 1]);
    }
    for (int i = 0; i < n; i++)
    {
        scanf("%d", &people[i + 1].w);
    }
    //初始权值W[i]从大到小进行排序，
    qSort(people, 1, n);
    // 每人就有了一个序号D[i]（取值同样是1--n）。
    for (int i = 0; i < n; i++)
    {
        int temp = i + 1;
        people[i].d = i;
        //类别c=(D[i]-1) mod 10 +1。得E[c]的权值。
        temp = (temp - 1) % 10 + 1;
        people[i].w += e[temp];
    }
    //求出加上额外权值以后，最终的权值最大的k个人，并输出编号。
    // 在排序中，如果两人的W[i]相同，编号小的优先。
    qSort(people, 1, n);
    for (int i = 1; i <= k; i++)
    {
        if (people[i].w == people[i + 1].w)
        {
            int temp = i + 1;
            while (temp <= n && people[i].w == people[temp].w)
                temp += 1;
            qqSort(people, i, temp - 1);
        }
    }
    for (int i = 1; i < k; i++)
    {
        printf("%d ", people[i].w);
        /* code */
    }
    return 0;
}
// 输出格式
// 只需输出一行用空格隔开的k个整数，分别表示最终的W[i]从高到低的人的编号。
void qSort(R *people, int first, int last)
{
    int l = first;
    int r = last;
    int key = people[l].w;
    int temp = people[l].d;
    while (l < r /* condition */)
    {
        while (l < r && people[r].w >= key)
        {
            r--;
        }
        people[l] = people[r];
        while (l < r && people[l].w <= key)
        {
            l++;
        }
        people[r] = people[l];
        /* code */
    }
    people[l].d = temp;
    people[l].w = key;
    if (first < l)
    {
        qSort(people, first, l);
    }
    if (l + 1 < last)
    {
        qSort(people, l + 1, last);
    }
    getchar();
}
void qqSort(R *people, int first, int last)
{
    int l = first;
    int r = last;
    int key = people[l].d;
    int temp = people[l].w;
    while (l < r /* condition */)
    {
        while (l < r && people[r].d >= key)
        {
            r--;
        }
        people[l] = people[r];
        while (l < r && people[l].d <= key)
        {
            l++;
        }
        people[r] = people[l];
        /* code */
    }
    people[l].w = temp;
    people[l].d = key;
    if (first < l)
    {
        qqSort(people, first, l);
    }
    if (l + 1 < last)
    {
        qqSort(people, l + 1, last);
    }
}
