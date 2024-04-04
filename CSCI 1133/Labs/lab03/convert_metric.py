


        
def metricConversion(num, unit):
       
       if unit == "pounds":
          num = num * .4536
          unit = "kg"
          return num, unit
       elif unit == "kilos":
          num = num / .4536
          unit = "lb"
          return num, unit
       elif unit == "ounces":
          num = num * 28.35
          unit = "g"
          return num, unit
       elif unit == "grams":
          num = num / 28.35
          unit = "oz"
          return num, unit
       elif unit == "miles":
          num = num * 1.609
          unit = "km"
          return num, unit
       elif unit == "kilometers":
          num = num / 1.609
          unit = "miles"
          return num, unit
       elif unit == "inches":
          num = num * 2.54
          unit ="cm"
          return num, unit
       elif unit == "centimeters":
          num = num / 2.54
          unit = "inches"
          return num, unit
       else:
          print("ERROR:", unit, "is an invalid unit")
    
    
def main():
    num = float(input("Enter amount: "))
    unit = input("Enter unit: ")
    metr_result = (metricConversion(num, unit))
    print(metr_result)
 

    
    