/**
 * generated by Xtext 2.25.0
 */
package dk.sdu.mmmi.mdsd.generator;

import com.google.common.collect.Iterators;
import dk.sdu.mmmi.mdsd.math.Binding;
import dk.sdu.mmmi.mdsd.math.Div;
import dk.sdu.mmmi.mdsd.math.Expression;
import dk.sdu.mmmi.mdsd.math.External;
import dk.sdu.mmmi.mdsd.math.ExternalCall;
import dk.sdu.mmmi.mdsd.math.LetBinding;
import dk.sdu.mmmi.mdsd.math.MathNumber;
import dk.sdu.mmmi.mdsd.math.Minus;
import dk.sdu.mmmi.mdsd.math.Mult;
import dk.sdu.mmmi.mdsd.math.Parenthesis;
import dk.sdu.mmmi.mdsd.math.Plus;
import dk.sdu.mmmi.mdsd.math.Program;
import dk.sdu.mmmi.mdsd.math.VarBinding;
import dk.sdu.mmmi.mdsd.math.VariableUse;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import javax.swing.JOptionPane;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.xtend2.lib.StringConcatenation;
import org.eclipse.xtext.generator.AbstractGenerator;
import org.eclipse.xtext.generator.IFileSystemAccess2;
import org.eclipse.xtext.generator.IGeneratorContext;

/**
 * Generates code from your model files on save.
 * 
 * See https://www.eclipse.org/Xtext/documentation/303_runtime_concepts.html#code-generation
 */
@SuppressWarnings("all")
public class MathGenerator extends AbstractGenerator {
  private static Map<String, String> variables;
  
  private static int letterIndex = 0;
  
  private static String alphabet = "abcdefghijklmnopqrstuvwxyz";
  
  private static Map<String, String> letVariables;
  
  private static List<String> varLetters;
  
  @Override
  public void doGenerate(final Resource resource, final IFileSystemAccess2 fsa, final IGeneratorContext context) {
    final Program program = Iterators.<Program>filter(resource.getAllContents(), Program.class).next();
    String programName = program.getName();
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("math_expression/");
    _builder.append(programName);
    _builder.append(".java");
    fsa.generateFile(_builder.toString(), MathGenerator.compile(program));
  }
  
  public static String compile(final Program pro) {
    HashMap<String, String> _hashMap = new HashMap<String, String>();
    MathGenerator.variables = _hashMap;
    HashMap<String, String> _hashMap_1 = new HashMap<String, String>();
    MathGenerator.letVariables = _hashMap_1;
    ArrayList<String> _arrayList = new ArrayList<String>();
    MathGenerator.varLetters = _arrayList;
    EList<VarBinding> _variables = pro.getMath().getVariables();
    for (final VarBinding binding : _variables) {
      {
        MathGenerator.varLetters.add(binding.getName());
        MathGenerator.variables.put(binding.getName(), MathGenerator.compileExp(binding.getExpression()));
      }
    }
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("package math_expression;");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("public class ");
    String _name = pro.getName();
    _builder.append(_name, "\t");
    _builder.append(" {");
    _builder.newLineIfNotEmpty();
    _builder.append("\t\t");
    _builder.newLine();
    {
      EList<VarBinding> _variables_1 = pro.getMath().getVariables();
      for(final VarBinding binding_1 : _variables_1) {
        _builder.append("\t\t");
        _builder.append("public int ");
        String _name_1 = binding_1.getName();
        _builder.append(_name_1, "\t\t");
        _builder.append(";");
        _builder.newLineIfNotEmpty();
      }
    }
    _builder.newLine();
    {
      int _size = pro.getExternal().size();
      boolean _greaterThan = (_size > 0);
      if (_greaterThan) {
        _builder.append("\t\t");
        _builder.append("public External external;");
        _builder.newLine();
        _builder.append("\t\t");
        _builder.newLine();
        _builder.append("\t\t");
        _builder.append("public ");
        String _name_2 = pro.getName();
        _builder.append(_name_2, "\t\t");
        _builder.append("(External external) {");
        _builder.newLineIfNotEmpty();
        _builder.append("\t\t");
        _builder.append("\t");
        _builder.append("this.external = external;");
        _builder.newLine();
        _builder.append("\t\t");
        _builder.append("}");
        _builder.newLine();
        _builder.append("\t\t");
        _builder.newLine();
      }
    }
    _builder.append("\t\t");
    _builder.append("public void compute(){");
    _builder.newLine();
    {
      EList<VarBinding> _variables_2 = pro.getMath().getVariables();
      for(final VarBinding binding_2 : _variables_2) {
        _builder.append("\t\t\t");
        String _get = MathGenerator.letVariables.get(binding_2.getName());
        _builder.append(_get, "\t\t\t");
        _builder.newLineIfNotEmpty();
        _builder.append("\t\t\t");
        String _name_3 = binding_2.getName();
        _builder.append(_name_3, "\t\t\t");
        _builder.append(" = ");
        String _get_1 = MathGenerator.variables.get(binding_2.getName());
        _builder.append(_get_1, "\t\t\t");
        _builder.append(";");
        _builder.newLineIfNotEmpty();
      }
    }
    _builder.append("\t\t");
    _builder.append("}");
    _builder.newLine();
    _builder.newLine();
    {
      int _size_1 = pro.getExternal().size();
      boolean _greaterThan_1 = (_size_1 > 0);
      if (_greaterThan_1) {
        _builder.append("\t\t");
        _builder.append("public interface External {");
        _builder.newLine();
        {
          EList<External> _external = pro.getExternal();
          for(final External ex : _external) {
            _builder.append("\t\t");
            _builder.append("\t");
            _builder.append("public int ");
            String _name_4 = ex.getName();
            _builder.append(_name_4, "\t\t\t");
            _builder.append("(");
            String _InterfaceParameters = MathGenerator.InterfaceParameters(ex);
            _builder.append(_InterfaceParameters, "\t\t\t");
            _builder.append(");");
            _builder.newLineIfNotEmpty();
          }
        }
        _builder.append("\t\t");
        _builder.append("}");
        _builder.newLine();
      }
    }
    _builder.append("\t");
    _builder.append("}");
    return _builder.toString();
  }
  
