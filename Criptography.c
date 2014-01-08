#include<iostream>
#include<string>
#include<sstream>
#include<iomanip>
#include<stdlib.h>
#include<math.h>
#include<vector>
#include<queue>
#include <set>
using namespace std;
 bool prime(int n){
	for (int i=2;i<sqrt((double)n)+1;i++){
	  if (n%i==0) return false;
	}
	return true;
    }

int main(){
    int k = 0;
    string input, line;
    getline(cin, input);
    stringstream ss(input);    
    ss>>k;
    if (k>0){
	vector<int> numbers;
	int sizeinput = 0, maxvalue=0;
	while(getline(cin, line) && sizeinput<k){
	  stringstream ss1(line);
	  int value;
	  ss1 >> value;
	  if (value>maxvalue)
	     maxvalue=value;
	  numbers.push_back(value);
	  sizeinput++;
	  if (sizeinput==k) break;
	}	
	vector<int> primes;	//collect the primes	
	for (int i=2;i<(unsigned int)-1;i++){		
	  if (prime(i)==true && i>2 && i%2!=0) {
	      if (primes.size()<maxvalue){
		primes.push_back(i);
	      } else if (primes.size()==maxvalue){
		  break;
	      }
	  }else if (i==2){
	      primes.push_back(i);
	  }
	 }
	
	for (int i=0;i<numbers.size();i++){
	  if (numbers[i]>2){
	    cout<<primes[numbers[i]-1]<<"\n";
	  }else if (numbers[i]==2) {cout<<3<<"\n";}
	  else if (numbers[i]==1) {cout<<2<<"\n";}
	}
    }
  
}
 