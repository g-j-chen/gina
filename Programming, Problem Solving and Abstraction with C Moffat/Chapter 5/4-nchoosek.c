#include <stdio.h>
#include <stdlib.h>

int n_choose_k(int, int);
int get_factorial(int);

int main() {
    int n, k;
    printf("Enter 2 integers for n and k: ");
    scanf("%d %d", &n, &k);
    printf("Number of different ways to select a k item subset of n distinct items is %d", n_choose_k(n, k));
    return 0;
}

int n_choose_k(int n, int k) {
    int n_fac = get_factorial(n);
    int k_fac = get_factorial(k);
    int n_less_k_fac = get_factorial(n - k);
    return n_fac / (n_less_k_fac * k_fac);
}

int get_factorial(int f) {
    int r = 1;
    for (int i = 2; i <= f; i++) {
        r *= i;
    }
    return r;
}
