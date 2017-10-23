public class Library {
    private Book[] books;

    public Library() {
        this.books = new Book[15];
    }

    public int bookCount() {
        int counter = 0;
        for (Book book : this.books) {
            if(book != null) {
                counter ++;
            }
        }
        return counter;
    }

    public boolean isLibraryFull() {
        return bookCount() == books.length;
    }

    public boolean isLibraryEmpty() {
        return bookCount() == 0;
    }

    public void add(Book book) {
        if (!isLibraryFull()) {
            int counter = bookCount();
            this.books[counter] = book;
        }
    }

    public void discardAll() {
        int counter = bookCount();
        for (int i=0; i < counter; i++) {
            this.books[i] = null;
        }
    }

}
