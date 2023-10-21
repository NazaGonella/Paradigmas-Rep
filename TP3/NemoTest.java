package nemo;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.Test;

public class NemoTest {
	
  @Test public void test00CheckInitialNemoCoordinates() {
	assertEquals( new Nemo(new Position(2,1),new West()).getPosition().getX(), new Position(2,1).getX() );
	assertEquals( new Nemo(new Position(2,1),new West()).getPosition().getY(), new Position(2,1).getY() );
	assertEquals( new West(), new Nemo(new Position(2,1),new West()).getDirection() );
	assertEquals( new SurfaceLevelZero(), new Nemo(new Position(2,1),new West()).getSurfaceLevel() );
  }
	
  @Test public void test01AcceptsEmptyCommands() {
	Nemo expected = new Nemo(new Position( 0, 1), new West());
    Nemo actual = expected.Command("");
	assertEquals(expected,actual);
  }

  @Test public void test02NemoGoesUp() {
	assertEquals(new Nemo(new Position(2, 1), new West()).getSurfaceLevel(),new Nemo(new Position(2, 1), new West()).Command("uu").getSurfaceLevel());
  }
	
  @Test public void test03NemoGoesDown() {
	assertEquals(new SurfaceLevelOne(),new Nemo(new Position(2, 1), new West()).Command("d").getSurfaceLevel());  
  }
	
  @Test public void test04MultipleUpCommands() {
	assertEquals(new Nemo(new Position(2, 1), new West()).getSurfaceLevel(),new Nemo(new Position(2, 1), new West()).Command("uu").getSurfaceLevel());
  }
 
  @Test public void test05MultipleDownCommands() {
	assertEquals(new SurfaceLevelDepths(new SurfaceLevelOne()),new Nemo(new Position(2, 1),  new West()).Command("dd").getSurfaceLevel());
  }

  @Test public void test06GoingUpInSurfaceZeroStaysInSurfaceZero() {
	assertEquals(new SurfaceLevelZero(), new Nemo(new Position(2, 1),new West()).Command("uuuuuu").getSurfaceLevel());
  }
 
  @Test public void test07ForwardFacingNorth() {
	Nemo nemo = new Nemo(new Position(2,1), new North());
	nemo.Command("f");
	assertEquals(2, nemo.getPosition().getX());
	assertEquals(2, nemo.getPosition().getY());
  }
  
  @Test public void test08ForwardFacingSouth() {
	//assertEquals(new Nemo(new Position(3,0), new South()).getPosition(), new Nemo(new Position(3,1), new South()).Command("f").getPosition());
	Nemo nemo = new Nemo(new Position(2,1), new South());
	nemo.Command("f");
	assertEquals(2, nemo.getPosition().getX());
	assertEquals(0, nemo.getPosition().getY());
  }
  
  @Test public void test09ForwardFacingWest() {
	//assertEquals(new Nemo(new Position(2,1), new West()).getPosition(), new Nemo(new Position(3,1), new West()).Command("f").getPosition());
	Nemo nemo = new Nemo(new Position(2,1), new West());
	nemo.Command("f");
	assertEquals(1, nemo.getPosition().getX());
	assertEquals(1, nemo.getPosition().getY());
  }
  
  @Test public void test10ForwardFacingEast() {
	//assertEquals(new Nemo(new Position(4,1), new East()).getPosition(), new Nemo(new Position(3,1), new East()).Command("f").getPosition());
	Nemo nemo = new Nemo(new Position(2,1), new East());
	nemo.Command("f");
	assertEquals(3, nemo.getPosition().getX());
	assertEquals(1, nemo.getPosition().getY());
  }
  
  @Test public void test11MultipleForwardCommands() {
	//assertEquals(new Nemo(new Position(3,3), new North()).getPosition(), new Nemo(new Position(3,1), new North()).Command("ff").getPosition());
	Nemo nemo = new Nemo(new Position(2,1), new West());
	nemo.Command("ffff");
	assertEquals(-2, nemo.getPosition().getX());
	assertEquals(1, nemo.getPosition().getY());
  }
  
  @Test public void test12NorthTurnsRightSuccesfully() {
	assertEquals(new East(), new Nemo(new Position(2,1), new North()).Command("r").getDirection());
  }
  
  @Test public void test13SouthTurnsRightSuccesfully() {
	assertEquals(new West(), new Nemo(new Position(2,1), new South()).Command("r").getDirection());
  }
  
  @Test public void test14WestTurnsRightSuccesfully() {
	assertEquals(new North(), new Nemo(new Position(2,1), new West()).Command("r").getDirection());
  }
  
  @Test public void test15EastTurnsRightSuccesfully() {
	assertEquals(new South(), new Nemo(new Position(2,1), new East()).Command("r").getDirection());
  }
  
  @Test public void testMultipleRightRotationCommands() {
	assertEquals(new South(), new Nemo(new Position(2,1), new East()).Command("rrrrr").getDirection());
  }
  
  @Test public void testMultipleLeftRotationCommands() {
	assertEquals(new West(), new Nemo(new Position(2,1), new East()).Command("llllll").getDirection());
  }
  
  @Test public void test16ReleasingCapsuleDoesNotAffectSubmarine() {
	Nemo nemo = new Nemo(new Position(2,1), new West());
	nemo.Command("m");
	assertEquals(nemo.getPosition().getX(), 2);
	assertEquals(nemo.getPosition().getY(), 1);
	assertEquals(nemo.getDirection(), new West());
	assertEquals(nemo.getSurfaceLevel(), new SurfaceLevelZero());
  }
  
  @Test public void test17ThrowingCapsuleInSurfaceBelowOneExplodesTheSubmarine() {
	Nemo nemo = new Nemo(new Position(2,1), new West());
	nemo.Command("ddd");
	assertThrows(RuntimeException.class, () -> nemo.Command("m"));
  }
  
  @Test public void test18GettingInDepthsAndComingBackInCorrectSurface() {
	Nemo nemo = new Nemo(new Position(2,1),new West());
	nemo.Command("ddddd");
	nemo.Command("uuuu");
	assertEquals(new SurfaceLevelOne(), nemo.getSurfaceLevel());
  }
  
  @Test public void test19GetDepthInDepthsWorksCorrectly() {
	Nemo nemo = new Nemo(new Position(2,1),new West());
	nemo.Command("dudddddu");
	assertEquals(4, nemo.getSurfaceLevel().getDepthLevel());
  }
  
  @Test public void test20GetDepthInSurfaceOneWorksCorrectly() {
	Nemo nemo = new Nemo(new Position(2,1),new West());
	nemo.Command("dud");
	assertEquals(1, nemo.getSurfaceLevel().getDepthLevel());
  }
  
  @Test public void test21GetDepthInSurfaceZeroWorksCorrectly() {
	Nemo nemo = new Nemo(new Position(2,1),new West());
	nemo.Command("uuuduu");
	assertEquals(0, nemo.getSurfaceLevel().getDepthLevel());
  }
  
}