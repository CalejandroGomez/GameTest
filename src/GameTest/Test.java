package GameTest;

import java.util.ArrayList;
import java.util.LinkedHashSet;
import java.util.Random;
import java.util.Scanner;
import java.util.Set;

public class Test {

static ArrayList<Question> PreguntasL1 = new ArrayList<Question>();	
static ArrayList<Question> PreguntasL2 = new ArrayList<Question>();	
	
	public static void main(String[] args) {
				
		//Level 1 questions
		
		String q1 = "How many days are there in a normal year??\n"
		+ "(a)365\n(b)366\n(c)180\n(d)360";
		
		String q2 = "How many colors are there in a rainbow?\n"
				+ "(a)5\n(b)7\n(c)9\n(d)18";
		String q3 = "How many sides are there in a triangle?\n"
				+ "(a)4.5\n(b)4\n(c)3\n(d)18";
		String q4 = "Which animal is called King of Jungle?\n"
				+ "(a)Lion\n(b)Tiger\n(c)Mouse\n(d)Giraffe";
		String q5 = "How many primary colors are there?\n"
				+ "(a)5\n(b)7\n(c)9\n(d)3";
		
		PreguntasL1.add(new Question(q1, "a"));
		PreguntasL1.add(new Question(q2, "b"));
		PreguntasL1.add(new Question(q3, "c"));
		PreguntasL1.add(new Question(q4, "a"));
		PreguntasL1.add(new Question(q5, "d"));
		
		// Level 2 questions
		
		
		
		String q6 = "Which is the tallest animal on the earth?\n"
				+ "(a)Elephant\n(b)ostrich\n(c)Whale\n(d)Giraffe";
				
		String q7 = "Who was the first man to walk on the moon?\n"
						+ "(a)Thoma Mann\n(b)Lance Armstrong\n(c) Neil Armstrong\n(d)Bruce Willis";
		String q8 = "Which is the fastest animal on the land?\n"
						+ "(a)Rabit\n(b)gazelle\n(c)Tiger\n(d)Cheetah";
		String q9 = "Which is the nearest star to planet earth?\n"
						+ "(a)Sun\n(b)Centauri \n(c)Moon\n(d)Mars";
		String q10 = "Which is the tallest mountain in the world?\n"
						+ "(a)Mount Everest\n(b)Burj Khalifa\n(c)Nepal\n(d)Colteger";
		
		PreguntasL2.add(new Question(q6, "d"));
		PreguntasL2.add(new Question(q7, "c"));
		PreguntasL2.add(new Question(q8, "d"));
		PreguntasL2.add(new Question(q9, "a"));
		PreguntasL2.add(new Question(q10, "a"));	
		
		
		
		
		ConectionBD c = new ConectionBD();
		c.agregar();
		
		levelUp();
		

	}
		
	
	
	
	public static int takeTest(ArrayList<Question> listaPreguntas) {
		
		ArrayList<Integer> numbers = new ArrayList<Integer>();
		int score = 0; 
		Scanner keyboardInput = new Scanner(System.in);
		
		Random random = new Random();

		
		
		
		for (int i = 0; i < listaPreguntas.size(); i++ ) {
			
			int randomValue1 = random.nextInt(listaPreguntas.size());
			while (numbers.contains(randomValue1)) {
				randomValue1 = random.nextInt(listaPreguntas.size());
		    }
			numbers.add(randomValue1);
			
			System.out.println(randomValue1); 
					
						
		      
			System.out.println(listaPreguntas.get(randomValue1).query);
			String answer = keyboardInput.nextLine();
			if(answer.equals(listaPreguntas.get(randomValue1).answer)) {
				score++;
				System.out.println("Weel Done!\n");
			}
			else{ 
				
				System.out.println("Wrong answer, the correct answer is: "+ listaPreguntas.get(randomValue1).answer); 
				return 0; 
			}
		}
		System.out.println("You got " + score + "/"+ listaPreguntas.size() ); 
			return 1;		
	}
	
	public static void levelUp() {
		
		int resultado = takeTest(PreguntasL1); 
		
		if (resultado == 1) {
			
			takeTest(PreguntasL2);			
		}
		
	}

}
