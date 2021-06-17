package timBookStore;

public class Book {
	private int id;
	private String name;
	private String author;
	private String publishDate;
	private double buy;
	private double sell;
	private int amount;
	
	public Book(int ID, String Name, String Author, String PublishDate, double Buy, double Sell, int Amount){
		this.id = ID;
		this.name =Name;
		this.author = Author;
		this.publishDate = PublishDate;
		this.buy = Buy;
		this.sell = Sell;
		this.amount =Amount;			
	}
	
	public int getID() {
		return id;
	}
	public String getName() {
		return name;
	}
	public String getAuthor() {
		return author;
	} 
	public String getPublishDate() {
		return publishDate;
	}
	public double getBuy() {
		return buy;
	}
	public double getSell() {
		return sell;
	}
	public int getAmount() {
		return amount;
	}
}
