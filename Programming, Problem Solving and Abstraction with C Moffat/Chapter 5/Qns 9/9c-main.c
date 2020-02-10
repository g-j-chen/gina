#include <stdio.h>
#include <stdlib.h>

int nextperfect(int);

int main() {
    int n;
    printf("Enter a number: ");
    scanf("%d", &n);
    printf("The next perfect number greater than %d is: %d", n, nextperfect(n + 1));
    return 0;
}
