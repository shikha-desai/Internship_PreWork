import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collection;

public class CollectionMemoryTest {

	public static void main(String[] args) {
		
			BufferedReader reader = new BufferedReader(
					new InputStreamReader(
							CollectionMemoryTest.class.getResourceAsStream("persons_data.txt")));

			Collection<Person> persons = new ArrayList<Person>();
			
			Collection<String> lines = new ArrayList<String>();
			
			try {
				String line;
				while((line = reader.readLine()) != null) {
					lines.add(line);
					/*String[] array = line.split(", ");
					Person p = new Person(
							Integer.parseInt(array[0]),
							array[1],
							array[3],
							array[9],
							array[13]);
					persons.add(p);
					try {
						Thread.sleep(10);
					} catch (InterruptedException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
					System.out.println(p);
					*/
					
				}
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			try {
				Thread.sleep(10000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
	}

}
