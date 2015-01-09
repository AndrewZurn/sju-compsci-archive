/*
* Author: Andrew Zurn
* Due Date: November 15, 2012
* Description: A more detailed version of the Producer and Consumer program found in the class book.
*/

#include <pthread.h>
#include <time.h>
#include <sys/time.h>
#include <sys/types.h>
#include <stdlib.h>
#include <stdio.h>
#include <string.h>

static char * products_array;
static int top_of_stack;
static pthread_mutex_t mtx = PTHREAD_MUTEX_INITIALIZER;
static int production_done = 0; //our boolean, 0 if false, true if anything else.
static time_t sec_time;
static char * actual_time;
static con_term = 0;

static void * consumerThread(void *arg){
  int s;
  while(1){
    if(production_done == 1){
      break;
    }
  }

  s = pthread_mutex_lock(&mtx);
  if(s != 0){
    printf("Consumer consuming lock error, exiting");
    exit(EXIT_FAILURE);
  }
  int loops = *((int *) arg);
  int i;
  char * product;
  char * consumer;
  char l;
  for(i = 0; i<loops; i++){
    if(top_of_stack == 0 ){
      con_term = 1;
      break;
    }
    l = i;
    sec_time = time(NULL);
    actual_time = ctime(&sec_time);
    product = &products_array[top_of_stack];
    sprintf(consumer, "Consumer < %s > < %s >\n", l, actual_time);
    //consumer = "Consumer <" + l + "> <" + actual_time + ">\n";
    char * null = NULL;
    products_array[top_of_stack] = *null;
    top_of_stack--;
    printf(product);
    printf(consumer);
    sleep(0.2);
  }
  s = pthread_mutex_unlock(&mtx);
  if(s != 0){
    printf("Consumer consuming unlock error, exiting");
    exit(EXIT_FAILURE);
  }
  return NULL;
}

static void * producerThread(void *arg){
  int s;
  s = pthread_mutex_lock(&mtx);
  if(s != 0){
    printf("Producer production lock error, exiting");
    exit(EXIT_FAILURE);
  }
  int loops = *((int *) arg);
  int i;
  char * product;
  for(i = 0; i<loops; i++){
    char l;
    l = i;
    sec_time = time(NULL);
    actual_time = ctime(&sec_time);
    if( top_of_stack >= 1500 ){
      printf("Product < %s > < %s >\n", l, actual_time);
      break;
    }
    sprintf(product, "Product < %s > < %s >\n", l, actual_time);
    products_array[top_of_stack] = *product;
    top_of_stack++;
  }
  if(s != 0){
    printf("Producer production unlock error, exiting");
    exit(EXIT_FAILURE);
  }
  return NULL;
}

int main(int argc, char * argv[]){
  int producer, consumer, loops, i, s;
  pthread_t prod_array[loops];
  pthread_t con_array[loops];
  pthread_t prod_thread, con_thread;

  if( argv[1] != NULL ){
    producer = atoi( (argv[0]));
  } else{ producer = 1; }
  if( argv[2] != NULL ){
    consumer = atoi( (argv[1]));
  } else{ consumer = 1; }
  if( argv[3] != NULL ){
    loops = atoi( (argv[2]));
  } else{ loops = 16; }

  top_of_stack = loops;
  products_array = (char *) malloc(1500 * sizeof(char));
  if (products_array == NULL){
    printf("Malloc error, exiting");
    exit(EXIT_FAILURE);
  }

  for(i = 0; i<loops; i++){
    s = pthread_create(&con_thread, NULL, consumerThread, &loops);
    if(s != 0){
      printf("Consumer thread creation error, exiting");
      exit(EXIT_FAILURE);
    }
    con_array[i] = s;
  }

  for(i = 0; i<loops; i++){
    s = pthread_create(&prod_thread, NULL, producerThread, &loops);
    if(s != 0){
      printf("Producer thread creation error, exiting");
      exit(EXIT_FAILURE);
    }
    prod_array[i] = s;
  }
  production_done = 1;

  s = pthread_mutex_lock(&mtx);
  if(s != 0){
    printf("lock error at producer join, exiting");
    exit(EXIT_FAILURE);
  }
  for(i = 0; i<loops; i++){
    s = pthread_join(prod_array[i], NULL);
    if(s != 0){
      printf("Producer join error, exiting");
      exit(EXIT_FAILURE);
    }
  }
  s = pthread_mutex_unlock(&mtx);
  if(s != 0){
    printf("unlock error at producer join, exiting");
    exit(EXIT_FAILURE);
  }

  while(1){
    if(con_term == 1){
      break;
    }
  }

  s = pthread_mutex_lock(&mtx);
  if(s != 0){
    printf("lock error at consumer join, exiting");
    exit(EXIT_FAILURE);
  }
  for(i = 0; i<loops; i++){
    s = pthread_join(con_array[i], NULL);
    if(s != 0){
      printf("Consumer join error, exiting");
      exit(EXIT_FAILURE);
    }
  }
  s = pthread_mutex_unlock(&mtx);
  if(s != 0){
    printf("unlock error at consumer join, exiting");
    exit(EXIT_FAILURE);
  }
  exit(EXIT_SUCCESS);
}
