#include <cs50.h>
#include <stdio.h>
#include <stdlib.h>
#include <ctype.h>
#include <string.h>
#include "valkey.c"
#include "encipher.c"

int valkey(string key);
string encipher(string key, string plaintext);

int main(int argc, string argv[])
{

    string key = argv[1];

   if(!(valkey(key)) || argc != 2)
    {
       printf("Invalid key emtered- one 26 character string with no repeated characters only\n");
       exit(1);
    }

    string plaintext = get_string("Please input the plaintext: ");

    printf("\nPlaintext: %s\n", plaintext);

    string ciphertext = encipher(key, plaintext);

    printf("Ciphertext: %s\n", ciphertext);

    return 0;


}//end main
