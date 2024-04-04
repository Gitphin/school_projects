# Alek Holiman
# holim004
# CSCI 1133 Section 050
# Assignment 1

#allows for trig methods to work by importing this library
import math

#asks user to input two numbers for sides of a triangle and one for an angle
b = float(input("What is the value of shorter side (b): "))
c = float(input("What is the value of side two (c): "))
angle_a = float(input("What is the value of the angle between (A): "))

#trig_calc will evaluate a^2 from the equation for length of the side             
trig_calc = (b ** 2) + (c ** 2) - ((2 * b * c)) * (math.cos(math.radians(angle_a)))
#this will evaluate a and not a^2, which is the side length we want
a = trig_calc ** .5

#this will print the length of side a
print("Length of the remaining side (a) is", a)

#this will calculate sinB
angle_b = ((math.sin(math.radians(angle_a))) / (a)) * b
#essentially solving sinB for angleB, converts to degrees, and prints
print("The angle of B is", math.degrees(math.asin(angle_b)))

#this will calculate sinC
angle_c = ((math.sin(math.radians(angle_a))) / (a)) * c
#solves sinC for an angleC, converts to degrees, and prints
print("The angle of C is", math.degrees(math.asin(angle_c)))
