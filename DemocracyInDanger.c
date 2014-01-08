#include <iostream.h>
int main ()
{
	int nr = 0, aux;// dimensiunea vectorului pe care il folosesc...        
    int i; 
    int suma=0; //rezultatul
	
	cin>>nr;
	int v[10001];
	for (i=0;i<nr;i++)
	{
		cin>>v[i];           
	}    
	for (i=0;i<nr;i++)
	{
		int poz = i;
        for (int j=i+1;j<nr;j++) 
        {
			if (v[poz]>v[j]) poz = j;
            aux = v[poz]; v[poz] = v[i];
            v[i] = aux;
        }
	}
	nr=nr/2+1;
    int n=0;        
    for (i=0;i<nr;i++)
    {
		n=v[i];         
        suma=suma+((n/2)+1);                       
	}
	cout<<suma<<"\n";   
	return 0;
}