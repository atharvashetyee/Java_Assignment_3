import java.util.*;

class Book{
	String title;
	String author;
	int isbn;
	Book(String title,String author,int isbn){
		this.title=title;
		this.author=author;
		this.isbn=isbn;
	}
	public String getTitle() {
		return title;
	}
	public String getAuthor() {
		return author;
	}
	public int getIsbn() {
		return isbn;
	}
	void display() {
		System.out.println("Book name:" +title+ "Book author:"+ author+ "Isbn:"+isbn);
	}
}

class Library{
	private ArrayList<Book> books;
	Library(){
		books=new ArrayList<>();
	}
	
	//add
	public void addBook(Book book) {
		books.add(book);
		System.out.println("Book added");
		
	}
	
	//remove book
	public void removeBook(int isbn) {
		Iterator<Book> iterator=books.iterator();
		boolean found=false;
		while(iterator.hasNext()) {
			Book book=iterator.next();
			if(book.isbn==isbn) {
				iterator.remove();
				System.out.println("Removed");
				found=true;
			}
			
		}
		if(!found) {
			System.out.println("No such isbn");
		}
	}
	
	//search
	public void searchBook(String title) {
		boolean found=false;
		for(Book book:books) {
			if(book.getTitle().equalsIgnoreCase(title)) {
				book.display();
				found=true;
			}
		}
		if(!found) {
			System.out.println("No such book");
		}
	}
	
	//display all
	public void DisplayAll() {
		if(books.isEmpty()) {
			System.out.println("No book in library");
		}
		else {
		for(Book book:books) {
			book.display();
			}
		}
	
	}
}
public class LibMgm {
	public static void main(String[]args) {
		Library lb=new Library();
		Scanner sc=new Scanner(System.in);
		
		while(true) {
			System.out.println("Welcome");
			System.out.println("1.Add");
			System.out.println("2.Remove");
			System.out.println("3.Search");
			System.out.println("4.List all");
			System.out.println("5.exit");
			System.out.println("Enter Choice");
			
			int choice=sc.nextInt();
			sc.nextLine();
			
			switch(choice) {
			case 1:
				System.out.println("Enter title");
				String title=sc.nextLine();
				System.out.println("author");
				String author=sc.nextLine();
				System.out.println("isbn");
				int isbn=sc.nextInt();
				Book book=new Book(title,author,isbn);
				lb.addBook(book);
				break;
			case 2:
				System.out.println("isbn");
				int removeisbn=sc.nextInt();
				sc.nextLine();
				lb.removeBook(removeisbn);
				break;
			case 3:
				System.out.println("Enter title");
				String newtitle=sc.nextLine();
				lb.searchBook(newtitle);
				break;
			case 4:
				lb.DisplayAll();
				break;
			case 5:
				System.out.println("Exit");
				sc.close();
				break;
			default:
				System.out.println("Invalid input");
			}
		}
		
	}

}
