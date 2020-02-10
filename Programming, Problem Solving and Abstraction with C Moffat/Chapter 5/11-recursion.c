#include <stdio.h>
#include <stdlib.h>

/* Calculate the n'th triangle number using iteration. */
int t_itr(int n) {
	int sum, i;
	sum = 0;
	for (i=1; i<=n; i++) {
		sum += i;
	}
	return sum;
}

/* Calculate the n'th triangle number using recursion. */
int t_rec(int n) {
	if (n<=0) {
		return 0;
	} else {
		return n + t_rec(n-1);
	}
}

int main() {
    int n;
    printf("Enter n: ");
    scanf("%d", &n);
    printf("t_itr(%d) = %d\n", n, t_itr(n));
	printf("t_rec(%d) = %d\n", n, t_rec(n));
	return 0;
}
