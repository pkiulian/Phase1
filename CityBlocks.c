#include<iostream>
#include<string>
#include<stack>
#include<vector>

using namespace std;

int gcd(int a, int b){
	int c;
	while ( a != 0 ) {
	     c = a; a = b%a;  b = c;
	}
	return b;
}

int main(){
	int result = 0;
	int gcdresult = 0;
	int a, b;
	cin>>a>>b;	
	a--; b--;
	gcdresult = gcd(a,b);
	a = a/gcdresult;
	b = b/gcdresult;
	result = ((a+b)-1)*gcdresult;
	cout<<result;
	return result;
}
