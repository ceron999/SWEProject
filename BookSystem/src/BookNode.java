
public class BookNode {
	private Book bookData;
	public BookNode parentNode;
	public BookNode leftChildNode;
	public BookNode rightChildNode;
	
	public void setBookData(Book paramBookData){
		this.bookData = paramBookData;
	}
	
	public int getBookIndex(){
		return bookData.bookIndex;
	}
	
	public Book getBookData() {
		return bookData;
	}
}
