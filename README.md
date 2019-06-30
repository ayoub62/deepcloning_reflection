
# Implementing Deep Cloning using Reflection

*There are too many libraries out there that were too hard to customize to my requirements and were too slow, so I decided to make my own*

**prerequisite**

 1. Use wrapper classes of primitives types
 2. Use a default constructor with super()
 3. Use getters and setters
 4. Extend the Cloneable class
 
 **Example**
 
 public class Hero extends Cloneable{
	
	private String name;

	public Hero() {
		super();
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
}

**Driver class**

import com.ayoub.me.Cloner;

import models.Hero;

public class Main {

	public static void main(String[] args) throws Exception {
		Hero hero = new Hero();
		hero.setName("Ayoub");
		Hero cloned = (Hero) Cloner.solve(hero);
		System.out.println(cloned.getName());
	}
}



> Feel free to fork and take it from here

***
