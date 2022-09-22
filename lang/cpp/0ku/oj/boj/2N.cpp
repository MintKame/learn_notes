#include<stdio.h>
int main()
{
//	先全部转码，输出时判断是否有连续
	int n;
	scanf("%d",&n);
	char s[10][25]={};
	int r[10][25]={}; 
	for(int i=0;i<n;i++)
	scanf("%s",s[i]);
	for(int i=0;i<n;i++)
	{
		for(int j=0;s[i][j]!=0;j++)
		{
			//switch格式：switch后面为{}，无：；case后面直接是情况+：；要有break 
			switch(s[i][j])
			{
				case 'B':
			case 'F':
			case 'P':
			case 'V':
			r[i][j]=1;
			break;
			case 'C':
			case 'G':
			case 'J':
			case 'K':
			case 'Q':
			case 'S':
			case 'X':
			case 'Z':
			r[i][j]=2;
			break;
			case 'D':
			case 'T':
			r[i][j]=3;
			break;	
			case 'L':
			r[i][j]=4;
			break;
			case 'M':
			case 'N':
			r[i][j]=5;
			break;
			case 'R':
			r[i][j]=6;
			break;
			default:
			break;
			}
		}
	}
	for(int i=0;i<n;i++)
	{
		for(int j=0;s[i][j]!=0;j++)
		{
			if((r[i][j]!=r[i][j+1])&&(r[i][j]!=0))
			printf("%d",r[i][j]);
		}
		putchar('\n');
	}
	return 0;
 } 
// X公司最近研究出了一种新的编码方式，这种编码是将一串大写字母转化为数字。下面是每个字母所代表的数字。
//B, F, P, V 代表 1
//C, G, J, K, Q, S, X, Z 代表 2。
//D ， T 代表 3
//L 代表 4
//M ， N 代表 5
//R 代表 6。
//另外字母A, E, I, O, U, H, W,Y不代表任何数字。你需要将每个字母转化为所代表的数字，但注意，如果连续几个字母都代表同一个数字，那么你只需要转化成一个数字就可以。比如PF,P和F都代表1，所以你只需要输出一个1，而不是两个1。不代表数字的字母不用转化
//输入格式
//第一行为整数T(0<T<10)代表T行测试数据，后边是T行，每行为一个只含大写字母的字符串，串长不超过20。
//输出格式
//为T行，每行对应输入的T行测试数据，为该行测试数据的字符串转化后的数字编码，如果没有任何编码，则输出一个空行。
//
//输入样例
//3
//KHAWN
//PFISTER
//BOBBY
//输出样例
//25
//1236
//11
