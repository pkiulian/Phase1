#include <stdio.h>
#include <stdlib.h>
#include <math.h>

int main(){

int sz = 256 * 1024 * 4; // Error was their - need more memory for input data

double *sp, *fp, *p;

sp = (double *)malloc(sz);
fp = sp + (sz / sizeof(double));

for(p = sp; (p < fp) && (scanf("%lf", p) != EOF); p++);
while(p > sp){
--p;
printf("%.4lf\n", sqrt((double)(*p)));
}
}