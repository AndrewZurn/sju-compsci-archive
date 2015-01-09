/*
* File: zurnAssign9-2.c
* Author: Andrew Zurn
* Due: 12/6/12
* Discription: One of two programs that operate on shared memory to 
*   sort a list of randomly generated numbers.
*/

#include <semaphore.h>
#include <stdlib.h>
#include <stdio.h>
#include <string.h>
#include <fcntl.h>
#include <sys/mman.h>
#include <sys/stat.h>

int int_array_compare(const int * a,const int * b)
{
  if (*a==*b){
    return 0;
  }
  else{
    if (*a < *b){
        return -1;
    }
     else{
      return 1;
    }
  }
}

int main(int argc, char * argv[]){

  if( argv[1] == NULL || argv[2] == NULL){
    printf("no command arguments given, exiting\n");
    exit(EXIT_FAILURE);
  }

  char * shared_memory = argv[1];
  size_t num_elements = atoi(argv[2]);
  int fd;
  struct stat sb;
  sem_t * sem;

  fd = shm_open(shared_memory, O_RDWR, 0);
  if(fd == -1){
    perror("shared memory open");
    exit(EXIT_FAILURE);
  }
  printf("shared memory open!");
  
  sem = sem_open("zurn_sem", O_CREAT, S_IRUSR | S_IWUSR, 0);
  if(sem == SEM_FAILED){
    perror("semaphore open failure");
    exit(EXIT_FAILURE);
  }

  if(fstat(fd, &sb) == -1){
    perror("fstat error, exiting\n");
    exit(EXIT_FAILURE);
  }

  shared_memory = mmap(NULL, sb.st_size, PROT_READ | PROT_WRITE, MAP_SHARED, fd, 0);
  if(shared_memory == MAP_FAILED){
    perror("memory mapping failed");
    exit(EXIT_FAILURE);
  }

  if(close(fd) == -1){
    perror("close fd error");
  }

  if(sem_wait(sem) == -1){
    perror("sem wait error");
    exit(EXIT_FAILURE);
  }

  qsort(shared_memory, num_elements, sizeof(int), (int(*)(const void*,const void*))int_array_compare);

  if(sem_post(sem) == -1){
    perror("sem wait error");
    exit(EXIT_FAILURE);
  }
  
  if(shm_unlink("zurn_sem") == -1){
    perror("sem unlink error");
    exit(EXIT_FAILURE);
  }

  exit(EXIT_SUCCESS);
}
