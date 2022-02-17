package main.metamodel;

import java.util.*;

public class Machine {
	
	private List<State> states = new ArrayList<>();
	private State initial;
	private Map<String, Integer> variables = new HashMap<>();
	
	public Machine(Collection<State> collection, State initial, Collection<String> variables) {
		this.states.addAll(collection);
		this.initial = initial;
		for (String variable : variables) {
			this.variables.put(variable, 0);
		}
	}

	public List<State> getStates() {
		return states;
	}

	public State getInitialState() {
		return initial;
	}

	public State getState(String string) {
		for (State state : states) 
		{ 
		    if (state.getName().equalsIgnoreCase(string)) return state;
		}
		return null;
	}
	
	public int numberOfIntegers() {
		return variables.size();
	}

	public boolean hasInteger(String string) {
		return variables.containsKey(string);
	}

	public void SetVariable(String string, int value) {
		variables.replace(string, value);
	}
	
	public int getVariable(String name) {
		return variables.get(name);
	}
}
