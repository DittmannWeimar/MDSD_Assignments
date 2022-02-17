package main.metamodel;

import java.util.*;

public class State {
	
	private String name;
	
	private List<Transition> transitions = new ArrayList<>();
	
	public State(String name) {
		this.name = name;
	}

	public String getName() {
		return name;
	}
	
	public void addTransition(Transition trans) {
		this.transitions.add(trans);
	}

	public List<Transition> getTransitions() {
		return transitions;
	}

	public Transition getTransitionByEvent(String string) {
		for (Transition trans : transitions) 
		{ 
		    if (trans.getEvent().equalsIgnoreCase(string)) return trans;
		}
		return null;
	}

}
