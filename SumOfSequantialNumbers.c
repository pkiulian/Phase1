#include<iostream>
#include<cmath>
	using namespace std;
	int sum (int a,int b) 
	{
		return (!((b-a+1)%2))?(b-a+1)/2*(a+b):(b-a)/2*(a+b-1)+b; // formula de suma
	}
	int main () 
	{ 
		int n;
		cin>>n;
		int a_real,p_real;
		int p=(int)(sqrt((double)(n*2)));
		do 
		{
			int a=(((n*2)/p-(p-1))/2);
			if (a&&sum(a,a+p-1)==n) 
			{
				a_real=a;p_real=p;break;
			}
			p--;
		}
		while (p);
	cout<<a_real<<" "<<p_real<<endl; 
	return 0;
}