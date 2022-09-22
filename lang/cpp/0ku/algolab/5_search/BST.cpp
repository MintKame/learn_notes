/*
 * @Author: 闫昭
 * @Date: 1970-01-01 08:00:00
 * @LastEditTime: 2020-11-30 16:08:37
 * @LastEditors: Please set LastEditors
 * @Description: In User Settings Edit
 * @FilePath: /cpp/algolab/5_search/BST.cpp
 */
/** BST.cpp */
#include "BST.h"
#include <iostream>
using namespace std;
BST::BST(int val)
{
    this->val = val;
}
int BST::search(BST *root, int target)
{
    if (root == nullptr)
    {
        return -1;
    }
    int cnt;
    for (cnt = 1;; cnt++)
    {
        if (target < root->val)
        {
            if (root->left != nullptr)
            {
                root = root->left;
            }
            else //not found
            {
                return -1;
            }
        }
        else if (target > root->val)
        {
            if (root->right != nullptr)
            {
                root = root->right;
            }
            else //not found
            {
                return -1;
            }
        }
        else
        {
            return cnt;
        }
    }
}

BST *BST::getParent(BST *node, int target)
{
    BST *parent = nullptr;
    while (node != nullptr && node->val != target)
    {
        parent = node;
        if (node->val > target)
        {
            node = node->left;
        }
        else
        {
            node = node->right;
        }
    }
    return parent;
}

void BST::insert(BST *root, int newVal)
{
    BST *prior = getParent(root, newVal);
    //err
    if (prior == nullptr)
    {
        return;
    }
    else
    {
        //insert to right
        if (prior->right == nullptr && prior->val < newVal)
        {
            prior->right = new BST(newVal);
        }
        //insert to left
        else if (prior->left == nullptr && prior->val > newVal)
        {
            prior->left = new BST(newVal);
        }
    }
}

void BST::remove(BST *root, int target)
{
    //set parent & toDel
    BST *parent = getParent(root, target);
    BST *toDel = nullptr;
    bool isLeft;
    if (parent == nullptr)
    {
        //can not find parent
        return;
    }
    else if (parent->left != nullptr && parent->left->val == target)
    {
        //parent's left
        toDel = parent->left;
        isLeft = true;
    }
    else if (parent->right != nullptr && parent->right->val == target)
    {
        //parent's right
        toDel = parent->right;
        isLeft = false;
    }
    else
    {
        //already exist
        return;
    }
    //only have 0/1 child
    if (toDel->left == nullptr)
    {
        if (isLeft)
            parent->left = toDel->right;
        else
            parent->right = toDel->right;
        return;
    }
    else if (toDel->right == nullptr)
    {
        if (isLeft)
            parent->left = toDel->left;
        else
            parent->right = toDel->left;
        return;
    }
    //have 2 child
    //find inorder's prior & parent of prior
    BST *p = toDel->left, *pp = toDel;
    while (p->right != nullptr)
    {
        pp = p;
        p = p->right;
    }
    //delete
    if (toDel == pp)
    {
        //toDel's prior is its left
        p->right = toDel->right;
        if (isLeft)
        {
            parent->left = p;
        }
        else
        {
            parent->right = p;
        }
        delete toDel;
    }
    else
    {
        pp->right = p->left;
        toDel->val = p->val;
        delete p;
    }
}

void BST::inOrder(BST *root)
{
    if (root == nullptr)
    {
        return;
    }
    inOrder(root->left);
    cout << root->val << ' ';
    inOrder(root->right);
}
