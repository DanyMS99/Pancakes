
public class Estado {

	private String text;
	private int idpadre;
	private int id;

	public Estado(int id, String text, int idpadre) {
		this.id = id;
		this.text = text;
		this.idpadre = idpadre;
	}

	public Estado() {
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getText() {
		return text;
	}

	public void setText(String text) {
		this.text = text;
	}

	public int getIdpadre() {
		return idpadre;
	}

	public void setIdpadre(int idpadre) {
		this.idpadre = idpadre;
	}

}
