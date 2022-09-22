#include <stdio.h>
#include <syscall.h> //some head file
#include <unistd.h>
#include <sys/types.h>
#include <sys/wait.h>
#include <stdlib.h> //use exit()

int main(){
    int ret = fork();
    if(!ret)
    {
        //pid_t wait(int *status) 
        //pid_t waitpid(pid_t pid,int *status,int options)
        /*  
            @para:
                status: point to the terminated child's status
                pid:
                    >0: exact child 
                    =-1: any 1 child (==wait())　　 
                    =0:  any 1 child in same process group 
                    <-1: any child in a group(grp id = |pid|)   
            @return: child pid
        */
        wait(NULL);
        //waitpid(ret);
        printf("child terminate");
    }
    else
    {
        //exit();   //dealloc all cache, static obj, I/O, then terminate
        //abort();  //terminate directly 
    }
}