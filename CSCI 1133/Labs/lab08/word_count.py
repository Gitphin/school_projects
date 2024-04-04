
def word_count(fname):
    
    open_file = open(fname, "r")
    read_file = open_file.read()
    split_file = read_file.split()
    
    open_file.close()
    return len(split_file)