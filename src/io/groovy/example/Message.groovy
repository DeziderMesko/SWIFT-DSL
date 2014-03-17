/**
 * 
 */
package io.groovy.example

/**
 * @author dezider.mesko
 *
 */
class Message {
	public Object parent
	public Map children = [:]
	public String name
	public setParent(Object parent){
		this.parent = parent
	}
	public addChild(Object child){
		children[child.name] = child
	}
	def propertyMissing(String name){
		children[name]
	}
}
