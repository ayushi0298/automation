package selenium;
import org.testng.annotations.Test;

public class test {
	/*
	 * @Test public void demo() { System.out.println("HELLOO"); }// @Test Annotation
	 */
	//@Test priority annotation
	@Test(priority=1)
	public void a() {
		System.out.println("HELLOO");
		
	}
	@Test(priority=3)
	public void b() {
		System.out.println("HELLOO");
		
	}
	@Test(priority=2)
	public void c() {
		System.out.println("HELLOO");
		
	}
}
