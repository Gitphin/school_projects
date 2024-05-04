#include <stdio.h>
#include <stdlib.h>
#include <string.h>

#include "contacts.h"

// This is the (somewhat famous) djb2 hash
unsigned hash(const char *str) {
    unsigned hash_val = 5381;
    int i = 0;
    while (str[i] != '\0') {
        hash_val = ((hash_val << 5) + hash_val) + str[i];
        i++;
    }
    return hash_val % NUM_BUCKETS;
}

contacts_log_t *create_contacts_log(const char *log_name) {
    contacts_log_t *new_log = malloc(sizeof(contacts_log_t));
    if (new_log == NULL) {
        return NULL;
    }
    strcpy(new_log->log_name, log_name);
    for (int i = 0; i < NUM_BUCKETS; i++) {
        new_log->buckets[i] = NULL;
    }
    new_log->size = 0;

    return new_log;
}

const char *get_contacts_log_name(const contacts_log_t *log) {
    // Complete, returns name of log
    return log->log_name;
}

int add_contact(contacts_log_t *log, const char *name, unsigned long phone_number, unsigned zip_code) {
    // Complete, adds contact to hash, returns 0 on success
    // Checks if log loaded or if phone/zip nums are valid
    if (log == NULL) {
        printf("Error: You must create or load a contacts log first\n");
        return -1;
    }
    if (phone_number > 9999999999 || phone_number < 1000000000) {
        printf("Error: Invalid phone number and/or zip code\n");
        return -1;
    }
    if (zip_code > 99999 || zip_code < 10000) {
        printf("Error: Invalid phone number and/or zip code\n");
        return -1;
    }
    // Creates new contact in proper hash location, increases hash size
    node_t *new_node = malloc(sizeof(node_t));
    new_node->next = NULL;
    unsigned i = hash(name);
    strcpy(new_node->name, name);
    new_node->phone_number = phone_number;
    new_node->zip_code = zip_code;
    node_t *current = log->buckets[i];
    if (current == NULL) {
        log->buckets[i] = new_node;
    } else {
        while (current->next != NULL) {
            current = current->next;
            }
        current->next = new_node;
    }
    log->size++;

    return 0;
}

long find_phone_number(const contacts_log_t *log, const char *name) {
    // Complete, returns phone number associated with name
    unsigned i = hash(name);
    // Checks if not a valid contact
    if (log->buckets[i] == NULL) {
        printf("No phone number for '%s' found\n", name);
        return -1;
    }
    printf("%s: %lu\n", log->buckets[i]->name, log->buckets[i]->phone_number);

    return log->buckets[i]->phone_number;
}

void print_contacts_log(const contacts_log_t *log) {
    // Complete, prints out contacts from log
    printf("All contacts in %s:\n", log->log_name);
    for (int i = 0; i < NUM_BUCKETS; i++) {
        node_t *current = log->buckets[i];
        while (current != NULL) {
            printf("Name: %s, Phone Number: %lu, Zip Code: %u\n", current->name, current->phone_number, current->zip_code);
            current = current->next;
        }
    }
}

void free_contacts_log(contacts_log_t *log) {
    // Complete, frees the malloced data in contact log
    // Checks if log is already null
    if (log == NULL) {
        return;
    }
    // Iterates and frees all existing contacts
    for(int i = 0; i < NUM_BUCKETS; i++) {
        node_t *current = log->buckets[i];
        while (current != NULL) {
            node_t *nxt = current;
            current = current->next;
            free(nxt);
        }
    }
    // Frees log struct
    free(log);
}

