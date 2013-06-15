import org.apache.hadoop.io.BytesWritable;
import org.hamcrest.core.Is;
import org.junit.Assert;
import org.junit.Test;


public class BytesWritableTest {

	@Test
	public void test() {
		BytesWritable b = new BytesWritable(new byte[] {3, 5});
		
		b.setCapacity(11);
		Assert.assertThat(b.getLength(), Is.is(2));
		Assert.assertThat(b.getBytes().length, Is.is(11));
	}

}
