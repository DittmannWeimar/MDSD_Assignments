/*
 * generated by Xtext 2.25.0
 */
package dk.sdu.mmmi.mdsd.generator

import dk.sdu.mmmi.mdsd.math.Div
import dk.sdu.mmmi.mdsd.math.LetBinding
import dk.sdu.mmmi.mdsd.math.MathExp
import dk.sdu.mmmi.mdsd.math.MathNumber
import dk.sdu.mmmi.mdsd.math.Minus
import dk.sdu.mmmi.mdsd.math.Mult
import dk.sdu.mmmi.mdsd.math.Plus
import dk.sdu.mmmi.mdsd.math.VarBinding
import dk.sdu.mmmi.mdsd.math.VariableUse
import dk.sdu.mmmi.mdsd.math.Program
import dk.sdu.mmmi.mdsd.math.Expression
import dk.sdu.mmmi.mdsd.math.Parenthesis
import dk.sdu.mmmi.mdsd.math.*
import java.util.*
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
	
	//static Map<String, Integer> variables;
	static int letterIndex = 0;
	static String alphabet = "abcdefghijklmnopqrstuvwxyz"
	

	override void doGenerate(Resource resource, IFileSystemAccess2 fsa, IGeneratorContext context) {
		val program = resource.allContents.filter(Program).next
		var programName = program.name
		//«»
		fsa.generateFile('''math_expression/«programName».java''', program.compile)
	}
		
	def void displayPanel(Map<String, Integer> result) {
		var resultString = ""
		for (entry : result.entrySet()) {
         	resultString += "var " + entry.getKey() + " = " + entry.getValue() + "\n"
        }
		
		JOptionPane.showMessageDialog(null, resultString ,"Math Language", JOptionPane.INFORMATION_MESSAGE)
	}
	
	def static compile(Program pro){ 
	return 
	'''
	package math_expression;
		public class «pro.name» {
			
			«FOR binding : pro.math.variables»
			public int «binding.name»;
			«ENDFOR»

			«IF pro.external.size() > 0»
			public External external;
			
			public «pro.name»(External external) {
				this.external = external;
			}
			
			«ENDIF»
			public void compute(){
				«FOR binding : pro.math.variables»
					«binding.name» = «binding.expression.compileExp»;
				«ENDFOR»
			}
	
			«IF pro.external.size() > 0»
			public interface External {
				«FOR ex : pro.external» 	
					public int «ex.name»(«ex.InterfaceParameters»);
				«ENDFOR»
			}
			«ENDIF»
		}'''
	}
 
	def static String compileExp(Expression exp){
		switch exp {
			Plus: '''«exp.left.compileExp» + «exp.right.compileExp»'''
			Minus: '''«exp.left.compileExp» - «exp.right.compileExp»'''
			Mult:  '''«exp.left.compileExp» * «exp.right.compileExp»'''
			Div: '''«exp.left.compileExp» / «exp.right.compileExp»'''
			MathNumber: '''«exp.value.toString()»'''
			Parenthesis: '''(«exp.exp.compileExp»)'''
			VariableUse: '''«exp.ref.name»'''
			ExternalCall: '''this.external.«exp.external.name»(«String.join(", ", exp.parms.complieExpList)»)'''
			LetBinding: '''«exp.compileLetBinding»'''
			default: '''0'''
		}
		
	}
	
	def static String compileLetBinding(LetBinding exp){
		
	}
	
	def static List<String> complieExpList(List<Expression> expList){
		var values = new ArrayList<String>();
		for (exp : expList){
			values.add(exp.compileExp)
		}
		return values
	}
	
	def static InterfaceParameters(External external){
		var parms = ""
		if(external.type.size() > 0){
			for(type : external.type){
				parms += type.toString() + " " + alphabet.charAt(letterIndex++).toString() + ", ";
			}
			parms = parms.substring(0, parms.length() - 2)
			letterIndex = 0
		}
		return parms;
	}

}