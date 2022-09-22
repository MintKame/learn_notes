/** sort.cpp */
#define ARRSIZE 100 // 待排序表的表长不少于100
#include <cstdlib>
#include <vector>
#include <iostream>
using namespace std;

int cnt[9][2] = {}; // 记录上次sort函数cmp, move 次数

static void swap(int &a, int &b)
{
    int tmp = a;
    a = b;
    b = tmp;
}
static int *getCopy(int *arr, int size)
{
    int *copy = new int[size];
    for (int i = 0; i < size; i++)
    {
        copy[i] = arr[i];
    }
    return copy;
}
static void print(int *arr, int size)
{
    cout << endl;
    for (int i = 0; i < size; ++i)
    {
        cout << arr[i] << ' ';
    }
    cout << endl;
}
// simple
static void bubbleSort(int arr[], int size)
{
    int isFinish = false;
    cnt[0][0] = 0, cnt[0][1] = 0;
    for (int i = 0; i < size - 1 && !isFinish; i++)
    {
        isFinish = true;
        for (int j = 0; j < size - i - 1; j++)
        {
            cnt[0][0]++; //cmp
            if (arr[j] > arr[j + 1])
            {
                swap(arr[j], arr[j + 1]);
                cnt[0][1] += 3; //swap
                isFinish = false;
            }
        }
    }
}
static void selectSort(int arr[], int size)
{
    cnt[1][0] = cnt[1][1] = 0;
    for (int i = 0; i < size - 1; ++i)
    {
        //select min
        int minIndex = i;
        for (int j = i + 1; j < size; ++j)
        {
            cnt[1][0]++; //cmp
            if (arr[j] < arr[minIndex])
            {
                minIndex = j;
            }
        }
        if (minIndex != i)
        {
            cnt[1][1] += 3; //swap
            swap(arr[minIndex], arr[i]);
        }
    }
}

static void insertSort(int arr[], int size)
{
    cnt[2][0] = cnt[2][1] = 0;
    for (size_t i = 1; i < size; i++)
    {
        cnt[2][1]++; //move
        int tmp = arr[i], j;
        for (j = i - 1; j >= 0 && arr[j] > tmp; j--)
        {
            cnt[2][0]++; //cmp
            cnt[2][1]++; //move
            arr[j + 1] = arr[j];
        }
        cnt[2][1]++; //move
        arr[j + 1] = tmp;
    }
}

