#include <stdio.h>
#include <stdlib.h>

int eeee(int n);
int oooo(int n);

int main(int argc, char **argv) {
    int n;

    printf("Enter an integer: ");
    scanf("%d", &n);
    printf("eeee : %d\noooo : %d\n", eeee(n), oooo(n));
    return 0;
}

int eeee(int n) {
    if (n % 2 == 0) {
        return 1;
    } else {
        return 0;
    }
}

int oooo(int n) {
    if (n % 2 == 0) {
        return 0;
    } else {
        return 1;
    }
}
