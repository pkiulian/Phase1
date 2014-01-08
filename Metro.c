#include <iostream>
#include <algorithm> 
#include <string>
#include <sstream>
#include <iomanip>
#include <stdlib.h>
#include <math.h>
#include <vector>
#include <queue>
#include <set>
using namespace std;

int main(){
        /**Input processing*/
        string line, nr, MN;
        int a, sizeInput(0), N, M;
        //N : number of lines
        //M : number of columns

        /** Values needed in the computation */
        double d(20000);
        double valueDiag (sqrt(d));
        int valueNormal(100);

        /**the counting of diagonals and/or the orizontal segments*/
        int diagCounts(0);
        int orizCounts(0);

        double result (0);

        getline(cin, MN);
        stringstream ss(MN);
        ss >> M >> N;
	if (M>0 || N>0){
                getline(cin, nr);
                a = atoi(nr.c_str());
                if (a>0){
                        static vector< vector<int> > matrix ((a), vector<int>(2));
                        while(getline(cin, line) && sizeInput<a){
                                int cl[2];
                                stringstream ss1(line);
                                ss1 >> cl[0] >> cl[1];
                                matrix[sizeInput][0] = cl[0];
                                matrix[sizeInput][1] = cl[1];
                                sizeInput++;
                                if (sizeInput==a) break;
                        }
			
			static vector <int> prev (M+1);
			static vector <int> act (M+1);
			int k=N;
			while (k>0){					
				//reset the vectors
				for(int i=0;i<M+1;i++){
					prev[i]=act[i];
					act[i]=0;
				}				
				//init the act				
				for (int i=0;i<a;i++){
					if (matrix[i][1]==k){
						act[matrix[i][0]-1]=1;
					}
				}					
				for (int i=M;i>=0;i--){
					if (act[i]==0){
						act[i]=max(act[i+1], prev[i]);
					}else if (act[i]==1){
						act[i]=1+prev[i+1];
					}
				}						
				if (k==1) {
					diagCounts=act[0];
					break;
				}
				k--;
			}
			orizCounts+=((M-0)+(N-0));	
			orizCounts=orizCounts - 2*diagCounts;
			result = diagCounts*valueDiag+orizCounts*valueNormal;
          		cout<<((int)(result+0.5))<<"\n";
                }else{
                         orizCounts+=((M-0)+(N-0));
                         result = diagCounts*valueDiag+orizCounts*valueNormal;
                         cout<<((int)(result+0.5))<<"\n";

                }
        }else if (N==0 && M ==0){
                cout<<0;
                return 0;
        }
}

