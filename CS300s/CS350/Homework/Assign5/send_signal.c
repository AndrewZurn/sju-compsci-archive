/*
 * File send_signal.c
 */

#include <sys/types.h>
#include <signal.h>
#include <stdio.h>
#include <stdlib.h>
#include <unistd.h>

int main(int argc, char *argv[]) {

  pid_t target = atoi(argv[1]);

  if (kill(target, SIGUSR1) == -1) {
    perror("kill ");
    exit(EXIT_FAILURE);
  }

  printf("SIGUSR1 sent to process %d\n", target);

  exit(EXIT_SUCCESS);

}
