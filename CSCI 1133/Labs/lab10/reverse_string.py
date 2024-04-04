
def reverse_string(text):

    if text == "":
        return text

    else:
        return reverse_string(text[1:]) + text[0]
    

        