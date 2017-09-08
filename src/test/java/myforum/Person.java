package myforum;

public class Person {

	private Integer id_card;
	private String name;
	public Integer getId_card() {
		return id_card;
	}
	public void setId_card(Integer id_card) {
		this.id_card = id_card;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	
	
	public Person(){
		
	}
	
	public Person(String name,Integer id_card){
		this.name = name;
		this.id_card = id_card;
	}
	
}
