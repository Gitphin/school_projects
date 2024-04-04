# Alek Holiman
# holim004
# CSCI 1133 Section 050
# Assignment 6

import datetime

# creates a new class called CrewMember
class CrewMember:
    # initiallizing with id, last/first name, rank, and a stats list
    def __init__(self, crew_id, last_name  = "", first_name = "", rank = "", stats = None):
        # sets to an empty stats list if none provided
        if stats == None:
            self.stats = ([],[],[])
        else:
            self.stats = stats
        # sets the self to the parameters of __init__
        self.crew_id = crew_id
        self.last_name = last_name
        self.first_name = first_name
        self.rank = rank
    # returns the ID, stats, and averages of self
    def __str__(self):
        return "ID: "+ str(self.crew_id) + "\nStats: " + str(self.stats) + "\nAverages: " + str(self.average_stats())
    # changes / sets the last name
    def set_last_name(self, n):
        self.last_name = n
    # changes / sets the first name
    def set_first_name(self, n):
        self.first_name = n
    # changes / sets the rank
    def set_rank(self, n):
        self.rank = n
    # returns the id number of self
    def get_crew_id(self):
        return self.crew_id
    # returns the last name of self
    def get_last_name(self):
        return self.last_name
    # returns the first name of self
    def get_first_name(self):
        return self.first_name 
    # returns the rank of self
    def get_rank(self):
        return self.rank
    # returns the stats of self
    def get_stats(self):
        return self.stats
    # function that can add to the different stats
    def add_stats(self, n, m):
        # if P value appends to the PT scores
        if m == "P":
            self.stats[0].append(n)
        # if J value appends to the job test scores
        elif m == "J":
            self.stats[1].append(n)
        # if R value appends to the review ratings
        elif m == "R":
            self.stats[2].append(n)
    # returns an average of each stat of self
    def average_stats(self):
        t = []
        # find average of scores if the length of the list is not 0, else appends 0 for average        
        for k in self.stats:
            if k != []:
                t.append(round(sum(k)/len(k)))
            else:
                t.append(0)
        # returns a tuple of the averages
        return tuple(t)

# creates class called StarshipCrew
class StarshipCrew:
    # initializes with starship name, the manufactured year, class, and start date of mission
    def __init__(self, starship_name, manufactured_year, ship_class, start_date_of_current_mission):
        # sets the crew to an empty list
        self.crew = []
        # assigns the init values to self
        self.starship_name = starship_name
        self.manufactured_year = manufactured_year
        self.ship_class = ship_class
        self.start_date_of_current_mission = start_date_of_current_mission    
    def __str__(self):
        # returns the starship name, manufactured year, ship class, start date of mission, and a set average of averages value of (0, 0, 0) if no crew members
        if len(self.crew) == 0:
            return str(self.starship_name) + ", " + str(self.manufactured_year) + ", " + str(self.ship_class) + ", " + str(self.start_date_of_current_mission) + ", (0, 0, 0)"
        # else returns the starship name, manufactured year, ship class, start date of mission, and the average of average scores if there are crew members
        else:
            a,b,c = 0,0,0
            for k in self.crew:
                v = k.average_stats()
                a,b,c = a + v[0],b + v[1],c + v[2]
            t = (round(a/len(self.crew)), round(b/len(self.crew)), round(c/len(self.crew)))
            return str(self.starship_name) + ", " + str(self.manufactured_year) + ", " + str(self.ship_class) + ", " + str(self.start_date_of_current_mission) + ", " + str(t)
    # returns the list of crew
    def get_crew(self):
        return self.crew
    # prints the list of crew
    def print_crew(self):
        for k in self.crew:
            print(k)
    # returns the amount of crew members
    def count(self):
        return len(self.crew)
    # checks how many of a rank are in the crew members
    def count_crew_rank(self, r):
        a = []
        # adds same ranks to a list and returns length of list to get count
        for k in self.crew:
            if k.rank == r:
                a.append(k)
            else:
                continue
        return len(a)
    # adds a new crewmember
    def add_crew(self, c):
        (self.crew).append(c)


if __name__ == '__main__':
    e = CrewMember("12345", "john", "johnson", "pog", ([75, 90, 80], [100, 100, 95, 99, 98], [85, 90, 98, 95, 100, 90]))
    f = CrewMember("127329", "red", "blue", "gold", ([45, 20, 99], [50, 2, 80], [90, 63, 38, 27]))
    g = CrewMember("1875309", "it", "cheese", "square", ([], [100, 80], [32, 67, 100]))

    print(e)
    a = StarshipCrew("a", 0, "b", 0)
    a.add_crew(e)
    a.add_crew(f)
    a.add_crew(g)
    print(a)
    print(a.count())
    print(a.count_crew_rank("pog"))
    lst = [e, f, g]
    for i in lst:
        print(i.get_crew_id())
        print(i.get_last_name())
        print(i.get_first_name())
        i.set_first_name("tset")
        i.set_last_name("test")
        i.set_rank("sett")
        print(i.get_crew_id())
        print(i.get_last_name())
        print(i.get_first_name())
        print(i.get_rank())
        print(i.get_stats())
        print(i.average_stats())
        