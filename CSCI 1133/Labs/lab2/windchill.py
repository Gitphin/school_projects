t = float(input("What is the temperature in *F?"))
v = float(input("What is the velocity in mph?"))
windChill = 35.74 + (0.6215 * t) - (35.75*(v**.16)) + (.4275 * t *(v**.16))
print("The wind chill is", windChill)
