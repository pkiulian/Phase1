#include <stdio.h>
#include <string.h>
	long l=0;
long fact1(long nb, long k, long l)
{
	long rez=1;
		while ((nb-l*k)>=k)
		{
		rez = rez * (nb-(l*k));
		l++;	
		}
	return rez;

}
long fact2(long nb, long k, long l)
{
long rez=1;

	while ((nb-l*k) >= (nb % k))
	{
		rez=rez*(nb-l*k);
		l++;
		
	}
	return rez;
}


void factorial(long nb, long k) 
{


	if ( (nb % k)!=0)
	{
		printf("%ld", fact2(nb, k, l));
	}
	if ( (nb % k)==0)
	{
		printf("%ld", fact1(nb, k, l));
	}
}
int main()
{

	long j, n, i=0, nrexclamatie, ind;
	long l=0;
	char c, v[1000];
	char ss[100];

	scanf("%ld %s", &n, &ss);

//	printf("%ld", strlen(ss));
//	printf("\n");
//	printf("numarul n este : %d", n);
//	printf("\n");
	nrexclamatie=strlen(ss);
//	printf("numarul de semne de ! este :"); 
//	printf("%ld", nrexclamatie);
//	printf("\n");
//	printf("rezultatul este :");
	factorial(n, nrexclamatie);
	printf("\n");
	return 0;
}
