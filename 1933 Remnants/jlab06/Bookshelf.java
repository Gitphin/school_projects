public class Bookshelf {

    private Book[] books;
    public int numComparisions = 0; 


    public Bookshelf(Book[] books) {
        this.books = books;
    }

    public Book[] getBooks() {
        return books;
    }

    public Book[] booksCopy(){
        Book[] copy = new Book[books.length];
        for(int i = 0; i < books.length; i++){
            copy[i] = books[i];
        }
        return copy;
    }


    public Bookshelf mergeBookshelves(Bookshelf bookshelf){
        Book[] thisBooks = this.books;
        Book[] bookshelfBooks = bookshelf.books;
        Book[] mergedBooks = new Book[thisBooks.length + bookshelfBooks.length];
        Bookshelf newMerged = new Bookshelf(mergedBooks);

        int ptrThis = 0;
        int ptrBookshelf = 0;

        while(ptrThis < thisBooks.length && ptrBookshelf < bookshelfBooks.length){
            newMerged.numComparisions ++;
            if(thisBooks[ptrThis].compareTo(bookshelfBooks[ptrBookshelf]) < 0){
                mergedBooks[ptrBookshelf + ptrThis] = thisBooks[ptrThis];
                ptrThis++;
            }
            else{
                mergedBooks[ptrBookshelf + ptrThis] = bookshelfBooks[ptrBookshelf];
                ptrBookshelf++;
            }
        }

        if(ptrThis < thisBooks.length){
            for(int i = ptrThis; i < thisBooks.length; i++){
                mergedBooks[i + ptrBookshelf] = thisBooks[i];
            }
        }
        else {
            for(int i = ptrBookshelf; i < bookshelfBooks.length; i++){
                mergedBooks[i + ptrThis] = bookshelfBooks[i];
            }
        }

        return newMerged;
    }

    public Bookshelf mergeSortBookshelf(){
        if (books.length > 1){
            Book[] books1 = Bookshelf.cloneBookArray(this.books, 0, books.length/2);
            Book[] books2 = Bookshelf.cloneBookArray(this.books, books.length/2, books.length);

            Bookshelf bookshelf1 = new Bookshelf(books1);
            Bookshelf bookshelf2 = new Bookshelf(books2);

            bookshelf1 = bookshelf1.mergeSortBookshelf();
            bookshelf2 = bookshelf2.mergeSortBookshelf();
            return bookshelf1.mergeBookshelves(bookshelf2);
        }
        else{
            return this;
        }
    }

    public static void printBookTitles(Book[] books){
        for (int i = 0; i < books.length; i++){
            System.out.println("Title: " + books[i].getTitle());
        }
    }

    public static void printBookTitlesAndAuthors(Book[] books){
        for (int i = 0; i < books.length; i++){
            System.out.println("Title: " + books[i].getTitle() + ", Authors: " + books[i].getNumPages());
        }
    }

    public static Book[] cloneBookArray(Book[] books, int startIndex, int endIndex){
        int diff = endIndex - startIndex;
        Book[] returnBooks = new Book[diff];
        for (int i = 0; i < returnBooks.length; i++){
            returnBooks[i] = books[startIndex + i];
        }
        return returnBooks;
    }

    public Bookshelf insertionSortBookshelf(){
        Book[] sortedBooks = this.booksCopy();
        Bookshelf newSorted = new Bookshelf(sortedBooks);
        int x, y;
        for(x = 1; x < sortedBooks.length; x++){
            Book largestBook = sortedBooks[x];
            for(y = x - 1;; y--){
                if(y < 0) {
                    break;
                }
                newSorted.numComparisions ++;
                if(largestBook.compareTo(sortedBooks[y]) >= 0) {
                    break;
                }

                sortedBooks[y+1] = sortedBooks[y];
            }
            sortedBooks[y+1] = largestBook;
        }
        return newSorted;
    }

    public Bookshelf selectionSortBookshelf() {
        Book[] b = this.booksCopy();
        Bookshelf c = new Bookshelf(b);
        for (int i = 0; i < b.length - 1; i++) {
            int min = i;
            for (int j = i + 1; j < b.length; j++) {
                c.numComparisions ++;
                if ((b[j]).compareTo(b[min]) < 0) {
                    min = j;
                }
            } 
            Book a = b[min];
            b[min] = b[i];
            b[i] = a;
        }
        return c;

    }
    public static void main(String[] args) {
        // random order
        Book[] books = {new Book("1984", "Orwell", "Fiction", 528),
                new Book("A Brief History Of Time", "Hawking", "Astronomy", 212),
                new Book("Alice's Adventures in Wonderland", "Carroll", "Fantasy", 272),
                new Book("Harry Potter : The Philosopher's Stone", "Rowling", "Fantasy", 256),
                new Book("Harry Potter : The Chamber of Secrets", "Rowling", "Fantasy", 368),
                new Book("Harry Potter : The Prisoner of Azkaban", "Rowling", "Fantasy", 464),
                new Book("JK Rowling : Autobiography", "Rowling", "Non-Fiction", 500),
                new Book("The Dark Tower: The Gunslinger", "King", "Horror", 224)};

        // sorted order
//        Book[] books = {new Book("Alice's Adventures in Wonderland", "Carroll", "Fantasy", 272),
//                new Book("1984", "Orwell", "Fiction", 528),
//                new Book("A Brief History Of Time", "Hawking", "Astronomy", 212),
//                new Book("The Dark Tower: The Gunslinger", "King", "Horror", 224)
//                new Book("Harry Potter : The Chamber of Secrets", "Rowling", "Fantasy", 368),
//                new Book("Harry Potter : The Philosopher's Stone", "Rowling", "Fantasy", 256),
//                new Book("Harry Potter : The Prisoner of Azkaban", "Rowling", "Fantasy", 464),
//                new Book("JK Rowling : Autobiography", "Rowling", "Non-Fiction", 500)};

        // Reverse order
//        Book[] books = {new Book("JK Rowling : Autobiography", "Rowling", "Non-Fiction", 500),
//                new Book("Harry Potter : The Prisoner of Azkaban", "Rowling", "Fantasy", 464),
//                new Book("Harry Potter : The Philosopher's Stone", "Rowling", "Fantasy", 256),
//                new Book("Harry Potter : The Chamber of Secrets", "Rowling", "Fantasy", 368),
//                new Book("The Dark Tower: The Gunslinger", "King", "Horror", 224),
//                new Book("A Brief History Of Time", "Hawking", "Astronomy", 212),
//                new Book("1984", "Orwell", "Fiction", 528),
//                new Book("Alice's Adventures in Wonderland", "Carroll", "Fantasy", 272)};

        Bookshelf bookshelf = new Bookshelf(books);
        //Uncomment below to start testing your sorting methods.
          //Bookshelf sorted = bookshelf.insertionSortBookshelf();
          Bookshelf sorted = bookshelf.selectionSortBookshelf();
          //Bookshelf sorted = bookshelf.mergeSortBookshelf();

          printBookTitlesAndAuthors(sorted.getBooks());
          //System.out.println("this is the number of comparisons: " + sorted.numComparisions);
    }
}