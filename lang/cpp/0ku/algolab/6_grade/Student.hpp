
/** Student.hpp */
#ifndef STU_YZ
#define STU_YZ
#include <iostream>
#include <string>
using namespace std;

class Student
{
private:
    // 每个学生的信息由学号、姓名以及各科成绩组成。
    int id;
    string name;
    int *score;
    int sum;

public:
    Student() = default;

    Student(int id_, string name_, int *s, int size)
    {
        id = id_;
        name = name_;
        score = new int[size];
        sum = 0;
        for (size_t i = 0; i < size; i++)
        {
            score[i] = s[i];
            sum += s[i];
        }
    }

    void print(int size)
    {
        cout << id << '\t' << name << '\t';
        for (size_t i = 0; i < size; i++)
        {
            cout << score[i] << '\t';
        }
        cout << sum << endl;
    }

    int compare(Student student)
    {
        return sum - student.sum;
    }
};

class Table
{
private:
    Student *student;
    int studentNum, subjectNum;

    /**
     * @description: 根据总分排序 
     * @param first 第一个元素的下标
     * @param last 最后一个元素的下标
     */
    void quickSort0(int first, int last)
    {
        Student key = student[first];
        int l = first, r = last;
        while (l < r)
        {
            while (l < r && student[r].compare(key) <= 0)
            {
                r--;
            }
            student[l] = student[r];
            while (l < r && student[l].compare(key) >= 0)
            {
                l++;
            }
            student[r] = student[l];
        }
        student[l] = key;
        if (first < l - 1)
        {
            quickSort0(first, l - 1);
        }
        if (r + 1 < last)
        {
            quickSort0(r + 1, last);
        }
    }

public:
    // 初始化表格
    Table(int st, int su)
    {
        studentNum = st;
        subjectNum = su;
        student = new Student[st]{};
        int id, score[su];
        string name;
        for (size_t i = 0; i < studentNum; i++)
        {
            cin >> id >> name;
            for (size_t j = 0; j < subjectNum; j++)
            {
                cin >> score[j];
            }
            student[i] = Student(id, name, score, subjectNum);
        }
    }

    ~Table()
    {
        delete[] student;
    }

    void quickSort()
    {
        quickSort0(0, studentNum - 1);
    }

    /* 按名次打印出每个学生的学号、姓名、总分以及各科成绩。 */
    void printTable()
    {
        int cnt = 1;
        for (int i = 0; i < studentNum; i++)
        {
            // 分数相同的为同一名次
            if (i != 0 && student[i].compare(student[i - 1]))
            {
                cnt = i + 1;
            }
            cout << cnt << '\t';
            student[i].print(subjectNum);
        }
    }
};
#endif
/*
5 2
101 a   100 88
102 b   95 95
103 c   60 65
104 d   100 90
105 e   72 80
*/