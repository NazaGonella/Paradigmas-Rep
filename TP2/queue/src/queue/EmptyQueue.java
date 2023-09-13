package queue;

import java.util.List;

public class EmptyQueue extends State {

	@Override
	public Object take(List<Object> list) {
		throw new Error(Queue.EmptyQueue);
	}

	@Override
	public Object head(List<Object> list) {
		// TODO Auto-generated method stub
		throw new Error(Queue.EmptyQueue);
	}

}
