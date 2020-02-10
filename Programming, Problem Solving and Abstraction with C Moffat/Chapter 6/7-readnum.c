#include <stdio.h>
#include <stdlib.h>

#define READ_OK 0
#define READ_ERROR 1

int read_num(int lo, int hi, int *num);

int main(int argc, char *argv[]) {
	int valu;
	if (read_num(-100, +100, &valu) != READ_OK) {
		printf("Read error, program abort\n");
		exit(EXIT_FAILURE);
	}
	printf("Value = %d\n", valu);
	return 0;
}

int read_num(int lo, int hi, int *num) {
	int next;
	if (lo >= hi) {
        printf("Lower limit cannot be bigger than upper limit\n");
        exit(EXIT_FAILURE);
	}
	printf("Enter a number between %d and %d inclusive: ",
			lo, hi);
	while (scanf("%d", &next) == 1) {
		if (lo <= next && next <= hi) {
			*num = next;
			return READ_OK;
		}
		printf("%d is not between %d and %d\ntry again: ",
				next, lo, hi);
	}
	return READ_ERROR;
}
