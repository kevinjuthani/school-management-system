import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.InputStreamReader;
import java.util.Arrays;

public class TestMain {

	public static void main(String[] args) {
		try {

//			String prg = "import sys\nprint int(sys.argv[1])+int(sys.argv[2])\n";
//			BufferedWriter out = new BufferedWriter(new FileWriter("test1.py"));
//			out.write(prg);
//			out.close();
			int number1 = 4;
			int number2 = 32;

			// ProcessBuilder pb = new
			// ProcessBuilder(Arrays.asList("C:\\Users\\LENOVO\\AppData\\Local\\Programs\\Python\\Python39\\python",
			// "E:\\Eclipse\\Test\\src\\test1.py", "" + number1, "" + number2));

			ProcessBuilder pb = new ProcessBuilder("python", "E:\\Eclipse\\Test\\pyfiles\\MarksRemarks.py", "" + number1,
					"" + number2);
			Process p = pb.start();

			BufferedReader in = new BufferedReader(new InputStreamReader(p.getInputStream()));
			String s = "";
			while ((s= in.readLine()) != null) {
				//String ret = in.readLine();
				System.out.println("value is : " + s);
			}
		} catch (Exception e) {
			System.out.println(e);
		}

	}

}