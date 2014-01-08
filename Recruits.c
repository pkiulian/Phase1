#include<iostream>
#include<string>
#include<iomanip>  
#include<stdlib.h> //atoi


using namespace std;

int main(){
	int result = 0;
	int a, sizeInput=0;
	string nr;
	string line;
	string content;
	
	getline(cin,nr);
	a = atoi(nr.c_str());

	while(getline(cin, line) && sizeInput<a){
		//line.erase(remove_if(line.begin(), line.end(), isspace), line.end());
		content+=line;	
		sizeInput+=line.size();
		if (sizeInput==a) break;
	}


//	cout<<"content: "<<content;
	bool first = false;
	int  k = 0;
	
	
	for (int i=0;i<content.size();i++){
		if (content.at(i)=='<' && (i-k)>=0){
			result+=(i-k);
			k++;
		}
	}
	cout<<result;

	return result;
}