int write_contacts_log_to_text(const contacts_log_t *log) {
    // Complete, writes a contact log to a '.txt' file, returns 0 on success
    char file_name[MAX_NAME_LEN + strlen(".txt")];
    strcpy(file_name, log->log_name);
    strcat(file_name, ".txt");
    FILE *f = fopen(file_name, "w");
    // Checks if can write to file
    if (f == NULL) {
        printf("Failed to write contacts log to text file\n");
        return -1;
    }
    // Iterates through existing contact data, writes to file
    fprintf(f, "%u\n", log->size);
    for (int i = 0; i < NUM_BUCKETS; i++) {
        node_t *current = log->buckets[i];
        while (current != NULL) {
            fprintf(f, "%s %lu %u\n", current->name, current->phone_number, current->zip_code);
            current = current->next;
        }
    }
    printf("Contacts log successfully written to %s.txt\n", get_contacts_log_name(log));
    fclose(f);

    return 0;
}

contacts_log_t *read_contacts_log_from_text(const char *file_name) {
    // Complete, reads in a provided '.txt' file, returns a new log using the data on success
    FILE *f = fopen((file_name), "r");
    // Checks if able to read file
    if (f == NULL) {
        printf("Failed to read contacts log from text file\n");
        return NULL;
    }
    char newName[MAX_NAME_LEN];
    strcpy(newName, file_name);
    newName[strlen(newName) - 4]  = '\0'; 
    contacts_log_t *logptr = create_contacts_log(newName);
    unsigned num_contacts;
    char n[MAX_NAME_LEN];
    unsigned long p;
    unsigned z;
    // Iterates through the file data and adds to new log using add_contact function
    fscanf(f, "%u", &num_contacts);
    for (int i = 0; i < num_contacts; i++) {
        fscanf(f, "%s %lu %u", n, &p, &z);
        add_contact(logptr,n,p,z);
    }
    fclose(f);
    printf("Contacts log loaded from text file\n");

    return logptr;   
}

int write_contacts_log_to_binary(const contacts_log_t *log) {
    // Complete, writes log data to '.bin' file, returns 0 on success
    char file_name[MAX_NAME_LEN + strlen(".bin")];
    strcpy(file_name, log->log_name);
    strcat(file_name, ".bin");
    FILE *f = fopen((file_name), "w");
    // Checks if can write to file
    if (f == NULL) {
        printf("Failed to write contacts log to binary file\n");
        return -1;
    }
    // Iterates through active log and writes exitsting contact data to file
    fwrite(&log->size, sizeof(unsigned), 1, f);
    for (int i = 0; i < NUM_BUCKETS; i++) {
        node_t *current = log->buckets[i];
        while (current != NULL) {
            int namelength = strlen(current->name);
            fwrite(&namelength, sizeof(int), 1, f);
            fwrite(current->name, sizeof(char), namelength, f);
            fwrite(&current->phone_number, sizeof(unsigned long), 1, f);
            fwrite(&current->zip_code, sizeof(unsigned), 1, f);
            current = current->next;
        }
     }
    fclose(f);
    printf("Contacts log successfully written to %s.bin\n", get_contacts_log_name(log));

    return 0;
}

contacts_log_t *read_contacts_log_from_binary(const char *file_name) {
    // Complete, reads in a '.bin' file and stores data into a new log, returns the log on success
    FILE *f = fopen(file_name, "r");
    // Checks if can read in the file
    if (f == NULL) {
        printf("Failed to read contacts log from binary file\n");
        return NULL;
    }
    char newName[MAX_NAME_LEN];
    strcpy(newName, file_name);
    newName[strlen(newName) - 4]  = '\0';
    unsigned num_contacts;
    char n[MAX_NAME_LEN];
    unsigned long p;
    unsigned z;
    contacts_log_t *newLog = create_contacts_log(newName);
    printf("Contacts log loaded from binary file\n");
    // Iterates through the 'bin' file, reads in data to the new log
    fread(&num_contacts, sizeof(unsigned), 1, f);
    for (int i = 0; i < num_contacts; i++) {
        int namelength;
        fread(&namelength, sizeof(int), 1, f);
        fread(n, sizeof(char), namelength, f); 
        n[namelength] = '\0'; 
        fread(&p, sizeof(unsigned long), 1, f); 
        fread(&z, sizeof(unsigned), 1, f);
        add_contact(newLog, n, p, z);
    }
    fclose(f);

    return newLog;
}