/*
 * File catch_signal.c
 */

#include <sys/types.h>
#include <signal.h>
#include <stdio.h>
#include <stdlib.h>
#include <unistd.h>

static void catch_sig(int sig) {

  if (sig != SIGUSR1) {
    fprintf(stderr, "Caught wrong signal %s\n", strsignal(sig));
  }
  else {
    printf("Caught SIGUSR1 in handler\n");
  }
}

int main() {

  pid_t pid = getpid();
  printf("Target pid is %d\n", pid);

  if (signal(SIGUSR1, catch_sig) == SIG_ERR) {
    perror("signal failed ");
    exit(EXIT_FAILURE);
  }

  pause(); // wait for a signal

  printf("Returned from signal handler\n");

  exit(EXIT_SUCCESS);

}
