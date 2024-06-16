import static org.junit.jupiter.api.Assertions.*;

import java.util.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class BookManagerTest {
	private BookManager bookManager;
	private BookTree bookTree;
	
	@BeforeEach
	void setUp() {
		bookManager = new BookManager();
		bookTree = new BookTree();
		
		Integer[] intArr = new Integer[100];
		
		Book tempBook;
		for(int i = 1; i<= 100; i++){
			intArr[i-1] = i;
		}
		
		List<Integer> list = Arrays.asList(intArr);
		Collections.shuffle(list);
		list.toArray(intArr);
		
		for(int i = 1; i<= 100; i++){
			tempBook = new Book(intArr[i-1], intArr[i-1] + "번째 책",
					intArr[i-1] + " 번째 책 저자",intArr[i-1] + 2000);
			
			//System.out.printf("Book id : %d 생성\n",tempBook.bookIndex);
			
			bookManager.addBook(tempBook);
			bookTree.insert(tempBook);
		}

	}
	
	@Test
	void testListSearch() {
		System.out.printf("Test1. heap Search\n");
		
		Random random = new Random();
		random.setSeed(System.currentTimeMillis());
		
		int randomNum = random.nextInt(100);
		Book nowBook = bookManager.searchBook(randomNum);
		System.out.printf("탐색 중인 책 : Book{id : '%d', 제목 : '%s', 저자 : '%s', 출판년도 : '%d'}\n"
				, nowBook.bookIndex, nowBook.bookName
				, nowBook.bookAuthor, nowBook.bookPublicationYear);
	}
	
	@Test
	void testTreeSearch_BS() {
		System.out.printf("Test2. BS Search\n");
		
		Random random = new Random();
		random.setSeed(System.currentTimeMillis());
		
		int randomNum = random.nextInt(100);
		Book nowBook = bookTree.search_BS(randomNum).getBookData();
		System.out.printf("탐색 중인 책 : Book{id : '%d', 제목 : '%s', 저자 : '%s', 출판년도 : '%d'}\n"
				, nowBook.bookIndex, nowBook.bookName
				, nowBook.bookAuthor, nowBook.bookPublicationYear);
	}

}
