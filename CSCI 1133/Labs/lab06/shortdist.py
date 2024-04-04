import math

def dist(p1, p2):
    sta = math.sqrt(((p2[0] - p1[0]) ** 2) + ((p2[1] - p1[1]) ** 2))
    return sta

def short_dist(n):
    short = dist(n[0], n[1])
    for i in range(len(n)):
        if short > dist(n[i], n[i + 1]):
            short = dist(n[i], n[i + 1])
    return short
    