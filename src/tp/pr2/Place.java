package tp.pr2;
import java.util.*;

public class Place {
	private String name;
	private boolean isSpaceShip;
	private String description;
	//private ItemContainer container;
	private ArrayList<Item> item;

	public Place(java.lang.String name, boolean isSpaceShip, java.lang.String description){
		this.description = description;
		this.name = name;
		this.isSpaceShip = isSpaceShip;
		this.item= new ArrayList<Item>();
		//this.container = new ItemContainer ();
	}
	
	public boolean isSpaceship (){
		return this.isSpaceShip;
	}
	public Item getItem(java.lang.String id){
		Item item = null;
		boolean encontrado = false;
		int i=0;
		
		while ( !encontrado && i < this.item.size()){
			
			if ( this.item.get(i).equals(id))
			{
				item = this.item.get(i);
				encontrado = true;
			}
			else{
				i++;
			}
			
			return item;
		}
		
		return item;
	}
	
	public Item pickItem(java.lang.String id){
		Item it = null;
		boolean encontrado = false;
		int i =0;
		if(this.existItem(id)){
			while(i < this.item.size() && !encontrado){
				it = this.item.get(i);
				if(it.getId().equalsIgnoreCase(id)){
					encontrado = true;
					this.item.remove(i);
					//this.item.get(i).setTimes(1);
				}
				i++;			
			}
		}
			return it;	
	}

	public void removeItem(Item item){
		int i=0;
		while (this.item.get(i)!=item){
			i++;
		}
		this.item.remove(i);
		
	}
	
	public boolean existItem(String id){//Mira a ver si existe un item con ese id en la lista de objetos de place
		boolean bool=false;
		Item aux;
		int i=0;
		
		while( i < this.item.size() && !bool){
			aux = this.item.get(i);
			if (aux.id.equalsIgnoreCase(id)){
				bool = true;
			}
			i++;
		}
		
		return bool;
	}
	
	public boolean addItem(Item it){//Intenta a�adir un item a un lugar.la operacion falla, si place ya contiene un item con el mismo nombre.
		boolean bool = true;
		boolean menor = false;
		int i = 0;
		
		while ( !menor && i < this.item.size() && bool){
			if ( it.menor(this.item.get(i).id)){
				menor = true;
			}
			else if (existItem(it.id))
			{
				bool = false;
			}
			else{
				i++;
			}
		}
		if (bool){
			if ( i == 0){
				this.item.add(0, it);
			}
			else
			{
				for ( int j = this.item.size(); j > i; j--){
					this.item.add(j, this.item.get(j-1));
				}
				this.item.add(i, it);
				
			}
		}
		return bool;

	}
	
	public java.lang.String toString(){ //Devuelve el nombre, la descripcion y la lista de los items que contiene el lugar
		String LINE_SEPARATOR = System.getProperty("line.separator");
		String st = this.name.toString() + LINE_SEPARATOR +  this.description.toString() + LINE_SEPARATOR;
		st += "The place contains these objects: " + LINE_SEPARATOR + "   ";
		for (int i = 0; i < this.item.size(); i++){
			st = st + this.item.get(i).id + LINE_SEPARATOR + "   ";
		}
		return st;
	}

}
