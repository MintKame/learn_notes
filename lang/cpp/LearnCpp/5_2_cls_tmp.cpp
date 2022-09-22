#include <vector>
template <typename T = int> //! header: before cls declare
class Stack
{
private:
    T elements[100]; //! generalize data type
    int size{0};

public:
    T push(T value); //! generalize func: para, ret, local data
    T pop();
    int getSize();
    Stack();
};

template <typename T> //! header: each func
Stack<T>::Stack()     //! class name, add<T>
{
    size = 0;
    for (auto &i : elements)
    {
        i = 0;
    }
}

template <typename T>
int Stack<T>::getSize()
{
    return size;
}

template <typename T>
T Stack<T>::pop()
{
    T temp = elements[size - 1];
    elements[size - 1] = 0;
    size--;
    return temp;
}

template <typename T>
T Stack<T>::push(T value)
{
    elements[size] = value;
    size++;
    return value;
}

//! instantiate: same as func
template class Stack<int>;
//! explict: declare the instance cls

int main()
{
    //! implict: when create an obj of instance cls
    //          compiler will auto create the instance cls, then cteate the obj
    Stack<int> int_stack;
    Stack<> stack; // because of default type
    // in cpp17, typename can deduct by ctor's para
    std::vector<int> iv1{};
    std::vector iv2{1, 2};
}