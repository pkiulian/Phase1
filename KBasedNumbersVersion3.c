#include <iostream.h>
unsigned long index[10000], y,  transport, m, i, j, a[10000], ab[10000], N,K, b[10000], kk,ml, z[10000], dz1[10000], indexz;
void afisare(unsigned long nr, unsigned long v5[10000])
{
	for (j=nr;j>=1; j--)
	{
		cout<<v5[j];
	}
}
void sumaa_vector(unsigned long &nr, unsigned long v1[100000], unsigned long v2[100000], unsigned long suma[10000])
{
	for (j=1;j<=nr+1;j++)
	{
		suma[j]=0;
	}
	for (j=1;j<=nr;j++)
	{
		transport = (suma[j]+v1[j]+v2[j])/10;
		ml=(suma[j]+v1[j]+v2[j])%10;
		suma[j]=ml;
		if(transport!=0)
		{
			suma[j+1]=suma[j+1]+transport;
			if (j==nr)
			{
			nr++;
			}
		}
	}
}



void scalar(unsigned long nn,unsigned long &limit, unsigned long v1[100000], unsigned long rez[10000])
{
	for (j=1;j<=limit+1;j++)
	{
		rez[j]=0;
	}
	for (j=1;j<=limit;j++)
	{
		transport = (rez[j]+nn*v1[j])/10;
		ml=(rez[j]+nn*v1[j])%10;
		rez[j]=ml;
		if(transport!=0)
		{
				rez[j+1]=rez[j+1]+transport;
				if (j==limit)
				{
				limit++;
				}
		}
	}
	
}



int main ()
{
cin>>N>>K;
indexz=1; 
z[indexz]=K-1;
ml=z[indexz]*(K-1);
kk=0;
while (ml!=0)
{
	kk++;
	dz1[kk]=ml%10;
	ml=ml/10;
}
for (i=2; i<N; ++i)
{
	for (j=1;j<=indexz;j++)
	{
		a[j]=z[j];
	}
	m=indexz;
	for (m=indexz+1; m<=kk; m++)
	{
		a[m]=0;
	}
	for (j=1;j<=kk;j++)
	{
		b[j]=dz1[j];
	}
	indexz=kk;
	for (j=1;j<=indexz;j++)
	{
		z[j]=b[j];
	}
	sumaa_vector(kk, a, b, ab);
	y=K-1;
	scalar(y, kk, ab, dz1);
}
sumaa_vector(kk, z, dz1, index);
afisare(kk,index);


return 0;
}
