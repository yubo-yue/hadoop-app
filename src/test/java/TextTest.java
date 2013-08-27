import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

import java.io.UnsupportedEncodingException;

import org.apache.hadoop.io.Text;
import org.hamcrest.core.Is;
import org.junit.Assert;
import org.junit.Test;

public class TextTest {

	@Test
	public void test() {
		Text t = new Text("hadoop");
		Assert.assertThat(t.getLength(), Is.is(6));
		Assert.assertThat(t.getBytes().length, Is.is(6));

		Assert.assertThat(t.charAt(2), Is.is((int) 'd'));
	}

	@Test
	public void string() throws UnsupportedEncodingException {
		String s = "\u0041\u00DF\u6771\uD801\uDC00";
		assertThat(s.length(), Is.is(5));
		assertThat(s.getBytes("UTF-8").length, Is.is(10));
		assertThat(s.indexOf("\u0041"), is(0));
		assertThat(s.indexOf("\u00DF"), is(1));
		assertThat(s.indexOf("\u6771"), is(2));
		assertThat(s.indexOf("\uD801\uDC00"), is(3));
		assertThat(s.charAt(0), is('\u0041'));
		assertThat(s.charAt(1), is('\u00DF'));
		assertThat(s.charAt(2), is('\u6771'));
		assertThat(s.charAt(3), is('\uD801'));
		assertThat(s.charAt(4), is('\uDC00'));

		assertThat(s.codePointAt(0), is(0x0041));
		assertThat(s.codePointAt(1), is(0x00DF));
		assertThat(s.codePointAt(2), is(0x6771));
		assertThat(s.codePointAt(3), is(0x10400));
	}

	@Test
	public void text()
	{
		Text t = new Text("\u0041\u00DF\u6771\uD801\uDC00");
		
		assertThat(t.getLength(), is(10));
		
		assertThat(t.find("\u0041"), is(0));
		assertThat(t.find("\u00DF"), is(1));
		assertThat(t.find("\u6771"), is(3));
		assertThat(t.find("\uD801\uDC00"), is(6));
		assertThat(t.charAt(0), is(0x0041));
		assertThat(t.charAt(1), is(0x00DF));
		assertThat(t.charAt(3), is(0x6771));
		assertThat(t.charAt(6), is(0x10400));
	}
}
