#include <stdio.h>
#include <stdlib.h>

#define MAX_SIZE 1000

void insertion_sort(int[], int);

int main(int argc, char **argv) {
    int n = 0;
    int next;
    int A[MAX_SIZE];
    printf("Enter up to 1000 integers:\n");
    while(scanf("%d", &next) == 1) {
        A[n] = next;
        n++;
    }
    insertion_sort(A, n);
    printf("After sorting:\n");
    for(int i = 0; i < n; i++) {
        printf("%d ", A[i]);
    }
    return 0;
}

void insertion_sort(int A[], int n) {
    int i = 1;
    while(i < n) {
        int curr = A[i];
        int j = i - 1;
        while(j >= 0 && curr < A[j]) {
            A[j + 1] = A[j];
            j--;
        }
        A[j + 1] = curr;
        i++;
    }
}

