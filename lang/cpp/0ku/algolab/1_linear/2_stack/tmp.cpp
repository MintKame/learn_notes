#include <iostream>
using Type = char;
class Node
{
private:
    Type data;

public:
    Node *next;
    //getter 函数
    Type getData() const;

    //构造一个新的节点,设置数据并置空后继指针
    Node(Type data_);

    //默认构造一个节点。用于创造头节点
    Node();
};

class Stack
{
private:
    Node *head;
    int size;

public:
    //构造一个空栈，初始化头节点及栈的大小
    Stack();

    //析构栈，删除每一个节点（包含head）
    ~Stack();

    //获取大小
    int getSize() const;

    //新节点入栈
    void push(Node *newNode);
    void push(Type data);

    //栈顶节点出栈(删除)，并返回节点的数据
    Type pop();

    //获取栈顶节点的数据
    Type top() const;
};

Node::Node()
{
    next = nullptr;
}

Node::Node(Type data_)
{
    data = data_;
    next = nullptr;
}

Type Node::getData() const
{
    return data;
}

Stack::Stack()
{
    //初始化头节点及栈的大小
    head = new Node();
    size = 0;
}
Stack::~Stack()
{
    Node *ptr = head;
    //删除每一个节点（包含head）
    for (int i = 0; i < size; i++)
    {
        Node *tmp = ptr;
        ptr = ptr->next;
        delete tmp;
    }
}

int Stack::getSize() const
{
    return size;
}

void Stack::push(Node *newNode)
{
    newNode->next = head->next;
    head->next = newNode;
    size++;
}

void Stack::push(Type data)
{
    push(new Node(data));
}

Type Stack::pop()
{
    //空栈抛出异常
    if (size == 0)
        throw new logic_error("stack为空，无法pop");
    Node *tmp = head->next;
    Type ret = tmp->getData();
    head->next = tmp->next;
    delete tmp;
    size--;
    return ret;
}
Type Stack::top() const
{
    //空栈抛出异常
    if (size == 0)
        throw new logic_error("stack为空，无法获取栈顶");
    return head->next->getData();
}
int isMatched(char *expr, int size)
{
    //创造一个栈
    Stack *stack = new Stack();
    //遍历每读入一个括号
    for (int i = 0; i < size; i++)
    {
        //若是左括号，则压入栈中
        if (expr[i] == '[' || expr[i] == '(')
        {
            stack->push(expr[i]);
        }
        //若是右括号，检查是否合法
        else
        {
            //栈空则不合法
            if (stack->getSize() == 0)
            {
                return 0;
            }
            //获取当前栈顶
            char top = stack->top();
            //与当前栈顶的左括号匹配，则将当前栈顶的左括号pop
            if ((top == '[' && expr[i] == ']') || (top == '(' && expr[i] == ')'))
            {
                stack->pop();
            }
            //与当前栈顶的左括号不匹配，则不合法。
            else
            {
                return 0;
            }
        }
    }
    //有未配对的括号，非法
    if (stack->getSize() != 0)
    {
        return 0;
    }
    //删除栈
    delete stack;
    return 1;
}

void printResult(char *expr, int size)
{
    if (isMatched((char *)(expr), size))
    {
        cout << expr << " 匹配" << endl;
    }
    else
    {
        cout << expr << " 此串括号匹配不合法" << endl;
    }
}

int main()
{
    printResult("", 0);
    printResult("[", 1);
    printResult(")", 1);
    printResult("([]())", 6);
    printResult("[()]", 4);
    printResult("[(]", 3);
    return 0;
}