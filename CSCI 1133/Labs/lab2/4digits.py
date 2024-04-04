digs = int(input("Enter a positive 4 digit integer: "))
i1 = digs // 1000
i2 = ((digs) - i1*1000) // 100
i3 = ((digs) - (i1*1000) - (i2*100)) // 10
i4 = ((digs) - (i1*1000) - (i2*100) - (i3*10)) // 1

print(i1)
print(i2)
print(i3)
print(i4)

