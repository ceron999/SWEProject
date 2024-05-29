import java.util.List;

public class BookManager {
	private List<Book> bookList;
	
	public void addBook(int getIndex, String getName, String getAuthor, int getYear){
		//부적절한 인덱스 제거
		if(getIndex < 0)
			return;
		
		//해당 인덱스가 존재하는지 확인
		if(searchBook(getIndex) == -1)
			return;
		
		//Book 추가
		Book newBook = new Book(getIndex, getName, getAuthor, getYear);
		bookList.add(bookList.size(), newBook);
		System.out.printf("Book{id : '%d', 제목 : '%s', 저자 : '%s', 출판년도 : '%d' 도서가 추가되었습니다.}"
							,getIndex, getName, getAuthor, getYear);
	}
	
	//해당 인덱스가 존재하는지 확인
	//heap 구조
	//존재 x = return -1 <-> 존재 o = return 위치한 index
	public int searchBook(int getFindIndex)
	{
		if(bookList.size() == 0)
			return -1;
		
		for(int i=0; i < bookList.size(); i++)
		{
			if(bookList.get(i).bookIndex == getFindIndex)
				{
					System.out.printf("해당 ID(%d)는 이미 존재합니다",getFindIndex);
					return i;
				}
		}
		return -1;
	}
	
	//해당 인덱스를 가진 책 삭제
	public void removeBook(int getFindIndex)
	{
		int locatedIndex = searchBook(getFindIndex);
		
		//해당 인덱스가 존재하지 않으니 return
		if(locatedIndex == -1)
			return;
				
		bookList.remove(getFindIndex);
	}
}
