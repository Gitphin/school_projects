/*
 * WARNING: Do not include the <stdio.h> header; it confuses the dlc
 * compiler. You can still use printf for debugging without including
 * <stdio.h>, although you might get a compiler warning. In general,
 * it's not good practice to ignore compiler warnings, but in this
 * case it's OK.
 */

#if 0
/*
 * STEP 1: Read the following instructions carefully.
 */

You will provide your solution to this part of the project by
editing the collection of functions in this source file.

INTEGER CODING RULES:

  Replace the "return" statement in each function with one
  or more lines of C code that implements the function. Your code
  must conform to the following style:

  int Funct(arg1, arg2, ...) {
      /* brief description of how your implementation works */
      int var1 = Expr1;
      ...
      int varM = ExprM;

      varJ = ExprJ;
      ...
      varN = ExprN;
      return ExprR;
  }

  Each "Expr" is an expression using ONLY the following:
  1. Integer constants 0 through 255 (0xFF), inclusive. You are
      not allowed to use big constants such as 0xffffffff.
  2. Function arguments and local variables (no global variables).
  3. Unary integer operations ! ~
  4. Binary integer operations & ^ | + << >>

  Some of the problems restrict the set of allowed operators even further.
  Each "Expr" may consist of multiple operators. You are not restricted to
  one operator per line.

  You are expressly forbidden to:
  1. Use any control constructs such as if, do, while, for, switch, etc.
  2. Define or use any macros.
  3. Define any additional functions in this file.
  4. Call any functions.
  5. Use any other operations, such as &&, ||, -, or ?:
  6. Use any form of casting.
  7. Use any data type other than int.  This implies that you
     cannot use arrays, structs, or unions.


  You may assume that your machine:
  1. Uses 2s complement, 32-bit representations of integers.
  2. Performs right shifts arithmetically.
  3. Has unpredictable behavior when shifting if the shift amount
     is less than 0 or greater than 31.


EXAMPLES OF ACCEPTABLE CODING STYLE:
  /*
   * pow2plus1 - returns 2^x + 1, where 0 <= x <= 31
   */
  int pow2plus1(int x) {
     /* exploit ability of shifts to compute powers of 2 */
     return (1 << x) + 1;
  }

  /*
   * pow2plus4 - returns 2^x + 4, where 0 <= x <= 31
   */
  int pow2plus4(int x) {
     /* exploit ability of shifts to compute powers of 2 */
     int result = (1 << x);
     result += 4;
     return result;
  }

FLOATING POINT CODING RULES

For the problems that require you to implement floating-point operations,
the coding rules are less strict.  You are allowed to use looping and
conditional control.  You are allowed to use both ints and unsigneds.
You can use arbitrary integer and unsigned constants. You can use any arithmetic,
logical, or comparison operations on int or unsigned data.

You are expressly forbidden to:
  1. Define or use any macros.
  2. Define any additional functions in this file.
  3. Call any functions.
  4. Use any form of casting.
  5. Use any data type other than int or unsigned.  This means that you
     cannot use arrays, structs, or unions.
  6. Use any floating point data types, operations, or constants.


NOTES:
  1. Use the dlc program (described in the spec) to check the legality of
     your solutions.
  2. Each function has a maximum number of operations (integer, logical,
     or comparison) that you are allowed to use for your implementation
     of the function.  The max operator count is checked by dlc.
     Note that assignment ('=') is not counted; you may use as many of
     these as you want without penalty.
  3. Use the btest test harness to check your functions for correctness.
  4. The maximum number of ops for each function is given in the
     header comment for each function. If there are any inconsistencies
     between the maximum ops in the spec and in this file, consider
     this file the authoritative source.

/*
 * STEP 2: Modify the following functions according the coding rules.
 *
 *   IMPORTANT. TO AVOID GRADING SURPRISES:
 *   1. Use the dlc compiler to check that your solutions conform
 *      to the coding rules.
 *
 *      YOU WILL RECEIVE NO CREDIT IF YOUR CODE DOES NOT PASS THIS CHECK.
 *
 *   2. Use the btest checker to verify that your solutions produce the
 *      correct answers.
 */

