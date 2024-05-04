#include <stdio.h>
#include <string.h>

#include "contacts.h"

#define MAX_CMD_LEN 128

/*
 * This is in general *very* similar to the list_main file seen in lab 2
 * One big difference is the notion of switching between contact logs in one
 * run of the program.
 * You have to create or load a contact log from a file before you can do things
 * like add, lookup, or write.
 * The code below has to check if contact log is NULL before the operations
 * occur. Also, the user has to explicitly clear the current contact log before
 * they can create or load in a new one.
 */
int main(int argc, char **argv) {
    contacts_log_t *log = NULL;
    char extend[MAX_NAME_LEN];
    // Checks if provided a file
    if (argc == 2) {
        strcpy(extend, argv[1]);
        char ext2[4];
        for (int i = 0; i < 4; i++) {
            ext2[i] = extend[strlen(extend)-4+i];
        }
        ext2[4] = '\0';
        const char *fl = argv[1];
        // Checks for proper file type, reads from file and creates log
        if ((strcmp(ext2,".bin")) != 0 && (strcmp(ext2,".txt")) != 0) {
            printf("Error: Unknown contacts log file extension\n");
        }
        else if (strcmp(ext2,".bin") == 0) {
            log = read_contacts_log_from_binary(fl);
        } 
        else if (strcmp(ext2, ".txt") == 0) {
            log = read_contacts_log_from_text(fl);
        }
    }

    printf("CSCI 2021 Contact Log System\n");
    printf("Commands:\n");
    printf("  create <name>:            creates a new log with specified name\n");
    printf("  log:                      shows the name of the active contacts log\n");
    printf("  add <name> <phone> <zip>: adds a new contact\n");
    printf("  lookup <name>:            searches for a phone number by contact name\n");
    printf("  clear:                    resets current contacts log\n");
    printf("  print:                    shows all contacts in active log\n");
    printf("  write_text:               saves all contacts to text file\n");
    printf("  read_text <file_name>:    loads contacts from text file\n");
    printf("  write_bin:                saves all contacts to binary file\n");
    printf("  read_bin <file_name>:     loads contacts from binary file\n");
    printf("  exit:                     exits the program\n");

    char cmd[MAX_CMD_LEN];
    while (1) {
        printf("contacts> ");
        if (scanf("%s", cmd) == EOF) {
            printf("\n");
            break;
        }
        if (strcmp("exit", cmd) == 0) {
            break;
        }
        else if (strcmp("print", cmd) == 0) {
            // Complete, checks if active log and prints out log contact info
            if (log == NULL) {
                printf("Error: You must create or load a contacts log first\n");
            } else {
                print_contacts_log(log);
            }
        }
        else if (strcmp("log", cmd) == 0) {
            // Complete, checks if active log and returns the name
            if (log == NULL) {
                printf("Error: You must create or load a contacts log first\n");
            } else {
                printf("%s\n", get_contacts_log_name(log));

            }
        }
        else if (strcmp("lookup", cmd) == 0) {
            // Complete, checks if active log and looks up number
            scanf("%s", cmd);
            if (log == NULL) {
                printf("Error: You must create or load a contacts log first\n");
            } else {
                find_phone_number(log, cmd);
            }
        }
        else if (strcmp("add", cmd) == 0) {
            // Complete, checks if active log and adds contact to it
            char x[MAX_NAME_LEN];
            unsigned long y;
            unsigned z;
            scanf("%s %lu %u", x,&y,&z);
            if (log == NULL) {
                printf("Error: You must create or load a contacts log first\n");
            } else {
                add_contact(log, x, y, z);
            }
        }
        else if (strcmp("clear", cmd) == 0) {
            // Complete, checks if active log and frees 
            if (log == NULL) {
                printf("Error: No contacts log to clear\n");
            } else {
                free_contacts_log(log);
                log = NULL;
            }
        }
        else if (strcmp("write_text", cmd) == 0) {
            // Complete, checks if active log and writes to text file
            if (log == NULL) {
                printf("Error: You must create or load a contacts log first\n");
            }
            else {
                write_contacts_log_to_text(log);
            }
        }
        else if(strcmp("read_text", cmd) == 0) {
            // Complete, checks if no active log and reads from text file
            char f[MAX_NAME_LEN];
            scanf("%s", f);
            if (log != NULL) {
                printf("Error: You must clear current contacts log first\n");
            } else {
                log = read_contacts_log_from_text(f);
            }
        }
        else if (strcmp("write_bin", cmd) == 0) {
            // Complete, checks if active log and writes to a binary file
            if (log == NULL) {
                printf("Error: You must create or load a contacts log first\n");
            } else {
                write_contacts_log_to_binary(log);
            }
        }

        else if (strcmp("read_bin", cmd) == 0) {
            // Complete, checks if no active log and reads binary file
            char f[MAX_NAME_LEN];
            scanf("%s", f);
            if (log != NULL) {
                printf("Error: You must clear current contacts log first\n");
            } else {
                log = read_contacts_log_from_binary(f);
            }
        }
        else if (strcmp("create", cmd) == 0) {
            scanf("%s", cmd); // Read in new log name
            if (log != NULL) {
                printf("Error: You already have an contacts log.\n");
                printf("You can remove it with the \'clear\' command\n");
            } else {
                log = create_contacts_log(cmd);
                if (log == NULL) {
                    printf("Contacts log creation failed\n");
                }
            }
        } else {
            printf("Unknown command %s\n", cmd);
        }
    }
    if (log != NULL) {
        free_contacts_log(log);
    }
    return 0;
}
