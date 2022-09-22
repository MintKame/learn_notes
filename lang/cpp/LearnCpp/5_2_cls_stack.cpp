//! generalize int
class StackOfIntegers
{
private:
    int elements[100];
    int size{0};

public:
    int push(int value);
    int pop();
    int getSize();
    StackOfIntegers();
};

StackOfIntegers::StackOfIntegers()
{
    size = 0;
    for (int &i : elements)
    {
        i = 0;
    }
}

int StackOfIntegers::getSize()
{
    return size;
}

int StackOfIntegers::pop()
{
    int temp = elements[size - 1];
    elements[size - 1] = 0;
    size--;
    return temp;
}

int StackOfIntegers::push(int value)
{
    elements[size] = value;
    size++;
    return value;
}