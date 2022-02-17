package main.metamodel;

public class Transition {
	
	private String event;
	private State taget;
	private boolean setOperation;
	private boolean incrementOperation;
	private boolean decrementOperation;
	private boolean conditional;
	private String conditionVariableName;
	private Integer conditionComparedValue;
	private boolean hasOperation;
	private String operationVariableName;
	private Integer operationVariableValue;
	private boolean isEqual;
	private boolean isLess;
	private boolean isGreater;
	
	public Transition(String event, State state) {
		this.event = event;
		this.taget = state;
	}

	public String getEvent() {
		return event;
	}

	public State getTarget() {
		return taget;
	}

	public boolean hasSetOperation() {
		return this.setOperation;
	}

	public boolean hasIncrementOperation() {
		return this.incrementOperation;
	}

	public boolean hasDecrementOperation() {
		return this.decrementOperation;
	}

	public String getOperationVariableName() {
		return this.operationVariableName;
	}

	public boolean isConditional() {
		return this.conditional;
	}

	public String getConditionVariableName() {
		return this.conditionVariableName;
	}

	public Integer getConditionComparedValue() {
		return this.conditionComparedValue;
	}

	public boolean isConditionEqual() {
		return this.isEqual;
	}

	public boolean isConditionGreaterThan() {
		return this.isGreater;
	}

	public boolean isConditionLessThan() {
		return this.isLess;
	}

	public boolean hasOperation() {
		return this.hasOperation;
	}

	public void setIncrementOperation(Boolean incrementOperation) {
		this.incrementOperation = incrementOperation;
		this.hasOperation = true;
	}

	public void setDecrementOperation(Boolean decrementOperation) {
		this.decrementOperation = decrementOperation;
		this.hasOperation = true;
	}

	public void setConditional(Boolean conditional) {
		this.conditional = conditional;
		this.hasOperation = true;
	}

	public void setOperationalVarible(String name, int value) {
		this.operationVariableName = name;
		this.operationVariableValue = value;
		this.setOperation = true;
		this.hasOperation = true;
	}

	public void setOperationVariableName(String operationVariableName) {
		this.operationVariableName = operationVariableName;
	}
	
	public void setCoditionalValue(String name, int value) {
		this.conditionVariableName = name;
		this.conditionComparedValue = value;
		this.conditional = true;
	}

	public void setEqual(boolean isEqual) {
		this.isEqual = isEqual;
	}

	public void setLess(boolean isLess) {
		this.isLess = isLess;
	}

	public void setGreater(boolean isGreater) {
		this.isGreater = isGreater;
	}

	public Integer getOperationVariableValue() {
		return operationVariableValue;
	}
	
	
	
	
}
