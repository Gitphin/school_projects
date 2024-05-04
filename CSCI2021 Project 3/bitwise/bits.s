# Read the following instructions carefully
# You will provide your solution to this part of the project by
# editing the collection of functions in this source file.
#
# Some rules from Project 2 are still in effect for your assembly code here:
#  1. No global variables are allowed
#  2. You may not define or call any additional functions in this file
#  3. You may not use any floating-point assembly instructions
# You may assume that your machine:
#  1. Uses two's complement, 32-bit representations of integers.

# bitMatch - Create mask indicating which bits in x match those in y
#   Example: bitMatch(0x7, 0xE) = 0x6
#   Rating: 1
.global bitMatch
bitMatch:
    movl %edi, %eax 
    andl %esi, %eax # x & y = eax
    notl %edi
    notl %esi
    andl %edi, %esi # (~x & ~y) = esi
    orl %esi, %eax
    ret

# evenBits - return word with all even-numbered bits set to 1
#   where bits are numbered from 0 (least significant) to 31 (most significant)
#   Rating: 1
.global evenBits
evenBits:
    movl $0x5555, %ecx #0x5555 
    movl %ecx, %eax
    sall $16, %eax
    orl %ecx, %eax #0x5555 << 16 OR #0x5555 
    ret

# allOddBits - return 1 if all odd-numbered bits in word set to 1
#   where bits are numbered from 0 (least significant) to 31 (most significant)
#   Examples allOddBits(0xFFFFFFFD) = 0, allOddBits(0xAAAAAAAA) = 1
#   Rating: 2
.global allOddBits
allOddBits:
    movl %edi, %eax
    movl $0xAAAA, %edx #0xAAAA
    movl %edx, %ecx
    sall $16, %ecx
    orl %edx, %ecx # ecx = mask
    andl %ecx, %eax # x & m
    xorl %ecx, %eax #(x & m) ^ m
    cmpl $0, %eax # checks if bits left over from xor (meaning not all odd)
    je IF_ZERO_ALL_ODD
    movl $0, %eax
    ret
    IF_ZERO_ALL_ODD:
        movl $1, %eax
        ret 

# floatAbsVal - Return bit-level equivalent of absolute value of f for
#   floating point argument f.
#   Both the argument and result are passed as unsigned ints, but
#   they are to be interpreted as the bit-level representations of
#   single-precision floating point values.
#   When argument is NaN, return argument.
#   Rating: 2
.global floatAbsVal
floatAbsVal:
    movl %edi, %eax 
    movl %edi, %ecx 
    movl %edi, %edx 
    andl $0x007FFFFF, %ecx # mt mask
    andl $0x7F800000, %edx # expo mask
    cmpl $0x7F800000, %edx # checks if expo all 1
        je NAN_TEST_ABS
    jmp CONTINUE_ABS
    CONTINUE_ABS:
        andl $0x7FFFFFFF, %eax # removes sign with AND and rets
        ret
    NAN_TEST_ABS:
        cmpl $0, %ecx # check if mt nonzero
        jne NAN_RET_ABS
        jmp CONTINUE_ABS
    NAN_RET_ABS:
        ret


# implication - return x -> y in propositional logic - 0 for false, 1 for true
#   Example: implication(1,1) = 1
#            implication(1,0) = 0
#   Rating: 2
.global implication
implication:
    movl %edi, %ecx # x
    movl %esi, %eax # y
    cmpl $0, %ecx #check if x is 0 and apply !(x) accordingly
    je IF_ZERO_IMP
    jmp NOT_ZERO_IMP
    IF_ZERO_IMP:
        movl $1, %ecx # if !(0) -> 1
        jmp CONTINUE_IMP
    NOT_ZERO_IMP: 
        movl $0, %ecx # if !(n != 0) -> 0
        jmp CONTINUE_IMP
    CONTINUE_IMP: 
        orl %ecx, %eax # rets not x or y
        ret

# isNegative - return 1 if x < 0, return 0 otherwise
#   Example: isNegative(-1) = 1.
#   Rating: 2
.global isNegative
isNegative:
    movl %edi, %eax
    sarl $31, %eax # check most sig bit (if 1 then neg)
    andl $1, %eax
    ret 

# sign - return 1 if positive, 0 if zero, and -1 if negative
#  Examples: sign(130) = 1
#            sign(-23) = -1
#  Rating: 2
.global sign
sign:
    movl %edi, %eax # x
    movl %edi, %ecx
    sarl $31, %ecx # m (1 if neg, 0 else)
    cmpl $0, %eax # !!(x) = 1 if nonzero, 0 if 0
    jne NONZERO_SIGN
    ret # ret 0 if 0
    NONZERO_SIGN:
        movl $1, %eax # set x to 1
        jmp CONTINUE_SIGN
    CONTINUE_SIGN:
        orl %ecx, %eax # use or to check if neg
        ret 

# isGreater - if x > y  then return 1, else return 0
#   Example: isGreater(4,5) = 0, isGreater(5,4) = 1
#   Rating: 3
.global isGreater
isGreater:
    movl %edi, %eax #x
    movl %esi, %ecx #y
    cmpl %eax, %ecx # if y >= x ret 0
    jge LESS_IS_GREATER 
    movl $1, %eax # if y < x ret 1
    ret
    LESS_IS_GREATER:
        movl $0, %eax
        ret

#  logicalShift - shift x to the right by n, using a logical shift
#    Can assume that 0 <= n <= 31
#    Examples: logicalShift(0x87654321,4) = 0x08765432
#    Rating: 3
.global logicalShift
logicalShift:
    movl %edi, %eax
    movl $0, %ecx # i = 0
    START_LOG_SHIFT:
        cmpl %ecx, %esi # if i == n return 
        je END_LOG_SHIFT # break from loop
        shrl $1, %eax # logical shifting by 1
        incl %ecx # i++
        jmp START_LOG_SHIFT # loooop
    END_LOG_SHIFT:
        ret

