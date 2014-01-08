#include<iostream>
#include<string>
#include<sstream>
#include<iomanip>
#include<stdlib.h>
#include<math.h>
#include<vector>
#include <climits>
#include <algorithm>

using namespace std;

void  printMatrix(vector< vector<int> > matrix, int M, int N);
void initFirstLine(vector<vector <int> > matrix, vector< vector<int> >& SUM, int M, int N);
void checkLine (int i, int M, int N, vector<vector <int> > matrix, vector<vector <int> > &SUM, vector<vector <int> > &visited, vector<vector <int> > &direction);
int getMinIndex(int line, int N, vector<vector <int> > &SUM, vector<vector <int> > &visited);
int getMinIndex(int line, int N, vector<vector <int> > &SUM);
int main(){
	int M, N, k = 0; 
	string input, line;
	
	getline(cin, input);
	stringstream sstr(input);
	sstr>>M>>N;
	
	vector< vector<int> > matrix (M, vector<int>(N));
	vector< vector<int> > SUM (M, vector<int>(N));
	vector< vector<int> > visited (M, vector<int>(N));
	vector< vector<int> > direction (M, vector<int>(N));
	
	while (getline(cin, line) && k<M){
		stringstream ss1(line);
		for (int j=0;j<N;j++){
			ss1>>matrix[k][j];
		}
		k++;
		if (k==M) break;
	}
	
	initFirstLine(matrix, SUM, M, N);
	
	
	for(int i=0;i<M-1;i++){	
			checkLine(i, M, N, matrix, SUM, visited, direction);
	}
	
	int startLine = M-1;		
	//cout<<"\n";
	int startCol = getMinIndex(startLine, N, SUM);
	//cout<<"startCol: "<<startCol<<"\n";
	vector<int> list;
	list.push_back(startCol+1);
	//printMatrix(direction, M, N );
	//cout<<"\n";
	//printMatrix(SUM, M, N );
	while (startLine>=0){					
			if (direction[startLine][startCol]==1){
				startLine--;
				list.push_back(startCol+1);
			}
			if (direction[startLine][startCol]==3){
				startCol++;
				list.push_back(startCol+1);
			}
			if (direction[startLine][startCol]==2){
				startCol--;
				list.push_back(startCol+1);
			}
			if (startLine==0)
				break;
	}		
	reverse(list.begin(), list.end());
	for (int i=0;i<list.size();i++)
	    cout<<list[i]<<" ";
	return 0;
}


void checkLine (int line, int M, int N, vector<vector <int> > matrix, vector<vector <int> > &SUM, 
		vector<vector <int> > &visited, vector<vector <int> > &direction){	
	int j = getMinIndex(line, N, SUM, visited);	
	//cout<<"j "<<j<<endl;
	while (j!=-1){			
			visited[line][j] = 1;	
			//cout<<"visited \n";
			//printMatrix(visited, M, N );
			if (j==-1)
				break;
			if (j==0){
				int value_to_right = SUM[line][j]+matrix[line][j+1];
				if (value_to_right<SUM[line][j+1]){
					SUM[line][j+1]= value_to_right;
					direction[line][j+1] = 2;
				}
				int value_to_down = SUM[line][j]+matrix[line+1][j];
				if (value_to_down<SUM[line+1][j]){
					SUM[line+1][j] = value_to_down;
					direction[line+1][j]  = 1;
				}
			}else if (j==N-1){
				int value_to_left = SUM[line][j]+matrix[line][j-1];
				if (value_to_left<SUM[line][j-1]){
					SUM[line][j-1] = value_to_left;
					direction[line][j-1]  = 3;
				}
				int value_to_down = SUM[line][j]+matrix[line+1][j];
				if (value_to_down<SUM[line+1][j]){
					SUM[line+1][j] = value_to_down;
					direction[line+1][j]  = 1;
				}
				
			}else{
				int value_to_right = SUM[line][j]+matrix[line][j+1];
				if (value_to_right<SUM[line][j+1]){
					SUM[line][j+1] = value_to_right;
					direction[line][j+1] = 2;
				}
				int value_to_left = SUM[line][j]+matrix[line][j-1];
				if (value_to_left<SUM[line][j-1]){					
					SUM[line][j-1] = value_to_left;
					direction[line][j-1]  = 3;
				}
				int value_to_down = SUM[line][j]+matrix[line+1][j];
				if (value_to_down<SUM[line+1][j]){
					SUM[line+1][j] = value_to_down;
					direction[line+1][j]  = 1;
				}
			}
			j = getMinIndex(line, N, SUM, visited);	
		}
}

int getMinIndex(int line, int N, vector<vector <int> > &SUM, vector<vector <int> > &visited){
	int column = -1;
	int value = INT_MAX;
	for(int j=0;j<N;j++){		
		if (value>SUM[line][j] && visited[line][j]==0){
			value = SUM[line][j];
			column = j;				
		}
	}
	return column;
}

int getMinIndex(int line, int N, vector<vector <int> > &SUM){
		int column = -1;
		int value = INT_MAX;
		for(int j=0;j<N;j++){			
			if (value>SUM[line][j]){
				value = SUM[line][j];
				column = j;				
			}
		}
		return column;
	}

void initFirstLine(vector<vector <int> > matrix, vector< vector<int> >& SUM, int M, int N){	
	for(int i=0;i<M;i++){
	  for(int j=0;j<N;j++){
	    if (i==0){
		SUM[0][j] = matrix[0][j];	
	    }else{
	      SUM[i][j] = INT_MAX;	
	    }
	  }
	}
	
}

void printMatrix(vector<vector <int> > matrix, int M, int N){
	for (int i=0;i<M;i++){
		for (int j=0;j<N;j++){
			cout<<matrix[i][j]<<" ";
		}
		cout<<"\n";
	}
}
