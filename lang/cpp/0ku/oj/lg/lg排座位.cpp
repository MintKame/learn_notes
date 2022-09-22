#include<stdio.h>
int main()
{
	int i,j,w;
	int m,n,k,l,d,temp;
	int a[2000]={},b[2000]={};
	int x[2000]={},y[2000]={},p[2000]={},q[2000]={};
	int L[1000]={},K[1000]={};
//	input
	scanf("%d %d %d %d %d",&m,&n,&k,&l,&d);
	for(i=0;i<d;i++)
	{
		scanf("%d %d %d %d",&x[i],&y[i],&p[i],&q[i]);
		if(x[i]==p[i]) 
		{
			if(y[i]<q[i]) b[y[i]]++;
			else b[q[i]]++;
		 } 
		 else{
		 	if(x[i]<p[i]) a[x[i]]++;
			else a[p[i]]++;
		 }
	}
// 获取a中前k大与b中前l大的index 
	for(i=0;i<k;i++)
	{
		w=0;
		temp=a[0];
		for(j=0;j<m;j++)
		{
			if(temp<a[j])
			{
				w=j;
				temp=a[j];
			}			
		}
		K[i]=w;	
		a[w]=0;
	}
	for(i=0;i<l;i++)
	{
		w=0;
		temp=b[0];
		for(j=0;j<n;j++)
		{
			if(temp<b[j])
			{
				w=j;
				temp=b[j];
			}			
		}
		L[i]=w;	
		b[w]=0;
	}
	for(i=0;i<k-1;i++)
	{
		for(j=0;j<k-i-1;j++)
		{
			if(K[j]>K[j+1])
			{
				temp=K[j];
				K[j]=K[j+1];
				K[j+1]=temp;
			}
		}
	}	
	for(i=0;i<l-1;i++)
	{
		for(j=0;j<l-i-1;j++)
		{
			if(L[j]>L[j+1])
			{
				temp=L[j];
				L[j]=L[j+1];
				L[j+1]=temp;
			}
		}
	}
//	output
	for(i=0;i<k-1;i++)
	{
		printf("%d ",K[i]);
	}
	printf("%d",K[i]);
	printf("\n");
	for(j=0;j<l-1;j++)
	{
		printf("%d ",L[j]);
	}
	printf("%d",L[j]);
	return 0;
}
