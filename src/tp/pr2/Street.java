package tp.pr2;

public class Street {
	private Place source;
	private Place target;
	private Direction direction;
	private boolean isOpen;
	private java.lang.String code;

	public Street (Place source, Direction direction, Place target){
		this.direction = direction;
		this.target = target;
		this.source = source;
		this.isOpen = true;
		
	}
	
	public Street (Place source, Direction direction, Place target, boolean isOpen, java.lang.String code ){
		this.source=source;
		this.direction=direction;
		this.target=target;
		this.isOpen = isOpen;
		this.code = code;
	}
	
	public boolean comeOutFrom(Place place, Direction whichDirection){ //Mira a ver si la calle sale de un lugar en la dir dada
		boolean isValid= false;
		if ( whichDirection == this.direction && place == this.source ){
			isValid=true;
		}
		else if( whichDirection == whichDirection.dirOpuesta(this.direction) && place == this.target){
			isValid =true;
		}
		else {
			isValid = false;
		}
		return isValid;
	}
	
	public Place nextPlace ( Place whereAmI){//Devuelve el lugar del otro lado del lugar whereAmI
		Place place = null;
		
		if ( whereAmI == this.source ){
			
			place = this.target;
		}
		else if ( whereAmI == this.target ){
			place = this.source;
		}
		else {
			place = null;
		}
		return place;
	}
	public boolean isOpen(){ //Mira si la calle est� abierta		
		return isOpen;
	}
	public boolean open(CodeCard card){//Intenta abrir la puerta usando la codeCard	
		boolean bool= false;
		if(this.code==card.getCode()){
			bool=true;
			this.isOpen=true;
		}
		return bool;
	}
	public boolean close(CodeCard card){
		boolean bool=false;
		if(this.code==card.getCode()){
			bool=true;
			this.isOpen=false;
		}
		return bool;
	}
	public Direction getDirection() {
		return direction;
	}
	public String getCodigo() {
		// TODO Auto-generated method stub
		return this.code;
	}
	
}
