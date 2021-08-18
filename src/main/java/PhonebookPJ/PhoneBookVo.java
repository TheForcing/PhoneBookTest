package PhonebookPJ;

public class PhoneBookVo {
	private int id;
	private String name;
	private int hp;
	private int tel;
	

	public PhoneBookVo(int id, String name, int hp, int tel)
	{
	     this.id=id;
	     this.name=name;
	     this.hp=hp;
	     this.tel=tel;
	}


	public int getId() {
		return id;
	}


	public void setId(int id) {
		this.id = id;
	}


	public String getName() {
		return name;
	}


	public void setName(String name) {
		this.name = name;
	}


	public int getHp() {
		return hp;
	}


	public void setHp(int hp) {
		this.hp = hp;
	}


	public int getTel() {
		return tel;
	}


	public void setTel(int tel) {
		this.tel = tel;
	}
   
	
	
	
}