#endif

/*
 * bitMatch - Create mask indicating which bits in x match those in y
 *            using only ~, &, |
 *   Example: bitMatch(0x7, 0xE) = 0x6
 *   Legal ops: ~ & |
 *   Max ops: 14
 *   Rating: 1
 */
int bitMatch(int x, int y) {
    // puts equal 0 and 1 bits from x and y into mask
    return (~x & ~y) | (x & y);
}

/*
 * evenBits - return word with all even-numbered bits set to 1
 *   where bits are numbered from 0 (least significant) to 31 (most significant)
 *   Legal ops: ! ~ & ^ | + << >>
 *   Max ops: 8
 *   Rating: 1
 */
int evenBits(void) {
    // creates mask of even bits by spanning 8 bit val w/ lshift
    int m = 0x55;
    m = m << 8 | m;
    m = m << 16 | m;
    return m;
}

/*
 * allOddBits - return 1 if all odd-numbered bits in word set to 1
 *   where bits are numbered from 0 (least significant) to 31 (most significant)
 *   Examples allOddBits(0xFFFFFFFD) = 0, allOddBits(0xAAAAAAAA) = 1
 *   Legal ops: ! ~ & ^ | + << >>
 *   Max ops: 12
 *   Rating: 2
 */
int allOddBits(int x) {
    // make odd bit mask
    int m = 0xAA;
    m = m << 8 | m;
    m = m << 16 | m; 
    // get just odd bits and compare w/XOR
    return !((x & m) ^ m);
}

/*
 * floatAbsVal - Return bit-level equivalent of absolute value of f for
 *   floating point argument f.
 *   Both the argument and result are passed as unsigned ints, but
 *   they are to be interpreted as the bit-level representations of
 *   single-precision floating point values.
 *   When argument is NaN, return argument.
 *   Legal ops: Any integer/unsigned operations incl. ||, &&. also if, while
 *   Max ops: 10
 *   Rating: 2
 */
unsigned floatAbsVal(unsigned uf) {
    // mantissa/expo mask 
    unsigned mt = uf & 0x007FFFFF;
    unsigned e = uf & 0x7F800000;
    // check if NaN (expo all 1 and non-zero mantissa) else ret uf w/ cleared sign using mask
    if (mt != 0 && e == 0x7F800000) {
        return uf;
    } else {
        return uf & 0x7FFFFFFF;
    }
}

/*
 * implication - return x -> y in propositional logic - 0 for false, 1 for true
 *   Example: implication(1,1) = 1
 *            implication(1,0) = 0
 *   Legal ops: ! ~ ^ |
 *   Max ops: 5
 *   Rating: 2
 */
int implication(int x, int y) {
    // (0 OR 1 = 1, 0 OR 0 = 0)
    return (!x) | y;
}

/*
 * isNegative - return 1 if x < 0, return 0 otherwise
 *   Example: isNegative(-1) = 1.
 *   Legal ops: ! ~ & ^ | + << >>
 *   Max ops: 6
 *   Rating: 2
 */
int isNegative(int x) {
    // checks if 31st bit is 1 (t.f neg)
    return x >> 31 & 1;
}

/*
 * sign - return 1 if positive, 0 if zero, and -1 if negative
 *  Examples: sign(130) = 1
 *            sign(-23) = -1
 *  Legal ops: ! ~ & ^ | + << >>
 *  Max ops: 10
 *  Rating: 2
 */
int sign(int x) {
    // >> 31 neg = -1, pos = 0
    int m = x >> 31;
    // !!(x) check if 0, ret 0, else become OR 1
    return  m | !!(x);;
}

/*
 * isGreater - if x > y  then return 1, else return 0
 *   Example: isGreater(4,5) = 0, isGreater(5,4) = 1
 *   Legal ops: ! ~ & ^ | + << >>
 *   Max ops: 24
 *   Rating: 3
 */
