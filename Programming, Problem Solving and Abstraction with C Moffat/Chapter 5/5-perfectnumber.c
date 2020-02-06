#include <stdio.h>
#include <stdlib.h>

int isperfect(int);
int nextperfect(int);

int main() {
    int n;
    printf("Enter a number: ");
    scanf("%d", &n);
    printf("The next perfect number greater than %d is: %d", n, nextperfect(n + 1));
    return 0;
}

int isperfect(int n) {
    int sum = 1;
    for (int i = 2; i <= (n + 1) / 2; i++) {
        if (n % i == 0) {
            sum += i;
        }
    }
    return sum == n;
}

int nextperfect(int n) {
    while (n < 10000) {
        if (isperfect(n)) {
            return n;
        }
        n++;
    }
    printf("Taking too long to compute next perfect number!"\n);
    return 0;
}
