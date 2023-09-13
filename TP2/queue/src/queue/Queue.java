package queue;

import java.util.ArrayList;
import java.util.List;

public class Queue {

  private List<Object> objetos = new ArrayList<>();
  
  public static String EmptyQueue = "Queue is empty";
  
  private State state = new EmptyQueue();
  private List<State> stateHistory = new ArrayList<>();
  
	
	public boolean isEmpty() {
	  	return objetos.isEmpty();
	}
	
	public Queue add( Object  cargo ) {
		objetos.add(cargo);
		stateHistory.add(state);
		state = new NonEmptyQueue();
		return this;
	}
	
	public Object take() {
		Object takenObject = state.take(objetos);
		state = stateHistory.remove(stateHistory.size() - 1);
		return takenObject;
	}
	
	public Object head() {
		return state.head(objetos);
	}
	
	public int size() {
		return objetos.size();
	}

}
