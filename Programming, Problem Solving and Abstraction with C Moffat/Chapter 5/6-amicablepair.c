#include <stdio.h>
#include <stdlib.h>

int is_amicable(int, int);
int get_sum_factors(int);

int main() {
    int a, b;
    printf("Enter 2 numbers to check if they are an amicable pair: ");
    scanf("%d %d", &a, &b);
    if (is_amicable(a, b)) {
        printf("%d and %d are an amicable pair.", a, b);
    } else {
        printf("These are not amicable.");
    }
}

int is_amicable(int a, int b) {
    if (a == get_sum_factors(b) && b == get_sum_factors(a)) {
        return 1;
    } else {
        return 0;
    }
}

int get_sum_factors(int n) {
    int sum = 1;
    for (int i = 2; i <= (n + 1) / 2; i++) {
        if (n % i == 0) {
            sum += i;
        }
    }
    return sum;
}