# rotateRight - Rotate x to the right by n
#   Can assume that 0 <= n <= 31
#   Examples: rotateRight(0x87654321,4) = 0x18765432
#   Rating: 3
.global rotateRight
rotateRight:
    movl %edi, %eax
    movl $0, %ecx # i = 0
    movl %esi, %edx
    START_ROTATE_RIGHT:
        cmpl %ecx, %esi # if i == n return 
        je NEW_ROTATE_RIGHT # break from loop
        shrl $1, %eax # logical shifting by 1
        incl %ecx # i++
        jmp START_ROTATE_RIGHT # loooop
    NEW_ROTATE_RIGHT: 
        movl $32, %edx 
        subl %esi, %edx # do 32 - n
        movl $0, %ecx # set i back to 0
        jmp ROTATE_RIGHT_LOOP
    ROTATE_RIGHT_LOOP:
        cmpl %ecx, %edx # while i != edx
        je END_ROTATE_RIGHT
        shll $1, %edi
        incl %ecx # i++
        jmp ROTATE_RIGHT_LOOP
    END_ROTATE_RIGHT:
        orl %edi, %eax # OR to save shifted bits of x
        ret
        

# floatScale4 - Return bit-level equivalent of expression 4*f for
#   floating point argument f.
#   Both the argument and result are passed as unsigned ints, but
#   they are to be interpreted as the bit-level representation of
#   single-precision floating point values.
#   When argument is NaN, return argument
#   Rating: 4
.global floatScale4
floatScale4:
    movl $0x80000000, %esi # s
    movl $0x007FFFFF, %ecx # mt
    movl $0x7F800000, %edx # e
    andl %edi, %esi 
    andl %edi, %ecx
    andl %edi, %edx
    sarl $23, %edx # get e in proper place
    cmpl $255, %edx # check if NaN result
    je NAN_CHECK_FLOAT_SCALE
    cmpl $253, %edx # check if infinity result
    jge INF_CHECK_FLOAT_SCALE 
    cmpl $0, %edx # check if denorm case, jump to denorm first check
    je DENORM_FLOAT_SCALE
    addl $2, %edx # e + 2 == * 4
    sall $23, %edx # get e in right place again
    andl $0x007FFFFF, %ecx # mask for mt to remove out of spot bits
    orl %ecx, %edx 
    orl %esi, %edx
    movl %edx, %eax # combines s, e, mt and rets
    ret
    DENORM_FLOAT_SCALE:
        sall $1, %ecx # first shift left (x2)
        movl %ecx, %eax 
        sarl $24, %eax 
        cmpl $1, %eax # checks if overflow happens, goes to overflow case
        je OVERFLOW_CASE_ONE_FLOAT_SCALE
        jmp CONTINUE_DENORM_FLOAT_SCALE # else continues to second check
    CONTINUE_DENORM_FLOAT_SCALE:
        sall $1, %ecx # second left shift (x4)
        movl %ecx, %eax 
        sarl $24, %eax
        cmpl $1, %eax # checks if overflow happens, goes to overflow case
        je OVERFLOW_CASE_TWO_FLOAT_SCALE
        jmp FINAL_DENORM_FLOAT_SCALE # else continues
    FINAL_DENORM_FLOAT_SCALE:
        andl $0x007FFFFF, %ecx 
        sall $23, %edx # gets just exp and puts back in correct place
        orl %ecx, %edx
        orl %esi, %edx
        movl %edx, %eax # combines s, e, mt and rets
        ret
    OVERFLOW_CASE_ONE_FLOAT_SCALE:
        addl $2, %edx 
        sarl $1, %ecx # adds 2 to expo value and shifts mt back
        jmp CONTINUE_DENORM_FLOAT_SCALE
    OVERFLOW_CASE_TWO_FLOAT_SCALE:
        addl $2, %edx
        sarl $1, %ecx # adds 2 to expo value and shifts mt back
        jmp FINAL_DENORM_FLOAT_SCALE   
    NAN_CHECK_FLOAT_SCALE:
        movl %edi, %eax # returns input if NaN
        ret 
    INF_CHECK_FLOAT_SCALE:
        movl %esi, %eax
        orl $0x7F800000, %eax # returns infinity with correct sign in eax
        ret 

# greatestBitPos - return a mask that marks the position of the
#               most significant 1 bit. If x == 0, return 0
#   Example: greatestBitPos(96) = 0x40
#   Rating: 4
.global greatestBitPos
greatestBitPos:
    movl %edi, %ecx # m shift tool
    movl %ecx, %edx # where true m stored
    sarl $1, %ecx
    orl %ecx, %edx
    movl %edx, %ecx
    sarl $2, %ecx
    orl %ecx, %edx
    movl %edx, %ecx
    sarl $4, %ecx
    orl %ecx, %edx
    movl %edx, %ecx
    sarl $8, %ecx
    orl %ecx, %edx
    movl %edx, %ecx
    sarl $16, %ecx
    orl %ecx, %edx # keep r shift m to create mask with all 1 to right of greatest bit
    movl %edx, %ecx
    sarl $1, %ecx # (m >> 1) 
    notl %ecx # ~(m >> 1)
    movl $1, %eax
    sall $31, %eax
    orl %ecx, %eax  # sign checking
    andl %edx, %eax # logic: 0111 1111 & 0100 000 -> 0100 0000 = mask of most sig bit
    ret
