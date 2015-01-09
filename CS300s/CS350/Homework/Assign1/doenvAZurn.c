/*
 *  File: doenvAndrewZurn.c
 *  Assignment: CS350 #1
 *  Author: Andrew Zurn
 *  Date: 09/06/12
 *  
 *  This program is intended to be similar to the env program. 
 *  The manual pages file should be accessed in
 *  order to under stand the uses of this program.
 */

#include <stdio.h>
  #include <stdlib.h>
  #include <string.h>
  
  extern char **environ;

int main(int argc, char ** argv) {
  char ** paramArray;
  int i =0;
  char * token1;
  char * token2;
  if (argc == 1){ //if no options or paramaters are passed to the program
    fprintf(stdout, "Current Environmental Variables are :\n");
    while(environ[i] != NULL){
      printf("%s \n", environ[i]);
      i++;
    }
    return 0;
  } //end no options/paramters branch
  
  if (argc > 1 && strcmp(argv[1], "-i") == 0){ //if params > 1 and 2nd param is -i
    paramArray=malloc(argc - 1); //allocate the memory to our params array
    for(i = 0;i< (argc -1);i++){  //copy the NAME=VALUE params to our params array
      paramArray[i] = argv[i+2];
    }
    paramArray[argc+1] = NULL;
    for(i=0;i< (argc - 2);i++){
      char * pair;
      pair = paramArray[i];
      if( isEnvVar(pair) == -1){
        fprintf(stderr, "Error: check param format, should be of NAME=VALUE format\n");
        return -1; //our param is not of NAME=VALUE format, throw error and return -1
      }
      environ = paramArray;
    }//end of for loop checking formatting
    for(i = 0; i<(argc - 2); i++){
      printf("The current environment array contains: %s \n", environ[i]);
    }
    free(paramArray);
    return 0;
  } //end of -i option branch
  
  else if(argc > 1 && strcmp(argv[1], "-i") != 0){ //when -i is not present and there are name=value pairs
    char ** newEnvArray;
    int a = 0;
    i=0;
    while(environ[i] != NULL){
      a++;
      i++;
    }
    newEnvArray = malloc(a + argc -1);
    newEnvArray = environ;
    for(i=1;i< (argc - 2);i++){
      char * pair;
      pair = argv[i];
      if( isEnvVar(pair) == -1){
        fprintf(stderr, "Error: check param format, should be of NAME=VALUE format\n");
        return -1; //our param is not of NAME=VALUE format, throw error and return -1
      }
      newEnvArray[a+1] = pair;
      a++;
    }
    printf("The current Environment contains: \n");
    i=0;
    while(newEnvArray != NULL){
     printf("%s \n", newEnvArray[i]);
     i++;
    }
      newEnvArray[argc + a] = NULL;
      return 0;
    } //end no option but parameters present branch
    
    fprintf(stderr, "An error occured in the operation of this program.\n");
    free(paramArray);
    return -1;
  } //end of main
  
  
  
  int isEnvVar(char * string){ //was going to be used to do advanced format checking, was unable to further develop.
    char * ourString;
    int i;
    int containsEquals; //used as a boolean, -1 if false
    ourString = string;
    if(string == NULL){
      return 1;
    }
    else if(string != NULL){
      for(i=0;i<sizeof(ourString);i++){ //loop used to check if an '=' sign is present in our param
        if(ourString[i] == '='){
          containsEquals = 0;
          break;
        }
        else{
          containsEquals = -1;
        }
      }
//      if(containsEquals == 0){ //will check the validity of the Name and Value pair in param
//        token1 = strtok(ourString, "="); //ourString becomes the first value in param (that is, NAME)
//         token2 = strtok(NULL, "=");
// for(i=0;i<sizeof(token1);i++){ //check validity of NAME
//    if(token1[i] == '/'){
//       return -1;
//    }
// } //end for loop
// if(token2[0] != '/'){ //check validity of VALUE, must start in the root directory
//   return -1;
// }
      if(containsEquals == -1){
        return -1; //if parameter didn't contain the proper formatting, return -1
      }
      else{
        return 1; //if parameter did contain the proper formatting, return 1.
      }
    }
    return -1; //if all else fails return -1
  }
  
  

