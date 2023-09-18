package queue;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.function.Executable;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class QueueTest {

  @Test public void test01QueueShouldBeEmptyWhenCreated() {
    assertTrue(new Queue().isEmpty());
  }

  @Test public void test02AddElementsToTheQueue() {
    assertFalse( queueWithSomething("Something").isEmpty() );
  }

  @Test public void test03AddedElementsIsAtHead() {
    assertEquals( "Something", queueWithSomething("Something").head() );
  }

  @Test public void test04TakeRemovesElementsFromTheQueue() {
    Queue queue = queueWithSomething("Something");
    queue.take();
    assertionEmptyQueue(queue);
  }

  @Test
  public void test05TakeReturnsLastAddedObject() {
  	String addedObject = "Something";
	assertEquals(queueWithSomething(addedObject).take(), addedObject);
  }

  @Test public void test06QueueBehavesFIFO() {
	String firstAddedObject = "First";
	String secondAddedObject = "Second";
	Queue queue = queueWithTwoElements(firstAddedObject, secondAddedObject);

    assertEquals( queue.take(), firstAddedObject );
    assertEquals( queue.take(), secondAddedObject );
    assertionEmptyQueue(queue);
  }

  @Test public void test07HeadReturnsFirstAddedObject() {
	String firstAddedObject = "First";
	Queue queue = queueWithTwoElements(firstAddedObject, "Second");

    assertEquals( queue.head(), firstAddedObject );
  }

  @Test public void test08HeadDoesNotRemoveObjectFromQueue() {
	Queue queue = queueWithSomething("Something");
    assertEquals( 1, queue.size() );
    queue.head();
    assertEquals( 1, queue.size() );
  }

  @Test public void test09SizeRepresentsObjectInTheQueue() {
    assertEquals( 2, queueWithTwoElements("First", "Second").size() );
  }

  @Test public void test10CanNotTakeWhenThereAreNoObjectsInTheQueue() {
    assertThrowsLike(() -> new Queue().take());
  }
 
  @Test public void test09CanNotTakeWhenThereAreNoObjectsInTheQueueAndTheQueueHadObjects() {
	Queue queue = queueWithSomething("Something");
    queue.take();
    assertThrowsLike(() -> queue.take());
  }

  @Test public void test10CanNotHeadWhenThereAreNoObjectsInTheQueue() {
    assertThrowsLike(() -> new Queue().head());
  }


  private Queue queueWithSomething(String string) {
	return new Queue().add( string );
  }

  private Queue queueWithTwoElements(String firstAddedObject, String secondAddedObject) {
	Queue queue = queueWithSomething(firstAddedObject);
	queue.add( secondAddedObject );
	return queue;
  }

  private void assertionEmptyQueue(Queue queue) {
	assertTrue( queue.isEmpty() );
  }

  private Error assertThrowsLike(Executable executable) {
	return assertThrows(Error.class, executable, Queue.EmptyQueue );
  }
}
