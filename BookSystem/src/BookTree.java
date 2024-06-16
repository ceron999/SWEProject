
public class BookTree {
	public BookNode root;
	private int nowNodeNum;
	private BookNode lastNode;
	
	public BookTree(){
		root = null;
		nowNodeNum = 0;
	}
	
	public void insert(Book paramBookData) {
		
		if(!isBookDataAvailable(paramBookData)) {
			return;
		}
		
		//집어넣을 Node 생성
		BookNode nowNode = new BookNode();
		nowNode.setBookData(paramBookData);
		lastNode = root;
		
		if(root == null) {
			root = nowNode;
			nowNodeNum++;
			return;
		}
		
		//목적지 노드까지 반복하여 진행하고 null이 되면 break;
		while(lastNode != null) {
			if(paramBookData.bookIndex >= lastNode.getBookIndex()) {
				//1. rightChildNode 획인 후 null이 아니면 lastNode = rightNode
				if(lastNode.rightChildNode != null)
					lastNode = lastNode.rightChildNode;
				//2. rightChildNode 획인 후 null이면 lastNode = nowNode
				else {
					nowNode.parentNode = lastNode;
					lastNode.rightChildNode = nowNode;
					nowNodeNum++;
					lastNode = null;
					break;
				}
			}else {
				//3. left Node도 동일하게 적용
				if(lastNode.leftChildNode != null)
					lastNode = lastNode.leftChildNode;
				else {
					nowNode.parentNode = lastNode;
					lastNode.leftChildNode = nowNode;
					nowNodeNum++;
					lastNode = null;
					break;
				}
			}
		}
		
		//System.out.printf("Book{id : '%d', 제목 : '%s', 저자 : '%s', 출판년도 : '%d' 도서가 추가되었습니다.}\n"
				//,paramBookData.bookIndex, paramBookData.bookName, paramBookData.bookAuthor, paramBookData.bookPublicationYear);
	}

	//Function : paramBookData가 적절하지 않은 데이터를 표함하는지를 확인
	//if(paramBookData.내용들 == null or <0) return false 
	public boolean isBookDataAvailable(Book paramBookData){
		if(paramBookData.bookAuthor == null || 
				paramBookData.bookName == null) {
			return false;
		}
		
		if(paramBookData.bookPublicationYear < 0 || paramBookData.bookIndex < 0)
			return false;
		
		if(search_BS(paramBookData.bookIndex) != null)
			return false;
		
		return true;
	}
	
	public BookNode search_BS(int searchIndex) {
		BookNode nowNode = root;
		
		while(nowNode != null) {
			if(searchIndex == nowNode.getBookIndex()) {
				System.out.printf("%d 인덱스 존재\n", searchIndex);
				return nowNode;
			}
			
			if(searchIndex > nowNode.getBookIndex()) {
				//1. rightChildNode 획인 후 null이 아니면 lastNode = rightNode
				if(nowNode.rightChildNode != null)
					nowNode = nowNode.rightChildNode;
				//2. rightChildNode 획인 후 null이면 값 존재 x
				else 
					break;
				
			}else {
				//3. left Node도 동일하게 적용
				if(nowNode.leftChildNode != null)
					nowNode = nowNode.leftChildNode;
				else 
					break;
				
			}
		}
		
		//System.out.printf("찾는 index 존재 x\n");
		return null;
	}
	
	//출처: https://you88.tistory.com/31 [영운's 블로그:티스토리]
	public void leftInorderTraversal(BookNode node) {
        //좌측 중위 순회
        if(node == null)
            return;
        leftInorderTraversal(node.leftChildNode);
        System.out.printf("%d ", node.getBookIndex());
        leftInorderTraversal(node.rightChildNode);
    }
}
