package main;

import java.util.*;

import main.metamodel.*;

public class StateMachine {

	
	private Machine machine;
	private State currentState;
	private State initial;
	private Map<String, State> states = new HashMap<>();
	private String currentEvent;
	private Set<String> variables = new HashSet<>();
	private Transition currentTrans;
	
	
	public Machine build() {
		machine = new Machine(states.values(), initial, variables);
		return machine;
	}

	public StateMachine state(String string) {
		checkStateExists(string);
		currentState = states.get(string);
		return this;
	}
	
	private void checkStateExists(String string) {
		if (!states.containsKey(string)) {
			states.put(string, new State(string));
		}
	}

	public StateMachine initial() {
		initial  =  currentState;
		return this;
	}

	public StateMachine when(String string) {
		currentEvent = string;
		return this;
	}

	public StateMachine to(String string) {
		checkStateExists(string);
		currentTrans = new Transition(currentEvent, states.get(string));
		currentState.addTransition(currentTrans);
		
		return this;
	}

	public StateMachine integer(String string) {
		variables.add(string);
		return this;
	}

	public StateMachine set(String string, int i) {
		currentTrans.setOperationalVarible(string, i);
		return this;
	}

	public StateMachine increment(String string) {
		currentTrans.setOperationVariableName(string);
		currentTrans.setIncrementOperation(true);
		return this;
	}

	public StateMachine decrement(String string) {
		currentTrans.setOperationVariableName(string);
		currentTrans.setDecrementOperation(true);
		return this;
	}

	public StateMachine ifEquals(String string, int i) {
		currentTrans.setCoditionalValue(string, i);
		currentTrans.setEqual(true);
		return this;
	}

	public StateMachine ifGreaterThan(String string, int i) {
		currentTrans.setCoditionalValue(string, i);
		currentTrans.setGreater(true);;
		return this;
	}

	public StateMachine ifLessThan(String string, int i) {
		currentTrans.setCoditionalValue(string, i);
		currentTrans.setLess(true);
		return this;
	}

}
