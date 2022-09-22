#include <iostream>
#include <array>
//! generalize para's var / type

//! generalize para's type
template <typename T> // template prefix, "typename" can be replace by "class"
// where can use tmpType? (3 place)
T sum1(T t1, T t2) // 1,2: ret, para
{
    T ret = t1 + t2; // 3: local var
    return ret;
}

template <typename T, typename S>
auto sum2(T t, S s) // auto: avoid force cast
{
    return t + s;
}

//! generalize para's var
// step 1: write a non-generic
/*
int sum(std::array<int, 5> arr)
{
    int ret = 0;
    for (size_t i = 0; i < 5; i++)
    {
        ret += arr[i];
    }
    return ret;
}
*/
// step 2: test func
// step 3: trans to generic
template <typename T, size_t N> // N also can be obj
T sum(std::array<T, N> arr)
{
    T ret = 0;
    for (size_t i = 0; i < N; i++)
    {
        ret += arr[i];
    }
    return ret;
}
//! instantiate: explict / implict
//! explict: declare func (3 form)
template int sum1<int>(int, int); // <> after the name
template int sum1<>(int, int);
template int sum1(int, int);

/* compiler generate code:
int sum1(int x, int y)
{
    int ret = t1 + t2; // 3: local var
    return ret;
}
*/

int main(int argc, char const *argv[])
{
    //! implict: call func (2 ways, 3 form)
    sum1<int>(1, 2);
    sum1<>(1, 2);
    sum1(1, 2);
    int (*ptr)(int, int) = sum1; // func ptr

    std::array<int, 5> arr{0, 1, 2, 3, 4};
    std::cout << sum(arr) << std::endl;
    return 0;
}
