package io.groovy.example


def mb = new MessageBuilder()
def mt101 = mb.message{
	tag21()
	tag28(option:"D")
	tag30()
	sequence(mandatory:true, repetetive: true){
		tag21()
		tag32(option:"B")
		tag59(option:["A", ""])
		tag71(option:"A")
	}
}

println mt101.children.tag21.name
println mt101.tag28.option
mt101.tag28.option = "A"
println mt101.tag28.option
println mt101.sequence.mandatory