int isGreater(int x, int y) {
   // mask to make 1 if neg, 0 if pos
    int m = x >> 31 & 1; 
    int m2 = y >> 31 & 1;
    // 1 if diff sign
    int r = (m ^ m2);
    // if diff sign and y is neg, ret 1, else cmp same sign subtraction with case if 0
    return (r & m2) | (!((x + (~y + 1)) >> 31) & !!(x ^ y));
}

/*
 * logicalShift - shift x to the right by n, using a logical shift
 *   Can assume that 0 <= n <= 31
 *   Examples: logicalShift(0x87654321,4) = 0x08765432
 *   Legal ops: ! ~ & ^ | + << >>
 *   Max ops: 20
 *   Rating: 3
 */
int logicalShift(int x, int n) {
    // shift x right by n bits
    int m = x >> n;
    // mask with most sig bits = 1 until bit 32 - n
    int m2 =  ~0 << (32 + (~n + 1));  
    // mask of all 1 if n = 0 (for n = 0 case)
    int l = !(n) << 31 >> 31;
    return (x & l) | (m & ~m2);
}

/*
 * rotateRight - Rotate x to the right by n
 *   Can assume that 0 <= n <= 31
 *   Examples: rotateRight(0x87654321,4) = 0x18765432
 *   Legal ops: ~ & ^ | + << >> !
 *   Max ops: 25
 *   Rating: 3
 */
int rotateRight(int x, int n) {
    // code from logical shift
    int m = x >> n;
    int m2 =  ~0 << (32 + (~n + 1));  
    int l = !(n) << 31 >> 31;
    int sh = (x & l) | (m & ~m2);
    // create a mask that saves first n insignificant bits
    int r = x << (32 + (~n + 1));
    // adds r on to logical shift
    return (r | sh);
}

/*
 * floatScale4 - Return bit-level equivalent of expression 4*f for
 *   floating point argument f.
 *   Both the argument and result are passed as unsigned ints, but
 *   they are to be interpreted as the bit-level representation of
 *   single-precision floating point values.
 *   When argument is NaN, return argument
 *   Legal ops: Any integer/unsigned operations incl. ||, &&. also if, while
 *   Max ops: 30
 *   Rating: 4
 */
unsigned floatScale4(unsigned uf) {
    // mask for mantissa, expo, and sign
    unsigned mt = uf & 0x007FFFFF;
    unsigned e = (uf & 0x7F800000) >> 23;
    unsigned s = uf & 0x80000000;
    // check for NaN or Infinity
    if (e == 255) {
        return uf;
    }
    if (e >= 253) {
        return s | 0x7F800000;
    }
    // denorm Case (expo close to 0)
    if (e == 0) {
        // first left shift (x2) w/ overflow check, if so convert to norm and adjust mantissa
        mt = mt << 1;
        if (mt >> 24 == 1) {
            e += 2;
            mt = mt >> 1;
        }
        // second left shift (x4) w/ overflow check
        mt = mt << 1;
        if (mt >> 24 == 1) {
            e += 2;
            mt = mt >> 1;
        }
        // return for denorm
        return s | (e << 23) | (mt & 0x007FFFFF);
    }
    // return for norm (e + 2 == (x4))
    return s | (e + 2) << 23 | (mt & 0x007FFFFF);
}

/*
 * greatestBitPos - return a mask that marks the position of the
 *               most significant 1 bit. If x == 0, return 0
 *   Example: greatestBitPos(96) = 0x40
 *   Legal ops: ! ~ & ^ | + << >>
 *   Max ops: 70
 *   Rating: 4
 */
int greatestBitPos(int x) {
    // AUTHORS NOTE: this took way too long to figure out for a two-liner :v(
    // create mask with all 1s to right of greatest bit (ex: 0001 1111)
    int m = x | x >> 1; m = m | m >> 2; m = m | m >> 4; m = m | m >> 8; m = m | m >> 16;
    // make greatest bit + mask position aligned using ~ and >>, ORs the sign, ANDs to just get mask of greatest bit
    return ((~(m >> 1) | 1 << 31) & m);
}
