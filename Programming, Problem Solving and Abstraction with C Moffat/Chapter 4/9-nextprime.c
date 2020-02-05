#include <stdio.h>
#include <stdlib.h>

int main() {
    int n, next_prime;
    printf("Enter an integer value: ");
    scanf("%d", &n);
    if (n % 2 == 0) {
        next_prime = n + 1;
    } else {
        next_prime = n + 2;
    }

    while (isprime(next_prime) == 0) {
        next_prime += 2;
    }

    printf("\nThe next prime is     : %d", next_prime);
    return 0;
}

int isprime(int n) {
    for (int divisor = 3; divisor * divisor <= n; divisor += 2) {
        if (n % divisor == 0) {
            return 0;
        }
    }
    return 1;
}
