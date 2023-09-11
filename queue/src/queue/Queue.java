package queue;

import java.util.ArrayList;
import java.util.List;

public class Queue {

  private List<Object> objetos = new ArrayList<>();
  
  public static String EmptyQueue = "Queue is empty";
  
  private State state = new EmptyQueue();
  private State statePrev = null;
  
	
	public boolean isEmpty() {
	  	return objetos.isEmpty();
	}
	
	public Queue add( Object  cargo ) {
		objetos.add(cargo);
		statePrev = state;
		state = new NonEmptyQueue();
		return this;
	}
	
	public Object take() {
		
		Object takenObject = state.take(objetos);
		state = statePrev;
		return takenObject;
	}
	
	public Object head() {
		return state.head(objetos);
	}
	
	public int size() {
		return objetos.size();
	}

}
