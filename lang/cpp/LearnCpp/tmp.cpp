
#include <iostream>
class C
{
    static int num;

public:
    C() { num++; }
    C(int x) : C() {}
    ~C() { num--; }
    auto static count()
    {
        return num;
    }
};
int C::num{0};
int main()
{
    C c1{2};
    std::cout << C::count() << std::endl;
    new C();
    auto p{new C()};
    std::cout << C::count() << std::endl;
    C c2;
    delete p;
    std::cout << C::count() << std::endl;
}