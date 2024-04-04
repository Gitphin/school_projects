
def tracking_covid(name, friends_dict, lst = None):
    if name not in friends_dict:
        return {}
    if friends_dict == {}:
        return {}
    if lst == None:
        lst = []
    for k in friends_dict[name]:
        if k not in lst:
            lst.append(k)
            tracking_covid(k, friends_dict, lst)
    return set(lst) - {name}



        