/*
* File: zurnAssign9-1.c
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
#include <unistd.h>

int main(int argc, char * argv[]){

  if( argv[1] == NULL || argv[2] == NULL ){
    printf("no command arguments given, exiting\n");
    exit(EXIT_FAILURE);
  }

  char * shared_memory = argv[1];
  int num_elements = atoi(argv[2]);
  size_t len = num_elements * sizeof(int);
  int fd, i;
  int array[num_elements];
  sem_t * sem;
  
  fd = shm_open(shared_memory, O_CREAT | O_RDWR, 0);
  if(fd == -1){
    perror("shared memory open");
    exit(EXIT_FAILURE);
  }
  printf("shared memory open!");
  
  if(ftruncate(fd, len) == -1){
    perror("shared memory resize");
    exit(EXIT_FAILURE);
  }
  printf("shared memory resized!");

  sem = sem_open("zurn_sem", O_CREAT, S_IRUSR | S_IWUSR, 0);
  if(sem == SEM_FAILED){
    perror("semaphore open failure");
    exit(EXIT_FAILURE);
  }
  
  for(i = 0; i < num_elements; i++){
    array[i] = rand();
  }

  shared_memory = mmap(NULL, len, PROT_READ | PROT_WRITE, MAP_SHARED, fd, 0);
  if(shared_memory == MAP_FAILED){
    perror("memory mapping failed");
    exit(EXIT_FAILURE);
  }

  if(close(fd) == -1){
    perror("close fd error");
  }

  memcpy(shared_memory, array, len);

  if(sem_post(sem) == -1){
    perror("sem post error");
    exit(EXIT_FAILURE);
  }

  if(sem_wait(sem) == -1){
    perror("sem wait error");
    exit(EXIT_FAILURE);
  }

  write(STDOUT_FILENO, shared_memory, len);

  if(shm_unlink("zurn_sem") == -1){
    perror("sem unlink error");
    exit(EXIT_FAILURE);
  }
  printf("\n");
  exit(EXIT_SUCCESS);
}
