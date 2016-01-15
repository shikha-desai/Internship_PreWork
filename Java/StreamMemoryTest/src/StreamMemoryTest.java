import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collection;
import java.util.stream.Stream;

public class StreamMemoryTest {

	public static void main(String[] args) {
		
		BufferedReader reader = new BufferedReader(
				new InputStreamReader(
						StreamMemoryTest.class.getResourceAsStream("persons_data.txt")));

		Collection<Person> persons = new ArrayList<Person>();
		
		Stream<String> stream = reader.lines();
		
		/*stream.map(line ->
			{
				String[] array = line.split(", ");
				Person p = new Person(
					Integer.parseInt(array[0]),
					array[1],
					array[3],
					array[9],
					array[13]);
				persons.add(p);
				try {
					Thread.sleep(100);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				return p;
				}).forEach(System.out::println);
		*/
		try {
			Thread.sleep(10000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

}
