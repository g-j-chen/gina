#include <stdio.h>
#include <stdlib.h>

int main(int argc, char **argv) {

    printf("Enter text:\n");
    int lineCount = 0;
    int charCount = 0;
    int wordCount = 0;
    int inaword = 0;
    int endofline = 0;
    int ch;

    while ((ch = getchar()) != EOF) {
        if (ch == '\n') {
            endofline = 1;
            inaword = 0;
        } else if (ch == ' ') {
            inaword = 0;
        } else {
            inaword = 1;
        }

        if (!inaword) {
            wordCount++;
        }
        if (!endofline) {
            charCount++;
        } else {
            lineCount++;
        }

    }
    printf("Lines: %8d\n", lineCount);
    printf("Chars: %8d\n", charCount);
    printf("Words: %8d\n", wordCount);

    return 0;
}
