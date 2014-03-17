/**
 * 
 */
package io.groovy.example.tags

/**
 * @author dezider.mesko
 *
 */
public class Sequence extends Tag {
	public name
	public children = [:]

	public Sequence(Map attributes) {
		super(attributes)
	}
	public addChild(Object child){
		children[child.name] = child
	}
	def propertyMissing(String name){
		children[name]
	}
}
