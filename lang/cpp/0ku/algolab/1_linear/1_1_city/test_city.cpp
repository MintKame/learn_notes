/*
 * @Author: 闫昭
 * @Date: 2020-10-08 18:51:37
 * @LastEditTime: 2020-10-10 15:45:45
 * @LastEditors: Please set LastEditors
 * @Description: In User Settings Edit
 * @FilePath: /cpp/algo/lab/1_linear/1_1_city/test_city.cpp
 */
#include "city.h"

int main()
{
    List *l = new List();
    
    //测试insert
    for (int i = 0; i < 5; i++)
    {
        l->insert(rand() % 20, rand() % 20, "c" + to_string(i));
    }
    l->insert(City(1, 1, "lastCity"));
    l->show();
    
    //测试positionOf：c2， 不存在的城市名
    cout << "positionOf(c2): " << l->positionOf(string("c2"))->toString() << endl;
    Position* tmp_pos = l->positionOf(string("hello"));
    if(tmp_pos == nullptr)
        cout << "positionOf(hello): hello not exist" << endl;
    else
        cout << "positionOf(hello):" << tmp_pos->toString() <<endl;    
    cout << endl;
    
    //测试deleteByName：删除第一个，最后一个, 不存在的城市名
    cout << "delete c0, lastCity, hello:" <<endl;
    l->deleteByName(string("c0"));
    l->deleteByName(string("lastCity"));
    int tmp_ret = l->deleteByName(string("hello"));
    if(tmp_ret != 0)
        cout << "deleteByName(hello): hello not exist" << endl;
    l->show();

    List *newList_1 = l->distanceToPositionLessEqual(15, 15, 3);  
    cout << "distance to (15, 15) <= 3:" <<endl;
    newList_1 -> show();
    
    List *newList_2 = l->distanceToPositionLessEqual(1, 9, 0);
    cout << "distance to (1, 9) <= 0:" <<endl;
    newList_2 -> show();
    return 0;
}
