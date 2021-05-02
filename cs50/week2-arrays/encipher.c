



string encipher(string key, string plaintext)
{
    //string key = "YTNSHKVEFXRBAUQZCLWDMIPGJO";

    //string plaintext = "hElLo, wORLd";

    int len = strlen(plaintext)+1;

    char ciphertext[len];

    for(int u = 65, l = 97, a = 0; a < 26; u++, l++, a++ )
    {

       for (int i = 0; i < len -1 ; i++)
        {

        if ( ispunct(plaintext[i]) || isspace(plaintext[i]) )
            {
            ciphertext[i] = plaintext[i];
            continue;
            }

        if ( plaintext[i] == u )
            ciphertext[i] = toupper(key[a]);

        if ( plaintext[i] == l )
            ciphertext[i] = tolower(key[a]);
        }
    }

   string conv = ciphertext;
   
   //printf("%s\n", conv);

   return conv;
    
}//end encipher