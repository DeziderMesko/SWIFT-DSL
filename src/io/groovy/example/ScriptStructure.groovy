/**
 * java -cp groovy-all-2.2.1.jar;jssc.jar groovy.inspect.swingui.AstBrowser jenled.groovy
 */
package io.groovy.example

import org.codehaus.groovy.ast.builder.AstBuilder
import org.codehaus.groovy.ast.expr.DeclarationExpression
import org.codehaus.groovy.ast.stmt.BlockStatement
import org.codehaus.groovy.ast.stmt.ExpressionStatement
import org.codehaus.groovy.ast.stmt.IfStatement
import org.codehaus.groovy.ast.stmt.ReturnStatement
import org.codehaus.groovy.ast.stmt.Statement

//CompilePhase.CONVERSION
def list = new AstBuilder().buildFromCode{
	def a = 1
	if(a == 1){
		println "A is a $a"
	} else {
		(1..10).each { println it }
	}
}

def iterate

iterate = { Statement stm ->
	if(stm == null) {return}
	if(stm instanceof BlockStatement){
		stm.statements.each(iterate)
	} else if (stm instanceof IfStatement){
		println "IF"
		iterate(stm.getIfBlock())
		println "ELSE"
		iterate(stm.getElseBlock())
	} else if (stm instanceof ExpressionStatement){
		println "x"+stm.getText()
	} else if (stm instanceof ReturnStatement){
		println stm.text
	} else if (stm instanceof DeclarationExpression){
		//println stm.getVariableExpression().getInitialExpression()
	} else {
		println stm
	}
}

list.each(iterate)