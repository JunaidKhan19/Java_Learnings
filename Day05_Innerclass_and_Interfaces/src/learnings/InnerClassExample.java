package learnings;

public class InnerClassExample {
	class Regularinner{
		private int id;
		private String departmentName;

		public int getId() {
			return id;
		}
		public void setId(int id) {
			this.id = id;
		}
		public String getDepartmentName() {
			return departmentName;
		}
		public void setDepartmentName(String departmentName) {
			this.departmentName = departmentName;
		}
	}
	
	void display() {
		class MethodLocal{
			private int number;
			private String name;

			public int getNumber() {
				return number;
			}
			public void setNumber(int number) {
				this.number = number;
			}
			public String getName() {
				return name;
			}
			public void setName(String name) {
				this.name = name;
			}
		}

		MethodLocal ml = new MethodLocal();
		ml.setNumber(1);
		ml.setName("Junaid");

		System.out.println(ml.getNumber() + " " + ml.getName());
	}
	
	static class StaticInner{
		public static void print() {
			System.out.println("static innerclass method called");
		}
	}
}
