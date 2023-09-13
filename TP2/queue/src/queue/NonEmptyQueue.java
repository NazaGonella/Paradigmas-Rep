package queue;

import java.util.List;

public class NonEmptyQueue extends State {

	@Override
	public Object take(List<Object> list) {
		// TODO Auto-generated method stub
		return list.remove(0);
	}

	@Override
	public Object head(List<Object> list) {
		// TODO Auto-generated method stub
		return list.get(0);
	}

}
