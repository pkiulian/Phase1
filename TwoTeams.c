#include <iostream>
#include <vector>
#include <queue>
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


// do it with bfs
using namespace std;


int getFirstNotVisited(vector<int> visited){
	int result = -2; // doesn't exist
	for (int i=1;i<visited.size();i++){
		if (visited.at(i)==0)
			return i;
	}
	return result;
}
int main(){
	vector<int>line;
	vector<int>col;
	int N;
	string lineR;	
	getline(cin, lineR);
	stringstream ss(lineR);
    ss >> N;
    
	for (int i=0;i<N;i++){		
		getline(cin, lineR);
		stringstream ss1(lineR);	
		int a;
		ss1>>a;		
		while (a!=0){					
			col.push_back(a);	
			line.push_back(i);
			a=0;	
			ss1>>a;
		}
	}
	vector<int> nodes;
	vector<int> flags;
	vector<int> visited;
	for (int i=0;i<=N;i++){
		visited.push_back(0);
		flags.push_back(-1);
		nodes.push_back(i);
	}
	int fl =0;
	queue<int> myqueue_nodes;	
	queue<int> myqueue_flags;	
			
	int ones = 0;
	while (getFirstNotVisited(visited)!=-2){
		myqueue_nodes.push(getFirstNotVisited(visited));	
		myqueue_flags.push(fl);
		while (!myqueue_nodes.empty()){
			int node = myqueue_nodes.front();		
			int flag = myqueue_flags.front();					
			myqueue_nodes.pop();
			myqueue_flags.pop();
			flags.at(node)=(flag);
			nodes.at(node)=(node);
			fl=flag;
			//cout<<"node:"<<node<<" flag: "<<flag<<"\n";			
			if (flag==1){
				ones++;
			}
			visited.at(node)=1;
			for (int i=0;i<line.size();i++){
				//cout<<"node-1: "<<(node-1)<<"\n";
				if (line.at(i)==(node-1)){
					//cout<<col.at(i)<<" --  "<<visited.at(col.at(i))<<"\n";
					if (visited.at(col.at(i))==0){
					//	cout<<"entered \n";
						visited.at(col.at(i))=1;	
						fl = (flags.at(node)+1)%2;				
						myqueue_nodes.push(col.at(i));
						myqueue_flags.push(fl);
					}
				}
			}			
		}
	}	
	cout<<ones<<"\n";
	for (int i=0;i<=N;i++){
		if (flags.at(i)==1)
			cout<<nodes.at(i)<<" ";
	}	
	cout<<"\n";
	return 0;
}

// done
