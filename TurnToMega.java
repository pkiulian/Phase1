
#include <iostream>
#include <vector>
#include <list>
#include <map>
#include <set>
#include <deque>
#include <stack>
#include <bitset>
#include <algorithm>
#include <functional>
#include <numeric>
#include <utility>
#include <sstream>
#include <fstream>
#include <iomanip>
#include <cstdio>
#include <climits>
#include <cmath>
#include <cstdlib>
#include <ctime>

using namespace std;

int main(){
	int k,n;
	cin>>k>>n;	
	vector<int> nr_cars;
	for (int i=0;i<n;i++){
		int a;
		cin>>a;
		nr_cars.push_back(a);
	}
	vector<int> carrier;
	//int oldcarrier = 0;
	if (nr_cars.at(0)-k>0 ){
		carrier.push_back(nr_cars.at(0)-k);
	}
	else {
		carrier.push_back(0);
	}
	
	for (int i=1;i<n;i++){		
		if ((nr_cars.at(i)+carrier.at(i-1))-k<=0){
			carrier.push_back(0);			
		}else if ((nr_cars.at(i)+carrier.at(i-1))-k>0 ){						
			carrier.push_back((nr_cars.at(i)+carrier.at(i-1))-k);
		}
	}
	/*for (int i=0;i<carrier.size();i++){
		cout<<carrier.at(i)<<" ";
	}
	/*
	int A = n*k;
	int B =0; 
	for (int i=0;i<n;i++){
		B+=nr_cars.at(i);
	}
	
	if (B-A<=0){
		cout<<0<<endl;
	}else{
		cout<<(B-A)<<endl;
	}
	*/
	cout<<"\n"<<carrier.at(n-1)<<"\n";
	return 0;
}
