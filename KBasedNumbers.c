#include <iostream.h>
int main ()
{
	unsigned long i, N,K, z, dz, a, b;
	unsigned long index;
		cin>>N>>K;
	
	z=K-1;
	dz=(K-1)*z;

	for (i=2;i<N;++i)
	{
		a=z;
		b=dz;
		z=b;
		dz=(K-1)*(b+a);		
	}
	index=z+dz;
	cout<<index<<"\n";
	return 0;

}


