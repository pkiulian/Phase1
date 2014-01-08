#include <iostream.h>
int modul (int x)
{
	if (x<0) return -x;
	return x;
}
int main ()
{
	int N;
	cin>>N;
	if (N>0)
	{
		cout<<(N*(N+1))/2<<"\n";
	}
	if(N<0)
	{
		cout<<1-((modul(N))*(modul(N)+1))/2<<"\n";
	}
	if (N==0)
	{
		cout<<1<<"\n";
	}
	return 0;
}