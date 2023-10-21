package nemo;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class NemoTest {
	
  @Test public void test00CheckInitialNemoCoordinates() {
	Nemo nemo = nemoFacingWest();
	assertPosition( nemo, new Position(2,1));
	assertEquals( new West(), nemo.getDirection() );
	assertEquals( new SurfaceLevelZero(), nemo.getSurfaceLevel() );
  }
	
  @Test public void test01AcceptsEmptyCommands() {
	Nemo nemo = nemoFacingWest();
	assertEquals(nemo, nemo.Command(""));
  }
	
  @Test public void test02NemoGoesDown() {
	assertEquals(new SurfaceLevelOne(), nemoFacingWest().Command("d").getSurfaceLevel());  
  }
  
  @Test public void test03NemoGoesUp() {
	Nemo nemo = nemoFacingWest();
	nemo.Command("d");
	assertEquals(new SurfaceLevelZero(), nemo.Command("u").getSurfaceLevel());
  }
 
  @Test public void test05MultipleDownCommands() {
	assertEquals(new SurfaceLevelDepths(new SurfaceLevelOne()), nemoFacingWest().Command("dd").getSurfaceLevel());
  }
  
  @Test public void test04MultipleUpCommands() {
	Nemo nemo = nemoFacingWest();
	nemo.Command("dddddd");
	assertEquals(new SurfaceLevelOne(), nemo.Command("uuuuu").getSurfaceLevel());
  }

  @Test public void test06GoingUpInSurfaceZeroStaysInSurfaceZero() {
	assertEquals(new SurfaceLevelZero(), nemoFacingWest().Command("uuuuuu").getSurfaceLevel());
  }
 
  @Test public void test07ForwardFacingNorth() {
	assertPosition(nemoFacingNorth().Command("f"), new Position(2,2));
  }
  
  @Test public void test08ForwardFacingSouth() {
	assertPosition(nemoFacingSouth().Command("f"), new Position(2,0));
  }
  
  @Test public void test09ForwardFacingWest() {
	assertPosition(nemoFacingWest().Command("f"), new Position(1,1));
  }
  
  @Test public void test10ForwardFacingEast() {
	assertPosition(nemoFacingEast().Command("f"), new Position(3,1));
  }
  
  @Test public void test11MultipleForwardCommands() {
	assertPosition(nemoFacingWest().Command("ffff"), new Position(-2,1));
  }
  
  @Test public void test12NorthTurnsRightSuccesfully() {
	assertEquals(new East(), nemoFacingNorth().Command("r").getDirection());
  }
  
  @Test public void test13SouthTurnsRightSuccesfully() {
	assertEquals(new West(), nemoFacingSouth().Command("r").getDirection());
  }
  
  @Test public void test14WestTurnsRightSuccesfully() {
	assertEquals(new North(), nemoFacingWest().Command("r").getDirection());
  }
  
  @Test public void test15EastTurnsRightSuccesfully() {
	assertEquals(new South(), nemoFacingEast().Command("r").getDirection());
  }
  @Test public void test12NorthTurnsLeftSuccesfully() {
	assertEquals(new West(), nemoFacingNorth().Command("l").getDirection());
  }
  
  @Test public void test13SouthTurnsLeftSuccesfully() {
	assertEquals(new East(), nemoFacingSouth().Command("l").getDirection());
  }
  
  @Test public void test14WestTurnsLeftSuccesfully() {
	assertEquals(new South(), nemoFacingWest().Command("l").getDirection());
  }
  
  @Test public void test15EastTurnsLeftSuccesfully() {
	assertEquals(new North(), nemoFacingEast().Command("l").getDirection());
  }
  
  @Test public void testMultipleRightRotationCommands() {
	assertEquals(new South(), nemoFacingEast().Command("rrrrr").getDirection());
  }
  
  @Test public void testMultipleLeftRotationCommands() {
	assertEquals(new West(), nemoFacingEast().Command("llllll").getDirection());
  }
  
  @Test public void test16ReleasingCapsuleDoesNotAffectSubmarine() {
	Nemo nemo = nemoFacingWest();
	nemo.Command("m");
	assertPosition(nemo, new Position(2,1));
	assertEquals(nemo.getDirection(), new West());
	assertEquals(nemo.getSurfaceLevel(), new SurfaceLevelZero());
  }
  
  @Test public void test17ThrowingCapsuleInSurfaceBelowOneExplodesTheSubmarine() {
	Nemo nemo = nemoFacingWest();
	nemo.Command("ddd");
	assertEquals(Nemo.Boooooooooom, assertThrows(RuntimeException.class, () -> nemo.Command("m")).getMessage());
  }
  
  @Test public void test18GettingInDepthsAndComingBackInCorrectSurface() {
	Nemo nemo = nemoFacingWest();
	nemo.Command("ddddd");
	nemo.Command("uuuu");
	assertEquals(new SurfaceLevelOne(), nemo.getSurfaceLevel());
  }
  
  @Test public void test19GetDepthInDepthsWorksCorrectly() {
	Nemo nemo = nemoFacingWest();
	nemo.Command("dudddddu");
	assertEquals(4, nemo.getSurfaceLevel().getDepthLevel());
  }
  
  @Test public void test20GetDepthInSurfaceOneWorksCorrectly() {
	Nemo nemo = nemoFacingWest();
	nemo.Command("dud");
	assertEquals(1, nemo.getSurfaceLevel().getDepthLevel());
  }
  
  @Test public void test21GetDepthInSurfaceZeroWorksCorrectly() {
	Nemo nemo = nemoFacingWest();
	nemo.Command("uuuduu");
	assertEquals(0, nemo.getSurfaceLevel().getDepthLevel());
  }
  
  private Nemo nemoFacingNorth() {
	return new Nemo(new Position(2,1), new North());}
  
  private Nemo nemoFacingWest() {
	return new Nemo(new Position(2,1),new West()); }
  
  private Nemo nemoFacingEast() {
	return new Nemo(new Position(2,1), new East()); }
  
  private Nemo nemoFacingSouth() {
	return new Nemo(new Position(2,1), new South()); }
  
  private void assertPosition(Nemo nemo, Position position) {
	assertEquals(position.getX(), nemo.getPosition().getX());
	assertEquals(position.getY(), nemo.getPosition().getY()); }
  
}