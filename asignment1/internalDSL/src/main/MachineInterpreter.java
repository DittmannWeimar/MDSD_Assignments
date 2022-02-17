package main;

import main.metamodel.*;

public class MachineInterpreter {
	
	private Machine machine;
	private State currentState;
	
	public void run(Machine m) {
		this.machine = m;
		this.currentState = machine.getInitialState();
	}

	public State getCurrentState() {
		return currentState;
	}

	public void processEvent(String string) {
		for (Transition trans: currentState.getTransitions()) {
			if(trans.getEvent().equalsIgnoreCase(string)) {
				
				boolean shouldTransition = trans.isConditional()? isConditionTrue(trans) : true;
				if (shouldTransition) {
					processOperation(trans);
					currentState = trans.getTarget();
					break;
				}
			}
		}
	}
	
	private void processOperation(Transition trans) {
		
		String operationVariableName = trans.getOperationVariableName();
		if (trans.hasSetOperation()) {
			machine.SetVariable(operationVariableName, trans.getOperationVariableValue());
		}
		
		if (trans.hasIncrementOperation()) {
			machine.SetVariable(operationVariableName, machine.getVariable(operationVariableName)+1);
			
		}
		
		if (trans.hasDecrementOperation()) {
			machine.SetVariable(operationVariableName, machine.getVariable(operationVariableName)-1);
		}
	}
	
	private boolean isConditionTrue(Transition trans) {
		int machineVaribleValue = machine.getVariable(trans.getConditionVariableName());
		int coditionVariableValue = trans.getConditionComparedValue();
		
		if (trans.isConditionEqual() 
				&& machineVaribleValue == coditionVariableValue) {
			return true;
		} else if (trans.isConditionGreaterThan() 
				&& machineVaribleValue > coditionVariableValue) {
			return true;
		} else if (trans.isConditionLessThan() 
				&& machineVaribleValue < coditionVariableValue) {
			return true;
		} else {
			return false;
		}
		
	}

	public int getInteger(String string) {
		return machine.getVariable(string);
	}

}
