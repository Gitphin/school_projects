import numpy as np
import matplotlib.pyplot as plt
import pandas as pd

arr = np.array([1,2,3])

# Prints shape of array
print(arr.shape)

# Prints a matrix of 0
print(np.zeros((2,3)))
# Prints an array of 1
print(np.ones(4))

# Prints a matrix of random values
print(np.random.rand(2,3))
# Prints an increasing  number array
print(np.linspace(1,5,5))

# Creates a random scatterplot of ants on a table over time
plt.scatter(np.random.rand(4,4),np.random.rand(4,4))
plt.xlabel("Hours passed")
plt.ylabel("Ants on table")
plt.title("Ants over time graph")
plt.savefig("nprand.jpg")
plt.show()

# Creates a graph of sin(x) in the x range of -6, 6
x = np.linspace(-6, 6, 100)
y = np.sin(x)
plt.scatter(x,y)
plt.show()

# Goes through and prints off data found in the file
df = pd.read_csv("titanic.csv")
print(df.head())
print(df.tail())
print(df.columns)
print(df.describe())
print(df.values)

# Prints first three columns 
print(df["Age"][0:3])

# Prints age value of first three columns
ages = df["Age"][0:3].values
print(ages)

# Lowest aged person
df = df.sort_values("Age")
low_age = df["Name"][0:1].values
print(low_age)

# Lowest paid fare
df = df.sort_values("Fare")
low_fare = df["Name"][0:1].values
print(low_fare)

# Avg fare of first class
df = df.sort_values("Pclass")
nfrs_avg = df["Fare"][0:216].values
avgf = (sum(nfrs_avg))/len(nfrs_avg)
print(avgf)

# Avg fare of third class
df = df.sort_values("Pclass", ascending = False)
nthr_avg = df["Age"][0:487].values
avga = (sum(nthr_avg))/len(nthr_avg)
print(avga)

# Creates a histogram of passenger classes
b = df["Pclass"].values
plt.hist(b)
plt.xlabel("Class type")
plt.ylabel("Number of passengers")
plt.show()
plt.savefig("histclass.jpg")

# Creates a histogram of passenger ages
c = df["Age"].values
plt.hist(c)
plt.show()
plt.savefig("histage.jpg")

# Scatterplot of Fare vs Age
d = df["Fare"].values

plt.scatter(d,c)
plt.xlabel("Fare of passenger")
plt.ylabel("Age of passenger")
plt.title("Fare vs Age of passenger")
plt.show()
plt.savefig("scatterfarevsage.jpg")