static void biInsSort(int arr[], int size){
    cnt[7][0] = 0, cnt[7][1] = 0;
    // 遍历要插入的值
    for (int i = 1; i < size; ++i) {
        cnt[7][1] ++;   // move
        int tmp = arr[i];
        // bs 找到插入位置
        int l = 0, r = i - 1, mid;
        while (l <= r){
            mid = l + (r - l) / 2;
            cnt[7][0]++; // cmp
            if (arr[mid] > tmp){
                r = mid - 1;
            }else{
                l = mid + 1;
            }
        }
        // 移动并插入
        for (int j = i - 1; j >= l; --j) {
            cnt[7][1]++; // move
            arr[j + 1] = arr[j];
        }
        cnt[7][1]++; // move
        arr[l] = tmp;
    }
}

 static void bi2InsSort(int arr[], int size){
    cnt[8][0] = 0, cnt[8][1] = 0;
    int* tmp = new int[size];
    tmp[0] = arr[0];
    cnt[8][1]++; // move
    int minIndex = 0, maxIndex = 0; // 记录最大与最小元素的位置
    // 插入每个点
    for (int i = 1; i < size; ++i) {
        int toIns = arr[i];
        cnt[8][1]++; // move
        cnt[8][0]++; // cmp
        if (toIns <= tmp[0]){
            cnt[8][0]++; // cmp
            if (toIns <= tmp[minIndex]){
                cnt[8][1]++; // move
                tmp[minIndex + 1] = toIns;
            } else{
                // 找到正确位置
                int mid, low = 1, high = minIndex - 1;
                while (low <= high){
                    mid = low + (high - low) / 2;
                    cnt[8][0]++; // cmp
                    if (tmp[mid] > toIns){
                        low = mid + 1;
                    } else{
                        high = mid - 1;
                    }
                }
                // 插入
                for (int j = minIndex; j >= low; --j) {
                    cnt[8][1]++; // move
                    tmp[j + 1] = tmp[j];
                }
                cnt[8][1]++; // move
                tmp[low] = toIns;
            }
            minIndex++;
        } else{
            cnt[8][0]++; // cmp
            if (toIns >= tmp[maxIndex]){
                cnt[8][1]++; // move
                tmp[(maxIndex - 1 + size) % size] = toIns;
            } else{
                // 找到正确位置并插入
                int mid, low = maxIndex + 1, high = size - 1;
                while (low <= high){
                    mid = low + (high - low) / 2;
                    cnt[8][0]++; // cmp
                    if (tmp[mid] > toIns){
                        low = mid + 1;
                    } else{
                        high = mid - 1;
                    }
                }
                // 插入
                for (int j = maxIndex; j <= high; ++j) {
                    cnt[8][1]++; // move
                    tmp[j - 1] = tmp[j];
                }
                cnt[8][1]++; // move
                tmp[high] = toIns;
            }
            maxIndex = (maxIndex - 1 + size) % size;
        }
    }
    // 存回arr
    int arrIndex = 0, tmpIndex = minIndex;
    while (arrIndex < size){
        cnt[8][1]++; // move
        arr[arrIndex++] = tmp[tmpIndex];
        tmpIndex = (tmpIndex - 1 + size) % size;
    }
    delete[] tmp;
 }

// complex

static void quickSort0(int arr[], int first, int last)
{
    cnt[3][1]++; // move
    int l = first, r = last, key = arr[first];
    while (l < r)
    {
        while (l < r && arr[r] >= key)
        {
            cnt[3][0]++; // cmp
            r--;
        }
        cnt[3][1]++; // move
        arr[l] = arr[r];
        while (l < r && arr[l] <= key)
        {
            cnt[3][0]++; // cmp
            l++;
        }
        cnt[3][1]++; // move
        arr[r] = arr[l];
    }
    cnt[3][1]++; // move
    arr[l] = key;
    if (first < l - 1)
    {
        quickSort0(arr, first, l - 1);
    }
    if (r + 1 < last)
    {
        quickSort0(arr, r + 1, last);
    }
}
static void quickSort(int arr[], int size)
{
    cnt[3][0] = 0, cnt[3][1] = 0;
    quickSort0(arr, 0, size - 1);
}

static void adjustHeap(int arr[], int from, int to)
{
    cnt[4][1]++; // move
    int node = from, child = 2 * from, val = arr[from];
    // 当未到达叶子时，循环
    while (child <= to){
        // 获得更大的孩子
        cnt[4][0]++; // cmp
        if (child + 1 <= to && arr[child + 1] > arr[child]) {
            child++;
        }
        // 已经满足大顶堆
        cnt[4][0]++; // cmp
        if (arr[child] <= val) {
            break;
        }
        cnt[4][1]++; // move
        arr[node] = arr[child];
        // 更新
        node = child;
        child *= 2;
    }
    cnt[4][1]++; // move
    arr[node] = val;
}

static void heapSort(int arr[], int size)
{
    cnt[4][0] = 0, cnt[4][1] = 0;
    int *newArr = new int[size + 1];
    for (int i = 1; i <= size; i++)
    {
        newArr[i] = arr[i - 1];
    }
    for (size_t i = size / 2; i >= 1; i--)
    {
        adjustHeap(newArr, i, size);
    }
    for(int i = size; i >= 2; i--){
        cnt[4][1] += 3; //swap
        swap(newArr[i], newArr[1]);
        adjustHeap(newArr, 1, i - 1);
    }
    for (int i = 1; i <= size; i++)
    {
        arr[i - 1] = newArr[i];
    }
    delete[] newArr;
}

