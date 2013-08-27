package hadoop.conf;

import org.apache.hadoop.conf.Configuration;
import org.hamcrest.core.Is;
import org.junit.Assert;
import org.junit.Test;

public class ConfigurationTest {

	@Test
	public void test() {
		Configuration conf = new Configuration();
		conf.addResource("configuration-1.xml");
		Assert.assertThat(conf.get("color"), Is.is("yellow"));
	}
	

}
