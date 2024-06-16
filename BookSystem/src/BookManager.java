import java.util.*;

public class BookManager {
	private List<Book> bookList;
	
	public BookManager()
	{
		bookList = new ArrayList<>();
	}
	
	public void addBook(Book paramBookData){
		//부적절한 인덱스 제거
		if(paramBookData.bookIndex < 0)
			return;
		
		//해당 인덱스가 존재하는지 확인
		if(searchBook(paramBookData.bookIndex) != null)
			return;
		
		//Book 추가
		Book newBook = paramBookData;
		bookList.add(newBook);
		//System.out.printf("Book{id : '%d', 제목 : '%s', 저자 : '%s', 출판년도 : '%d' 도서가 추가되었습니다.}"
		//		,paramBookData.bookIndex, paramBookData.bookName, 
		//		paramBookData.bookAuthor, paramBookData.bookPublicationYear);
	}
	
	//해당 인덱스가 존재하는지 확인
	//heap 구조
	//존재 x = return -1 <-> 존재 o = return 위치한 index
	public Book searchBook(int getFindIndex)
	{
		if(bookList == null)
			return null;
		
		for(int i=0; i < bookList.size(); i++)
		{
			if(bookList.get(i).bookIndex == getFindIndex)
				{
					System.out.printf("해당 ID(%d)는 이미 존재합니다\n",getFindIndex);
					return bookList.get(i);
				}
		}
		return null;
	}
	
	//해당 인덱스를 가진 책 삭제
	public void removeBook(int getFindIndex)
	{
		Book locatedBook = searchBook(getFindIndex);
		
		//해당 인덱스가 존재하지 않으니 return
		if(locatedBook.bookIndex == -1)
			return;
				
		bookList.remove(getFindIndex);
	}
	
	public void printList()
	{
		for(int i = 0; i < bookList.size(); i++) {
			System.out.printf("BookList[%d] = %d\n", i, bookList.get(i).bookIndex);
		}
	}
}