  public static String compileExp(final Expression exp) {
    String _switchResult = null;
    boolean _matched = false;
    if (exp instanceof Plus) {
      _matched=true;
      StringConcatenation _builder = new StringConcatenation();
      String _compileExp = MathGenerator.compileExp(((Plus)exp).getLeft());
      _builder.append(_compileExp);
      _builder.append(" + ");
      String _compileExp_1 = MathGenerator.compileExp(((Plus)exp).getRight());
      _builder.append(_compileExp_1);
      _switchResult = _builder.toString();
    }
    if (!_matched) {
      if (exp instanceof Minus) {
        _matched=true;
        StringConcatenation _builder = new StringConcatenation();
        String _compileExp = MathGenerator.compileExp(((Minus)exp).getLeft());
        _builder.append(_compileExp);
        _builder.append(" - ");
        String _compileExp_1 = MathGenerator.compileExp(((Minus)exp).getRight());
        _builder.append(_compileExp_1);
        _switchResult = _builder.toString();
      }
    }
    if (!_matched) {
      if (exp instanceof Mult) {
        _matched=true;
        StringConcatenation _builder = new StringConcatenation();
        String _compileExp = MathGenerator.compileExp(((Mult)exp).getLeft());
        _builder.append(_compileExp);
        _builder.append(" * ");
        String _compileExp_1 = MathGenerator.compileExp(((Mult)exp).getRight());
        _builder.append(_compileExp_1);
        _switchResult = _builder.toString();
      }
    }
    if (!_matched) {
      if (exp instanceof Div) {
        _matched=true;
        StringConcatenation _builder = new StringConcatenation();
        String _compileExp = MathGenerator.compileExp(((Div)exp).getLeft());
        _builder.append(_compileExp);
        _builder.append(" / ");
        String _compileExp_1 = MathGenerator.compileExp(((Div)exp).getRight());
        _builder.append(_compileExp_1);
        _switchResult = _builder.toString();
      }
    }
    if (!_matched) {
      if (exp instanceof MathNumber) {
        _matched=true;
        StringConcatenation _builder = new StringConcatenation();
        String _string = Integer.valueOf(((MathNumber)exp).getValue()).toString();
        _builder.append(_string);
        _switchResult = _builder.toString();
      }
    }
    if (!_matched) {
      if (exp instanceof Parenthesis) {
        _matched=true;
        StringConcatenation _builder = new StringConcatenation();
        _builder.append("(");
        String _compileExp = MathGenerator.compileExp(((Parenthesis)exp).getExp());
        _builder.append(_compileExp);
        _builder.append(")");
        _switchResult = _builder.toString();
      }
    }
    if (!_matched) {
      if (exp instanceof VariableUse) {
        _matched=true;
        StringConcatenation _builder = new StringConcatenation();
        String _name = ((VariableUse)exp).getRef().getName();
        _builder.append(_name);
        _switchResult = _builder.toString();
      }
    }
    if (!_matched) {
      if (exp instanceof ExternalCall) {
        _matched=true;
        StringConcatenation _builder = new StringConcatenation();
        _builder.append("this.external.");
        String _name = ((ExternalCall)exp).getExternal().getName();
        _builder.append(_name);
        _builder.append("(");
        String _join = String.join(", ", MathGenerator.complieExpList(((ExternalCall)exp).getParms()));
        _builder.append(_join);
        _builder.append(")");
        _switchResult = _builder.toString();
      }
    }
    if (!_matched) {
      if (exp instanceof LetBinding) {
        _matched=true;
        StringConcatenation _builder = new StringConcatenation();
        String _compileLet = MathGenerator.compileLet(((LetBinding)exp));
        _builder.append(_compileLet);
        _switchResult = _builder.toString();
      }
    }
    if (!_matched) {
      StringConcatenation _builder = new StringConcatenation();
      _builder.append("0");
      _switchResult = _builder.toString();
    }
    return _switchResult;
  }
  
