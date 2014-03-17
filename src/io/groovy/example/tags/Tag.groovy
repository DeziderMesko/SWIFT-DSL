/**
 * 
 */
package io.groovy.example.tags

/**
 * @author dezider.mesko
 *
 */
class Tag {
	public Object parent
	public Map children = [:]
	public String name
	def option
	def attributes
	public Tag(Map attributes){
		if(attributes.containsKey("option")){
			this.option = attributes["option"]
		}
		this.attributes = attributes
	}

	public setParent(Object parent){
		this.parent = parent
	}
	public addChild(Object child){
		//children[child.name] = child
	}
}