static void shellSort(int arr[], int size)
{
    cnt[5][0] = 0, cnt[5][1] = 0;
    int inc = size;
    do
    {
        // 更新间隔
        inc = inc / 3 + 1;
        // traverse number to be inserted
        for (int index = inc; index < size; ++index)
        {
            cnt[5][0]++; //cmp
            // 需要移动位置
            if (arr[index] < arr[index - inc])
            {
                cnt[5][1]++; //move
                int num = arr[index], prior;
                // 插入合适的位置
                for (prior = index - inc; prior >= 0 && arr[prior] > num; prior -= inc)
                {
                    cnt[5][0]++; //cmp
                    cnt[5][1]++; //move
                    arr[prior + inc] = arr[prior];
                }
                cnt[5][1]++; //move
                arr[prior + inc] = num;
            }
        }
    } while (inc > 1);
}

// 将 aArray 的 两个子序列 merge 到 bArray
static void merge(int aArr[], int bArr[], int head_1, int head_2, int tail_2){
    int tail_1 = head_2 - 1, index_B = head_1;
    // merge 至 其中一个 array 用完
    while (head_1 <= tail_1 && head_2 <= tail_2){
        cnt[6][0]++; // cmp
        cnt[6][1]++; // move
        if (aArr[head_1] < aArr[head_2]){
            bArr[index_B++] = aArr[head_1++];
        } else{
            bArr[index_B++] = aArr[head_2++];
        }
    }
    while (head_1 <= tail_1){
        cnt[6][1]++; // move
        bArr[index_B++] = aArr[head_1++];
    }
    while (head_2 <= tail_2){
        cnt[6][1]++; // move
        bArr[index_B++] = aArr[head_2++];
    }
}

// merge 每一对 长度为subLen的子序列 到 另一个array
static void mergeSwap(int* from, int * to, int size, int subLen){
    int pair = size / (2 * subLen);
    for (int i = 0; i < pair; ++i) {
        merge(from, to, i * 2 * subLen, i * 2 * subLen + subLen, i * 2 * subLen + subLen * 2 - 1);
    }
    int base = pair * 2 * subLen;
    if (base < size){
        if(size - base <= subLen){         // 剩余一个子序列
            for (int i = base; i < size; ++i) {
                cnt[6][1]++; // move
                to[i] = from[i];
            }
        } else{         // 剩余2个子序列
            merge(from, to, base, base + subLen, size - 1);
        }
    }
}

static void mergeSort(int arr[], int size)
{
    cnt[6][0] = 0, cnt[6][1] = 0;
    int * tmp = new int[size];
    int len = 1;
    while (len < size){
        mergeSwap(arr, tmp, size, len);
        len *= 2;
        mergeSwap(tmp, arr, size, len);
        len *= 2;
    }
    delete [] tmp;
}

// 对9种常用的内部排序算法进行比较
int main()
{
    vector<void (*)(int *, int)> sortFunc = {bubbleSort, selectSort, insertSort,
                                             quickSort, heapSort, shellSort, mergeSort, biInsSort, bi2InsSort};
    // 比较 比较次数和关键字移动次数
    cout << "\nbubble\tselect\tinsert\tquick\theap\tshell\tmerge\tbiIns\tbi2Ins" << endl;
    int arr[ARRSIZE]; // 存待排序数组
    // 5组不同的输入数据作比较
    for (int i = 0; i < 5; i++)
    {
        cout << "\ntest " << i << endl ;
        // 数据用伪随机数产生
        for (int j = 0; j < ARRSIZE; j++)
        {
            arr[j] = rand() % 200;
        }
        // sort
        for (auto i : sortFunc)
        {
            i(getCopy(arr, ARRSIZE), ARRSIZE);
        }
        for (int i = 0; i < 2; ++i)
        {
            for (int j = 0; j < 9; ++j)
            {
                cout << cnt[j][i] << '\t';
            }
            cout << endl;
        }
     }
}