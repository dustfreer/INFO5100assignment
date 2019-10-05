package assignment4;

public class Polymorphism {

	static abstract class MoodyObject{
		protected abstract String getMood();
		
		protected abstract void expressFeelings();
		
		public void queryMood() {
			
		}
	}

	static class SadObject extends MoodyObject{
		protected String getMood() {
			return "sad";
		}
		
		public void expressFeelings() {
			System.out.println("'wah''boo hoo''weep''sob''weep'");
		}
		
		public String toString() {
			return "Subject cries a lot";
		}

	}
	
	static class HappyObject extends MoodyObject{

		protected String getMood() {
			return "happy";
		}

		public void expressFeelings() {
			System.out.println("hehehe...hahahah...HAHAHAHAHA!!!");
		}

		public String toString() {
			return "Subject laughs a lot";
		}				
	}
	
	static class PsychiatristObject{
		private String mood;
		
		public void examine(MoodyObject moodObject) {
			System.out.println("How are you feeling today?");
			mood = moodObject.getMood();
			if ( mood.equals("happy"))
				System.out.println("I feel happy today!");
			else if ( mood.equals("sad"))				
				System.out.println("I sad happy today!");				
		}
		
		public void observe(MoodyObject moodyObject) {
			moodyObject.expressFeelings();
			System.out.println("Observation: " + moodyObject.toString());
		}
	}
	
	public static void main(String[] args) {
		PsychiatristObject p = new PsychiatristObject();
		HappyObject h = new HappyObject();
		SadObject s = new SadObject();
		p.examine(h);
		System.out.println();
		p.observe(h);
		System.out.println();
		p.examine(s);
		System.out.println();
		p.observe(s);
	}
	
}
