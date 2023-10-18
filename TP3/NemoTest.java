package nemo;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;

public class NemoTest {
	
  @Test public void test00CheckInitialNemoCoordinates() {
	int[] position= {0,0};
	assertArrayEquals( new Nemo(new Position(0,0),new West()).getCoordenadas().position(), position );
	assertEquals( new West(), new Nemo(new Position(0,0),new West()).getDirection() );
  }
	
  @Test public void test01AcceptsEmptyCommands() {
	Nemo expected = new Nemo(new Position( 0, 1), new West());
    Nemo actual = expected.Command("");
	assertEquals(expected,actual);
  }

//  @Test public void test02NemoGoesUp() {
//	assertEquals(new Nemo(2, 1, 1, new West()).getCoordenadas().getZ(),new Nemo(2, 1, 2, new West()).Command("u").getCoordenadas().getZ());
//  }
	
//  @Test public void test03NemoGoesDown() {
//	assertEquals(new Nemo(2, 1, 3, new West()).getCoordenadas().getZ(),new Nemo(2, 1, 2, new West()).Command("d").getCoordenadas().getZ());  
//  }
//	
//  @Test public void test04AcceptsSeveralUpCommands() {
//	assertEquals(new Nemo(3, 1, 0, new West()).getCoordenadas().getZ(),new Nemo(3, 1, 2, new West()).Command("uu").getCoordenadas().getZ());
//  }
//  
//  @Test public void test05AcceptsSeveralDownCommands() {
//	assertEquals(new Nemo(3, 1, 4, new West()).getCoordenadas().getZ(),new Nemo(3, 1, 2, new West()).Command("dd").getCoordenadas().getZ());
//  }
//  
//  @Test public void test06CantInitializeNemoPorEncimaSuperficie() {
//	assertThrows(RuntimeException.class, () -> new Nemo(0,0,-1,new West()));
//  }
//  @Test public void test07NemoGoingUpTooMuchThrowsException() {
//	Nemo nemo = new Nemo(0,0,2,new West());
//	assertThrows(RuntimeException.class, () -> nemo.Command("uuu"));
//	assertEquals(0, nemo.getCoordenadas().getZ());
//  }
  @Test public void test08ForwardFacingNorth() {
	assertArrayEquals(new Nemo(new Position(3,2), new North()).getCoordenadas().position(), new Nemo(new Position(3,1), new North()).Command("f").getCoordenadas().position());
  }
  @Test public void test09ForwardFacingNorth() {
	assertArrayEquals(new Nemo(new Position(3,0), new South()).getCoordenadas().position(), new Nemo(new Position(3,1), new South()).Command("f").getCoordenadas().position());
  }
  @Test public void test10ForwardFacingNorth() {
	assertArrayEquals(new Nemo(new Position(2,1), new West()).getCoordenadas().position(), new Nemo(new Position(3,1), new West()).Command("f").getCoordenadas().position());
  }
  @Test public void test11ForwardFacingNorth() {
	assertArrayEquals(new Nemo(new Position(4,1), new East()).getCoordenadas().position(), new Nemo(new Position(3,1), new East()).Command("f").getCoordenadas().position());
  }
  @Test public void test12ForwardFacingNorth() {
	assertArrayEquals(new Nemo(new Position(3,3), new North()).getCoordenadas().position(), new Nemo(new Position(3,1), new North()).Command("ff").getCoordenadas().position());
  }
//  @Test public void test14WrongDirectionThrowsException() {
//	assertThrows(RuntimeException.class, () -> new Nemo(new Position(3,1),"Noroeste").Command("f"));
//  }
  @Test public void test15NorthTurnsRightSuccesfully() {
	assertEquals(new East(), new Nemo(new Position(3,1), new North()).Command("r").getDirection());
  }
  @Test public void test16SouthTurnsRightSuccesfully() {
	assertEquals(new West(), new Nemo(new Position(3,1), new South()).Command("r").getDirection());
  }
  @Test public void test17WestTurnsRightSuccesfully() {
	assertEquals(new North(), new Nemo(new Position(3,1), new West()).Command("r").getDirection());
  }
  @Test public void test18EastTurnsRightSuccesfully() {
	assertEquals(new South(), new Nemo(new Position(3,1), new East()).Command("r").getDirection());
  }
}
