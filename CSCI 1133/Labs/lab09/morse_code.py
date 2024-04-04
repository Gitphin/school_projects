

def morse_code(phrase):
    
    morse_dictionary = {'A': '.-', 'B': '-...', 'C': '-.-.',
                      'D': '-..', 'E': '.', 'F': '..-.', 'G': '--.', 'H': '....',
                      'I': '..', 'J': '.---', 'K': '-.-', 'L': '.-..', 'M': '--',
                      'N': '-.', 'O': '---', 'P': '.--.', 'Q': '--.-', 'R': '.-.',
                      'S': '...', 'T': '-', 'U': '..-', 'V': '...-', 'W': '.--',
                      'X': '-..-', 'Y': '-.--', 'Z': '--..', ' ': '/'}
    
    lst_phrase = list(phrase)
    msg = []
    
    for i in lst_phrase:
       if i.upper() in morse_dictionary:
           msg.append(morse_dictionary[i.upper()])
       elif i == " ":
           msg.append(" / ")
       else:
           continue
    
    morse_msg = " ".join(msg)
    
    return morse_msg
   