package queue;

import java.util.List;

public abstract class State {

		public abstract Object take(List<Object> list) ;

		public abstract Object head(List<Object> list) ;

}
