
def make_dictionary(names = ['joe', 'tom', 'barb', 'sue', 'sally'] , scores = [10,23,13,18,12]):
    score_dict = {}
        
    for i in range(len(names)):
        score_dict[names[i]] = scores[i]
    
    print(score_dict)
    
    print(score_dict["barb"])
    
    score_dict["john"] = 19
    print(score_dict)
    
    print(list(score_dict.values()))
    
    del score_dict["tom"]
    print(score_dict)
    
    score_dict["sally"] = 13
    print(score_dict)
    
    return score_dict

def get_score(name, dic):
    if name in dic:
        return dic[name]
    else:
        return -1

