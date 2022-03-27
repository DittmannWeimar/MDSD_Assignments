/*
 * generated by Xtext 2.25.0
 */
package dk.sdu.mmmi.mdsd.generator

import dk.sdu.mmmi.mdsd.math.Div
import dk.sdu.mmmi.mdsd.math.Exp
import dk.sdu.mmmi.mdsd.math.MathExp
import dk.sdu.mmmi.mdsd.math.Minus
import dk.sdu.mmmi.mdsd.math.Mult
import dk.sdu.mmmi.mdsd.math.Plus
import dk.sdu.mmmi.mdsd.math.Primary
import java.util.HashMap
import java.util.Map
import javax.swing.JOptionPane
import org.eclipse.emf.ecore.resource.Resource
import org.eclipse.xtext.generator.AbstractGenerator
import org.eclipse.xtext.generator.IFileSystemAccess2
import org.eclipse.xtext.generator.IGeneratorContext

/**
 * Generates code from your model files on save.
 * 
 * See https://www.eclipse.org/Xtext/documentation/303_runtime_concepts.html#code-generation
 */
class MathGenerator extends AbstractGenerator {

	static Map<String, Integer> variables = new HashMap();
	
	override void doGenerate(Resource resource, IFileSystemAccess2 fsa, IGeneratorContext context) {
		val math = resource.allContents.filter(MathExp).next
		val result = math.compute
		
		// You can replace with hovering, see Bettini Chapter 8
		result.displayPanel
	}
	
	//
	// Compute function: computes value of expression
	// Note: written according to illegal left-recursive grammar, requires fix
	//
	
	def static compute(MathExp math) { 
		math.exp.computeExp
		return variables
	}
	
	def static int computeExp(Exp exp) {
		val left = exp.left.computePrim
		switch exp.operator {
			Plus: left+exp.right.computeExp
			Minus: left-exp.right.computeExp
			Mult: left*exp.right.computeExp
			Div: left/exp.right.computeExp
			default: left
		}
	}
	
	def static int computePrim(Primary factor) { 
		87
	}

	def void displayPanel(Map<String, Integer> result) {
		var resultString = ""
		for (entry : result.entrySet()) {
         	resultString += "var " + entry.getKey() + " = " + entry.getValue() + "\n"
        }
		
		JOptionPane.showMessageDialog(null, resultString ,"Math Language", JOptionPane.INFORMATION_MESSAGE)
	}

}
