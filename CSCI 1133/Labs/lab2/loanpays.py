
l = float(input("Enter your loan amount: "))
r = float(input("Enter your annual interest rate amount: "))
d = float(input("Enter your duration amount in months: "))
rr = r/12
payment = ((rr*l)/(1-((1 + rr)**(-d))))

print(payment)