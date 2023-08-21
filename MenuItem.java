package cafe.entity;



import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;


@Entity
public class MenuItem {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String menuName;
    private String description;
    public MenuItem(Long id, String menuName, String description, String price, String category) {
		super();
		this.id = id;
		this.menuName = menuName;
		this.description = description;
		this.price = price;
		this.category = category;
		
	}
	private String price;
    private String category;
   
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getMenuName() {
		return menuName;
	}
	public void setMenuName(String menuName) {
		this.menuName = menuName;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public String getPrice() {
		return price;
	}
	public void setPrice(String price) {
		this.price = price;
	}
	public String getCategory() {
		return category;
	}
	public void setCategory(String category) {
		this.category = category;
	}
	  
	@Override
	public String toString() {
		return "MenuItem [id=" + id + ", menuName=" + menuName + ", description=" + description + ", price=" + price
				+ ", category=" + category + "]";
	}
	public MenuItem() {
		super();
		// TODO Auto-generated constructor stub
	}
}

