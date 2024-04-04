public static int[] clone(int[] inputArray) {
    int[] newArray = new int[inputArray.length];
    for(int i = 0; i < inputArray.length; i++) {
        newArray[i] = inputArray[i];
    }
    return newArray;
}