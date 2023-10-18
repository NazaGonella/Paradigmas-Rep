package nemo;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.Test;

public class NemoTest {
	
  @Test public void test00CheckInitialNemoCoordinates() {
	assertEquals( new Nemo(new Position(0,0),new West()).getPosition(), new Position(0,0) );
	assertEquals( new West(), new Nemo(new Position(0,0),new West()).getDirection() );
	assertEquals( new NivelDeSuperficie0(), new Nemo(new Position(0,0),new West()).getSurfaceLevel() );
  }
	
  @Test public void test01AcceptsEmptyCommands() {
	Nemo expected = new Nemo(new Position( 0, 1), new West());
    Nemo actual = expected.Command("");
	assertEquals(expected,actual);
  }

  @Test public void test02NemoGoesUp() {
	assertEquals(new Nemo(new Position(2, 1), new West()).getSurfaceLevel(),new Nemo(new Position(2, 1), new West()).Command("u").getSurfaceLevel());
  }
	
  @Test public void test03NemoGoesDown() {
	assertEquals(new NivelDeSuperficie1(),new Nemo(new Position(2, 1), new West()).Command("d").getSurfaceLevel());  
  }
	
 @Test public void test04AcceptsSeveralUpCommands() {
	 assertEquals(new Nemo(new Position(3, 1), new West()).getSurfaceLevel(),new Nemo(new Position(3, 1), new West()).Command("uu").getSurfaceLevel());
 }
 @Test public void test05AcceptsSeveralDownCommands() {
	 assertEquals(new NivelDeSuperficieRestante(new NivelDeSuperficie1()),new Nemo(new Position(3, 1),  new West()).Command("dd").getSurfaceLevel());
 }

 @Test public void test06GoingUpInSurfaceZeroStaysInSurfaceZero() {
	assertEquals(new NivelDeSuperficie0(), new Nemo(new Position(0, 0),new West()).Command("uuuuuu").getSurfaceLevel());
 }
  @Test public void test07ForwardFacingNorth() {
	assertEquals(new Nemo(new Position(3,2), new North()).getPosition(), new Nemo(new Position(3,1), new North()).Command("f").getPosition());
  }
  @Test public void test08ForwardFacingNorth() {
	assertEquals(new Nemo(new Position(3,0), new South()).getPosition(), new Nemo(new Position(3,1), new South()).Command("f").getPosition());
  }
  @Test public void test09ForwardFacingNorth() {
	assertEquals(new Nemo(new Position(2,1), new West()).getPosition(), new Nemo(new Position(3,1), new West()).Command("f").getPosition());
  }
  @Test public void test10ForwardFacingNorth() {
	assertEquals(new Nemo(new Position(4,1), new East()).getPosition(), new Nemo(new Position(3,1), new East()).Command("f").getPosition());
  }
  @Test public void test11ForwardFacingNorth() {
	assertEquals(new Nemo(new Position(3,3), new North()).getPosition(), new Nemo(new Position(3,1), new North()).Command("ff").getPosition());
  }
//  @Test public void test14WrongDirectionThrowsException() {
//	assertThrows(RuntimeException.class, () -> new Nemo(new Position(3,1),"Noroeste").Command("f"));
//  }
  @Test public void test12NorthTurnsRightSuccesfully() {
	assertEquals(new East(), new Nemo(new Position(3,1), new North()).Command("r").getDirection());
  }
  @Test public void test13SouthTurnsRightSuccesfully() {
	assertEquals(new West(), new Nemo(new Position(3,1), new South()).Command("r").getDirection());
  }
  @Test public void test14WestTurnsRightSuccesfully() {
	assertEquals(new North(), new Nemo(new Position(3,1), new West()).Command("r").getDirection());
  }
  @Test public void test15EastTurnsRightSuccesfully() {
	assertEquals(new South(), new Nemo(new Position(3,1), new East()).Command("r").getDirection());
  }
  @Test public void test16ThrowingCaosulaDoesNotAffectSubmarine() {
	Nemo nemo = new Nemo(new Position(3,1), new West());
	nemo.Command("m");
	assertEquals(nemo.getPosition(), new Position(3,1));
	assertEquals(nemo.getDirection(), new West());
	assertEquals(nemo.getSurfaceLevel(), new NivelDeSuperficie0());
  }
  @Test public void test17MoveAndThenThrowCapsuleInInnableSurface() {
	  assertThrows(RuntimeException.class, () -> new Nemo(new Position(3,1),new West()).Command("ddm"));
  }
  @Test public void test18MoveUpCommandWorksCorrectly() {
	  Nemo nemo = new Nemo(new Position(3,1),new West());
	  nemo.Command("ddddd");
	  nemo.Command("uuuu");
	  assertEquals(new NivelDeSuperficie1(), nemo.getSurfaceLevel());
  }
  
}