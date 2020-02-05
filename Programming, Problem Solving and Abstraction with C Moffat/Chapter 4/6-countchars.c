#include <stdio.h>
#include <stdlib.h>

int main(int argc, char **argv) {

    printf("Enter text:\n");
    int lineCount = 0;
    int charCount = 0;
    int ch;

    while ((ch = getchar()) != EOF) {
        if (ch == '\n') {
            lineCount++;
        } else {
            charCount++;
        }
    }
    printf("Lines: %8d\n", lineCount);
    printf("Chars: %8d\n", charCount);

    return 0;
}
