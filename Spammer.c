#include<iostream>
#include<set>
#include<list>
#include<vector>
#include<string>
#include<stdlib.h>
#include <iterator>

using namespace std;

int main(){
	int result = 0;
	int a = -1;
	string nr, line;
	set<string> myset;
	set<string> resultSet;
	vector<string> slist;
	//list<int>::iterator it;
	set<string>::iterator myIterator;
	getline(cin, nr);	
	a = atoi(nr.c_str());
	
	if ( a>0 ){			
		int index = 0;		
		while(getline(cin, line) && index<=(a+1)){		
			slist.push_back(line);						
			index++;
			if (index==a) break;
		}
		for (int i=0;i<slist.size();i++){
			
			if( myset.find(slist[i]) != myset.end() ){			
				resultSet.insert(slist[i]);	
			}else{
				myset.insert(slist[i]);
			}
		}
		for(myIterator = resultSet.begin(); myIterator != resultSet.end(); myIterator++){
			cout<<*myIterator<<"\n";
		}	
	}else if (a==0){
		//cout<<"a: "<<a;
	}		
	return result;	
}
