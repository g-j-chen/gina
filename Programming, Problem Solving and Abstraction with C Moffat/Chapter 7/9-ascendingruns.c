#include <stdio.h>
#include <stdlib.h>

#define MAX_SIZE 1000

int ascending_runs(int[], int);

int main(int argc, char **argv) {
    int n = 0;
    int next;
    int A[MAX_SIZE];
    printf("Enter up to 1000 numbers:\n");
    while (scanf("%d", &next) == 1) {
        A[n] = next;
        n++;
    }
    printf("Number of ascending runs present is %d", ascending_runs(A, n));
    return 0;
}

int ascending_runs(int A[], int n) {
    int runs = 1;
    int prev = A[0];
    for (int i = 1; i < n; i++) {
        if (A[i] < prev) {
            runs++;
        }
        prev = A[i];
    }
    return runs;
}