  public static String compileLet(final LetBinding let) {
    String bindingName = MathGenerator.findBindingName(let);
    String letName = let.getName();
    String _compileExp = MathGenerator.compileExp(let.getBinding());
    String _plus = ((("int " + letName) + " = ") + _compileExp);
    String newVariable = (_plus + "; ");
    String body = MathGenerator.compileExp(let.getBody()).toString();
    boolean _containsKey = MathGenerator.letVariables.containsKey(bindingName);
    if (_containsKey) {
      String variable = MathGenerator.letVariables.get(bindingName);
      boolean _contains = MathGenerator.varLetters.contains(let.getName().toString());
      if (_contains) {
        variable = variable.replace("int ", "");
      }
      MathGenerator.letVariables.put(bindingName, (((newVariable + " ") + variable) + " "));
    }
    boolean _containsKey_1 = MathGenerator.letVariables.containsKey(bindingName);
    boolean _not = (!_containsKey_1);
    if (_not) {
      boolean _containsKey_2 = MathGenerator.variables.containsKey(letName);
      if (_containsKey_2) {
        letName = MathGenerator.findNewName();
        String _compileExp_1 = MathGenerator.compileExp(let.getBinding());
        String _plus_1 = ((("int " + letName) + " = ") + _compileExp_1);
        String _plus_2 = (_plus_1 + "; ");
        newVariable = _plus_2;
        body = body.replace(let.getName(), letName);
      } else {
        boolean _contains_1 = MathGenerator.varLetters.contains(letName);
        if (_contains_1) {
          newVariable = newVariable.replace("int ", "");
        }
      }
      MathGenerator.letVariables.put(bindingName, newVariable);
      MathGenerator.varLetters.add(letName);
    }
    return body;
  }
  
  public static String findNewName() {
    char[] alpha = MathGenerator.alphabet.toCharArray();
    String let = "a";
    for (final char letter : alpha) {
      {
        boolean _containsKey = MathGenerator.variables.containsKey(Character.valueOf(letter).toString());
        boolean _not = (!_containsKey);
        if (_not) {
          return let;
        }
        let = Character.valueOf(letter).toString();
      }
    }
    return null;
  }
  
  public static String findBindingName(final Binding binding) {
    String name = binding.getName();
    EObject CurrentContainer = binding.eContainer();
    while ((CurrentContainer != null)) {
      {
        if ((CurrentContainer instanceof VarBinding)) {
          name = ((VarBinding)CurrentContainer).getName();
        }
        CurrentContainer = CurrentContainer.eContainer();
      }
    }
    return name;
  }
  
  public static List<String> complieExpList(final List<Expression> expList) {
    ArrayList<String> values = new ArrayList<String>();
    for (final Expression exp : expList) {
      values.add(MathGenerator.compileExp(exp));
    }
    return values;
  }
  
  public static String InterfaceParameters(final External external) {
    String parms = "";
    int _size = external.getType().size();
    boolean _greaterThan = (_size > 0);
    if (_greaterThan) {
      EList<String> _type = external.getType();
      for (final String type : _type) {
        String _parms = parms;
        String _string = type.toString();
        String _plus = (_string + " ");
        int _plusPlus = MathGenerator.letterIndex++;
        String _string_1 = Character.valueOf(MathGenerator.alphabet.charAt(_plusPlus)).toString();
        String _plus_1 = (_plus + _string_1);
        String _plus_2 = (_plus_1 + ", ");
        parms = (_parms + _plus_2);
      }
      int _length = parms.length();
      int _minus = (_length - 2);
      parms = parms.substring(0, _minus);
      MathGenerator.letterIndex = 0;
    }
    return parms;
  }
  
  public void displayPanel(final Map<String, Integer> result) {
    String resultString = "";
    Set<Map.Entry<String, Integer>> _entrySet = result.entrySet();
    for (final Map.Entry<String, Integer> entry : _entrySet) {
      String _resultString = resultString;
      String _key = entry.getKey();
      String _plus = ("var " + _key);
      String _plus_1 = (_plus + " = ");
      Integer _value = entry.getValue();
      String _plus_2 = (_plus_1 + _value);
      String _plus_3 = (_plus_2 + "\n");
      resultString = (_resultString + _plus_3);
    }
    JOptionPane.showMessageDialog(null, resultString, "Math Language", JOptionPane.INFORMATION_MESSAGE);
  }
}
