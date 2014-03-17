/**
 * 
 */
package io.groovy.example

/**
 * @author dezider.mesko
 *
 */

import io.groovy.example.tags.Sequence
import io.groovy.example.tags.Tag21
import io.groovy.example.tags.Tag28
import io.groovy.example.tags.Tag30
import io.groovy.example.tags.Tag32
import io.groovy.example.tags.Tag59
import io.groovy.example.tags.Tag71

class MessageBuilder extends BuilderSupport {

	@Override
	protected void setParent(Object parent, Object child) {
		child.setParent(parent)
		//		println "${parent} - ${child}"
		parent.addChild(child)
	}

	@Override
	protected Object createNode(Object name) {
		instantiateTag(name, [:])
	}

	@Override
	protected Object createNode(Object name, Object value) {
		return null
	}

	@Override
	protected Object createNode(Object name, Map attributes) {
		instantiateTag(name, attributes)
	}

	@Override
	protected Object createNode(Object name, Map attributes, Object value) {
		return null
	}

	def instantiateTag(String name, Map attributes){
		def tag = null
		switch(name){
			case "tag21":
				tag = new Tag21(attributes)
				break
			case "tag28":
				tag = new Tag28(attributes)
				break
			case "sequence":
				tag = new Sequence(attributes)
				break
			case "tag30":
				tag = new Tag30(attributes)
				break
			case "tag32":
				tag = new Tag32(attributes)
				break
			case "tag59":
				tag = new Tag59(attributes)
				break
			case "tag71":
				tag = new Tag71(attributes)
				break
			case "message":
				tag = new Message()
				break
			default:
				println "No class for ${name}"
				return null
		}
		tag.name = name
		return tag
	}
}
